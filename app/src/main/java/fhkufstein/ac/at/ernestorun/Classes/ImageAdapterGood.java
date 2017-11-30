package fhkufstein.ac.at.ernestorun.Classes;

/**
 * Created by marti on 25.11.2017.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import fhkufstein.ac.at.ernestorun.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import fhkufstein.ac.at.ernestorun.R;

/**
 * Created by marti on 25.11.2017.
 */

public class ImageAdapterGood extends BaseAdapter {

    private Context mContext;

    public ImageAdapterGood(Context c) {
        mContext = c;
    }

    public int getCount() {
        return good.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(15, 15, 15, 15);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(good[position]);
        return imageView;
    }

    // references to our images

    private Integer[] good = {

            R.drawable.good_1, R.drawable.good_2,
            R.drawable.good_3, R.drawable.good_4,
            R.drawable.good_5, R.drawable.good_6,
            R.drawable.good_7, R.drawable.good_8,
            R.drawable.good_9, R.drawable.good_10,
            R.drawable.good_11, R.drawable.good_12,
            R.drawable.good_13, R.drawable.good_14,
            R.drawable.good_15, R.drawable.good_16,
            R.drawable.good_17, R.drawable.good_18,
            R.drawable.good_19, R.drawable.good_20,
            R.drawable.good_21, R.drawable.good_22,
            R.drawable.good_23, R.drawable.good_24,
            R.drawable.good_25, R.drawable.good_26,

    };

}