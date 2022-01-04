package com.example.dumidusasankaphotography;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter4 extends BaseAdapter {

    private Context mmmmContext;
    public  int[] imageArray={

            R.drawable.pic138,R.drawable.pic137,R.drawable.pic136,
            R.drawable.pic133,R.drawable.pic134,R.drawable.pic135,
            R.drawable.pic132,R.drawable.pic131,R.drawable.pic130,
            R.drawable.pic127,R.drawable.pic128,R.drawable.pic129,
            R.drawable.pic126,R.drawable.pic125,R.drawable.pic124,
            R.drawable.pic121,R.drawable.pic122,R.drawable.pic123,
            R.drawable.pic120,R.drawable.pic119,R.drawable.pic118,
            R.drawable.pic117,R.drawable.pic116,R.drawable.pic115,
            R.drawable.pic114,R.drawable.pic113,R.drawable.pic112,
            R.drawable.pic111,R.drawable.pic110,

    };

    public ImageAdapter4(Context mmmmContext) {
        this.mmmmContext = mmmmContext;
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
        ImageView imageView3 = new ImageView(mmmmContext);
        imageView3.setImageResource(imageArray[position]);
        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView3.setLayoutParams(new AbsListView.LayoutParams(340,350));
        return imageView3;
    }
}
