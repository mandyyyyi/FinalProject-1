package com.example.dingyuxi.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class City extends AppCompatActivity {

    /** Request queue for our network requests. */
    private static RequestQueue requestQueuee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueuee = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_main3);

        Button chicago = (Button) findViewById(R.id.chicago);
        chicago.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myThirdIntent = new Intent(view.getContext(), CuisineCategory.class);
                startActivityForResult(myThirdIntent, 0);
            }

        });


    }
}
