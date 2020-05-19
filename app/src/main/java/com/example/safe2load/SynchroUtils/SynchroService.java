package com.example.safe2load.SynchroUtils;

import org.json.JSONObject;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SynchroService {

    @Headers( "Content-Type: application/json; charset=utf-8")
    @POST("get_all_data/")
    Call<Object> getAllData(@Body RequestBody object) ;

    @POST("get_all_utilisateur")
    Call<Object> getAllUsers() ;
}
