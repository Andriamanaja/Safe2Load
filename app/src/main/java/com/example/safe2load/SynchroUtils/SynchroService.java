package com.example.safe2load.SynchroUtils;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SynchroService {

    @Headers( "Content-Type: application/json; charset=utf-8")
    @POST("get_all_data/")
    Call<Object> getAllData(@Body RequestBody object) ;

    @POST("get_all_utilisateur/")
    Call<Object> getAllUsers() ;

    @POST("get_reset_password/")
    Call<Object> getUsers();
}
