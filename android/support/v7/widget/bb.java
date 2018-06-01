package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.p022b.C0605a.C0601a;
import android.support.v7.p022b.C0605a.C0602b;

class bb extends Drawable {
    static C0753a f2541a;
    private static final double f2542b = Math.cos(Math.toRadians(45.0d));
    private final int f2543c;
    private Paint f2544d;
    private Paint f2545e;
    private Paint f2546f;
    private final RectF f2547g;
    private float f2548h;
    private Path f2549i;
    private float f2550j;
    private float f2551k;
    private float f2552l;
    private ColorStateList f2553m;
    private boolean f2554n = true;
    private final int f2555o;
    private final int f2556p;
    private boolean f2557q = true;
    private boolean f2558r = false;

    interface C0753a {
        void mo678a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    bb(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f2555o = resources.getColor(C0601a.cardview_shadow_start_color);
        this.f2556p = resources.getColor(C0601a.cardview_shadow_end_color);
        this.f2543c = resources.getDimensionPixelSize(C0602b.cardview_compat_inset_shadow);
        this.f2544d = new Paint(5);
        m4443b(colorStateList);
        this.f2545e = new Paint(5);
        this.f2545e.setStyle(Style.FILL);
        this.f2548h = (float) ((int) (0.5f + f));
        this.f2547g = new RectF();
        this.f2546f = new Paint(this.f2545e);
        this.f2546f.setAntiAlias(false);
        m4440a(f2, f3);
    }

    static float m4439a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f2542b) * ((double) f2))) : 1.5f * f;
    }

    private void m4440a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float d = (float) m4445d(f);
            float d2 = (float) m4445d(f2);
            if (d > d2) {
                if (!this.f2558r) {
                    this.f2558r = true;
                }
                d = d2;
            }
            if (this.f2552l != d || this.f2550j != d2) {
                this.f2552l = d;
                this.f2550j = d2;
                this.f2551k = (float) ((int) (((d * 1.5f) + ((float) this.f2543c)) + 0.5f));
                this.f2554n = true;
                invalidateSelf();
            }
        }
    }

    private void m4441a(Canvas canvas) {
        float f = (-this.f2548h) - this.f2551k;
        float f2 = (this.f2548h + ((float) this.f2543c)) + (this.f2552l / 2.0f);
        Object obj = this.f2547g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f2547g.height() - (2.0f * f2) > 0.0f ? 1 : null;
        int save = canvas.save();
        canvas.translate(this.f2547g.left + f2, this.f2547g.top + f2);
        canvas.drawPath(this.f2549i, this.f2545e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2547g.width() - (2.0f * f2), -this.f2548h, this.f2546f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.f2547g.right - f2, this.f2547g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f2549i, this.f2545e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2547g.width() - (2.0f * f2), this.f2551k + (-this.f2548h), this.f2546f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f2547g.left + f2, this.f2547g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f2549i, this.f2545e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2547g.height() - (2.0f * f2), -this.f2548h, this.f2546f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f2547g.right - f2, this.f2547g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2549i, this.f2545e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2547g.height() - (2.0f * f2), -this.f2548h, this.f2546f);
        }
        canvas.restoreToCount(save2);
    }

    static float m4442b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f2542b) * ((double) f2))) : f;
    }

    private void m4443b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2553m = colorStateList;
        this.f2544d.setColor(this.f2553m.getColorForState(getState(), this.f2553m.getDefaultColor()));
    }

    private void m4444b(Rect rect) {
        float f = this.f2550j * 1.5f;
        this.f2547g.set(((float) rect.left) + this.f2550j, ((float) rect.top) + f, ((float) rect.right) - this.f2550j, ((float) rect.bottom) - f);
        m4446g();
    }

    private int m4445d(float f) {
        int i = (int) (0.5f + f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void m4446g() {
        RectF rectF = new RectF(-this.f2548h, -this.f2548h, this.f2548h, this.f2548h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f2551k, -this.f2551k);
        if (this.f2549i == null) {
            this.f2549i = new Path();
        } else {
            this.f2549i.reset();
        }
        this.f2549i.setFillType(FillType.EVEN_ODD);
        this.f2549i.moveTo(-this.f2548h, 0.0f);
        this.f2549i.rLineTo(-this.f2551k, 0.0f);
        this.f2549i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f2549i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f2549i.close();
        float f = this.f2548h / (this.f2548h + this.f2551k);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.f2545e.setShader(new RadialGradient(0.0f, f, this.f2548h + this.f2551k, new int[]{this.f2555o, this.f2555o, this.f2556p}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f2546f.setShader(new LinearGradient(0.0f, (-this.f2548h) + this.f2551k, f2, (-this.f2548h) - this.f2551k, new int[]{this.f2555o, this.f2555o, this.f2556p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f2546f.setAntiAlias(false);
    }

    float m4447a() {
        return this.f2548h;
    }

    void m4448a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.f2548h != f2) {
            this.f2548h = f2;
            this.f2554n = true;
            invalidateSelf();
        }
    }

    void m4449a(ColorStateList colorStateList) {
        m4443b(colorStateList);
        invalidateSelf();
    }

    void m4450a(Rect rect) {
        getPadding(rect);
    }

    void m4451a(boolean z) {
        this.f2557q = z;
        invalidateSelf();
    }

    float m4452b() {
        return this.f2552l;
    }

    void m4453b(float f) {
        m4440a(f, this.f2550j);
    }

    float m4454c() {
        return this.f2550j;
    }

    void m4455c(float f) {
        m4440a(this.f2552l, f);
    }

    float m4456d() {
        return (Math.max(this.f2550j, (this.f2548h + ((float) this.f2543c)) + (this.f2550j / 2.0f)) * 2.0f) + ((this.f2550j + ((float) this.f2543c)) * 2.0f);
    }

    public void draw(Canvas canvas) {
        if (this.f2554n) {
            m4444b(getBounds());
            this.f2554n = false;
        }
        canvas.translate(0.0f, this.f2552l / 2.0f);
        m4441a(canvas);
        canvas.translate(0.0f, (-this.f2552l) / 2.0f);
        f2541a.mo678a(canvas, this.f2547g, this.f2548h, this.f2544d);
    }

    float m4457e() {
        return (Math.max(this.f2550j, (this.f2548h + ((float) this.f2543c)) + ((this.f2550j * 1.5f) / 2.0f)) * 2.0f) + (((this.f2550j * 1.5f) + ((float) this.f2543c)) * 2.0f);
    }

    ColorStateList m4458f() {
        return this.f2553m;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m4439a(this.f2550j, this.f2548h, this.f2557q));
        int ceil2 = (int) Math.ceil((double) m4442b(this.f2550j, this.f2548h, this.f2557q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public boolean isStateful() {
        return (this.f2553m != null && this.f2553m.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2554n = true;
    }

    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f2553m.getColorForState(iArr, this.f2553m.getDefaultColor());
        if (this.f2544d.getColor() == colorForState) {
            return false;
        }
        this.f2544d.setColor(colorForState);
        this.f2554n = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i) {
        this.f2544d.setAlpha(i);
        this.f2545e.setAlpha(i);
        this.f2546f.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2544d.setColorFilter(colorFilter);
    }
}
