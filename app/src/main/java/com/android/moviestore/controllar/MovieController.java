package com.android.moviestore.controllar;

import com.android.moviestore.model.MovieGenre;
import com.android.moviestore.model.MoviesModel;

public class MovieController {

    private MoviesModel moviesModel = new MoviesModel();
    private ViewControllerInteractionListener viewControllerInteractionListener;

    public MovieController(ViewControllerInteractionListener viewControllerInteractionListener) {
        this.viewControllerInteractionListener = viewControllerInteractionListener;
    }

    public void loadAndGetMoviesData() {

        viewControllerInteractionListener.getAllMovies(moviesModel.loadMovies());
    }

    public void filterMovies(String title, int year, MovieGenre movieGenre) {

        viewControllerInteractionListener.getSearchResultMovies(moviesModel.filterMoviesByTitleProductionYearOrGenre(movieGenre, title, year));
    }

    public void loadMovieGenres() {

        viewControllerInteractionListener.getMovieGenresList(moviesModel.getMovieGenres());
    }
}
