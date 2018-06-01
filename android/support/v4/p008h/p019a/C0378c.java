package android.support.v4.p008h.p019a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p008h.p019a.C0380d.C0371a;
import android.support.v4.p008h.p019a.C0382e.C0375a;
import java.util.ArrayList;
import java.util.List;

public class C0378c {
    private static final C0370a f1030a;
    private final Object f1031b;

    interface C0370a {
        Object mo235a(C0378c c0378c);
    }

    static class C0373d implements C0370a {
        C0373d() {
        }

        public Object mo235a(C0378c c0378c) {
            return null;
        }
    }

    private static class C0374b extends C0373d {
        C0374b() {
        }

        public Object mo235a(final C0378c c0378c) {
            return C0380d.m1753a(new C0371a(this) {
                final /* synthetic */ C0374b f1027b;

                public Object mo232a(int i) {
                    C0369b a = c0378c.m1748a(i);
                    return a == null ? null : a.m1704a();
                }

                public List<Object> mo233a(String str, int i) {
                    List a = c0378c.m1750a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0369b) a.get(i2)).m1704a());
                    }
                    return arrayList;
                }

                public boolean mo234a(int i, int i2, Bundle bundle) {
                    return c0378c.m1751a(i, i2, bundle);
                }
            });
        }
    }

    private static class C0377c extends C0373d {
        C0377c() {
        }

        public Object mo235a(final C0378c c0378c) {
            return C0382e.m1754a(new C0375a(this) {
                final /* synthetic */ C0377c f1029b;

                public Object mo236a(int i) {
                    C0369b a = c0378c.m1748a(i);
                    return a == null ? null : a.m1704a();
                }

                public List<Object> mo237a(String str, int i) {
                    List a = c0378c.m1750a(str, i);
                    if (a == null) {
                        return null;
                    }
                    List<Object> arrayList = new ArrayList();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((C0369b) a.get(i2)).m1704a());
                    }
                    return arrayList;
                }

                public boolean mo238a(int i, int i2, Bundle bundle) {
                    return c0378c.m1751a(i, i2, bundle);
                }

                public Object mo239b(int i) {
                    C0369b b = c0378c.m1752b(i);
                    return b == null ? null : b.m1704a();
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1030a = new C0377c();
        } else if (VERSION.SDK_INT >= 16) {
            f1030a = new C0374b();
        } else {
            f1030a = new C0373d();
        }
    }

    public C0378c() {
        this.f1031b = f1030a.mo235a(this);
    }

    public C0378c(Object obj) {
        this.f1031b = obj;
    }

    public C0369b m1748a(int i) {
        return null;
    }

    public Object m1749a() {
        return this.f1031b;
    }

    public List<C0369b> m1750a(String str, int i) {
        return null;
    }

    public boolean m1751a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0369b m1752b(int i) {
        return null;
    }
}
