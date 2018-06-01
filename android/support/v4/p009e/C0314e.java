package android.support.v4.p009e;

import android.os.Build.VERSION;
import android.os.Trace;

public final class C0314e {
    public static void m1528a() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void m1529a(String str) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
