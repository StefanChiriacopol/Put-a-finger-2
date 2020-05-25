package com.example.putafingerdown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    ImageView backImageView, nextImageView, previousImageView;
    TextView detailsTextView, titleTextView, contentTextView;
    LinearLayout playScreen;
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        backImageView = findViewById(R.id.BackImageView);
        detailsTextView = findViewById(R.id.DetailsPlayTextView);
        titleTextView = findViewById(R.id.TitlePlayTextView);
        playScreen = findViewById(R.id.PlayScreen);
        nextImageView = findViewById(R.id.NextImageView);
        previousImageView = findViewById(R.id.PreviousImageView);
        contentTextView = findViewById(R.id.ContentTextView);

        //back click
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //setDarkMode special items
        int nightModeFlags =
                this.getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                backImageView.setImageDrawable(this.getDrawable(R.drawable.back_white));
                titleTextView.setTextColor(Color.parseColor("#FFFFFF"));
                detailsTextView.setTextColor(Color.parseColor("#E8E8E8"));
                nextImageView.setImageDrawable(this.getDrawable(R.drawable.right_next_white));
                previousImageView.setImageDrawable(this.getDrawable(R.drawable.left_previous_white));
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                break;

        }

        //set textView values
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String details = intent.getStringExtra("Details");
        int background_nr = intent.getIntExtra("Background",1);
        setBackground (background_nr);
        titleTextView.setText(title);
        detailsTextView.setText(details);

    }

    private void setBackground (int nr){
        if (nr==1){
            playScreen.setBackground(this.getDrawable(R.drawable.round_b_category_grid_view_item));
        }
        if (nr==2){
            playScreen.setBackground(this.getDrawable(R.drawable.round_b_category_grid_view_item_v2));
        }
        if (nr==3){
            playScreen.setBackground(this.getDrawable(R.drawable.round_b_category_grid_view_item_v3));
        }
        if (nr==4){
            playScreen.setBackground(this.getDrawable(R.drawable.round_b_category_grid_view_item_v4));
        }
        if (nr==5){
            playScreen.setBackground(this.getDrawable(R.drawable.round_b_category_grid_view_item_v5));
        }
        if (nr==6){
            playScreen.setBackground(this.getDrawable(R.drawable.round_b_category_grid_view_item_v6));
        }
    }
}
