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

import model.object.Detail_stat_model;

public class Detail_stat_ViewAdapter extends RecyclerView.Adapter<Detail_stat_ViewAdapter.ViewHolder> {


    Context context ;
    private List<Detail_stat_model> _list_detail_stat  ;

    public Detail_stat_ViewAdapter(Context context, List<Detail_stat_model> _list_detail_stat ) {
        this.context = context;
        this._list_detail_stat = _list_detail_stat;
    }


    @NonNull
    @Override
    public Detail_stat_ViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        view = LayoutInflater.from(context).inflate(R.layout.item_detail_stat, viewGroup, false) ;
        Detail_stat_ViewAdapter.ViewHolder viewHolder = new Detail_stat_ViewAdapter.ViewHolder(view) ;
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.id_detail_stat.setText(String.valueOf(_list_detail_stat.get(i).getId_detail_stat()));
        viewHolder._desc_detail_stat.setText(_list_detail_stat.get(i).get_desc_detail_stat());
        viewHolder._commentaire_detail_stat.setText(_list_detail_stat.get(i).get_commentaire_detail_stat());

    }

//    public void onBindViewHolder(@NonNull ControleConducteurViewPageAdapter.ViewHolder viewHolder, int i) {
//        viewHolder.id_detail_stat.setText(String.valueOf(_list_detail_stat.get(i).get_id()));
//        viewHolder._desc_detail_stat.setText(_list_detail_stat.get(i).get_descrption());
//        viewHolder._commentaire_detail_stat.setChecked(_list_detail_stat.get(i).is_is_true());
//    }

//

    @Override
    public int getItemCount() {
        return this._list_detail_stat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView id_detail_stat ;
        private TextView _desc_detail_stat ;
        private TextView _commentaire_detail_stat ;
        private ImageView imageCar ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.id_detail_stat = itemView.findViewById(R.id.id_detail_stat) ;
            this._desc_detail_stat = itemView.findViewById(R.id._desc_detail_stat) ;
            this._commentaire_detail_stat  = itemView.findViewById(R.id._commentaire_detail_stat) ;
            this.imageCar = itemView.findViewWithTag(R.id._image_detail_stat) ;
        }
    }


}



