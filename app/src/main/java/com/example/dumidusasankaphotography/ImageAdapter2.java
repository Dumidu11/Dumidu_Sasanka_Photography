package com.example.dumidusasankaphotography;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter2 extends BaseAdapter {

    private Context mmContext;
    public  int[] imageArray={

            R.drawable.pic48,R.drawable.pic49,R.drawable.pic50,
            R.drawable.pic51,R.drawable.pic52,R.drawable.pic53,
            R.drawable.pic54,R.drawable.pic55,R.drawable.pic56,
            R.drawable.pic57,R.drawable.pic58,R.drawable.pic59,
            R.drawable.pic60,R.drawable.pic61,R.drawable.pic62,
            R.drawable.pic63,R.drawable.pic64,R.drawable.pic65,
            R.drawable.pic66,R.drawable.pic67,R.drawable.pic68,
            R.drawable.pic69,R.drawable.pic70,R.drawable.pic71,
            R.drawable.pic72,R.drawable.pic73,R.drawable.pic74,
            R.drawable.pic75,R.drawable.pic76,R.drawable.pic77,
            R.drawable.pic78,


    };

    public ImageAdapter2(Context mmContext) {
        this.mmContext = mmContext;
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

        ImageView imageView1 = new ImageView(mmContext);
        imageView1.setImageResource(imageArray[position]);
        imageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView1.setLayoutParams(new AbsListView.LayoutParams(340,350));
        return imageView1;
    }
}
