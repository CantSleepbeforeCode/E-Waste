package com.example.mitra.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mitra.R;

import org.json.JSONException;
import org.json.JSONObject;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class RegisterDevice extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener {

    private Button btnKirim;
    private EditText edtNamaDevice, edtLokasiDevice;
    private AntaresHTTPAPI antaresAPIHTTP;
    static final String accessKey = "fe218f75b96fc5ce:e43a94e6dfd6179a";
    static final String appName = "E-Waste";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_device);

        //UI
        btnKirim = (Button) findViewById(R.id.btnKirim);
        Button btnDelete = (Button)findViewById(R.id.deleteDevice);
        edtNamaDevice = (EditText) findViewById(R.id.editNamaDevice);
        edtLokasiDevice = (EditText) findViewById(R.id.editLokasi);
        final String newDevice = edtNamaDevice.getText().toString();
        String lokasiDevice = edtLokasiDevice.getText().toString();

        antaresAPIHTTP = new AntaresHTTPAPI();
        antaresAPIHTTP.addListener(this);

        btnKirim.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                antaresAPIHTTP.createDevice(accessKey, appName, newDevice);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                antaresAPIHTTP.deleteDevice(accessKey, appName, newDevice);
            }
        });
    }

    @Override
    public void onResponse(AntaresResponse antaresResponse) {
        // --- Cetak hasil yang didapat dari ANTARES ke System Log --- //
        //Log.d(TAG,antaresResponse.toString());
//        Log.d(TAG,Integer.toString(antaresResponse.getRequestCode()));
//        if(antaresResponse.getRequestCode()==0){
//            try {
//                JSONObject body = new JSONObject(antaresResponse.getBody());
//                dataDevice = body.getJSONObject("m2m:cin").getString("con");
//                Log.d(TAG,dataDevice);
//
//                JSONObject jObject= new JSONObject(dataDevice);
//                date=jObject.getString("date");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        txtData.setText(date);
//                    }
//                });
//                Log.d(TAG,date);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
