package android.support.v4.p012a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class C0205g {

    static class C0204a {
        private static Method f596a;
        private static boolean f597b;

        public static IBinder m902a(Bundle bundle, String str) {
            Throwable e;
            if (!f597b) {
                try {
                    f596a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f596a.setAccessible(true);
                } catch (Throwable e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e2);
                }
                f597b = true;
            }
            if (f596a != null) {
                try {
                    return (IBinder) f596a.invoke(bundle, new Object[]{str});
                } catch (InvocationTargetException e3) {
                    e2 = e3;
                } catch (IllegalAccessException e4) {
                    e2 = e4;
                } catch (IllegalArgumentException e5) {
                    e2 = e5;
                }
            }
            return null;
            Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
            f596a = null;
            return null;
        }
    }

    public static IBinder m903a(Bundle bundle, String str) {
        return VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : C0204a.m902a(bundle, str);
    }
}
