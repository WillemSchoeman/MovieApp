package com.shumy.user.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // now_playing https://api.themoviedb.org/3/movie/now_playing?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // popular https://api.themoviedb.org/3/movie/popular?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // top_rated https://api.themoviedb.org/3/movie/top_rated?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // upcoming https://api.themoviedb.org/3/movie/upcoming?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1

    // basic search https://api.themoviedb.org/3/search/movie?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&query=deadpool&page=1&include_adult=false

    // baseURL https://api.themoviedb.org/3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
