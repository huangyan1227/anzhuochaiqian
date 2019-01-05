package com.examplechaiqian.py.mytabrapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class ItemActiVity1 extends Fragment implements View.OnClickListener {

             private Button btn;
             private Button newsbtn;
             private Button membersbtn;
             private Button casebtn;
             private Button introducedbtn;
             private Button feiguang;
             private Button feilv;
             private Button feitong;
             private Button feibuxiu;
             private Button feizhi;
             private Button feisuoliao;

             private Drawable drawablefeigang;
             private Drawable drawablefeilv;
             private Drawable drawablefeitong;
             private Drawable drawablefeibuxiu;
             private Drawable drawablefeizhi;
             private Drawable drawablefeisuliao;

             private TextView textView;
             private View view;

             private  FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Log.v("ItemActiVity1","跳方法fd转");

//         View view = null;

        if (view == null) {


            view = inflater.inflate(R.layout.item_vp1, container, false);

            fragmentManager = getFragmentManager();

     //添加button

     feiguang = view.findViewById(R.id.button1);

     feilv = view.findViewById(R.id.button2);

     feitong = view.findViewById(R.id.button3);

     feibuxiu =view.findViewById(R.id.tbutton1);

     feizhi = view.findViewById(R.id.tbutton2);

     feisuoliao = view.findViewById(R.id.tbutton3);



    newsbtn = view.findViewById(R.id.newsbtnClick);

    casebtn = view.findViewById(R.id.caseClick);

    membersbtn = view.findViewById(R.id.membersClick);

    introducedbtn = view.findViewById(R.id.introducedClick);







//        View view = inflater.inflate(R.layout.item_vp1,container,false);
     //   Log.v("ItemActiVity1","跳fffggh转");
//        Log.v("ItemActiVity1","跳转");

//      textView =  view.findViewById(R.id.textkk);


      //textView.setText("你好");

            addButton();

      //   btn =  (Button) view.findViewById(R.id.buttonClick);
   //按钮点击不好使
        Log.v("ItemActiVity1", String.valueOf(view));
   //      btn.setOnClickListener(new View.OnClickListener() {
          //   @Override
         //    public void onClick(View v) {

                 Log.v("ItemActiVity1","跳7000fsa转");

                 //if (savedInstanceState == null) {
//                                getFragmentManager()
//                                         .beginTransaction()
//                                        .add(R.id.fragment_container, new OthenFragment())
//                                        .commit();
                           //  }
//     getActivity().getSupportFragmentManager().beginTransaction()
//                         .add(R.id.containerg, new OthenFragment(), null)
//                         .addToBackStack(null)
//                         .commit();
//                 getActivity().getSupportFragmentManager()
//                         .beginTransaction()
//                         .replace(R.id.fragment_container, new OthenFragment(), null)
//                         .addToBackStack(null)
//                         .commit();



//                 getActivity().getSupportFragmentManager()
//                         .beginTransaction()
//                         .replace(R.id.itm1, new OthenFragment(), null)
//                         .addToBackStack(null)
//                         .commit();



                 //跳转另一个Active
//
          //       Intent intent = new Intent(getActivity(),LogActiVity.class);

            //     startActivity(intent);
//                 Intent intent = new Intent(getActivity(),LogActiVity.class);
//                 startActivity(intent);
             // getFragmentManager().beginTransaction().add(ItemActiVity1(), OthenFragment()).commit();

//                 startActivity(new Intent(new MainActivity(),ArticleActivity.class));

               //  startActivity(new Intent(new ItemActiVity(),ArticleActivity.class));
               //  startActivity(new Intent(ItemActiVity1.this,ArticleActivity.class));

          //   }

           //  private FragmentManager getSupportFragmentManager() {
//                 return null;
//             }
      //   });

        }

        return view;
    }

    private void  addButton(){


        drawablefeigang=getResources().getDrawable(R.drawable.feigang);
        //必须设置图片大小，否则不显示图片

        drawablefeigang.setBounds(0,0,180,180);


        drawablefeilv = getResources().getDrawable(R.drawable.feilv);

        drawablefeilv.setBounds(0,0,180,180);


        drawablefeitong = getResources().getDrawable(R.drawable.feitong);

        drawablefeitong.setBounds(0,0,180,180);

        drawablefeibuxiu = getResources().getDrawable(R.drawable.buxiugang);

        drawablefeibuxiu.setBounds(0,0,180,180);

        drawablefeizhi = getResources().getDrawable(R.drawable.feizhi);

        drawablefeizhi.setBounds(0,0,180,180);

        drawablefeisuliao = getResources().getDrawable(R.drawable.suoliao);

        drawablefeisuliao.setBounds(0,0,180,180);


        feiguang.setCompoundDrawables(null,drawablefeigang,null,null);

        feilv.setCompoundDrawables(null,drawablefeilv,null,null);

        feitong.setCompoundDrawables(null,drawablefeitong,null,null);

        feibuxiu.setCompoundDrawables(null,drawablefeibuxiu,null,null);

        feizhi.setCompoundDrawables(null,drawablefeizhi,null,null);

        feisuoliao.setCompoundDrawables(null,drawablefeisuliao,null,null);


        feiguang.setOnClickListener(this);

        feilv.setOnClickListener(this);

        feitong.setOnClickListener(this);

        feibuxiu.setOnClickListener(this);

        feizhi.setOnClickListener(this);

        feisuoliao.setOnClickListener(this);

        newsbtn.setOnClickListener(this);

        casebtn.setOnClickListener(this);

        membersbtn.setOnClickListener(this);

        introducedbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(),XinWenActivity.class);

        Intent intent1 = new Intent(getActivity(),PingTaiJieShou.class);

        switch (v.getId()){

            case R.id.newsbtnClick:

                intent.putExtra("id","27");

                startActivity(intent);

                Log.v("My","00000llllllllnewsbtnClick");


//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.item1, new News());
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();



                break;

            case R.id.caseClick:

                intent.putExtra("id","36");

                startActivity(intent);

                Log.v("My","00000llllllllcaseClick");

                break;

            case R.id.membersClick:

                Log.v("My","00000llllllllmembersClick");

                break;


            case R.id.introducedClick:


                startActivity(intent1);

                Log.v("My","00000llllllllmembersClickintroducedClick");

                break;

            case R.id.button1:


                Log.v("My","00000llllllll");

                break;
            case R.id.button2:


                Log.v("My","0000011111111");
                break;

            case R.id.button3:

                Log.v("My","0000022222222");
                break;

            case R.id.tbutton1:

                Log.v("My","0000033333333");
                break;

            case R.id.tbutton2:

                Log.v("My","0000044444444");
                break;

            case R.id.tbutton3:

                Log.v("My","0000055555555");

                break;


                default:

                    break;






        }




    }


    //    public void switchContent(Fragment from, Fragment to, int position) {
////        if (mContent != to) {
////            mContent = to;
////            FragmentTransaction transaction = fm.beginTransaction();
////            if (!to.isAdded()) { // 先判断是否被add过
////                transaction.hide(from)
////                        .add(R.id.content_frame, to, tags[position]).commit(); // 隐藏当前的fragment，add下一个到Activity中
////            } else {
////                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
////            }
////        }
////    }


}
