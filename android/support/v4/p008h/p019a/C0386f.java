package android.support.v4.p008h.p019a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public class C0386f {
    private static final C0383c f1034a;
    private final AccessibilityRecord f1035b;

    static class C0383c {
        C0383c() {
        }

        public void mo240a(AccessibilityRecord accessibilityRecord, int i) {
        }

        public void mo241b(AccessibilityRecord accessibilityRecord, int i) {
        }
    }

    static class C0384a extends C0383c {
        C0384a() {
        }

        public void mo240a(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollX(i);
        }

        public void mo241b(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    static class C0385b extends C0384a {
        C0385b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1034a = new C0385b();
        } else if (VERSION.SDK_INT >= 15) {
            f1034a = new C0384a();
        } else {
            f1034a = new C0383c();
        }
    }

    @Deprecated
    public C0386f(Object obj) {
        this.f1035b = (AccessibilityRecord) obj;
    }

    public static void m1759a(AccessibilityRecord accessibilityRecord, int i) {
        f1034a.mo240a(accessibilityRecord, i);
    }

    public static void m1760b(AccessibilityRecord accessibilityRecord, int i) {
        f1034a.mo241b(accessibilityRecord, i);
    }

    @Deprecated
    public void m1761a(int i) {
        this.f1035b.setItemCount(i);
    }

    @Deprecated
    public void m1762a(boolean z) {
        this.f1035b.setScrollable(z);
    }

    @Deprecated
    public void m1763b(int i) {
        this.f1035b.setFromIndex(i);
    }

    @Deprecated
    public void m1764c(int i) {
        this.f1035b.setToIndex(i);
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0386f c0386f = (C0386f) obj;
        return this.f1035b == null ? c0386f.f1035b == null : this.f1035b.equals(c0386f.f1035b);
    }

    @Deprecated
    public int hashCode() {
        return this.f1035b == null ? 0 : this.f1035b.hashCode();
    }
}
