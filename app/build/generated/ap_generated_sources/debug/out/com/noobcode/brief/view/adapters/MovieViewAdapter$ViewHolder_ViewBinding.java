// Generated code from Butter Knife. Do not modify!
package com.noobcode.brief.view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.noobcode.brief.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieViewAdapter$ViewHolder_ViewBinding implements Unbinder {
  private MovieViewAdapter.ViewHolder target;

  @UiThread
  public MovieViewAdapter$ViewHolder_ViewBinding(MovieViewAdapter.ViewHolder target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.movie_title, "field 'title'", TextView.class);
    target.image = Utils.findRequiredViewAsType(source, R.id.movie_image, "field 'image'", ImageView.class);
    target.ratings = Utils.findRequiredViewAsType(source, R.id.movie_rating, "field 'ratings'", TextView.class);
    target.release = Utils.findRequiredViewAsType(source, R.id.movie_release, "field 'release'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieViewAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.image = null;
    target.ratings = null;
    target.release = null;
  }
}
