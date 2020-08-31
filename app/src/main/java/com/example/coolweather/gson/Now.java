package com.example.coolweather.gson;

public class Now {
    String obsTime;
    String temp;
    String text;


    String aqi;
    String category;
    String pm2p5;

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPm2p5() {
        return pm2p5;
    }

    public void setPm2p5(String pm2p5) {
        this.pm2p5 = pm2p5;
    }


    public String getObsTime() {
        return obsTime;
    }

    public void setObsTime(String obsTime) {
        this.obsTime = obsTime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
