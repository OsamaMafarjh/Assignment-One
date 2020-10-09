package com.android.moviestore.model;

import com.android.moviestore.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesModel {

    private List<CategorizedMovieModel> categorizedMovieModelList = new ArrayList<>();

    public CategorizedMovieModel getMovie(int position) {

        return categorizedMovieModelList.get(position);
    }

    public void addMovie(CategorizedMovieModel categorizedMovieModel) {

        categorizedMovieModelList.add(categorizedMovieModel);

    }

    public List<CategorizedMovieModel> loadMovies() {

        //create list of categorized movies
        CategorizedMovieModel movie1 = MovieFactory.getMovie(MovieGenre.ACTION, R.drawable.attack_cover, "Attack", 2020);
        CategorizedMovieModel movie2 = MovieFactory.getMovie(MovieGenre.ACTION, R.drawable.bad_blood, "Bad Blood", 2010);
        CategorizedMovieModel movie3 = MovieFactory.getMovie(MovieGenre.ACTION, R.drawable.flash_gordon_cover, "Flash Gordon", 1980);
        CategorizedMovieModel movie4 = MovieFactory.getMovie(MovieGenre.COMEDY, R.drawable.almost_famous_cover, "Almost Famous", 2000);
        CategorizedMovieModel movie5 = MovieFactory.getMovie(MovieGenre.COMEDY, R.drawable.the_tristocrats_album_cover, "The Aristocrats", 1970);
        CategorizedMovieModel movie6 = MovieFactory.getMovie(MovieGenre.COMEDY, R.drawable.somthing_gotta_cover, "Something's Gotta Give", 2003);
        CategorizedMovieModel movie7 = MovieFactory.getMovie(MovieGenre.HORROR, R.drawable.frankenstein_cover, "Frankenstein", 1990);
        CategorizedMovieModel movie8 = MovieFactory.getMovie(MovieGenre.HORROR, R.drawable.halloween_kills_cover, "Halloween Kills", 2020);
        CategorizedMovieModel movie9 = MovieFactory.getMovie(MovieGenre.ROMANCE, R.drawable.things_cover, "10 Things I Hate About You", 2010);
        CategorizedMovieModel movie10 = MovieFactory.getMovie(MovieGenre.ROMANCE, R.drawable.forever_cover, "Forever Young", 2014);
        CategorizedMovieModel movie11 = MovieFactory.getMovie(MovieGenre.DRAMA, R.drawable.abraham_cover, "Abraham Lincoln", 1930);
        CategorizedMovieModel movie12 = MovieFactory.getMovie(MovieGenre.DRAMA, R.drawable.eugene_cover, "Eugene Aram ", 1915);
        CategorizedMovieModel movie13 = MovieFactory.getMovie(MovieGenre.CRIME, R.drawable.the_killing_jar_cover, "The Killing Jar", 2020);
        CategorizedMovieModel movie14 = MovieFactory.getMovie(MovieGenre.CRIME, R.drawable.the_killing_cover, "The Killing", 2014);
        CategorizedMovieModel movie15 = MovieFactory.getMovie(MovieGenre.CRIME, R.drawable.end_of_watch_poster, "End of Watch", 2012);

        addMovie(movie1);
        addMovie(movie2);
        addMovie(movie3);
        addMovie(movie4);
        addMovie(movie5);
        addMovie(movie6);
        addMovie(movie7);
        addMovie(movie8);
        addMovie(movie9);
        addMovie(movie10);
        addMovie(movie11);
        addMovie(movie12);
        addMovie(movie13);
        addMovie(movie14);
        addMovie(movie15);

        return categorizedMovieModelList;
    }

    public List<MovieGenre> getMovieGenres() {

        if (categorizedMovieModelList == null) return null;

        List<MovieGenre> genres = new ArrayList<>(categorizedMovieModelList.size());
        genres.add(MovieGenre.ALL);

        for (CategorizedMovieModel categorizedMovieModel : categorizedMovieModelList) {

            if (!genres.contains(categorizedMovieModel.getMovieGenre()))
                genres.add(categorizedMovieModel.getMovieGenre());
        }

        return genres;
    }

    public int getMoviesSize() {

        if (categorizedMovieModelList == null) return 0;
        return categorizedMovieModelList.size();

    }

    public List<CategorizedMovieModel> filterMoviesByTitleProductionYearOrGenre(MovieGenre movieGenre,
                                                                                String title,
                                                                                int productionYear) {

        if (categorizedMovieModelList == null) return null;

        //hold memory for the search result and the worst case all the movies are included
        List<CategorizedMovieModel> searchResultMovies = new ArrayList<>(categorizedMovieModelList.size());

        //loop and search for result
        for (CategorizedMovieModel categorizedMovieModel : categorizedMovieModelList) {

            if (movieGenre == MovieGenre.ALL && title.isEmpty() && productionYear == 0)
                return categorizedMovieModelList;

            if (movieGenre == MovieGenre.ALL) {

                if (productionYear > 0 && title.isEmpty()) {

                    if (categorizedMovieModel.getYear() == productionYear) {
                        searchResultMovies.add(categorizedMovieModel);
                    }
                } else if (productionYear == 0) {

                    if (categorizedMovieModel.getTitle().toLowerCase().contains(title.toLowerCase())) {
                        searchResultMovies.add(categorizedMovieModel);
                    }
                } else if (productionYear > 0) {

                    if (categorizedMovieModel.getTitle().toLowerCase().contains(title.toLowerCase()) &&
                            categorizedMovieModel.getYear() == productionYear) {
                        searchResultMovies.add(categorizedMovieModel);
                    }
                }
            } else if (productionYear == 0) {

                if (title.isEmpty()) {

                    if (categorizedMovieModel.getMovieGenre() == movieGenre) {

                        searchResultMovies.add(categorizedMovieModel);
                    }
                } else {

                    if (categorizedMovieModel.getTitle().toLowerCase().contains(title.toLowerCase()) ||
                            categorizedMovieModel.getMovieGenre() == movieGenre) {

                        searchResultMovies.add(categorizedMovieModel);
                    }
                }
            } else if (!title.isEmpty()) {

                if (categorizedMovieModel.getTitle().toLowerCase().contains(title.toLowerCase()) ||
                        categorizedMovieModel.getYear() == productionYear ||
                        categorizedMovieModel.getMovieGenre() == movieGenre) {

                    searchResultMovies.add(categorizedMovieModel);
                }
            } else if (categorizedMovieModel.getYear() == productionYear &&
                    categorizedMovieModel.getMovieGenre() == movieGenre) {

                searchResultMovies.add(categorizedMovieModel);
            }
        }

        return searchResultMovies;
    }
}
