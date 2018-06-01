package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.C0172r.C0171e;
import android.support.design.widget.C0172r.C0171e.C0166b;
import android.support.design.widget.C0172r.C0171e.C0168a;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class C0174s extends C0171e {
    private static final Handler f518a = new Handler(Looper.getMainLooper());
    private long f519b;
    private boolean f520c;
    private float f521d;
    private final int[] f522e = new int[2];
    private final float[] f523f = new float[2];
    private long f524g = 200;
    private Interpolator f525h;
    private ArrayList<C0168a> f526i;
    private ArrayList<C0166b> f527j;
    private final Runnable f528k = new C01731(this);

    class C01731 implements Runnable {
        final /* synthetic */ C0174s f517a;

        C01731(C0174s c0174s) {
            this.f517a = c0174s;
        }

        public void run() {
            this.f517a.m833h();
        }
    }

    C0174s() {
    }

    private void m816i() {
        if (this.f527j != null) {
            int size = this.f527j.size();
            for (int i = 0; i < size; i++) {
                ((C0166b) this.f527j.get(i)).mo138a();
            }
        }
    }

    private void m817j() {
        if (this.f526i != null) {
            int size = this.f526i.size();
            for (int i = 0; i < size; i++) {
                ((C0168a) this.f526i.get(i)).mo139a();
            }
        }
    }

    private void m818k() {
        if (this.f526i != null) {
            int size = this.f526i.size();
            for (int i = 0; i < size; i++) {
                ((C0168a) this.f526i.get(i)).mo141c();
            }
        }
    }

    private void m819l() {
        if (this.f526i != null) {
            int size = this.f526i.size();
            for (int i = 0; i < size; i++) {
                ((C0168a) this.f526i.get(i)).mo140b();
            }
        }
    }

    public void mo142a() {
        if (!this.f520c) {
            if (this.f525h == null) {
                this.f525h = new AccelerateDecelerateInterpolator();
            }
            this.f520c = true;
            this.f521d = 0.0f;
            m832g();
        }
    }

    public void mo143a(float f, float f2) {
        this.f523f[0] = f;
        this.f523f[1] = f2;
    }

    public void mo144a(int i, int i2) {
        this.f522e[0] = i;
        this.f522e[1] = i2;
    }

    public void mo145a(long j) {
        this.f524g = j;
    }

    public void mo146a(C0168a c0168a) {
        if (this.f526i == null) {
            this.f526i = new ArrayList();
        }
        this.f526i.add(c0168a);
    }

    public void mo147a(C0166b c0166b) {
        if (this.f527j == null) {
            this.f527j = new ArrayList();
        }
        this.f527j.add(c0166b);
    }

    public void mo148a(Interpolator interpolator) {
        this.f525h = interpolator;
    }

    public boolean mo149b() {
        return this.f520c;
    }

    public int mo150c() {
        return C0118a.m629a(this.f522e[0], this.f522e[1], mo152e());
    }

    public void mo151d() {
        this.f520c = false;
        f518a.removeCallbacks(this.f528k);
        m818k();
        m819l();
    }

    public float mo152e() {
        return this.f521d;
    }

    public void mo153f() {
        if (this.f520c) {
            this.f520c = false;
            f518a.removeCallbacks(this.f528k);
            this.f521d = 1.0f;
            m816i();
            m819l();
        }
    }

    final void m832g() {
        this.f519b = SystemClock.uptimeMillis();
        m816i();
        m817j();
        f518a.postDelayed(this.f528k, 10);
    }

    final void m833h() {
        if (this.f520c) {
            float a = C0156l.m746a(((float) (SystemClock.uptimeMillis() - this.f519b)) / ((float) this.f524g), 0.0f, 1.0f);
            if (this.f525h != null) {
                a = this.f525h.getInterpolation(a);
            }
            this.f521d = a;
            m816i();
            if (SystemClock.uptimeMillis() >= this.f519b + this.f524g) {
                this.f520c = false;
                m819l();
            }
        }
        if (this.f520c) {
            f518a.postDelayed(this.f528k, 10);
        }
    }
}
