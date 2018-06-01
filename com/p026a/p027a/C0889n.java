package com.p026a.p027a;

import com.p026a.p027a.C0854b.C0869a;

public class C0889n<T> {
    public final T f2934a;
    public final C0869a f2935b;
    public final C0867s f2936c;
    public boolean f2937d;

    public interface C0887a {
        void mo846a(C0867s c0867s);
    }

    public interface C0888b<T> {
        void mo845a(T t);
    }

    private C0889n(C0867s c0867s) {
        this.f2937d = false;
        this.f2934a = null;
        this.f2935b = null;
        this.f2936c = c0867s;
    }

    private C0889n(T t, C0869a c0869a) {
        this.f2937d = false;
        this.f2934a = t;
        this.f2935b = c0869a;
        this.f2936c = null;
    }

    public static <T> C0889n<T> m4941a(C0867s c0867s) {
        return new C0889n(c0867s);
    }

    public static <T> C0889n<T> m4942a(T t, C0869a c0869a) {
        return new C0889n(t, c0869a);
    }

    public boolean m4943a() {
        return this.f2936c == null;
    }
}
