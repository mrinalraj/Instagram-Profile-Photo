package com.p026a.p027a;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class C0878g extends Thread {
    private final BlockingQueue<C0862l<?>> f2905a;
    private final C0847f f2906b;
    private final C0854b f2907c;
    private final C0876o f2908d;
    private volatile boolean f2909e = false;

    public C0878g(BlockingQueue<C0862l<?>> blockingQueue, C0847f c0847f, C0854b c0854b, C0876o c0876o) {
        this.f2905a = blockingQueue;
        this.f2906b = c0847f;
        this.f2907c = c0854b;
        this.f2908d = c0876o;
    }

    @TargetApi(14)
    private void m4930a(C0862l<?> c0862l) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(c0862l.m4880b());
        }
    }

    private void m4931a(C0862l<?> c0862l, C0867s c0867s) {
        this.f2908d.mo810a((C0862l) c0862l, c0862l.m4877a(c0867s));
    }

    public void m4932a() {
        this.f2909e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                C0862l c0862l = (C0862l) this.f2905a.take();
                try {
                    c0862l.m4879a("network-queue-take");
                    if (c0862l.m4886f()) {
                        c0862l.m4882b("network-discard-cancelled");
                    } else {
                        m4930a(c0862l);
                        C0880i a = this.f2906b.mo794a(c0862l);
                        c0862l.m4879a("network-http-complete");
                        if (a.f2913d && c0862l.m4901u()) {
                            c0862l.m4882b("not-modified");
                        } else {
                            C0889n a2 = c0862l.mo799a(a);
                            c0862l.m4879a("network-parse-complete");
                            if (c0862l.m4896p() && a2.f2935b != null) {
                                this.f2907c.mo797a(c0862l.m4884d(), a2.f2935b);
                                c0862l.m4879a("network-cache-written");
                            }
                            c0862l.m4900t();
                            this.f2908d.mo808a(c0862l, a2);
                        }
                    }
                } catch (C0867s e) {
                    e.m4912a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m4931a(c0862l, e);
                } catch (Throwable e2) {
                    C0894t.m4948a(e2, "Unhandled exception %s", e2.toString());
                    C0867s c0867s = new C0867s(e2);
                    c0867s.m4912a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f2908d.mo810a(c0862l, c0867s);
                }
            } catch (InterruptedException e3) {
                if (this.f2909e) {
                    return;
                }
            }
        }
    }
}
