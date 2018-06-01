package android.support.v7.p023c.p024a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p013b.C0190a;
import android.support.v7.widget.C0827m;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class C0608b {
    private static final ThreadLocal<TypedValue> f1584a = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<C0607a>> f1585b = new WeakHashMap(0);
    private static final Object f1586c = new Object();

    private static class C0607a {
        final ColorStateList f1582a;
        final Configuration f1583b;

        C0607a(ColorStateList colorStateList, Configuration configuration) {
            this.f1582a = colorStateList;
            this.f1583b = configuration;
        }
    }

    public static ColorStateList m2860a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = C0608b.m2865d(context, i);
        if (d != null) {
            return d;
        }
        d = C0608b.m2864c(context, i);
        if (d == null) {
            return C0190a.m867b(context, i);
        }
        C0608b.m2862a(context, i, d);
        return d;
    }

    private static TypedValue m2861a() {
        TypedValue typedValue = (TypedValue) f1584a.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f1584a.set(typedValue);
        return typedValue;
    }

    private static void m2862a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f1586c) {
            SparseArray sparseArray = (SparseArray) f1585b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f1585b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0607a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static Drawable m2863b(Context context, int i) {
        return C0827m.m4729a().m4748a(context, i);
    }

    private static ColorStateList m2864c(Context context, int i) {
        ColorStateList colorStateList = null;
        if (!C0608b.m2866e(context, i)) {
            Resources resources = context.getResources();
            try {
                colorStateList = C0606a.m2856a(resources, resources.getXml(i), context.getTheme());
            } catch (Throwable e) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        return colorStateList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m2865d(android.content.Context r5, int r6) {
        /*
        r2 = f1586c;
        monitor-enter(r2);
        r0 = f1585b;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0035 }
        r0 = (android.util.SparseArray) r0;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0032;
    L_0x000d:
        r1 = r0.size();	 Catch:{ all -> 0x0035 }
        if (r1 <= 0) goto L_0x0032;
    L_0x0013:
        r1 = r0.get(r6);	 Catch:{ all -> 0x0035 }
        r1 = (android.support.v7.p023c.p024a.C0608b.C0607a) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r1.f1583b;	 Catch:{ all -> 0x0035 }
        r4 = r5.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r3 == 0) goto L_0x002f;
    L_0x002b:
        r0 = r1.f1582a;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
    L_0x002e:
        return r0;
    L_0x002f:
        r0.remove(r6);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        r0 = 0;
        goto L_0x002e;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.b.d(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static boolean m2866e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = C0608b.m2861a();
        resources.getValue(i, a, true);
        return a.type >= 28 && a.type <= 31;
    }
}
