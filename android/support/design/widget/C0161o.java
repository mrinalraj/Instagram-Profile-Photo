package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class C0161o {
    private static C0161o f499a;
    private final Object f500b = new Object();
    private final Handler f501c = new Handler(Looper.getMainLooper(), new C01591(this));
    private C0160b f502d;
    private C0160b f503e;

    interface C0124a {
        void mo103a();

        void mo104a(int i);
    }

    class C01591 implements Callback {
        final /* synthetic */ C0161o f496a;

        C01591(C0161o c0161o) {
            this.f496a = c0161o;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f496a.m771a((C0160b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    private static class C0160b {
        final WeakReference<C0124a> f497a;
        int f498b;

        C0160b(int i, C0124a c0124a) {
            this.f497a = new WeakReference(c0124a);
            this.f498b = i;
        }

        boolean m761a(C0124a c0124a) {
            return c0124a != null && this.f497a.get() == c0124a;
        }
    }

    private C0161o() {
    }

    static C0161o m762a() {
        if (f499a == null) {
            f499a = new C0161o();
        }
        return f499a;
    }

    private boolean m763a(C0160b c0160b, int i) {
        C0124a c0124a = (C0124a) c0160b.f497a.get();
        if (c0124a == null) {
            return false;
        }
        this.f501c.removeCallbacksAndMessages(c0160b);
        c0124a.mo104a(i);
        return true;
    }

    private void m764b() {
        if (this.f503e != null) {
            this.f502d = this.f503e;
            this.f503e = null;
            C0124a c0124a = (C0124a) this.f502d.f497a.get();
            if (c0124a != null) {
                c0124a.mo103a();
            } else {
                this.f502d = null;
            }
        }
    }

    private void m765b(C0160b c0160b) {
        if (c0160b.f498b != -2) {
            int i = 2750;
            if (c0160b.f498b > 0) {
                i = c0160b.f498b;
            } else if (c0160b.f498b == -1) {
                i = 1500;
            }
            this.f501c.removeCallbacksAndMessages(c0160b);
            this.f501c.sendMessageDelayed(Message.obtain(this.f501c, 0, c0160b), (long) i);
        }
    }

    private boolean m766f(C0124a c0124a) {
        return this.f502d != null && this.f502d.m761a(c0124a);
    }

    private boolean m767g(C0124a c0124a) {
        return this.f503e != null && this.f503e.m761a(c0124a);
    }

    public void m768a(int i, C0124a c0124a) {
        synchronized (this.f500b) {
            if (m766f(c0124a)) {
                this.f502d.f498b = i;
                this.f501c.removeCallbacksAndMessages(this.f502d);
                m765b(this.f502d);
                return;
            }
            if (m767g(c0124a)) {
                this.f503e.f498b = i;
            } else {
                this.f503e = new C0160b(i, c0124a);
            }
            if (this.f502d == null || !m763a(this.f502d, 4)) {
                this.f502d = null;
                m764b();
                return;
            }
        }
    }

    public void m769a(C0124a c0124a) {
        synchronized (this.f500b) {
            if (m766f(c0124a)) {
                this.f502d = null;
                if (this.f503e != null) {
                    m764b();
                }
            }
        }
    }

    public void m770a(C0124a c0124a, int i) {
        synchronized (this.f500b) {
            if (m766f(c0124a)) {
                m763a(this.f502d, i);
            } else if (m767g(c0124a)) {
                m763a(this.f503e, i);
            }
        }
    }

    void m771a(C0160b c0160b) {
        synchronized (this.f500b) {
            if (this.f502d == c0160b || this.f503e == c0160b) {
                m763a(c0160b, 2);
            }
        }
    }

    public void m772b(C0124a c0124a) {
        synchronized (this.f500b) {
            if (m766f(c0124a)) {
                m765b(this.f502d);
            }
        }
    }

    public void m773c(C0124a c0124a) {
        synchronized (this.f500b) {
            if (m766f(c0124a)) {
                this.f501c.removeCallbacksAndMessages(this.f502d);
            }
        }
    }

    public void m774d(C0124a c0124a) {
        synchronized (this.f500b) {
            if (m766f(c0124a)) {
                m765b(this.f502d);
            }
        }
    }

    public boolean m775e(C0124a c0124a) {
        boolean z;
        synchronized (this.f500b) {
            z = m766f(c0124a) || m767g(c0124a);
        }
        return z;
    }
}
