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

public class ControleConducteurViewPageAdapter extends RecyclerView.Adapter<ControleConducteurViewPageAdapter.ViewHolder> {

    Context context ;
    private List<controle_model> list_controle_model ;

    public ControleConducteurViewPageAdapter(Context context, List<controle_model> list_controle_model) {
        this.context = context;
        this.list_controle_model = list_controle_model;
    }

    @NonNull
    @Override
    public ControleConducteurViewPageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        view = LayoutInflater.from(context).inflate(R.layout.item_controle_conducteur, viewGroup, false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ControleConducteurViewPageAdapter.ViewHolder viewHolder, int i) {
        viewHolder._id_controle_conducteur.setText(String.valueOf(list_controle_model.get(i).get_id()));
        viewHolder._desc_controle_conducteur.setText(list_controle_model.get(i).get_descrption());
        viewHolder._is_actif_controle_conducteur.setChecked(list_controle_model.get(i).is_is_true());
    }

    @Override
    public int getItemCount() {
        return this.list_controle_model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView _id_controle_conducteur ;
        private TextView _desc_controle_conducteur ;
        private Switch _is_actif_controle_conducteur ;
        private ImageView _btn_edit_controle_conducteur ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this._id_controle_conducteur = itemView.findViewById(R.id._id_controle_conducteur) ;
            this._desc_controle_conducteur = itemView.findViewById(R.id._desc_controle_conducteur) ;
            this._is_actif_controle_conducteur = itemView.findViewById(R.id._is_actif_controle_conducteur) ;
            this._btn_edit_controle_conducteur = itemView.findViewWithTag(R.id._btn_edit_controle_conducteur) ;
        }
    }

}
