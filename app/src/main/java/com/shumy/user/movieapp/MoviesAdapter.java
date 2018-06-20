package com.shumy.user.movieapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

//public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
//
//    private Context mContext;
//    private List<Movie> mMovieList;
//
//    public MoviesAdapter(Context mContext, List<Movie> mMovieList) {
//        this.mContext = mContext;
//        this.mMovieList = mMovieList;
//    }
//
//    @Override
//    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(final MoviesAdapter.MyViewHolder viewHolder,int i) {
//        viewHolder.title.setText(mMovieList.get(i).getTitle());
//        viewHolder.year.setText(mMovieList.get(i).getReleaseYear());
//        viewHolder.rating.setText(mMovieList.get(i).getRating());
//        viewHolder.poster.setImageResource(R.drawable.baseline_image_black_48);
//    }
//
//    @Override
//    public int getItemCount() {
//        return mMovieList.size();
//    }
//
//    void loadNewData(List<Movie> newMovies) {
//        mMovieList = newMovies;
//        notifyDataSetChanged();
//    }
//
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView title;
//        public TextView year;
//        public TextView rating;
//        public ImageView poster;
//
//        public MyViewHolder(View view) {
//            super(view);
//            title = view.findViewById(R.id.titleTextView);
//            year = view.findViewById(R.id.yearTextView);
//            rating = view.findViewById(R.id.ratingTextView);
//            poster = view.findViewById(R.id.posterImageView);
//
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int pos = getAdapterPosition();
//                    if(pos != RecyclerView.NO_POSITION) {
//                        Movie clickDataItem = mMovieList.get(pos);
//                        Intent intent = new Intent(mContext, DetailActivity.class);
//                        intent.putExtra("Title",mMovieList.get(pos).getTitle());
//                        intent.putExtra("Release Year",mMovieList.get(pos).getReleaseYear());
//                        intent.putExtra("Rating",mMovieList.get(pos).getRating());
//                        intent.putExtra("Summary",mMovieList.get(pos).getSummary());
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        mContext.startActivity(intent);
//                        Toast.makeText(v.getContext(),"You clicked " + clickDataItem.getTitle(),Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//    }
//
//}

class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private static final String TAG = "MoviesAdapter";
    private List<Movie> mMovieList;
    private Context mContext;

    public MoviesAdapter(Context context, List<Movie> movieList) {
        mContext = context;
        mMovieList = movieList;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        // Called by the layout manager when it wants new data in an existing row

        Movie movieItem = mMovieList.get(position);
        Log.d(TAG, "onBindViewHolder: " + movieItem.getTitle() + " --> " + position);

        holder.title.setText(movieItem.getTitle());
        holder.year.setText(movieItem.getReleaseYear());
        holder.rating.setText(movieItem.getRating());

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Title",mMovieList.get(position).getTitle());
        intent.putExtra("Release Year",mMovieList.get(position).getReleaseYear());
        intent.putExtra("Rating",mMovieList.get(position).getRating());
        intent.putExtra("Summary",mMovieList.get(position).getSummary());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((mMovieList != null) && (mMovieList.size() !=0) ? mMovieList.size() : 0);
    }

    void loadNewData(List<Movie> newMovie) {
        mMovieList = newMovie;
        notifyDataSetChanged();
    }

    public Movie getMovie(int position) {
        return ((mMovieList != null) && (mMovieList.size() !=0) ? mMovieList.get(position) : null);
    }

    static class MoviesViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "MoviesViewHolder";
        public TextView title;
        public TextView year;
        public TextView rating;


        public MoviesViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titleTextView);
            year = view.findViewById(R.id.yearTextView);
            rating = view.findViewById(R.id.ratingTextView);






        }
    }
}

