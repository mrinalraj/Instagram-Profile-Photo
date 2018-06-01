package com.p029b.p030a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

public class C0933m implements C0917d {
    final LinkedHashMap<String, Bitmap> f3059b;
    private final int f3060c;
    private int f3061d;
    private int f3062e;
    private int f3063f;
    private int f3064g;
    private int f3065h;

    public C0933m(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f3060c = i;
        this.f3059b = new LinkedHashMap(0, 0.75f, true);
    }

    public C0933m(Context context) {
        this(ag.m5017c(context));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5110a(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.f3061d;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r3.f3059b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r3.f3061d;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r3.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r3.f3061d;	 Catch:{ all -> 0x0032 }
        if (r0 <= r4) goto L_0x0041;
    L_0x0039:
        r0 = r3.f3059b;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r3.f3059b;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0032 }
        r2 = r3.f3059b;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r1 = r3.f3061d;	 Catch:{ all -> 0x0032 }
        r0 = com.p029b.p030a.ag.m4997a(r0);	 Catch:{ all -> 0x0032 }
        r0 = r1 - r0;
        r3.f3061d = r0;	 Catch:{ all -> 0x0032 }
        r0 = r3.f3063f;	 Catch:{ all -> 0x0032 }
        r0 = r0 + 1;
        r3.f3063f = r0;	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.m.a(int):void");
    }

    public final synchronized int mo816a() {
        return this.f3061d;
    }

    public Bitmap mo817a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = (Bitmap) this.f3059b.get(str);
            if (bitmap != null) {
                this.f3064g++;
                return bitmap;
            }
            this.f3065h++;
            return null;
        }
    }

    public void mo818a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f3062e++;
            this.f3061d += ag.m4997a(bitmap);
            Bitmap bitmap2 = (Bitmap) this.f3059b.put(str, bitmap);
            if (bitmap2 != null) {
                this.f3061d -= ag.m4997a(bitmap2);
            }
        }
        m5110a(this.f3060c);
    }

    public final synchronized int mo819b() {
        return this.f3060c;
    }
}
