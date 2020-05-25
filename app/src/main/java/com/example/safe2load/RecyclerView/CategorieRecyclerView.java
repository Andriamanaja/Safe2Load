package com.example.safe2load.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.safe2load.R;

import java.util.ArrayList;
import java.util.List;

import database.helper.dao.categorie_dao;
import database.helper.dao.pointcontrole_dao;
import model.object.categorie_model;
import model.object.controle_model;

public class CategorieRecyclerView extends RecyclerView.Adapter<CategorieRecyclerView.ViewHolder> {

    View view ;
    Context context ;
    ViewHolder viewHolder ;
    List<categorie_model> list  ;
    RecyclerView det_quest ;

    public CategorieRecyclerView(Context context, List<categorie_model> cat) {
        this.context = context;
        this.list = cat ;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item_categorie, viewGroup, false) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        det_quest = view.findViewById(R.id.det_quest) ;
        List<controle_model> list_ct = new ArrayList<>() ;
        pointcontrole_dao pointcontrole_dao = new pointcontrole_dao(view.getContext()) ;
        list_ct = pointcontrole_dao.getDataForDetail(list.get(i).get_categorie_id()) ;
        DetailInspectionRecyclerAdapter detailInspectionRecyclerAdapter = new DetailInspectionRecyclerAdapter(view.getContext() , list_ct) ;
        detailInspectionRecyclerAdapter.notifyDataSetChanged();
        det_quest.setLayoutManager(new LinearLayoutManager(view.getContext()));
        det_quest.setAdapter(detailInspectionRecyclerAdapter);
        viewHolder.detail_categorie_nom.setText(list.get(i).getCategorie_nom());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView detail_categorie_nom ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.detail_categorie_nom = itemView.findViewById(R.id.detail_categorie_nom) ;
        }
    }
}
