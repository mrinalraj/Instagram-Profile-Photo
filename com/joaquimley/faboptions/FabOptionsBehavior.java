package com.joaquimley.faboptions;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.C0081a;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.View;
import android.widget.FrameLayout;

public class FabOptionsBehavior extends C0081a<FrameLayout> {
    public boolean m5225a(CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, View view) {
        return view instanceof SnackbarLayout;
    }

    public /* synthetic */ boolean mo62b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return m5225a(coordinatorLayout, (FrameLayout) view, view2);
    }

    public boolean m5227b(CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, View view) {
        frameLayout.setTranslationY(Math.min(0.0f, view.getTranslationY() - ((float) view.getHeight())));
        return true;
    }

    public void m5228c(CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, View view) {
        super.mo825d(coordinatorLayout, frameLayout, view);
        frameLayout.setTranslationY(0.0f);
    }

    public /* synthetic */ boolean mo63c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return m5227b(coordinatorLayout, (FrameLayout) view, view2);
    }

    public /* synthetic */ void mo825d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        m5228c(coordinatorLayout, (FrameLayout) view, view2);
    }
}
