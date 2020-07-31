package com.noobcode.brief.view.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.noobcode.brief.R;

public class MovieDetailFragmentDirections {
  private MovieDetailFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMovieDetailFragmentToMovieListFragment() {
    return new ActionOnlyNavDirections(R.id.action_movieDetailFragment_to_movieListFragment);
  }
}
