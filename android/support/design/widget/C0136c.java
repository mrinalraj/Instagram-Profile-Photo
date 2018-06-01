package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.C0288a;

class C0136c extends Drawable {
    final Paint f418a = new Paint(1);
    final Rect f419b = new Rect();
    final RectF f420c = new RectF();
    float f421d;
    private int f422e;
    private int f423f;
    private int f424g;
    private int f425h;
    private ColorStateList f426i;
    private int f427j;
    private boolean f428k = true;
    private float f429l;

    public C0136c() {
        this.f418a.setStyle(Style.STROKE);
    }

    private Shader m658a() {
        Rect rect = this.f419b;
        copyBounds(rect);
        float height = this.f421d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0288a.m1447a(this.f422e, this.f427j), C0288a.m1447a(this.f423f, this.f427j), C0288a.m1447a(C0288a.m1449b(this.f423f, 0), this.f427j), C0288a.m1447a(C0288a.m1449b(this.f425h, 0), this.f427j), C0288a.m1447a(this.f425h, this.f427j), C0288a.m1447a(this.f424g, this.f427j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }

    void m659a(float f) {
        if (this.f421d != f) {
            this.f421d = f;
            this.f418a.setStrokeWidth(1.3333f * f);
            this.f428k = true;
            invalidateSelf();
        }
    }

    void m660a(int i, int i2, int i3, int i4) {
        this.f422e = i;
        this.f423f = i2;
        this.f424g = i3;
        this.f425h = i4;
    }

    void m661a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f427j = colorStateList.getColorForState(getState(), this.f427j);
        }
        this.f426i = colorStateList;
        this.f428k = true;
        invalidateSelf();
    }

    final void m662b(float f) {
        if (f != this.f429l) {
            this.f429l = f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f428k) {
            this.f418a.setShader(m658a());
            this.f428k = false;
        }
        float strokeWidth = this.f418a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f420c;
        copyBounds(this.f419b);
        rectF.set(this.f419b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f429l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f418a);
        canvas.restore();
    }

    public int getOpacity() {
        return this.f421d > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f421d);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        return (this.f426i != null && this.f426i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.f428k = true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f426i != null) {
            int colorForState = this.f426i.getColorForState(iArr, this.f427j);
            if (colorForState != this.f427j) {
                this.f428k = true;
                this.f427j = colorForState;
            }
        }
        if (this.f428k) {
            invalidateSelf();
        }
        return this.f428k;
    }

    public void setAlpha(int i) {
        this.f418a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f418a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
