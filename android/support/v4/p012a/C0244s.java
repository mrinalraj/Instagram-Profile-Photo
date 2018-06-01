package android.support.v4.p012a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0425s;
import android.support.v4.p012a.C0199c.C0196a;
import android.support.v4.p018g.C0332a;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class C0244s {
    private static final int[] f799a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    static class C0243a {
        public C0212h f793a;
        public boolean f794b;
        public C0199c f795c;
        public C0212h f796d;
        public boolean f797e;
        public C0199c f798f;

        C0243a() {
        }
    }

    private static C0243a m1245a(C0243a c0243a, SparseArray<C0243a> sparseArray, int i) {
        if (c0243a != null) {
            return c0243a;
        }
        c0243a = new C0243a();
        sparseArray.put(i, c0243a);
        return c0243a;
    }

    private static C0332a<String, String> m1246a(int i, ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        C0332a<String, String> c0332a = new C0332a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0199c c0199c = (C0199c) arrayList.get(i4);
            if (c0199c.m894b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (c0199c.f578s != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = c0199c.f578s.size();
                    if (booleanValue) {
                        arrayList3 = c0199c.f578s;
                        arrayList4 = c0199c.f579t;
                    } else {
                        ArrayList arrayList5 = c0199c.f578s;
                        arrayList3 = c0199c.f579t;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) c0332a.remove(str2);
                        if (str3 != null) {
                            c0332a.put(str, str3);
                        } else {
                            c0332a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c0332a;
    }

    private static Object m1249a(C0212h c0212h, C0212h c0212h2, boolean z) {
        if (c0212h == null || c0212h2 == null) {
            return null;
        }
        return C0252t.m1297b(C0252t.m1276a(z ? c0212h2.m1021x() : c0212h.m1020w()));
    }

    private static Object m1250a(C0212h c0212h, boolean z) {
        if (c0212h == null) {
            return null;
        }
        return C0252t.m1276a(z ? c0212h.m1019v() : c0212h.m1016s());
    }

    private static Object m1251a(ViewGroup viewGroup, View view, C0332a<String, String> c0332a, C0243a c0243a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        View view2 = null;
        final C0212h c0212h = c0243a.f793a;
        final C0212h c0212h2 = c0243a.f796d;
        if (c0212h != null) {
            c0212h.m1001i().setVisibility(0);
        }
        if (c0212h == null || c0212h2 == null) {
            return null;
        }
        Object obj3;
        final boolean z = c0243a.f794b;
        Object a = c0332a.isEmpty() ? null : C0244s.m1249a(c0212h, c0212h2, z);
        C0332a b = C0244s.m1266b((C0332a) c0332a, a, c0243a);
        final C0332a c = C0244s.m1275c(c0332a, a, c0243a);
        if (c0332a.isEmpty()) {
            if (b != null) {
                b.clear();
            }
            if (c != null) {
                c.clear();
                obj3 = null;
            } else {
                obj3 = null;
            }
        } else {
            C0244s.m1265a((ArrayList) arrayList, b, c0332a.keySet());
            C0244s.m1265a((ArrayList) arrayList2, c, c0332a.values());
            obj3 = a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        C0244s.m1272b(c0212h, c0212h2, z, b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            C0252t.m1287a(obj3, view, (ArrayList) arrayList);
            C0244s.m1263a(obj3, obj2, b, c0243a.f797e, c0243a.f798f);
            rect = new Rect();
            view2 = C0244s.m1267b(c, c0243a, obj, z);
            if (view2 != null) {
                C0252t.m1285a(obj, rect);
            }
        } else {
            rect = null;
        }
        C0260x.m1332a(viewGroup, new Runnable() {
            public void run() {
                C0244s.m1272b(c0212h, c0212h2, z, c, false);
                if (view2 != null) {
                    C0252t.m1280a(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static Object m1252a(Object obj, Object obj2, Object obj3, C0212h c0212h, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || c0212h == null)) {
            z2 = z ? c0212h.m1023z() : c0212h.m1022y();
        }
        return z2 ? C0252t.m1277a(obj2, obj, obj3) : C0252t.m1298b(obj2, obj, obj3);
    }

    private static String m1253a(C0332a<String, String> c0332a, String str) {
        int size = c0332a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(c0332a.m1607c(i))) {
                return (String) c0332a.m1606b(i);
            }
        }
        return null;
    }

    private static void m1255a(C0199c c0199c, C0196a c0196a, SparseArray<C0243a> sparseArray, boolean z, boolean z2) {
        C0212h c0212h = c0196a.f555b;
        if (c0212h != null) {
            int i = c0212h.f664x;
            if (i != 0) {
                int i2;
                int i3;
                C0243a a;
                boolean z3;
                int i4;
                int i5;
                boolean z4;
                int i6;
                switch (z ? f799a[c0196a.f554a] : c0196a.f554a) {
                    case 1:
                    case 7:
                        z3 = z2 ? c0212h.f636P : (c0212h.f651k || c0212h.f666z) ? false : true;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        z4 = z3;
                        break;
                    case 3:
                    case 6:
                        i6 = z2 ? (c0212h.f651k || c0212h.f628H == null || c0212h.f628H.getVisibility() != 0 || c0212h.f638R < 0.0f) ? 0 : 1 : (!c0212h.f651k || c0212h.f666z) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i3 = 0;
                        break;
                    case 4:
                        i6 = z2 ? (c0212h.f637Q && c0212h.f651k && c0212h.f666z) ? 1 : 0 : (!c0212h.f651k || c0212h.f666z) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i3 = 0;
                        break;
                    case 5:
                        z3 = z2 ? c0212h.f637Q && !c0212h.f666z && c0212h.f651k : c0212h.f666z;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        z4 = z3;
                        break;
                    default:
                        i4 = 0;
                        i2 = 0;
                        i5 = 0;
                        i3 = 0;
                        break;
                }
                C0243a c0243a = (C0243a) sparseArray.get(i);
                if (i3 != 0) {
                    a = C0244s.m1245a(c0243a, (SparseArray) sparseArray, i);
                    a.f793a = c0212h;
                    a.f794b = z;
                    a.f795c = c0199c;
                } else {
                    a = c0243a;
                }
                if (!(z2 || r4 == 0)) {
                    if (a != null && a.f796d == c0212h) {
                        a.f796d = null;
                    }
                    C0233n c0233n = c0199c.f561b;
                    if (c0212h.f642b < 1 && c0233n.f735l >= 1 && !c0199c.f580u) {
                        c0233n.m1208f(c0212h);
                        c0233n.m1171a(c0212h, 1, 0, 0, false);
                    }
                }
                if (i2 == 0 || !(a == null || a.f796d == null)) {
                    c0243a = a;
                } else {
                    c0243a = C0244s.m1245a(a, (SparseArray) sparseArray, i);
                    c0243a.f796d = c0212h;
                    c0243a.f797e = z;
                    c0243a.f798f = c0199c;
                }
                if (!z2 && r7 != 0 && c0243a != null && c0243a.f793a == c0212h) {
                    c0243a.f793a = null;
                }
            }
        }
    }

    public static void m1256a(C0199c c0199c, SparseArray<C0243a> sparseArray, boolean z) {
        int size = c0199c.f562c.size();
        for (int i = 0; i < size; i++) {
            C0244s.m1255a(c0199c, (C0196a) c0199c.f562c.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    private static void m1258a(C0233n c0233n, int i, C0243a c0243a, View view, C0332a<String, String> c0332a) {
        ViewGroup viewGroup = null;
        if (c0233n.f737n.mo160a()) {
            viewGroup = (ViewGroup) c0233n.f737n.mo159a(i);
        }
        if (viewGroup != null) {
            C0212h c0212h = c0243a.f793a;
            C0212h c0212h2 = c0243a.f796d;
            boolean z = c0243a.f794b;
            boolean z2 = c0243a.f797e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object a = C0244s.m1250a(c0212h, z);
            Object b = C0244s.m1268b(c0212h2, z2);
            Object a2 = C0244s.m1251a(viewGroup, view, (C0332a) c0332a, c0243a, arrayList2, arrayList, a, b);
            if (a != null || a2 != null || b != null) {
                ArrayList b2 = C0244s.m1270b(b, c0212h2, arrayList2, view);
                ArrayList b3 = C0244s.m1270b(a, c0212h, arrayList, view);
                C0244s.m1274b(b3, 4);
                Object a3 = C0244s.m1252a(a, b, a2, c0212h, z);
                if (a3 != null) {
                    C0244s.m1262a(b, c0212h2, b2);
                    ArrayList a4 = C0252t.m1279a(arrayList);
                    C0252t.m1288a(a3, a, b3, b, b2, a2, arrayList);
                    C0252t.m1283a(viewGroup, a3);
                    C0252t.m1281a(viewGroup, arrayList2, arrayList, a4, c0332a);
                    C0244s.m1274b(b3, 0);
                    C0252t.m1290a(a2, arrayList2, arrayList);
                }
            }
        }
    }

    static void m1259a(C0233n c0233n, ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (c0233n.f735l >= 1 && VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C0199c c0199c = (C0199c) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    C0244s.m1271b(c0199c, sparseArray, z);
                } else {
                    C0244s.m1256a(c0199c, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(c0233n.f736m.m1039g());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    C0332a a = C0244s.m1246a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    C0243a c0243a = (C0243a) sparseArray.valueAt(i4);
                    if (z) {
                        C0244s.m1258a(c0233n, keyAt, c0243a, view, a);
                    } else {
                        C0244s.m1273b(c0233n, keyAt, c0243a, view, a);
                    }
                }
            }
        }
    }

    private static void m1260a(C0332a<String, String> c0332a, C0332a<String, View> c0332a2) {
        for (int size = c0332a.size() - 1; size >= 0; size--) {
            if (!c0332a2.containsKey((String) c0332a.m1607c(size))) {
                c0332a.m1608d(size);
            }
        }
    }

    private static void m1261a(ViewGroup viewGroup, C0212h c0212h, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final View view2 = view;
        final C0212h c0212h2 = c0212h;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        C0260x.m1332a(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    C0252t.m1303c(obj3, view2);
                    arrayList5.addAll(C0244s.m1270b(obj3, c0212h2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        C0252t.m1302b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void m1262a(Object obj, C0212h c0212h, final ArrayList<View> arrayList) {
        if (c0212h != null && obj != null && c0212h.f651k && c0212h.f666z && c0212h.f637Q) {
            c0212h.m996f(true);
            C0252t.m1301b(obj, c0212h.m1001i(), (ArrayList) arrayList);
            C0260x.m1332a(c0212h.f627G, new Runnable() {
                public void run() {
                    C0244s.m1274b(arrayList, 4);
                }
            });
        }
    }

    private static void m1263a(Object obj, Object obj2, C0332a<String, View> c0332a, boolean z, C0199c c0199c) {
        if (c0199c.f578s != null && !c0199c.f578s.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) c0199c.f579t.get(0);
            } else {
                String str = (String) c0199c.f578s.get(0);
            }
            View view = (View) c0332a.get(obj3);
            C0252t.m1286a(obj, view);
            if (obj2 != null) {
                C0252t.m1286a(obj2, view);
            }
        }
    }

    private static void m1265a(ArrayList<View> arrayList, C0332a<String, View> c0332a, Collection<String> collection) {
        for (int size = c0332a.size() - 1; size >= 0; size--) {
            View view = (View) c0332a.m1607c(size);
            if (collection.contains(C0425s.m1977p(view))) {
                arrayList.add(view);
            }
        }
    }

    private static C0332a<String, View> m1266b(C0332a<String, String> c0332a, Object obj, C0243a c0243a) {
        if (c0332a.isEmpty() || obj == null) {
            c0332a.clear();
            return null;
        }
        ArrayList arrayList;
        C0261y c0261y;
        C0212h c0212h = c0243a.f796d;
        Map c0332a2 = new C0332a();
        C0252t.m1293a(c0332a2, c0212h.m1001i());
        C0199c c0199c = c0243a.f798f;
        C0261y P;
        if (c0243a.f797e) {
            P = c0212h.m940P();
            arrayList = c0199c.f579t;
            c0261y = P;
        } else {
            P = c0212h.m941Q();
            arrayList = c0199c.f578s;
            c0261y = P;
        }
        c0332a2.m1610a(arrayList);
        if (c0261y != null) {
            c0261y.m1335a(arrayList, c0332a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) c0332a2.get(str);
                if (view == null) {
                    c0332a.remove(str);
                } else if (!str.equals(C0425s.m1977p(view))) {
                    c0332a.put(C0425s.m1977p(view), (String) c0332a.remove(str));
                }
            }
        } else {
            c0332a.m1610a(c0332a2.keySet());
        }
        return c0332a2;
    }

    private static View m1267b(C0332a<String, View> c0332a, C0243a c0243a, Object obj, boolean z) {
        C0199c c0199c = c0243a.f795c;
        if (obj == null || c0332a == null || c0199c.f578s == null || c0199c.f578s.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) c0199c.f578s.get(0);
        } else {
            String str = (String) c0199c.f579t.get(0);
        }
        return (View) c0332a.get(obj2);
    }

    private static Object m1268b(C0212h c0212h, boolean z) {
        if (c0212h == null) {
            return null;
        }
        return C0252t.m1276a(z ? c0212h.m1017t() : c0212h.m1018u());
    }

    private static Object m1269b(ViewGroup viewGroup, View view, C0332a<String, String> c0332a, C0243a c0243a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final C0212h c0212h = c0243a.f793a;
        final C0212h c0212h2 = c0243a.f796d;
        if (c0212h == null || c0212h2 == null) {
            return null;
        }
        Object obj3;
        final boolean z = c0243a.f794b;
        Object a = c0332a.isEmpty() ? null : C0244s.m1249a(c0212h, c0212h2, z);
        C0332a b = C0244s.m1266b((C0332a) c0332a, a, c0243a);
        if (c0332a.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b.values());
            obj3 = a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        Rect rect;
        C0244s.m1272b(c0212h, c0212h2, z, b, true);
        if (obj3 != null) {
            rect = new Rect();
            C0252t.m1287a(obj3, view, (ArrayList) arrayList);
            C0244s.m1263a(obj3, obj2, b, c0243a.f797e, c0243a.f798f);
            if (obj != null) {
                C0252t.m1285a(obj, rect);
            }
        } else {
            rect = null;
        }
        final C0332a<String, String> c0332a2 = c0332a;
        final C0243a c0243a2 = c0243a;
        final ArrayList<View> arrayList3 = arrayList2;
        final View view2 = view;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj4 = obj;
        C0260x.m1332a(viewGroup, new Runnable() {
            public void run() {
                C0332a a = C0244s.m1275c(c0332a2, obj3, c0243a2);
                if (a != null) {
                    arrayList3.addAll(a.values());
                    arrayList3.add(view2);
                }
                C0244s.m1272b(c0212h, c0212h2, z, a, false);
                if (obj3 != null) {
                    C0252t.m1290a(obj3, arrayList4, arrayList3);
                    View a2 = C0244s.m1267b(a, c0243a2, obj4, z);
                    if (a2 != null) {
                        C0252t.m1280a(a2, rect);
                    }
                }
            }
        });
        return obj3;
    }

    private static ArrayList<View> m1270b(Object obj, C0212h c0212h, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View i = c0212h.m1001i();
            if (i != null) {
                C0252t.m1291a((ArrayList) arrayList2, i);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                C0252t.m1289a(obj, (ArrayList) arrayList2);
            }
        }
        return arrayList2;
    }

    public static void m1271b(C0199c c0199c, SparseArray<C0243a> sparseArray, boolean z) {
        if (c0199c.f561b.f737n.mo160a()) {
            for (int size = c0199c.f562c.size() - 1; size >= 0; size--) {
                C0244s.m1255a(c0199c, (C0196a) c0199c.f562c.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    private static void m1272b(C0212h c0212h, C0212h c0212h2, boolean z, C0332a<String, View> c0332a, boolean z2) {
        int i = 0;
        C0261y P = z ? c0212h2.m940P() : c0212h.m940P();
        if (P != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int size = c0332a == null ? 0 : c0332a.size();
            while (i < size) {
                arrayList2.add(c0332a.m1606b(i));
                arrayList.add(c0332a.m1607c(i));
                i++;
            }
            if (z2) {
                P.m1334a(arrayList2, arrayList, null);
            } else {
                P.m1336b(arrayList2, arrayList, null);
            }
        }
    }

    private static void m1273b(C0233n c0233n, int i, C0243a c0243a, View view, C0332a<String, String> c0332a) {
        ViewGroup viewGroup = null;
        if (c0233n.f737n.mo160a()) {
            viewGroup = (ViewGroup) c0233n.f737n.mo159a(i);
        }
        if (viewGroup != null) {
            C0212h c0212h = c0243a.f793a;
            C0212h c0212h2 = c0243a.f796d;
            boolean z = c0243a.f794b;
            boolean z2 = c0243a.f797e;
            Object a = C0244s.m1250a(c0212h, z);
            Object b = C0244s.m1268b(c0212h2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object b2 = C0244s.m1269b(viewGroup, view, c0332a, c0243a, arrayList, arrayList2, a, b);
            if (a != null || b2 != null || b != null) {
                ArrayList b3 = C0244s.m1270b(b, c0212h2, arrayList, view);
                Object obj = (b3 == null || b3.isEmpty()) ? null : b;
                C0252t.m1300b(a, view);
                b = C0244s.m1252a(a, obj, b2, c0212h, c0243a.f794b);
                if (b != null) {
                    ArrayList arrayList3 = new ArrayList();
                    C0252t.m1288a(b, a, arrayList3, obj, b3, b2, arrayList2);
                    C0244s.m1261a(viewGroup, c0212h, view, arrayList2, a, arrayList3, obj, b3);
                    C0252t.m1282a((View) viewGroup, arrayList2, (Map) c0332a);
                    C0252t.m1283a(viewGroup, b);
                    C0252t.m1284a(viewGroup, arrayList2, (Map) c0332a);
                }
            }
        }
    }

    private static void m1274b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    private static C0332a<String, View> m1275c(C0332a<String, String> c0332a, Object obj, C0243a c0243a) {
        C0212h c0212h = c0243a.f793a;
        View i = c0212h.m1001i();
        if (c0332a.isEmpty() || obj == null || i == null) {
            c0332a.clear();
            return null;
        }
        ArrayList arrayList;
        C0261y c0261y;
        C0332a<String, View> c0332a2 = new C0332a();
        C0252t.m1293a((Map) c0332a2, i);
        C0199c c0199c = c0243a.f795c;
        C0261y Q;
        if (c0243a.f794b) {
            Q = c0212h.m941Q();
            arrayList = c0199c.f578s;
            c0261y = Q;
        } else {
            Q = c0212h.m940P();
            arrayList = c0199c.f579t;
            c0261y = Q;
        }
        if (arrayList != null) {
            c0332a2.m1610a(arrayList);
        }
        if (c0261y != null) {
            c0261y.m1335a(arrayList, c0332a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                i = (View) c0332a2.get(str);
                if (i == null) {
                    str = C0244s.m1253a((C0332a) c0332a, str);
                    if (str != null) {
                        c0332a.remove(str);
                    }
                } else if (!str.equals(C0425s.m1977p(i))) {
                    str = C0244s.m1253a((C0332a) c0332a, str);
                    if (str != null) {
                        c0332a.put(str, C0425s.m1977p(i));
                    }
                }
            }
        } else {
            C0244s.m1260a((C0332a) c0332a, (C0332a) c0332a2);
        }
        return c0332a2;
    }
}
