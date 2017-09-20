package com.example.a301.myapplication;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 301 on 2017-09-19.
 */

public class DataVO {


    @SerializedName("baseDate")
    @Expose
    private String baseDate;
    @SerializedName("baseTime")
    @Expose
    private String baseTime;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("nx")
    @Expose
    private String nx;
    @SerializedName("ny")
    @Expose
    private String ny;
    @SerializedName("obsrValue")
    @Expose
    private String obsrValue;

    public String getBaseDate() {
        Log.v("Testing","DataVO getBaseDate");
        return baseDate;
    }

    public String getBaseTime() {
        return baseTime;
    }

    public String getCategory() {
        return category;
    }

    public String getNx() {
        return nx;
    }

    public String getNy() {
        return ny;
    }

    public String getObsrValue() {
        return obsrValue;
    }

}
