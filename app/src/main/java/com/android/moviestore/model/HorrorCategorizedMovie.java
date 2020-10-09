package com.android.moviestore.model;

public class HorrorCategorizedMovie extends CategorizedMovieModel {

    private String title;
    private int year;
    private MovieGenre movieGenre;
    private int movieCover;

    public HorrorCategorizedMovie(String title,int movieCover,int year, MovieGenre movieGenre) {
        this.title = title;
        this.year = year;
        this.movieGenre = movieGenre;
        this.movieCover = movieCover;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    @Override
    public int getMovieCoverImage() {
        return movieCover;
    }
}
