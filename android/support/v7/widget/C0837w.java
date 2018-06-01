package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.widget.SeekBar;

class C0837w extends C0833s {
    private final SeekBar f2796a;
    private Drawable f2797b;
    private ColorStateList f2798c = null;
    private Mode f2799d = null;
    private boolean f2800e = false;
    private boolean f2801f = false;

    C0837w(SeekBar seekBar) {
        super(seekBar);
        this.f2796a = seekBar;
    }

    private void m4771d() {
        if (this.f2797b == null) {
            return;
        }
        if (this.f2800e || this.f2801f) {
            this.f2797b = C0279a.m1431f(this.f2797b.mutate());
            if (this.f2800e) {
                C0279a.m1421a(this.f2797b, this.f2798c);
            }
            if (this.f2801f) {
                C0279a.m1424a(this.f2797b, this.f2799d);
            }
            if (this.f2797b.isStateful()) {
                this.f2797b.setState(this.f2796a.getDrawableState());
            }
        }
    }

    void m4772a(Canvas canvas) {
        int i = 1;
        if (this.f2797b != null) {
            int max = this.f2796a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2797b.getIntrinsicWidth();
                int intrinsicHeight = this.f2797b.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f2797b.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.f2796a.getWidth() - this.f2796a.getPaddingLeft()) - this.f2796a.getPaddingRight())) / ((float) max);
                intrinsicHeight = canvas.save();
                canvas.translate((float) this.f2796a.getPaddingLeft(), (float) (this.f2796a.getHeight() / 2));
                for (i = 0; i <= max; i++) {
                    this.f2797b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicHeight);
            }
        }
    }

    void mo786a(Drawable drawable) {
        if (this.f2797b != null) {
            this.f2797b.setCallback(null);
        }
        this.f2797b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2796a);
            C0279a.m1427b(drawable, C0425s.m1966f(this.f2796a));
            if (drawable.isStateful()) {
                drawable.setState(this.f2796a.getDrawableState());
            }
            m4771d();
        }
        this.f2796a.invalidate();
    }

    void mo787a(AttributeSet attributeSet, int i) {
        super.mo787a(attributeSet, i);
        bm a = bm.m4513a(this.f2796a.getContext(), attributeSet, C0528j.AppCompatSeekBar, i, 0);
        Drawable b = a.m4521b(C0528j.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.f2796a.setThumb(b);
        }
        mo786a(a.m4517a(C0528j.AppCompatSeekBar_tickMark));
        if (a.m4531g(C0528j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f2799d = al.m4289a(a.m4515a(C0528j.AppCompatSeekBar_tickMarkTintMode, -1), this.f2799d);
            this.f2801f = true;
        }
        if (a.m4531g(C0528j.AppCompatSeekBar_tickMarkTint)) {
            this.f2798c = a.m4527e(C0528j.AppCompatSeekBar_tickMarkTint);
            this.f2800e = true;
        }
        a.m4518a();
        m4771d();
    }

    void mo788b() {
        if (this.f2797b != null) {
            this.f2797b.jumpToCurrentState();
        }
    }

    void m4776c() {
        Drawable drawable = this.f2797b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2796a.getDrawableState())) {
            this.f2796a.invalidateDrawable(drawable);
        }
    }
}
