package android.support.v4.p008h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v4.p015d.p016a.C0303b;
import android.util.Log;
import android.view.MenuItem;

public final class C0406g {
    static final C0403c f1051a;

    interface C0403c {
        void mo247a(MenuItem menuItem, char c, int i);

        void mo248a(MenuItem menuItem, ColorStateList colorStateList);

        void mo249a(MenuItem menuItem, Mode mode);

        void mo250a(MenuItem menuItem, CharSequence charSequence);

        void mo251b(MenuItem menuItem, char c, int i);

        void mo252b(MenuItem menuItem, CharSequence charSequence);
    }

    static class C0404b implements C0403c {
        C0404b() {
        }

        public void mo247a(MenuItem menuItem, char c, int i) {
        }

        public void mo248a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        public void mo249a(MenuItem menuItem, Mode mode) {
        }

        public void mo250a(MenuItem menuItem, CharSequence charSequence) {
        }

        public void mo251b(MenuItem menuItem, char c, int i) {
        }

        public void mo252b(MenuItem menuItem, CharSequence charSequence) {
        }
    }

    static class C0405a extends C0404b {
        C0405a() {
        }

        public void mo247a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        public void mo248a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        public void mo249a(MenuItem menuItem, Mode mode) {
            menuItem.setIconTintMode(mode);
        }

        public void mo250a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        public void mo251b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        public void mo252b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1051a = new C0405a();
        } else {
            f1051a = new C0404b();
        }
    }

    public static MenuItem m1810a(MenuItem menuItem, C0397c c0397c) {
        if (menuItem instanceof C0303b) {
            return ((C0303b) menuItem).mo502a(c0397c);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void m1811a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0303b) {
            ((C0303b) menuItem).setNumericShortcut(c, i);
        } else {
            f1051a.mo251b(menuItem, c, i);
        }
    }

    public static void m1812a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof C0303b) {
            ((C0303b) menuItem).setIconTintList(colorStateList);
        } else {
            f1051a.mo248a(menuItem, colorStateList);
        }
    }

    public static void m1813a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof C0303b) {
            ((C0303b) menuItem).setIconTintMode(mode);
        } else {
            f1051a.mo249a(menuItem, mode);
        }
    }

    public static void m1814a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0303b) {
            ((C0303b) menuItem).mo503a(charSequence);
        } else {
            f1051a.mo250a(menuItem, charSequence);
        }
    }

    public static void m1815b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0303b) {
            ((C0303b) menuItem).setAlphabeticShortcut(c, i);
        } else {
            f1051a.mo247a(menuItem, c, i);
        }
    }

    public static void m1816b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0303b) {
            ((C0303b) menuItem).mo505b(charSequence);
        } else {
            f1051a.mo252b(menuItem, charSequence);
        }
    }
}
