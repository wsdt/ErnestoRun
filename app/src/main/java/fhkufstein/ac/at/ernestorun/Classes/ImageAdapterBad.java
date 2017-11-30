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

public class ImageAdapterBad extends BaseAdapter {

    private Context mContext;

    public ImageAdapterBad(Context c) {
        mContext = c;
    }

    public int getCount() {
        return bad.length;
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

        imageView.setImageResource(bad[position]);
        return imageView;
    }

    // references to our images
    private Integer[] bad = {

            R.drawable.bad_1, R.drawable.bad_2,
            R.drawable.bad_3, R.drawable.bad_4,
            R.drawable.bad_5, R.drawable.bad_6,
            R.drawable.bad_7, R.drawable.bad_8,
            R.drawable.bad_9, R.drawable.bad_10,
            R.drawable.bad_11, R.drawable.bad_12,
            R.drawable.bad_13, R.drawable.bad_14,
            R.drawable.bad_15, R.drawable.bad_17,
            R.drawable.bad_18, R.drawable.bad_19,
            R.drawable.bad_20, R.drawable.bad_21,
            R.drawable.bad_22, R.drawable.bad_23,
            R.drawable.bad_24, R.drawable.bad_25,
            R.drawable.bad_26, R.drawable.bad_27

    };

}