package com.examplechaiqian.py.mytabrapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.List;

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {


//    private Button btn;
//    private ViewPager myViewPager;
//    private Context ctx;
//    private FragmentManager fragmentManager;
  //  private List<Fragment> list;
     //  private v adapter;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        initUI();
//


    }

    private  void  initUI(){


          final ViewPager viewPager = findViewById(R.id.vp_horizontal_ntb);
            ArrayList list = new ArrayList<Fragment>();

        list.add(new ItemActiVity());
        list.add(new ItemActiVity1());
        list.add(new ItemActiVity2());//这里把你要绑定的Fragment添加进去
        list.add(new ItemActiVity3());
        list.add(new ItemActiVity4());//


            viewPager.setAdapter(new myFragmentPagerAdapter(getSupportFragmentManager(),list));

//
//               fragments.add(new ItemActiVity());
//               fragments.add(new ItemActiVity1());
//               fragments.add(new ItemActiVity2());
//               fragments.add(new ItemActiVity3());
//               fragments.add(new ItemActiVity4());
//        FragmentStatePagerAdapter
//               viewPager = (ViewPager) findViewById(R.id.viewPager);
     //   FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager(), viewPager, fragments) {





//      Fragment fragment1 =  new ItemActiVity1();

//        viewPager.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return 5;
//            }
//
//            @NonNull
//            @Override
//            public Object instantiateItem(@NonNull ViewGroup container, int position) {
//
//                Fragment fragment = fragments.get(position);
//                if(!fragment.isAdded()){ // 如果fragment还没有added
//                    FragmentTransaction ft = fragmentManager.beginTransaction();
//                    ft.add(fragment, fragment.getClass().getSimpleName());
//                    ft.commit();
//                    /**
//                     * 在用FragmentTransaction.commit()方法提交FragmentTransaction对象后
//                     * 会在进程的主线程中，用异步的方式来执行。
//                     * 如果想要立即执行这个等待中的操作，就要调用这个方法（只能在主线程中调用）。
//                     * 要注意的是，所有的回调和相关的行为都会在这个调用中被执行完成，因此要仔细确认这个方法的调用位置。
//                     */
//                    fragmentManager.executePendingTransactions();
//                }
//
//                if(fragment.getView().getParent() == null){
//                    container.addView(fragment.getView()); // 为viewpager增加布局
//                }
//
//                Log.v("Ac")
//                return fragment.getView();
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//
//
//
//                return view.equals(o);
//            }
//
//
//            @Override
//            public void destroyItem(final View container, final int position, final Object object) {
//
//
//                ((ViewPager) container).removeView((View) object);
//            }
//
//        });
//

//
//          viewPager.setAdapter(new PagerAdapter() { //zhe
//              @Override
//              public int getCount() {
//                  return 5;
//              }
//
////
//
//              @Override
//              public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//                  return view.equals(o);
//              }
//
//
//
//              @Override
//              public Object instantiateItem(final ViewGroup container, final int position) {
//
//
//
////                                    txtPage.setText(String.format("item_vp#%d", position));
//                  if (position==0){
//
//
//
//                      final View view = LayoutInflater.from(
//                              getBaseContext()).inflate(R.layout.item_vp, container, false);
//
//                      container.addView(view);
//
//
//                      final TextView txtPage = (TextView) view.findViewById(R.id.txt_vp_item_page);
//
//                      txtPage.setText(String.format("Page #%d", position));
//
//
//
//                      return view;
//
//                  }else if (position==1){
////            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new ItemActiVity1()).commit();
////                      LayoutInflater.from(getBaseContext()).inflate()
//
//
//                      final View view = LayoutInflater.from(
//                               getBaseContext()).inflate(R.layout.item_vp1, container, false);
//
//                       container.addView(view);
//
//
//
//                      final TextView txtPage = (TextView) view.findViewById(R.id.txt_vp_item_page);
//
//                      txtPage.setText(String.format("Page #%d", position));
//
//
//
//                      btn =  (Button) view.findViewById(R.id.buttonClick);
//
//                      Log.v("ItemActiVity1", String.valueOf(view)+"i123");
//                      btn.setOnClickListener(new View.OnClickListener() {
//                          @Override
//                          public void onClick(View v) {
//
//                              Log.v("ItemActiVity1","跳7dfsa转");
//
//
////                              getSupportFragmentManager().beginTransaction().replace(R.id.container,new OthenFragment()).commit();
//
//                             // startActivity(new Intent(MainActivity.this,ArticleActivity.class));
//
//                          }
//                      });
//
//
//
//
//
//
//
//
//
//
//                      return view;
//
//
//                  }else if (position==2){
//
//                      final View view = LayoutInflater.from(
//                              getBaseContext()).inflate(R.layout.item_vp2, null, false);
//
//                      container.addView(view);
//
//
//                      final TextView txtPage = (TextView) view.findViewById(R.id.txt_vp_item_page);
//
//                      txtPage.setText(String.format("Page #%d", position));
//
//                      return view;
//                  }else if (position==3){
//
//                      final View view = LayoutInflater.from(
//                              getBaseContext()).inflate(R.layout.item_vp3, null, false);
//
//                      container.addView(view);
//
//
//                      final TextView txtPage = (TextView) view.findViewById(R.id.txt_vp_item_page);
//
//                      txtPage.setText(String.format("Page #%d", position));
//
//                      return view;
//
//                  }else {
//
//                      final View view = LayoutInflater.from(
//                              getBaseContext()).inflate(R.layout.item_vp4, null, false);
//
//                      container.addView(view);
//
//
//                      final TextView txtPage = (TextView) view.findViewById(R.id.txt_vp_item_page);
//
//                      txtPage.setText(String.format("Page #%d", position));
//
//                      return view;
//
//
//
//                  }
//
//
////                  container.addView(view1);
////                  return view;
//              }

//              @Override
//              public void destroyItem(final View container, final int position, final Object object) {
//
//
//                  ((ViewPager) container).removeView((View) object);
//              }
//
//
//
//
//
//
//
//          });



        final String[] colors = getResources().getStringArray(R.array.default_preview);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_first),
                        Color.parseColor(colors[0]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("拆迁")
//                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_second),
                        Color.parseColor(colors[1]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("商机")
//                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_third),
                        Color.parseColor(colors[2]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_seventh))
                        .title("发布")
//                        .badgeTitle("state")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fourth),
                        Color.parseColor(colors[3]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("活动")
//                        .badgeTitle("icon")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[4]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("管家")
                        .build()
        );


        navigationTabBar.setModels(models);
//        navigationTabBar.getModels().hideBadge();


        navigationTabBar.setViewPager(viewPager, 0);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                navigationTabBar.getModels().get(position).hideBadge();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

//        navigationTabBar.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
//                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
////                    navigationTabBar.postDelayed(new Runnable() {
////                        @Override
////                        public void run() {
////                          //  model.showBadge();
////                        }
////                    }, i * 100);
//                }
//            }
//        }, 500);
   }



}




