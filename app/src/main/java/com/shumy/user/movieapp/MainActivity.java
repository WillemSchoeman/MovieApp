package com.shumy.user.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    // now_playing https://api.themoviedb.org/3/movie/now_playing?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // popular https://api.themoviedb.org/3/movie/popular?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // top_rated https://api.themoviedb.org/3/movie/top_rated?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1
    // upcoming https://api.themoviedb.org/3/movie/upcoming?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1

    public static final String EXTRA_MESSAGE = "com.example.android.DisplayActivity.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button popularButton = findViewById(R.id.popularButton);
        Button playingButton = findViewById(R.id.playingButton);
        Button ratedButton = findViewById(R.id.ratedButton);
        Button upcomingButton = findViewById(R.id.upcomingButton);
        Button aboutButton = findViewById(R.id.aboutButton);
        popularButton.setOnClickListener(this);
        playingButton.setOnClickListener(this);
        ratedButton.setOnClickListener(this);
        upcomingButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);

        Log.d(TAG, "onCreate: ends");
    }

    public void onClick(View view) {
        Intent intent = null;
        String myURL;

        switch(view.getId()) {
            case R.id.popularButton:
                intent = new Intent(this,DisplayActivity.class);
                myURL = "https://api.themoviedb.org/3/movie/popular?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1";
                Log.d(TAG, "onClick: popular button pressed with URL is " + myURL);
                intent.putExtra(EXTRA_MESSAGE,myURL);
                break;
            case R.id.playingButton:
                intent = new Intent(this,DisplayActivity.class);
                myURL = "https://api.themoviedb.org/3/movie/now_playing?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1";
                Log.d(TAG, "onClick: playing button pressed with URL is " + myURL);
                intent.putExtra(EXTRA_MESSAGE,myURL);
                break;
            case R.id.ratedButton:
                intent = new Intent(this,DisplayActivity.class);
                myURL = "https://api.themoviedb.org/3/movie/top_rated?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1";
                Log.d(TAG, "onClick: rated button pressed with URL is " + myURL);
                intent.putExtra(EXTRA_MESSAGE,myURL);
                break;
            case R.id.upcomingButton:
                intent = new Intent(this,DisplayActivity.class);
                myURL = "https://api.themoviedb.org/3/movie/upcoming?api_key=d87c00b6a00ae74e930c063e106d6b4d&language=en-US&page=1";
                Log.d(TAG, "onClick: upcoming button pressed with URL is " + myURL);
                intent.putExtra(EXTRA_MESSAGE,myURL);
                break;
            case R.id.aboutButton:
                intent = new Intent(this,AboutActivity.class);
                break;

            default:

        }
        if(intent != null) {
            startActivity(intent);
        }
    }
}
