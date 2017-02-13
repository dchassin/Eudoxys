package com.stanford.slac.eudoxystest;


import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class GridlabdClient {
    private static String BASE_URL = "http://gridlabd.slac.stanford.edu:6267/json/house_1/";
    private static String AIR_TEMP = BASE_URL + "air_temperature";
    private static String OUTDOOR_TEMP = BASE_URL + "outdoor_temperature";
    private static String HEATING_SETPOINT = BASE_URL + "heating_setpoint";
    private static String COOLING_SETPOINT = BASE_URL  + "cooling_setpoint";
    private static String MODE = BASE_URL + "thermostat_mode";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void getAirTemp(RequestParams params, AsyncHttpResponseHandler asyncHttpResponseHandler){
        client.get(AIR_TEMP, params, asyncHttpResponseHandler);
        Log.d(String.valueOf(AIR_TEMP), "getAirTemp: ");
    }

    public static void getOutdoorSetpoint(RequestParams params, AsyncHttpResponseHandler asyncHttpResponseHandler){
        client.get(OUTDOOR_TEMP, params, asyncHttpResponseHandler);
        Log.d(String.valueOf(OUTDOOR_TEMP), "getOutdoorTemp: ");
    }

    public static void getHeatingSetpoint(RequestParams params, AsyncHttpResponseHandler asyncHttpResponseHandler){
        client.get(HEATING_SETPOINT, params, asyncHttpResponseHandler);
        Log.d(String.valueOf(HEATING_SETPOINT), "getHeatingSetPoint: ");
    }

    public static void getCoolingSetpoint(RequestParams params, AsyncHttpResponseHandler asyncHttpResponseHandler){
        client.get(COOLING_SETPOINT, params, asyncHttpResponseHandler);
        Log.d(String.valueOf(COOLING_SETPOINT), "getCoolingSetpoint: ");
    }

    public static void getMode(RequestParams params, AsyncHttpResponseHandler asyncHttpResponseHandler){
        client.get(MODE, params, asyncHttpResponseHandler);
        Log.d(String.valueOf(MODE), "getMode: ");
    }

}
