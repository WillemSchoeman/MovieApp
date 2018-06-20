package com.shumy.user.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class DisplayActivity extends MainActivity implements GetMovieJsonData.OnDataAvailable {

    private static final String TAG = "DisplayActivity";

    TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

//        Intent intent = getIntent();
//        String myURL = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

//        GetRawData getRawData = new GetRawData(this);
//        getRawData.execute(myURL);



    }

    public void onDataAvailable(List<Movie> data, DownloadStatus status) {
        if(status == DownloadStatus.OK) {
            Log.d(TAG, "onAvailableComplete: data is " + data);

//            displayTextView = findViewById(R.id.displayTextView);
//            displayTextView.setText();
        }
        else {
            // download or processing failed
            Log.e(TAG, "onAvailableComplete failed with status" + status);
        }
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


}
