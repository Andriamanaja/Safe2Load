package com.example.safe2load.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.SupportActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.safe2load.DetailActivity;
import com.example.safe2load.R;

import java.util.List;

import database.helper.dao.activity_dao;
import model.object.activity_model;
import model.object.stat_operation;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context ;
    List<stat_operation> list_stat_operation ;


    public RecyclerViewAdapter(Context context, List<stat_operation> list_stat_operation) {
        this.context = context;
        this.list_stat_operation = list_stat_operation;



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        view = LayoutInflater.from(context).inflate(R.layout.item_stat, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Log.d("after", "after") ;
        viewHolder._tv_id_stat_op.setText(String.valueOf(list_stat_operation.get(i).get_id_stat_op()));
        viewHolder._tv_name_stat_op.setText(list_stat_operation.get(i).get_name_stat_op());
        viewHolder._tv_duree_stat_op.setText(list_stat_operation.get(i).get_duree_stat_op());
        viewHolder._tv_date_stat_op.setText(list_stat_operation.get(i).get_date_stat_op());
        viewHolder._tv_name_usr_stat_op.setText(list_stat_operation.get(i).get_name_usr_stat_op());
        viewHolder._tv_heure_stat_op.setText(list_stat_operation.get(i).get_heure_stat_op());
        if(list_stat_operation.get(i).get_heure_stat_op() == "Conforme") {
            viewHolder._tv_heure_stat_op.setTextColor(R.color.conforme);
        } else {
            viewHolder._tv_heure_stat_op.setTextColor(R.color.non_confrme);
        }
        if(i%2 == 0) {
            viewHolder.item_stat.setBackgroundColor(Color.parseColor("#f0f0f0"));
        }
        viewHolder._img_look_stat_op.setOnClickListener(v -> {
            activity_model activity_model = new activity_model("inspection", list_stat_operation.get(i).get_id_stat_op()) ;
            activity_dao activity_dao = new activity_dao(v.getContext()) ;
            if(activity_dao.verify_if_exists("inspection").equals(true)) {
                activity_dao.remove_activity("inspection");
            }
            activity_dao.create_activity(activity_model);
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            v.getContext().startActivity(intent);
        }) ;
    }


    @Override
    public int getItemCount() {
        return list_stat_operation.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        private TextView _tv_id_stat_op ;
        private TextView _tv_name_stat_op ;
        private TextView _tv_duree_stat_op ;
        private TextView _tv_date_stat_op ;
        private TextView _tv_name_usr_stat_op ;
        private TextView _tv_heure_stat_op ;
        private ImageView _img_look_stat_op;
        LinearLayout item_stat ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this._tv_id_stat_op = itemView.findViewById((R.id.id_stat_op)) ;
            this._tv_name_stat_op = itemView.findViewById(R.id.name_stat_op) ;
            this._tv_duree_stat_op = itemView.findViewById((R.id.duree_stat_op)) ;
            this._tv_date_stat_op = itemView.findViewById(R.id.date_stat_op) ;
            this._tv_name_usr_stat_op = itemView.findViewById((R.id.name_usr_stat_op)) ;
            this._tv_heure_stat_op = itemView.findViewById((R.id.heure_stat_op)) ;
            this._img_look_stat_op = itemView.findViewById((R.id.img_look_stat_op));
            this.item_stat = itemView.findViewById(R.id.item_stat) ;
        }
    }

}
