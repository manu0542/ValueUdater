package com.example.valueupdater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
  RelativeLayout layout;
  RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        layout=findViewById(R.id.sinewave);

        queue= Volley.newRequestQueue(this);

        sendRequest();

    }

    private void sendRequest() {
        String url="https://us-central1-eratechbackend.cloudfunctions.net/getSGV";
        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array=response.getJSONArray("sgvs");
                    JSONObject object=array.getJSONObject(0);
                    String value =object.getString("sgv");
                    SineView myView = new SineView(MainActivity.this,value);
                    layout.addView(myView);
                    TextView view=findViewById(R.id.valueShower);
                    view.setText(value);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();

            }
        });
        queue.add(request);
    }
}
