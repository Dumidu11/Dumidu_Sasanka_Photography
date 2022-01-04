package com.example.dumidusasankaphotography;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    public  int[] imageArray={

            R.drawable.pic20,R.drawable.pic21,R.drawable.pic22,
            R.drawable.pic23,R.drawable.pic24,R.drawable.pic25,
            R.drawable.pic26,R.drawable.pic27,R.drawable.pic28,
            R.drawable.pic30,R.drawable.pic31,R.drawable.pic32,
            R.drawable.pic33,R.drawable.pic34,R.drawable.pic35,
            R.drawable.pic36,R.drawable.pic37,R.drawable.pic38,
            R.drawable.pic39,R.drawable.pic40,R.drawable.pic41,
            R.drawable.pic42,R.drawable.pic43,R.drawable.pic44,
            R.drawable.pic45,R.drawable.pic46,R.drawable.pic47,


    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new AbsListView.LayoutParams(340,350));


        return imageView;
    }
}
