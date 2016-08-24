package com.example.ubun17.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String searchURL = "http://api.walmartlabs.com/v1/search?query=cereal&format=json&apiKey=usu6xmuc5dha75jepwnp2ds9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                searchURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public  void onResponse(JSONObject response) {
                        String stResponse = response.toString();

                        //Gson gson = new Gson();
                        //WalMartSearch walMartSearch = gson.fromJson(stResponse, WalMartSearch.class);
                        //String asdf = walMartSearch.getNumItems().toString();

                        Toast.makeText(MainActivity.this, stResponse, Toast.LENGTH_LONG)
                                .show();

                        Log.d("asdf",stResponse);

                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
        });
        queue.add(jsonObjectRequest);


    }
}
