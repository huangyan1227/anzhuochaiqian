package com.examplechaiqian.py.mytabrapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.examplechaiqian.py.mytabrapplication.CountDownTimerButton;

public class Registered  extends Activity {

//    private Button timeBtn;
    private CountDownTimerButton timerButton;

    private ConstraintLayout constraintLayout;



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registered);

        Log.v("fff","创建");

        timerButton = findViewById(R.id.yangzhanmabutton);

        constraintLayout = findViewById(R.id.registeredconstraint);

        constraintLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.resg1));

        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//          timerButton.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View v) {
//                  Toast.makeText(Registered.this, "倒计时开始", Toast.LENGTH_SHORT).show();
//              }
//          });
    }
}
