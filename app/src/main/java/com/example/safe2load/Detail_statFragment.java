package com.example.safe2load;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safe2load.RecyclerView.Detail_stat_ViewAdapter;

import java.util.ArrayList;
import java.util.List;

import model.object.Detail_stat_model;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detail_statFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detail_statFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    View view ;
    private RecyclerView _recyclerView ;
    private List<Detail_stat_model> _list_detail_stat ;

    private StatFragment.OnFragmentInteractionListener mListener;

    public Detail_statFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Detail_stat.
     */
    // TODO: Rename and change types and number of parameters
    public static Detail_statFragment newInstance(String param1, String param2) {
        Detail_statFragment fragment = new Detail_statFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _list_detail_stat = new ArrayList<>() ;
        _list_detail_stat.add(new Detail_stat_model(6, "Présence de ceintures de sécurité à 03 points qui fonctionne bien pour le conducteur et son aide", "Présence de ceintures de sécurité à 03 points qui fonctionne bien pour le conducteur et abscence de ceintures de sécurité à 03 points quiu fonctionne bien pour son aide  " )) ;
        _list_detail_stat.add(new Detail_stat_model(9, "Plots de mise à la terre bien fixés et propre (non rouillées et non peints)", "Plots de mise à la terre bien fixé mais pas propre et non rouillés" )) ;
        _list_detail_stat.add(new Detail_stat_model(11, "Pneumatiques en bon état y compris les roues de secours (profondeur rainure > 2 mm sur toute la circonférence) et en nombre suffisant(01RDS pour le tracteur et 01RDS pour la citerne)", "Pneumatiques en bon état y compris les roues de secours (profondeur rainure > 2 mm ur toute la circonférence)mais en nombre insuffisant (01RDS pour le tracteur et 0 pour la citerne) " )) ;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_detail_stat, container, false);
        _recyclerView = v.findViewById(R.id.recycler_Detail_stat) ;
        Detail_stat_ViewAdapter detail_stat_viewAdapter = new Detail_stat_ViewAdapter(this.getContext(), _list_detail_stat) ;
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        _recyclerView.setAdapter(detail_stat_viewAdapter);
        return v ;
    }

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