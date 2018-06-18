package com.shumy.user.movieapp;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetMovieJsonData implements GetRawData.OnDownloadComplete {

    private static final String TAG = "GetMovieJsonData";

    private List<Movie> mMovieList = null;
    private String mBaseURL;
    private String mMoviePar;
    private boolean mMatch;
    private String mAPI;
    private String mLanguage;
    private String mPage;

////////////////////////////////////////////////////////////////////////////////////////////////////
// Use call back field to MainActivity to send the Data when available
// Gives back a list of movies and the download status
////////////////////////////////////////////////////////////////////////////////////////////////////

    private final OnDataAvailable mCallback;

    interface OnDataAvailable {
        void onDataAvailable(List<Movie> data, DownloadStatus status);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
// Constructor for all the parameters
////////////////////////////////////////////////////////////////////////////////////////////////////

    public GetMovieJsonData(OnDataAvailable callback, String baseURL,String API, String language, String page) {
        Log.d(TAG, "GetMovieJsonData called");
        mBaseURL = baseURL;
        mAPI = API;
        mLanguage = language;
        mPage = page;
        mCallback = callback;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////////////////////////////////////////////////

    void executeOnSameThread(String searchCriteria) {
        Log.d(TAG, "executeOnSameThread starts");
        String destinationUri = createdUri(mAPI,mLanguage,mPage);

        GetRawData getRawData = new GetRawData(this);
        getRawData.execute(destinationUri);
        Log.d(TAG, "executeOnSameThread ends");
    }

    private String createUri(String API,String language,String page) {
        Log.d(TAG, "createUri starts");

        return Uri.parse(mBaseURL).buildUpon()
                .appendQueryParameter("api_key",API)
                .appendQueryParameter("language",language)
                .appendQueryParameter("page",page)
                .build().toString();
    }

    @Override
    public void onDownloadComplete(String data, DownloadStatus status) {
        Log.d(TAG, "onDownloadComplete starts. Status " + status);

        if(status == DownloadStatus.OK) {
            mMovieList = new ArrayList<>();

            try {
                JSONObject jsonData  = new JSONObject(data);
                JSONArray itemsArray = jsonData.getJSONArray("movie");

                for(int i=0; i<itemsArray.length();i++) {
                    JSONObject jsonMovie = itemsArray.getJSONObject(i);

                    String title = jsonMovie.getString("title");
                    String releaseYear = jsonMovie.getString("release_date");
                    String rating = jsonMovie.getString("vote_average");
                    String summary = jsonMovie.getString("overview");
                    String poster = jsonMovie.getString("poster_path");
                }
            }
        }
    }


}





















