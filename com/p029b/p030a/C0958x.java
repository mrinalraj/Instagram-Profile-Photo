package com.p029b.p030a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.p029b.p030a.C0951t.C0947d;
import com.p029b.p030a.C0957w.C0956a;
import java.util.concurrent.atomic.AtomicInteger;

public class C0958x {
    private static final AtomicInteger f3175a = new AtomicInteger();
    private final C0951t f3176b;
    private final C0956a f3177c;
    private boolean f3178d;
    private boolean f3179e;
    private boolean f3180f;
    private int f3181g;
    private int f3182h;
    private int f3183i;
    private int f3184j;
    private Drawable f3185k;
    private Drawable f3186l;
    private Object f3187m;

    C0958x() {
        this.f3180f = true;
        this.f3176b = null;
        this.f3177c = new C0956a(null, 0, null);
    }

    C0958x(C0951t c0951t, Uri uri, int i) {
        this.f3180f = true;
        if (c0951t.f3127m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f3176b = c0951t;
        this.f3177c = new C0956a(uri, i, c0951t.f3124j);
    }

    private C0957w m5173a(long j) {
        int andIncrement = f3175a.getAndIncrement();
        C0957w c = this.f3177c.m5165c();
        c.f3157a = andIncrement;
        c.f3158b = j;
        boolean z = this.f3176b.f3126l;
        if (z) {
            ag.m5011a("Main", "created", c.m5167b(), c.toString());
        }
        C0957w a = this.f3176b.m5143a(c);
        if (a != c) {
            a.f3157a = andIncrement;
            a.f3158b = j;
            if (z) {
                ag.m5011a("Main", "changed", a.m5166a(), "into " + a);
            }
        }
        return a;
    }

    private Drawable m5174b() {
        return this.f3181g != 0 ? this.f3176b.f3117c.getResources().getDrawable(this.f3181g) : this.f3185k;
    }

    C0958x m5175a() {
        this.f3179e = false;
        return this;
    }

    public C0958x m5176a(int i, int i2) {
        this.f3177c.m5162a(i, i2);
        return this;
    }

    public void m5177a(ImageView imageView) {
        m5178a(imageView, null);
    }

    public void m5178a(ImageView imageView, C0919e c0919e) {
        long nanoTime = System.nanoTime();
        ag.m5007a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.f3177c.m5163a()) {
            if (this.f3179e) {
                if (this.f3177c.m5164b()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width == 0 || height == 0) {
                    if (this.f3180f) {
                        C0952u.m5158a(imageView, m5174b());
                    }
                    this.f3176b.m5148a(imageView, new C0923h(this, imageView, c0919e));
                    return;
                }
                this.f3177c.m5162a(width, height);
            }
            C0957w a = m5173a(nanoTime);
            String a2 = ag.m5005a(a);
            if (C0937p.m5123a(this.f3183i)) {
                Bitmap b = this.f3176b.m5152b(a2);
                if (b != null) {
                    this.f3176b.m5147a(imageView);
                    C0952u.m5157a(imageView, this.f3176b.f3117c, b, C0947d.MEMORY, this.f3178d, this.f3176b.f3125k);
                    if (this.f3176b.f3126l) {
                        ag.m5011a("Main", "completed", a.m5167b(), "from " + C0947d.MEMORY);
                    }
                    if (c0919e != null) {
                        c0919e.mo829a();
                        return;
                    }
                    return;
                }
            }
            if (this.f3180f) {
                C0952u.m5158a(imageView, m5174b());
            }
            this.f3176b.m5149a(new C0932l(this.f3176b, imageView, a, this.f3183i, this.f3184j, this.f3182h, this.f3186l, a2, this.f3187m, c0919e, this.f3178d));
        } else {
            this.f3176b.m5147a(imageView);
            if (this.f3180f) {
                C0952u.m5158a(imageView, m5174b());
            }
        }
    }

    public void m5179a(ac acVar) {
        Drawable drawable = null;
        long nanoTime = System.nanoTime();
        ag.m5007a();
        if (acVar == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.f3179e) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        } else if (this.f3177c.m5163a()) {
            C0957w a = m5173a(nanoTime);
            String a2 = ag.m5005a(a);
            if (C0937p.m5123a(this.f3183i)) {
                Bitmap b = this.f3176b.m5152b(a2);
                if (b != null) {
                    this.f3176b.m5150a(acVar);
                    acVar.mo831a(b, C0947d.MEMORY);
                    return;
                }
            }
            if (this.f3180f) {
                drawable = m5174b();
            }
            acVar.mo833b(drawable);
            this.f3176b.m5149a(new ad(this.f3176b, acVar, a, this.f3183i, this.f3184j, this.f3186l, a2, this.f3187m, this.f3182h));
        } else {
            this.f3176b.m5150a(acVar);
            if (this.f3180f) {
                drawable = m5174b();
            }
            acVar.mo833b(drawable);
        }
    }
}
