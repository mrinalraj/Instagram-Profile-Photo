package android.support.v4.p005c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.p013b.p014a.C0268b.C0265b;
import android.support.v4.p013b.p014a.C0268b.C0266c;
import android.support.v4.p017f.C0323b;
import android.support.v4.p017f.C0323b.C0322b;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public class C0297f extends C0295d {
    private static final Class f891a;
    private static final Constructor f892b;
    private static final Method f893c;
    private static final Method f894d;
    private static final Method f895e;
    private static final Method f896f;
    private static final Method f897g;

    static {
        Method method;
        Method method2;
        Method method3;
        Method declaredMethod;
        Constructor constructor;
        Class cls;
        Throwable e;
        Method method4 = null;
        try {
            Class cls2 = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls2.getConstructor(new Class[0]);
            Method method5 = cls2.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method = cls2.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method2 = cls2.getMethod("freeze", new Class[0]);
            method3 = cls2.getMethod("abortCreation", new Class[0]);
            declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls2, 1).getClass(), Integer.TYPE, Integer.TYPE});
            declaredMethod.setAccessible(true);
            method4 = method3;
            method3 = method2;
            method2 = method;
            method = method5;
            constructor = constructor2;
            cls = cls2;
        } catch (ClassNotFoundException e2) {
            e = e2;
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            declaredMethod = null;
            method3 = null;
            method2 = null;
            method = null;
            constructor = null;
            cls = null;
            f892b = constructor;
            f891a = cls;
            f893c = method;
            f894d = method2;
            f895e = method3;
            f896f = method4;
            f897g = declaredMethod;
        } catch (NoSuchMethodException e3) {
            e = e3;
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            declaredMethod = null;
            method3 = null;
            method2 = null;
            method = null;
            constructor = null;
            cls = null;
            f892b = constructor;
            f891a = cls;
            f893c = method;
            f894d = method2;
            f895e = method3;
            f896f = method4;
            f897g = declaredMethod;
        }
        f892b = constructor;
        f891a = cls;
        f893c = method;
        f894d = method2;
        f895e = method3;
        f896f = method4;
        f897g = declaredMethod;
    }

    private static Typeface m1489a(Object obj) {
        Throwable e;
        try {
            Array.set(Array.newInstance(f891a, 1), 0, obj);
            return (Typeface) f897g.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private static boolean m1490a() {
        if (f893c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f893c != null;
    }

    private static boolean m1491a(Context context, Object obj, String str, int i, int i2, int i3) {
        Throwable e;
        try {
            return ((Boolean) f893c.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private static boolean m1492a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        Throwable e;
        try {
            return ((Boolean) f894d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private static Object m1493b() {
        Throwable e;
        try {
            return f892b.newInstance(new Object[0]);
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

    private static boolean m1494b(Object obj) {
        Throwable e;
        try {
            return ((Boolean) f895e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private static boolean m1495c(Object obj) {
        Throwable e;
        try {
            return ((Boolean) f896f.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    public Typeface mo207a(Context context, Resources resources, int i, String str, int i2) {
        if (!C0297f.m1490a()) {
            return super.mo207a(context, resources, i, str, i2);
        }
        Object b = C0297f.m1493b();
        if (C0297f.m1491a(context, b, str, 0, -1, -1)) {
            return !C0297f.m1494b(b) ? null : C0297f.m1489a(b);
        } else {
            C0297f.m1495c(b);
            return null;
        }
    }

    public Typeface mo208a(Context context, CancellationSignal cancellationSignal, C0322b[] c0322bArr, int i) {
        Throwable th;
        Throwable th2;
        if (c0322bArr.length < 1) {
            return null;
        }
        if (C0297f.m1490a()) {
            Map a = C0323b.m1557a(context, c0322bArr, cancellationSignal);
            Object b = C0297f.m1493b();
            Object obj = null;
            int length = c0322bArr.length;
            int i2 = 0;
            while (i2 < length) {
                Object obj2;
                C0322b c0322b = c0322bArr[i2];
                ByteBuffer byteBuffer = (ByteBuffer) a.get(c0322b.m1545a());
                if (byteBuffer == null) {
                    obj2 = obj;
                } else {
                    if (C0297f.m1492a(b, byteBuffer, c0322b.m1546b(), c0322b.m1547c(), c0322b.m1548d() ? 1 : 0)) {
                        obj2 = 1;
                    } else {
                        C0297f.m1495c(b);
                        return null;
                    }
                }
                i2++;
                obj = obj2;
            }
            if (obj != null) {
                return !C0297f.m1494b(b) ? null : C0297f.m1489a(b);
            } else {
                C0297f.m1495c(b);
                return null;
            }
        }
        ParcelFileDescriptor openFileDescriptor;
        C0322b a2 = m1480a(c0322bArr, i);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.m1545a(), "r", cancellationSignal);
            th = null;
            try {
                Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.m1547c()).setItalic(a2.m1548d()).build();
                if (openFileDescriptor == null) {
                    return build;
                }
                if (th != null) {
                    try {
                        openFileDescriptor.close();
                        return build;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        return build;
                    }
                }
                openFileDescriptor.close();
                return build;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                th4 = th2;
                th2 = th5;
            }
        } catch (IOException e) {
            return null;
        }
        if (openFileDescriptor != null) {
            if (th4 != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th32) {
                    th4.addSuppressed(th32);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th2;
        throw th2;
    }

    public Typeface mo209a(Context context, C0265b c0265b, Resources resources, int i) {
        if (!C0297f.m1490a()) {
            return super.mo209a(context, c0265b, resources, i);
        }
        Object b = C0297f.m1493b();
        C0266c[] a = c0265b.m1339a();
        int length = a.length;
        int i2 = 0;
        while (i2 < length) {
            C0266c c0266c = a[i2];
            if (C0297f.m1491a(context, b, c0266c.m1340a(), 0, c0266c.m1341b(), c0266c.m1342c() ? 1 : 0)) {
                i2++;
            } else {
                C0297f.m1495c(b);
                return null;
            }
        }
        return !C0297f.m1494b(b) ? null : C0297f.m1489a(b);
    }
}
