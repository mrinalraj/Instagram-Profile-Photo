package android.support.v4.p008h;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class C0401e {
    static final C0399b f1048a;
    private static Field f1049b;
    private static boolean f1050c;

    static class C0399b {
        C0399b() {
        }

        public void mo246a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                C0401e.m1788a(layoutInflater, (Factory2) factory);
            } else {
                C0401e.m1788a(layoutInflater, factory2);
            }
        }
    }

    static class C0400a extends C0399b {
        C0400a() {
        }

        public void mo246a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1048a = new C0400a();
        } else {
            f1048a = new C0399b();
        }
    }

    static void m1788a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f1050c) {
            try {
                f1049b = LayoutInflater.class.getDeclaredField("mFactory2");
                f1049b.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f1050c = true;
        }
        if (f1049b != null) {
            try {
                f1049b.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void m1789b(LayoutInflater layoutInflater, Factory2 factory2) {
        f1048a.mo246a(layoutInflater, factory2);
    }
}
