package com.p026a.p027a;

import android.os.Process;
import com.p026a.p027a.C0854b.C0869a;
import java.util.concurrent.BlockingQueue;

public class C0871c extends Thread {
    private static final boolean f2888a = C0894t.f2945b;
    private final BlockingQueue<C0862l<?>> f2889b;
    private final BlockingQueue<C0862l<?>> f2890c;
    private final C0854b f2891d;
    private final C0876o f2892e;
    private volatile boolean f2893f = false;

    public C0871c(BlockingQueue<C0862l<?>> blockingQueue, BlockingQueue<C0862l<?>> blockingQueue2, C0854b c0854b, C0876o c0876o) {
        this.f2889b = blockingQueue;
        this.f2890c = blockingQueue2;
        this.f2891d = c0854b;
        this.f2892e = c0876o;
    }

    public void m4916a() {
        this.f2893f = true;
        interrupt();
    }

    public void run() {
        if (f2888a) {
            C0894t.m4947a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f2891d.mo796a();
        while (true) {
            try {
                final C0862l c0862l = (C0862l) this.f2889b.take();
                c0862l.m4879a("cache-queue-take");
                if (c0862l.m4886f()) {
                    c0862l.m4882b("cache-discard-canceled");
                } else {
                    C0869a a = this.f2891d.mo795a(c0862l.m4884d());
                    if (a == null) {
                        c0862l.m4879a("cache-miss");
                        this.f2890c.put(c0862l);
                    } else if (a.m4913a()) {
                        c0862l.m4879a("cache-hit-expired");
                        c0862l.m4873a(a);
                        this.f2890c.put(c0862l);
                    } else {
                        c0862l.m4879a("cache-hit");
                        C0889n a2 = c0862l.mo799a(new C0880i(a.f2879a, a.f2885g));
                        c0862l.m4879a("cache-hit-parsed");
                        if (a.m4914b()) {
                            c0862l.m4879a("cache-hit-refresh-needed");
                            c0862l.m4873a(a);
                            a2.f2937d = true;
                            this.f2892e.mo809a(c0862l, a2, new Runnable(this) {
                                final /* synthetic */ C0871c f2887b;

                                public void run() {
                                    try {
                                        this.f2887b.f2890c.put(c0862l);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        } else {
                            this.f2892e.mo808a(c0862l, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f2893f) {
                    return;
                }
            }
        }
    }
}
