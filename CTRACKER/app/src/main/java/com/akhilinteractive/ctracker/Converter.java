package com.akhilinteractive.ctracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class Converter extends AppCompatActivity {

    TextView result;
    EditText input;
    String i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        input = findViewById(R.id.input);
        result = findViewById(R.id.result);
        i=input.getText().toString();
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

    public void btcclick(View view){
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


                    Converter.this.runOnUiThread(new Runnable() {
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
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));
                        }
                    });
                }

            }
        });

    }
    public void ethclick(View view){
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


                    Converter.this.runOnUiThread(new Runnable() {
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
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));
                        }
                    });
                }

            }
        });

    }
    public void xrpclick(View view){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=ripple&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

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


                    Converter.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;

                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("ripple").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));
                        }
                    });
                }

            }
        });

    }
    public void xmrclick(View view){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=monero&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

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


                    Converter.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;
                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("monero").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));
                        }
                    });
                }

            }
        });

    }
    public void iotaclick(View view){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=iota&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

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


                    Converter.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;

                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("iota").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));
                        }
                    });
                }

            }
        });
    }
    public void dashclick(View view){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=dash&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

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


                    Converter.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;
                            String capital = null;
                            String hourvolume = null;
                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("dash").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));
                        }
                    });
                }

            }
        });
    }
    public void ltcclick(View view){
        OkHttpClient Client = new OkHttpClient();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=litecoin&vs_currencies=inr&include_market_cap=true&include_24hr_vol=true";

        final Request request = new Request.Builder()
                .url(url)
                .build();

        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }


            @Override
            public void onResponse(@NotNull final Call call, @NotNull final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myresponse = response.body().string();


                    Converter.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject jObj = null;
                            String cObj = null;
                            JSONObject iObj = null;
                            String inr = null;
                            try {
                                jObj = new JSONObject(myresponse);
                                cObj = jObj.get("litecoin").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));

                        }
                    });
                }

            }
        });

    }
    public void tronclick(View view){

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


                    Converter.this.runOnUiThread(new Runnable() {
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
                            double a =Double.parseDouble(input.getText().toString());
                            result.setText("₹ "+Double.toString(a*Double.parseDouble(inr)));
                        }
                    });
                }

            }
        });
    }
}
