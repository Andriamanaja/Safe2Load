package com.example.safe2load.SynchroUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface SynchroService {

    @POST("get_all_data/")
    Call<Object> getAllData() ;

    @POST("get_all_utilisateur")
    Call<Object> getAllUsers() ;
}
