package com.example.putafingerdown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView categoryGrid;
    ArrayList<CategoryItem> categoryList = new ArrayList<>();
    ImageView storageImageView, addImageView;
    TextView appNameTextView;
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoryGrid = findViewById(R.id.CategoryGridView);
        storageImageView = findViewById(R.id.StorageImageView);
        addImageView = findViewById(R.id.AddImageView);
        appNameTextView = findViewById(R.id.AppNameTextView);

        //setDarkMode special items
        int nightModeFlags =
                this.getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                storageImageView.setImageDrawable(this.getDrawable(R.drawable.storage_white));
                addImageView.setImageDrawable(this.getDrawable(R.drawable.add_white));
                appNameTextView.setTextColor(Color.parseColor("#FFFFFF"));
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                break;

        }

        //fill categories list
        Cursor data = db.getSetTableData();
        while (data.moveToNext()) {
            Log.i("merge","da");
            String title = data.getString(1);
            int set_number = data.getInt(2);
            int background_number = data.getInt(4);
            String set_number_string = getString(R.string.set)+ " "+set_number;
            CategoryItem item = new CategoryItem(title,set_number_string,background_number);
            categoryList.add(item);
        }

        //set GridView adapter
        categoryGrid.setAdapter(new GridViewAdapter(this, R.layout.category_grid_view_item, categoryList));

        //onClickItem
        categoryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(MainActivity.this, PlayActivity.class);
                CategoryItem aux = (CategoryItem) categoryGrid.getItemAtPosition(position);
                intent.putExtra("Title",aux.getItemTitle());
                intent.putExtra("Details",aux.getItemDetails());
                intent.putExtra("Background",aux.getItemBackgroundNr());
                Log.i("Item clicked",aux.getItemTitle()+" "+aux.getItemDetails());
                startActivity(intent);
            }
        });
    }
}
