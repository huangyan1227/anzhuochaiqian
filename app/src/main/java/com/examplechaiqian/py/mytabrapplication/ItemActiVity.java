package com.examplechaiqian.py.mytabrapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.donkingliang.banner.CustomBanner;
import android.graphics.drawable.Drawable;
import android.widget.SearchView;

import java.util.ArrayList;

public class ItemActiVity extends Fragment implements View.OnClickListener {


    private CustomBanner<String> mBanner;
    private Button btn;
    private Button btn2;
    private Button btn1;
    private Button wbtn;
    private Button wbtn1;
    private Button wbtn2;
    private Button rbtn1;
    private Button rbtn2;
    private Button rbtn;
    private Drawable drawable;
    private Drawable drawable2;
    private Drawable drawable3;
    private Drawable drawable4;
    private Drawable drawable5;
    private Drawable drawable6;
    private Drawable drawable7;
    private Drawable drawable8;
    private Drawable drawable9;

    private SearchView mSearchView;

    private View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {





   if (null==view){

       Log.v("ItemActiVity","ItemActiVity");


       view =  inflater.inflate(R.layout.item_vp,container,false);


       mSearchView = (SearchView) view.findViewById(R.id.searchView);


       // 设置搜索文本监听
       mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           // 当点击搜索按钮时触发该方法
           @Override
           public boolean onQueryTextSubmit(String query) {

               Log.v("ItemActiVity",query);
               mSearchView.clearFocus();  //可以收起键盘
//                mSearchView.onActionViewCollapsed();    //可以收起SearchView视图
               return true;
           }

           /**
            * Called when the query text is changed by the user.
            *
            * @param newText the new content of the query text field.
            * @return false if the SearchView should perform the default action of showing any
            * suggestions if available, true if the action was handled by the listener.
            */
           @Override
           public boolean onQueryTextChange(String newText) {


               Log.v("ItemActiVity",newText);

               return false;
           }


       });


       mBanner =      view.findViewById(R.id.banner);

       btn =  view.findViewById(R.id.button2);
       btn1 = view.findViewById(R.id.button3);

       btn2 = view.findViewById(R.id.button1);
       wbtn = view.findViewById(R.id.tbutton1);
       wbtn2 = view.findViewById(R.id.tbutton2);
       wbtn1 = view.findViewById(R.id.tbutton3);
       rbtn = view.findViewById(R.id.rbutton11);
       rbtn1 = view.findViewById(R.id.rbutton2);
       rbtn2 = view.findViewById(R.id.rbutton3);



       ArrayList <String> images = new ArrayList<>();


       images.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3778456200,3076998411&fm=23&gp=0.jpg");
       images.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3535338527,4000198595&fm=23&gp=0.jpg");
       images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1017904219,2460650030&fm=23&gp=0.jpg");
       images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2863927798,667335035&fm=23&gp=0.jpg");
       images.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3885596348,1190704919&fm=23&gp=0.jpg");
       //images.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1597254274,1405139366&fm=23&gp=0.jpg");
       images.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3513269361,2662598514&fm=23&gp=0.jpg");

       mBanner.setIndicatorRes(R.drawable.shape_point_select,R.drawable.shape_point_unselect);



       setBean(images);

//        app:indicatorSelectRes="@drawable/shape_point_select"
//        app:indicatorUnSelectRes="@drawable/shape_point_unselect"


//        mBanner.setindicat

       addbutton();
   }







        return view;
    }



    private void addbutton(){




        drawable=getResources().getDrawable(R.drawable.chushou);
        //必须设置图片大小，否则不显示图片

        drawable.setBounds(0,0,180,180);


        drawable2=getResources().getDrawable(R.drawable.huishou);
        //必须设置图片大小，否则不显示图片

        drawable2.setBounds(0,0,180,180);




        drawable3=getResources().getDrawable(R.drawable.zichang);
        //必须设置图片大小，否则不显示图片

        drawable3.setBounds(0,0,180,180);




        drawable4=getResources().getDrawable(R.drawable.zhao);
        //必须设置图片大小，否则不显示图片

        drawable4.setBounds(0,0,180,180);



        drawable5=getResources().getDrawable(R.drawable.shengyi);
        //必须设置图片大小，否则不显示图片

        drawable5.setBounds(0,0,180,180);


        drawable6=getResources().getDrawable(R.drawable.kucun);
        //必须设置图片大小，否则不显示图片

        drawable6.setBounds(0,0,180,180);


        drawable7=getResources().getDrawable(R.drawable.wuzi);
        //必须设置图片大小，否则不显示图片

        drawable7.setBounds(0,0,180,180);


        drawable8=getResources().getDrawable(R.drawable.jixie);
        //必须设置图片大小，否则不显示图片

        drawable8.setBounds(0,0,180,180);


        drawable9=getResources().getDrawable(R.drawable.huoyun);
        //必须设置图片大小，否则不显示图片

        drawable9.setBounds(0,0,180,180);



        btn.setCompoundDrawables(null,drawable,null,null);



        btn1.setCompoundDrawables(null,drawable2,null,null);

        btn2.setCompoundDrawables(null,drawable3,null,null);




        wbtn1.setCompoundDrawables(null,drawable5,null,null);

        wbtn2.setCompoundDrawables(null,drawable6,null,null);

        wbtn.setCompoundDrawables(null,drawable4,null,null);


        rbtn.setCompoundDrawables(null,drawable7,null,null);

        rbtn1.setCompoundDrawables(null,drawable8,null,null);

        rbtn2.setCompoundDrawables(null,drawable9,null,null);



        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);


        wbtn.setOnClickListener(this);
        wbtn2.setOnClickListener(this);
        wbtn1.setOnClickListener(this);




        rbtn.setOnClickListener(this);
        rbtn2.setOnClickListener(this);
        rbtn1.setOnClickListener(this);



    }
    private  void  setBean(final  ArrayList<String> beans){


          mBanner.stopTurning();

        mBanner.setPages(new CustomBanner.ViewCreator<String>() {
            @Override
            public View createView(Context context, int i) {

                ImageView imageView = new ImageView(context);

                imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                return imageView;
            }

            @Override
            public void updateUI(Context context, View view, int i, String s) {

                Picasso.get().load(s).into((ImageView)view);

//                mBanner.startTurning();

            }
        },beans).startTurning(5000);





    }

    @Override
    public void onResume() {
        super.onResume();

        mBanner.startTurning(5000);
    }

    public void   onDestroy() {

        super.onDestroy();

        Log.v("ItemActi","消毁");


    }

//点击事件
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {



             String textData = ((Data)getActivity().getApplication()).getLogState();



      Log.v("ItemActiVity",textData);



        Intent intent = new Intent(getActivity(),ArticleActivity.class);

        switch (v.getId()){



            case R.id.button1:

                intent.putExtra("id","5");



                break;
            case R.id.button2:

                intent.putExtra("id","3");

                break;
            case R.id.button3:

                intent.putExtra("id","21");
                break;
            case R.id.tbutton1:

                intent.putExtra("id","12");
                break;

            case R.id.tbutton2:

                intent.putExtra("id","3,5,7");

                break;
            case R.id.tbutton3:

                intent.putExtra("id","7");

                break;

            case R.id.rbutton11:

                intent.putExtra("id","9");
                break;

            case R.id.rbutton2:

                intent.putExtra("id","30");
                break;

            case R.id.rbutton3:

                intent.putExtra("id","24");
                break;

                default:

                    break;





        }

        Log.v("ItemActiVity","点发发发击");

        startActivity(intent);

    }
}
