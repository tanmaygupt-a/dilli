package com.delhiexmp.dilli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CardDetails extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        // Setting up fade to exclude bottom navigation bar from animation
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        // initializing resources
        ImageView imageView = (ImageView)  findViewById(R.id.imageViewCardDetails);
        Button mapsBtn = (Button) findViewById(R.id.maps_btn);
        TextView descTextView = (TextView) findViewById(R.id.descTextView);

        // Setting scrollable text view
        descTextView.setMovementMethod(new ScrollingMovementMethod());

        // Getting incoming intent
        Intent intent = getIntent();

        // Setting up resources from intent data
        imageView.setImageResource(intent.getIntExtra("imageId",0));
        descTextView.setText(intent.getStringExtra("description"));

        // navigation button on click listener
        mapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsIntent = new Intent(android.content.Intent.ACTION_VIEW,
                     Uri.parse(intent.getStringExtra("locationURL")));
                     startActivity(mapsIntent);
                     finishAfterTransition();
                     finish();
            }
        });

    }
}