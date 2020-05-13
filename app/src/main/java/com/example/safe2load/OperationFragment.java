package com.example.safe2load;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.example.safe2load.Fragment.CLCC_baremage_Fragment;
import com.example.safe2load.Fragment.CLCC_chargement_Fragment;
import com.example.safe2load.Fragment.CLCC_dechargement_Fragment;
import com.example.safe2load.Fragment.CLCP_Fragment;

import database.helper.dao.activity_dao;
import database.helper.dao.typeoeration_dao;
import model.object.activity_model;
import model.object.typeoperation_model;


public class OperationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view ;
    ConstraintLayout content_operation ;

    FloatingActionButton floatingActionButton ;
    CardView bnt_clcc_chargement ;
    CardView bnt__clcc_dechargement ;
    CardView bnt_clcp ;
    CardView bnt_clcc_baremage ;
    OvershootInterpolator interpolator = new OvershootInterpolator() ;

    Context operation_context ;

    float translationY = 100f;

    boolean is_open = false ;

    private OnFragmentInteractionListener mListener;

    public OperationFragment() {
        // Required empty public constructor
    }

    public static OperationFragment newInstance(String param1, String param2) {
        OperationFragment fragment = new OperationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
    }

    private void init_view() {
        floatingActionButton = view.findViewById(R.id.floating_btn_operation);
        bnt__clcc_dechargement = view.findViewById(R.id.bnt__clcc_dechargement);
        bnt_clcc_chargement = view.findViewById(R.id.bnt_clcc_chargement);
        bnt_clcp = view.findViewById(R.id.bnt_clcp);
        bnt_clcc_baremage = view.findViewById(R.id.bnt_clcc_baremage) ;

        bnt__clcc_dechargement.setAlpha(0f);
        bnt_clcc_chargement.setAlpha(0f);
        bnt_clcp.setAlpha(0f);
        bnt_clcc_baremage.setAlpha(0f);

        bnt__clcc_dechargement.setTranslationX(translationY);
        bnt_clcc_chargement.setTranslationX(translationY);
        bnt_clcp.setTranslationX(translationY);
        bnt_clcc_baremage.setTranslationX(translationY);

        floatingActionButton.setOnClickListener(v -> {
            if(is_open == false) {
                open_menu();
            }
            else {
                close_menu();
            }
        });

        bnt__clcc_dechargement.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager() ;
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content, CLCC_dechargement_Fragment.class.newInstance()).commit() ;
                getActivity().setTitle("CLCC Déchargement");
                add_to_activity("CLCC Déchargement") ;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });

        bnt_clcc_chargement.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager() ;
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content, CLCC_chargement_Fragment.class.newInstance()).commit() ;
                getActivity().setTitle("CLCC Chargement");
                add_to_activity("CLCC Chargement") ;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });

        bnt_clcp.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager() ;
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content, CLCP_Fragment.class.newInstance()).commit() ;
                getActivity().setTitle("CLCP");
                add_to_activity("CLCP") ;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });

        bnt_clcc_baremage.setOnClickListener(v -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager() ;
            try {
                fragmentManager.beginTransaction().replace(R.id.layout_content, CLCC_baremage_Fragment.class.newInstance()).commit() ;
                getActivity().setTitle("CLCC Barémage");
                add_to_activity("CLCC Barémage") ;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        });
    }

    public void add_to_activity(String title) {
        typeoeration_dao typeoeration_dao = new typeoeration_dao(this.view.getContext()) ;
        typeoperation_model typeoperation_model = typeoeration_dao.getTypeOperationByName(title) ;
        activity_dao activity_dao = new activity_dao(this.view.getContext()) ;
        activity_model activity_model1 = new activity_model("typeoperation", typeoperation_model.get_typeoperation_id()) ;
        if(activity_dao.verify_if_exists("typeoperation").equals(true)) {
            activity_dao.remove_activity("typeoperation");
        }
        activity_dao.create_activity(activity_model1);
    }

    @SuppressLint("ResourceAsColor")
    public void open_menu() {

        floatingActionButton.setBackgroundColor(R.color.colorSecondaryDark);

        floatingActionButton.animate().setInterpolator(interpolator).rotationBy(45f).setDuration(300).start();
        bnt__clcc_dechargement.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        bnt_clcc_chargement.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        bnt_clcp.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        bnt_clcc_baremage.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();

        is_open = true ;
    }

    public void close_menu() {

        floatingActionButton.animate().setInterpolator(interpolator).rotationBy(0).setDuration(300).start();
        bnt__clcc_dechargement.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        bnt_clcc_chargement.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        bnt_clcp.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        bnt_clcc_baremage.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

        is_open = false ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_operation, container, false) ;
        this.init_view();
        //content_operation = view.findViewById(R.id.content_operation) ;
        return view;
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
