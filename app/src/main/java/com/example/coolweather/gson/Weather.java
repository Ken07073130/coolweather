package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {
    private String code;
    private String updateTime;
    private String fxLink;
    private Now now;


    @SerializedName("daily")
    private List<Daily> dailyList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public List<Daily> getDailyList() {
        return dailyList;
    }

    public void setDailyList(List<Daily> dailyList) {
        this.dailyList = dailyList;
    }
}
