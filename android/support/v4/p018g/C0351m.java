package android.support.v4.p018g;

public class C0351m<E> implements Cloneable {
    private static final Object f1015a = new Object();
    private boolean f1016b;
    private int[] f1017c;
    private Object[] f1018d;
    private int f1019e;

    public C0351m() {
        this(10);
    }

    public C0351m(int i) {
        this.f1016b = false;
        if (i == 0) {
            this.f1017c = C0335c.f980a;
            this.f1018d = C0335c.f982c;
        } else {
            int a = C0335c.m1629a(i);
            this.f1017c = new int[a];
            this.f1018d = new Object[a];
        }
        this.f1019e = 0;
    }

    private void m1666d() {
        int i = this.f1019e;
        int[] iArr = this.f1017c;
        Object[] objArr = this.f1018d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1015a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1016b = false;
        this.f1019e = i2;
    }

    public C0351m<E> m1667a() {
        try {
            C0351m<E> c0351m = (C0351m) super.clone();
            try {
                c0351m.f1017c = (int[]) this.f1017c.clone();
                c0351m.f1018d = (Object[]) this.f1018d.clone();
                return c0351m;
            } catch (CloneNotSupportedException e) {
                return c0351m;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1668a(int i) {
        return m1669a(i, null);
    }

    public E m1669a(int i, E e) {
        int a = C0335c.m1630a(this.f1017c, this.f1019e, i);
        return (a < 0 || this.f1018d[a] == f1015a) ? e : this.f1018d[a];
    }

    public int m1670b() {
        if (this.f1016b) {
            m1666d();
        }
        return this.f1019e;
    }

    public void m1671b(int i) {
        int a = C0335c.m1630a(this.f1017c, this.f1019e, i);
        if (a >= 0 && this.f1018d[a] != f1015a) {
            this.f1018d[a] = f1015a;
            this.f1016b = true;
        }
    }

    public void m1672b(int i, E e) {
        int a = C0335c.m1630a(this.f1017c, this.f1019e, i);
        if (a >= 0) {
            this.f1018d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f1019e || this.f1018d[a] != f1015a) {
            if (this.f1016b && this.f1019e >= this.f1017c.length) {
                m1666d();
                a = C0335c.m1630a(this.f1017c, this.f1019e, i) ^ -1;
            }
            if (this.f1019e >= this.f1017c.length) {
                int a2 = C0335c.m1629a(this.f1019e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f1017c, 0, obj, 0, this.f1017c.length);
                System.arraycopy(this.f1018d, 0, obj2, 0, this.f1018d.length);
                this.f1017c = obj;
                this.f1018d = obj2;
            }
            if (this.f1019e - a != 0) {
                System.arraycopy(this.f1017c, a, this.f1017c, a + 1, this.f1019e - a);
                System.arraycopy(this.f1018d, a, this.f1018d, a + 1, this.f1019e - a);
            }
            this.f1017c[a] = i;
            this.f1018d[a] = e;
            this.f1019e++;
            return;
        }
        this.f1017c[a] = i;
        this.f1018d[a] = e;
    }

    public void m1673c() {
        int i = this.f1019e;
        Object[] objArr = this.f1018d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1019e = 0;
        this.f1016b = false;
    }

    public void m1674c(int i) {
        m1671b(i);
    }

    public void m1675c(int i, E e) {
        if (this.f1019e == 0 || i > this.f1017c[this.f1019e - 1]) {
            if (this.f1016b && this.f1019e >= this.f1017c.length) {
                m1666d();
            }
            int i2 = this.f1019e;
            if (i2 >= this.f1017c.length) {
                int a = C0335c.m1629a(i2 + 1);
                Object obj = new int[a];
                Object obj2 = new Object[a];
                System.arraycopy(this.f1017c, 0, obj, 0, this.f1017c.length);
                System.arraycopy(this.f1018d, 0, obj2, 0, this.f1018d.length);
                this.f1017c = obj;
                this.f1018d = obj2;
            }
            this.f1017c[i2] = i;
            this.f1018d[i2] = e;
            this.f1019e = i2 + 1;
            return;
        }
        m1672b(i, e);
    }

    public /* synthetic */ Object clone() {
        return m1667a();
    }

    public int m1676d(int i) {
        if (this.f1016b) {
            m1666d();
        }
        return this.f1017c[i];
    }

    public E m1677e(int i) {
        if (this.f1016b) {
            m1666d();
        }
        return this.f1018d[i];
    }

    public String toString() {
        if (m1670b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1019e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1019e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1676d(i));
            stringBuilder.append('=');
            C0351m e = m1677e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
