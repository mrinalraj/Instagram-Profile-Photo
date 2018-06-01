package android.support.v4.p018g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class C0329h<K, V> {
    C0341b f956b;
    C0342c f957c;
    C0344e f958d;

    final class C0340a<T> implements Iterator<T> {
        final int f998a;
        int f999b;
        int f1000c;
        boolean f1001d = false;
        final /* synthetic */ C0329h f1002e;

        C0340a(C0329h c0329h, int i) {
            this.f1002e = c0329h;
            this.f998a = i;
            this.f999b = c0329h.mo214a();
        }

        public boolean hasNext() {
            return this.f1000c < this.f999b;
        }

        public T next() {
            if (hasNext()) {
                T a = this.f1002e.mo216a(this.f1000c, this.f998a);
                this.f1000c++;
                this.f1001d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1001d) {
                this.f1000c--;
                this.f999b--;
                this.f1001d = false;
                this.f1002e.mo218a(this.f1000c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class C0341b implements Set<Entry<K, V>> {
        final /* synthetic */ C0329h f1003a;

        C0341b(C0329h c0329h) {
            this.f1003a = c0329h;
        }

        public boolean m1655a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ boolean add(Object obj) {
            return m1655a((Entry) obj);
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f1003a.mo214a();
            for (Entry entry : collection) {
                this.f1003a.mo219a(entry.getKey(), entry.getValue());
            }
            return a != this.f1003a.mo214a();
        }

        public void clear() {
            this.f1003a.mo222c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f1003a.mo215a(entry.getKey());
            return a >= 0 ? C0335c.m1632a(this.f1003a.mo216a(a, 1), entry.getValue()) : false;
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
            return C0329h.m1571a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f1003a.mo214a() - 1;
            int i = 0;
            while (a >= 0) {
                Object a2 = this.f1003a.mo216a(a, 0);
                Object a3 = this.f1003a.mo216a(a, 1);
                a--;
                i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f1003a.mo214a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0343d(this.f1003a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f1003a.mo214a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class C0342c implements Set<K> {
        final /* synthetic */ C0329h f1004a;

        C0342c(C0329h c0329h) {
            this.f1004a = c0329h;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1004a.mo222c();
        }

        public boolean contains(Object obj) {
            return this.f1004a.mo215a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0329h.m1570a(this.f1004a.mo221b(), (Collection) collection);
        }

        public boolean equals(Object obj) {
            return C0329h.m1571a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f1004a.mo214a() - 1; a >= 0; a--) {
                Object a2 = this.f1004a.mo216a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return this.f1004a.mo214a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0340a(this.f1004a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f1004a.mo215a(obj);
            if (a < 0) {
                return false;
            }
            this.f1004a.mo218a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0329h.m1572b(this.f1004a.mo221b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0329h.m1573c(this.f1004a.mo221b(), collection);
        }

        public int size() {
            return this.f1004a.mo214a();
        }

        public Object[] toArray() {
            return this.f1004a.m1583b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1004a.m1580a((Object[]) tArr, 0);
        }
    }

    final class C0343d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int f1005a;
        int f1006b;
        boolean f1007c = false;
        final /* synthetic */ C0329h f1008d;

        C0343d(C0329h c0329h) {
            this.f1008d = c0329h;
            this.f1005a = c0329h.mo214a() - 1;
            this.f1006b = -1;
        }

        public Entry<K, V> m1656a() {
            if (hasNext()) {
                this.f1006b++;
                this.f1007c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f1007c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0335c.m1632a(entry.getKey(), this.f1008d.mo216a(this.f1006b, 0)) && C0335c.m1632a(entry.getValue(), this.f1008d.mo216a(this.f1006b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.f1007c) {
                return this.f1008d.mo216a(this.f1006b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1007c) {
                return this.f1008d.mo216a(this.f1006b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f1006b < this.f1005a;
        }

        public final int hashCode() {
            int i = 0;
            if (this.f1007c) {
                Object a = this.f1008d.mo216a(this.f1006b, 0);
                Object a2 = this.f1008d.mo216a(this.f1006b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public /* synthetic */ Object next() {
            return m1656a();
        }

        public void remove() {
            if (this.f1007c) {
                this.f1008d.mo218a(this.f1006b);
                this.f1006b--;
                this.f1005a--;
                this.f1007c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f1007c) {
                return this.f1008d.mo217a(this.f1006b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class C0344e implements Collection<V> {
        final /* synthetic */ C0329h f1009a;

        C0344e(C0329h c0329h) {
            this.f1009a = c0329h;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f1009a.mo222c();
        }

        public boolean contains(Object obj) {
            return this.f1009a.mo220b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f1009a.mo214a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0340a(this.f1009a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f1009a.mo220b(obj);
            if (b < 0) {
                return false;
            }
            this.f1009a.mo218a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a = this.f1009a.mo214a();
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f1009a.mo216a(i, 1))) {
                    this.f1009a.mo218a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a = this.f1009a.mo214a();
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f1009a.mo216a(i, 1))) {
                    this.f1009a.mo218a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f1009a.mo214a();
        }

        public Object[] toArray() {
            return this.f1009a.m1583b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f1009a.m1580a((Object[]) tArr, 1);
        }
    }

    C0329h() {
    }

    public static <K, V> boolean m1570a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean m1571a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean m1572b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m1573c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int mo214a();

    protected abstract int mo215a(Object obj);

    protected abstract Object mo216a(int i, int i2);

    protected abstract V mo217a(int i, V v);

    protected abstract void mo218a(int i);

    protected abstract void mo219a(K k, V v);

    public <T> T[] m1580a(T[] tArr, int i) {
        int a = mo214a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo216a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int mo220b(Object obj);

    protected abstract Map<K, V> mo221b();

    public Object[] m1583b(int i) {
        int a = mo214a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo216a(i2, i);
        }
        return objArr;
    }

    protected abstract void mo222c();

    public Set<Entry<K, V>> m1585d() {
        if (this.f956b == null) {
            this.f956b = new C0341b(this);
        }
        return this.f956b;
    }

    public Set<K> m1586e() {
        if (this.f957c == null) {
            this.f957c = new C0342c(this);
        }
        return this.f957c;
    }

    public Collection<V> m1587f() {
        if (this.f958d == null) {
            this.f958d = new C0344e(this);
        }
        return this.f958d;
    }
}
