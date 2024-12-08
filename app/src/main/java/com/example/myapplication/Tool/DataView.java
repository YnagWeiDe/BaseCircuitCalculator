package com.example.myapplication.Tool;

import android.content.Intent;

public class DataView {//数据源
    private String str;
    private Intent index;//跳转到的activity

    public DataView(String str, Intent index) {
        this.str = str;
        this.index = index;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Intent getIndex() {
        return index;
    }

    public void setIndex(Intent index) {
        this.index = index;
    }
}
