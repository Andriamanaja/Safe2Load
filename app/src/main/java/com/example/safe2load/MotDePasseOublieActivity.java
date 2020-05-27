package com.example.safe2load;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.safe2load.SynchroUtils.SynchroController;

import org.json.JSONObject;

import java.util.Random;

import database.helper.dao.res_users_dao;
import database.helper.dao.users_dao;
import okhttp3.RequestBody;

public class MotDePasseOublieActivity extends AppCompatActivity {


    private String email, mdp, cmdp;
    private EditText emailEditText, mdpEditText, cmdpEditText;
    private database.helper.dao.res_users_dao res_users_dao;
    private long back_pressed ;
    private Toast toast ;


    private static final String ALLOWED_CHARACTERS ="0123456789qwertyuiopasdfghjklzxcvbnm";
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
//        mdpEditText = (EditText) findViewById(R.id.mdpEditText);
//        cmdpEditText = (EditText) findViewById(R.id.cmdpEditText);

    }



    public class bnt_initListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            email = emailEditText.getText().toString();
//            mdp = mdpEditText.getText().toString();
//            cmdp = cmdpEditText.getText().toString();

            SynchroController synchroController = new SynchroController(getBaseContext());
            RequestBody requestBody = null;

            String new_password = null;

            if (emailEditText.getText().toString().trim().length() == 0 )
//                    mdpEditText.getText().toString().trim().length() == 0 ||
//                    cmdpEditText.getText().toString().trim().length() == 0
            {


                showMessage("Error", "Vérifier l'adresse Email");
            }
//            else if (!mdp.matches(cmdp)) {
//                Toast.makeText(MotDePasseOublieActivity.this, "Le mot de passe saisie n'est pas valide !", Toast.LENGTH_SHORT).show();
//            }
            else {

                try {
                    users_dao users_dao = new users_dao(getBaseContext());
                    JSONObject users_model = users_dao.get_users_model_for_sync(emailEditText.getText().toString());
                    if (!users_model.equals(null)) {
                        requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), users_model.toString());
                        synchroController.UsersFromOneline(requestBody);
                        sendPasswordEmail(new_password);
                    } else {
                        Toast.makeText(getBaseContext(), "This mail is not exist", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }       }

        private  String generatePassword(final int sizeOfRandomString) {
            final Random random=new Random();
            final StringBuilder sb=new StringBuilder(sizeOfRandomString);
            for(int i=0;i<sizeOfRandomString;++i)
                sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
            return sb.toString();
        }

        protected void sendPasswordEmail(String toSend) {
            Log.i("Send email", "");

            String databaseEmail = "";

            final int sizePass = 10;
            String[] TO = {toSend};
            String newRandom =  generatePassword(sizePass);
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mail to :"));
            emailIntent.setType("text/plain");



            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your new password is...");
            emailIntent.putExtra(Intent.EXTRA_TEXT, newRandom);

            //if email is already registered, send a random password.

            try{
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();
                Log.i("Sent email", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MotDePasseOublieActivity.this,
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }
//
//            if (emailEditText.getText().toString().trim().length() == 0 )
////                    mdpEditText.getText().toString().trim().length() == 0 ||
////                    cmdpEditText.getText().toString().trim().length() == 0
//                     {
//
//
//                showMessage("Error", "Vérifier l'adresse Email");
//            }
////            else if (!mdp.matches(cmdp)) {
////                Toast.makeText(MotDePasseOublieActivity.this, "Le mot de passe saisie n'est pas valide !", Toast.LENGTH_SHORT).show();
////            }
//            else {
//                Intent i = new Intent(MotDePasseOublieActivity.this, MainActivity.class);
//                startActivity(i);
//                ;
//                finish();
//
//                logInWith(email,mdp);
//
//            }
//        }

//
//
//    private void logInWith(String email, String mdp) {
//
//        final ProgressDialog progressDialog = ProgressDialog
//                .show(MotDePasseOublieActivity.this,
//                        "Log In is processing...",
//                        "");



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
