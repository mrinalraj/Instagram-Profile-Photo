package android.support.v4.p008h.p020b;

import android.view.animation.Interpolator;

abstract class C0391d implements Interpolator {
    private final float[] f1040a;
    private final float f1041b = (1.0f / ((float) (this.f1040a.length - 1)));

    public C0391d(float[] fArr) {
        this.f1040a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f1040a.length - 1)) * f), this.f1040a.length - 2);
        float f2 = (f - (((float) min) * this.f1041b)) / this.f1041b;
        return ((this.f1040a[min + 1] - this.f1040a[min]) * f2) + this.f1040a[min];
    }
}
