package com.example.safe2load.RecyclerView;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safe2load.R;

import java.util.List;

import database.helper.dao.activity_dao;
import database.helper.dao.pointcontrole_dao;
import model.object.activity_model;
import model.object.controle_model;
import model.object.pointcontrole_model;

public class InspectionRecyclerView extends RecyclerView.Adapter<InspectionRecyclerView.ViewHolder> implements ActivityCompat.OnRequestPermissionsResultCallback {

    Context context ;
    private List<controle_model> list_controle_model ;
    View view ;
    InspectionRecyclerView.ViewHolder vh ;
    String comment = "" ;

    public InspectionRecyclerView(Context context) {
        this.context = context;
    }

    public void setItems(List<controle_model> list_controle_model) {
        this.list_controle_model = list_controle_model;
    }

    @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strings, @NonNull int[] ints) {
        switch (i) {
            case 1001 : {
                if(ints.length > 0&&ints[0]== PackageManager.PERMISSION_GRANTED) {
                    open_camera();
                }
                else{
                    Toast.makeText(context, "Permission réfusée", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item_inspection, viewGroup, false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        Toast.makeText(view.getContext(), "tonga ato inspection recycler", Toast.LENGTH_LONG).show();

        this.vh = viewHolder ;
        viewHolder._id_doc_potrail.setText(String.valueOf(list_controle_model.get(i).get_id()));
        viewHolder._desc_doc_portail.setText(list_controle_model.get(i).get_descrption());
        viewHolder._is_actif_doc_portail.setChecked(list_controle_model.get(i).is_is_true());

        if(list_controle_model.get(i).get_image().equals("") == false) {
            
        }

        viewHolder._btn_edit_doc_portail.setOnClickListener(v -> {
            if(v.GONE == viewHolder._commentaire_container.getVisibility()) {
//                    TransitionManager.beginDelayedTransition(viewHolder.itm_cnt, new AutoTransition());
                viewHolder._commentaire_container.setVisibility(v.VISIBLE);
            }
            else {
//                  TransitionManager.beginDelayedTransition(viewHolder.itm_cnt, new AutoTransition());
                viewHolder._commentaire_container.setVisibility(v.GONE);
            }

        });

        viewHolder._image_doc_portail.setOnClickListener(v -> {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if( context.checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED||context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE} ;
                        ActivityCompat.requestPermissions(((Activity)context),permissions, 1000) ;
                    }
                    else{
                        open_camera();
                    }
                }
                else {
                    open_camera();
                }
                setActualActivity(i) ;
            }
        });

        viewHolder._is_actif_doc_portail.setOnCheckedChangeListener((buttonView, isChecked) -> {
            activity_dao activity_dao = new activity_dao(view.getContext()) ;
            activity_model activity_model = new activity_model("questionnaire", list_controle_model.get(i).get_id()) ;
            if(activity_dao.verify_if_exists("questionnaire").equals(true)) {
                activity_dao.remove_activity("questionnaire");
            }
            activity_dao.create_activity(activity_model);
            pointcontrole_dao pointcontrole_dao1 = new pointcontrole_dao(view.getContext()) ;
            if(isChecked == true) {
                pointcontrole_dao1.updateConforme(1);
            }
            else {
                pointcontrole_dao1.updateConforme(2);
            }
        });

        viewHolder._commentaire_doc_portail.setOnFocusChangeListener((v, hasFocus) -> {
            setActualActivity(i);
            this.comment = vh._commentaire_doc_portail.getText().toString();
            Log.d("110 => ", vh._commentaire_doc_portail.getText().toString()) ;
        });

        viewHolder._commentaire_doc_portail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateComments(s.toString(), i);
            }
        });

        viewHolder._commentaire_doc_portail.getText().toString() ;
    }

    public void setActualActivity(int index) {
        activity_dao activity_dao = new activity_dao(view.getContext()) ;
        activity_model activity_model = new activity_model("questionnaire", list_controle_model.get(index).get_id()) ;
        if(activity_dao.verify_if_exists("questionnaire").equals(true)) {
            activity_dao.remove_activity("questionnaire");
        }
        activity_dao.create_activity(activity_model);
    }

    public void updateComments(String comment, int index) {
        Log.d("152", String.valueOf(index)) ;

        pointcontrole_dao pointcontrole_dao = new pointcontrole_dao(view.getContext()) ;
        pointcontrole_dao.updateCommentaire(comment, list_controle_model.get(index).get_id());
    }

    public void open_camera() {
        try {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE) ;
            ((Activity)view.getContext()).startActivityForResult(camera, 1001);
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int get_current_position() {
        return this.vh.getAdapterPosition();
    }


    @Override
    public int getItemCount() {
        return this.list_controle_model.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView _id_doc_potrail ;
        private TextView _desc_doc_portail ;
        private Switch _is_actif_doc_portail ;
        private ImageView _btn_edit_doc_portail ;
        private LinearLayout _commentaire_container ;
        private LinearLayout itm_cnt ;
        private TextView _commentaire_doc_portail ;
        private ImageView _image_doc_portail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this._id_doc_potrail = itemView.findViewById(R.id._id_doc_potrail) ;
            this._desc_doc_portail = itemView.findViewById(R.id._desc_doc_portail) ;
            this._is_actif_doc_portail = itemView.findViewById(R.id._is_actif_doc_portail) ;
            this._btn_edit_doc_portail = itemView.findViewById(R.id._btn_edit_doc_portail) ;
            this._commentaire_container = itemView.findViewById(R.id._commentaire_container) ;
            this.itm_cnt = itemView.findViewById(R.id.itm_cnt) ;
            this._commentaire_doc_portail = itemView.findViewById(R.id._commentaire_doc_portail) ;
            this._image_doc_portail = itemView.findViewById(R.id._image_doc_portail) ;
        }
    }
}
