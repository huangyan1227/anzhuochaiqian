package com.examplechaiqian.py.mytabrapplication;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import  android.content.Context;

import  android.widget.ImageView;

import  android.widget.TextView;

import  com.squareup.picasso.Picasso;

public class MyAdapter extends BaseAdapter {

    HashMap<Integer,View> lmap = new HashMap<Integer,View>();

    private  List<Map<String,Object>> shuJuXianQingsList;

    private  LayoutInflater inflater;

    private View view;



     public MyAdapter(List<Map<String,Object>> shuJuXianQingsList ,Context context){

         this.shuJuXianQingsList = shuJuXianQingsList;

         this.inflater = LayoutInflater.from(context);


     }
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */

    @Override
    public int getCount() {
        return shuJuXianQingsList == null ? 0 : shuJuXianQingsList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {


        return shuJuXianQingsList.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @SuppressLint("WrongConstant")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      ViewHolder holder=null;

        if (convertView==null){


            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.layout_shujuxianqing_item,null);


            holder.image_photo = (ImageView) convertView.findViewById(R.id.image_photo);
            holder.tv_name = (TextView) convertView.findViewById(R.id.title);
            holder.tv_age = (TextView) convertView.findViewById(R.id.regional);

           holder.tvTele =(TextView) convertView.findViewById(R.id.tell);


            lmap.put(position, convertView);
            convertView.setTag(holder);





//        ShuJuXianQing shuJuXianQing = (ShuJuXianQing) getItem(position);



      //   holder.tvTele.setVisibility(0);



    // }

        }else {


            holder = (ViewHolder) convertView.getTag();
        }




        ShuJuXianQing shuJuXianQing = (ShuJuXianQing) shuJuXianQingsList.get(position).get("studt");

        //if (shuJuXianQing != null){



        ///d/file/sybanner/2018-10-23/1e184615665d4cd9a6bb82949d1614b0.png

        Picasso.get().load("http://www.chaiqian88.com"+shuJuXianQing
                .getImageString()).tag("landptf").into(holder.image_photo);


        //   holder.image_photo.setVisibility(0);

        holder.tv_name.setText(shuJuXianQing.getTitle());

        //   holder.tv_name.setVisibility(0);

        holder.tv_age.setText(String.valueOf(shuJuXianQing.getRegionalString()));

        //   holder.tv_age.setVisibility(0);

        holder.tvTele.setText(shuJuXianQing.getTimeString());


        return convertView;
    }


    public void  updateView(List<Map<String,Object>> nolist){

        this.shuJuXianQingsList = nolist;

        this.notifyDataSetChanged();//强制动态刷新数据进而调用getView方法



    }

   private static class ViewHolder{
        TextView tv_name;
        TextView tv_age;
        TextView tvTele;
        ImageView image_photo;
    }
}
