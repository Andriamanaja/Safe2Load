package com.example.safe2load.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safe2load.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import model.object.controle_model;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CLCP_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CLCP_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CLCP_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view ;

    CategorieFragment categorieFragment ;

    private OnFragmentInteractionListener mListener;

    public CLCP_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CLCP_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CLCP_Fragment newInstance(String param1, String param2) {
        CLCP_Fragment fragment = new CLCP_Fragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_clcp_, container, false);

        categorieFragment = (CategorieFragment)this.getChildFragmentManager().findFragmentById(R.id.fragmentParent) ;

        List<controle_model> doc_portail_list_controle_model = new ArrayList<>() ;
        List<controle_model> cams_list_controle_model = new ArrayList<>() ;
        List<controle_model> cond_list_controle_model = new ArrayList<>() ;
        Gson gson = new Gson() ;

        doc_portail_list_controle_model.add(new controle_model(1 , "Le camion dispose de tous les certificats d\\'aptitude sur les contrôles de confirmité APAVA/MADAUTO en cours de validité (Code de la route, test de freinage, visite intérieur compartiement, test d\\étanchéité)", true)) ;
        doc_portail_list_controle_model.add(new controle_model(2 , "Le transporteur dispose t-il le protocole de sécurité valide et signé par un responsable habilité de LPSA", true)) ;
        doc_portail_list_controle_model.add(new controle_model(3 , "Le conducteur est muni d\\'un certificat d\\'habilitation à conduire de PATH / LPSA (PASSEPORT DE CONDUITE)", true)) ;

        cams_list_controle_model.add(new controle_model(1 , "Le camion dispose de tous les certificats d\\'aptitude sur les contrôles de confirmité APAVA/MADAUTO en cours de validité (Code de la route, test de freinage, visite intérieur compartiement, test d\\étanchéité)", true)) ;
        cams_list_controle_model.add(new controle_model(2 , "Le transporteur dispose t-il le protocole de sécurité valide et signé par un responsable habilité de LPSA", true)) ;

        cond_list_controle_model.add(new controle_model(2 , "Le transporteur dispose t-il le protocole de sécurité valide et signé par un responsable habilité de LPSA", true)) ;

        String json_doc_portail_list_controle_model = gson.toJson(doc_portail_list_controle_model) ;
        String json_cams_list_controle_model = gson.toJson(cams_list_controle_model) ;
        String json_cond_list_controle_model = gson.toJson(cond_list_controle_model) ;


        //SOLOINA AMLE AVY ANATY BASE RF VITA N SYNCHRO
        categorieFragment.add_categorie("Présentation des documents au portail", json_doc_portail_list_controle_model);
        categorieFragment.add_categorie("Contrôle de conducteur", json_cams_list_controle_model);
        categorieFragment.add_categorie("Contrôle de camion", json_cond_list_controle_model);

        return view ;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
