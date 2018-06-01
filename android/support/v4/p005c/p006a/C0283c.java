package android.support.v4.p005c.p006a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class C0283c extends Drawable implements Callback, C0280b, C0029f {
    static final Mode f872a = Mode.SRC_IN;
    C0281a f873b;
    Drawable f874c;
    private int f875d;
    private Mode f876e;
    private boolean f877f;
    private boolean f878g;

    protected static abstract class C0281a extends ConstantState {
        int f868a;
        ConstantState f869b;
        ColorStateList f870c = null;
        Mode f871d = C0283c.f872a;

        C0281a(C0281a c0281a, Resources resources) {
            if (c0281a != null) {
                this.f868a = c0281a.f868a;
                this.f869b = c0281a.f869b;
                this.f870c = c0281a.f870c;
                this.f871d = c0281a.f871d;
            }
        }

        boolean m1435a() {
            return this.f869b != null;
        }

        public int getChangingConfigurations() {
            return (this.f869b != null ? this.f869b.getChangingConfigurations() : 0) | this.f868a;
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public abstract Drawable newDrawable(Resources resources);
    }

    private static class C0282b extends C0281a {
        C0282b(C0281a c0281a, Resources resources) {
            super(c0281a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0283c(this, resources);
        }
    }

    C0283c(Drawable drawable) {
        this.f873b = mo204b();
        mo203a(drawable);
    }

    C0283c(C0281a c0281a, Resources resources) {
        this.f873b = c0281a;
        m1436a(resources);
    }

    private void m1436a(Resources resources) {
        if (this.f873b != null && this.f873b.f869b != null) {
            mo203a(m1439a(this.f873b.f869b, resources));
        }
    }

    private boolean m1437a(int[] iArr) {
        if (!mo205c()) {
            return false;
        }
        ColorStateList colorStateList = this.f873b.f870c;
        Mode mode = this.f873b.f871d;
        if (colorStateList == null || mode == null) {
            this.f877f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f877f && colorForState == this.f875d && mode == this.f876e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f875d = colorForState;
        this.f876e = mode;
        this.f877f = true;
        return true;
    }

    public final Drawable mo202a() {
        return this.f874c;
    }

    protected Drawable m1439a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    public final void mo203a(Drawable drawable) {
        if (this.f874c != null) {
            this.f874c.setCallback(null);
        }
        this.f874c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f873b != null) {
                this.f873b.f869b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    C0281a mo204b() {
        return new C0282b(this.f873b, null);
    }

    protected boolean mo205c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f874c.draw(canvas);
    }

    public int getChangingConfigurations() {
        return ((this.f873b != null ? this.f873b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f874c.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.f873b == null || !this.f873b.m1435a()) {
            return null;
        }
        this.f873b.f868a = getChangingConfigurations();
        return this.f873b;
    }

    public Drawable getCurrent() {
        return this.f874c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f874c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f874c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f874c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f874c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f874c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f874c.getPadding(rect);
    }

    public int[] getState() {
        return this.f874c.getState();
    }

    public Region getTransparentRegion() {
        return this.f874c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo205c() || this.f873b == null) ? null : this.f873b.f870c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f874c.isStateful();
    }

    public void jumpToCurrentState() {
        this.f874c.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f878g && super.mutate() == this) {
            this.f873b = mo204b();
            if (this.f874c != null) {
                this.f874c.mutate();
            }
            if (this.f873b != null) {
                this.f873b.f869b = this.f874c != null ? this.f874c.getConstantState() : null;
            }
            this.f878g = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f874c != null) {
            this.f874c.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f874c.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f874c.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f874c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f874c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f874c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f874c.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m1437a(iArr) || this.f874c.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f873b.f870c = colorStateList;
        m1437a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f873b.f871d = mode;
        m1437a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f874c.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
