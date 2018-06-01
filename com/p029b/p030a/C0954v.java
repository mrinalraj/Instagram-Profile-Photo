package com.p029b.p030a;

import android.net.NetworkInfo;
import com.p029b.p030a.C0951t.C0948e;
import com.p029b.p030a.ag.C0907e;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class C0954v extends ThreadPoolExecutor {

    private static final class C0953a extends FutureTask<C0916c> implements Comparable<C0953a> {
        private final C0916c f3140a;

        public C0953a(C0916c c0916c) {
            super(c0916c, null);
            this.f3140a = c0916c;
        }

        public int m5159a(C0953a c0953a) {
            C0948e n = this.f3140a.m5058n();
            C0948e n2 = c0953a.f3140a.m5058n();
            return n == n2 ? this.f3140a.f3006a - c0953a.f3140a.f3006a : n2.ordinal() - n.ordinal();
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m5159a((C0953a) obj);
        }
    }

    C0954v() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0907e());
    }

    private void m5160a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    void m5161a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m5160a(3);
            return;
        }
        switch (networkInfo.getType()) {
            case 0:
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        m5160a(1);
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 12:
                        m5160a(2);
                        return;
                    case 13:
                    case 14:
                    case 15:
                        m5160a(3);
                        return;
                    default:
                        m5160a(3);
                        return;
                }
            case 1:
            case 6:
            case 9:
                m5160a(4);
                return;
            default:
                m5160a(3);
                return;
        }
    }

    public Future<?> submit(Runnable runnable) {
        Object c0953a = new C0953a((C0916c) runnable);
        execute(c0953a);
        return c0953a;
    }
}
