package android.support.v4.p018g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C0332a<K, V> extends C0331l<K, V> implements Map<K, V> {
    C0329h<K, V> f967a;

    class C03301 extends C0329h<K, V> {
        final /* synthetic */ C0332a f959a;

        C03301(C0332a c0332a) {
            this.f959a = c0332a;
        }

        protected int mo214a() {
            return this.f959a.h;
        }

        protected int mo215a(Object obj) {
            return this.f959a.m1601a(obj);
        }

        protected Object mo216a(int i, int i2) {
            return this.f959a.g[(i << 1) + i2];
        }

        protected V mo217a(int i, V v) {
            return this.f959a.m1603a(i, (Object) v);
        }

        protected void mo218a(int i) {
            this.f959a.m1608d(i);
        }

        protected void mo219a(K k, V v) {
            this.f959a.put(k, v);
        }

        protected int mo220b(Object obj) {
            return this.f959a.m1605b(obj);
        }

        protected Map<K, V> mo221b() {
            return this.f959a;
        }

        protected void mo222c() {
            this.f959a.clear();
        }
    }

    public C0332a(int i) {
        super(i);
    }

    private C0329h<K, V> m1609b() {
        if (this.f967a == null) {
            this.f967a = new C03301(this);
        }
        return this.f967a;
    }

    public boolean m1610a(Collection<?> collection) {
        return C0329h.m1573c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1609b().m1585d();
    }

    public Set<K> keySet() {
        return m1609b().m1586e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1604a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return m1609b().m1587f();
    }
}
