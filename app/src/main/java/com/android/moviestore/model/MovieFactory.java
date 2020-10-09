package com.android.moviestore.model;

public class MovieFactory {

    public static CategorizedMovieModel getMovie(MovieGenre movieGenre, int movieCover, String title, int year) {

        switch (movieGenre) {

            case CRIME:
                return new CrimeCategorizedMovie(title, movieCover, year, movieGenre);
            case DRAMA:
                return new DramaCategorizedMovie(title, movieCover, year, movieGenre);
            case ACTION:
                return new ActionCategorizedMovie(title, movieCover, year, movieGenre);
            case COMEDY:
                return new ComedyCategorizedMovie(title, movieCover, year, movieGenre);
            case HORROR:
                return new HorrorCategorizedMovie(title, movieCover, year, movieGenre);
            case ROMANCE:
                return new RomanceCategorizedMovie(title, movieCover, year, movieGenre);
        }

        return null;
    }
}
