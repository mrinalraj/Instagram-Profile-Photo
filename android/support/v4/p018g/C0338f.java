package android.support.v4.p018g;

public class C0338f<E> implements Cloneable {
    private static final Object f985a = new Object();
    private boolean f986b;
    private long[] f987c;
    private Object[] f988d;
    private int f989e;

    public C0338f() {
        this(10);
    }

    public C0338f(int i) {
        this.f986b = false;
        if (i == 0) {
            this.f987c = C0335c.f981b;
            this.f988d = C0335c.f982c;
        } else {
            int b = C0335c.m1633b(i);
            this.f987c = new long[b];
            this.f988d = new Object[b];
        }
        this.f989e = 0;
    }

    private void m1637d() {
        int i = this.f989e;
        long[] jArr = this.f987c;
        Object[] objArr = this.f988d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f985a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f986b = false;
        this.f989e = i2;
    }

    public C0338f<E> m1638a() {
        try {
            C0338f<E> c0338f = (C0338f) super.clone();
            try {
                c0338f.f987c = (long[]) this.f987c.clone();
                c0338f.f988d = (Object[]) this.f988d.clone();
                return c0338f;
            } catch (CloneNotSupportedException e) {
                return c0338f;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1639a(long j) {
        return m1640a(j, null);
    }

    public E m1640a(long j, E e) {
        int a = C0335c.m1631a(this.f987c, this.f989e, j);
        return (a < 0 || this.f988d[a] == f985a) ? e : this.f988d[a];
    }

    public void m1641a(int i) {
        if (this.f988d[i] != f985a) {
            this.f988d[i] = f985a;
            this.f986b = true;
        }
    }

    public int m1642b() {
        if (this.f986b) {
            m1637d();
        }
        return this.f989e;
    }

    public long m1643b(int i) {
        if (this.f986b) {
            m1637d();
        }
        return this.f987c[i];
    }

    public void m1644b(long j) {
        int a = C0335c.m1631a(this.f987c, this.f989e, j);
        if (a >= 0 && this.f988d[a] != f985a) {
            this.f988d[a] = f985a;
            this.f986b = true;
        }
    }

    public void m1645b(long j, E e) {
        int a = C0335c.m1631a(this.f987c, this.f989e, j);
        if (a >= 0) {
            this.f988d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f989e || this.f988d[a] != f985a) {
            if (this.f986b && this.f989e >= this.f987c.length) {
                m1637d();
                a = C0335c.m1631a(this.f987c, this.f989e, j) ^ -1;
            }
            if (this.f989e >= this.f987c.length) {
                int b = C0335c.m1633b(this.f989e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f987c, 0, obj, 0, this.f987c.length);
                System.arraycopy(this.f988d, 0, obj2, 0, this.f988d.length);
                this.f987c = obj;
                this.f988d = obj2;
            }
            if (this.f989e - a != 0) {
                System.arraycopy(this.f987c, a, this.f987c, a + 1, this.f989e - a);
                System.arraycopy(this.f988d, a, this.f988d, a + 1, this.f989e - a);
            }
            this.f987c[a] = j;
            this.f988d[a] = e;
            this.f989e++;
            return;
        }
        this.f987c[a] = j;
        this.f988d[a] = e;
    }

    public E m1646c(int i) {
        if (this.f986b) {
            m1637d();
        }
        return this.f988d[i];
    }

    public void m1647c() {
        int i = this.f989e;
        Object[] objArr = this.f988d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f989e = 0;
        this.f986b = false;
    }

    public /* synthetic */ Object clone() {
        return m1638a();
    }

    public String toString() {
        if (m1642b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f989e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f989e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1643b(i));
            stringBuilder.append('=');
            C0338f c = m1646c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
