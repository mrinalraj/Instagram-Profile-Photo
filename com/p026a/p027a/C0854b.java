package com.p026a.p027a;

import java.util.Collections;
import java.util.Map;

public interface C0854b {

    public static class C0869a {
        public byte[] f2879a;
        public String f2880b;
        public long f2881c;
        public long f2882d;
        public long f2883e;
        public long f2884f;
        public Map<String, String> f2885g = Collections.emptyMap();

        public boolean m4913a() {
            return this.f2883e < System.currentTimeMillis();
        }

        public boolean m4914b() {
            return this.f2884f < System.currentTimeMillis();
        }
    }

    C0869a mo795a(String str);

    void mo796a();

    void mo797a(String str, C0869a c0869a);
}
