package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class C0494e {
    private static final C0492b f1242b;
    private EdgeEffect f1243a;

    static class C0492b {
        C0492b() {
        }

        public void mo376a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static class C0493a extends C0492b {
        C0493a() {
        }

        public void mo376a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1242b = new C0493a();
        } else {
            f1242b = new C0492b();
        }
    }

    @Deprecated
    public C0494e(Context context) {
        this.f1243a = new EdgeEffect(context);
    }

    public static void m2395a(EdgeEffect edgeEffect, float f, float f2) {
        f1242b.mo376a(edgeEffect, f, f2);
    }

    @Deprecated
    public void m2396a(int i, int i2) {
        this.f1243a.setSize(i, i2);
    }

    @Deprecated
    public boolean m2397a() {
        return this.f1243a.isFinished();
    }

    @Deprecated
    public boolean m2398a(float f, float f2) {
        f1242b.mo376a(this.f1243a, f, f2);
        return true;
    }

    @Deprecated
    public boolean m2399a(int i) {
        this.f1243a.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean m2400a(Canvas canvas) {
        return this.f1243a.draw(canvas);
    }

    @Deprecated
    public boolean m2401b() {
        this.f1243a.onRelease();
        return this.f1243a.isFinished();
    }
}
