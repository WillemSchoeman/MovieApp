package com.shumy.user.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView movieTitle;
    TextView movieYear;
    TextView movieRating;
    TextView summary;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.movie_list);

        movieTitle = findViewById(R.id.movieTitleTextView);
        movieYear = findViewById(R.id.movieYearTextView);
        movieRating = findViewById(R.id.movieRatingTextView);
        summary = findViewById(R.id.summaryTextView);

        Intent detailIntent = getIntent();

        if(detailIntent.hasExtra("Title")) {

            String movieName = getIntent().getExtras().getString("Title");
            String releaseDate = getIntent().getExtras().getString("Release Year");
            String voterRating = getIntent().getExtras().getString("Rating");
            String movieSummary = getIntent().getExtras().getString("Summary");

            movieTitle.setText(movieName);
            movieYear.setText(releaseDate);
            movieRating.setText(voterRating);
            summary.setText(movieSummary);

        }
        else {
            Toast.makeText(this,"No API data",Toast.LENGTH_SHORT).show();
        }

    }

}
