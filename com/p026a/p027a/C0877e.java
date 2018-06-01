package com.p026a.p027a;

import android.os.Handler;
import java.util.concurrent.Executor;

public class C0877e implements C0876o {
    private final Executor f2904a;

    private class C0875a implements Runnable {
        final /* synthetic */ C0877e f2900a;
        private final C0862l f2901b;
        private final C0889n f2902c;
        private final Runnable f2903d;

        public C0875a(C0877e c0877e, C0862l c0862l, C0889n c0889n, Runnable runnable) {
            this.f2900a = c0877e;
            this.f2901b = c0862l;
            this.f2902c = c0889n;
            this.f2903d = runnable;
        }

        public void run() {
            if (this.f2901b.m4886f()) {
                this.f2901b.m4882b("canceled-at-delivery");
                return;
            }
            if (this.f2902c.m4943a()) {
                this.f2901b.mo800a(this.f2902c.f2934a);
            } else {
                this.f2901b.m4881b(this.f2902c.f2936c);
            }
            if (this.f2902c.f2937d) {
                this.f2901b.m4879a("intermediate-response");
            } else {
                this.f2901b.m4882b("done");
            }
            if (this.f2903d != null) {
                this.f2903d.run();
            }
        }
    }

    public C0877e(final Handler handler) {
        this.f2904a = new Executor(this) {
            final /* synthetic */ C0877e f2899b;

            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void mo808a(C0862l<?> c0862l, C0889n<?> c0889n) {
        mo809a(c0862l, c0889n, null);
    }

    public void mo809a(C0862l<?> c0862l, C0889n<?> c0889n, Runnable runnable) {
        c0862l.m4900t();
        c0862l.m4879a("post-response");
        this.f2904a.execute(new C0875a(this, c0862l, c0889n, runnable));
    }

    public void mo810a(C0862l<?> c0862l, C0867s c0867s) {
        c0862l.m4879a("post-error");
        this.f2904a.execute(new C0875a(this, c0862l, C0889n.m4941a(c0867s), null));
    }
}
