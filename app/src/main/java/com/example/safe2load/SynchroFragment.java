package com.example.safe2load;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safe2load.Fragment.CategorieFragment;
import com.example.safe2load.SynchroUtils.ApiUtils;
import com.example.safe2load.SynchroUtils.SynchroService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

import database.helper.dao.sync_dao;
import database.helper.dao.vehicule_dao;
import model.object.vehicule_model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SynchroFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private TextView _field_url ;
    private TextView _fiel_user ;
    private TextView _fiel_password ;
    //private ProgressBar _sync_pb ;
    private CardView _btn_sync ;
    View view ;
    SynchroService synchroService ;

    public SynchroFragment() {
        // Required empty public constructor
    }

    public static SynchroFragment newInstance(String param1, String param2) {
        SynchroFragment fragment = new SynchroFragment();
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
        this.view = inflater.inflate(R.layout.fragment_synchro, container, false);
        loadViews();
        eventListner() ;
        loadServices() ;
        return this.view ;
    }

    public void loadViews() {
        _field_url = this.view.findViewById(R.id._field_url) ;
        _fiel_user = view.findViewById(R.id._fiel_user) ;
        _fiel_password = view.findViewById(R.id._fiel_password) ;
        _btn_sync = view.findViewById(R.id.btn_sync) ;
        //_sync_pb = view.findViewById(R.id._sync_pb) ;

    }

    public void loadServices() {
        this.synchroService = ApiUtils.getSynchroService() ;
    }

    public void eventListner() {
        this._btn_sync.setOnClickListener(v -> {
            sync_all();;
        });
    }

    public void sync_all() {

        Call<Object> call_user = synchroService.getAllUsers() ;
        call_user.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {
                    Gson gson = new Gson() ;
                    JSONArray users = new JSONArray(gson.toJson(response.body()));
                    if (users.length() > 0) {
                        for(int i = 0 ; i < users.length() ; i++) {
                            sync_dao sd = new sync_dao(view.getContext()) ;
                           // sd.generic_insert(users.getJSONObject(i));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

        Call<Object> call = synchroService.getAllData();
        call.enqueue(new Callback<Object>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()) {

                    try {
                        Gson gson = new Gson() ;
                        JSONObject jsonObject = new JSONObject(gson.toJson(response.body()));
                        JSONArray to_offline = new JSONArray(jsonObject.get("to_offline").toString());
                        JSONArray from_offline = new JSONArray(jsonObject.get("from_offline").toString());

                        if (to_offline.length() > 0) {
                            for(int i = 0 ; i < to_offline.length() ; i++) {
                                sync_dao sd = new sync_dao(view.getContext()) ;
                                sd.generic_insert(to_offline.getJSONObject(i));
                            }
                            Toast.makeText(view.getContext(), "Synchronisation effectuée avec succès", Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
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
