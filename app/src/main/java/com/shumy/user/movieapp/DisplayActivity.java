package com.shumy.user.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayActivity extends MainActivity {

    private static final String TAG = "DisplayActivity";

    TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String myURL = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        GetRawData getRawData = new GetRawData(this);
        getRawData.execute(myURL);
    }



    public void onDownloadComplete(String data,DownloadStatus status) {
        if(status == DownloadStatus.OK) {
//            Log.d(TAG, "onDownloadComplete: data is " + data);

            displayTextView = findViewById(R.id.displayTextView);
            displayTextView.setText(data);
        }
        else {
            // download or processing failed
            Log.e(TAG, "onDownloadComplete failed with status" + status);
        }

    }

}
