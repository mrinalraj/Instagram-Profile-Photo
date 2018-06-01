package com.p029b.p030a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;
import com.p029b.p030a.C0951t.C0948e;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class C0916c implements Runnable {
    private static final Object f3002t = new Object();
    private static final ThreadLocal<StringBuilder> f3003u = new C09101();
    private static final AtomicInteger f3004v = new AtomicInteger();
    private static final C0908y f3005w = new C09112();
    final int f3006a = f3004v.incrementAndGet();
    final C0951t f3007b;
    final C0928i f3008c;
    final C0917d f3009d;
    final aa f3010e;
    final String f3011f;
    final C0957w f3012g;
    final int f3013h;
    int f3014i;
    final C0908y f3015j;
    C0896a f3016k;
    List<C0896a> f3017l;
    Bitmap f3018m;
    Future<?> f3019n;
    C0947d f3020o;
    Exception f3021p;
    int f3022q;
    int f3023r;
    C0948e f3024s;

    static class C09101 extends ThreadLocal<StringBuilder> {
        C09101() {
        }

        protected StringBuilder m5032a() {
            return new StringBuilder("Picasso-");
        }

        protected /* synthetic */ Object initialValue() {
            return m5032a();
        }
    }

    static class C09112 extends C0908y {
        C09112() {
        }

        public C0959a mo814a(C0957w c0957w, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + c0957w);
        }

        public boolean mo815a(C0957w c0957w) {
            return true;
        }
    }

    C0916c(C0951t c0951t, C0928i c0928i, C0917d c0917d, aa aaVar, C0896a c0896a, C0908y c0908y) {
        this.f3007b = c0951t;
        this.f3008c = c0928i;
        this.f3009d = c0917d;
        this.f3010e = aaVar;
        this.f3016k = c0896a;
        this.f3011f = c0896a.m4958e();
        this.f3012g = c0896a.m4956c();
        this.f3024s = c0896a.m4964k();
        this.f3013h = c0896a.m4961h();
        this.f3014i = c0896a.m4962i();
        this.f3015j = c0908y;
        this.f3023r = c0908y.mo821a();
    }

    static Bitmap m5035a(C0957w c0957w, Bitmap bitmap, int i) {
        int ceil;
        int i2;
        int i3;
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = c0957w.f3168l;
        Matrix matrix = new Matrix();
        if (c0957w.m5171f()) {
            int i4 = c0957w.f3164h;
            int i5 = c0957w.f3165i;
            float f = c0957w.f3169m;
            if (f != 0.0f) {
                if (c0957w.f3172p) {
                    matrix.setRotate(f, c0957w.f3170n, c0957w.f3171o);
                } else {
                    matrix.setRotate(f);
                }
            }
            float f2;
            if (c0957w.f3166j) {
                int i6;
                int i7;
                f2 = ((float) i4) / ((float) width);
                f = ((float) i5) / ((float) height);
                if (f2 > f) {
                    ceil = (int) Math.ceil((double) ((f / f2) * ((float) height)));
                    f = ((float) i5) / ((float) ceil);
                    i6 = 0;
                    i7 = (height - ceil) / 2;
                    i2 = width;
                } else {
                    ceil = (int) Math.ceil((double) ((f2 / f) * ((float) width)));
                    f2 = ((float) i4) / ((float) ceil);
                    i6 = (width - ceil) / 2;
                    i7 = 0;
                    i2 = ceil;
                    ceil = height;
                }
                if (C0916c.m5040a(z, width, height, i4, i5)) {
                    matrix.preScale(f2, f);
                }
                height = i2;
                i3 = i6;
                i2 = ceil;
                ceil = i7;
            } else if (c0957w.f3167k) {
                f = ((float) i4) / ((float) width);
                f2 = ((float) i5) / ((float) height);
                if (f >= f2) {
                    f = f2;
                }
                if (C0916c.m5040a(z, width, height, i4, i5)) {
                    matrix.preScale(f, f);
                }
                ceil = 0;
                i3 = 0;
                i2 = height;
                height = width;
            } else if (!((i4 == 0 && i5 == 0) || (i4 == width && i5 == height))) {
                f2 = i4 != 0 ? ((float) i4) / ((float) width) : ((float) i5) / ((float) height);
                f = i5 != 0 ? ((float) i5) / ((float) height) : ((float) i4) / ((float) width);
                if (C0916c.m5040a(z, width, height, i4, i5)) {
                    matrix.preScale(f2, f);
                }
            }
            if (i != 0) {
                matrix.preRotate((float) i);
            }
            createBitmap = Bitmap.createBitmap(bitmap, i3, ceil, height, i2, matrix, true);
            if (createBitmap != bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }
        ceil = 0;
        i3 = 0;
        i2 = height;
        height = width;
        if (i != 0) {
            matrix.preRotate((float) i);
        }
        createBitmap = Bitmap.createBitmap(bitmap, i3, ceil, height, i2, matrix, true);
        if (createBitmap != bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    static Bitmap m5036a(InputStream inputStream, C0957w c0957w) {
        InputStream c0934n = new C0934n(inputStream);
        long a = c0934n.m5117a(65536);
        Options c = C0908y.m5023c(c0957w);
        boolean a2 = C0908y.m5022a(c);
        boolean c2 = ag.m5018c(c0934n);
        c0934n.m5118a(a);
        if (c2) {
            byte[] b = ag.m5016b(c0934n);
            if (a2) {
                BitmapFactory.decodeByteArray(b, 0, b.length, c);
                C0908y.m5021a(c0957w.f3164h, c0957w.f3165i, c, c0957w);
            }
            return BitmapFactory.decodeByteArray(b, 0, b.length, c);
        }
        if (a2) {
            BitmapFactory.decodeStream(c0934n, null, c);
            C0908y.m5021a(c0957w.f3164h, c0957w.f3165i, c, c0957w);
            c0934n.m5118a(a);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(c0934n, null, c);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    static Bitmap m5037a(List<ae> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            final ae aeVar = (ae) list.get(i);
            try {
                bitmap = aeVar.m4985a(bitmap2);
                if (bitmap == null) {
                    final StringBuilder append = new StringBuilder().append("Transformation ").append(aeVar.m4986a()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                    for (ae aeVar2 : list) {
                        append.append(aeVar2.m4986a()).append('\n');
                    }
                    C0951t.f3115a.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(append.toString());
                        }
                    });
                    return null;
                } else if (bitmap == bitmap2 && bitmap2.isRecycled()) {
                    C0951t.f3115a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + aeVar2.m4986a() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (bitmap == bitmap2 || bitmap2.isRecycled()) {
                    i++;
                    bitmap2 = bitmap;
                } else {
                    C0951t.f3115a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + aeVar2.m4986a() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (final RuntimeException e) {
                C0951t.f3115a.post(new Runnable() {
                    public void run() {
                        throw new RuntimeException("Transformation " + aeVar2.m4986a() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap2;
    }

    static C0916c m5038a(C0951t c0951t, C0928i c0928i, C0917d c0917d, aa aaVar, C0896a c0896a) {
        C0957w c = c0896a.m4956c();
        List a = c0951t.m5146a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            C0908y c0908y = (C0908y) a.get(i);
            if (c0908y.mo815a(c)) {
                return new C0916c(c0951t, c0928i, c0917d, aaVar, c0896a, c0908y);
            }
        }
        return new C0916c(c0951t, c0928i, c0917d, aaVar, c0896a, f3005w);
    }

    static void m5039a(C0957w c0957w) {
        String c = c0957w.m5168c();
        StringBuilder stringBuilder = (StringBuilder) f3003u.get();
        stringBuilder.ensureCapacity("Picasso-".length() + c.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), c);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    private static boolean m5040a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    private C0948e m5041o() {
        int i = 1;
        int i2 = 0;
        C0948e c0948e = C0948e.LOW;
        int i3 = (this.f3017l == null || this.f3017l.isEmpty()) ? 0 : 1;
        if (this.f3016k == null && i3 == 0) {
            i = 0;
        }
        if (i == 0) {
            return c0948e;
        }
        C0948e k = this.f3016k != null ? this.f3016k.m4964k() : c0948e;
        if (i3 == 0) {
            return k;
        }
        int size = this.f3017l.size();
        while (i2 < size) {
            C0948e k2 = ((C0896a) this.f3017l.get(i2)).m4964k();
            if (k2.ordinal() <= k.ordinal()) {
                k2 = k;
            }
            i2++;
            k = k2;
        }
        return k;
    }

    Bitmap m5042a() {
        Bitmap bitmap = null;
        if (C0937p.m5123a(this.f3013h)) {
            bitmap = this.f3009d.mo817a(this.f3011f);
            if (bitmap != null) {
                this.f3010e.m4968a();
                this.f3020o = C0947d.MEMORY;
                if (this.f3007b.f3126l) {
                    ag.m5011a("Hunter", "decoded", this.f3012g.m5166a(), "from cache");
                }
                return bitmap;
            }
        }
        this.f3012g.f3159c = this.f3023r == 0 ? C0938q.OFFLINE.f3087d : this.f3014i;
        C0959a a = this.f3015j.mo814a(this.f3012g, this.f3014i);
        if (a != null) {
            this.f3020o = a.m5182c();
            this.f3022q = a.m5183d();
            bitmap = a.m5180a();
            if (bitmap == null) {
                InputStream b = a.m5181b();
                try {
                    bitmap = C0916c.m5036a(b, this.f3012g);
                } finally {
                    ag.m5009a(b);
                }
            }
        }
        if (bitmap != null) {
            if (this.f3007b.f3126l) {
                ag.m5010a("Hunter", "decoded", this.f3012g.m5166a());
            }
            this.f3010e.m4970a(bitmap);
            if (this.f3012g.m5170e() || this.f3022q != 0) {
                synchronized (f3002t) {
                    if (this.f3012g.m5171f() || this.f3022q != 0) {
                        bitmap = C0916c.m5035a(this.f3012g, bitmap, this.f3022q);
                        if (this.f3007b.f3126l) {
                            ag.m5010a("Hunter", "transformed", this.f3012g.m5166a());
                        }
                    }
                    if (this.f3012g.m5172g()) {
                        bitmap = C0916c.m5037a(this.f3012g.f3163g, bitmap);
                        if (this.f3007b.f3126l) {
                            ag.m5011a("Hunter", "transformed", this.f3012g.m5166a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f3010e.m4974b(bitmap);
                }
            }
        }
        return bitmap;
    }

    void m5043a(C0896a c0896a) {
        boolean z = this.f3007b.f3126l;
        C0957w c0957w = c0896a.f2948b;
        if (this.f3016k == null) {
            this.f3016k = c0896a;
            if (!z) {
                return;
            }
            if (this.f3017l == null || this.f3017l.isEmpty()) {
                ag.m5011a("Hunter", "joined", c0957w.m5166a(), "to empty hunter");
                return;
            } else {
                ag.m5011a("Hunter", "joined", c0957w.m5166a(), ag.m5004a(this, "to "));
                return;
            }
        }
        if (this.f3017l == null) {
            this.f3017l = new ArrayList(3);
        }
        this.f3017l.add(c0896a);
        if (z) {
            ag.m5011a("Hunter", "joined", c0957w.m5166a(), ag.m5004a(this, "to "));
        }
        C0948e k = c0896a.m4964k();
        if (k.ordinal() > this.f3024s.ordinal()) {
            this.f3024s = k;
        }
    }

    boolean m5044a(boolean z, NetworkInfo networkInfo) {
        if (!(this.f3023r > 0)) {
            return false;
        }
        this.f3023r--;
        return this.f3015j.mo822a(z, networkInfo);
    }

    void m5045b(C0896a c0896a) {
        boolean z = false;
        if (this.f3016k == c0896a) {
            this.f3016k = null;
            z = true;
        } else if (this.f3017l != null) {
            z = this.f3017l.remove(c0896a);
        }
        if (z && c0896a.m4964k() == this.f3024s) {
            this.f3024s = m5041o();
        }
        if (this.f3007b.f3126l) {
            ag.m5011a("Hunter", "removed", c0896a.f2948b.m5166a(), ag.m5004a(this, "from "));
        }
    }

    boolean m5046b() {
        return this.f3016k == null ? (this.f3017l == null || this.f3017l.isEmpty()) && this.f3019n != null && this.f3019n.cancel(false) : false;
    }

    boolean m5047c() {
        return this.f3019n != null && this.f3019n.isCancelled();
    }

    boolean m5048d() {
        return this.f3015j.mo823b();
    }

    Bitmap m5049e() {
        return this.f3018m;
    }

    String m5050f() {
        return this.f3011f;
    }

    int m5051g() {
        return this.f3013h;
    }

    C0957w m5052h() {
        return this.f3012g;
    }

    C0896a m5053i() {
        return this.f3016k;
    }

    C0951t m5054j() {
        return this.f3007b;
    }

    List<C0896a> m5055k() {
        return this.f3017l;
    }

    Exception m5056l() {
        return this.f3021p;
    }

    C0947d m5057m() {
        return this.f3020o;
    }

    C0948e m5058n() {
        return this.f3024s;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = r4.f3012g;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        com.p029b.p030a.C0916c.m5039a(r0);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0 = r4.f3007b;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0 = r0.f3126l;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        if (r0 == 0) goto L_0x0016;
    L_0x000b:
        r0 = "Hunter";
        r1 = "executing";
        r2 = com.p029b.p030a.ag.m5003a(r4);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        com.p029b.p030a.ag.m5010a(r0, r1, r2);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
    L_0x0016:
        r0 = r4.m5042a();	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r4.f3018m = r0;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0 = r4.f3018m;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        if (r0 != 0) goto L_0x002f;
    L_0x0020:
        r0 = r4.f3008c;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0.m5097c(r4);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
    L_0x0025:
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
    L_0x002e:
        return;
    L_0x002f:
        r0 = r4.f3008c;	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        r0.m5087a(r4);	 Catch:{ b -> 0x0035, a -> 0x0051, IOException -> 0x0063, OutOfMemoryError -> 0x0075, Exception -> 0x00a3 }
        goto L_0x0025;
    L_0x0035:
        r0 = move-exception;
        r1 = r0.f3056a;	 Catch:{ all -> 0x00b6 }
        if (r1 == 0) goto L_0x0040;
    L_0x003a:
        r1 = r0.f3057b;	 Catch:{ all -> 0x00b6 }
        r2 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        if (r1 == r2) goto L_0x0042;
    L_0x0040:
        r4.f3021p = r0;	 Catch:{ all -> 0x00b6 }
    L_0x0042:
        r0 = r4.f3008c;	 Catch:{ all -> 0x00b6 }
        r0.m5097c(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0051:
        r0 = move-exception;
        r4.f3021p = r0;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f3008c;	 Catch:{ all -> 0x00b6 }
        r0.m5093b(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0063:
        r0 = move-exception;
        r4.f3021p = r0;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f3008c;	 Catch:{ all -> 0x00b6 }
        r0.m5093b(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x0075:
        r0 = move-exception;
        r1 = new java.io.StringWriter;	 Catch:{ all -> 0x00b6 }
        r1.<init>();	 Catch:{ all -> 0x00b6 }
        r2 = r4.f3010e;	 Catch:{ all -> 0x00b6 }
        r2 = r2.m4978e();	 Catch:{ all -> 0x00b6 }
        r3 = new java.io.PrintWriter;	 Catch:{ all -> 0x00b6 }
        r3.<init>(r1);	 Catch:{ all -> 0x00b6 }
        r2.m4979a(r3);	 Catch:{ all -> 0x00b6 }
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00b6 }
        r1 = r1.toString();	 Catch:{ all -> 0x00b6 }
        r2.<init>(r1, r0);	 Catch:{ all -> 0x00b6 }
        r4.f3021p = r2;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f3008c;	 Catch:{ all -> 0x00b6 }
        r0.m5097c(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x00a3:
        r0 = move-exception;
        r4.f3021p = r0;	 Catch:{ all -> 0x00b6 }
        r0 = r4.f3008c;	 Catch:{ all -> 0x00b6 }
        r0.m5097c(r4);	 Catch:{ all -> 0x00b6 }
        r0 = java.lang.Thread.currentThread();
        r1 = "Picasso-Idle";
        r0.setName(r1);
        goto L_0x002e;
    L_0x00b6:
        r0 = move-exception;
        r1 = java.lang.Thread.currentThread();
        r2 = "Picasso-Idle";
        r1.setName(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.c.run():void");
    }
}
