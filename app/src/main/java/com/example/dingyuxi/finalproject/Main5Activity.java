package com.example.dingyuxi.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        final TextView cost = findViewById(R.id.cost);
        cost.setText("average_cost_for_two: " + CuisineCategory.getCost());
        final TextView delivery = findViewById(R.id.delivery);
        delivery.setText("has_online_delivery: " + CuisineCategory.getDelivery());
        final TextView address = findViewById(R.id.address);
        address.setText("Location: " + CuisineCategory.getAddress());
        final TextView rate = findViewById(R.id.rate);
        rate.setText("Rate: " + CuisineCategory.getRate());
        Button web = (Button) findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(CuisineCategory.getUrl()));
                startActivityForResult(myIntent, 0);
                startActivity(myIntent);

            }
        });

    }
}
