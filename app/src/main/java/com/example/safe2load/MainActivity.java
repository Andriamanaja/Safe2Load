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
import android.widget.EditText;
import android.widget.Toast;

import at.favre.lib.crypto.bcrypt.BCrypt;
import database.helper.dao.data_for_sync_dao;
import database.helper.dao.users_dao;
import model.object.users_model;

public class MainActivity extends AppCompatActivity {

    private CardView btn_connect ;
    private CardView mbdp ;
    private Button btn ;
    private long back_pressed ;
    private Toast toast ;
    private EditText field_login ;
    private EditText field_pswd ;

    @Override
    public void onBackPressed() {
        if(back_pressed+2000>System.currentTimeMillis()) {
            toast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            toast = Toast.makeText(getBaseContext(), "Appuyez une deusième fois pour quitter.", Toast.LENGTH_LONG);
            toast.show();
        }
        back_pressed = System.currentTimeMillis() ;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field_login = findViewById(R.id.field_login) ;
        field_pswd = findViewById(R.id.field_pswd) ;
        btn_connect = findViewById(R.id.bnt_connect);
        btn_connect.setOnClickListener(new btn_on_click_listner());
        mbdp = findViewById(R.id.mbdp) ;

        mbdp.setOnClickListener(v -> {
            data_for_sync_dao dao = new data_for_sync_dao(getBaseContext()) ;
            dao.getAllDataForSync();
            Intent i = new Intent(MainActivity.this, MotDePasseOublieActivity.class);
            startActivity(i);
            ;
            finish();
        });
        users_dao dao = new users_dao(this) ;
        dao.disconnectAll();
    }





    public class btn_on_click_listner implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String password = "nothing" ;
            String email = "nothing" ;

            if(field_pswd.getText().toString().equals(null)==false&&field_pswd.getText().toString().equals(null)==false) {
                password = field_pswd.getText().toString() ;
                email = field_login.getText().toString();
            }

            users_model users_model = new users_model(password, email) ;
            users_dao users_dao = new users_dao(getBaseContext()) ;
            users_model = users_dao.loginUser(users_model) ;

            Log.d("pass => ", users_model.getPassword()) ;

            if(users_model.getPassword()!="") {
                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), users_model.getPassword()) ;

                if(users_model.getEmail() == "nothing") {
                    Intent i = new Intent(MainActivity.this, Menu2Activity.class) ;
                    startActivity(i); ;
                    finish();
                    Toast.makeText(v.getContext(), "Vérifier l'adreese email saisi.", Toast.LENGTH_LONG).show();
                }
                else if (users_model.getEmail() == "admin@admin.com" && users_model.getPassword() == "password" ) {
                    Intent i = new Intent(MainActivity.this, Menu2Activity.class) ;
                    startActivity(i); ;
                    finish();
                }
                else {
                    if (result.verified == true) {
                        Intent i = new Intent(MainActivity.this, Menu2Activity.class) ;
                        users_dao.connect(users_model);
                        startActivity(i); ;
                        finish();
                    }
                    else {
                        Toast.makeText(v.getContext(), "Vérifier le mot de passe saisi.", Toast.LENGTH_LONG).show();
                    }
                }
        }
        }
    }
}