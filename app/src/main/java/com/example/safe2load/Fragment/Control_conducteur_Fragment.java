package com.example.safe2load.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safe2load.R;
import com.example.safe2load.RecyclerView.ControleConducteurViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import model.object.controle_model;

public class Control_conducteur_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView _recyclerView ;
    List<controle_model> _list_controle_model ;
    private OnFragmentInteractionListener mListener;

    public Control_conducteur_Fragment() {
        // Required empty public constructor
    }

    public static Control_conducteur_Fragment newInstance(String param1, String param2) {
        Control_conducteur_Fragment fragment = new Control_conducteur_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _list_controle_model = new ArrayList() ;
        _list_controle_model.add(new controle_model(1 , "Le camion dispose de tous les certificats d\\'aptitude sur les contrôles de confirmité APAVA/MADAUTO en cours de validité (Code de la route, test de freinage, visite intérieur compartiement, test d\\étanchéité)", true)) ;
        _list_controle_model.add(new controle_model(2 , "Le transporteur dispose t-il le protocole de sécurité valide et signé par un responsable habilité de LPSA", true)) ;
        _list_controle_model.add(new controle_model(3, "Le conducteur est muni d\\'un certificat d\\'habilitation à conduire de PATH / LPSA (PASSEPORT DE CONDUITE)", true)) ;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_control_conducteur_, container, false);
        _recyclerView = v.findViewById(R.id._controle_conducteur_recycler_view) ;
        ControleConducteurViewPageAdapter controleConducteurViewPageAdapter = new ControleConducteurViewPageAdapter(this.getContext(), _list_controle_model) ;
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        _recyclerView.setAdapter(controleConducteurViewPageAdapter);
        return v ;
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
