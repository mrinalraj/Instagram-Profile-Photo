package android.support.v4.p005c.p006a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class C0279a {
    static final C0274e f867a;

    static class C0274e {
        C0274e() {
        }

        public int mo186a(Drawable drawable) {
            return 0;
        }

        public void mo192a(Drawable drawable, float f, float f2) {
        }

        public void mo193a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo194a(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof C0029f) {
                ((C0029f) drawable).setTintList(colorStateList);
            }
        }

        public void mo195a(Drawable drawable, Theme theme) {
        }

        public void mo196a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }

        public void mo197a(Drawable drawable, Mode mode) {
            if (drawable instanceof C0029f) {
                ((C0029f) drawable).setTintMode(mode);
            }
        }

        public void mo188a(Drawable drawable, boolean z) {
        }

        public boolean mo187a(Drawable drawable, int i) {
            return false;
        }

        public void mo198b(Drawable drawable, int i) {
            if (drawable instanceof C0029f) {
                ((C0029f) drawable).setTint(i);
            }
        }

        public boolean mo189b(Drawable drawable) {
            return false;
        }

        public Drawable mo190c(Drawable drawable) {
            return !(drawable instanceof C0029f) ? new C0283c(drawable) : drawable;
        }

        public int mo191d(Drawable drawable) {
            return 0;
        }

        public boolean mo199e(Drawable drawable) {
            return false;
        }

        public ColorFilter mo200f(Drawable drawable) {
            return null;
        }

        public void m1397g(Drawable drawable) {
            drawable.jumpToCurrentState();
        }
    }

    static class C0275a extends C0274e {
        private static Method f863a;
        private static boolean f864b;
        private static Method f865c;
        private static boolean f866d;

        C0275a() {
        }

        public int mo186a(Drawable drawable) {
            if (!f866d) {
                try {
                    f865c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f865c.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve getLayoutDirection() method", e);
                }
                f866d = true;
            }
            if (f865c != null) {
                try {
                    return ((Integer) f865c.invoke(drawable, new Object[0])).intValue();
                } catch (Throwable e2) {
                    Log.i("DrawableCompatApi17", "Failed to invoke getLayoutDirection() via reflection", e2);
                    f865c = null;
                }
            }
            return 0;
        }

        public boolean mo187a(Drawable drawable, int i) {
            if (!f864b) {
                try {
                    f863a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    f863a.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("DrawableCompatApi17", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                f864b = true;
            }
            if (f863a != null) {
                try {
                    f863a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                    return true;
                } catch (Throwable e2) {
                    Log.i("DrawableCompatApi17", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    f863a = null;
                }
            }
            return false;
        }
    }

    static class C0276b extends C0275a {
        C0276b() {
        }

        public void mo188a(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        public boolean mo189b(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        public Drawable mo190c(Drawable drawable) {
            return !(drawable instanceof C0029f) ? new C0285d(drawable) : drawable;
        }

        public int mo191d(Drawable drawable) {
            return drawable.getAlpha();
        }
    }

    static class C0277c extends C0276b {
        C0277c() {
        }

        public void mo192a(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        public void mo193a(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        public void mo194a(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public void mo195a(Drawable drawable, Theme theme) {
            drawable.applyTheme(theme);
        }

        public void mo196a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public void mo197a(Drawable drawable, Mode mode) {
            drawable.setTintMode(mode);
        }

        public void mo198b(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        public Drawable mo190c(Drawable drawable) {
            return !(drawable instanceof C0029f) ? new C0287e(drawable) : drawable;
        }

        public boolean mo199e(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public ColorFilter mo200f(Drawable drawable) {
            return drawable.getColorFilter();
        }
    }

    static class C0278d extends C0277c {
        C0278d() {
        }

        public int mo186a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public boolean mo187a(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        public Drawable mo190c(Drawable drawable) {
            return drawable;
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f867a = new C0278d();
        } else if (VERSION.SDK_INT >= 21) {
            f867a = new C0277c();
        } else if (VERSION.SDK_INT >= 19) {
            f867a = new C0276b();
        } else if (VERSION.SDK_INT >= 17) {
            f867a = new C0275a();
        } else {
            f867a = new C0274e();
        }
    }

    public static void m1417a(Drawable drawable) {
        f867a.m1397g(drawable);
    }

    public static void m1418a(Drawable drawable, float f, float f2) {
        f867a.mo192a(drawable, f, f2);
    }

    public static void m1419a(Drawable drawable, int i) {
        f867a.mo198b(drawable, i);
    }

    public static void m1420a(Drawable drawable, int i, int i2, int i3, int i4) {
        f867a.mo193a(drawable, i, i2, i3, i4);
    }

    public static void m1421a(Drawable drawable, ColorStateList colorStateList) {
        f867a.mo194a(drawable, colorStateList);
    }

    public static void m1422a(Drawable drawable, Theme theme) {
        f867a.mo195a(drawable, theme);
    }

    public static void m1423a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f867a.mo196a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void m1424a(Drawable drawable, Mode mode) {
        f867a.mo197a(drawable, mode);
    }

    public static void m1425a(Drawable drawable, boolean z) {
        f867a.mo188a(drawable, z);
    }

    public static boolean m1426b(Drawable drawable) {
        return f867a.mo189b(drawable);
    }

    public static boolean m1427b(Drawable drawable, int i) {
        return f867a.mo187a(drawable, i);
    }

    public static int m1428c(Drawable drawable) {
        return f867a.mo191d(drawable);
    }

    public static boolean m1429d(Drawable drawable) {
        return f867a.mo199e(drawable);
    }

    public static ColorFilter m1430e(Drawable drawable) {
        return f867a.mo200f(drawable);
    }

    public static Drawable m1431f(Drawable drawable) {
        return f867a.mo190c(drawable);
    }

    public static int m1432g(Drawable drawable) {
        return f867a.mo186a(drawable);
    }
}
