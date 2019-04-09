package com.example.dell.jsonstudy;

import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Atest {
    public void sendRquestWithOkHttp(){
       new Thread(new Runnable() {
          @Override
          public void run() {
             try{
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("")
                        .build();
                Response response = client.newCall(request).execute();
                String responseData = response.body().string();
                Log.d("run",responseData);

             }catch (Exception e){
                e.printStackTrace();
             }
          }
       }).start();
    }

   private void praseJsonWithGson(String data){
      try{
            JSONObject jsonObject = new JSONObject(data.toString());


      }catch (Exception e){
         e.printStackTrace();
      }
   }
}
