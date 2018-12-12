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
    //restaurant1
    public static String restaurant1;
    private static String cost11;
    private static String delivery11;
    private static String url11;
    private static String address11;
    private static String rate11;
    //restaurant2
    private static String cost22;
    private static String delivery22;
    private static String url22;
    private static String address22;
    private static String rate22;

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
                        //Log.d(TAG, response.toString());
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
                //Log.d(TAG, params.toString());
                return params;
            }
        };

        requestQueue.add(jsonObjectRequest);

    };

    void AsianRestraunt(JSONObject response) {
        try {
            JSONArray res = response.getJSONArray("restaurants");

            JSONObject one = res.getJSONObject(0);
            JSONObject two = res.getJSONObject(1);
            JSONObject three = res.getJSONObject(2);
            JSONObject four = res.getJSONObject(3);

            JSONObject hell = one.getJSONObject("restaurant");
            JSONObject hell2 = two.getJSONObject("restaurant");
            JSONObject hell3 = three.getJSONObject("restaurant");
            JSONObject hell4 = four.getJSONObject("restaurant");

            String restaurant = hell.get("name").toString();
            String restaurant2 = hell2.get("name").toString();
            String restaurant3 = hell3.get("name").toString();
            String restaurant4 = hell4.get("name").toString();

            //restaurant 1
            String cost1 = hell.get("average_cost_for_two").toString();
            cost11 = cost1;
            delivery11 = hell.get("has_online_delivery").toString();
            url11 = hell.get("url").toString();

            //location adress
            JSONObject temp = hell.getJSONObject("location");
            address11 = temp.get("address").toString();
            JSONObject tmp1 = hell.getJSONObject("user_rating");
            rate11 = tmp1.get("aggregate_rating").toString();

            //restaurant2
            cost22 = hell2.get("average_cost_for_two").toString();
            delivery22 = hell2.get("has_online_delivery").toString();
            url22 = hell2.get("url").toString();

            //location adress
            JSONObject temp2 = hell2.getJSONObject("location");
            address22 = temp2.get("address").toString();
            JSONObject tmp2 = hell2.getJSONObject("user_rating");
            rate22 = tmp2.get("aggregate_rating").toString();



            Intent intent = new Intent(CuisineCategory.this, ChicagoAsian.class);
            intent.putExtra("restaurant-name", restaurant);
            intent.putExtra("restaurant-name2", restaurant2);
            intent.putExtra("restaurant-name3", restaurant3);
            intent.putExtra("restaurant-name4", restaurant4);
            startActivity(intent);

        } catch(Exception e) {
            Log.d(TAG, "Sorry, we don't have Asian food");
        }
    }
    public static String getCost() {
        return cost11;
    }
    public static String getDelivery() {
        return delivery11;
    }
    public static String getUrl() {
        return url11;
    }
    public static String getAddress() {
        return address11;
    }
    public static String getRate() {
        return rate11;
    }
    public static String getCost2() {
        return cost22;
    }
    public static String getDelivery2() {
        return delivery22;
    }
    public static String getUrl2() {
        return url22;
    }
    public static String getAddress2() {
        return address22;
    }
    public static String getRate2() {
        return rate22;
    }
}
