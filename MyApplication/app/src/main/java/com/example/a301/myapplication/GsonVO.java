package com.example.a301.myapplication;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by 301 on 2017-09-19.
 */

public class GsonVO {

    @SerializedName("response")
    @Expose
    private String master;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("items")
    @Expose
    private String items;
    @SerializedName("item")
    @Expose
    private String item;

    ////////필요한부분
    private ArrayList<DataVO> dataList = null;

    public ArrayList<DataVO> getDataList() {
        Log.v("Testing","Gson getData");
        return dataList;
    }
    //////////////


    public void setDataList(ArrayList<DataVO> dataList) {
        this.dataList = dataList;
    }
}
