package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class C0587n {
    private static Field f1507a;
    private static boolean f1508b;
    private static Class f1509c;
    private static boolean f1510d;
    private static Field f1511e;
    private static boolean f1512f;
    private static Field f1513g;
    private static boolean f1514h;

    static boolean m2744a(Resources resources) {
        return VERSION.SDK_INT >= 24 ? C0587n.m2748d(resources) : VERSION.SDK_INT >= 23 ? C0587n.m2747c(resources) : VERSION.SDK_INT >= 21 ? C0587n.m2746b(resources) : false;
    }

    private static boolean m2745a(Object obj) {
        if (!f1510d) {
            try {
                f1509c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f1510d = true;
        }
        if (f1509c == null) {
            return false;
        }
        if (!f1512f) {
            try {
                f1511e = f1509c.getDeclaredField("mUnthemedEntries");
                f1511e.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f1512f = true;
        }
        if (f1511e == null) {
            return false;
        }
        LongSparseArray longSparseArray;
        try {
            longSparseArray = (LongSparseArray) f1511e.get(obj);
        } catch (Throwable e22) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e22);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }

    private static boolean m2746b(Resources resources) {
        if (!f1508b) {
            try {
                f1507a = Resources.class.getDeclaredField("mDrawableCache");
                f1507a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1508b = true;
        }
        if (f1507a != null) {
            Map map;
            try {
                map = (Map) f1507a.get(resources);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
                return true;
            }
        }
        return false;
    }

    private static boolean m2747c(Resources resources) {
        Object obj;
        boolean z = true;
        if (!f1508b) {
            try {
                f1507a = Resources.class.getDeclaredField("mDrawableCache");
                f1507a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1508b = true;
        }
        if (f1507a != null) {
            try {
                obj = f1507a.get(resources);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            if (obj == null) {
                return false;
            }
            if (obj == null || !C0587n.m2745a(obj)) {
                z = false;
            }
            return z;
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        z = false;
        return z;
    }

    private static boolean m2748d(Resources resources) {
        boolean z = true;
        if (!f1514h) {
            try {
                f1513g = Resources.class.getDeclaredField("mResourcesImpl");
                f1513g.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f1514h = true;
        }
        if (f1513g == null) {
            return false;
        }
        Object obj;
        try {
            obj = f1513g.get(resources);
        } catch (Throwable e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        Object obj2;
        if (!f1508b) {
            try {
                f1507a = obj.getClass().getDeclaredField("mDrawableCache");
                f1507a.setAccessible(true);
            } catch (Throwable e22) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e22);
            }
            f1508b = true;
        }
        if (f1507a != null) {
            try {
                obj2 = f1507a.get(obj);
            } catch (Throwable e222) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e222);
            }
            if (obj2 == null || !C0587n.m2745a(obj2)) {
                z = false;
            }
            return z;
        }
        obj2 = null;
        z = false;
        return z;
    }
}
