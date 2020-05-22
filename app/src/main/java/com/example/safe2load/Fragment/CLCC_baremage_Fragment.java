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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safe2load.R;
import com.google.gson.Gson;

import org.json.JSONException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import database.helper.dao.activity_dao;
import database.helper.dao.data_for_sync_dao;
import database.helper.dao.depot_dao;
import database.helper.dao.inspection_dao;
import database.helper.dao.plannification_dao;
import database.helper.dao.pointcontrole_dao;
import database.helper.dao.questionnaire_dao;
import database.helper.dao.users_dao;
import database.helper.dao.vehicule_dao;
import database.helper.dao.vehiculeinspection_dao;
import model.object.activity_model;
import model.object.categorie_questionnaire_model;
import model.object.controle_model;
import model.object.data_for_sync_model;
import model.object.depot_model;
import model.object.inspection_model;
import model.object.plannification_model;
import model.object.pointcontrole_model;
import model.object.spinner_content_model;
import model.object.transporteur_model;
import model.object.users_model;
import model.object.vehicule_model;

public class CLCC_baremage_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view ;
    Spinner spinner_transporteur_clcc_baremage ;
    Spinner spinner_conducteur_clcc_baremage ;
    Spinner spinner_tracteur_clcc_baremage ;
    Spinner spinner_citerne_clcc_baremage ;
    CategorieFragment categorieFragment ;
    TextView date_clcc_baremage ;
    TextView heure_clcc_baremage ;
    TextView depot_clcc_baremage ;
    TextView durée_clcc_baremage ;
    Button save_clcc_inspection ;
    int current_inspection_id = 0 ;
    private List<plannification_model> list_plannification = new ArrayList<>() ;

    private OnFragmentInteractionListener mListener;

    public CLCC_baremage_Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CLCC_baremage_Fragment newInstance(String param1, String param2) {
        CLCC_baremage_Fragment fragment = new CLCC_baremage_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_clcc_baremage_, container, false);
        this.loadViews();
        try {
            this.fillDataToAllSpinner();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return view ;
    }

    public void loadViews () {
        spinner_tracteur_clcc_baremage = view.findViewById(R.id.spinner_tracteur_clcc_baremage) ;
        spinner_conducteur_clcc_baremage = view.findViewById(R.id.spinner_conducteur_clcc_baremage) ;
        spinner_transporteur_clcc_baremage = view.findViewById(R.id.spinner_transporteur_clcc_baremage) ;
        spinner_citerne_clcc_baremage = view.findViewById(R.id.spinner_citerne_clcc_baremage) ;
        save_clcc_inspection = view.findViewById(R.id.save_clcc_inspection) ;
        date_clcc_baremage = view.findViewById(R.id.date_clcc_baremage) ;
        heure_clcc_baremage = view.findViewById(R.id.heure_clcc_baremage) ;
        depot_clcc_baremage = view.findViewById(R.id.depot_clcc_baremage) ;
    }

    public void fillDataToAllSpinner () throws ParseException {

        users_dao users_dao = new users_dao(view.getContext()) ;

        plannification_dao plannification_dao = new plannification_dao(this.getContext()) ;
        this.list_plannification = plannification_dao.getPlannification() ;
        List<vehicule_model> list_vehicule = new ArrayList<>() ;
        for(int i = 0 ; i < this.list_plannification.size() ; i++) {
            list_vehicule.add(list_plannification.get(i).getCiterne(list_plannification.get(i))) ;
        }

        ArrayAdapter<vehicule_model> array_adapter_spinner_vehicule = new ArrayAdapter<vehicule_model>(this.view.getContext(), android.R.layout.simple_spinner_item, list_vehicule) ;
        array_adapter_spinner_vehicule.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //TRACTEUR
        spinner_tracteur_clcc_baremage.setAdapter(array_adapter_spinner_vehicule);

        spinner_tracteur_clcc_baremage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

                depot_dao depot_dao = new depot_dao(view.getContext()) ;
                depot_model depot_model = depot_dao.getDepotById(list_plannification.get(position).get_depot_id()) ;
                depot_clcc_baremage.setText(depot_model.getDepot_nom());

                pointcontrole_dao pointcontrole_dao = new pointcontrole_dao(view.getContext()) ;
                plannification_model my_plannification = list_plannification.get(position) ;
                vehicule_model my_vehicule = list_vehicule.get(position) ;
                vehiculeinspection_dao vehiculeinspection_dao = new vehiculeinspection_dao(view.getContext()) ;
                boolean verification = false ;
                if(list_vehicule.get(position).get_vehiculetype_id() == 1) {
                    verification =  vehiculeinspection_dao.verify_inspection_id(list_vehicule.get(position).get_vehicule_id()) ;
                }
                else {
                    verification =  vehiculeinspection_dao.verify_inspection_vehicule_id(list_vehicule.get(position).get_vehicule_id()) ;
                }
                if(verification == false) {
                    try {
                        inspection_dao inspection_dao = new inspection_dao(view.getContext()) ;
                        current_inspection_id = inspection_dao.getNewIdfromInspection() ;
                        activity_model activity_model = new activity_model("inspection", current_inspection_id) ;
                        activity_dao activity_dao = new activity_dao(view.getContext()) ;
                        if(activity_dao.verify_if_exists("inspection").equals(true)) {
                            activity_dao.remove_activity("inspection");
                        }
                        activity_dao.create_activity(activity_model);
                        vehicule_dao vehicule_dao = new vehicule_dao(view.getContext()) ;
                        int idtransporteur = vehicule_dao.getTransporteur(my_vehicule.get_vehicule_id()).getId() ;
                        inspection_model inspection_model = new inspection_model(
                                users_dao.getConnectedUser().getId(),
                                0,
                                idtransporteur,
                                2,
                                my_plannification.get_type_operation() ,
                                my_plannification.get_depot_id(),
                                inspection_dao.getNewIdfromInspection(),
                                my_vehicule.get_vehicule_id(),
                                my_vehicule.get_citerne_id(),
                                list_plannification.get(position).get_plannification_id()
                        ) ;
                        data_for_sync_dao data_for_sync_dao = new data_for_sync_dao(view.getContext()) ;
                        data_for_sync_model dt = inspection_dao.insertInspection(inspection_model);
                        data_for_sync_dao.insertDataForSync(dt);
                        questionnaire_dao questionnaire_dao = new questionnaire_dao(view.getContext()) ;
                        List<Integer> list_questionnaire_id = questionnaire_dao.getQuestionnaireIdByActivity() ;
                        for(int i = 0 ; i < list_questionnaire_id.size() ; i++) {
                            pointcontrole_model pointcontrole_model = new pointcontrole_model(
                                    current_inspection_id ,
                                    list_questionnaire_id.get(i) ,
                                    2,
                                    "",
                                    ""
                            );
                            dt = pointcontrole_dao.insertPointControle(pointcontrole_model);
                            data_for_sync_dao.insertDataForSync(dt);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {

                    current_inspection_id = vehiculeinspection_dao.getInspectionId(my_plannification.get_vehicule_id()) ;
                    activity_model activity_model = new activity_model("inspection", current_inspection_id) ;
                    activity_dao activity_dao = new activity_dao(view.getContext()) ;
                    if(activity_dao.verify_if_exists("inspection").equals(true)) {
                        activity_dao.remove_activity("inspection");
                    }
                    activity_dao.create_activity(activity_model);
                }

                try {
                    fillDataToCategorieFragment(current_inspection_id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                List<vehicule_model> list_citerne = new ArrayList<>() ;
                vehicule_dao vehicule_dao = new vehicule_dao(view.getContext()) ;
                if(list_plannification.get(position).get_cterne_id() > 0) {
                    list_citerne.add(vehicule_dao.getVehiculeById(list_plannification.get(position).get_cterne_id())) ;
                }
                else {
                    list_citerne.add(vehicule_dao.getCiterneById(list_plannification.get(position).get_cterne_id())) ;
                }
                ArrayAdapter<vehicule_model> array_adapter_spinner_citerne = new ArrayAdapter<vehicule_model>(view.getContext(), android.R.layout.simple_spinner_item, list_citerne) ;
                spinner_citerne_clcc_baremage.setAdapter(array_adapter_spinner_citerne);

                List<transporteur_model> list_transporteur = new ArrayList<>() ;
                list_transporteur.add(vehicule_dao.getTransporteur(my_vehicule.get_vehicule_id())) ;
                ArrayAdapter<transporteur_model> array_adapter_spinner_spinner = new ArrayAdapter<transporteur_model>(view.getContext(), android.R.layout.simple_spinner_item, list_transporteur) ;
                spinner_transporteur_clcc_baremage.setAdapter(array_adapter_spinner_spinner);

                inspection_dao inspection_dao = new inspection_dao(view.getContext()) ;
                inspection_model info = inspection_dao.getInspectionInfo(current_inspection_id) ;
                date_clcc_baremage.setText(info.getInspection_datevisite());
                heure_clcc_baremage.setText(info.getInspection_heuredebut());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                try {
                    fillDataToCategorieFragment(current_inspection_id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });

        //TRACTEUR

        //CONDUCTEUR
        List<users_model> users_models = users_dao.getAllConducteur() ;
        ArrayAdapter<users_model> array_adapter_spinner_conducteur = new ArrayAdapter<users_model>(view.getContext(), android.R.layout.simple_spinner_item, users_models) ;
        spinner_conducteur_clcc_baremage.setAdapter(array_adapter_spinner_conducteur);

        spinner_conducteur_clcc_baremage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                inspection_dao inspection_dao = new inspection_dao(view.getContext()) ;
                inspection_dao.updateConducteur(users_models.get(position).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //CONDUCTEUR



        //SAVE INSPECTION
        save_clcc_inspection.setOnClickListener(v -> {
            inspection_dao inspection_dao = new inspection_dao(view.getContext()) ;
            inspection_dao.cloturerInspection();
            Toast.makeText(view.getContext(), "Inpection clôturée avec succès", Toast.LENGTH_LONG).show();
        });
        //SAVE INSPECTION
    }

    public void fillDataToCategorieFragment(int id_inspection_mobile) throws JSONException {
        categorieFragment = (CategorieFragment)this.getChildFragmentManager().findFragmentById(R.id.fragmentParent) ;
        activity_dao activity_dao = new activity_dao(view.getContext()) ;
        activity_model activity_model = activity_dao.getActivityByTableName("typeoperation") ;
        questionnaire_dao questionnaire_dao = new questionnaire_dao(view.getContext()) ;
        List<categorie_questionnaire_model> list = new ArrayList<>() ;
        list = questionnaire_dao.getCategorieQuestionnaireBycatId(activity_model.get_table_id(), id_inspection_mobile) ;
        if(list.size() > 0) {
            activity_model activity_model1 = new activity_model("categorie", list.get(0).getCategorie_id()) ;
            if(activity_dao.verify_if_exists("categorie").equals(true)) {
                activity_dao.remove_activity("categorie");
            }
            activity_dao.create_activity(activity_model1);
            /*for(int i = 0 ; i < list.size() ; i++) {
               categorieFragment.add_categorie(list.get(i).getCategorie_nom(), list.get(i).getQuestionnaire());
            }*/
            categorieFragment.add_categorie(list);
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
