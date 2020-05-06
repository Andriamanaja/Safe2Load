package com.example.safe2load.Fragment;

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

import com.example.safe2load.R;
import com.example.safe2load.RecyclerView.Doc_Portail_ViewAdapter;
import com.example.safe2load.ViewPagerAdapter.ViewPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import model.object.controle_model;



public class InspectionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView _recyclerView ;
    List<controle_model> _list_controle_model = new ArrayList<>() ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view ;

    private OnFragmentInteractionListener mListener;

    public InspectionFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static InspectionFragment newInstance(String param1, String param2) {
        InspectionFragment fragment = new InspectionFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments() ;

        try {
            JSONArray jsonArray = new JSONArray(bundle.getString("_list_inspection")) ;

            for (int i = 0 ; i < jsonArray.length() ; i++) {
                _list_controle_model.add(new controle_model((JSONObject) jsonArray.get(i))) ;
            }

            Log.d("inspection => " , jsonArray.get(0).toString()) ;
        } catch (JSONException e) {
            e.printStackTrace();
        }


        View view = inflater.inflate(R.layout.fragment_inspection, container, false);
        _recyclerView = view.findViewById(R.id._inspection_recycler_view) ;
        Doc_Portail_ViewAdapter doc_portail_viewAdapter = new Doc_Portail_ViewAdapter(this.getContext(), _list_controle_model) ;
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        _recyclerView.setAdapter(doc_portail_viewAdapter);
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
