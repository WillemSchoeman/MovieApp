package com.shumy.user.movieapp;

public class Movie {

    String title;
    String releaseYear;
    String rating;
    String summary;

    public Movie(String title, String releaseYear, String rating, String summary) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", rating='" + rating + '\'' +
                ", summory='" + summary + '\'' +
                '}';
    }
}
