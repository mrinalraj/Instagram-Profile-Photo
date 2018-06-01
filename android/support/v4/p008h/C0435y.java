package android.support.v4.p008h;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public class C0435y {
    private final Object f1084a;

    private C0435y(Object obj) {
        this.f1084a = obj;
    }

    static C0435y m2026a(Object obj) {
        return obj == null ? null : new C0435y(obj);
    }

    static Object m2027a(C0435y c0435y) {
        return c0435y == null ? null : c0435y.f1084a;
    }

    public int m2028a() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1084a).getSystemWindowInsetLeft() : 0;
    }

    public C0435y m2029a(int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 20 ? new C0435y(((WindowInsets) this.f1084a).replaceSystemWindowInsets(i, i2, i3, i4)) : null;
    }

    public int m2030b() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1084a).getSystemWindowInsetTop() : 0;
    }

    public int m2031c() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1084a).getSystemWindowInsetRight() : 0;
    }

    public int m2032d() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1084a).getSystemWindowInsetBottom() : 0;
    }

    public boolean m2033e() {
        return VERSION.SDK_INT >= 21 ? ((WindowInsets) this.f1084a).isConsumed() : false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0435y c0435y = (C0435y) obj;
        return this.f1084a == null ? c0435y.f1084a == null : this.f1084a.equals(c0435y.f1084a);
    }

    public int hashCode() {
        return this.f1084a == null ? 0 : this.f1084a.hashCode();
    }
}
