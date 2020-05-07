package com.example.safe2load;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safe2load.RecyclerView.RecyclerViewAdapter;
import com.example.safe2load.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import database.helper.dao.inspection_dao;
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
    private RecyclerViewAdapter adapter;

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
    }

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_stat, container, false) ;
        _list_stat_operation = new ArrayList<>() ;
        inspection_dao inspection_dao = new inspection_dao(view.getContext()) ;
        _list_stat_operation = inspection_dao.getAllStatOperation() ;
        _recyclerView = view.findViewById(R.id.recycler_stat_op) ;
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this.getContext() , _list_stat_operation) ;
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        _recyclerView.setAdapter(recyclerViewAdapter);
        return view ;

//        this.configureRecyclerView();
//        this.configureSwipeRefreshLayout();
        // 2 - Calling the method that configuring click on RecyclerView
    }

    private void configureOnClickRecyclerView() {

        ItemClickSupport.addTo(_recyclerView, R.layout.fragment_stat)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Log.e("TAG", "Position : "+position);
                    }
                });
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
