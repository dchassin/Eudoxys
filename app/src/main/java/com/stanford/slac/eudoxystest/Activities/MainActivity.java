package com.stanford.slac.eudoxystest.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.stanford.slac.eudoxystest.Models.Gridlabd;
import com.stanford.slac.eudoxystest.GridlabdClient;
import com.stanford.slac.eudoxystest.R;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    TextView air_temp;
    TextView outdoor_temp;
    TextView heating_setpoint;
    TextView cooling_setpoint;
    TextView mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        air_temp = (TextView) findViewById(R.id.currTempValue);
        outdoor_temp = (TextView)findViewById(R.id.outdoorTempValue);
        heating_setpoint = (TextView)findViewById(R.id.heatingTempValue);
        cooling_setpoint = (TextView)findViewById(R.id.coolingTempValue);
        mode = (TextView)findViewById(R.id.modeValue);

        fetchRoomData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_refresh:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fetchRoomData() {
        final Gridlabd roomData = new Gridlabd();

        GridlabdClient.getAirTemp(null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    roomData.setAir_temp(response.getString("value"));
                    air_temp.setText(roomData.getAir_temp());
                    Log.d("INSIDE FETCH:", roomData.getAir_temp());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

        GridlabdClient.getOutdoorSetpoint(null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    roomData.setOutdoor_temp(response.getString("value"));
                    outdoor_temp.setText(roomData.getOutdoor_temp());
                    Log.d("INSIDE FETCH:", roomData.getOutdoor_temp());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        });

        GridlabdClient.getHeatingSetpoint(null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    roomData.setHeating_setpoint(response.getString("value"));
                    heating_setpoint.setText(roomData.getHeating_setpoint());
                    Log.d("INSIDE FETCH:", roomData.getHeating_setpoint());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

        GridlabdClient.getCoolingSetpoint(null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    roomData.setCooling_setpoint(response.getString("value"));
                    cooling_setpoint.setText(roomData.getCooling_setpoint());
                    Log.d("INSIDE FETCH:", roomData.getCooling_setpoint());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

        GridlabdClient.getMode(null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    roomData.setMode(response.getString("value"));
                    mode.setText(roomData.getMode());
                    Log.d("INSIDE FETCH:", roomData.getMode());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        });

    }


}
