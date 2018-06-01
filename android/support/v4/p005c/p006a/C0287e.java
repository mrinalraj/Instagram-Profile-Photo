package android.support.v4.p005c.p006a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.p005c.p006a.C0283c.C0281a;
import android.util.Log;
import java.lang.reflect.Method;

class C0287e extends C0285d {
    private static Method f879d;

    private static class C0286a extends C0281a {
        C0286a(C0281a c0281a, Resources resources) {
            super(c0281a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0287e(this, resources);
        }
    }

    C0287e(Drawable drawable) {
        super(drawable);
        m1444d();
    }

    C0287e(C0281a c0281a, Resources resources) {
        super(c0281a, resources);
        m1444d();
    }

    private void m1444d() {
        if (f879d == null) {
            try {
                f879d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Throwable e) {
                Log.w("DrawableWrapperApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    C0281a mo204b() {
        return new C0286a(this.b, null);
    }

    protected boolean mo205c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (mo205c()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo205c()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (mo205c()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }
}
