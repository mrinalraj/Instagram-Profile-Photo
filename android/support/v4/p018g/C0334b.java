package android.support.v4.p018g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class C0334b<E> implements Collection<E>, Set<E> {
    static Object[] f969a;
    static int f970b;
    static Object[] f971c;
    static int f972d;
    private static final int[] f973j = new int[0];
    private static final Object[] f974k = new Object[0];
    final boolean f975e;
    int[] f976f;
    Object[] f977g;
    int f978h;
    C0329h<E, E> f979i;

    class C03331 extends C0329h<E, E> {
        final /* synthetic */ C0334b f968a;

        C03331(C0334b c0334b) {
            this.f968a = c0334b;
        }

        protected int mo214a() {
            return this.f968a.f978h;
        }

        protected int mo215a(Object obj) {
            return this.f968a.m1625a(obj);
        }

        protected Object mo216a(int i, int i2) {
            return this.f968a.f977g[i];
        }

        protected E mo217a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        protected void mo218a(int i) {
            this.f968a.m1628c(i);
        }

        protected void mo219a(E e, E e2) {
            this.f968a.add(e);
        }

        protected int mo220b(Object obj) {
            return this.f968a.m1625a(obj);
        }

        protected Map<E, E> mo221b() {
            throw new UnsupportedOperationException("not a map");
        }

        protected void mo222c() {
            this.f968a.clear();
        }
    }

    public C0334b() {
        this(0, false);
    }

    public C0334b(int i, boolean z) {
        this.f975e = z;
        if (i == 0) {
            this.f976f = f973j;
            this.f977g = f974k;
        } else {
            m1624d(i);
        }
        this.f978h = 0;
    }

    private int m1620a() {
        int i = this.f978h;
        if (i == 0) {
            return -1;
        }
        int a = C0335c.m1630a(this.f976f, i, 0);
        if (a < 0 || this.f977g[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f976f[i2] == 0) {
            if (this.f977g[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f976f[a] == 0) {
            if (this.f977g[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private int m1621a(Object obj, int i) {
        int i2 = this.f978h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0335c.m1630a(this.f976f, i2, i);
        if (a < 0 || obj.equals(this.f977g[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f976f[i3] == i) {
            if (obj.equals(this.f977g[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f976f[a] == i) {
            if (obj.equals(this.f977g[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private static void m1622a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0334b.class) {
                if (f972d < 10) {
                    objArr[0] = f971c;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f971c = objArr;
                    f972d++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0334b.class) {
                if (f970b < 10) {
                    objArr[0] = f969a;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f969a = objArr;
                    f970b++;
                }
            }
        }
    }

    private C0329h<E, E> m1623b() {
        if (this.f979i == null) {
            this.f979i = new C03331(this);
        }
        return this.f979i;
    }

    private void m1624d(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0334b.class) {
                if (f971c != null) {
                    objArr = f971c;
                    this.f977g = objArr;
                    f971c = (Object[]) objArr[0];
                    this.f976f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f972d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0334b.class) {
                if (f969a != null) {
                    objArr = f969a;
                    this.f977g = objArr;
                    f969a = (Object[]) objArr[0];
                    this.f976f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f970b--;
                    return;
                }
            }
        }
        this.f976f = new int[i];
        this.f977g = new Object[i];
    }

    public int m1625a(Object obj) {
        if (obj == null) {
            return m1620a();
        }
        return m1621a(obj, this.f975e ? System.identityHashCode(obj) : obj.hashCode());
    }

    public void m1626a(int i) {
        if (this.f976f.length < i) {
            Object obj = this.f976f;
            Object obj2 = this.f977g;
            m1624d(i);
            if (this.f978h > 0) {
                System.arraycopy(obj, 0, this.f976f, 0, this.f978h);
                System.arraycopy(obj2, 0, this.f977g, 0, this.f978h);
            }
            C0334b.m1622a(obj, obj2, this.f978h);
        }
    }

    public boolean add(E e) {
        int a;
        int i;
        if (e == null) {
            a = m1620a();
            i = 0;
        } else {
            a = this.f975e ? System.identityHashCode(e) : e.hashCode();
            i = a;
            a = m1621a(e, a);
        }
        if (a >= 0) {
            return false;
        }
        int i2 = a ^ -1;
        if (this.f978h >= this.f976f.length) {
            a = this.f978h >= 8 ? this.f978h + (this.f978h >> 1) : this.f978h >= 4 ? 8 : 4;
            Object obj = this.f976f;
            Object obj2 = this.f977g;
            m1624d(a);
            if (this.f976f.length > 0) {
                System.arraycopy(obj, 0, this.f976f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f977g, 0, obj2.length);
            }
            C0334b.m1622a(obj, obj2, this.f978h);
        }
        if (i2 < this.f978h) {
            System.arraycopy(this.f976f, i2, this.f976f, i2 + 1, this.f978h - i2);
            System.arraycopy(this.f977g, i2, this.f977g, i2 + 1, this.f978h - i2);
        }
        this.f976f[i2] = i;
        this.f977g[i2] = e;
        this.f978h++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        m1626a(this.f978h + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public E m1627b(int i) {
        return this.f977g[i];
    }

    public E m1628c(int i) {
        int i2 = 8;
        E e = this.f977g[i];
        if (this.f978h <= 1) {
            C0334b.m1622a(this.f976f, this.f977g, this.f978h);
            this.f976f = f973j;
            this.f977g = f974k;
            this.f978h = 0;
        } else if (this.f976f.length <= 8 || this.f978h >= this.f976f.length / 3) {
            this.f978h--;
            if (i < this.f978h) {
                System.arraycopy(this.f976f, i + 1, this.f976f, i, this.f978h - i);
                System.arraycopy(this.f977g, i + 1, this.f977g, i, this.f978h - i);
            }
            this.f977g[this.f978h] = null;
        } else {
            if (this.f978h > 8) {
                i2 = this.f978h + (this.f978h >> 1);
            }
            Object obj = this.f976f;
            Object obj2 = this.f977g;
            m1624d(i2);
            this.f978h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f976f, 0, i);
                System.arraycopy(obj2, 0, this.f977g, 0, i);
            }
            if (i < this.f978h) {
                System.arraycopy(obj, i + 1, this.f976f, i, this.f978h - i);
                System.arraycopy(obj2, i + 1, this.f977g, i, this.f978h - i);
            }
        }
        return e;
    }

    public void clear() {
        if (this.f978h != 0) {
            C0334b.m1622a(this.f976f, this.f977g, this.f978h);
            this.f976f = f973j;
            this.f977g = f974k;
            this.f978h = 0;
        }
    }

    public boolean contains(Object obj) {
        return m1625a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f978h) {
            try {
                if (!set.contains(m1627b(i))) {
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
    }

    public int hashCode() {
        int i = 0;
        int[] iArr = this.f976f;
        int i2 = 0;
        while (i < this.f978h) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public boolean isEmpty() {
        return this.f978h <= 0;
    }

    public Iterator<E> iterator() {
        return m1623b().m1586e().iterator();
    }

    public boolean remove(Object obj) {
        int a = m1625a(obj);
        if (a < 0) {
            return false;
        }
        m1628c(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f978h - 1; i >= 0; i--) {
            if (!collection.contains(this.f977g[i])) {
                m1628c(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f978h;
    }

    public Object[] toArray() {
        Object obj = new Object[this.f978h];
        System.arraycopy(this.f977g, 0, obj, 0, this.f978h);
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        Object obj = tArr.length < this.f978h ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f978h) : tArr;
        System.arraycopy(this.f977g, 0, obj, 0, this.f978h);
        if (obj.length > this.f978h) {
            obj[this.f978h] = null;
        }
        return obj;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f978h * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.f978h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0334b b = m1627b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
