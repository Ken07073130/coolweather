package com.example.coolweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(MainActivity.this,WeatherActivity.class);
        startActivity(intent);
        //finish();
        /*try {
            String address="https://devapi.heweather.net/v7/weather/now?location=101210108&key=cfa5848ee9b34dd9b450d0b9a8c26d18";
            HttpUtil.sendOkHttpRequest(address, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String jsonData=response.body().string();
                    Gson gson=new Gson();
                    Log.d("Main",jsonData);
                    Weather weather=gson.fromJson(jsonData,new TypeToken<Weather>(){}.getType());
                    Now now=weather.getNow();
                    Log.d("Main",now.getText());
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }*/

    }
}