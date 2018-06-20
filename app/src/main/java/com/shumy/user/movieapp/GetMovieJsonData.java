//package com.shumy.user.movieapp;
//
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GetMovieJsonData extends AsyncTask<String,Void,List<Movie>>  {
//
//    private static final String TAG = "GetMovieJsonData";
//
//    private List<Movie> mMovieList = null;
//    private String mBaseURL;
//
//////////////////////////////////////////////////////////////////////////////////////////////////////
//// Use call back field to MainActivity to send the Data when available
//// Gives back a list of movies and the download status
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    private final OnDataAvailable mCallback;
//
//    interface OnDataAvailable {
//        void onDataAvailable(List<Movie> data, DownloadStatus status);
//    }
//
//////////////////////////////////////////////////////////////////////////////////////////////////////
//// Constructor for all the parameters
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public GetMovieJsonData(OnDataAvailable callback, String baseURL,String API, String language, String page) {
//        Log.d(TAG, "GetMovieJsonData called");
//        mBaseURL = baseURL;
//        mCallback = callback;
//    }
//
//////////////////////////////////////////////////////////////////////////////////////////////////////
////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    @Override
//    protected List<Movie> doInBackground(String... params) {
//        Log.d(TAG, "doInBackground starts");
//        GetRawData getRawData = new GetRawData(this);
//        Log.d(TAG, "doInBackground ends");
//        return mMovieList;
//    }
//
//
//    @Override
//    public void onDownloadComplete(String data, DownloadStatus status) {
//        Log.d(TAG, "onDownloadComplete starts. Status " + status);
//
//        if(status == DownloadStatus.OK) {
//            mMovieList = new ArrayList<>();
//
//            try {
//                JSONObject jsonData  = new JSONObject(data);
//                JSONArray itemsArray = jsonData.getJSONArray("movie");
//
//                for(int i=0; i<itemsArray.length();i++) {
//                    JSONObject jsonMovie = itemsArray.getJSONObject(i);
//
//                    String title = jsonMovie.getString("title");
//                    String releaseYear = jsonMovie.getString("release_date");
//                    String rating = jsonMovie.getString("vote_average");
//                    String summary = jsonMovie.getString("overview");
//                    String poster = jsonMovie.getString("poster_path");
//
//                    Movie movieObject = new Movie(title,releaseYear,rating,summary,poster);
//                    mMovieList.add(movieObject);
//
//                    Log.d(TAG, "onDownloadComplete " + movieObject.toString());
//                }
//            } catch(JSONException jsone) {
//                jsone.printStackTrace();
//                Log.e(TAG, "onDownloadComplete: Error processing Json data " + jsone.getMessage());
//                status = DownloadStatus.FAILED_OR_EMPTY;
//            }
//        }
//    }
//
//
//}





















