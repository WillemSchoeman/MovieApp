package com.shumy.user.movieapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetMovieJsonData extends AsyncTask<String,Void,List<Movie>> implements GetRawData.OnDownloadComplete {

    private static final String TAG = "GetMovieJsonData";

    private List<Movie> mMovieList = null;
    private String newURL;
    private final OnDataAvailable mCallBack;

////////////////////////////////////////////////////////////////////////////////////////////////////
// Use call back field to MainActivity to send the Data when available
// Gives back a list of movies and the download status
////////////////////////////////////////////////////////////////////////////////////////////////////

    interface OnDataAvailable {
        void onDataAvailable(List<Movie> data, DownloadStatus status);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
// Constructor for all the parameters
////////////////////////////////////////////////////////////////////////////////////////////////////

    public GetMovieJsonData(OnDataAvailable callback, String myURL) {
        Log.d(TAG, "GetMovieJsonData called");
        mCallBack = callback;
        newURL = myURL;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onPostExecute(List<Movie> movies) {
        Log.d(TAG, "onPostExecute starts");

        if(mCallBack != null) {
            mCallBack.onDataAvailable(mMovieList, DownloadStatus.OK);
        }
        Log.d(TAG, "onPostExecute ends");
    }
        
    @Override
    protected List<Movie> doInBackground(String... params) {
        Log.d(TAG, "doInBackground starts");
        GetRawData getRawData = new GetRawData(this);
        getRawData.execute(newURL);
        Log.d(TAG, "doInBackground ends");
        return mMovieList;
    }

    @Override
    public void onDownloadComplete(String data, DownloadStatus status) {
        Log.d(TAG, "onDownloadComplete starts. Status " + status);

        if(status == DownloadStatus.OK) {
            mMovieList = new ArrayList<>();

            try {
                JSONObject jsonData  = new JSONObject(data);
                JSONArray itemsArray = jsonData.getJSONArray("results");

                for(int i=0; i<itemsArray.length();i++) {
                    JSONObject jsonMovie = itemsArray.getJSONObject(i);

                    String title = jsonMovie.getString("title");
                    String releaseYear = jsonMovie.getString("release_date");
                    String rating = jsonMovie.getString("vote_average");
                    String summary = jsonMovie.getString("overview");
                    String poster = jsonMovie.getString("poster_path");

                    Movie movieObject = new Movie(title,releaseYear,rating,summary,poster);
                    mMovieList.add(movieObject);

                    Log.d(TAG, "onDownloadComplete " + movieObject.toString());
                }
            } catch(JSONException jsone) {
                jsone.printStackTrace();
                Log.e(TAG, "onDownloadComplete: Error processing Json data " + jsone.getMessage());
                status = DownloadStatus.FAILED_OR_EMPTY;
            }
        }

        if(mCallBack != null) {
            mCallBack.onDataAvailable(mMovieList,status);
        }
        Log.d(TAG, "onDownloadComplete: ends");
    }
}





















