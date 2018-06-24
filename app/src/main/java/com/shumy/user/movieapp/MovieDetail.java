package com.shumy.user.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class MovieDetail extends DisplayActivity {

    private static final String TAG = "MovieDetail";

    ImageView bigPoster;
    TextView movieTitle;
    TextView movieYear;
    TextView movieRating;
    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        bigPoster = findViewById(R.id.bigPosterImageView);
        movieTitle = findViewById(R.id.detailTitleTextView);
        movieYear = findViewById(R.id.detailYearTextView);
        movieRating = findViewById(R.id.detailRatingTextView);
        summary = findViewById(R.id.summaryTextView);

        Intent detailIntent = getIntent();

        Movie movie = (Movie) detailIntent.getSerializableExtra(MOVIE_TRANSFER);

        if(movie != null) {

            movieTitle.setText(movie.getTitle());
            movieYear.setText(movie.getReleaseYear());
            movieRating.setText(movie.getRating());
            summary.setText(movie.getSummary());

            Picasso.get().load(movie.getPosterURL())
                    .error(R.drawable.baseline_image_black_48dp)
                    .placeholder(R.drawable.baseline_image_black_48dp)
                    .into(bigPoster);
        }








    }
}
