package com.android.moviestore.model;


public abstract class CategorizedMovieModel {

    public abstract String getTitle();
    public abstract int getYear();
    public abstract MovieGenre getMovieGenre();
    public abstract int getMovieCoverImage();
}
