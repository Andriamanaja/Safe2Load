package com.example.safe2load;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.safe2load.Fragment.CLCC_dechargement_Fragment;

public class Menu2Activity extends AppCompatActivity {

    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle actionBarDrawerToggle ;
    CLCC_dechargement_Fragment clcc_dechargement_fragment;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) ;
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view) ;
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContext(navigationView);
        /*clcc_dechargement_fragment = (CLCC_dechargement_Fragment) this.getSupportFragmentManager().findFragmentById(R.id.fragmnt_prnt) ;
        clcc_dechargement_fragment.addPage("TEST");*/
    }

    public void fill_fragment () {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void selectItemDrawer(MenuItem item) {
        Fragment fragment = null ;
        Class fragment_class ;
        switch (item.getItemId()) {
            case R.id.home : fragment_class = HomeFragment.class; break;
            case R.id.operation : fragment_class = OperationFragment.class ; break;
            case R.id.stat_op_controle : fragment_class = StatFragment.class ; break;
            case R.id.synchro : fragment_class = SynchroFragment.class ; break;
            case R.id.parameter : fragment_class = ParamsFragment.class ; break;
            default: fragment_class = HomeFragment.class ;
        }
        try {
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
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer(menuItem );
                return true;
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true ;
        }
        return super.onOptionsItemSelected(item) ;
    }
}
