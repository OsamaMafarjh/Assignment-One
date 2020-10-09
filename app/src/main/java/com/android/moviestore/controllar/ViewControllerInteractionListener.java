package com.android.moviestore.controllar;

import com.android.moviestore.model.CategorizedMovieModel;
import com.android.moviestore.model.MovieGenre;

import java.util.List;

public interface ViewControllerInteractionListener {

    void getAllMovies(List<CategorizedMovieModel>  categorizedMovieModels);
    void getSearchResultMovies(List<CategorizedMovieModel> searchResult);
    void getMovieGenresList(List<MovieGenre> genres);
}
