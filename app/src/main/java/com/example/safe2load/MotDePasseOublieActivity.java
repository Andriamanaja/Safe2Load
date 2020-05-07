package com.example.safe2load;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.helper.dao.res_users_dao;

public class MotDePasseOublieActivity extends AppCompatActivity {


    private String email, mdp, cmdp;
    private EditText emailEditText, mdpEditText, cmdpEditText;
    private database.helper.dao.res_users_dao res_users_dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mot_de_passe_oubi);

        res_users_dao = new res_users_dao(this);

//        List<User> list_user = new ArrayList() ;
//        list_user = res_users_dao.get_all_user() ;

        // bouton
        Button btnMdpOubli = (Button) findViewById(R.id.btn_reinit);
        btnMdpOubli.setOnClickListener(new bnt_initListener());



        emailEditText = (EditText) findViewById(R.id.emailEditText);
        mdpEditText = (EditText) findViewById(R.id.mdpEditText);
        cmdpEditText = (EditText) findViewById(R.id.cmdpEditText);

    }



    public class bnt_initListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            email = emailEditText.getText().toString();
            mdp = mdpEditText.getText().toString();
            cmdp = cmdpEditText.getText().toString();
//            Toast.makeText(getApplicationContext(), mdp, Toast.LENGTH_SHORT).show();


//            if (mdpEditText.getText().toString().equals(cmdpEditText.getText().toString())) {
//                showMessage("Error", "Please verify your password");
//                return;
//            }


            if (emailEditText.getText().toString().trim().length() == 0 ||
                    mdpEditText.getText().toString().trim().length() == 0 ||
                    cmdpEditText.getText().toString().trim().length() == 0) {


                showMessage("Error", "Please enter Email and The new password");
            }

            else {
                Intent i = new Intent(MotDePasseOublieActivity.this, MainActivity.class);
                startActivity(i);
                ;
                finish();


            }
        }
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
