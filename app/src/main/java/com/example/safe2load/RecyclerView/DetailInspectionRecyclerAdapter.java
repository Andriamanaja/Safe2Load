package com.example.safe2load.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.safe2load.R;

import java.security.PrivateKey;
import java.util.List;
import java.util.zip.Inflater;

import model.object.controle_model;

public class DetailInspectionRecyclerAdapter extends RecyclerView.Adapter<DetailInspectionRecyclerAdapter.ViewHolder> {

    Context context ;
    List<controle_model> list ;
    View view ;

    public DetailInspectionRecyclerAdapter(Context context, List<controle_model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DetailInspectionRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item_questionnaire, viewGroup, false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailInspectionRecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.detail_comm_quest.setText(list.get(i).get_commentaire());
        viewHolder.detail_id_quest.setText(String.valueOf(list.get(i).get_id()));
        viewHolder.detail_nom_quest.setText(list.get(i).get_descrption());
        viewHolder.detail_conf_quest.setImageResource(R.drawable.ic_check);
        if(list.get(i).get_is_true() == false) {
            viewHolder.detail_conf_quest.setImageResource(R.drawable.ic_clear);
            viewHolder.dat_cont.setBackgroundColor(Color.parseColor("#e8e8e8"));
        }
        if(list.get(i).get_commentaire() == "") {
            viewHolder.detail_comm_quest.setText("-- aucun commentaire --");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout dat_cont ;
        TextView detail_id_quest ;
        TextView detail_nom_quest ;
        TextView detail_comm_quest ;
        ImageView detail_conf_quest ;
        Button detail_show_image ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            detail_id_quest = itemView.findViewById(R.id.detail_id_quest) ;
            detail_nom_quest = itemView.findViewById(R.id.detail_nom_quest) ;
            detail_comm_quest = itemView.findViewById(R.id.detail_comm_quest) ;
            detail_conf_quest = itemView.findViewById(R.id.detail_conf_quest) ;
            detail_show_image = itemView.findViewById(R.id.detail_show_image) ;
            dat_cont = itemView.findViewById(R.id.dat_cont) ;
        }
    }
}
