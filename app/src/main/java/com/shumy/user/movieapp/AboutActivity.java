package com.shumy.user.movieapp;

import android.os.Bundle;
import android.util.Log;

public class AboutActivity extends MainActivity {

    private static final String TAG = "AboutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}
