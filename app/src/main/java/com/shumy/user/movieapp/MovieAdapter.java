package com.shumy.user.movieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static final String TAG = "MovieAdapter";

    private List<Movie> mMovieList;
    private Context mContext;

    public MovieAdapter(Context context,List<Movie> movieList) {
        mContext = context;
        mMovieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        //called by the layout manager when it wants new data in an existing row

        Movie movieItem = mMovieList.get(position);
        Log.d(TAG, "onBindViewHolder: " + movieItem.getTitle() + "-->" + position);
        Picasso.get().load(movieItem.getPosterURL())
                .error(R.drawable.baseline_image_black_48dp)
                .placeholder(R.drawable.baseline_image_black_48dp)
                .into(holder.poster);

        holder.title.setText(movieItem.getTitle());
        //holder.year.setText(movieItem.getReleaseYear());
       // holder.rating.setText(movieItem.getRating());
    }

    @Override
    public int getItemCount() {
        //Log.d(TAG, "getItemCount: called");
        return ((mMovieList != null) && (mMovieList.size() !=0) ? mMovieList.size() : 0);
    }

    void loadNewData(List<Movie> newMovie) {
        mMovieList = newMovie;
        notifyDataSetChanged();
    }

    public Movie getMovie(int position) {
        return ((mMovieList != null) && (mMovieList.size() !=0) ? mMovieList.get(position) : null);
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieViewHolder";

        ImageView poster;
        TextView title;
        //TextView year;
        //TextView rating;

        public MovieViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "MovieImageViewHolder: starts");

            this.poster = itemView.findViewById(R.id.posterImageView);
            this.title = itemView.findViewById(R.id.titleTextView);
            //this.year = itemView.findViewById(R.id.yearTextView);
            //this.rating = itemView.findViewById(R.id.ratingTextView);
        }

    }



}
