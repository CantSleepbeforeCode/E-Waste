package com.example.mitra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mitra.R;

import org.json.JSONException;
import org.json.JSONObject;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class GetTrashActivity extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener{
    Spinner spinner;
    private AntaresHTTPAPI antaresAPIHTTP;
    static final String accessKey = "fe218f75b96fc5ce:e43a94e6dfd6179a";
    static final String appName = "E-Waste";
    String dataDevice, date;
    String TAG = "GetTrashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_trash);

        spinner = findViewById(R.id.spinner);

        String[] spinnerItem = this.getResources().getStringArray(R.array.place_spinner);
        final ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItem);
        spinner.setAdapter(adapterSpinner);
    }

    @Override
    public void onResponse(AntaresResponse antaresResponse) {
        Log.d(TAG,antaresResponse.toString());
        Log.d(TAG,Integer.toString(antaresResponse.getRequestCode()));
        if(antaresResponse.getRequestCode()==0){
            try {
                JSONObject body = new JSONObject(antaresResponse.getBody());
                dataDevice = body.getJSONObject("m2m:grp").getString("mid");
                Log.d(TAG,dataDevice);

                JSONObject jObject= new JSONObject(dataDevice);
                date = jObject.getString("date");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                Log.d(TAG,date);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
