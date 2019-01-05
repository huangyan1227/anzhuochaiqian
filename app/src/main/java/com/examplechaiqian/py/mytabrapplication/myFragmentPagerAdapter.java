package com.examplechaiqian.py.mytabrapplication;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.view.View;


import java.util.List;

public class myFragmentPagerAdapter extends FragmentPagerAdapter {
     
    private FragmentManager fragmetnmanager;  //创建FragmentManager
    private List<Fragment> listfragment; //创建一个List<Fragment>//定义构造带两个参数
    public myFragmentPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.fragmetnmanager=fm;
        this.listfragment=list;
    }
 
    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return listfragment.get(arg0); //返回第几个fragment
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listfragment.size(); //总共有多少个fragment
    }

    //            @Override
//            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//
//
//
//                return view.equals(o);
//            }

    //            @Override
//            public void destroyItem(final View container, final int position, final Object object) {
//
//
//                ((ViewPager) container).removeView((View) object);
//            }
//
//        });


//    @Override
////    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
////        super.destroyItem(container, position, object);
////
////        ((ViewPager) container).removeView((View) object);
////
////    }
}