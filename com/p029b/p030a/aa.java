package com.p029b.p030a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class aa {
    final HandlerThread f2962a = new HandlerThread("Picasso-Stats", 10);
    final C0917d f2963b;
    final Handler f2964c;
    long f2965d;
    long f2966e;
    long f2967f;
    long f2968g;
    long f2969h;
    long f2970i;
    long f2971j;
    long f2972k;
    int f2973l;
    int f2974m;
    int f2975n;

    private static class C0898a extends Handler {
        private final aa f2961a;

        public C0898a(Looper looper, aa aaVar) {
            super(looper);
            this.f2961a = aaVar;
        }

        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.f2961a.m4975c();
                    return;
                case 1:
                    this.f2961a.m4977d();
                    return;
                case 2:
                    this.f2961a.m4973b((long) message.arg1);
                    return;
                case 3:
                    this.f2961a.m4976c((long) message.arg1);
                    return;
                case 4:
                    this.f2961a.m4971a((Long) message.obj);
                    return;
                default:
                    C0951t.f3115a.post(new Runnable(this) {
                        final /* synthetic */ C0898a f2960b;

                        public void run() {
                            throw new AssertionError("Unhandled stats message." + message.what);
                        }
                    });
                    return;
            }
        }
    }

    aa(C0917d c0917d) {
        this.f2963b = c0917d;
        this.f2962a.start();
        ag.m5008a(this.f2962a.getLooper());
        this.f2964c = new C0898a(this.f2962a.getLooper(), this);
    }

    private static long m4966a(int i, long j) {
        return j / ((long) i);
    }

    private void m4967a(Bitmap bitmap, int i) {
        this.f2964c.sendMessage(this.f2964c.obtainMessage(i, ag.m4997a(bitmap), 0));
    }

    void m4968a() {
        this.f2964c.sendEmptyMessage(0);
    }

    void m4969a(long j) {
        this.f2964c.sendMessage(this.f2964c.obtainMessage(4, Long.valueOf(j)));
    }

    void m4970a(Bitmap bitmap) {
        m4967a(bitmap, 2);
    }

    void m4971a(Long l) {
        this.f2973l++;
        this.f2967f += l.longValue();
        this.f2970i = aa.m4966a(this.f2973l, this.f2967f);
    }

    void m4972b() {
        this.f2964c.sendEmptyMessage(1);
    }

    void m4973b(long j) {
        this.f2974m++;
        this.f2968g += j;
        this.f2971j = aa.m4966a(this.f2974m, this.f2968g);
    }

    void m4974b(Bitmap bitmap) {
        m4967a(bitmap, 3);
    }

    void m4975c() {
        this.f2965d++;
    }

    void m4976c(long j) {
        this.f2975n++;
        this.f2969h += j;
        this.f2972k = aa.m4966a(this.f2974m, this.f2969h);
    }

    void m4977d() {
        this.f2966e++;
    }

    ab m4978e() {
        return new ab(this.f2963b.mo819b(), this.f2963b.mo816a(), this.f2965d, this.f2966e, this.f2967f, this.f2968g, this.f2969h, this.f2970i, this.f2971j, this.f2972k, this.f2973l, this.f2974m, this.f2975n, System.currentTimeMillis());
    }
}
