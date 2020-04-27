package com.example.safe2load;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private final static int MdpOubli = 1234;

    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Button btnOubli;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnOubli = (Button) findViewById(R.id.btnOubli);


        btnOubli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mot_de_passe_oublie = new Intent(
                        Login.this,
                        Mot_de_passe_oublie.class
                );
                startActivity(Mot_de_passe_oublie);

            }
        });
    }
}
