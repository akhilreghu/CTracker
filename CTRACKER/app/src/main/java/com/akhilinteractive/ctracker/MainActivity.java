package com.akhilinteractive.ctracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView btcrate;
    TextView ethrate;
    TextView tronrate;


    public String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btcrate  = findViewById(R.id.btcrate);
        ethrate  = findViewById(R.id.ethrate);
        tronrate  = findViewById(R.id.tronrate);
        btcprice();
        ethprice();
        tronprice();

    }
    public void home(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void calculator(View view){
        Intent intent = new Intent(getApplicationContext(),Converter.class);
        startActivity(intent);
    }
    public void blog(View view){
        Intent intent = new Intent(getApplicationContext(), Blog.class);
        startActivity(intent);
    }
    public void contact(View view){
        Intent intent = new Intent(getApplicationContext(), Contact.class);
        startActivity(intent);
    }
    public void info(View view){
        Intent intent = new Intent(getApplicationContext(), Info.class);
        startActivity(intent);
    }
    public void btconclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","Bitcoin");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }
    public void ethonclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","Ethereum");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }
    public void dashonclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","Dash");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }
    public void xmronclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","Monero");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }
    public void xrponclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","Ripple");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }
    public void ltconclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","Litecoin");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }
    public void iotaonclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","IOTA");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }
    public void trononclick(View view){
        Intent intent = new Intent(getApplicationContext(),Coin.class);
        intent.putExtra("name","Tron");
        Log.d("click","Pressed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        startActivity(intent);
    }



    public void btcprice(){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

        final Request request = new Request.Builder()
                .url(url)
                .build();

        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }


            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myresponse = response.body().string();


                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;
                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("bitcoin").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            btcrate.setText("₹ "+inr);
                        }
                    });
                }

            }
        });
    }
    public void ethprice(){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

        final Request request = new Request.Builder()
                .url(url)
                .build();

        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }


            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myresponse = response.body().string();


                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;
                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("ethereum").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            ethrate.setText("₹ "+inr);
                        }
                    });
                }

            }
        });
    }
    public void tronprice(){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=tron&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

        final Request request = new Request.Builder()
                .url(url)
                .build();

        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }


            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myresponse = response.body().string();


                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;
                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("tron").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            tronrate.setText("₹ "+inr);
                        }
                    });
                }

            }
        });
    }
}
