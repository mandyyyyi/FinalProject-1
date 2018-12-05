package com.example.dingyuxi.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.content.Intent;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Yelp";


    /** Request queue for our network requests. */
    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = Volley.newRequestQueue(this);
        setContentView(R.layout.mainactivity);
        Button myButton = (Button) findViewById(R.id.get_weather);
        myButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ImageView iv = (ImageView) findViewById(R.id.imageView);
                iv.setVisibility(View.VISIBLE);
            }
        });


        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), City.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}






