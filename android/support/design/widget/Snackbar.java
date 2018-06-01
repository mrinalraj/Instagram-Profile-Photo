package android.support.design.widget;

import android.content.Context;
import android.support.design.C0066a.C0063h;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.C0113b.C0073c;
import android.support.design.widget.C0113b.C0112f;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

public final class Snackbar extends C0113b<Snackbar> {

    public static final class SnackbarLayout extends C0112f {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    private Snackbar(ViewGroup viewGroup, View view, C0073c c0073c) {
        super(viewGroup, view, c0073c);
    }

    public static Snackbar m604a(View view, CharSequence charSequence, int i) {
        ViewGroup a = m605a(view);
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(a.getContext()).inflate(C0063h.design_layout_snackbar_include, a, false);
        Snackbar snackbar = new Snackbar(a, snackbarContentLayout, snackbarContentLayout);
        snackbar.m606a(charSequence);
        snackbar.m594a(i);
        return snackbar;
    }

    private static ViewGroup m605a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    public Snackbar m606a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.b.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }
}
