package com.p029b.p030a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.p029b.p030a.C0951t.C0947d;
import com.p029b.p030a.C0951t.C0948e;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class C0896a<T> {
    final C0951t f2947a;
    final C0957w f2948b;
    final WeakReference<T> f2949c;
    final boolean f2950d;
    final int f2951e;
    final int f2952f;
    final int f2953g;
    final Drawable f2954h;
    final String f2955i;
    final Object f2956j;
    boolean f2957k;
    boolean f2958l;

    static class C0895a<M> extends WeakReference<M> {
        final C0896a f2946a;

        public C0895a(C0896a c0896a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f2946a = c0896a;
        }
    }

    C0896a(C0951t c0951t, T t, C0957w c0957w, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f2947a = c0951t;
        this.f2948b = c0957w;
        this.f2949c = t == null ? null : new C0895a(this, t, c0951t.f3123i);
        this.f2951e = i;
        this.f2952f = i2;
        this.f2950d = z;
        this.f2953g = i3;
        this.f2954h = drawable;
        this.f2955i = str;
        if (obj == null) {
            C0896a c0896a = this;
        }
        this.f2956j = obj;
    }

    abstract void mo811a();

    abstract void mo812a(Bitmap bitmap, C0947d c0947d);

    void mo820b() {
        this.f2958l = true;
    }

    C0957w m4956c() {
        return this.f2948b;
    }

    T m4957d() {
        return this.f2949c == null ? null : this.f2949c.get();
    }

    String m4958e() {
        return this.f2955i;
    }

    boolean m4959f() {
        return this.f2958l;
    }

    boolean m4960g() {
        return this.f2957k;
    }

    int m4961h() {
        return this.f2951e;
    }

    int m4962i() {
        return this.f2952f;
    }

    C0951t m4963j() {
        return this.f2947a;
    }

    C0948e m4964k() {
        return this.f2948b.f3174r;
    }

    Object m4965l() {
        return this.f2956j;
    }
}
