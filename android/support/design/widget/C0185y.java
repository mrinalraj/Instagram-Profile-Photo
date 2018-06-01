package android.support.design.widget;

import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.design.widget.C0172r.C0170d;

class C0185y {
    static final C0170d f542a = new C01841();

    static class C01841 implements C0170d {
        C01841() {
        }

        public C0172r mo155a() {
            return new C0172r(VERSION.SDK_INT >= 12 ? new C0177t() : new C0174s());
        }
    }

    static Mode m859a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            default:
                return mode;
        }
    }

    static C0172r m860a() {
        return f542a.mo155a();
    }

    static boolean m861a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
