// Generated by data binding compiler. Do not edit!
package com.noobcode.brief.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.noobcode.brief.R;
import com.noobcode.brief.viewmodel.MovieListViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMovieListBinding extends ViewDataBinding {
  @NonNull
  public final TextView errorString;

  @NonNull
  public final RecyclerView movieRecyclerview;

  @NonNull
  public final FloatingActionButton next;

  @NonNull
  public final FloatingActionButton previous;

  @NonNull
  public final ProgressBar progress;

  @Bindable
  protected MovieListViewModel mViewmodel;

  protected FragmentMovieListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView errorString, RecyclerView movieRecyclerview, FloatingActionButton next,
      FloatingActionButton previous, ProgressBar progress) {
    super(_bindingComponent, _root, _localFieldCount);
    this.errorString = errorString;
    this.movieRecyclerview = movieRecyclerview;
    this.next = next;
    this.previous = previous;
    this.progress = progress;
  }

  public abstract void setViewmodel(@Nullable MovieListViewModel viewmodel);

  @Nullable
  public MovieListViewModel getViewmodel() {
    return mViewmodel;
  }

  @NonNull
  public static FragmentMovieListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMovieListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMovieListBinding>inflateInternal(inflater, R.layout.fragment_movie_list, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMovieListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMovieListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMovieListBinding>inflateInternal(inflater, R.layout.fragment_movie_list, null, false, component);
  }

  public static FragmentMovieListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentMovieListBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMovieListBinding)bind(component, view, R.layout.fragment_movie_list);
  }
}