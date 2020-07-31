package com.noobcode.brief.view.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.noobcode.brief.R;

public class MovieListFragmentDirections {
  private MovieListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMovieListFragmentToMovieDetailFragment() {
    return new ActionOnlyNavDirections(R.id.action_movieListFragment_to_movieDetailFragment);
  }
}
