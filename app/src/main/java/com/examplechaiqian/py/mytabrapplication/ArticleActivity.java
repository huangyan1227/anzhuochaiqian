package com.examplechaiqian.py.mytabrapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;
import java.util.Map;

import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import android.os.Handler;
import android.content.Intent;
import com.squareup.picasso.Picasso;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

//import androidx.annotation.Nullable;

public class ArticleActivity extends Activity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener,OnLoadMoreListener {


    public List< Map<String,Object>> shuJuXianQingList = new ArrayList<>();

    private ListView listView;

    private MyAdapter adapter;

    private MyLoading loading;

    private int page =0;

    private boolean isRefresh = false;//是否刷新

    private RefreshLayout refreshLayout;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity);

        loading = findViewById(R.id.loading);

        refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout);

//        intent = getIntent();
        //    MyLoading loading1 = new MyLoading(this,"")

//       refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
    //  refreshLayout.setEnableRefresh(true);//启用刷新SpinnerStyle.Scale
//        refreshLayout.setEnableLoadmore(true);//启用加载
        refreshLayout.setEnableAutoLoadMore(true);

      //refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(ClassicsFooter));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

        loading.setCurrentProgress(2);

        loading.start();


        addBaseList();

        addNework();



    }


    private  void  addBaseList(){


         listView = findViewById(R.id.listview);



    //    adapter = new MyAdapter(shuJuXianQingList,ArticleActivity.this );

        adapter = new MyAdapter(shuJuXianQingList, ArticleActivity.this);
      ///  listView.setAdapter(adapter);

         listView.setOnItemClickListener(this);

         listView.setOnScrollListener(this);



    }



  //网路加载
    public  void addNework(){

        Intent intent = getIntent();

        String name = intent.getStringExtra("id");


        //把请求的内容字符串转换为json
       // RequestBody body = RequestBody.create(JSON, json);

       String url = "http://www.chaiqian88.com/afdglxt/Newapp/ios/iosfangfa.php?sdk=synews&bq=0&bqz=null"+"&classid="+name+"&sx=new&sxz=null"+"&qs="+page+"&sl=8";

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();

        Call call = okHttpClient.newCall(request);



        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                //Log.v("Tag","eff"+e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

               // Log.v("TAG", "onResponse: " + response.body().string());

                 parseJSONWithJSONObjec(response.body().string());

               // parJS(response.body().string());


            }
        });




    }



    private void parseJSONWithJSONObjec(String JsonData){

       try {


           JSONArray jsonArray = new JSONArray(JsonData);


           for (int i =0; i<jsonArray.length();i++){


               JSONObject jsonObject = jsonArray.getJSONObject(i);

                  Map<String, Object> showitem = new HashMap<String, Object>();

                   ShuJuXianQing shuJuXianQing = new ShuJuXianQing();

                   shuJuXianQing.setTitle(jsonObject.getString("title"));

                   shuJuXianQing.setRegionalString(jsonObject.getString("pro")+"-"+jsonObject.getString("city"));

                   shuJuXianQing.setPhoto(R.drawable.ad);

                   shuJuXianQing.setImageString(jsonObject.getString("titlepic"));

                   shuJuXianQing.setTimeString(jsonObject.getString("time"));

                   shuJuXianQing.setIdString(jsonObject.getString("id"));

                    showitem.put("studt",shuJuXianQing);

                    shuJuXianQingList.add(showitem);



           }



          //回到主线程

           Handler mainHandler = new Handler(Looper.getMainLooper());

           mainHandler.post(new Runnable() {
               @Override
               public void run() {
                   //已在主线程中，可以更新UI

                   Log.v("LLL", "主线程"+String.valueOf(Thread.currentThread()));

                   loading.cancel();

                //   if (isRefresh){


                   loading.setVisibility(View.INVISIBLE);



               //    }else {




                       listView.setAdapter(adapter);

                  // }

               }
           });



       }

       catch (Exception e)
       {
           e.printStackTrace();

       }





    }




    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = getIntent();

     //   Log.v("MainActivity", String.valueOf(position));

      //  String name = intent.getStringExtra("id");

        Intent intent1 = new Intent(ArticleActivity.this,XianXiWebView.class);

