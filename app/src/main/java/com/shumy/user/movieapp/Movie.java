package com.shumy.user.movieapp;

public class Movie {

    private String mTitle;
    private String mReleaseYear;
    private String mRating;
    private String mSummary;
    private String mPoster;
    private String mPosterURL;

    public Movie(String title, String releaseYear, String rating, String summary, String poster, String posterURL) {
        mTitle = title;
        mReleaseYear = releaseYear;
        mRating = rating;
        mSummary = summary;
        mPoster = poster;
        mPosterURL = posterURL;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getReleaseYear() {
        return mReleaseYear;
    }

    public String getRating() {
        return mRating;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getPoster() {
        return mPoster;
    }

    public String getPosterURL() { return mPosterURL; }

    @Override
    public String toString() {
        return "Movie{" +
                "mTitle='" + mTitle + '\'' +
                ", mReleaseYear='" + mReleaseYear + '\'' +
                ", mRating='" + mRating + '\'' +
                ", mSummary='" + mSummary + '\'' +
                ", mPoster='" + mPoster + '\'' +
                ", mPosterURL'" + mPosterURL + '\'' +
                '}';
    }
}
