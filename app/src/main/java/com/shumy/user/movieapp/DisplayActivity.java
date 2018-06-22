package com.shumy.user.movieapp;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends MainActivity implements GetMovieJsonData.OnDataAvailable,RecyclerItemClickListener.OnRecyclerClickListener {

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

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView,this));


        mMovieAdapter = new MovieAdapter(this, new ArrayList<Movie>());
        recyclerView.setAdapter(mMovieAdapter);

        Log.d(TAG, "onCreate: ends");
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

            Log.d(TAG, "onDataAvailable: movie is" + movies);

            mMovieAdapter.loadNewData(movies);

        }
        else {
            // download or processing failed
            Log.e(TAG, "onAvailableComplete failed with status" + status);
        }
        Log.d(TAG, "onDataAvailable: ends");
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: starts");
        Toast.makeText(DisplayActivity.this,"Normal tap at position" + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: starts");
//        Toast.makeText(DisplayActivity.this,"Long tap at position " + position,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,MovieDetailActivity.class);
        intent.putExtra(PHOTO_TRANSFER,mMovieAdapter.getMovie(position));
        startActivity(intent);
    }
}
