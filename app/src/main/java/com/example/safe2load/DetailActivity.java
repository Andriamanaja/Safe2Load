package com.example.safe2load;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.safe2load.RecyclerView.CategorieRecyclerView;

import java.util.List;

import database.helper.dao.categorie_dao;
import database.helper.dao.inspection_dao;
import model.object.categorie_model;
import model.object.detail_info_model;

public class DetailActivity extends AppCompatActivity {

    RecyclerView cat_rec_view ;
    TextView detail_typeoperation ;
    TextView detail_imm_trac ;
    TextView detail_imm_cit ;
    TextView detail_heure_duree ;
    TextView detail_conforme ;
    TextView detail_conducteur_nom ;
    TextView detail_date ;
    TextView detail_heure_debut ;
    TextView detail_heure_fin ;
    ImageView conforme_icon ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Détail opération") ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        fillDataToCategorie();
        loadViews();
    }

    private void loadViews() {
        detail_typeoperation = findViewById(R.id.detail_typeoperation) ;
        detail_imm_trac = findViewById(R.id.detail_imm_trac) ;
        detail_imm_cit = findViewById(R.id.detail_imm_cit) ;
        detail_heure_duree = findViewById(R.id.detail_heure_duree) ;
        detail_conforme = findViewById(R.id.detail_conforme) ;
        detail_conducteur_nom = findViewById(R.id.detail_conducteur_nom) ;
        detail_date = findViewById(R.id.detail_date) ;
        detail_heure_debut = findViewById(R.id.detail_heure_debut) ;
        detail_heure_fin = findViewById(R.id.detail_heure_fin) ;
        detail_conforme = findViewById(R.id.detail_conforme) ;
        conforme_icon = findViewById(R.id.conforme_icon) ;
        inspection_dao inspection_dao = new inspection_dao(this) ;
        detail_info_model detail_info_model = inspection_dao.getDetailInfoByIdInspection() ;
        this.fillDataToView(detail_info_model) ;
    }

    private void fillDataToView(detail_info_model data) {
        detail_typeoperation.setText(data.getTypeoperation_nom());
        detail_imm_trac.setText(data.getVehicule_immatriculation());
        detail_imm_cit.setText(data.getCiterne_immatriculation());
        detail_heure_duree.setText(data.getDuree());
        detail_conforme.setText(data.getInspectionstatut_nom());
        detail_conforme.setTextColor(Color.parseColor("#14D72C"));
        conforme_icon.setImageResource(R.drawable.ic_check_circle);
        if(data.getInspectionstatut_nom().equals("NON-CONFORME")) {
            detail_conforme.setTextColor(Color.parseColor("#CD0505"));
            conforme_icon.setImageResource(R.drawable.ic_clear_circle);
        }

        detail_conducteur_nom.setText(data.getLast_name());
        detail_date.setText(data.getInspection_datevisite());
        detail_heure_debut.setText(data.getInspection_heuredebut());
        detail_heure_fin.setText(data.getInspection_heurefin());
    }

    public void fillDataToCategorie() {
        categorie_dao categorie_dao = new categorie_dao(this.getBaseContext()) ;
        List<categorie_model> list = categorie_dao.getAllCategorieByTypeOperationIdFromActivity() ;

        cat_rec_view = findViewById(R.id.cat_rec_view) ;
        CategorieRecyclerView categorieRecyclerView = new CategorieRecyclerView(this, list) ;
        categorieRecyclerView.notifyDataSetChanged();
        cat_rec_view.setLayoutManager(new LinearLayoutManager(this));
        cat_rec_view.setAdapter(categorieRecyclerView);
    }
}
