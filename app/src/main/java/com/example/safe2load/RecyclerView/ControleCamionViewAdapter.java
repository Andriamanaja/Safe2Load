package com.example.safe2load.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.safe2load.R;

import java.util.List;

import model.object.controle_model;

public class ControleCamionViewAdapter extends RecyclerView.Adapter<ControleCamionViewAdapter.ViewHolder> {

    List<controle_model> list_controle_model ;
    Context context ;

    public ControleCamionViewAdapter(List<controle_model> _list_controle, Context context) {
        this.list_controle_model = _list_controle;
        this.context = context;
    }

    @NonNull
    @Override
    public ControleCamionViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        view = LayoutInflater.from(context).inflate(R.layout.item_controle_camion, viewGroup, false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ControleCamionViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder._id_controle_camion.setText(String.valueOf(list_controle_model.get(i).get_id()));
        viewHolder._desc_controle_camion.setText(list_controle_model.get(i).get_descrption());
        viewHolder._is_actif_controle_camion.setChecked(list_controle_model.get(i).is_is_true());
    }

    @Override
    public int getItemCount() {
        return this.list_controle_model.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView _id_controle_camion ;
        private TextView _desc_controle_camion ;
        private Switch _is_actif_controle_camion ;
        private ImageView _btn_edit_doc_camion ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this._id_controle_camion = itemView.findViewById(R.id._id_controle_camion) ;
            this._desc_controle_camion = itemView.findViewById(R.id._desc_controle_camion) ;
            this._is_actif_controle_camion = itemView.findViewById(R.id._is_actif_controle_camion) ;
            this._btn_edit_doc_camion = itemView.findViewWithTag(R.id._btn_edit_doc_camion) ;
        }
    }
}
