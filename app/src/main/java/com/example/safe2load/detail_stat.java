package com.example.safe2load;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.safe2load.RecyclerView.Detail_stat_ViewAdapter;

import java.util.ArrayList;
import java.util.List;

import model.object.Detail_stat_model;

public class detail_stat extends AppCompatActivity {


    private RecyclerView _recyclerView ;
    private List<Detail_stat_model> _list_detail_stat ;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
       protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_stat);

        _recyclerView = findViewById(R.id.recycler_Detail_stat) ;


        _list_detail_stat = new ArrayList<>() ;
        _list_detail_stat.add(new Detail_stat_model(6, "Présence de ceintures de sécurité à 03 points qui fonctionne bien pour le conducteur et son aide", "Présence de ceintures de sécurité à 03 points qui fonctionne bien pour le conducteur et abscence de ceintures de sécurité à 03 points quiu fonctionne bien pour son aide  " )) ;
        _list_detail_stat.add(new Detail_stat_model(9, "Plots de mise à la terre bien fixés et propre (non rouillées et non peints)", "Plots de mise à la terre bien fixé mais pas propre et non rouillés" )) ;
        _list_detail_stat.add(new Detail_stat_model(11, "Pneumatiques en bon état y compris les roues de secours (profondeur rainure > 2 mm sur toute la circonférence) et en nombre suffisant(01RDS pour le tracteur et 01RDS pour la citerne)", "Pneumatiques en bon état y compris les roues de secours (profondeur rainure > 2 mm ur toute la circonférence)mais en nombre insuffisant (01RDS pour le tracteur et 0 pour la citerne) " )) ;



        Detail_stat_ViewAdapter detail_stat_viewAdapter = new Detail_stat_ViewAdapter(this.getBaseContext(), _list_detail_stat) ;
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getParent()));
        _recyclerView.setAdapter(detail_stat_viewAdapter);
       }






}
