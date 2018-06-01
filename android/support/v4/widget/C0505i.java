package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.p008h.C0398d;
import android.support.v4.p008h.C0425s;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class C0505i {
    static final C0501d f1249a;

    static class C0501d {
        private static Method f1246a;
        private static boolean f1247b;

        C0501d() {
        }

        public void mo386a(PopupWindow popupWindow, int i) {
            if (!f1247b) {
                try {
                    f1246a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    f1246a.setAccessible(true);
                } catch (Exception e) {
                }
                f1247b = true;
            }
            if (f1246a != null) {
                try {
                    f1246a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }

        public void mo384a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0398d.m1784a(i3, C0425s.m1966f(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo385a(PopupWindow popupWindow, boolean z) {
        }
    }

    static class C0502a extends C0501d {
        C0502a() {
        }

        public void mo384a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    static class C0503b extends C0502a {
        private static Field f1248a;

        static {
            try {
                f1248a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f1248a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        C0503b() {
        }

        public void mo385a(PopupWindow popupWindow, boolean z) {
            if (f1248a != null) {
                try {
                    f1248a.set(popupWindow, Boolean.valueOf(z));
                } catch (Throwable e) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    static class C0504c extends C0503b {
        C0504c() {
        }

        public void mo386a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        public void mo385a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f1249a = new C0504c();
        } else if (VERSION.SDK_INT >= 21) {
            f1249a = new C0503b();
        } else if (VERSION.SDK_INT >= 19) {
            f1249a = new C0502a();
        } else {
            f1249a = new C0501d();
        }
    }

    public static void m2429a(PopupWindow popupWindow, int i) {
        f1249a.mo386a(popupWindow, i);
    }

    public static void m2430a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1249a.mo384a(popupWindow, view, i, i2, i3);
    }

    public static void m2431a(PopupWindow popupWindow, boolean z) {
        f1249a.mo385a(popupWindow, z);
    }
}
