package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class ba extends Drawable {
    private float f2530a;
    private final Paint f2531b;
    private final RectF f2532c;
    private final Rect f2533d;
    private float f2534e;
    private boolean f2535f = false;
    private boolean f2536g = true;
    private ColorStateList f2537h;
    private PorterDuffColorFilter f2538i;
    private ColorStateList f2539j;
    private Mode f2540k = Mode.SRC_IN;

    ba(ColorStateList colorStateList, float f) {
        this.f2530a = f;
        this.f2531b = new Paint(5);
        m4432b(colorStateList);
        this.f2532c = new RectF();
        this.f2533d = new Rect();
    }

    private PorterDuffColorFilter m4430a(ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void m4431a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2532c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f2533d.set(rect);
        if (this.f2535f) {
            float a = bb.m4439a(this.f2534e, this.f2530a, this.f2536g);
            this.f2533d.inset((int) Math.ceil((double) bb.m4442b(this.f2534e, this.f2530a, this.f2536g)), (int) Math.ceil((double) a));
            this.f2532c.set(this.f2533d);
        }
    }

    private void m4432b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2537h = colorStateList;
        this.f2531b.setColor(this.f2537h.getColorForState(getState(), this.f2537h.getDefaultColor()));
    }

    float m4433a() {
        return this.f2534e;
    }

    void m4434a(float f) {
        if (f != this.f2530a) {
            this.f2530a = f;
            m4431a(null);
            invalidateSelf();
        }
    }

    void m4435a(float f, boolean z, boolean z2) {
        if (f != this.f2534e || this.f2535f != z || this.f2536g != z2) {
            this.f2534e = f;
            this.f2535f = z;
            this.f2536g = z2;
            m4431a(null);
            invalidateSelf();
        }
    }

    public void m4436a(ColorStateList colorStateList) {
        m4432b(colorStateList);
        invalidateSelf();
    }

    public float m4437b() {
        return this.f2530a;
    }

    public ColorStateList m4438c() {
        return this.f2537h;
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.f2531b;
        if (this.f2538i == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.f2538i);
            obj = 1;
        }
        canvas.drawRoundRect(this.f2532c, this.f2530a, this.f2530a, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2533d, this.f2530a);
    }

    public boolean isStateful() {
        return (this.f2539j != null && this.f2539j.isStateful()) || ((this.f2537h != null && this.f2537h.isStateful()) || super.isStateful());
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m4431a(rect);
    }

    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f2537h.getColorForState(iArr, this.f2537h.getDefaultColor());
        boolean z = colorForState != this.f2531b.getColor();
        if (z) {
            this.f2531b.setColor(colorForState);
        }
        if (this.f2539j == null || this.f2540k == null) {
            return z;
        }
        this.f2538i = m4430a(this.f2539j, this.f2540k);
        return true;
    }

    public void setAlpha(int i) {
        this.f2531b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2531b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2539j = colorStateList;
        this.f2538i = m4430a(this.f2539j, this.f2540k);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f2540k = mode;
        this.f2538i = m4430a(this.f2539j, this.f2540k);
        invalidateSelf();
    }
}
