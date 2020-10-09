package com.android.moviestore.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.moviestore.R;
import com.android.moviestore.adapters.MovieRecyclerViewAdaptor;
import com.android.moviestore.controllar.MovieController;
import com.android.moviestore.controllar.ViewControllerInteractionListener;
import com.android.moviestore.model.CategorizedMovieModel;
import com.android.moviestore.model.MovieGenre;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private RecyclerView movieListRecyclerView;
    private AppCompatEditText searchMovies;
    private AppCompatEditText searchByYear;
    private AppCompatEditText searchResultEditText;
    private Spinner movieGenresSpinner;

    private MovieRecyclerViewAdaptor movieRecyclerViewAdaptor;
    private MovieController movieController;
    private Context context;

    private MovieGenre selectedGenre = MovieGenre.ALL;
    private List<MovieGenre> movieGenres;

    ViewControllerInteractionListener viewControllerInteractionListener = new ViewControllerInteractionListener() {
        @Override
        public void getAllMovies(List<CategorizedMovieModel> categorizedMovieModels) {

            movieRecyclerViewAdaptor = new MovieRecyclerViewAdaptor(context, categorizedMovieModels);
            movieListRecyclerView.setAdapter(movieRecyclerViewAdaptor);

        }

        @Override
        public void getSearchResultMovies(List<CategorizedMovieModel> searchResult) {

            movieRecyclerViewAdaptor.setMovies(searchResult);
            movieListRecyclerView.post(new Runnable() {
                @Override
                public void run() {

                    movieRecyclerViewAdaptor.notifyDataSetChanged();
                }
            });

            if (selectedGenre == MovieGenre.ALL &&
                    (searchMovies.getText() == null || searchMovies.getText().toString().isEmpty()) &&
                    (searchByYear.getText() == null || searchByYear.getText().toString().isEmpty())) {
                searchResultEditText.setText("");
                return;
            }

            if (searchResult != null && searchResult.size() > 0) {

                String searchMoviesResult = "";

                for (int i = 0; i < searchResult.size(); i++) {

                    if (i == searchResult.size() - 1) {
                        searchMoviesResult = searchMoviesResult.concat(searchResult.get(i).getTitle());
                    } else {
                        searchMoviesResult = searchMoviesResult.concat(searchResult.get(i).getTitle().concat(", "));
                    }
                }

                searchResultEditText.setText(searchMoviesResult);
            }
        }

        @Override
        public void getMovieGenresList(List<MovieGenre> genres) {

            movieGenres = genres;
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter<MovieGenre> aa = new ArrayAdapter<MovieGenre>(context, android.R.layout.simple_spinner_item, genres);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            movieGenresSpinner.setAdapter(aa);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        bindUiComponents();

        movieController = new MovieController(viewControllerInteractionListener);
        movieController.loadAndGetMoviesData();
        movieController.loadMovieGenres();

        setupEditTextWatchers();
    }

    private void setupEditTextWatchers() {

        searchMovies.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (searchMovies.getText() != null)
                    movieController.filterMovies(searchMovies.getText().toString(),
                            searchByYear.getText() != null && !searchByYear.getText().toString().isEmpty() ?
                                    Integer.parseInt(searchByYear.getText().toString()) : 0, selectedGenre);
            }
        });

        searchByYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (searchByYear.getText() != null)
                    movieController.filterMovies(searchMovies.getText() != null ? searchMovies.getText().toString() : "",
                            searchByYear.getText() != null && !searchByYear.getText().toString().isEmpty()
                                    ? Integer.parseInt(searchByYear.getText().toString()) : 0, selectedGenre);
            }
        });
    }

    private void bindUiComponents() {

        searchMovies = findViewById(R.id.appcompat_edit_txt_search);
        searchByYear = findViewById(R.id.prodcution_year);
        searchResultEditText = findViewById(R.id.search_result);
        movieListRecyclerView = findViewById(R.id.recycler_vw_movies_activity);
        movieGenresSpinner = findViewById(R.id.genres);
        movieGenresSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        selectedGenre = movieGenres.get(position);
        movieController.filterMovies(searchMovies.getText() != null ? searchMovies.getText().toString() : "",
                searchByYear.getText() != null && !searchByYear.getText().toString().isEmpty()
                        ? Integer.parseInt(searchByYear.getText().toString()) : 0, selectedGenre);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}