package com.example.safe2load.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safe2load.R;

import java.util.List;

import model.object.controle_model;

public class Doc_Portail_ViewAdapter extends RecyclerView.Adapter<Doc_Portail_ViewAdapter.ViewHolder> implements ActivityCompat.OnRequestPermissionsResultCallback {

    Context context ;
    private List<controle_model> list_controle_model ;
    Uri uri ;
    Doc_Portail_ViewAdapter.ViewHolder vh ;
    View view ;

    public Doc_Portail_ViewAdapter(Context context, List<controle_model> list_controle_model) {
        this.context = context;
        this.list_controle_model = list_controle_model;
    }

    @NonNull
    @Override
    public Doc_Portail_ViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item_doc_portail, viewGroup, false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull final Doc_Portail_ViewAdapter.ViewHolder viewHolder, int i) {
        this.vh = viewHolder ;
        viewHolder._id_doc_potrail.setText(String.valueOf(list_controle_model.get(i).get_id()));
        viewHolder._desc_doc_portail.setText(list_controle_model.get(i).get_descrption());
        viewHolder._is_actif_doc_portail.setChecked(list_controle_model.get(i).is_is_true());
        viewHolder._btn_edit_doc_portail.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(v.GONE == viewHolder._commentaire_container.getVisibility()) {
                    TransitionManager.beginDelayedTransition(viewHolder.itm_cnt, new AutoTransition());
                    viewHolder._commentaire_container.setVisibility(v.VISIBLE);
                }
                else {
                    TransitionManager.beginDelayedTransition(viewHolder.itm_cnt, new AutoTransition());
                    viewHolder._commentaire_container.setVisibility(v.GONE);
                }
            }
        });
        viewHolder._image_doc_portail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if( context.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED||context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
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
                }
            }
        });
    }

    public void open_camera() {
        try {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE) ;
            camera.putExtra("position", this.get_current_position()) ;
            ((Activity)view.getContext()).startActivityForResult(camera, 1001);

        } catch (Exception e) {
            e.printStackTrace();
        }

       // ((Activity)context).startActivityForResult(camera, 1001);
    }

    @Override
    public int getItemCount() {
        return this.list_controle_model.size() ;
    }

    @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strings, @NonNull int[] ints) {
        switch (i) {
            case 1001 : {
                if(ints.length > 0&&ints[0]==PackageManager.PERMISSION_GRANTED) {
                    open_camera();
                }
                else{
                    Toast.makeText(context, "Permission réfusée", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public int get_current_position() {
        return this.vh.getAdapterPosition();
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