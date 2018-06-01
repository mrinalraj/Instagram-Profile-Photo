package android.support.v4.p008h;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class C0425s {
    static final C0414j f1070a;

    static class C0414j {
        static Field f1059b;
        static boolean f1060c = false;
        private static Field f1061d;
        private static boolean f1062e;
        private static Field f1063f;
        private static boolean f1064g;
        private static WeakHashMap<View, String> f1065h;
        WeakHashMap<View, C0433u> f1066a = null;

        C0414j() {
        }

        private static void m1850A(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        long m1851a() {
            return ValueAnimator.getFrameDelay();
        }

        public C0435y mo276a(View view, C0435y c0435y) {
            return c0435y;
        }

        public void mo277a(View view, float f) {
        }

        public void mo254a(View view, int i) {
        }

        public void mo290a(View view, int i, int i2) {
        }

        public void mo266a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void mo278a(View view, ColorStateList colorStateList) {
            if (view instanceof C0094q) {
                ((C0094q) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void mo279a(View view, Mode mode) {
            if (view instanceof C0094q) {
                ((C0094q) view).setSupportBackgroundTintMode(mode);
            }
        }

        public void mo255a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public void m1860a(View view, C0067b c0067b) {
            view.setAccessibilityDelegate(c0067b == null ? null : c0067b.m156a());
        }

        public void mo280a(View view, C0097o c0097o) {
        }

        public void mo256a(View view, Runnable runnable) {
            view.postDelayed(runnable, m1851a());
        }

        public void mo257a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, m1851a() + j);
        }

        public boolean mo253a(View view) {
            return false;
        }

        public void mo273b(View view, int i) {
        }

        public boolean mo258b(View view) {
            return false;
        }

        public void mo259c(View view) {
            view.postInvalidate();
        }

        public void mo281c(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                C0414j.m1850A(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    C0414j.m1850A((View) parent);
                }
            }
        }

        public int mo260d(View view) {
            return 0;
        }

        public void mo282d(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                C0414j.m1850A(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    C0414j.m1850A((View) parent);
                }
            }
        }

        public int mo261e(View view) {
            if (!f1062e) {
                try {
                    f1061d = View.class.getDeclaredField("mMinWidth");
                    f1061d.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f1062e = true;
            }
            if (f1061d != null) {
                try {
                    return ((Integer) f1061d.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        public int mo262f(View view) {
            if (!f1064g) {
                try {
                    f1063f = View.class.getDeclaredField("mMinHeight");
                    f1063f.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f1064g = true;
            }
            if (f1063f != null) {
                try {
                    return ((Integer) f1063f.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        public void mo263g(View view) {
        }

        public boolean mo264h(View view) {
            return false;
        }

        public boolean mo265i(View view) {
            return true;
        }

        public int mo267j(View view) {
            return 0;
        }

        public int mo268k(View view) {
            return view.getPaddingLeft();
        }

        public int mo269l(View view) {
            return view.getPaddingRight();
        }

        public int mo270m(View view) {
            return 0;
        }

        public boolean mo271n(View view) {
            return false;
        }

        public Display mo272o(View view) {
            return mo275q(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
        }

        public boolean mo274p(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean mo275q(View view) {
            return view.getWindowToken() != null;
        }

        public String mo283r(View view) {
            return f1065h == null ? null : (String) f1065h.get(view);
        }

        public float mo284s(View view) {
            return 0.0f;
        }

        public float mo285t(View view) {
            return 0.0f;
        }

        public void mo286u(View view) {
            if (view instanceof C0071i) {
                ((C0071i) view).stopNestedScroll();
            }
        }

        public ColorStateList mo287v(View view) {
            return view instanceof C0094q ? ((C0094q) view).getSupportBackgroundTintList() : null;
        }

        public Mode mo288w(View view) {
            return view instanceof C0094q ? ((C0094q) view).getSupportBackgroundTintMode() : null;
        }

        public float mo289x(View view) {
            return mo285t(view) + mo284s(view);
        }

        public boolean m1891y(View view) {
            boolean z = true;
            if (f1060c) {
                return false;
            }
            if (f1059b == null) {
                try {
                    f1059b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f1059b.setAccessible(true);
                } catch (Throwable th) {
                    f1060c = true;
                    return false;
                }
            }
            try {
                if (f1059b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f1060c = true;
                return false;
            }
        }

        public C0433u m1892z(View view) {
            if (this.f1066a == null) {
                this.f1066a = new WeakHashMap();
            }
            C0433u c0433u = (C0433u) this.f1066a.get(view);
            if (c0433u != null) {
                return c0433u;
            }
            c0433u = new C0433u(view);
            this.f1066a.put(view, c0433u);
            return c0433u;
        }
    }

    static class C0415a extends C0414j {
        C0415a() {
        }

        public boolean mo253a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class C0416b extends C0415a {
        C0416b() {
        }

        public void mo254a(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public void mo255a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void mo256a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public void mo257a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public boolean mo258b(View view) {
            return view.hasTransientState();
        }

        public void mo259c(View view) {
            view.postInvalidateOnAnimation();
        }

        public int mo260d(View view) {
            return view.getImportantForAccessibility();
        }

        public int mo261e(View view) {
            return view.getMinimumWidth();
        }

        public int mo262f(View view) {
            return view.getMinimumHeight();
        }

        public void mo263g(View view) {
            view.requestFitSystemWindows();
        }

        public boolean mo264h(View view) {
            return view.getFitsSystemWindows();
        }

        public boolean mo265i(View view) {
            return view.hasOverlappingRendering();
        }
    }

    static class C0417c extends C0416b {
        C0417c() {
        }

        public void mo266a(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public int mo267j(View view) {
            return view.getLayoutDirection();
        }

        public int mo268k(View view) {
            return view.getPaddingStart();
        }

        public int mo269l(View view) {
            return view.getPaddingEnd();
        }

        public int mo270m(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public boolean mo271n(View view) {
            return view.isPaddingRelative();
        }

        public Display mo272o(View view) {
            return view.getDisplay();
        }
    }

    static class C0418d extends C0417c {
        C0418d() {
        }
    }

    static class C0419e extends C0418d {
        C0419e() {
        }

        public void mo254a(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public void mo273b(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        public boolean mo274p(View view) {
            return view.isLaidOut();
        }

        public boolean mo275q(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class C0421f extends C0419e {
        private static ThreadLocal<Rect> f1069d;

        C0421f() {
        }

        private static Rect m1917b() {
            if (f1069d == null) {
                f1069d = new ThreadLocal();
            }
            Rect rect = (Rect) f1069d.get();
            if (rect == null) {
                rect = new Rect();
                f1069d.set(rect);
            }
            rect.setEmpty();
            return rect;
        }

        public C0435y mo276a(View view, C0435y c0435y) {
            Object obj = (WindowInsets) C0435y.m2027a(c0435y);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
            if (onApplyWindowInsets != obj) {
                obj = new WindowInsets(onApplyWindowInsets);
            }
            return C0435y.m2026a(obj);
        }

        public void mo277a(View view, float f) {
            view.setElevation(f);
        }

        public void mo278a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void mo279a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void mo280a(View view, final C0097o c0097o) {
            if (c0097o == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                    final /* synthetic */ C0421f f1068b;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) C0435y.m2027a(c0097o.mo81a(view, C0435y.m2026a((Object) windowInsets)));
                    }
                });
            }
        }

        public void mo281c(View view, int i) {
            Object obj;
            Rect b = C0421f.m1917b();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.mo281c(view, i);
            if (obj != null && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        }

        public void mo282d(View view, int i) {
            Object obj;
            Rect b = C0421f.m1917b();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.mo282d(view, i);
            if (obj != null && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        }

        public void mo263g(View view) {
            view.requestApplyInsets();
        }

        public String mo283r(View view) {
            return view.getTransitionName();
        }

        public float mo284s(View view) {
            return view.getElevation();
        }

        public float mo285t(View view) {
            return view.getTranslationZ();
        }

        public void mo286u(View view) {
            view.stopNestedScroll();
        }

        public ColorStateList mo287v(View view) {
            return view.getBackgroundTintList();
        }

        public Mode mo288w(View view) {
            return view.getBackgroundTintMode();
        }

        public float mo289x(View view) {
            return view.getZ();
        }
    }

    static class C0422g extends C0421f {
        C0422g() {
        }

        public void mo290a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        public void mo281c(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public void mo282d(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    static class C0423h extends C0422g {
        C0423h() {
        }
    }

    static class C0424i extends C0423h {
        C0424i() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1070a = new C0424i();
        } else if (VERSION.SDK_INT >= 24) {
            f1070a = new C0423h();
        } else if (VERSION.SDK_INT >= 23) {
            f1070a = new C0422g();
        } else if (VERSION.SDK_INT >= 21) {
            f1070a = new C0421f();
        } else if (VERSION.SDK_INT >= 19) {
            f1070a = new C0419e();
        } else if (VERSION.SDK_INT >= 18) {
            f1070a = new C0418d();
        } else if (VERSION.SDK_INT >= 17) {
            f1070a = new C0417c();
        } else if (VERSION.SDK_INT >= 16) {
            f1070a = new C0416b();
        } else if (VERSION.SDK_INT >= 15) {
            f1070a = new C0415a();
        } else {
            f1070a = new C0414j();
        }
    }

    public static boolean m1936A(View view) {
        return f1070a.mo275q(view);
    }

    public static boolean m1937B(View view) {
        return f1070a.mo253a(view);
    }

    public static Display m1938C(View view) {
        return f1070a.mo272o(view);
    }

    @Deprecated
    public static int m1939a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    @Deprecated
    public static int m1940a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static C0435y m1941a(View view, C0435y c0435y) {
        return f1070a.mo276a(view, c0435y);
    }

    @Deprecated
    public static void m1942a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m1943a(View view, int i, int i2) {
        f1070a.mo290a(view, i, i2);
    }

    public static void m1944a(View view, int i, int i2, int i3, int i4) {
        f1070a.mo266a(view, i, i2, i3, i4);
    }

    public static void m1945a(View view, ColorStateList colorStateList) {
        f1070a.mo278a(view, colorStateList);
    }

    public static void m1946a(View view, Mode mode) {
        f1070a.mo279a(view, mode);
    }

    public static void m1947a(View view, Drawable drawable) {
        f1070a.mo255a(view, drawable);
    }

    public static void m1948a(View view, C0067b c0067b) {
        f1070a.m1860a(view, c0067b);
    }

    public static void m1949a(View view, C0097o c0097o) {
        f1070a.mo280a(view, c0097o);
    }

    public static void m1950a(View view, Runnable runnable) {
        f1070a.mo256a(view, runnable);
    }

    public static void m1951a(View view, Runnable runnable, long j) {
        f1070a.mo257a(view, runnable, j);
    }

    @Deprecated
    public static void m1952a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean m1953a(View view) {
        return f1070a.m1891y(view);
    }

    @Deprecated
    public static boolean m1954a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static void m1955b(View view, float f) {
        view.setTranslationY(f);
    }

    public static boolean m1956b(View view) {
        return f1070a.mo258b(view);
    }

    @Deprecated
    public static boolean m1957b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m1958c(View view) {
        f1070a.mo259c(view);
    }

    @Deprecated
    public static void m1959c(View view, float f) {
        view.setAlpha(f);
    }

    public static void m1960c(View view, int i) {
        f1070a.mo254a(view, i);
    }

    public static int m1961d(View view) {
        return f1070a.mo260d(view);
    }

    public static void m1962d(View view, float f) {
        f1070a.mo277a(view, f);
    }

    public static void m1963d(View view, int i) {
        f1070a.mo273b(view, i);
    }

    @Deprecated
    public static float m1964e(View view) {
        return view.getAlpha();
    }

    public static void m1965e(View view, int i) {
        f1070a.mo282d(view, i);
    }

    public static int m1966f(View view) {
        return f1070a.mo267j(view);
    }

    public static void m1967f(View view, int i) {
        f1070a.mo281c(view, i);
    }

    @Deprecated
    public static int m1968g(View view) {
        return view.getMeasuredState();
    }

    public static int m1969h(View view) {
        return f1070a.mo268k(view);
    }

    public static int m1970i(View view) {
        return f1070a.mo269l(view);
    }

    @Deprecated
    public static float m1971j(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float m1972k(View view) {
        return view.getTranslationY();
    }

    @Deprecated
    public static Matrix m1973l(View view) {
        return view.getMatrix();
    }

    public static int m1974m(View view) {
        return f1070a.mo261e(view);
    }

    public static int m1975n(View view) {
        return f1070a.mo262f(view);
    }

    public static C0433u m1976o(View view) {
        return f1070a.m1892z(view);
    }

    public static String m1977p(View view) {
        return f1070a.mo283r(view);
    }

    public static int m1978q(View view) {
        return f1070a.mo270m(view);
    }

    public static void m1979r(View view) {
        f1070a.mo263g(view);
    }

    public static boolean m1980s(View view) {
        return f1070a.mo264h(view);
    }

    public static boolean m1981t(View view) {
        return f1070a.mo265i(view);
    }

    public static boolean m1982u(View view) {
        return f1070a.mo271n(view);
    }

    public static ColorStateList m1983v(View view) {
        return f1070a.mo287v(view);
    }

    public static Mode m1984w(View view) {
        return f1070a.mo288w(view);
    }

    public static void m1985x(View view) {
        f1070a.mo286u(view);
    }

    public static boolean m1986y(View view) {
        return f1070a.mo274p(view);
    }

    public static float m1987z(View view) {
        return f1070a.mo289x(view);
    }
}
