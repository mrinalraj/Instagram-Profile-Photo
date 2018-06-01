package com.joaquimley.faboptions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.joaquimley.faboptions.C0984a.C0982d;

public class FabOptionsButtonContainer extends LinearLayout {
    public FabOptionsButtonContainer(Context context) {
        this(context, null);
    }

    public FabOptionsButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FabOptionsButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AppCompatImageView m5231a(Context context, int i, CharSequence charSequence, Drawable drawable) {
        return m5232a(context, i, charSequence, drawable, null);
    }

    public AppCompatImageView m5232a(Context context, int i, CharSequence charSequence, Drawable drawable, Integer num) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) LayoutInflater.from(context).inflate(C0982d.faboptions_button, this, false);
        appCompatImageView.setImageDrawable(drawable);
        appCompatImageView.setContentDescription(charSequence);
        appCompatImageView.setId(i);
        if (num == null) {
            addView(appCompatImageView);
        } else {
            addView(appCompatImageView, num.intValue());
        }
        return appCompatImageView;
    }

    public View m5233a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(C0982d.faboptions_separator, this, false);
        addView(inflate, getChildCount() / 2);
        return inflate;
    }
}
