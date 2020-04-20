package com.example.safe2load;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import database.helper.dao.res_users_dao;
import model.object.res_users_model;

public class MainActivity extends AppCompatActivity {

    private CardView btn_connect ;
    private Button btn ;
    private res_users_dao res_users_dao ;
    private res_users_model res_users_model ;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res_users_model = new res_users_model("test@moov.mg", "password", 1) ;
        Log.d("user_model", String.valueOf(res_users_model.getName()));

        this.res_users_dao = new res_users_dao(this);

        res_users_dao.insert_user(res_users_model);

        btn_connect = findViewById(R.id.bnt_connect);
        btn_connect.setOnClickListener(new btn_on_click_listner());
    }

    public class btn_on_click_listner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, Menu2Activity.class) ;
            startActivity(i); ;
            finish();
        }
    }
}
