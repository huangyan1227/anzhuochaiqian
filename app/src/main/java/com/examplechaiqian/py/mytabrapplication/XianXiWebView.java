package com.examplechaiqian.py.mytabrapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Response;

public class XianXiWebView  extends Activity  {


    private WebView   webView;
    private TextView  textView;
    private String    next;

    private MyLoading loading;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.xiangqingwebview);


        loading = findViewById(R.id.loading2);

      //  Intent intent = getIntent();

     //   String classIdname =  intent.getStringExtra("classid");

       // String idname = intent.getStringExtra("id");

        //intent1.putExtra(juXianQing.getIdString(),"childidString");

      //  String childidString = intent.getStringExtra("childidString");


//
//        intent1.putExtra(juXianQing.getTitle(),"title");

    //   String titleString = intent.getStringExtra("title");


    //   Log.v("Makkkk",classIdname+"---"+"---"+childidString + "------"+titleString);

//

        webView = findViewById(R.id.webView);

        textView = findViewById(R.id.xiqingtextView);

        webView.getSettings().setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        loading.start();

//        String st = "<p style=\"text-align: center;\"><img src=\"/d/file/xwzx/jszx/2018-12-26/85cc5d497cb8a1ab77478365657ebbc6.jpg\" alt=\"铜早盘小幅高开后迅速跳水.jpg\" width=\"321\" height=\"261\" /></p><p>&nbsp;</p><p>　　12月26日，comex铜圣诞节后恢复交易，早盘小幅高开后迅速跳水，其中03月合约(hgh9)最新报2.6635美元/磅，日上涨0.08%。</p><p>&nbsp;</p><p>　　国际衍生品智库分析师认为，因美国政府正陷入部分关门，白宫和美联储公开对抗，特朗普在政府停摆的背景下选择放弃假期孤守白宫，使市场避险情绪增加，铜价上行受阻。</p><p>&nbsp;</p> <p>　　但近期美元指数走势疲软，亦提振了低迷的铜市信心，短期多空交织，comex铜或以震荡为主。</p><p>&nbsp;</p><p>　　建议comex铜3月合约可以考虑在2.65-2.70美元/磅进行高抛低吸，止损各0.02美元/磅。</p>";
//
//        String k=     st.replaceAll("<img src=\"","<img src=\"http://www.chaiqian88.com");
//
//        Log.v("Mall",st);
//
//        Log.v("Mall",k);
//
//

       // webView.loadUrl("http://www.chaiqian88.com/jsbjtj/");
//
//        webView.loadDataWithBaseURL(null,"<html><head><title> </title></head>" +
//                "<body>"+k+"</body></html>", "text/html" , "utf-8", null);


        addNework();

        webView.setWebViewClient(new WebViewClient(){


//            public void onProgressChanged(WebView view, int progress)
//                {
//                    //当进度走到100的时候做自己的操作，我这边是弹出dialog
//
//                }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                loading.cancel();
                loading.setVisibility(View.INVISIBLE);


            }
        });

    }

    private void  addNework(){

        Intent intent = getIntent();

        String classIdname =  intent.getStringExtra("classid");

        // String idname = intent.getStringExtra("id");

        //intent1.putExtra(juXianQing.getIdString(),"childidString");

        String childidString = intent.getStringExtra("childidString");


//
//        intent1.putExtra(juXianQing.getTitle(),"title");

        String titleString = intent.getStringExtra("title");


        Log.v("Makkkk",classIdname+"---"+"---"+childidString + "------"+titleString);
        //http://www.chaiqian88.com/afdglxt/Newapp/ios/newsx.php?lx=news&classid=%@&id=%@

        textView.setText(titleString);

         OkHttpClient  okHttpClient = new OkHttpClient();

        String url = "http://www.chaiqian88.com/afdglxt/Newapp/ios/newsx.php?lx=news"+"&classid="+classIdname+"&id="+childidString;



         final  Request request = new Request.Builder().url(url).get().build();

         Call call = okHttpClient.newCall(request);


         call.enqueue(new Callback() {

             @Override
             public void onFailure(Call call, IOException e) {



             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {

                 pasent(response.body().string());


             }
         });

    }

    private void pasent(String stirng ){


        try {


//            JSONArray jsonArray = new JSONArray(stirng);

          JSONObject jsonObject = new JSONObject(stirng);



//            for (int i =0; i<jsonArray.length();i++){

           //     Map<String, Object> showitem = new HashMap<String, Object>();
              //\  JSONObject jsonObject = jsonArray.getJSONObject(i);

                next = (String) jsonObject.getString("newstext");

            //    ShuJuXianQing shuJuXianQing = new ShuJuXianQing();

              //  shuJuXianQing.setTitle(jsonObject.getString("title"));

                //shuJuXianQing.setRegionalString(jsonObject.getString("pro")+"-"+jsonObject.getString("city"));

                //  shuJuXianQing.setPhoto(R.drawable.ad);

             //   shuJuXianQing.setImageString(jsonObject.getString("titlepic"));

                //shuJuXianQing.setTimeString(jsonObject.getString("time"));

              //  shuJuXianQing.setIdString(jsonObject.getString("id"));

                //   Log.v("LLL",jsonObject.getString("title")+"eee");

              //  showitem.put("studt",shuJuXianQing);

//                shuJuXianQingList.add(showitem);

           //     shuJuXianQingListxinwen.add(showitem);;

            Log.v("LLL",next+"-----===++++----++++----+++++----");

//            }



            //回到主线程

            Handler mainHandler = new Handler(Looper.getMainLooper());

           // final String finalNext = next;
            mainHandler.post(new Runnable() {
                @Override
                public void run() {

                    //已在主线程中，可以更新UI


                String b = next.replace("\\\"","\"");

                String c =b.replace("421","300");

                String a =  c.replaceAll("/d","http://www.chaiqian88.com/d");



                    webView.loadDataWithBaseURL(null,"<html><head><title> </title></head>" +
                            "<body>"+a+"</body></html>", "text/html" , "utf-8", null);



                }
            });



        }

        catch (Exception e)
        {
            e.printStackTrace();

        }


        Log.v("enm",stirng);



    }
}
