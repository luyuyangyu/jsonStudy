package com.example.dell.jsonstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
        Gson gson = new Gson();
        List<Novel> appList = gson.fromJson(jsonData, new TypeToken<List<Novel>>() {
        }.getType());
        for (Novel novel : appList) {
            Log.d("MainActivity", "bid :" + novel.getBid());
            Log.d("MainActivity", "bookname:" + novel.getBookname());
            Log.d("MainActivity", "authorname" + novel.getAuthor_name());
            Log.d("MainActivity", "book_cover" + novel.getBook_cover());
            Log.d("MainActivity", "class_name" + novel.getClass_name());
            Log.d("MainActivity", "stat_name" + novel.getStat_name());
            Log.d("MainActivity", "num_click" + novel.getNum_click());
        }

    }

}
