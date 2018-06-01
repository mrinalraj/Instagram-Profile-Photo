package android.support.v4.p005c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.p013b.p014a.C0268b.C0265b;
import android.support.v4.p013b.p014a.C0268b.C0266c;
import android.support.v4.p017f.C0323b.C0322b;
import android.support.v4.p018g.C0331l;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class C0296e extends C0294g {
    private static final Class f887a;
    private static final Constructor f888b;
    private static final Method f889c;
    private static final Method f890d;

    static {
        Method method;
        Constructor constructor;
        Class cls;
        Throwable e;
        Method method2 = null;
        try {
            Class cls2 = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls2.getConstructor(new Class[0]);
            Method method3 = cls2.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls2, 1).getClass()});
            method2 = method3;
            constructor = constructor2;
            cls = cls2;
        } catch (ClassNotFoundException e2) {
            e = e2;
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            method = null;
            constructor = null;
            cls = null;
            f888b = constructor;
            f887a = cls;
            f889c = method2;
            f890d = method;
        } catch (NoSuchMethodException e3) {
            e = e3;
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            method = null;
            constructor = null;
            cls = null;
            f888b = constructor;
            f887a = cls;
            f889c = method2;
            f890d = method;
        }
        f888b = constructor;
        f887a = cls;
        f889c = method2;
        f890d = method;
    }

    C0296e() {
    }

    private static Typeface m1483a(Object obj) {
        Throwable e;
        try {
            Array.set(Array.newInstance(f887a, 1), 0, obj);
            return (Typeface) f890d.invoke(null, new Object[]{r0});
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    public static boolean m1484a() {
        if (f889c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f889c != null;
    }

    private static boolean m1485a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        Throwable e;
        try {
            return ((Boolean) f889c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private static Object m1486b() {
        Throwable e;
        try {
            return f888b.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw new RuntimeException(e);
        }
    }

    public Typeface mo208a(Context context, CancellationSignal cancellationSignal, C0322b[] c0322bArr, int i) {
        Object b = C0296e.m1486b();
        C0331l c0331l = new C0331l();
        for (C0322b c0322b : c0322bArr) {
            Uri a = c0322b.m1545a();
            ByteBuffer byteBuffer = (ByteBuffer) c0331l.get(a);
            if (byteBuffer == null) {
                byteBuffer = C0301h.m1511a(context, cancellationSignal, a);
                c0331l.put(a, byteBuffer);
            }
            if (!C0296e.m1485a(b, byteBuffer, c0322b.m1546b(), c0322b.m1547c(), c0322b.m1548d())) {
                return null;
            }
        }
        return C0296e.m1483a(b);
    }

    public Typeface mo209a(Context context, C0265b c0265b, Resources resources, int i) {
        Object b = C0296e.m1486b();
        for (C0266c c0266c : c0265b.m1339a()) {
            if (!C0296e.m1485a(b, C0301h.m1510a(context, resources, c0266c.m1343d()), 0, c0266c.m1341b(), c0266c.m1342c())) {
                return null;
            }
        }
        return C0296e.m1483a(b);
    }
}
