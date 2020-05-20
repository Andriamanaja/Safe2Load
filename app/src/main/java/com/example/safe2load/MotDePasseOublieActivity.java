package com.example.safe2load;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.helper.dao.res_users_dao;

public class MotDePasseOublieActivity extends AppCompatActivity {


    private String email, mdp, cmdp;
    private EditText emailEditText, mdpEditText, cmdpEditText;
    private database.helper.dao.res_users_dao res_users_dao;
    private long back_pressed ;
    private Toast toast ;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

//            Boolean res=res_users_dao.checkUsers(email,mdp);
//            if(res == true){
//                Toast.makeText(MotDePasseOublieActivity.this,"Succesfully loggedin",Toast.LENGTH_SHORT).show();
//
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            }else{
//                Toast.makeText(MotDePasseOublieActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
//            }


//            Toast.makeText(getApplicationContext(), mdp, Toast.LENGTH_SHORT).show();


//            if (mdpEditText.getText().toString().equals(cmdpEditText.getText().toString())) {
//                showMessage("Error", "Please verify your password");
//                return;
//            }


            if (emailEditText.getText().toString().trim().length() == 0 ||
                    mdpEditText.getText().toString().trim().length() == 0 ||
                    cmdpEditText.getText().toString().trim().length() == 0) {


                showMessage("Error", "Please enter Email/The new password");
            }
            else if (!mdp.matches(cmdp)) {
                Toast.makeText(MotDePasseOublieActivity.this, "Password doesn't matched!", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent i = new Intent(MotDePasseOublieActivity.this, MainActivity.class);
                startActivity(i);
                ;
                finish();

                logInWith(email,mdp);

            }
        }
    }


    private void logInWith(String email, String mdp) {

        final ProgressDialog progressDialog = ProgressDialog
                .show(MotDePasseOublieActivity.this,
                        "Log In is processing...",
                        "");

//        res_users_dao.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
////            @Override
////            public void onComplete(@NonNull Task<AuthResult> task) {
////                if(task.isSuccessful()){
////                    Intent intent = new Intent(MotDePasseOublieActivity.this, MainActivity.class);
////                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
////                    startActivity(intent);
////                    finish();
////                    Toast.makeText(MotDePasseOublieActivity.this, "Log In Successful", Toast.LENGTH_SHORT).show();
////                    progressDialog.dismiss();
////
////                }else{
////                    progressDialog.dismiss();
////                    Toast.makeText(MotDePasseOublieActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
////                }
////            }
////        });

    }



    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
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
}
