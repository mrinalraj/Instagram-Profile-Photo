package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0398d;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0522d;
import android.support.v7.view.menu.C0628o.C0577a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class C0655n {
    private final Context f1863a;
    private final C0643h f1864b;
    private final boolean f1865c;
    private final int f1866d;
    private final int f1867e;
    private View f1868f;
    private int f1869g;
    private boolean f1870h;
    private C0577a f1871i;
    private C0638m f1872j;
    private OnDismissListener f1873k;
    private final OnDismissListener f1874l;

    class C06541 implements OnDismissListener {
        final /* synthetic */ C0655n f1862a;

        C06541(C0655n c0655n) {
            this.f1862a = c0655n;
        }

        public void onDismiss() {
            this.f1862a.mo772e();
        }
    }

    public C0655n(Context context, C0643h c0643h, View view, boolean z, int i) {
        this(context, c0643h, view, z, i, 0);
    }

    public C0655n(Context context, C0643h c0643h, View view, boolean z, int i, int i2) {
        this.f1869g = 8388611;
        this.f1874l = new C06541(this);
        this.f1863a = context;
        this.f1864b = c0643h;
        this.f1868f = view;
        this.f1865c = z;
        this.f1866d = i;
        this.f1867e = i2;
    }

    private void m3171a(int i, int i2, boolean z, boolean z2) {
        C0638m b = m3180b();
        b.mo544c(z2);
        if (z) {
            if ((C0398d.m1784a(this.f1869g, C0425s.m1966f(this.f1868f)) & 7) == 5) {
                i += this.f1868f.getWidth();
            }
            b.mo541b(i);
            b.mo543c(i2);
            int i3 = (int) ((this.f1863a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.m3012a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.mo535a();
    }

    private C0638m m3172g() {
        Display defaultDisplay = ((WindowManager) this.f1863a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        C0638m c0639e = (Math.min(point.x, point.y) >= this.f1863a.getResources().getDimensionPixelSize(C0522d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null ? new C0639e(this.f1863a, this.f1868f, this.f1866d, this.f1867e, this.f1865c) : new C0660t(this.f1863a, this.f1864b, this.f1868f, this.f1866d, this.f1867e, this.f1865c);
        c0639e.mo537a(this.f1864b);
        c0639e.mo539a(this.f1874l);
        c0639e.mo538a(this.f1868f);
        c0639e.mo527a(this.f1871i);
        c0639e.mo540a(this.f1870h);
        c0639e.mo536a(this.f1869g);
        return c0639e;
    }

    public void m3173a() {
        if (!m3181c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m3174a(int i) {
        this.f1869g = i;
    }

    public void m3175a(C0577a c0577a) {
        this.f1871i = c0577a;
        if (this.f1872j != null) {
            this.f1872j.mo527a(c0577a);
        }
    }

    public void m3176a(View view) {
        this.f1868f = view;
    }

    public void m3177a(OnDismissListener onDismissListener) {
        this.f1873k = onDismissListener;
    }

    public void m3178a(boolean z) {
        this.f1870h = z;
        if (this.f1872j != null) {
            this.f1872j.mo540a(z);
        }
    }

    public boolean m3179a(int i, int i2) {
        if (m3184f()) {
            return true;
        }
        if (this.f1868f == null) {
            return false;
        }
        m3171a(i, i2, true, true);
        return true;
    }

    public C0638m m3180b() {
        if (this.f1872j == null) {
            this.f1872j = m3172g();
        }
        return this.f1872j;
    }

    public boolean m3181c() {
        if (m3184f()) {
            return true;
        }
        if (this.f1868f == null) {
            return false;
        }
        m3171a(0, 0, false, false);
        return true;
    }

    public void m3182d() {
        if (m3184f()) {
            this.f1872j.mo542c();
        }
    }

    protected void mo772e() {
        this.f1872j = null;
        if (this.f1873k != null) {
            this.f1873k.onDismiss();
        }
    }

    public boolean m3184f() {
        return this.f1872j != null && this.f1872j.mo545d();
    }
}
