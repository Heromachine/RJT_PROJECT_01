package com.example.jessi.rjt_project_01.data.models;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class CustomProductlistAdapter extends BaseAdapter {

    private Activity                 activity;
    private LayoutInflater           inflater;
    private List           list_Modle_Product;


    public CustomProductlistAdapter(Activity activity, List Model_Product)
    {
        this.activity = activity;
        this.list_Modle_Product = Model_Product;
    }
    @Override
    public int getCount() {
        return list_Modle_Product.size();
    }

    @Override
    public Object getItem(int position) {
        return list_Modle_Product.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if (inflater == null)
//            inflater = (LayoutInflater) activity
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        if (convertView == null)
//            convertView = inflater.inflate(R.layout.list_row, null);
//
//        if (imageLoader == null)
//            imageLoader = AppController.getInstance().getImageLoader();
//
//        TextView title = (TextView) convertView.findViewById(R.id.title);
//        TextView category = (TextView) convertView.findViewById(R.id.category);
//
//        NetworkImageView thumbNail = (NetworkImageView) convertView
//                .findViewById(R.id.thumbnail);
//
//        // getting model data for the row
//        Model m = modelItems.get(position);
//
//        // title
//        title.setText("Title: " + String.valueOf(m.getTitle()));
//
//        // category
//        category.setText("Category: "+ String.valueOf(m.getCategory()));
//
//        // thumbnail image
//        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);
//
//        return convertView;
//    }
}
