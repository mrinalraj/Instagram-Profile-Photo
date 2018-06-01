package android.support.v4.p008h.p019a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class C0357a {
    private static final C0354c f1020a;

    static class C0354c {
        C0354c() {
        }

        public int mo225a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void mo226a(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    static class C0355a extends C0354c {
        C0355a() {
        }
    }

    static class C0356b extends C0355a {
        C0356b() {
        }

        public int mo225a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        public void mo226a(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1020a = new C0356b();
        } else if (VERSION.SDK_INT >= 16) {
            f1020a = new C0355a();
        } else {
            f1020a = new C0354c();
        }
    }

    @Deprecated
    public static C0386f m1685a(AccessibilityEvent accessibilityEvent) {
        return new C0386f(accessibilityEvent);
    }

    public static void m1686a(AccessibilityEvent accessibilityEvent, int i) {
        f1020a.mo226a(accessibilityEvent, i);
    }

    public static int m1687b(AccessibilityEvent accessibilityEvent) {
        return f1020a.mo225a(accessibilityEvent);
    }
}
