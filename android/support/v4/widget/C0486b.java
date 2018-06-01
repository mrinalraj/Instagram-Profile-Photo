package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class C0486b {
    private static final C0483c f1229a;

    static class C0483c {
        private static Field f1227a;
        private static boolean f1228b;

        C0483c() {
        }

        public Drawable mo371a(CompoundButton compoundButton) {
            if (!f1228b) {
                try {
                    f1227a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f1227a.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                f1228b = true;
            }
            if (f1227a != null) {
                try {
                    return (Drawable) f1227a.get(compoundButton);
                } catch (Throwable e2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                    f1227a = null;
                }
            }
            return null;
        }

        public void mo369a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof C0515m) {
                ((C0515m) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        public void mo370a(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof C0515m) {
                ((C0515m) compoundButton).setSupportButtonTintMode(mode);
            }
        }
    }

    static class C0484a extends C0483c {
        C0484a() {
        }

        public void mo369a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public void mo370a(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class C0485b extends C0484a {
        C0485b() {
        }

        public Drawable mo371a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f1229a = new C0485b();
        } else if (VERSION.SDK_INT >= 21) {
            f1229a = new C0484a();
        } else {
            f1229a = new C0483c();
        }
    }

    public static Drawable m2376a(CompoundButton compoundButton) {
        return f1229a.mo371a(compoundButton);
    }

    public static void m2377a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1229a.mo369a(compoundButton, colorStateList);
    }

    public static void m2378a(CompoundButton compoundButton, Mode mode) {
        f1229a.mo370a(compoundButton, mode);
    }
}
