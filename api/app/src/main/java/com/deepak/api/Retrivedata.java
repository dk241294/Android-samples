package com.deepak.api;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Retrivedata extends AsyncTask<String,Void,String> {
    String data="";
    String singleParsed;
    String dataParsed;
    private static final String TAG = "Retrivedata";
    @Override
    protected String doInBackground(String... voids) {
        URL url = null;
        try {
            url = new URL("https://api.myjson.com/bins/p2sw1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream= httpURLConnection.getInputStream();
            BufferedReader br =new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null){
                line=br.readLine();
                data= data+line;
                JSONArray ja = new JSONArray(data);
                Log.d(TAG, "doInBackground: "+ja.length());
                for(int i =0;i<ja.length();i++){
                JSONObject JO = (JSONObject) ja.get(i);
                singleParsed="Name:" + JO.get("name") + "\n"+
                        "Password:" + JO.get("place")+"\n"+
                "idddd"+JO.get("id");
                dataParsed =dataParsed+singleParsed+"\n";
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataParsed;
    }

    @Override
    protected void onPostExecute(String s) {
        MainActivity.response.setText(dataParsed);
    }
}