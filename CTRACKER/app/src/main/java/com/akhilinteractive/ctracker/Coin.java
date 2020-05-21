package com.akhilinteractive.ctracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Coin extends AppCompatActivity {

    String name;
    public String Bitcoin = "Bitcoin (BTC)";
    public String Ethereum = "Ethereum (ETH)";
    public String Dash = "Dash (DASH)";
    public String Ripple = "Ripple (XRP)";
    public String IOTA = "IOTA (MIOTA)";
    public String Tron = "Tron (TRX)";
    public String Monero = "Monero (XMR)";
    public String Litecoin = "Litecoin (LTC)";

    TextView coinprice;
    TextView cap;
    TextView volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        coinprice = (TextView) findViewById(R.id.coinprice);
        cap = (TextView) findViewById(R.id.marketcap);
        volume = (TextView) findViewById(R.id.hourvolume);
        TextView coinname = (TextView) findViewById(R.id.coinname);
        name = getIntent().getStringExtra("name");
        System.out.println(name);

        ImageView coinimage = (ImageView) findViewById(R.id.coinimage);

        coinname.setText(name);
        if(name.equals("Bitcoin")){
            coinname.setText(Bitcoin);
            coinimage.setImageResource(R.drawable.btc);
            btcprice();
        }
        if(name.equals("Ethereum")){
            coinname.setText(Ethereum);
            coinimage.setImageResource(R.drawable.eth);
            ethprice();
        }
        if(name.equals("Dash")){
            coinname.setText(Dash);
            coinimage.setImageResource(R.drawable.dash);
            dashprice();
        }
        if(name.equals("Ripple")){
            coinname.setText(Ripple);
            coinimage.setImageResource(R.drawable.xrp);
            xrpprice();
        }
        if(name.equals("IOTA")){
            coinname.setText(IOTA);
            coinimage.setImageResource(R.drawable.iota);
            iotaprice();
        }
        if(name.equals("Tron")){
            coinname.setText(Tron);
            coinimage.setImageResource(R.drawable.tron);
            tronprice();
        }
        if(name.equals("Monero")){
            coinname.setText(Monero);
            coinimage.setImageResource(R.drawable.xmr);
            xmrprice();
        }
        if(name.equals("Litecoin")){
            coinname.setText(Litecoin);
            coinimage.setImageResource(R.drawable.ltc);
            ltcprice();
        }


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


                    Coin.this.runOnUiThread(new Runnable() {
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
                                cObj = jObj.get("bitcoin").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);
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


                    Coin.this.runOnUiThread(new Runnable() {
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
                                cObj = jObj.get("ethereum").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);
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


                    Coin.this.runOnUiThread(new Runnable() {
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
                                cObj = jObj.get("tron").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);
                        }
                    });
                }

            }
        });
    }
    public void xmrprice(){
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


                    Coin.this.runOnUiThread(new Runnable() {
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
                                cObj = jObj.get("monero").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);
                        }
                    });
                }

            }
        });
    }
    public void xrpprice(){
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


                    Coin.this.runOnUiThread(new Runnable() {
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
                                cObj = jObj.get("ripple").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);
                        }
                    });
                }

            }
        });
    }
    public void dashprice(){
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


                    Coin.this.runOnUiThread(new Runnable() {
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
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);
                        }
                    });
                }

            }
        });
    }
    public void iotaprice(){
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


                    Coin.this.runOnUiThread(new Runnable() {
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
                                cObj = jObj.get("iota").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);
                        }
                    });
                }

            }
        });
    }
    public void ltcprice(){
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


                    Coin.this.runOnUiThread(new Runnable() {
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
                                cObj = jObj.get("litecoin").toString();
                                iObj = new JSONObject(cObj);
                                inr = iObj.get("inr").toString();
                                capital = iObj.get("inr_market_cap").toString();
                                hourvolume = iObj.get("inr_24h_vol").toString();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jObj);
                            coinprice.setText("₹ "+inr);
                            cap.setText("₹ "+capital);
                            volume.setText("₹ "+hourvolume);

                        }
                    });
                }

            }
        });
    }




}
