package com.p029b.p030a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.p029b.p030a.C0951t.C0947d;
import java.io.InputStream;

public abstract class C0908y {

    public static final class C0959a {
        private final C0947d f3188a;
        private final Bitmap f3189b;
        private final InputStream f3190c;
        private final int f3191d;

        public C0959a(Bitmap bitmap, C0947d c0947d) {
            this((Bitmap) ag.m5002a((Object) bitmap, "bitmap == null"), null, c0947d, 0);
        }

        C0959a(Bitmap bitmap, InputStream inputStream, C0947d c0947d, int i) {
            int i2 = 1;
            int i3 = bitmap != null ? 1 : 0;
            if (inputStream == null) {
                i2 = 0;
            }
            if ((i2 ^ i3) == 0) {
                throw new AssertionError();
            }
            this.f3189b = bitmap;
            this.f3190c = inputStream;
            this.f3188a = (C0947d) ag.m5002a((Object) c0947d, "loadedFrom == null");
            this.f3191d = i;
        }

        public C0959a(InputStream inputStream, C0947d c0947d) {
            this(null, (InputStream) ag.m5002a((Object) inputStream, "stream == null"), c0947d, 0);
        }

        public Bitmap m5180a() {
            return this.f3189b;
        }

        public InputStream m5181b() {
            return this.f3190c;
        }

        public C0947d m5182c() {
            return this.f3188a;
        }

        int m5183d() {
            return this.f3191d;
        }
    }

    static void m5020a(int i, int i2, int i3, int i4, Options options, C0957w c0957w) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                i5 = (int) Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = c0957w.f3167k ? Math.max(i5, floor) : Math.min(i5, floor);
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    static void m5021a(int i, int i2, Options options, C0957w c0957w) {
        C0908y.m5020a(i, i2, options.outWidth, options.outHeight, options, c0957w);
    }

    static boolean m5022a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static Options m5023c(C0957w c0957w) {
        boolean d = c0957w.m5169d();
        Object obj = c0957w.f3173q != null ? 1 : null;
        Options options = null;
        if (d || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = d;
            if (obj != null) {
                options.inPreferredConfig = c0957w.f3173q;
            }
        }
        return options;
    }

    int mo821a() {
        return 0;
    }

    public abstract C0959a mo814a(C0957w c0957w, int i);

    public abstract boolean mo815a(C0957w c0957w);

    boolean mo822a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean mo823b() {
        return false;
    }
}
