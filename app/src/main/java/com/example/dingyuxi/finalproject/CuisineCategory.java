package com.example.dingyuxi.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.Map;
import java.util.HashMap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class CuisineCategory extends AppCompatActivity {
    private static final String TAG = "Yelp";
    private static RequestQueue requestQueue;
    public static String restaurant1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        requestQueue = Volley.newRequestQueue(this);




        Button asian = (Button) findViewById(R.id.asian);
        asian.setOnClickListener(new View.OnClickListener() {
//            @Override
            public void onClick(View view) {
                startAPICall();
                Intent mySecondIntent = new Intent(view.getContext(), ChicagoAsian.class).putExtra("restaurant_name", restaurant1);
                startActivityForResult(mySecondIntent, 0);

            }

        });
    }




    void startAPICall() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://developers.zomato.com/api/v2.1/search?entity_id=292&entity_type=city",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(final JSONObject response) {
                        Log.d(TAG, response.toString());
                        AsianRestraunt(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                Log.w(TAG, error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("user-key", "f229d0f31115c5f25cea35172d49a89a");
                Log.d(TAG, params.toString());
                return params;
            }
        };

        requestQueue.add(jsonObjectRequest);

    };

    void AsianRestraunt(JSONObject response) {
        try {
            //String a = response
            JSONArray res = response.getJSONArray("restaurants");
            Log.d(TAG, res.toString());
            JSONObject one = res.getJSONObject(0);
            JSONObject two = res.getJSONObject(1);
            //Log.d(TAG, one.toString());

            //JSONObject asianChicago1 = response.getJSONObject("restaurants");
            //restaurant1 = asianChicago1.get("name").toString();
            JSONObject hell = one.getJSONObject("restaurant");
            JSONObject hell2 = two.getJSONObject("restaurant");
            //Log.d(TAG, hell.toString());
            String restaurant = hell.get("name").toString();
            String restaurant2 = hell2.get("name").toString();
            //restaurant1 = "hi";
            //return restaurant1;
            //Log.d(TAG, restaurant);
            Intent intent = new Intent(CuisineCategory.this, ChicagoAsian.class);
            intent.putExtra("restaurant-name", restaurant);
            intent.putExtra("restaurant-name2", restaurant2);
            startActivity(intent);
//            Log.d(TAG, a);

        } catch(Exception e) {
            Log.d(TAG, "Sorry, we don't have Asian food");
        }
    }
}
