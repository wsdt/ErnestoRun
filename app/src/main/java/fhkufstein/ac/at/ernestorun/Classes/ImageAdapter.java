package fhkufstein.ac.at.ernestorun.Classes;

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

//brauchen wir eigentlich nicht mehr !!!

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c) {
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

            R.drawable.bad_01, R.drawable.bad_02,
            R.drawable.bad_03, R.drawable.bad_04,
            R.drawable.bad_05, R.drawable.bad_06,
            R.drawable.bad_07, R.drawable.bad_08,
            R.drawable.bad_09, R.drawable.bad_10,
            R.drawable.bad_11, R.drawable.bad_12,
            R.drawable.bad_13, R.drawable.bad_14,
            R.drawable.bad_15, R.drawable.bad_17,
            R.drawable.bad_18, R.drawable.bad_19,
            R.drawable.bad_20, R.drawable.bad_21,
            R.drawable.bad_22, R.drawable.bad_23,
            R.drawable.bad_24, R.drawable.bad_25,
            R.drawable.bad_26, R.drawable.bad_27

    };

    private Integer[] good = {

            R.drawable.good_01, R.drawable.good_02,
            R.drawable.good_03, R.drawable.good_04,
            R.drawable.good_05, R.drawable.good_06,
            R.drawable.good_07, R.drawable.good_07,
            R.drawable.good_08, R.drawable.good_10,
            R.drawable.good_11, R.drawable.good_12,
            R.drawable.good_13, R.drawable.good_14,
            R.drawable.good_15, R.drawable.good_16,
            R.drawable.good_17, R.drawable.good_18,
            R.drawable.good_19, R.drawable.good_20,
            R.drawable.good_21, R.drawable.good_22,
            R.drawable.good_23, R.drawable.good_24,
            R.drawable.good_25, R.drawable.good_26,

    };

    private Integer [] end = {
            R.drawable.dead_01
    };





}