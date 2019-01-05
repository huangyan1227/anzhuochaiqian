package com.examplechaiqian.py.mytabrapplication;

import android.app.Application;

public class Data extends Application {

    private  String logState;

    public void setLogState(String logState) {

        this.logState = logState;

    }


    public String getLogState() {

        return logState;

    }


    @Override
    public void onCreate() {

        logState = "你好啊";

        super.onCreate();
    }
}
