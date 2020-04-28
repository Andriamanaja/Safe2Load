package com.example.safe2load;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safe2load.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import model.object.stat_operation;

public class StatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view ;
    private RecyclerView _recyclerView ;
    private List<stat_operation> _list_stat_operation ;

    private OnFragmentInteractionListener mListener;

    public StatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatFragment newInstance(String param1, String param2) {
        StatFragment fragment = new StatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _list_stat_operation = new ArrayList<>() ;
        _list_stat_operation.add(new stat_operation(1, "CLCC-DECHARGEMENT", "RABEMANJAFY  Désiré" , "5896 TBA", "4h10min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(2, "CLCC-LIVRAISON", "RAKOTO Jean" , "0132 TBB", "9h11min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(3, "CLWR", "ALAIN Bernad" , "7413 TBC", "12h30min00s", "17/04/2020" , "Conforme")) ;
        _list_stat_operation.add(new stat_operation(4, "CLCC-DECHARGEMENT", "RABEMANJAFY  Désiré" , "5896 TBA", "4h10min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(5, "CLCC-LIVRAISON", "RAKOTO Jean" , "0132 TBB", "9h11min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(6, "CLWR", "ALAIN Bernad" , "7413 TBC", "12h30min00s", "17/04/2020" , "Conforme")) ;
        _list_stat_operation.add(new stat_operation(7, "CLCC-DECHARGEMENT", "RABEMANJAFY  Désiré" , "5896 TBA", "4h10min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(8, "CLCC-LIVRAISON", "RAKOTO Jean" , "0132 TBB", "9h11min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(9, "CLWR", "ALAIN Bernad" , "7413 TBC", "12h30min00s", "17/04/2020" , "Conforme")) ;
        _list_stat_operation.add(new stat_operation(10, "CLCC-DECHARGEMENT", "RABEMANJAFY  Désiré" , "5896 TBA", "4h10min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(12, "CLCC-LIVRAISON", "RAKOTO Jean" , "0132 TBB", "9h11min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(13, "CLWR", "ALAIN Bernad" , "7413 TBC", "12h30min00s", "17/04/2020" , "Conforme")) ;
        _list_stat_operation.add(new stat_operation(14, "CLCC-DECHARGEMENT", "RABEMANJAFY  Désiré" , "5896 TBA", "4h10min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(15, "CLCC-LIVRAISON", "RAKOTO Jean" , "0132 TBB", "9h11min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(16, "CLWR", "ALAIN Bernad" , "7413 TBC", "12h30min00s", "17/04/2020" , "Conforme")) ;
        _list_stat_operation.add(new stat_operation(17, "CLCC-DECHARGEMENT", "RABEMANJAFY  Désiré" , "5896 TBA", "4h10min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(18, "CLCC-LIVRAISON", "RAKOTO Jean" , "0132 TBB", "9h11min00s", "17/04/2020" , "Non conforme")) ;
        _list_stat_operation.add(new stat_operation(19, "CLWR", "ALAIN Bernad" , "7413 TBC", "12h30min00s", "17/04/2020" , "Non conforme")) ;
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_stat, container, false) ;
        _recyclerView = view.findViewById(R.id.recycler_stat_op) ;
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this.getContext() , _list_stat_operation) ;
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        _recyclerView.setAdapter(recyclerViewAdapter);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
