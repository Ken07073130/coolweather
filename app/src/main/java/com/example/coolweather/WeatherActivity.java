package com.example.coolweather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coolweather.gson.Daily;
import com.example.coolweather.gson.Now;
import com.example.coolweather.gson.Weather;
import com.example.coolweather.util.HttpUtil;
import com.example.coolweather.util.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    String addressNowWeather="https://devapi.heweather.net/v7/weather/now?location=101210108&key=cfa5848ee9b34dd9b450d0b9a8c26d18";
    String addressNowAir="https://devapi.heweather.net/v7/air/now?location=101210108&key=cfa5848ee9b34dd9b450d0b9a8c26d18";
    String addressSuggest="https://devapi.heweather.net/v7/indices/1d?location=101210108&key=cfa5848ee9b34dd9b450d0b9a8c26d18&type=0";
    TextView tvDegree;
    TextView tvWeatherInfo;
    TextView tvAirText;
    TextView tvAqiText;
    TextView tvPm25;
    TextView tvSuggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        tvDegree=findViewById(R.id.degree_text);
        tvWeatherInfo=findViewById(R.id.weather_info_text);
        tvAirText=findViewById(R.id.air_text);
        tvAqiText=findViewById(R.id.aqi_text);
        tvPm25=findViewById(R.id.pm25_text);
        tvSuggest=findViewById(R.id.suggest_text);


        showWeatherInfo(new Weather());
    }

    //填充天气信息
    public void showWeatherInfo(Weather weather){
        //当前气温
        HttpUtil.sendOkHttpRequest(addressNowWeather, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Now now= Utility.handleWeatherNowResponse(response.body().string()).getNow();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvDegree.setText(now.getTemp()+"℃");
                        tvWeatherInfo.setText(now.getText());
                    }
                });
            }
        });
        //当前空气质量
        HttpUtil.sendOkHttpRequest(addressNowAir, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Now now= Utility.handleWeatherNowResponse(response.body().string()).getNow();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvAirText.setText("空气质量："+now.getCategory());
                        tvAqiText.setText(now.getAqi());
                        tvPm25.setText(now.getPm2p5());
                    }
                });
            }
        });

        //舒适指数
        HttpUtil.sendOkHttpRequest(addressSuggest, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final List<Daily> dailyList= Utility.handleWeatherNowResponse(response.body().string()).getDailyList();
                Log.d("aaa",String.valueOf(dailyList.size()));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        StringBuilder sbSuggest=new StringBuilder();
                        for (Daily daily:dailyList) {
                            sbSuggest.append(daily.getName()+":"+daily.getCategory());
                            sbSuggest.append("\r\n");
                            sbSuggest.append(daily.getText());
                            sbSuggest.append("\r\n");
                            sbSuggest.append("\r\n");

                        }
                        tvSuggest.setText(sbSuggest);


                    }
                });
            }
        });
    }
}
