package com.example.jessi.rjt_project_01.ui.main.uicategories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.models.ModelCategory;
import com.example.jessi.rjt_project_01.data.models.Model_Product;
import com.example.jessi.rjt_project_01.ui.main.uiproductlist.RecycleView_Adapter_Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterCategories extends RecyclerView.Adapter<RecyclerViewAdapterCategories.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapterCate: STARTED";
    private Context mCtx;
    private List<ModelCategory> modelCategoryList;

    public RecyclerViewAdapterCategories(Context context, List<ModelCategory> modelCategoryList)
    {
        this.mCtx = context;
        this.modelCategoryList = modelCategoryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private static final String TAG = "viewHolder";
        TextView id;
        TextView name;
        TextView description;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Log.d(TAG, "viewHolder: ");
            id = itemView.findViewById(R.id.tv_cat_item_id);
            name = itemView.findViewById(R.id.tv_cat_item_name);
            description = itemView.findViewById(R.id.tv_cat_item_description);
            image = itemView.findViewById(R.id.img_cat_item);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(R.layout.view_categorylist_item, viewGroup, false);
        RecyclerViewAdapterCategories.ViewHolder holder = new RecyclerViewAdapterCategories.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ModelCategory modelCategory = modelCategoryList.get(i);

        viewHolder.id.setText(modelCategory.getId());
        viewHolder.name.setText(modelCategory.getName());
        viewHolder.description.setText(modelCategory.getDescription());
        Picasso.get().load(modelCategory.getUrl()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {

         return modelCategoryList.size();
    }
}

