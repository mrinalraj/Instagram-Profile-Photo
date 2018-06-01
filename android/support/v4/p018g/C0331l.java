package android.support.v4.p018g;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class C0331l<K, V> {
    static Object[] f960b;
    static int f961c;
    static Object[] f962d;
    static int f963e;
    int[] f964f;
    Object[] f965g;
    int f966h;

    public C0331l() {
        this.f964f = C0335c.f980a;
        this.f965g = C0335c.f982c;
        this.f966h = 0;
    }

    public C0331l(int i) {
        if (i == 0) {
            this.f964f = C0335c.f980a;
            this.f965g = C0335c.f982c;
        } else {
            m1599e(i);
        }
        this.f966h = 0;
    }

    private static int m1597a(int[] iArr, int i, int i2) {
        try {
            return C0335c.m1630a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    private static void m1598a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0332a.class) {
                if (f963e < 10) {
                    objArr[0] = f962d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f962d = objArr;
                    f963e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0332a.class) {
                if (f961c < 10) {
                    objArr[0] = f960b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f960b = objArr;
                    f961c++;
                }
            }
        }
    }

    private void m1599e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0332a.class) {
                if (f962d != null) {
                    objArr = f962d;
                    this.f965g = objArr;
                    f962d = (Object[]) objArr[0];
                    this.f964f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f963e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0332a.class) {
                if (f960b != null) {
                    objArr = f960b;
                    this.f965g = objArr;
                    f960b = (Object[]) objArr[0];
                    this.f964f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f961c--;
                    return;
                }
            }
        }
        this.f964f = new int[i];
        this.f965g = new Object[(i << 1)];
    }

    int m1600a() {
        int i = this.f966h;
        if (i == 0) {
            return -1;
        }
        int a = C0331l.m1597a(this.f964f, i, 0);
        if (a < 0 || this.f965g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f964f[i2] == 0) {
            if (this.f965g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f964f[a] == 0) {
            if (this.f965g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    public int m1601a(Object obj) {
        return obj == null ? m1600a() : m1602a(obj, obj.hashCode());
    }

    int m1602a(Object obj, int i) {
        int i2 = this.f966h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0331l.m1597a(this.f964f, i2, i);
        if (a < 0 || obj.equals(this.f965g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f964f[i3] == i) {
            if (obj.equals(this.f965g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f964f[a] == i) {
            if (obj.equals(this.f965g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public V m1603a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f965g[i2];
        this.f965g[i2] = v;
        return v2;
    }

    public void m1604a(int i) {
        int i2 = this.f966h;
        if (this.f964f.length < i) {
            int[] iArr = this.f964f;
            Object[] objArr = this.f965g;
            m1599e(i);
            if (this.f966h > 0) {
                System.arraycopy(iArr, 0, this.f964f, 0, i2);
                System.arraycopy(objArr, 0, this.f965g, 0, i2 << 1);
            }
            C0331l.m1598a(iArr, objArr, i2);
        }
        if (this.f966h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    int m1605b(Object obj) {
        int i = 1;
        int i2 = this.f966h * 2;
        Object[] objArr = this.f965g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public K m1606b(int i) {
        return this.f965g[i << 1];
    }

    public V m1607c(int i) {
        return this.f965g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f966h > 0) {
            int[] iArr = this.f964f;
            Object[] objArr = this.f965g;
            int i = this.f966h;
            this.f964f = C0335c.f980a;
            this.f965g = C0335c.f982c;
            this.f966h = 0;
            C0331l.m1598a(iArr, objArr, i);
        }
        if (this.f966h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m1601a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m1605b(obj) >= 0;
    }

    public V m1608d(int i) {
        int i2 = 8;
        V v = this.f965g[(i << 1) + 1];
        int i3 = this.f966h;
        if (i3 <= 1) {
            C0331l.m1598a(this.f964f, this.f965g, i3);
            this.f964f = C0335c.f980a;
            this.f965g = C0335c.f982c;
            i2 = 0;
        } else {
            int i4 = i3 - 1;
            if (this.f964f.length <= 8 || this.f966h >= this.f964f.length / 3) {
                if (i < i4) {
                    System.arraycopy(this.f964f, i + 1, this.f964f, i, i4 - i);
                    System.arraycopy(this.f965g, (i + 1) << 1, this.f965g, i << 1, (i4 - i) << 1);
                }
                this.f965g[i4 << 1] = null;
                this.f965g[(i4 << 1) + 1] = null;
                i2 = i4;
            } else {
                if (i3 > 8) {
                    i2 = (i3 >> 1) + i3;
                }
                Object obj = this.f964f;
                Object obj2 = this.f965g;
                m1599e(i2);
                if (i3 != this.f966h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f964f, 0, i);
                    System.arraycopy(obj2, 0, this.f965g, 0, i << 1);
                }
                if (i < i4) {
                    System.arraycopy(obj, i + 1, this.f964f, i, i4 - i);
                    System.arraycopy(obj2, (i + 1) << 1, this.f965g, i << 1, (i4 - i) << 1);
                }
                i2 = i4;
            }
        }
        if (i3 != this.f966h) {
            throw new ConcurrentModificationException();
        }
        this.f966h = i2;
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof C0331l) {
            C0331l c0331l = (C0331l) obj;
            if (size() != c0331l.size()) {
                return false;
            }
            i = 0;
            while (i < this.f966h) {
                try {
                    b = m1606b(i);
                    c = m1607c(i);
                    obj2 = c0331l.get(b);
                    if (c == null) {
                        if (obj2 != null || !c0331l.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.f966h) {
                try {
                    b = m1606b(i);
                    c = m1607c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public V get(Object obj) {
        int a = m1601a(obj);
        return a >= 0 ? this.f965g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f964f;
        Object[] objArr = this.f965g;
        int i = this.f966h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f966h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        int i3 = this.f966h;
        if (k == null) {
            a = m1600a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m1602a((Object) k, i);
        }
        if (a >= 0) {
            int i4 = (a << 1) + 1;
            V v2 = this.f965g[i4];
            this.f965g[i4] = v;
            return v2;
        }
        a ^= -1;
        if (i3 >= this.f964f.length) {
            if (i3 >= 8) {
                i2 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i2 = 4;
            }
            int[] iArr = this.f964f;
            Object[] objArr = this.f965g;
            m1599e(i2);
            if (i3 != this.f966h) {
                throw new ConcurrentModificationException();
            }
            if (this.f964f.length > 0) {
                System.arraycopy(iArr, 0, this.f964f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f965g, 0, objArr.length);
            }
            C0331l.m1598a(iArr, objArr, i3);
        }
        if (a < i3) {
            System.arraycopy(this.f964f, a, this.f964f, a + 1, i3 - a);
            System.arraycopy(this.f965g, a << 1, this.f965g, (a + 1) << 1, (this.f966h - a) << 1);
        }
        if (i3 != this.f966h || a >= this.f964f.length) {
            throw new ConcurrentModificationException();
        }
        this.f964f[a] = i;
        this.f965g[a << 1] = k;
        this.f965g[(a << 1) + 1] = v;
        this.f966h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m1601a(obj);
        return a >= 0 ? m1608d(a) : null;
    }

    public int size() {
        return this.f966h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f966h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f966h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0331l b = m1606b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1607c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
