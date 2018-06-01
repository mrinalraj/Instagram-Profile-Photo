package com.jsibbold.zoomage;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.v4.p008h.C0412p;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.widget.ImageView.ScaleType;
import com.jsibbold.zoomage.C0988a.C0987a;
import com.jsibbold.zoomage.C0990b.C0989a;

public class ZoomageView extends AppCompatImageView implements OnScaleGestureListener {
    private final float f3240a;
    private final float f3241b;
    private final int f3242c;
    private ScaleType f3243d;
    private Matrix f3244e;
    private Matrix f3245f;
    private float[] f3246g;
    private float[] f3247h;
    private float f3248i;
    private float f3249j;
    private float f3250k;
    private float f3251l;
    private final RectF f3252m;
    private boolean f3253n;
    private boolean f3254o;
    private boolean f3255p;
    private boolean f3256q;
    private boolean f3257r;
    private int f3258s;
    private PointF f3259t;
    private float f3260u;
    private float f3261v;
    private int f3262w;
    private ScaleGestureDetector f3263x;

    public ZoomageView(Context context) {
        this(context, null);
    }

    public ZoomageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3240a = 0.6f;
        this.f3241b = 8.0f;
        this.f3242c = 200;
        this.f3244e = new Matrix();
        this.f3245f = new Matrix();
        this.f3246g = new float[9];
        this.f3247h = null;
        this.f3248i = 0.6f;
        this.f3249j = 8.0f;
        this.f3250k = 0.6f;
        this.f3251l = 8.0f;
        this.f3252m = new RectF();
        this.f3259t = new PointF(0.0f, 0.0f);
        this.f3260u = 1.0f;
        this.f3261v = 1.0f;
        this.f3262w = 1;
        this.f3263x = new ScaleGestureDetector(context, this);
        C0412p.m1847a(this.f3263x, false);
        this.f3243d = getScaleType();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0989a.ZoomageView);
        this.f3254o = obtainStyledAttributes.getBoolean(C0989a.ZoomageView_zoomage_zoomable, true);
        this.f3253n = obtainStyledAttributes.getBoolean(C0989a.ZoomageView_zoomage_translatable, true);
        this.f3256q = obtainStyledAttributes.getBoolean(C0989a.ZoomageView_zoomage_animateOnReset, true);
        this.f3257r = obtainStyledAttributes.getBoolean(C0989a.ZoomageView_zoomage_autoCenter, true);
        this.f3255p = obtainStyledAttributes.getBoolean(C0989a.ZoomageView_zoomage_restrictBounds, false);
        this.f3248i = obtainStyledAttributes.getFloat(C0989a.ZoomageView_zoomage_minScale, 0.6f);
        this.f3249j = obtainStyledAttributes.getFloat(C0989a.ZoomageView_zoomage_maxScale, 8.0f);
        this.f3258s = C0987a.m5249a(obtainStyledAttributes.getInt(C0989a.ZoomageView_zoomage_autoResetMode, 0));
        m5240b();
        obtainStyledAttributes.recycle();
    }

    private float m5234a(float f) {
        return getCurrentDisplayedWidth() >= ((float) getWidth()) ? (this.f3252m.left > 0.0f || this.f3252m.left + f <= 0.0f || this.f3263x.isInProgress()) ? (this.f3252m.right < ((float) getWidth()) || this.f3252m.right + f >= ((float) getWidth()) || this.f3263x.isInProgress()) ? f : ((float) getWidth()) - this.f3252m.right : -this.f3252m.left : !this.f3263x.isInProgress() ? (this.f3252m.left < 0.0f || this.f3252m.left + f >= 0.0f) ? (this.f3252m.right > ((float) getWidth()) || this.f3252m.right + f <= ((float) getWidth())) ? f : ((float) getWidth()) - this.f3252m.right : -this.f3252m.left : f;
    }

    private float m5235a(float f, float f2) {
        float f3 = f - f2;
        if (this.f3255p) {
            f3 = m5234a(f3);
        }
        return this.f3252m.right + f3 < 0.0f ? -this.f3252m.right : this.f3252m.left + f3 > ((float) getWidth()) ? ((float) getWidth()) - this.f3252m.left : f3;
    }

    private void m5236a(final int i, float f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f3246g[i], f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final float[] f3236a = new float[9];
            Matrix f3237b = new Matrix();
            final /* synthetic */ ZoomageView f3239d;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f3237b.set(this.f3239d.getImageMatrix());
                this.f3237b.getValues(this.f3236a);
                this.f3236a[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f3237b.setValues(this.f3236a);
                this.f3239d.setImageMatrix(this.f3237b);
            }
        });
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    private void m5237a(float[] fArr) {
        if (getDrawable() != null) {
            this.f3252m.set(fArr[2], fArr[5], (((float) getDrawable().getIntrinsicWidth()) * fArr[0]) + fArr[2], (((float) getDrawable().getIntrinsicHeight()) * fArr[4]) + fArr[5]);
        }
    }

    private float m5238b(float f) {
        return getCurrentDisplayedHeight() >= ((float) getHeight()) ? (this.f3252m.top > 0.0f || this.f3252m.top + f <= 0.0f || this.f3263x.isInProgress()) ? (this.f3252m.bottom < ((float) getHeight()) || this.f3252m.bottom + f >= ((float) getHeight()) || this.f3263x.isInProgress()) ? f : ((float) getHeight()) - this.f3252m.bottom : -this.f3252m.top : !this.f3263x.isInProgress() ? (this.f3252m.top < 0.0f || this.f3252m.top + f >= 0.0f) ? (this.f3252m.bottom > ((float) getHeight()) || this.f3252m.bottom + f <= ((float) getHeight())) ? f : ((float) getHeight()) - this.f3252m.bottom : -this.f3252m.top : f;
    }

    private float m5239b(float f, float f2) {
        float f3 = f - f2;
        if (this.f3255p) {
            f3 = m5238b(f3);
        }
        return this.f3252m.bottom + f3 < 0.0f ? -this.f3252m.bottom : this.f3252m.top + f3 > ((float) getHeight()) ? ((float) getHeight()) - this.f3252m.top : f3;
    }

    private void m5240b() {
        if (this.f3248i >= this.f3249j) {
            throw new IllegalStateException("minScale must be less than maxScale");
        } else if (this.f3248i < 0.0f) {
            throw new IllegalStateException("minScale must be greater than 0");
        } else if (this.f3249j < 0.0f) {
            throw new IllegalStateException("maxScale must be greater than 0");
        }
    }

    private void m5241c() {
        this.f3247h = new float[9];
        this.f3245f = new Matrix(getImageMatrix());
        this.f3245f.getValues(this.f3247h);
        this.f3250k = this.f3248i * this.f3247h[0];
        this.f3251l = this.f3249j * this.f3247h[0];
    }

    private void m5242d() {
        switch (this.f3258s) {
            case 0:
                if (this.f3246g[0] <= this.f3247h[0]) {
                    m5247a();
                    return;
                } else {
                    m5243e();
                    return;
                }
            case 1:
                if (this.f3246g[0] >= this.f3247h[0]) {
                    m5247a();
                    return;
                } else {
                    m5243e();
                    return;
                }
            case 2:
                m5247a();
                return;
            case 3:
                m5243e();
                return;
            default:
                return;
        }
    }

    private void m5243e() {
        if (this.f3257r) {
            m5245g();
            m5246h();
        }
    }

    private void m5244f() {
        final Matrix matrix = new Matrix(getImageMatrix());
        matrix.getValues(this.f3246g);
        final float f = this.f3247h[0] - this.f3246g[0];
        final float f2 = this.f3247h[4] - this.f3246g[4];
        final float f3 = this.f3247h[2] - this.f3246g[2];
        final float f4 = this.f3247h[5] - this.f3246g[5];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final Matrix f3228a = new Matrix(this.f3235h.getImageMatrix());
            final float[] f3229b = new float[9];
            final /* synthetic */ ZoomageView f3235h;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f3228a.set(matrix);
                this.f3228a.getValues(this.f3229b);
                this.f3229b[2] = this.f3229b[2] + (f3 * floatValue);
                this.f3229b[5] = this.f3229b[5] + (f4 * floatValue);
                this.f3229b[0] = this.f3229b[0] + (f * floatValue);
                this.f3229b[4] = (floatValue * f2) + this.f3229b[4];
                this.f3228a.setValues(this.f3229b);
                this.f3235h.setImageMatrix(this.f3228a);
            }
        });
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    private void m5245g() {
        if (getCurrentDisplayedWidth() > ((float) getWidth())) {
            if (this.f3252m.left > 0.0f) {
                m5236a(2, 0.0f);
            } else if (this.f3252m.right < ((float) getWidth())) {
                m5236a(2, (this.f3252m.left + ((float) getWidth())) - this.f3252m.right);
            }
        } else if (this.f3252m.left < 0.0f) {
            m5236a(2, 0.0f);
        } else if (this.f3252m.right > ((float) getWidth())) {
            m5236a(2, (this.f3252m.left + ((float) getWidth())) - this.f3252m.right);
        }
    }

    private float getCurrentDisplayedHeight() {
        return getDrawable() != null ? ((float) getDrawable().getIntrinsicHeight()) * this.f3246g[4] : 0.0f;
    }

    private float getCurrentDisplayedWidth() {
        return getDrawable() != null ? ((float) getDrawable().getIntrinsicWidth()) * this.f3246g[0] : 0.0f;
    }

    private void m5246h() {
        if (getCurrentDisplayedHeight() > ((float) getHeight())) {
            if (this.f3252m.top > 0.0f) {
                m5236a(5, 0.0f);
            } else if (this.f3252m.bottom < ((float) getHeight())) {
                m5236a(5, (this.f3252m.top + ((float) getHeight())) - this.f3252m.bottom);
            }
        } else if (this.f3252m.top < 0.0f) {
            m5236a(5, 0.0f);
        } else if (this.f3252m.bottom > ((float) getHeight())) {
            m5236a(5, (this.f3252m.top + ((float) getHeight())) - this.f3252m.bottom);
        }
    }

    public void m5247a() {
        m5248a(this.f3256q);
    }

    public void m5248a(boolean z) {
        if (z) {
            m5244f();
        } else {
            setImageMatrix(this.f3245f);
        }
    }

    public boolean getAnimateOnReset() {
        return this.f3256q;
    }

    public boolean getAutoCenter() {
        return this.f3257r;
    }

    public int getAutoResetMode() {
        return this.f3258s;
    }

    public boolean getRestrictBounds() {
        return this.f3255p;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.f3261v = (this.f3260u * scaleGestureDetector.getScaleFactor()) / this.f3246g[0];
        float f = this.f3261v * this.f3246g[0];
        if (f < this.f3250k) {
            this.f3261v = this.f3250k / this.f3246g[0];
        } else if (f > this.f3251l) {
            this.f3261v = this.f3251l / this.f3246g[0];
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f3260u = this.f3246g[0];
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f3261v = 1.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || (!this.f3254o && !this.f3253n)) {
            return super.onTouchEvent(motionEvent);
        }
        if (getScaleType() != ScaleType.MATRIX) {
            super.setScaleType(ScaleType.MATRIX);
        }
        if (this.f3247h == null) {
            m5241c();
        }
        this.f3244e.set(getImageMatrix());
        this.f3244e.getValues(this.f3246g);
        m5237a(this.f3246g);
        this.f3263x.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 0 || motionEvent.getPointerCount() != this.f3262w) {
            this.f3259t.set(this.f3263x.getFocusX(), this.f3263x.getFocusY());
        } else if (motionEvent.getActionMasked() == 2) {
            float focusX = this.f3263x.getFocusX();
            float focusY = this.f3263x.getFocusY();
            if (this.f3253n) {
                this.f3244e.postTranslate(m5235a(focusX, this.f3259t.x), m5239b(focusY, this.f3259t.y));
            }
            if (this.f3254o) {
                this.f3244e.postScale(this.f3261v, this.f3261v, focusX, focusY);
            }
            setImageMatrix(this.f3244e);
            this.f3259t.set(focusX, focusY);
        }
        if (motionEvent.getActionMasked() == 1) {
            this.f3261v = 1.0f;
            m5242d();
        }
        this.f3262w = motionEvent.getPointerCount();
        return true;
    }

    public void setAnimateOnReset(boolean z) {
        this.f3256q = z;
    }

    public void setAutoCenter(boolean z) {
        this.f3257r = z;
    }

    public void setAutoResetMode(int i) {
        this.f3258s = i;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            setScaleType(this.f3243d);
        }
    }

    public void setRestrictBounds(boolean z) {
        this.f3255p = z;
    }

    public void setScaleType(ScaleType scaleType) {
        super.setScaleType(scaleType);
        this.f3243d = scaleType;
        this.f3247h = null;
    }

    public void setTranslatable(boolean z) {
        this.f3253n = z;
    }

    public void setZoomable(boolean z) {
        this.f3254o = z;
    }
}
