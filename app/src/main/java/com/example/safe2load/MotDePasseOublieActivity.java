package com.example.safe2load;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.safe2load.SynchroUtils.SynchroController;

import org.json.JSONObject;

import database.helper.dao.res_users_dao;
import database.helper.dao.users_dao;
import okhttp3.RequestBody;

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
            


            try {
                users_dao users_dao = new users_dao(getBaseContext());
                JSONObject users_model = users_dao.get_users_model_for_sync(emailEditText.getText().toString());
                if (!users_model.equals(null)) {
                    requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), users_model.toString());
                    synchroController.UsersFromOneline(requestBody);
                }
                else{
                    Toast.makeText(getBaseContext(), "message", Toast.LENGTH_LONG).show();
                }
            }
        catch (Exception e){
e.printStackTrace();

}
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
    }
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
