package com.android.moviestore.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.moviestore.R;

public class MovieItemPlaceholder extends RecyclerView.ViewHolder  {

    protected AppCompatImageView movieCoverAppCompatImageView; //appcompat_img_view_movie_cover_image_card_movie_details_holder

    protected AppCompatTextView movieTitleAppCompatTextView;//appcompat_txt_view_movie_title_text_card_movie_details_holder

    protected AppCompatTextView movieProductionYearAppCompatTextView;//appcompat_txt_view_movie_name_text_card_movie_details_holder

    public MovieItemPlaceholder(@NonNull View itemView) {
        super(itemView);

        this.movieCoverAppCompatImageView = itemView.
                findViewById(R.id.appcompat_img_view_movie_cover_image_card_movie_details_holder);
        this.movieTitleAppCompatTextView = itemView.
                findViewById(R.id.appcompat_txt_view_movie_title_text_card_movie_details_holder);
        this.movieProductionYearAppCompatTextView = itemView.
                findViewById(R.id.appcompat_txt_view_movie_name_text_card_movie_details_holder);
    }

    public AppCompatImageView getMovieCoverAppCompatImageView() {
        return movieCoverAppCompatImageView;
    }

    public void setMovieCoverAppCompatImageView(AppCompatImageView movieCoverAppCompatImageView) {
        this.movieCoverAppCompatImageView = movieCoverAppCompatImageView;
    }

    public AppCompatTextView getMovieTitleAppCompatTextView() {
        return movieTitleAppCompatTextView;
    }

    public void setMovieTitleAppCompatTextView(AppCompatTextView movieTitleAppCompatTextView) {
        this.movieTitleAppCompatTextView = movieTitleAppCompatTextView;
    }

    public AppCompatTextView getMovieProductionYearAppCompatTextView() {
        return movieProductionYearAppCompatTextView;
    }

    public void setMovieProductionYearAppCompatTextView(AppCompatTextView movieProductionYearAppCompatTextView) {
        this.movieProductionYearAppCompatTextView = movieProductionYearAppCompatTextView;
    }
}
