package com.shumy.user.movieapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

enum DownloadStatus {IDLE,PROCESSING,NOT_INITIALISED,FAILED_OR_EMPTY,OK}

public class GetRawData extends AsyncTask<String,Void,String> {

    private static final String TAG = "GetRawData";

    private DownloadStatus mDownloadStatus;
    private final GetMovieJsonData mCallback;

////////////////////////////////////////////////////////////////////////////////////////////////////
// Enables GetRawData to call back to the MainActivity
////////////////////////////////////////////////////////////////////////////////////////////////////


    public GetRawData(GetMovieJsonData callback) {
        this.mDownloadStatus = DownloadStatus.IDLE;
        mCallback = callback;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
// Used to open the connection to the API
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected String doInBackground(String... strings) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        if(strings == null) {
            mDownloadStatus = DownloadStatus.NOT_INITIALISED;
            return null;
        }
        try {
            mDownloadStatus = DownloadStatus.PROCESSING;

            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int response = connection.getResponseCode();
            Log.d(TAG, "doInBackground: The response code was " + response);

            StringBuilder result = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            for(String line = reader.readLine(); line!=null; line = reader.readLine()) {
                result.append(line).append("\n");
            }

            mDownloadStatus = DownloadStatus.OK;
            return result.toString();

        }
        catch(MalformedURLException e) {
        Log.e(TAG, "doInBackground: Invalid URL " + e.getMessage() );
        }
        catch(IOException e) {
        Log.e(TAG, "doInBackground: IO Exception reading data: " + e.getMessage() );
        }
        catch(SecurityException e) {
        Log.e(TAG, "doInBackground: Security Exception. Needs permission? " + e.getMessage());
        }
        finally {
            if(connection != null) {
                connection.disconnect();
            }
            if(reader != null) {
                try {
                    reader.close();
                } catch(IOException e) {
                    Log.e(TAG, "doInBackground: Error closing stream " + e.getMessage() );
                }
            }
        }
        mDownloadStatus = DownloadStatus.FAILED_OR_EMPTY;
        return null;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////
// This defines the method the callback must use
////////////////////////////////////////////////////////////////////////////////////////////////////

    interface OnDownloadComplete {
        void onDownloadComplete(String data,DownloadStatus status);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
// When the data download is completed, the onDownloadComplete function is called and
// download status and data is given to onDownloadComplete in MainActivity
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onPostExecute(String s) {
        Log.d(TAG, "onPostExecute: parameter = " + s);
        if(mCallback != null) {
            mCallback.onDownloadComplete(s,mDownloadStatus);
        }
        Log.d(TAG, "onPostExecute: ends");
    }



}
