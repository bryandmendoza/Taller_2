package com.example.taller_2.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Country {
    private String name;
    private String newConfirmed;
    private String newRecovered;
    private String newDeaths;
    private String totalConfirmed;
    private String totalRecovered;
    private String totalDeaths;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(String newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        this.newRecovered = newRecovered;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Country(JSONObject a) throws JSONException {
        name =  a.getString("Country").toString();
        newConfirmed =  a.getString("NewConfirmed").toString();
        newRecovered =  a.getString("NewRecovered").toString();
        newDeaths =  a.getString("NewDeaths").toString();
        totalConfirmed =  a.getString("TotalConfirmed").toString();
        totalRecovered =  a.getString("TotalRecovered").toString();
        totalDeaths =  a.getString("TotalDeaths").toString();
    }

    public static ArrayList<Country> JsonObjectsBuild(JSONArray data) throws JSONException {
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            countries.add(new Country(data.getJSONObject(i)));
        }
        return countries;
    }
}
