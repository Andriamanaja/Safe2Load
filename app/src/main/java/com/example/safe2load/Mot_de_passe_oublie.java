package com.example.safe2load;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mot_de_passe_oublie extends AppCompatActivity {

private EditText txtmail;
private Button btn;

private SQLiteDatabase db;
private SQLiteOpenHelper openHelper;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mot_de_passe_oublie);

        txtmail = (EditText) findViewById(R.id.txtmail);
        btn = (Button) findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String s = txtmail.getText().toString();


            }
        });
    }
}
