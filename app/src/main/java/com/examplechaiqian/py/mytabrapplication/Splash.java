package com.examplechaiqian.py.mytabrapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

public class Splash  extends Activity {


    private ImageView imageView;

    private final int SPLASH_DISPLAY_LENGHT = 2000;//两秒后进入系统，时间可自行调整
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

       imageView =  findViewById(R.id.imageView);


       imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ad));


        new  android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);

                Splash.this.finish();

            }
        },SPLASH_DISPLAY_LENGHT);



    }



}
