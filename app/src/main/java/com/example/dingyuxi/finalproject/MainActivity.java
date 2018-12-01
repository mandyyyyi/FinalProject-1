package com.example.dingyuxi.finalproject;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.util.Log;
import android.content.Intent;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


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
                Intent myIntent = new Intent(view.getContext(), Main3Activity.class);
                startActivityForResult(myIntent, 0);
            }

        });

//        Button start = (Button) findViewById(R.id.start);
//        start.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myFirstIntent = new Intent(view.getContext(), Main3Activity.class);
//                startActivityForResult(myFirstIntent, 0);
//            }
//
//        });
//
//        Button chicago = (Button) findViewById(R.id.chicago);
//        chicago.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent mySecondIntent = new Intent(view.getContext(), Main2Activity.class);
//                startActivityForResult(mySecondIntent, 0);
//            }
//
//        });
//
//        Button urbana = (Button) findViewById(R.id.urbana);
//        urbana.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myThirdIntent = new Intent(view.getContext(), Main2Activity.class);
//                startActivityForResult(myThirdIntent, 0);
//            }
//
//        });


        final Button startAPICall = findViewById(R.id.Yelp);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start API button clicked");
                startAPICall();
            }
        });
    }

    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d(TAG, response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}





