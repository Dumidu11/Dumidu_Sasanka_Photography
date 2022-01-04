package com.example.dumidusasankaphotography;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter3 extends BaseAdapter {

    private Context mmmContext;
    public  int[] imageArray={

            R.drawable.pic79,R.drawable.pic80,R.drawable.pic81,
            R.drawable.pic82,R.drawable.pic83,R.drawable.pic84,
            R.drawable.pic87,R.drawable.pic86,R.drawable.pic85,
            R.drawable.pic88,R.drawable.pic89,R.drawable.pic90,
            R.drawable.pic93,R.drawable.pic92,R.drawable.pic91,
            R.drawable.pic94,R.drawable.pic95,R.drawable.pic96,
            R.drawable.pic99,R.drawable.pic98,R.drawable.pic97,
            R.drawable.pic100,R.drawable.pic101

    };

    public ImageAdapter3(Context mmContext) {
        this.mmmContext = mmContext;
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
        ImageView imageView2 = new ImageView(mmmContext);
        imageView2.setImageResource(imageArray[position]);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView2.setLayoutParams(new AbsListView.LayoutParams(340,350));
        return imageView2;
    }
}
