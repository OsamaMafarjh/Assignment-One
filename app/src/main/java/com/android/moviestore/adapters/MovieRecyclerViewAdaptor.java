package com.android.moviestore.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviestore.R;
import com.android.moviestore.model.CategorizedMovieModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MovieRecyclerViewAdaptor extends RecyclerView.Adapter<MovieItemPlaceholder> {


    private static final String LOG_TAG = MovieRecyclerViewAdaptor.class.getSimpleName();
    protected Context context;
    private List<CategorizedMovieModel> movieList;

    public MovieRecyclerViewAdaptor(Context context, List<CategorizedMovieModel> movieList) {
        super();
        this.context = context;
        this.movieList = movieList;
    }

    @NotNull
    @Override
    public MovieItemPlaceholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_view_holder, parent, false);
        return new MovieItemPlaceholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemPlaceholder holder, int position) {

        final CategorizedMovieModel movieModel = movieList.get(position);

        try {

            holder.getMovieCoverAppCompatImageView().setImageResource(movieModel.getMovieCoverImage());
        } catch (Exception ex) {
            Log.e(LOG_TAG, ex.getMessage(), ex);
        }

        holder.getMovieTitleAppCompatTextView().setText(movieModel.getTitle());
        holder.getMovieProductionYearAppCompatTextView().setText(movieModel.getYear() + "");
    }

    @Override
    public int getItemCount() {
        if (movieList == null) return 0;
        return movieList.size();
    }


    public void setMovies(List<CategorizedMovieModel> booksList) {
        this.movieList = booksList;
    }
}
