package com.example.safe2load;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import database.helper.dao.pointcontrole_dao;
import database.helper.dao.users_dao;

public class Menu2Activity extends AppCompatActivity {

    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle actionBarDrawerToggle ;
    private long back_pressed ;
    private Toast toast ;
    Class saved_class ;

    Fragment fragment = null ;
    Class fragment_class = HomeFragment.class;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) ;
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view) ;
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContext(navigationView);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void selectItemDrawer(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home : fragment_class = HomeFragment.class; break;
            case R.id.operation : fragment_class = OperationFragment.class ; break;
            case R.id.stat_op_controle : fragment_class = StatFragment.class ; break;
            case R.id.synchro : fragment_class = SynchroFragment.class ; break;
            case R.id.parameter : fragment_class = ParamsFragment.class ; break;
            case R.id.discnonnect : {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this) ;
                alertDialog.setMessage("Êtes-vous sûr de vouloir se déconnecter ?")
                        .setCancelable(false)
                        .setPositiveButton("Oui", (dialog, which) -> {
                            Intent i = new Intent(Menu2Activity.this, MainActivity.class) ;
                            users_dao users_dao = new users_dao(this) ;
                            users_dao.disconnect();
                            startActivity(i); ;
                        })
                        .setNegativeButton("Non", (dialog, which) -> dialog.cancel()).create().show();
                fragment_class = saved_class;
                break;
            }
            default: fragment_class = HomeFragment.class ;
        }
        try {
            saved_class = fragment_class ;
            fragment = (Fragment) fragment_class.newInstance() ;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_content, fragment).commit() ;
        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }

    private void setupDrawerContext(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            selectItemDrawer(menuItem);
            return true;
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true ;
        }
        return super.onOptionsItemSelected(item) ;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data") ;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream() ;
            bitmap.compress(Bitmap.CompressFormat.PNG, 10, byteArrayOutputStream) ;
            byte[] bytes = byteArrayOutputStream.toByteArray() ;
            String encoded_image = Base64.encodeToString(bytes, Base64.DEFAULT) ;
            pointcontrole_dao pointcontrole_dao = new pointcontrole_dao(this) ;
            pointcontrole_dao.updateImage(encoded_image);
        }
        else {
            Log.d("tsy ato eh" , "khz") ;
        }
    }
}
