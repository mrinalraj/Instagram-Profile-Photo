package com.p029b.p030a;

public enum C0937p {
    NO_CACHE(1),
    NO_STORE(2);
    
    final int f3082c;

    private C0937p(int i) {
        this.f3082c = i;
    }

    static boolean m5123a(int i) {
        return (NO_CACHE.f3082c & i) == 0;
    }

    static boolean m5124b(int i) {
        return (NO_STORE.f3082c & i) == 0;
    }
}
