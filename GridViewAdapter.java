package com.example.putafingerdown;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class GridViewAdapter extends ArrayAdapter<CategoryItem> {

    private final Context mContext;
    int mResource;

    public GridViewAdapter(@NonNull Context context, int resource, @NonNull List<CategoryItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String title = getItem(position).getItemTitle();
        String details = getItem(position).getItemDetails();
        int background_nr = getItem(position).getItemBackgroundNr();
        Drawable background = getBackgroud (background_nr);

        CategoryItem new_object = new CategoryItem(title,details,background_nr);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTitle = convertView.findViewById(R.id.TitleItem);
        TextView tvDetails = convertView.findViewById(R.id.DetailItem);
        LinearLayout tvLayout = convertView.findViewById(R.id.ItemLayout);

        tvLayout.setBackground(background);
        tvTitle.setText(title);
        tvDetails.setText(details);
        return convertView;
    }

    private Drawable getBackgroud (int background){

        if (background == 6){
            return mContext.getResources().getDrawable(R.drawable.round_b_category_grid_view_item_v6);
        }
        if (background == 5){
            return mContext.getResources().getDrawable(R.drawable.round_b_category_grid_view_item_v5);
        }
        if (background == 4){
            return mContext.getResources().getDrawable(R.drawable.round_b_category_grid_view_item_v4);
        }
        if (background == 3){
            return mContext.getResources().getDrawable(R.drawable.round_b_category_grid_view_item_v3);
        }
        if (background == 2){
            return mContext.getResources().getDrawable(R.drawable.round_b_category_grid_view_item_v2);
        }
        if (background == 1){
            return mContext.getResources().getDrawable(R.drawable.round_b_category_grid_view_item);
        }
        else {
            return null;
        }
    }
}
