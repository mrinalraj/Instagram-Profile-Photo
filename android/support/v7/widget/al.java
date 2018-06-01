package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.p005c.p006a.C0280b;
import android.support.v7.p010d.p011a.C0157a;

public class al {
    public static final Rect f2429a = new Rect();
    private static Class<?> f2430b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f2430b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static Mode m4289a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }

    static void m4290a(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m4292c(drawable);
        }
    }

    public static boolean m4291b(Drawable drawable) {
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable b : ((DrawableContainerState) constantState).getChildren()) {
                    if (!m4291b(b)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof C0280b) {
            return m4291b(((C0280b) drawable).mo202a());
        } else {
            if (drawable instanceof C0157a) {
                return m4291b(((C0157a) drawable).m749b());
            }
            if (drawable instanceof ScaleDrawable) {
                return m4291b(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    private static void m4292c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(bh.f2611e);
        } else {
            drawable.setState(bh.f2614h);
        }
        drawable.setState(state);
    }
}
