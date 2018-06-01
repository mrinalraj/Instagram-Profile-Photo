package android.support.v4.p008h;

import android.view.MotionEvent;

public final class C0407h {
    @Deprecated
    public static float m1817a(MotionEvent motionEvent, int i) {
        return motionEvent.getAxisValue(i);
    }

    @Deprecated
    public static int m1818a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int m1819b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }
}
