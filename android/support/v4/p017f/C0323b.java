package android.support.v4.p017f;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.support.v4.p005c.C0293c;
import android.support.v4.p005c.C0301h;
import android.support.v4.p013b.p014a.C0268b;
import android.support.v4.p017f.C0328c.C0317a;
import android.support.v4.p018g.C0331l;
import android.support.v4.p018g.C0339g;
import android.support.v4.p018g.C0350k;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class C0323b {
    private static final C0339g<String, Typeface> f930a = new C0339g(16);
    private static final C0328c f931b = new C0328c("fonts", 10, 10000);
    private static final Object f932c = new Object();
    private static final C0331l<String, ArrayList<C0317a<Typeface>>> f933d = new C0331l();
    private static final Comparator<byte[]> f934e = new C03204();

    static class C03204 implements Comparator<byte[]> {
        C03204() {
        }

        public int m1542a(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1542a((byte[]) obj, (byte[]) obj2);
        }
    }

    public static class C0321a {
        private final int f923a;
        private final C0322b[] f924b;

        public C0321a(int i, C0322b[] c0322bArr) {
            this.f923a = i;
            this.f924b = c0322bArr;
        }

        public int m1543a() {
            return this.f923a;
        }

        public C0322b[] m1544b() {
            return this.f924b;
        }
    }

    public static class C0322b {
        private final Uri f925a;
        private final int f926b;
        private final int f927c;
        private final boolean f928d;
        private final int f929e;

        public C0322b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f925a = (Uri) C0350k.m1665a(uri);
            this.f926b = i;
            this.f927c = i2;
            this.f928d = z;
            this.f929e = i3;
        }

        public Uri m1545a() {
            return this.f925a;
        }

        public int m1546b() {
            return this.f926b;
        }

        public int m1547c() {
            return this.f927c;
        }

        public boolean m1548d() {
            return this.f928d;
        }

        public int m1549e() {
            return this.f929e;
        }
    }

    public static ProviderInfo m1550a(PackageManager packageManager, C0315a c0315a, Resources resources) {
        String a = c0315a.m1530a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a, 0);
        if (resolveContentProvider == null) {
            throw new NameNotFoundException("No package found for authority: " + a);
        } else if (resolveContentProvider.packageName.equals(c0315a.m1531b())) {
            List a2 = C0323b.m1556a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f934e);
            List a3 = C0323b.m1555a(c0315a, resources);
            for (int i = 0; i < a3.size(); i++) {
                List arrayList = new ArrayList((Collection) a3.get(i));
                Collections.sort(arrayList, f934e);
                if (C0323b.m1558a(a2, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new NameNotFoundException("Found content provider " + a + ", but package was not " + c0315a.m1531b());
        }
    }

    public static Typeface m1552a(final Context context, final C0315a c0315a, final TextView textView, int i, int i2, final int i3) {
        final Object obj = c0315a.m1535f() + "-" + i3;
        Typeface typeface = (Typeface) f930a.m1649a(obj);
        if (typeface != null) {
            return typeface;
        }
        Object obj2 = i == 0 ? 1 : null;
        if (obj2 != null && i2 == -1) {
            return C0323b.m1560b(context, c0315a, i3);
        }
        Callable c03161 = new Callable<Typeface>() {
            public Typeface m1536a() {
                Typeface a = C0323b.m1560b(context, c0315a, i3);
                if (a != null) {
                    C0323b.f930a.m1650a(obj, a);
                }
                return a;
            }

            public /* synthetic */ Object call() {
                return m1536a();
            }
        };
        if (obj2 != null) {
            try {
                return (Typeface) f931b.m1568a(c03161, i2);
            } catch (InterruptedException e) {
                return null;
            }
        }
        final WeakReference weakReference = new WeakReference(textView);
        C03182 c03182 = new C0317a<Typeface>() {
            public void m1538a(Typeface typeface) {
                if (((TextView) weakReference.get()) != null) {
                    textView.setTypeface(typeface, i3);
                }
            }
        };
        synchronized (f932c) {
            if (f933d.containsKey(obj)) {
                ((ArrayList) f933d.get(obj)).add(c03182);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c03182);
            f933d.put(obj, arrayList);
            f931b.m1569a(c03161, new C0317a<Typeface>() {
                public void m1540a(Typeface typeface) {
                    synchronized (C0323b.f932c) {
                        ArrayList arrayList = (ArrayList) C0323b.f933d.get(obj);
                        C0323b.f933d.remove(obj);
                    }
                    for (int i = 0; i < arrayList.size(); i++) {
                        ((C0317a) arrayList.get(i)).mo213a(typeface);
                    }
                }
            });
            return null;
        }
    }

    public static C0321a m1553a(Context context, CancellationSignal cancellationSignal, C0315a c0315a) {
        ProviderInfo a = C0323b.m1550a(context.getPackageManager(), c0315a, context.getResources());
        return a == null ? new C0321a(1, null) : new C0321a(0, C0323b.m1559a(context, c0315a, a.authority, cancellationSignal));
    }

    private static List<List<byte[]>> m1555a(C0315a c0315a, Resources resources) {
        return c0315a.m1533d() != null ? c0315a.m1533d() : C0268b.m1348a(resources, c0315a.m1534e());
    }

    private static List<byte[]> m1556a(Signature[] signatureArr) {
        List<byte[]> arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    public static Map<Uri, ByteBuffer> m1557a(Context context, C0322b[] c0322bArr, CancellationSignal cancellationSignal) {
        Map hashMap = new HashMap();
        for (C0322b c0322b : c0322bArr) {
            if (c0322b.m1549e() == 0) {
                Uri a = c0322b.m1545a();
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, C0301h.m1511a(context, cancellationSignal, a));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean m1558a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static C0322b[] m1559a(Context context, C0315a c0315a, String str, CancellationSignal cancellationSignal) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Uri build = new Builder().scheme("content").authority(str).build();
        Uri build2 = new Builder().scheme("content").authority(str).appendPath("file").build();
        try {
            ArrayList arrayList2;
            Cursor query = VERSION.SDK_INT > 16 ? context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0315a.m1532c()}, null, cancellationSignal) : context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0315a.m1532c()}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex("result_code");
                        arrayList2 = new ArrayList();
                        int columnIndex2 = query.getColumnIndex("_id");
                        int columnIndex3 = query.getColumnIndex("file_id");
                        int columnIndex4 = query.getColumnIndex("font_ttc_index");
                        int columnIndex5 = query.getColumnIndex("font_weight");
                        int columnIndex6 = query.getColumnIndex("font_italic");
                        while (query.moveToNext()) {
                            int i = columnIndex != -1 ? query.getInt(columnIndex) : 0;
                            int i2 = columnIndex4 != -1 ? query.getInt(columnIndex4) : 0;
                            Uri withAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(build, query.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, query.getLong(columnIndex3));
                            int i3 = columnIndex5 != -1 ? query.getInt(columnIndex5) : 400;
                            boolean z = columnIndex6 != -1 && query.getInt(columnIndex6) == 1;
                            arrayList2.add(new C0322b(withAppendedId, i2, i3, z, i));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return (C0322b[]) arrayList2.toArray(new C0322b[0]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                }
            }
            arrayList2 = arrayList;
            if (query != null) {
                query.close();
            }
            return (C0322b[]) arrayList2.toArray(new C0322b[0]);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static Typeface m1560b(Context context, C0315a c0315a, int i) {
        try {
            C0321a a = C0323b.m1553a(context, null, c0315a);
            return a.m1543a() == 0 ? C0293c.m1470a(context, null, a.m1544b(), i) : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
