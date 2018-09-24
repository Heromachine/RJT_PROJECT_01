package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jessi.rjt_project_01.R;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.jessi.rjt_project_01.data.models.Model_Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleView_Adapter_Product extends RecyclerView.Adapter <RecycleView_Adapter_Product.viewHolder>{
    private static final String TAG = "RecycleView_Adapter_Pro";
    TextView tv;
    private Context mCtx;
    private List<Model_Product> listViewListItem;

    public RecycleView_Adapter_Product(Context mCtx, List<Model_Product> listViewListItem) {
        Log.d(TAG, "RecycleView_Adapter_Product: " + listViewListItem.size());
        this.mCtx = mCtx;
        this.listViewListItem = listViewListItem;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(R.layout.view_product_list_listview, null);
        viewHolder holder = new viewHolder(view);
        return holder;
    }
    public class viewHolder extends RecyclerView.ViewHolder
    {
        private static final String TAG = "viewHolder";
        TextView id;
        TextView name;
        TextView description;
        ImageView image;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            Log.d(TAG, "viewHolder: ");
            id = itemView.findViewById(R.id.tv_item_id);
            name = itemView.findViewById(R.id.tv_item_name);
            description = itemView.findViewById(R.id.tv_item_description);
            image = itemView.findViewById(R.id.img_item);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: ");
        Model_Product vli = listViewListItem.get(i);

        viewHolder.id.setText(vli.getId());
        viewHolder.name.setText(vli.getName());
        viewHolder.description.setText(vli.getDescription());
        Picasso.get().load(vli.getUrl()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "); return listViewListItem.size();
    }

}
