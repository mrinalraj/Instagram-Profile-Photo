package com.p029b.p030a;

public enum C0938q {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    final int f3087d;

    private C0938q(int i) {
        this.f3087d = i;
    }

    public static boolean m5125a(int i) {
        return (NO_CACHE.f3087d & i) == 0;
    }

    public static boolean m5126b(int i) {
        return (NO_STORE.f3087d & i) == 0;
    }

    public static boolean m5127c(int i) {
        return (OFFLINE.f3087d & i) != 0;
    }
}
