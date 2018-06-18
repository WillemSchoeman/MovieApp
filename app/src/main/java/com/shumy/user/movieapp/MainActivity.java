package com.shumy.user.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements GetRawData.OnDownloadComplete {

    private static final String TAG = "MainActivity";

    // now_playing https://api.themoviedb.org/3/movie/now_playing?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // popular https://api.themoviedb.org/3/movie/popular?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // top_rated https://api.themoviedb.org/3/movie/top_rated?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // upcoming https://api.themoviedb.org/3/movie/upcoming?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1

    // basic search https://api.themoviedb.org/3/search/movie?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&query=deadpool&page=1&include_adult=false

    // baseURL https://api.themoviedb.org/3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetRawData getRawData = new GetRawData(this);
        getRawData.execute("https://api.themoviedb.org/3/movie/now_playing?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1");

        Log.d(TAG, "onCreate: ends");
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
// Block used to see if download is complete and then log the data or return error
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onDownloadComplete(String data,DownloadStatus status) {
        if(status == DownloadStatus.OK) {
            Log.d(TAG, "onDownloadComplete: data is " + data);
        }else {
            Log.e(TAG, "onDownloadComplete failed with status " + status);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
}
