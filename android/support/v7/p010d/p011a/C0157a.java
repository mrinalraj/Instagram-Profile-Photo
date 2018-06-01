package android.support.v7.p010d.p011a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p005c.p006a.C0279a;

public class C0157a extends Drawable implements Callback {
    private Drawable f478a;

    public C0157a(Drawable drawable) {
        m748a(drawable);
    }

    public void m748a(Drawable drawable) {
        if (this.f478a != null) {
            this.f478a.setCallback(null);
        }
        this.f478a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public Drawable m749b() {
        return this.f478a;
    }

    public void draw(Canvas canvas) {
        this.f478a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f478a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f478a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f478a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f478a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f478a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f478a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f478a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f478a.getPadding(rect);
    }

    public int[] getState() {
        return this.f478a.getState();
    }

    public Region getTransparentRegion() {
        return this.f478a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return C0279a.m1426b(this.f478a);
    }

    public boolean isStateful() {
        return this.f478a.isStateful();
    }

    public void jumpToCurrentState() {
        C0279a.m1417a(this.f478a);
    }

    protected void onBoundsChange(Rect rect) {
        this.f478a.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f478a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f478a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        C0279a.m1425a(this.f478a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f478a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f478a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f478a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f478a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        C0279a.m1418a(this.f478a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0279a.m1420a(this.f478a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f478a.setState(iArr);
    }

    public void setTint(int i) {
        C0279a.m1419a(this.f478a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0279a.m1421a(this.f478a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0279a.m1424a(this.f478a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f478a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
