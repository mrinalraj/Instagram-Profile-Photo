package com.p029b.p030a;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.p029b.p030a.C0951t.C0948e;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class C0957w {
    private static final long f3156s = TimeUnit.SECONDS.toNanos(5);
    int f3157a;
    long f3158b;
    int f3159c;
    public final Uri f3160d;
    public final int f3161e;
    public final String f3162f;
    public final List<ae> f3163g;
    public final int f3164h;
    public final int f3165i;
    public final boolean f3166j;
    public final boolean f3167k;
    public final boolean f3168l;
    public final float f3169m;
    public final float f3170n;
    public final float f3171o;
    public final boolean f3172p;
    public final Config f3173q;
    public final C0948e f3174r;

    public static final class C0956a {
        private Uri f3141a;
        private int f3142b;
        private String f3143c;
        private int f3144d;
        private int f3145e;
        private boolean f3146f;
        private boolean f3147g;
        private boolean f3148h;
        private float f3149i;
        private float f3150j;
        private float f3151k;
        private boolean f3152l;
        private List<ae> f3153m;
        private Config f3154n;
        private C0948e f3155o;

        C0956a(Uri uri, int i, Config config) {
            this.f3141a = uri;
            this.f3142b = i;
            this.f3154n = config;
        }

        public C0956a m5162a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f3144d = i;
                this.f3145e = i2;
                return this;
            }
        }

        boolean m5163a() {
            return (this.f3141a == null && this.f3142b == 0) ? false : true;
        }

        boolean m5164b() {
            return (this.f3144d == 0 && this.f3145e == 0) ? false : true;
        }

        public C0957w m5165c() {
            if (this.f3147g && this.f3146f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f3146f && this.f3144d == 0 && this.f3145e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (this.f3147g && this.f3144d == 0 && this.f3145e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.f3155o == null) {
                    this.f3155o = C0948e.NORMAL;
                }
                return new C0957w(this.f3141a, this.f3142b, this.f3143c, this.f3153m, this.f3144d, this.f3145e, this.f3146f, this.f3147g, this.f3148h, this.f3149i, this.f3150j, this.f3151k, this.f3152l, this.f3154n, this.f3155o);
            }
        }
    }

    private C0957w(Uri uri, int i, String str, List<ae> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Config config, C0948e c0948e) {
        this.f3160d = uri;
        this.f3161e = i;
        this.f3162f = str;
        if (list == null) {
            this.f3163g = null;
        } else {
            this.f3163g = Collections.unmodifiableList(list);
        }
        this.f3164h = i2;
        this.f3165i = i3;
        this.f3166j = z;
        this.f3167k = z2;
        this.f3168l = z3;
        this.f3169m = f;
        this.f3170n = f2;
        this.f3171o = f3;
        this.f3172p = z4;
        this.f3173q = config;
        this.f3174r = c0948e;
    }

    String m5166a() {
        long nanoTime = System.nanoTime() - this.f3158b;
        return nanoTime > f3156s ? m5167b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's' : m5167b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    String m5167b() {
        return "[R" + this.f3157a + ']';
    }

    String m5168c() {
        return this.f3160d != null ? String.valueOf(this.f3160d.getPath()) : Integer.toHexString(this.f3161e);
    }

    public boolean m5169d() {
        return (this.f3164h == 0 && this.f3165i == 0) ? false : true;
    }

    boolean m5170e() {
        return m5171f() || m5172g();
    }

    boolean m5171f() {
        return m5169d() || this.f3169m != 0.0f;
    }

    boolean m5172g() {
        return this.f3163g != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.f3161e > 0) {
            stringBuilder.append(this.f3161e);
        } else {
            stringBuilder.append(this.f3160d);
        }
        if (!(this.f3163g == null || this.f3163g.isEmpty())) {
            for (ae a : this.f3163g) {
                stringBuilder.append(' ').append(a.m4986a());
            }
        }
        if (this.f3162f != null) {
            stringBuilder.append(" stableKey(").append(this.f3162f).append(')');
        }
        if (this.f3164h > 0) {
            stringBuilder.append(" resize(").append(this.f3164h).append(',').append(this.f3165i).append(')');
        }
        if (this.f3166j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.f3167k) {
            stringBuilder.append(" centerInside");
        }
        if (this.f3169m != 0.0f) {
            stringBuilder.append(" rotation(").append(this.f3169m);
            if (this.f3172p) {
                stringBuilder.append(" @ ").append(this.f3170n).append(',').append(this.f3171o);
            }
            stringBuilder.append(')');
        }
        if (this.f3173q != null) {
            stringBuilder.append(' ').append(this.f3173q);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
