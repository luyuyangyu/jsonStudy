package com.example.dell.jsonstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private String TAG = "text";
    private String resultData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequestWithOkHttp();
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://www.apiopen.top/novelApi")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Log.d("run", responseData);
                    parseJSONWithGSON(responseData);
                    parseJSONWithGSON2(resultData);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void parseJSONWithGSON(String jsonData) {
        try {


            JSONObject jsonObject = new JSONObject(jsonData.toString());
            String resultCode = jsonObject.getString("code");
            String reason = jsonObject.getString("msg");
            String result = jsonObject.getString("data");


            Log.d("MainActivity", resultCode);
            Log.d("MainActivity", reason);
            Log.d("MainActivity", result);
            resultData = result;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJSONWithGSON2(String jsonData) {
        try{
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
