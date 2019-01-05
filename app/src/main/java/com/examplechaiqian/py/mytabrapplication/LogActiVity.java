package com.examplechaiqian.py.mytabrapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;

public class LogActiVity extends  Activity {


    private EditText et_username;
    private EditText et_password;
    private Button   bt_log;
    private Button   bt_registered;

    private ConstraintLayout constraintLayout;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        et_username = findViewById(R.id.et_username);

        et_password = findViewById(R.id.et_password);

        bt_log = findViewById(R.id.bt_log);

        ((Data)getApplication()).setLogState("你挺隧的");

        bt_registered = findViewById(R.id.bt_registered);

//        new ConstraintLayout(this).setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logbackground));

//     ConstraintLayout constraintLayout1 = new ConstraintLayout(this);
//         new  ConstraintLayout(R.layout.login).setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logbackground));
//

        constraintLayout = findViewById(R.id.logconstrain);

        constraintLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logbackground));

        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String strUsername = et_username.getText().toString();

                String strPassword = et_password.getText().toString();

                Nework nework = new Nework();

                String password =  hamcshal("123456789","chaiqian88");

                nework.addNework("哈哈哈",password);

                if (strUsername.equals("fff") && strPassword.equals("3333")) {



                    Toast.makeText(LogActiVity.this,"用户名和密码"+password,Toast.LENGTH_SHORT).show();

//                    finish();

                } else {

                    Toast.makeText(LogActiVity.this,"用户名和密码错误",Toast.LENGTH_SHORT).show();

                }
            }
        });


        bt_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                addTiao();
            }
        });



    }

   private  void  addTiao(){

        Log.v("LogActiVit","跳转");

       Intent intent = new Intent(LogActiVity.this,Registered.class);

       startActivity(intent);



   }
//    private void switchFragment(Fragment f) {
//
//
//        FragmentManager fragmentM = getSupportFragmentManager();//管理对象
//        FragmentTransaction trans = fragmentM.beginTransaction();//切换碎片
//        trans.replace(R.id.regional, f);
//        trans.commit();
//    }




    public static  String hamcshal(String data,String key){

        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            return byte2hex(mac.doFinal(data.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;


    }

    //二行制转字符串
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        //toUpperCase() 小写转换城大写
        return hs.toString();
    }


    public static void setce(String args) {
//        String genHMAC = genHMAC("123456789", "chaiqian88");

        String genH =hamcshal("123456789","chaiqian88");

        Log.v("MainActivity",genH+"你好");

    }


}
