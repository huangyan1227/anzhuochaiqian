package com.examplechaiqian.py.mytabrapplication;

import android.content.Intent;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class Nework {

    public  void addNework(String name,String password){

//        Intent intent = getIntent();
//        String name = intent.getStringExtra("id");

//        Log.v("ArticleActivity",name);

        String url = "http://www.chaiqian88.com/afdglxt/Newapp/ios/login.php";


        Log.v("ArticleActivity",url);

      //  MediaType JSON = MediaType.parse("application/json; charset=utf-8");


     // RequestBody body =RequestBody.create(JSON,password);

        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", password)
                .build();



//      FormBody.Builder body = new FormBody.Builder().add("",name).add("",password);

//       RequestBody body = new RequestBody() {
//           @javax.annotation.Nullable
//           @Override
//           public MediaType contentType() {
//               return null;
//           }

//           @Override
//           public void writeTo(BufferedSink sink) throws IOException {
//
//           }
//       }


        OkHttpClient okHttpClient = new OkHttpClient();

        //new Request.Builder().url(url).post(body).build();
        final Request request = new Request.Builder()
                .url(url).post(formBody).build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.v("Tag","eff"+e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                 Log.v("TAG", "onResponse: " + response.body().string());

            //    parseJSONWithJSONObjec(response.body().string());

            }
        });




    }



}
