package com.example.safe2load.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safe2load.R;

import java.util.List;

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
        Log.d("after", "after") ;
        View view ;
        view = LayoutInflater.from(context).inflate(R.layout.item_stat, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("after", "after") ;
        viewHolder._tv_id_stat_op.setText(String.valueOf(list_stat_operation.get(i).get_id_stat_op()));
        viewHolder._tv_name_stat_op.setText(list_stat_operation.get(i).get_name_stat_op());
        viewHolder._tv_duree_stat_op.setText(list_stat_operation.get(i).get_duree_stat_op());
        viewHolder._tv_date_stat_op.setText(list_stat_operation.get(i).get_date_stat_op());
        viewHolder._tv_name_usr_stat_op.setText(list_stat_operation.get(i).get_name_usr_stat_op());
        viewHolder._tv_heure_stat_op.setText(list_stat_operation.get(i).get_heure_stat_op());
    }

    @Override
    public int getItemCount() {
        return list_stat_operation.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView _tv_id_stat_op ;
        private TextView _tv_name_stat_op ;
        private TextView _tv_duree_stat_op ;
        private TextView _tv_date_stat_op ;
        private TextView _tv_name_usr_stat_op ;
        private TextView _tv_heure_stat_op ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this._tv_id_stat_op = itemView.findViewById((R.id.id_stat_op)) ;
            this._tv_name_stat_op = itemView.findViewById(R.id.name_stat_op) ;
            this._tv_duree_stat_op = itemView.findViewById((R.id.duree_stat_op)) ;
            this._tv_date_stat_op = itemView.findViewById(R.id.date_stat_op) ;
            this._tv_name_usr_stat_op = itemView.findViewById((R.id.name_usr_stat_op)) ;
            this._tv_heure_stat_op = itemView.findViewById((R.id.heure_stat_op)) ;
        }
    }
}
