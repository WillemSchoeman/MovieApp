package com.shumy.user.movieapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends MainActivity implements GetMovieJsonData.OnDataAvailable {

    private static final String TAG = "DisplayActivity";

    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

//        Intent intent = getIntent();
//        String myURL = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

//        GetRawData getRawData = new GetRawData(this);
//        getRawData.execute(myURL);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMovieAdapter = new MovieAdapter(this, new ArrayList<Movie>());
        recyclerView.setAdapter(mMovieAdapter);


    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume starts");
        super.onResume();
        Intent intent = getIntent();
        String myURL = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        GetMovieJsonData getMovieJsonData = new GetMovieJsonData(this,myURL);
        getMovieJsonData.execute();
        Log.d(TAG, "onResume ends");
    }

    public void onDataAvailable(List<Movie> movies, DownloadStatus status) {
        Log.d(TAG, "onAvailableComplete: starts");

        if(status == DownloadStatus.OK) {

            mMovieAdapter.loadNewData(movies);

        }
        else {
            // download or processing failed
            Log.e(TAG, "onAvailableComplete failed with status" + status);
        }
        Log.d(TAG, "onDataAvailable: ends");
    }




}
