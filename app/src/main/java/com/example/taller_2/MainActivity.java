package com.example.taller_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.taller_2.Adapter.CountryAdapter;
import com.example.taller_2.Model.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listCountries;
    private RequestQueue request;
    private StringRequest stringRq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCountries = (ListView) findViewById(R.id.listCountries);
        View header = getLayoutInflater().inflate(R.layout.list_header, null);
        listCountries.addHeaderView(header);

        getCovidData();
    }

    public void getCovidData() {
        request = Volley.newRequestQueue(MainActivity.this);
        String URL = "https://api.covid19api.com/summary";
        stringRq = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject json_response = null;
                ArrayList<Country> countries = new ArrayList<Country>();
                try {
                    json_response = new JSONObject(response);
                    JSONArray json_countries = json_response.getJSONArray("Countries");
                    countries = Country.JsonObjectsBuild(json_countries);
                    CountryAdapter countryAdapter = new CountryAdapter(MainActivity.this, countries);
                    listCountries.setAdapter(countryAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringRq);
    }
}