package com.example.safe2load;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;



public class SplashscreenActivity extends Activity {
    private static int SPLASH_TIMEOUT = 3000 ;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashscreenActivity.this, MainActivity.class) ;
                startActivity(i); ;
                finish();
            }
        }, SPLASH_TIMEOUT) ;
    }
}
