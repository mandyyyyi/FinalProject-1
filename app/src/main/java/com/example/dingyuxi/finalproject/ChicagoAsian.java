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

        //ca1 stands for chicago restaurant 1
        Button ca1 = (Button) findViewById(R.id.asian1);
        String ca1name = getIntent().getStringExtra("restaurant_name");
        Log.d("RES", ca1name);
        ca1.setText(ca1name);
        ca1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), Main5Activity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
