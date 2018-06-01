package com.p029b.p030a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface C0901j {

    public static class C0929a {
        final InputStream f3052a;
        final Bitmap f3053b;
        final boolean f3054c;
        final long f3055d;

        public C0929a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f3052a = inputStream;
            this.f3053b = null;
            this.f3054c = z;
            this.f3055d = j;
        }

        public InputStream m5101a() {
            return this.f3052a;
        }

        @Deprecated
        public Bitmap m5102b() {
            return this.f3053b;
        }

        public long m5103c() {
            return this.f3055d;
        }
    }

    public static class C0930b extends IOException {
        final boolean f3056a;
        final int f3057b;

        public C0930b(String str, int i, int i2) {
            super(str);
            this.f3056a = C0938q.m5127c(i);
            this.f3057b = i2;
        }
    }

    C0929a mo813a(Uri uri, int i);
}
