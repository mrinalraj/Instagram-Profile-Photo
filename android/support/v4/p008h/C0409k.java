package android.support.v4.p008h;

import android.view.View;
import android.view.ViewParent;

public class C0409k {
    private ViewParent f1052a;
    private ViewParent f1053b;
    private final View f1054c;
    private boolean f1055d;
    private int[] f1056e;

    public C0409k(View view) {
        this.f1054c = view;
    }

    private void m1820a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f1052a = viewParent;
                return;
            case 1:
                this.f1053b = viewParent;
                return;
            default:
                return;
        }
    }

    private ViewParent m1821d(int i) {
        switch (i) {
            case 0:
                return this.f1052a;
            case 1:
                return this.f1053b;
            default:
                return null;
        }
    }

    public void m1822a(boolean z) {
        if (this.f1055d) {
            C0425s.m1985x(this.f1054c);
        }
        this.f1055d = z;
    }

    public boolean m1823a() {
        return this.f1055d;
    }

    public boolean m1824a(float f, float f2) {
        if (!m1823a()) {
            return false;
        }
        ViewParent d = m1821d(0);
        return d != null ? C0429t.m2005a(d, this.f1054c, f, f2) : false;
    }

    public boolean m1825a(float f, float f2, boolean z) {
        if (!m1823a()) {
            return false;
        }
        ViewParent d = m1821d(0);
        return d != null ? C0429t.m2006a(d, this.f1054c, f, f2, z) : false;
    }

    public boolean m1826a(int i) {
        return m1821d(i) != null;
    }

    public boolean m1827a(int i, int i2) {
        if (m1826a(i2)) {
            return true;
        }
        if (m1823a()) {
            View view = this.f1054c;
            for (ViewParent parent = this.f1054c.getParent(); parent != null; parent = parent.getParent()) {
                if (C0429t.m2007a(parent, view, this.f1054c, i, i2)) {
                    m1820a(i2, parent);
                    C0429t.m2008b(parent, view, this.f1054c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean m1828a(int i, int i2, int i3, int i4, int[] iArr) {
        return m1829a(i, i2, i3, i4, iArr, 0);
    }

    public boolean m1829a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (m1823a()) {
            ViewParent d = m1821d(i5);
            if (d == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                int i6;
                int i7;
                if (iArr != null) {
                    this.f1054c.getLocationInWindow(iArr);
                    int i8 = iArr[0];
                    i6 = iArr[1];
                    i7 = i8;
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                C0429t.m2003a(d, this.f1054c, i, i2, i3, i4, i5);
                if (iArr != null) {
                    this.f1054c.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i7;
                    iArr[1] = iArr[1] - i6;
                }
                return true;
            } else if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }
        return false;
    }

    public boolean m1830a(int i, int i2, int[] iArr, int[] iArr2) {
        return m1831a(i, i2, iArr, iArr2, 0);
    }

    public boolean m1831a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (!m1823a()) {
            return false;
        }
        ViewParent d = m1821d(i3);
        if (d == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i4;
            int i5;
            int[] iArr3;
            if (iArr2 != null) {
                this.f1054c.getLocationInWindow(iArr2);
                int i6 = iArr2[0];
                i4 = iArr2[1];
                i5 = i6;
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                if (this.f1056e == null) {
                    this.f1056e = new int[2];
                }
                iArr3 = this.f1056e;
            } else {
                iArr3 = iArr;
            }
            iArr3[0] = 0;
            iArr3[1] = 0;
            C0429t.m2004a(d, this.f1054c, i, i2, iArr3, i3);
            if (iArr2 != null) {
                this.f1054c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            boolean z = (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
            return z;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m1832b() {
        return m1826a(0);
    }

    public boolean m1833b(int i) {
        return m1827a(i, 0);
    }

    public void m1834c() {
        m1835c(0);
    }

    public void m1835c(int i) {
        ViewParent d = m1821d(i);
        if (d != null) {
            C0429t.m2002a(d, this.f1054c, i);
            m1820a(i, null);
        }
    }
}
