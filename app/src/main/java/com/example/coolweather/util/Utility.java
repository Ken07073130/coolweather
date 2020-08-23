package com.example.coolweather.util;

import android.text.TextUtils;


import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;


public class Utility {
    public static boolean handleProvinceResponse(String response){
        boolean result=false;
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray jsonArray=new JSONArray(response);
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject=(JSONObject) jsonArray.get(i);
                    Province province=new Province();
                    province.setProvinceCode(jsonObject.getInt("id"));
                    province.setProvinceName(jsonObject.getString("name"));
                    province.save();
                    result=true;

                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }

        return result;
    }


    public static boolean handleCityResponse(String response,int provinceID){
        boolean result=false;
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray jsonArray=new JSONArray(response);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject=(JSONObject) jsonArray.get(i);
                    City city=new City();
                    city.setProvinceId(provinceID);
                    city.setCityCode(jsonObject.getInt("id"));
                    city.setCityName(jsonObject.getString("name"));
                    city.save();
                    result=true;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }


    public static boolean handleCountyResponse(String response,int cityID){
        boolean result=false;
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray jsonArray=new JSONArray(response);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject=(JSONObject) jsonArray.get(i);
                    County county=new County();
                    county.setId(jsonObject.getInt("id"));
                    county.setCityId(cityID);
                    county.setCountyName(jsonObject.getString("name"));
                    county.setWeatherId(jsonObject.getString("weather_id"));
                    county.save();
                    result=true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
