package android.support.v4.p008h;

import android.os.Build.VERSION;
import android.view.ScaleGestureDetector;

public final class C0412p {
    public static void m1846a(ScaleGestureDetector scaleGestureDetector, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            scaleGestureDetector.setQuickScaleEnabled(z);
        }
    }

    @Deprecated
    public static void m1847a(Object obj, boolean z) {
        C0412p.m1846a((ScaleGestureDetector) obj, z);
    }
}
