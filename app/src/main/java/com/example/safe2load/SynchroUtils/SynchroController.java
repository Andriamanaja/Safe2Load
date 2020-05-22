package com.example.safe2load.SynchroUtils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import database.helper.dao.data_for_sync_dao;
import database.helper.dao.sync_dao;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SynchroController {

    private SynchroService synchroService ;
    private Context context ;

    public SynchroController(Context context) {
        this.context = context;
        this.synchroService = ApiUtils.getSynchroService() ;
    }

    public void getAllUserFromOnline() {
        Call<Object> call_user = synchroService.getAllUsers() ;
        call_user.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                try {
                    Gson gson = new Gson() ;
                    JSONArray users = new JSONArray(gson.toJson(response.body()));
                    if (users.length() > 0) {
                        for(int i = 0 ; i < users.length() ; i++) {
                            sync_dao sd = new sync_dao(context) ;
                            if(sd.verify_if_users_exist(users.getJSONObject(i).getInt("id")) == false) {
                                sd.generic_insert(users.getJSONObject(i));
                            }
                        }
                    }
                } catch (JSONException e) {
                    Toast.makeText(context, "Une erreur s'est produite lors de la synchronisation : " + e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(context, "Une erreur s'est produite lors de la synchronisation : " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getAllDataFromOnline(RequestBody object) {
        Call<Object> call = synchroService.getAllData(object);
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
                                sync_dao sd = new sync_dao(context) ;
                                sd.generic_insert(to_offline.getJSONObject(i));

                            }
                            Toast.makeText(context, "Synchronisation effectuée avec succès", Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        Toast.makeText(context, "Une erreur s'est produite lors de la synchronisation : " + e.getMessage(),  Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(context, "Une erreur s'est produite lors de la synchronisation : " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}
