package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
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
import android.support.design.C0066a.C0058c;
import android.support.v4.p013b.C0190a;
import android.support.v7.p010d.p011a.C0157a;

class C0158m extends C0157a {
    static final double f479a = Math.cos(Math.toRadians(45.0d));
    final Paint f480b;
    final Paint f481c;
    final RectF f482d;
    float f483e;
    Path f484f;
    float f485g;
    float f486h;
    float f487i;
    float f488j;
    private boolean f489k = true;
    private final int f490l;
    private final int f491m;
    private final int f492n;
    private boolean f493o = true;
    private float f494p;
    private boolean f495q = false;

    public C0158m(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f490l = C0190a.m868c(context, C0058c.design_fab_shadow_start_color);
        this.f491m = C0190a.m868c(context, C0058c.design_fab_shadow_mid_color);
        this.f492n = C0190a.m868c(context, C0058c.design_fab_shadow_end_color);
        this.f480b = new Paint(5);
        this.f480b.setStyle(Style.FILL);
        this.f483e = (float) Math.round(f);
        this.f482d = new RectF();
        this.f481c = new Paint(this.f480b);
        this.f481c.setAntiAlias(false);
        m758a(f2, f3);
    }

    public static float m750a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f479a) * ((double) f2))) : 1.5f * f;
    }

    private void m751a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f494p, this.f482d.centerX(), this.f482d.centerY());
        float f = (-this.f483e) - this.f487i;
        float f2 = this.f483e;
        Object obj = this.f482d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f482d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f488j - (this.f488j * 0.5f)) + f2);
        float f4 = f2 / ((this.f488j - (this.f488j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f488j - (this.f488j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f482d.left + f2, this.f482d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f484f, this.f480b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f482d.width() - (2.0f * f2), -this.f483e, this.f481c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f482d.right - f2, this.f482d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f484f, this.f480b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f482d.width() - (2.0f * f2), this.f487i + (-this.f483e), this.f481c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f482d.left + f2, this.f482d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f484f, this.f480b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f482d.height() - (2.0f * f2), -this.f483e, this.f481c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f482d.right - f2, this.f482d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f484f, this.f480b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f482d.height() - (2.0f * f2), -this.f483e, this.f481c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m752a(Rect rect) {
        float f = this.f486h * 1.5f;
        this.f482d.set(((float) rect.left) + this.f486h, ((float) rect.top) + f, ((float) rect.right) - this.f486h, ((float) rect.bottom) - f);
        m749b().setBounds((int) this.f482d.left, (int) this.f482d.top, (int) this.f482d.right, (int) this.f482d.bottom);
        m755c();
    }

    public static float m753b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f479a) * ((double) f2))) : f;
    }

    private static int m754c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    private void m755c() {
        RectF rectF = new RectF(-this.f483e, -this.f483e, this.f483e, this.f483e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f487i, -this.f487i);
        if (this.f484f == null) {
            this.f484f = new Path();
        } else {
            this.f484f.reset();
        }
        this.f484f.setFillType(FillType.EVEN_ODD);
        this.f484f.moveTo(-this.f483e, 0.0f);
        this.f484f.rLineTo(-this.f487i, 0.0f);
        this.f484f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f484f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f484f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f483e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f480b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f490l, this.f491m, this.f492n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f481c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f490l, this.f491m, this.f492n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f481c.setAntiAlias(false);
    }

    public float m756a() {
        return this.f488j;
    }

    final void m757a(float f) {
        if (this.f494p != f) {
            this.f494p = f;
            invalidateSelf();
        }
    }

    void m758a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float c = (float) C0158m.m754c(f);
        float c2 = (float) C0158m.m754c(f2);
        if (c > c2) {
            if (!this.f495q) {
                this.f495q = true;
            }
            c = c2;
        }
        if (this.f488j != c || this.f486h != c2) {
            this.f488j = c;
            this.f486h = c2;
            this.f487i = (float) Math.round(c * 1.5f);
            this.f485g = c2;
            this.f489k = true;
            invalidateSelf();
        }
    }

    public void m759a(boolean z) {
        this.f493o = z;
        invalidateSelf();
    }

    public void m760b(float f) {
        m758a(f, this.f486h);
    }

    public void draw(Canvas canvas) {
        if (this.f489k) {
            m752a(getBounds());
            this.f489k = false;
        }
        m751a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) C0158m.m750a(this.f486h, this.f483e, this.f493o));
        int ceil2 = (int) Math.ceil((double) C0158m.m753b(this.f486h, this.f483e, this.f493o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.f489k = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f480b.setAlpha(i);
        this.f481c.setAlpha(i);
    }
}
