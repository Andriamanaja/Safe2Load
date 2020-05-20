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
import android.widget.Toast;

import com.example.safe2load.R;
import com.example.safe2load.RecyclerView.InspectionRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import model.object.controle_model;



public class InspectionFragment extends Fragment implements CLCC_chargement_Fragment.CategorieFragmentListner {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView _recyclerView ;
    List<controle_model> _list_controle_model ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view ;

    private OnFragmentInteractionListener mListener;

    public InspectionFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public InspectionFragment(String questionnaire) throws JSONException {
        Log.d("qest => " , questionnaire) ;
        _list_controle_model = new ArrayList<>() ;
        JSONArray jsonArray = new JSONArray(questionnaire) ;
        for (int i = 0 ; i < jsonArray.length() ; i++) {
            _list_controle_model.add(new controle_model((JSONObject) jsonArray.get(i))) ;
        }
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_inspection, container, false);
        _recyclerView = view.findViewById(R.id._inspection_recycler_view) ;
        InspectionRecyclerView inspectionRecyclerView = new InspectionRecyclerView(this.getContext()) ;
        inspectionRecyclerView.setItems( _list_controle_model);
        inspectionRecyclerView.notifyDataSetChanged();
        _recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        _recyclerView.setAdapter(inspectionRecyclerView);
        Log.d("inspection fragment", "ok");
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
        Log.d("inspection fragment", "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.d("inspection fragment", "onDetach");
    }

    @Override
    public void onTracteurChange() {
        Toast.makeText(view.getContext(), "TEST", Toast.LENGTH_SHORT).show();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
