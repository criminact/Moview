// Generated code from Butter Knife. Do not modify!
package com.noobcode.brief.view.fragments;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.noobcode.brief.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieListFragment_ViewBinding implements Unbinder {
  private MovieListFragment target;

  @UiThread
  public MovieListFragment_ViewBinding(MovieListFragment target, View source) {
    this.target = target;

    target.moviewView = Utils.findRequiredViewAsType(source, R.id.movie_recyclerview, "field 'moviewView'", RecyclerView.class);
    target.error = Utils.findRequiredViewAsType(source, R.id.error_string, "field 'error'", TextView.class);
    target.progress = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progress'", ProgressBar.class);
    target.previous = Utils.findRequiredViewAsType(source, R.id.previous, "field 'previous'", FloatingActionButton.class);
    target.next = Utils.findRequiredViewAsType(source, R.id.next, "field 'next'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.moviewView = null;
    target.error = null;
    target.progress = null;
    target.previous = null;
    target.next = null;
  }
}
