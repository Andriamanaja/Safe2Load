package com.example.safe2load.SynchroUtils;

public class ApiUtils {

    private ApiUtils(){
    };

    public static final String API_URL = "http://5.189.167.183/safe2load/webservice/";

    public static SynchroService getSynchroService(){
        return RetrofitClient.getClient(API_URL).create(SynchroService.class);
    }

}
