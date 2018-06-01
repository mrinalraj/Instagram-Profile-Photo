package com.p026a.p027a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class C0894t {
    public static String f2944a = "Volley";
    public static boolean f2945b = Log.isLoggable(f2944a, 2);

    static class C0893a {
        public static final boolean f2941a = C0894t.f2945b;
        private final List<C0892a> f2942b = new ArrayList();
        private boolean f2943c = false;

        private static class C0892a {
            public final String f2938a;
            public final long f2939b;
            public final long f2940c;

            public C0892a(String str, long j, long j2) {
                this.f2938a = str;
                this.f2939b = j;
                this.f2940c = j2;
            }
        }

        C0893a() {
        }

        private long m4944a() {
            if (this.f2942b.size() == 0) {
                return 0;
            }
            return ((C0892a) this.f2942b.get(this.f2942b.size() - 1)).f2940c - ((C0892a) this.f2942b.get(0)).f2940c;
        }

        public synchronized void m4945a(String str) {
            this.f2943c = true;
            if (m4944a() > 0) {
                long j = ((C0892a) this.f2942b.get(0)).f2940c;
                C0894t.m4949b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C0892a c0892a : this.f2942b) {
                    C0894t.m4949b("(+%-4d) [%2d] %s", Long.valueOf(c0892a.f2940c - j2), Long.valueOf(c0892a.f2939b), c0892a.f2938a);
                    j2 = c0892a.f2940c;
                }
            }
        }

        public synchronized void m4946a(String str, long j) {
            if (this.f2943c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f2942b.add(new C0892a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (!this.f2943c) {
                m4945a("Request on the loose");
                C0894t.m4950c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void m4947a(String str, Object... objArr) {
        if (f2945b) {
            Log.v(f2944a, C0894t.m4952e(str, objArr));
        }
    }

    public static void m4948a(Throwable th, String str, Object... objArr) {
        Log.e(f2944a, C0894t.m4952e(str, objArr), th);
    }

    public static void m4949b(String str, Object... objArr) {
        Log.d(f2944a, C0894t.m4952e(str, objArr));
    }

    public static void m4950c(String str, Object... objArr) {
        Log.e(f2944a, C0894t.m4952e(str, objArr));
    }

    public static void m4951d(String str, Object... objArr) {
        Log.wtf(f2944a, C0894t.m4952e(str, objArr));
    }

    private static String m4952e(String str, Object... objArr) {
        String valueOf;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(C0894t.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = String.valueOf(String.valueOf(str2.substring(str2.lastIndexOf(36) + 1)));
                valueOf = String.valueOf(String.valueOf(stackTrace[i].getMethodName()));
                valueOf = new StringBuilder((str2.length() + 1) + valueOf.length()).append(str2).append(".").append(valueOf).toString();
                break;
            }
        }
        valueOf = str2;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), valueOf, str});
    }
}
