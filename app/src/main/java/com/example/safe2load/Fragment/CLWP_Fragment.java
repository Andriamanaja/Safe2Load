package com.example.safe2load.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.safe2load.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import database.helper.dao.activity_dao;
import database.helper.dao.questionnaire_dao;
import model.object.activity_model;
import model.object.categorie_questionnaire_model;
import model.object.controle_model;
import model.object.spinner_content_model;

public class CLWP_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view ;
    Spinner spinner_transporteur_clwp ;
    Spinner spinner_conducteur_clwp ;
    Spinner spinner_tracteur_clwp ;
    Spinner spinner_citerne_clwp ;
    CategorieFragment categorieFragment ;

    private OnFragmentInteractionListener mListener;

    public CLWP_Fragment() {
        // Required empty public constructor
    }

    public static CLWP_Fragment newInstance(String param1, String param2) {
        CLWP_Fragment fragment = new CLWP_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_clwp_, container, false);
        this.loadViews();
        this.fillDataToAllSpinner();
        this.fillDataToCategorieFragment();
        return view ;
    }

    public void loadViews () {
        categorieFragment = (CategorieFragment)this.getChildFragmentManager().findFragmentById(R.id.fragmentParent) ;
        spinner_tracteur_clwp = view.findViewById(R.id.spinner_tracteur_clwp) ;
        spinner_conducteur_clwp = view.findViewById(R.id.spinner_conducteur_clwp) ;
        spinner_transporteur_clwp = view.findViewById(R.id.spinner_transporteur_clwp) ;
        spinner_citerne_clwp = view.findViewById(R.id.spinner_citerne_clwp) ;
    }

    public void fillDataToAllSpinner () {
        List<spinner_content_model> spinner_transporteur = new ArrayList<>() ;
        List<spinner_content_model> spinner_conducteur = new ArrayList<>() ;
        List<spinner_content_model> spinner_tracteur = new ArrayList<>() ;
        List<spinner_content_model> spinner_citerne = new ArrayList<>() ;

        spinner_transporteur.add(new spinner_content_model(1, "Rasoa")) ;
        spinner_transporteur.add(new spinner_content_model(2, "Ravao")) ;
        spinner_transporteur.add(new spinner_content_model(3, "Maria")) ;
        spinner_transporteur.add(new spinner_content_model(4, "Berta")) ;
        spinner_transporteur.add(new spinner_content_model(5, "Ravao")) ;
        spinner_transporteur.add(new spinner_content_model(6, "Ramena")) ;

        spinner_conducteur.add(new spinner_content_model(1, "Randria")) ;
        spinner_conducteur.add(new spinner_content_model(1, "Raleva")) ;
        spinner_conducteur.add(new spinner_content_model(2, "Rahosa")) ;
        spinner_conducteur.add(new spinner_content_model(2, "Ndrema")) ;
        spinner_conducteur.add(new spinner_content_model(3, "Razily")) ;
        spinner_conducteur.add(new spinner_content_model(3, "Rakoto")) ;


        spinner_tracteur.add(new spinner_content_model(1, "0248 TN")) ;
        spinner_tracteur.add(new spinner_content_model(2, "1214 TG")) ;
        spinner_tracteur.add(new spinner_content_model(3, "5588 TF")) ;
        spinner_tracteur.add(new spinner_content_model(1, "0130 FE")) ;
        spinner_tracteur.add(new spinner_content_model(2, "9910 TH")) ;
        spinner_tracteur.add(new spinner_content_model(3, "1103 TA")) ;

        spinner_citerne.add(new spinner_content_model(1, "788201")) ;
        spinner_citerne.add(new spinner_content_model(1, "336870")) ;
        spinner_citerne.add(new spinner_content_model(2, "011478")) ;
        spinner_citerne.add(new spinner_content_model(2, "485484")) ;
        spinner_citerne.add(new spinner_content_model(3, "025649")) ;
        spinner_citerne.add(new spinner_content_model(3, "684984")) ;

        ArrayAdapter<spinner_content_model> array_adapter_spinner_transporteur  = new ArrayAdapter( this.getContext(), android.R.layout.simple_spinner_dropdown_item, spinner_transporteur) ;
        array_adapter_spinner_transporteur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_transporteur_clwp.setAdapter(array_adapter_spinner_transporteur);
        spinner_transporteur_clwp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_content_model selected = (spinner_content_model) parent.getSelectedItem() ;
                Log.d("changed => ", String.valueOf(selected.get_description())) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<spinner_content_model> array_adapter_spinner_conducteur  = new ArrayAdapter( this.getContext(), android.R.layout.simple_spinner_dropdown_item, spinner_conducteur) ;
        array_adapter_spinner_conducteur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_conducteur_clwp.setAdapter(array_adapter_spinner_conducteur);
        spinner_conducteur_clwp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_content_model selected = (spinner_content_model) parent.getSelectedItem() ;
                Log.d("changed => ", String.valueOf(selected.get_description())) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<spinner_content_model> array_adapter_spinner_tracteur  = new ArrayAdapter( this.getContext(), android.R.layout.simple_spinner_dropdown_item, spinner_tracteur) ;
        array_adapter_spinner_tracteur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tracteur_clwp.setAdapter(array_adapter_spinner_tracteur);
        spinner_tracteur_clwp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_content_model selected = (spinner_content_model) parent.getSelectedItem() ;
                Log.d("changed => ", String.valueOf(selected.get_description())) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<spinner_content_model> array_adapter_spinner_citerne  = new ArrayAdapter( this.getContext(), android.R.layout.simple_spinner_dropdown_item, spinner_citerne) ;
        array_adapter_spinner_tracteur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_citerne_clwp.setAdapter(array_adapter_spinner_tracteur);
        spinner_citerne_clwp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_content_model selected = (spinner_content_model) parent.getSelectedItem() ;
                Log.d("changed => ", String.valueOf(selected.get_description())) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void fillDataToCategorieFragment() {
        activity_dao activity_dao = new activity_dao(view.getContext()) ;
        activity_model activity_model = activity_dao.getActivityByTableName("typeoperation") ;
        questionnaire_dao questionnaire_dao = new questionnaire_dao(view.getContext()) ;
        List<categorie_questionnaire_model> list = questionnaire_dao.getCategorieQuestionnaireBycatId(activity_model.get_table_id(), 0) ;
        if(list.size() > 0) {
            activity_model activity_model1 = new activity_model("categorie", list.get(0).getCategorie_id()) ;
            if(activity_dao.verify_if_exists("categorie").equals(true)) {
                activity_dao.remove_activity("categorie");
            }
            activity_dao.create_activity(activity_model1);
            for(int i = 0 ; i < list.size() ; i++) {
              //  categorieFragment.add_categorie(list.get(i).getCategorie_nom(), list.get(i).getQuestionnaire());
            }
        }
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
