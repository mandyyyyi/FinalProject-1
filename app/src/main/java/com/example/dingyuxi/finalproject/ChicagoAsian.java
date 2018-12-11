package com.example.dingyuxi.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChicagoAsian extends AppCompatActivity {
    public String restaurant1 = CuisineCategory.restaurant1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Button ca1 = (Button) findViewById(R.id.asian1);
        String ca1name = getIntent().getStringExtra("restaurant-name");
        ca1.setText(ca1name);
        ca1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), Main5Activity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button ca2 = (Button) findViewById(R.id.asian2);
        String ca2name = getIntent().getStringExtra("restaurant-name2");
        ca2.setText(ca2name);
        ca2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), Main7Activity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button ca3 = (Button) findViewById(R.id.asian3);
        String ca3name = getIntent().getStringExtra("restaurant-name3");
        ca3.setText(ca3name);
        ca3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), Main5Activity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button ca4 = (Button) findViewById(R.id.asian4);
        String ca4name = getIntent().getStringExtra("restaurant-name4");
        ca4.setText(ca4name);
        ca4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), Main5Activity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
