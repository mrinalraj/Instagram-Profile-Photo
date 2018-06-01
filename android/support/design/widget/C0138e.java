package android.support.design.widget;

import android.support.v4.p018g.C0331l;
import android.support.v4.p018g.C0349j.C0346a;
import android.support.v4.p018g.C0349j.C0347b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class C0138e<T> {
    private final C0346a<ArrayList<T>> f430a = new C0347b(10);
    private final C0331l<T, ArrayList<T>> f431b = new C0331l();
    private final ArrayList<T> f432c = new ArrayList();
    private final HashSet<T> f433d = new HashSet();

    C0138e() {
    }

    private void m663a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.f431b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m663a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    private void m664a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f430a.mo224a(arrayList);
    }

    private ArrayList<T> m665c() {
        ArrayList<T> arrayList = (ArrayList) this.f430a.mo223a();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    void m666a() {
        int size = this.f431b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f431b.m1607c(i);
            if (arrayList != null) {
                m664a(arrayList);
            }
        }
        this.f431b.clear();
    }

    void m667a(T t) {
        if (!this.f431b.containsKey(t)) {
            this.f431b.put(t, null);
        }
    }

    void m668a(T t, T t2) {
        if (this.f431b.containsKey(t) && this.f431b.containsKey(t2)) {
            ArrayList arrayList = (ArrayList) this.f431b.get(t);
            if (arrayList == null) {
                arrayList = m665c();
                this.f431b.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    ArrayList<T> m669b() {
        this.f432c.clear();
        this.f433d.clear();
        int size = this.f431b.size();
        for (int i = 0; i < size; i++) {
            m663a(this.f431b.m1606b(i), this.f432c, this.f433d);
        }
        return this.f432c;
    }

    boolean m670b(T t) {
        return this.f431b.containsKey(t);
    }

    List m671c(T t) {
        return (List) this.f431b.get(t);
    }

    List m672d(T t) {
        List list = null;
        int size = this.f431b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f431b.m1607c(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    List list2 = list;
                }
                arrayList.add(this.f431b.m1606b(i));
                list = arrayList;
            }
        }
        return list;
    }

    boolean m673e(T t) {
        int size = this.f431b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f431b.m1607c(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