//        ShuJuXianQing  juXianQing =  shuJuXianQingList.;
//
//       intent1.putExtra(name,"classid");
//
//       intent1.putExtra(juXianQing.getIdString(),"childidString");
//
//       intent1.putExtra(juXianQing.getTitle(),"title");
//
//       intent1.putExtra(juXianQing.getImageString(),"titlepic");
//

       startActivity(intent1);

       // Log.v("MainActivity", juXianQing.getIdString()+"你啊凯迪拉克"+name);


    }

    /**
     * Callback method to be invoked while the list view or grid view is being scrolled. If the
     * view is being scrolled, this method will be called before the next frame of the scroll is
     * rendered. In particular, it will be called before any calls to
     * {@link }.
     *
     * @param view        The view whose scroll state is being reported
     * @param scrollState The current scroll state. One of
     *                    {@link #SCROLL_STATE_TOUCH_SCROLL} or {@link #SCROLL_STATE_IDLE}.
     */



    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {




        if (scrollState==0){

            Picasso.get().resumeTag("landptf");
          //  Log.v("ArticleActivity","停止");


        }else {
          //  Log.v("ArticleActivity","开始");
            Picasso.get().pauseTag("landptf");


        }

    }



    /**
     * Callback method to be invoked when the list or grid has been scrolled. This will be
     * called after the scroll has completed
     *
     * @param view             The view whose scroll state is being reported
     * @param firstVisibleItem the index of the first visible cell (ignore if
     *                         visibleItemCount == 0)
     * @param visibleItemCount the number of visible cells
     * @param totalItemCount   the number of items in the list adaptor
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

       // Log.v("ArticleActivity","开始滚动完成");

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    //    Log.v("MainActivity","加了");
//        listView.setAdapter(adapter);

   //     Log.v("G", "主线程gggggg"+String.valueOf(Thread.currentThread()));

        if (!isRefresh){

            isRefresh = true;

           page = page+8;

          loadNework();




        }




    }



    //网路加载
    public  void loadNework(){

        Intent intent = getIntent();

        String name = intent.getStringExtra("id");

        //Log.v("ArticleActivity",name);


//        String json = "{"+"'sdk':"+"synews"+","+"'bq':"+"0"+","+"'bqz':"+"null"+","+"'classid':"+name+","+"'sx':"+"new"+","+"'sxz':"+"null"+","+"'qs':"+page+","+"'sl':"+8+ "}";

        //把请求的内容字符串转换为json
//        RequestBody body = RequestBody.create(JSON, json);

//        String url = "http://www.chaiqian88.com/afdglxt/Newapp/ios/iosfangfa.php?";

        String url = "http://www.chaiqian88.com/afdglxt/Newapp/ios/iosfangfa.php?sdk=synews&bq=0&bqz=null"+"&classid="+name+"&sx=new&sxz=null"+"&qs="+page+"&sl=8";

    // Log.v("G",String.valueOf(page)+"-----------------------------------" + url);

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();

         Call call = okHttpClient.newCall(request);

         call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

             //   Log.v("Tag","eff"+e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Log.v("TAG", "onResponse: " + response.body().string());

             loadJspon(response.body().string());

            }
        });




    }

    private void loadJspon(final String JsonData){




//   final  String jsonData =  JsonData;

            //回到主线程

            Handler mainHandler = new Handler(Looper.getMainLooper());

            mainHandler.post(new Runnable() {
                @Override
                public void run() {




                    try {

//                        shuJuXianQingList.clear();

                        JSONArray jsonArray = new JSONArray(JsonData);


                        for (int i = 0; i < jsonArray.length(); i++) {

                            Map<String, Object> showitem = new HashMap<String, Object>();


                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            ShuJuXianQing shuJuXianQing = new ShuJuXianQing();

                            shuJuXianQing.setTitle(jsonObject.getString("title"));

                            shuJuXianQing.setRegionalString(jsonObject.getString("pro") + "-" + jsonObject.getString("city"));

                            shuJuXianQing.setPhoto(R.drawable.ad);

                            shuJuXianQing.setImageString(jsonObject.getString("titlepic"));

                            shuJuXianQing.setTimeString(jsonObject.getString("time"));

                          //  Log.v("LLL", jsonObject.getString("title") + "eee");

                            showitem.put("studt",shuJuXianQing);

                           shuJuXianQingList.add(showitem);

                        //    Log.v("G",jsonObject.getString("title"));




                        }





                    }

                    catch (Exception e)
                    {
                        e.printStackTrace();

                    }




                      //  Log.v("G","结束");
                    //已在主线程中，可以更新UI
                   // adapter.notifyDataSetChanged();


                    if(adapter == null)
                    {
                        adapter=new MyAdapter(shuJuXianQingList,ArticleActivity.this);
                        listView.setAdapter(adapter);
                    }else
                    {
//                        adapter.updateView(shuJuXianQingList);



                    }

                    adapter.notifyDataSetChanged();


                    isRefresh = false;

                    refreshLayout.finishLoadMore();

                }
            });










    }

//    @Override
//    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//
//        Log.v("MainActivity","加了more");
//        refreshLayout.finishRefresh();
//
//    }
}
