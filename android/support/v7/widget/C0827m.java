package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p003b.p004a.C0031c;
import android.support.p003b.p004a.C0045i;
import android.support.v4.p005c.C0288a;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.p013b.C0190a;
import android.support.v4.p018g.C0332a;
import android.support.v4.p018g.C0338f;
import android.support.v4.p018g.C0339g;
import android.support.v4.p018g.C0351m;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0521c;
import android.support.v7.p021a.C0529a.C0523e;
import android.support.v7.p023c.p024a.C0608b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class C0827m {
    private static final Mode f2760a = Mode.SRC_IN;
    private static C0827m f2761b;
    private static final C0825b f2762c = new C0825b(6);
    private static final int[] f2763d = new int[]{C0523e.abc_textfield_search_default_mtrl_alpha, C0523e.abc_textfield_default_mtrl_alpha, C0523e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f2764e = new int[]{C0523e.abc_ic_commit_search_api_mtrl_alpha, C0523e.abc_seekbar_tick_mark_material, C0523e.abc_ic_menu_share_mtrl_alpha, C0523e.abc_ic_menu_copy_mtrl_am_alpha, C0523e.abc_ic_menu_cut_mtrl_alpha, C0523e.abc_ic_menu_selectall_mtrl_alpha, C0523e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f2765f = new int[]{C0523e.abc_textfield_activated_mtrl_alpha, C0523e.abc_textfield_search_activated_mtrl_alpha, C0523e.abc_cab_background_top_mtrl_alpha, C0523e.abc_text_cursor_material, C0523e.abc_text_select_handle_left_mtrl_dark, C0523e.abc_text_select_handle_middle_mtrl_dark, C0523e.abc_text_select_handle_right_mtrl_dark, C0523e.abc_text_select_handle_left_mtrl_light, C0523e.abc_text_select_handle_middle_mtrl_light, C0523e.abc_text_select_handle_right_mtrl_light};
    private static final int[] f2766g = new int[]{C0523e.abc_popup_background_mtrl_mult, C0523e.abc_cab_background_internal_bg, C0523e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f2767h = new int[]{C0523e.abc_tab_indicator_material, C0523e.abc_textfield_search_material};
    private static final int[] f2768i = new int[]{C0523e.abc_btn_check_material, C0523e.abc_btn_radio_material};
    private WeakHashMap<Context, C0351m<ColorStateList>> f2769j;
    private C0332a<String, C0823c> f2770k;
    private C0351m<String> f2771l;
    private final Object f2772m = new Object();
    private final WeakHashMap<Context, C0338f<WeakReference<ConstantState>>> f2773n = new WeakHashMap(0);
    private TypedValue f2774o;
    private boolean f2775p;

    private interface C0823c {
        Drawable mo785a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class C0824a implements C0823c {
        C0824a() {
        }

        public Drawable mo785a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0031c.m48a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class C0825b extends C0339g<Integer, PorterDuffColorFilter> {
        public C0825b(int i) {
            super(i);
        }

        private static int m4719b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter m4720a(int i, Mode mode) {
            return (PorterDuffColorFilter) m1649a((Object) Integer.valueOf(C0825b.m4719b(i, mode)));
        }

        PorterDuffColorFilter m4721a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m1650a(Integer.valueOf(C0825b.m4719b(i, mode)), porterDuffColorFilter);
        }
    }

    private static class C0826d implements C0823c {
        C0826d() {
        }

        public Drawable mo785a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0045i.m112a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long m4723a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    static Mode m4724a(int i) {
        return i == C0523e.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public static PorterDuffColorFilter m4725a(int i, Mode mode) {
        PorterDuffColorFilter a = f2762c.m4720a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f2762c.m4721a(i, mode, a);
        return a;
    }

    private static PorterDuffColorFilter m4726a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : C0827m.m4725a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable m4727a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m4752b(context, i);
        if (b != null) {
            if (al.m4291b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0279a.m1431f(drawable);
            C0279a.m1421a(drawable, b);
            Mode a = C0827m.m4724a(i);
            if (a == null) {
                return drawable;
            }
            C0279a.m1424a(drawable, a);
            return drawable;
        } else if (i == C0523e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C0827m.m4731a(r0.findDrawableByLayerId(16908288), bh.m4501a(context, C0519a.colorControlNormal), f2760a);
            C0827m.m4731a(r0.findDrawableByLayerId(16908303), bh.m4501a(context, C0519a.colorControlNormal), f2760a);
            C0827m.m4731a(r0.findDrawableByLayerId(16908301), bh.m4501a(context, C0519a.colorControlActivated), f2760a);
            return drawable;
        } else if (i != C0523e.abc_ratingbar_material && i != C0523e.abc_ratingbar_indicator_material && i != C0523e.abc_ratingbar_small_material) {
            return (C0827m.m4735a(context, i, drawable) || !z) ? drawable : null;
        } else {
            r0 = (LayerDrawable) drawable;
            C0827m.m4731a(r0.findDrawableByLayerId(16908288), bh.m4505c(context, C0519a.colorControlNormal), f2760a);
            C0827m.m4731a(r0.findDrawableByLayerId(16908303), bh.m4501a(context, C0519a.colorControlActivated), f2760a);
            C0827m.m4731a(r0.findDrawableByLayerId(16908301), bh.m4501a(context, C0519a.colorControlActivated), f2760a);
            return drawable;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m4728a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.f2772m;
        monitor-enter(r3);
        r0 = r4.f2773n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.p018g.C0338f) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.m1639a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.m1644b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.m.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static C0827m m4729a() {
        if (f2761b == null) {
            f2761b = new C0827m();
            C0827m.m4733a(f2761b);
        }
        return f2761b;
    }

    private void m4730a(Context context, int i, ColorStateList colorStateList) {
        if (this.f2769j == null) {
            this.f2769j = new WeakHashMap();
        }
        C0351m c0351m = (C0351m) this.f2769j.get(context);
        if (c0351m == null) {
            c0351m = new C0351m();
            this.f2769j.put(context, c0351m);
        }
        c0351m.m1675c(i, colorStateList);
    }

    private static void m4731a(Drawable drawable, int i, Mode mode) {
        if (al.m4291b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2760a;
        }
        drawable.setColorFilter(C0827m.m4725a(i, mode));
    }

    static void m4732a(Drawable drawable, bk bkVar, int[] iArr) {
        if (!al.m4291b(drawable) || drawable.mutate() == drawable) {
            if (bkVar.f2624d || bkVar.f2623c) {
                drawable.setColorFilter(C0827m.m4726a(bkVar.f2624d ? bkVar.f2621a : null, bkVar.f2623c ? bkVar.f2622b : f2760a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static void m4733a(C0827m c0827m) {
        if (VERSION.SDK_INT < 24) {
            c0827m.m4734a("vector", new C0826d());
            if (VERSION.SDK_INT >= 11) {
                c0827m.m4734a("animated-vector", new C0824a());
            }
        }
    }

    private void m4734a(String str, C0823c c0823c) {
        if (this.f2770k == null) {
            this.f2770k = new C0332a();
        }
        this.f2770k.put(str, c0823c);
    }

    static boolean m4735a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f2760a;
        if (C0827m.m4738a(f2763d, i)) {
            i2 = C0519a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0827m.m4738a(f2765f, i)) {
            i2 = C0519a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0827m.m4738a(f2766g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0523e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == C0523e.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            i3 = -1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (al.m4291b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0827m.m4725a(bh.m4501a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private boolean m4736a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f2772m) {
            C0338f c0338f = (C0338f) this.f2773n.get(context);
            if (c0338f == null) {
                c0338f = new C0338f();
                this.f2773n.put(context, c0338f);
            }
            c0338f.m1645b(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean m4737a(Drawable drawable) {
        return (drawable instanceof C0045i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean m4738a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList m4739b(Context context) {
        return m4746f(context, bh.m4501a(context, C0519a.colorButtonNormal));
    }

    private ColorStateList m4740c(Context context) {
        return m4746f(context, 0);
    }

    private Drawable m4741c(Context context, int i) {
        if (this.f2774o == null) {
            this.f2774o = new TypedValue();
        }
        TypedValue typedValue = this.f2774o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0827m.m4723a(typedValue);
        Drawable a2 = m4728a(context, a);
        if (a2 == null) {
            if (i == C0523e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m4748a(context, C0523e.abc_cab_background_internal_bg), m4748a(context, C0523e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m4736a(context, a, a2);
            }
        }
        return a2;
    }

    private ColorStateList m4742d(Context context) {
        return m4746f(context, bh.m4501a(context, C0519a.colorAccent));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m4743d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f2770k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f2770k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f2771l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f2771l;
        r0 = r0.m1668a(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f2770k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.support.v4.g.m;
        r0.<init>();
        r9.f2771l = r0;
    L_0x0036:
        r0 = r9.f2774o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f2774o = r0;
    L_0x0041:
        r2 = r9.f2774o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C0827m.m4723a(r2);
        r1 = r9.m4728a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f2771l;
        r2 = "appcompat_skip_skip";
        r1.m1675c(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2771l;	 Catch:{ Exception -> 0x0082 }
        r7.m1675c(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2770k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C0827m.C0823c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.mo785a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m4736a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.m.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList m4744e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = bh.m4504b(context, C0519a.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = bh.f2607a;
            iArr2[0] = bh.m4505c(context, C0519a.colorSwitchThumbNormal);
            iArr[1] = bh.f2611e;
            iArr2[1] = bh.m4501a(context, C0519a.colorControlActivated);
            iArr[2] = bh.f2614h;
            iArr2[2] = bh.m4501a(context, C0519a.colorSwitchThumbNormal);
        } else {
            iArr[0] = bh.f2607a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = bh.f2611e;
            iArr2[1] = bh.m4501a(context, C0519a.colorControlActivated);
            iArr[2] = bh.f2614h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList m4745e(Context context, int i) {
        if (this.f2769j == null) {
            return null;
        }
        C0351m c0351m = (C0351m) this.f2769j.get(context);
        return c0351m != null ? (ColorStateList) c0351m.m1668a(i) : null;
    }

    private ColorStateList m4746f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = bh.m4501a(context, C0519a.colorControlHighlight);
        int c = bh.m4505c(context, C0519a.colorButtonNormal);
        r0[0] = bh.f2607a;
        r1[0] = c;
        r0[1] = bh.f2610d;
        r1[1] = C0288a.m1447a(a, i);
        r0[2] = bh.f2608b;
        r1[2] = C0288a.m1447a(a, i);
        r0[3] = bh.f2614h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private void m4747f(Context context) {
        if (!this.f2775p) {
            this.f2775p = true;
            Drawable a = m4748a(context, C0523e.abc_vector_test);
            if (a == null || !C0827m.m4737a(a)) {
                this.f2775p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public Drawable m4748a(Context context, int i) {
        return m4749a(context, i, false);
    }

    Drawable m4749a(Context context, int i, boolean z) {
        m4747f(context);
        Drawable d = m4743d(context, i);
        if (d == null) {
            d = m4741c(context, i);
        }
        if (d == null) {
            d = C0190a.m865a(context, i);
        }
        if (d != null) {
            d = m4727a(context, i, z, d);
        }
        if (d != null) {
            al.m4290a(d);
        }
        return d;
    }

    Drawable m4750a(Context context, br brVar, int i) {
        Drawable d = m4743d(context, i);
        if (d == null) {
            d = brVar.m4593a(i);
        }
        return d != null ? m4727a(context, i, false, d) : null;
    }

    public void m4751a(Context context) {
        synchronized (this.f2772m) {
            C0338f c0338f = (C0338f) this.f2773n.get(context);
            if (c0338f != null) {
                c0338f.m1647c();
            }
        }
    }

    ColorStateList m4752b(Context context, int i) {
        ColorStateList e = m4745e(context, i);
        if (e == null) {
            if (i == C0523e.abc_edit_text_material) {
                e = C0608b.m2860a(context, C0521c.abc_tint_edittext);
            } else if (i == C0523e.abc_switch_track_mtrl_alpha) {
                e = C0608b.m2860a(context, C0521c.abc_tint_switch_track);
            } else if (i == C0523e.abc_switch_thumb_material) {
                e = m4744e(context);
            } else if (i == C0523e.abc_btn_default_mtrl_shape) {
                e = m4739b(context);
            } else if (i == C0523e.abc_btn_borderless_material) {
                e = m4740c(context);
            } else if (i == C0523e.abc_btn_colored_material) {
                e = m4742d(context);
            } else if (i == C0523e.abc_spinner_mtrl_am_alpha || i == C0523e.abc_spinner_textfield_background_material) {
                e = C0608b.m2860a(context, C0521c.abc_tint_spinner);
            } else if (C0827m.m4738a(f2764e, i)) {
                e = bh.m4504b(context, C0519a.colorControlNormal);
            } else if (C0827m.m4738a(f2767h, i)) {
                e = C0608b.m2860a(context, C0521c.abc_tint_default);
            } else if (C0827m.m4738a(f2768i, i)) {
                e = C0608b.m2860a(context, C0521c.abc_tint_btn_checkable);
            } else if (i == C0523e.abc_seekbar_thumb_material) {
                e = C0608b.m2860a(context, C0521c.abc_tint_seek_thumb);
            }
            if (e != null) {
                m4730a(context, i, e);
            }
        }
        return e;
    }
}
