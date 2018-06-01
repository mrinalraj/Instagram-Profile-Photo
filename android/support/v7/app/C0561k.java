package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p008h.C0097o;
import android.support.v4.p008h.C0120w;
import android.support.v4.p008h.C0401e;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0433u;
import android.support.v4.p008h.C0435y;
import android.support.v4.p012a.C0259w;
import android.support.v4.widget.C0505i;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0521c;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.p021a.C0529a.C0527i;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.p023c.p024a.C0608b;
import android.support.v7.view.C0597b;
import android.support.v7.view.C0597b.C0580a;
import android.support.v7.view.C0614d;
import android.support.v7.view.C0615e;
import android.support.v7.view.menu.C0072p;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.view.menu.C0641f;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0643h.C0560a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0827m;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.C0572a;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ai;
import android.support.v7.widget.an;
import android.support.v7.widget.an.C0570a;
import android.support.v7.widget.br;
import android.support.v7.widget.bt;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

class C0561k extends C0556f implements C0560a, Factory2 {
    private static final boolean f1421t = (VERSION.SDK_INT < 21);
    private View f1422A;
    private boolean f1423B;
    private boolean f1424C;
    private boolean f1425D;
    private C0583d[] f1426E;
    private C0583d f1427F;
    private boolean f1428G;
    private final Runnable f1429H = new C05681(this);
    private boolean f1430I;
    private Rect f1431J;
    private Rect f1432K;
    private C0586m f1433L;
    C0597b f1434m;
    ActionBarContextView f1435n;
    PopupWindow f1436o;
    Runnable f1437p;
    C0433u f1438q = null;
    boolean f1439r;
    int f1440s;
    private ai f1441u;
    private C0578a f1442v;
    private C0584e f1443w;
    private boolean f1444x;
    private ViewGroup f1445y;
    private TextView f1446z;

    class C05681 implements Runnable {
        final /* synthetic */ C0561k f1458a;

        C05681(C0561k c0561k) {
            this.f1458a = c0561k;
        }

        public void run() {
            if ((this.f1458a.f1440s & 1) != 0) {
                this.f1458a.m2675f(0);
            }
            if ((this.f1458a.f1440s & 4096) != 0) {
                this.f1458a.m2675f(108);
            }
            this.f1458a.f1439r = false;
            this.f1458a.f1440s = 0;
        }
    }

    class C05692 implements C0097o {
        final /* synthetic */ C0561k f1459a;

        C05692(C0561k c0561k) {
            this.f1459a = c0561k;
        }

        public C0435y mo81a(View view, C0435y c0435y) {
            int b = c0435y.m2030b();
            int g = this.f1459a.m2676g(b);
            if (b != g) {
                c0435y = c0435y.m2029a(c0435y.m2028a(), g, c0435y.m2031c(), c0435y.m2032d());
            }
            return C0425s.m1941a(view, c0435y);
        }
    }

    class C05713 implements C0570a {
        final /* synthetic */ C0561k f1460a;

        C05713(C0561k c0561k) {
            this.f1460a = c0561k;
        }

        public void mo449a(Rect rect) {
            rect.top = this.f1460a.m2676g(rect.top);
        }
    }

    class C05734 implements C0572a {
        final /* synthetic */ C0561k f1461a;

        C05734(C0561k c0561k) {
            this.f1461a = c0561k;
        }

        public void mo450a() {
        }

        public void mo451b() {
            this.f1461a.m2683v();
        }
    }

    class C05755 implements Runnable {
        final /* synthetic */ C0561k f1463a;

        class C05741 extends C0120w {
            final /* synthetic */ C05755 f1462a;

            C05741(C05755 c05755) {
                this.f1462a = c05755;
            }

            public void mo100a(View view) {
                this.f1462a.f1463a.f1435n.setVisibility(0);
            }

            public void mo101b(View view) {
                this.f1462a.f1463a.f1435n.setAlpha(1.0f);
                this.f1462a.f1463a.f1438q.m2016a(null);
                this.f1462a.f1463a.f1438q = null;
            }
        }

        C05755(C0561k c0561k) {
            this.f1463a = c0561k;
        }

        public void run() {
            this.f1463a.f1436o.showAtLocation(this.f1463a.f1435n, 55, 0, 0);
            this.f1463a.m2681t();
            if (this.f1463a.m2680s()) {
                this.f1463a.f1435n.setAlpha(0.0f);
                this.f1463a.f1438q = C0425s.m1976o(this.f1463a.f1435n).m2014a(1.0f);
                this.f1463a.f1438q.m2016a(new C05741(this));
                return;
            }
            this.f1463a.f1435n.setAlpha(1.0f);
            this.f1463a.f1435n.setVisibility(0);
        }
    }

    class C05766 extends C0120w {
        final /* synthetic */ C0561k f1464a;

        C05766(C0561k c0561k) {
            this.f1464a = c0561k;
        }

        public void mo100a(View view) {
            this.f1464a.f1435n.setVisibility(0);
            this.f1464a.f1435n.sendAccessibilityEvent(32);
            if (this.f1464a.f1435n.getParent() instanceof View) {
                C0425s.m1979r((View) this.f1464a.f1435n.getParent());
            }
        }

        public void mo101b(View view) {
            this.f1464a.f1435n.setAlpha(1.0f);
            this.f1464a.f1438q.m2016a(null);
            this.f1464a.f1438q = null;
        }
    }

    private final class C0578a implements C0577a {
        final /* synthetic */ C0561k f1465a;

        C0578a(C0561k c0561k) {
            this.f1465a = c0561k;
        }

        public void mo452a(C0643h c0643h, boolean z) {
            this.f1465a.m2664b(c0643h);
        }

        public boolean mo453a(C0643h c0643h) {
            Callback q = this.f1465a.m2622q();
            if (q != null) {
                q.onMenuOpened(108, c0643h);
            }
            return true;
        }
    }

    class C0581b implements C0580a {
        final /* synthetic */ C0561k f1467a;
        private C0580a f1468b;

        class C05791 extends C0120w {
            final /* synthetic */ C0581b f1466a;

            C05791(C0581b c0581b) {
                this.f1466a = c0581b;
            }

            public void mo101b(View view) {
                this.f1466a.f1467a.f1435n.setVisibility(8);
                if (this.f1466a.f1467a.f1436o != null) {
                    this.f1466a.f1467a.f1436o.dismiss();
                } else if (this.f1466a.f1467a.f1435n.getParent() instanceof View) {
                    C0425s.m1979r((View) this.f1466a.f1467a.f1435n.getParent());
                }
                this.f1466a.f1467a.f1435n.removeAllViews();
                this.f1466a.f1467a.f1438q.m2016a(null);
                this.f1466a.f1467a.f1438q = null;
            }
        }

        public C0581b(C0561k c0561k, C0580a c0580a) {
            this.f1467a = c0561k;
            this.f1468b = c0580a;
        }

        public void mo454a(C0597b c0597b) {
            this.f1468b.mo454a(c0597b);
            if (this.f1467a.f1436o != null) {
                this.f1467a.b.getDecorView().removeCallbacks(this.f1467a.f1437p);
            }
            if (this.f1467a.f1435n != null) {
                this.f1467a.m2681t();
                this.f1467a.f1438q = C0425s.m1976o(this.f1467a.f1435n).m2014a(0.0f);
                this.f1467a.f1438q.m2016a(new C05791(this));
            }
            if (this.f1467a.e != null) {
                this.f1467a.e.mo394b(this.f1467a.f1434m);
            }
            this.f1467a.f1434m = null;
        }

        public boolean mo455a(C0597b c0597b, Menu menu) {
            return this.f1468b.mo455a(c0597b, menu);
        }

        public boolean mo456a(C0597b c0597b, MenuItem menuItem) {
            return this.f1468b.mo456a(c0597b, menuItem);
        }

        public boolean mo457b(C0597b c0597b, Menu menu) {
            return this.f1468b.mo457b(c0597b, menu);
        }
    }

    private class C0582c extends ContentFrameLayout {
        final /* synthetic */ C0561k f1477a;

        public C0582c(C0561k c0561k, Context context) {
            this.f1477a = c0561k;
            super(context);
        }

        private boolean m2731a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1477a.mo434a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m2731a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f1477a.m2673e(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0608b.m2863b(getContext(), i));
        }
    }

    protected static final class C0583d {
        int f1478a;
        int f1479b;
        int f1480c;
        int f1481d;
        int f1482e;
        int f1483f;
        ViewGroup f1484g;
        View f1485h;
        View f1486i;
        C0643h f1487j;
        C0641f f1488k;
        Context f1489l;
        boolean f1490m;
        boolean f1491n;
        boolean f1492o;
        public boolean f1493p;
        boolean f1494q = false;
        boolean f1495r;
        Bundle f1496s;

        C0583d(int i) {
            this.f1478a = i;
        }

        C0072p m2732a(C0577a c0577a) {
            if (this.f1487j == null) {
                return null;
            }
            if (this.f1488k == null) {
                this.f1488k = new C0641f(this.f1489l, C0525g.abc_list_menu_item_layout);
                this.f1488k.mo527a(c0577a);
                this.f1487j.m3087a(this.f1488k);
            }
            return this.f1488k.m3054a(this.f1484g);
        }

        void m2733a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0519a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0519a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0527i.Theme_AppCompat_CompactMenu, true);
            }
            Context c0614d = new C0614d(context, 0);
            c0614d.getTheme().setTo(newTheme);
            this.f1489l = c0614d;
            TypedArray obtainStyledAttributes = c0614d.obtainStyledAttributes(C0528j.AppCompatTheme);
            this.f1479b = obtainStyledAttributes.getResourceId(C0528j.AppCompatTheme_panelBackground, 0);
            this.f1483f = obtainStyledAttributes.getResourceId(C0528j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m2734a(C0643h c0643h) {
            if (c0643h != this.f1487j) {
                if (this.f1487j != null) {
                    this.f1487j.m3098b(this.f1488k);
                }
                this.f1487j = c0643h;
                if (c0643h != null && this.f1488k != null) {
                    c0643h.m3087a(this.f1488k);
                }
            }
        }

        public boolean m2735a() {
            return this.f1485h == null ? false : this.f1486i != null || this.f1488k.m3055a().getCount() > 0;
        }
    }

    private final class C0584e implements C0577a {
        final /* synthetic */ C0561k f1497a;

        C0584e(C0561k c0561k) {
            this.f1497a = c0561k;
        }

        public void mo452a(C0643h c0643h, boolean z) {
            Menu menu;
            Menu p = c0643h.mo567p();
            boolean z2 = p != c0643h;
            C0561k c0561k = this.f1497a;
            if (z2) {
                menu = p;
            }
            C0583d a = c0561k.m2644a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.f1497a.m2648a(a.f1478a, a, p);
                this.f1497a.m2652a(a, true);
                return;
            }
            this.f1497a.m2652a(a, z);
        }

        public boolean mo453a(C0643h c0643h) {
            if (c0643h == null && this.f1497a.h) {
                Callback q = this.f1497a.m2622q();
                if (!(q == null || this.f1497a.m2621p())) {
                    q.onMenuOpened(108, c0643h);
                }
            }
            return true;
        }
    }

    C0561k(Context context, Window window, C0548d c0548d) {
        super(context, window, c0548d);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2627a(android.support.v7.app.C0561k.C0583d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f1492o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m2621p();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f1478a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m2622q();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f1478a;
        r5 = r11.f1487j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m2652a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m2633b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f1484g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f1494q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f1484g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m2629a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f1484g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m2634c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m2735a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f1485h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f1479b;
        r4 = r11.f1484g;
        r4.setBackgroundResource(r0);
        r0 = r11.f1485h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f1485h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f1484g;
        r4 = r11.f1485h;
        r0.addView(r4, r1);
        r0 = r11.f1485h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f1485h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f1491n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1481d;
        r4 = r11.f1482e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f1480c;
        r0.gravity = r1;
        r1 = r11.f1483f;
        r0.windowAnimations = r1;
        r1 = r11.f1484g;
        r8.addView(r1, r0);
        r11.f1492o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f1494q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f1484g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f1484g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f1486i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f1486i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.k.a(android.support.v7.app.k$d, android.view.KeyEvent):void");
    }

    private void m2628a(C0643h c0643h, boolean z) {
        if (this.f1441u == null || !this.f1441u.mo579e() || (ViewConfiguration.get(this.a).hasPermanentMenuKey() && !this.f1441u.mo581g())) {
            C0583d a = m2643a(0, true);
            a.f1494q = true;
            m2652a(a, false);
            m2627a(a, null);
            return;
        }
        Callback q = m2622q();
        if (this.f1441u.mo580f() && z) {
            this.f1441u.mo583i();
            if (!m2621p()) {
                q.onPanelClosed(108, m2643a(0, true).f1487j);
            }
        } else if (q != null && !m2621p()) {
            if (this.f1439r && (this.f1440s & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f1429H);
                this.f1429H.run();
            }
            C0583d a2 = m2643a(0, true);
            if (a2.f1487j != null && !a2.f1495r && q.onPreparePanel(0, a2.f1486i, a2.f1487j)) {
                q.onMenuOpened(108, a2.f1487j);
                this.f1441u.mo582h();
            }
        }
    }

    private boolean m2629a(C0583d c0583d) {
        c0583d.m2733a(m2619n());
        c0583d.f1484g = new C0582c(this, c0583d.f1489l);
        c0583d.f1480c = 81;
        return true;
    }

    private boolean m2630a(C0583d c0583d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((c0583d.f1490m || m2633b(c0583d, keyEvent)) && c0583d.f1487j != null) {
                z = c0583d.f1487j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1441u == null) {
                m2652a(c0583d, true);
            }
        }
        return z;
    }

    private boolean m2631a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || C0425s.m1936A((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private boolean m2632b(C0583d c0583d) {
        Context c0614d;
        C0643h c0643h;
        Context context = this.a;
        if ((c0583d.f1478a == 0 || c0583d.f1478a == 108) && this.f1441u != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0519a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0519a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0519a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0614d = new C0614d(context, 0);
                c0614d.getTheme().setTo(theme3);
                c0643h = new C0643h(c0614d);
                c0643h.mo561a((C0560a) this);
                c0583d.m2734a(c0643h);
                return true;
            }
        }
        c0614d = context;
        c0643h = new C0643h(c0614d);
        c0643h.mo561a((C0560a) this);
        c0583d.m2734a(c0643h);
        return true;
    }

    private boolean m2633b(C0583d c0583d, KeyEvent keyEvent) {
        if (m2621p()) {
            return false;
        }
        if (c0583d.f1490m) {
            return true;
        }
        if (!(this.f1427F == null || this.f1427F == c0583d)) {
            m2652a(this.f1427F, false);
        }
        Callback q = m2622q();
        if (q != null) {
            c0583d.f1486i = q.onCreatePanelView(c0583d.f1478a);
        }
        boolean z = c0583d.f1478a == 0 || c0583d.f1478a == 108;
        if (z && this.f1441u != null) {
            this.f1441u.mo584j();
        }
        if (c0583d.f1486i == null && !(z && (m2618m() instanceof C0590o))) {
            if (c0583d.f1487j == null || c0583d.f1495r) {
                if (c0583d.f1487j == null && (!m2632b(c0583d) || c0583d.f1487j == null)) {
                    return false;
                }
                if (z && this.f1441u != null) {
                    if (this.f1442v == null) {
                        this.f1442v = new C0578a(this);
                    }
                    this.f1441u.mo578a(c0583d.f1487j, this.f1442v);
                }
                c0583d.f1487j.m3111g();
                if (q.onCreatePanelMenu(c0583d.f1478a, c0583d.f1487j)) {
                    c0583d.f1495r = false;
                } else {
                    c0583d.m2734a(null);
                    if (!z || this.f1441u == null) {
                        return false;
                    }
                    this.f1441u.mo578a(null, this.f1442v);
                    return false;
                }
            }
            c0583d.f1487j.m3111g();
            if (c0583d.f1496s != null) {
                c0583d.f1487j.m3096b(c0583d.f1496s);
                c0583d.f1496s = null;
            }
            if (q.onPreparePanel(0, c0583d.f1486i, c0583d.f1487j)) {
                c0583d.f1493p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                c0583d.f1487j.setQwertyMode(c0583d.f1493p);
                c0583d.f1487j.m3112h();
            } else {
                if (z && this.f1441u != null) {
                    this.f1441u.mo578a(null, this.f1442v);
                }
                c0583d.f1487j.m3112h();
                return false;
            }
        }
        c0583d.f1490m = true;
        c0583d.f1491n = false;
        this.f1427F = c0583d;
        return true;
    }

    private boolean m2634c(C0583d c0583d) {
        if (c0583d.f1486i != null) {
            c0583d.f1485h = c0583d.f1486i;
            return true;
        } else if (c0583d.f1487j == null) {
            return false;
        } else {
            if (this.f1443w == null) {
                this.f1443w = new C0584e(this);
            }
            c0583d.f1485h = (View) c0583d.m2732a(this.f1443w);
            return c0583d.f1485h != null;
        }
    }

    private void mo447d(int i) {
        this.f1440s |= 1 << i;
        if (!this.f1439r) {
            C0425s.m1950a(this.b.getDecorView(), this.f1429H);
            this.f1439r = true;
        }
    }

    private boolean m2636d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0583d a = m2643a(i, true);
            if (!a.f1492o) {
                return m2633b(a, keyEvent);
            }
        }
        return false;
    }

    private boolean m2637e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f1434m != null) {
            return false;
        }
        C0583d a = m2643a(i, true);
        if (i != 0 || this.f1441u == null || !this.f1441u.mo579e() || ViewConfiguration.get(this.a).hasPermanentMenuKey()) {
            boolean z2;
            if (a.f1492o || a.f1491n) {
                z2 = a.f1492o;
                m2652a(a, true);
                z = z2;
            } else {
                if (a.f1490m) {
                    if (a.f1495r) {
                        a.f1490m = false;
                        z2 = m2633b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m2627a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f1441u.mo580f()) {
            z = this.f1441u.mo583i();
        } else {
            if (!m2621p() && m2633b(a, keyEvent)) {
                z = this.f1441u.mo582h();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private int m2638h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void m2639w() {
        if (!this.f1444x) {
            this.f1445y = m2640x();
            CharSequence r = m2623r();
            if (!TextUtils.isEmpty(r)) {
                mo438b(r);
            }
            m2641y();
            m2656a(this.f1445y);
            this.f1444x = true;
            C0583d a = m2643a(0, false);
            if (!m2621p()) {
                if (a == null || a.f1487j == null) {
                    mo447d(108);
                }
            }
        }
    }

    private ViewGroup m2640x() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0528j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0528j.AppCompatTheme_windowNoTitle, false)) {
                mo440c(1);
            } else if (obtainStyledAttributes.getBoolean(C0528j.AppCompatTheme_windowActionBar, false)) {
                mo440c(108);
            }
            if (obtainStyledAttributes.getBoolean(C0528j.AppCompatTheme_windowActionBarOverlay, false)) {
                mo440c(109);
            }
            if (obtainStyledAttributes.getBoolean(C0528j.AppCompatTheme_windowActionModeOverlay, false)) {
                mo440c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0528j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2 = this.j ? (ViewGroup) from.inflate(C0525g.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(C0525g.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    C0425s.m1949a(view2, new C05692(this));
                    view = view2;
                } else {
                    ((an) view2).setOnFitSystemWindowsListener(new C05713(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0525g.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0519a.actionBarTheme, typedValue, true);
                r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0614d(this.a, typedValue.resourceId) : this.a).inflate(C0525g.abc_screen_toolbar, null);
                this.f1441u = (ai) r0.findViewById(C0524f.decor_content_parent);
                this.f1441u.setWindowCallback(m2622q());
                if (this.i) {
                    this.f1441u.mo577a(109);
                }
                if (this.f1423B) {
                    this.f1441u.mo577a(2);
                }
                if (this.f1424C) {
                    this.f1441u.mo577a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f1441u == null) {
                this.f1446z = (TextView) view.findViewById(C0524f.title);
            }
            bt.m4616b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0524f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new C05734(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void m2641y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1445y.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m2729a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0528j.AppCompatTheme);
        obtainStyledAttributes.getValue(C0528j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0528j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0528j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0528j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0528j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0528j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void m2642z() {
        if (this.f1444x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    protected C0583d m2643a(int i, boolean z) {
        Object obj = this.f1426E;
        if (obj == null || obj.length <= i) {
            Object obj2 = new C0583d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f1426E = obj2;
            obj = obj2;
        }
        C0583d c0583d = obj[i];
        if (c0583d != null) {
            return c0583d;
        }
        c0583d = new C0583d(i);
        obj[i] = c0583d;
        return c0583d;
    }

    C0583d m2644a(Menu menu) {
        C0583d[] c0583dArr = this.f1426E;
        int length = c0583dArr != null ? c0583dArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0583d c0583d = c0583dArr[i];
            if (c0583d != null && c0583d.f1487j == menu) {
                return c0583d;
            }
        }
        return null;
    }

    C0597b mo424a(C0580a c0580a) {
        C0597b c0597b;
        m2681t();
        if (this.f1434m != null) {
            this.f1434m.mo483c();
        }
        if (!(c0580a instanceof C0581b)) {
            c0580a = new C0581b(this, c0580a);
        }
        if (this.e == null || m2621p()) {
            c0597b = null;
        } else {
            try {
                c0597b = this.e.mo392a(c0580a);
            } catch (AbstractMethodError e) {
                c0597b = null;
            }
        }
        if (c0597b != null) {
            this.f1434m = c0597b;
        } else {
            if (this.f1435n == null) {
                if (this.k) {
                    Context c0614d;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0519a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0614d = new C0614d(this.a, 0);
                        c0614d.getTheme().setTo(newTheme);
                    } else {
                        c0614d = this.a;
                    }
                    this.f1435n = new ActionBarContextView(c0614d);
                    this.f1436o = new PopupWindow(c0614d, null, C0519a.actionModePopupWindowStyle);
                    C0505i.m2429a(this.f1436o, 2);
                    this.f1436o.setContentView(this.f1435n);
                    this.f1436o.setWidth(-1);
                    c0614d.getTheme().resolveAttribute(C0519a.actionBarSize, typedValue, true);
                    this.f1435n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0614d.getResources().getDisplayMetrics()));
                    this.f1436o.setHeight(-2);
                    this.f1437p = new C05755(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1445y.findViewById(C0524f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m2619n()));
                        this.f1435n = (ActionBarContextView) viewStubCompat.m4089a();
                    }
                }
            }
            if (this.f1435n != null) {
                m2681t();
                this.f1435n.m3233c();
                C0597b c0615e = new C0615e(this.f1435n.getContext(), this.f1435n, c0580a, this.f1436o == null);
                if (c0580a.mo455a(c0615e, c0615e.mo480b())) {
                    c0615e.mo484d();
                    this.f1435n.m3230a(c0615e);
                    this.f1434m = c0615e;
                    if (m2680s()) {
                        this.f1435n.setAlpha(0.0f);
                        this.f1438q = C0425s.m1976o(this.f1435n).m2014a(1.0f);
                        this.f1438q.m2016a(new C05766(this));
                    } else {
                        this.f1435n.setAlpha(1.0f);
                        this.f1435n.setVisibility(0);
                        this.f1435n.sendAccessibilityEvent(32);
                        if (this.f1435n.getParent() instanceof View) {
                            C0425s.m1979r((View) this.f1435n.getParent());
                        }
                    }
                    if (this.f1436o != null) {
                        this.b.getDecorView().post(this.f1437p);
                    }
                } else {
                    this.f1434m = null;
                }
            }
        }
        if (!(this.f1434m == null || this.e == null)) {
            this.e.mo393a(this.f1434m);
        }
        return this.f1434m;
    }

    public <T extends View> T mo425a(int i) {
        m2639w();
        return this.b.findViewById(i);
    }

    View mo445a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    void m2648a(int i, C0583d c0583d, Menu menu) {
        if (menu == null) {
            if (c0583d == null && i >= 0 && i < this.f1426E.length) {
                c0583d = this.f1426E[i];
            }
            if (c0583d != null) {
                menu = c0583d.f1487j;
            }
        }
        if ((c0583d == null || c0583d.f1492o) && !m2621p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    void mo426a(int i, Menu menu) {
        if (i == 108) {
            C0546a a = mo413a();
            if (a != null) {
                a.mo470e(false);
            }
        } else if (i == 0) {
            C0583d a2 = m2643a(i, true);
            if (a2.f1492o) {
                m2652a(a2, false);
            }
        }
    }

    public void mo427a(Configuration configuration) {
        if (this.h && this.f1444x) {
            C0546a a = mo413a();
            if (a != null) {
                a.mo460a(configuration);
            }
        }
        C0827m.m4729a().m4751a(this.a);
        mo420i();
    }

    public void mo428a(Bundle bundle) {
        if ((this.c instanceof Activity) && C0259w.m1329b((Activity) this.c) != null) {
            C0546a m = m2618m();
            if (m == null) {
                this.f1430I = true;
            } else {
                m.mo466c(true);
            }
        }
    }

    void m2652a(C0583d c0583d, boolean z) {
        if (z && c0583d.f1478a == 0 && this.f1441u != null && this.f1441u.mo580f()) {
            m2664b(c0583d.f1487j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !c0583d.f1492o || c0583d.f1484g == null)) {
            windowManager.removeView(c0583d.f1484g);
            if (z) {
                m2648a(c0583d.f1478a, c0583d, null);
            }
        }
        c0583d.f1490m = false;
        c0583d.f1491n = false;
        c0583d.f1492o = false;
        c0583d.f1485h = null;
        c0583d.f1494q = true;
        if (this.f1427F == c0583d) {
            this.f1427F = null;
        }
    }

    public void mo429a(C0643h c0643h) {
        m2628a(c0643h, true);
    }

    public void mo430a(View view) {
        m2639w();
        ViewGroup viewGroup = (ViewGroup) this.f1445y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void mo431a(View view, LayoutParams layoutParams) {
        m2639w();
        ViewGroup viewGroup = (ViewGroup) this.f1445y.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m2656a(ViewGroup viewGroup) {
    }

    boolean mo432a(int i, KeyEvent keyEvent) {
        C0546a a = mo413a();
        if (a != null && a.mo463a(i, keyEvent)) {
            return true;
        }
        if (this.f1427F == null || !m2630a(this.f1427F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1427F == null) {
                C0583d a2 = m2643a(0, true);
                m2633b(a2, keyEvent);
                boolean a3 = m2630a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1490m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f1427F == null) {
            return true;
        } else {
            this.f1427F.f1491n = true;
            return true;
        }
    }

    public boolean mo433a(C0643h c0643h, MenuItem menuItem) {
        Callback q = m2622q();
        if (!(q == null || m2621p())) {
            C0583d a = m2644a(c0643h.mo567p());
            if (a != null) {
                return q.onMenuItemSelected(a.f1478a, menuItem);
            }
        }
        return false;
    }

    boolean mo434a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m2670c(keyCode, keyEvent) : m2667b(keyCode, keyEvent);
    }

    public C0597b m2660b(C0580a c0580a) {
        if (c0580a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1434m != null) {
            this.f1434m.mo483c();
        }
        C0580a c0581b = new C0581b(this, c0580a);
        C0546a a = mo413a();
        if (a != null) {
            this.f1434m = a.mo489a(c0581b);
            if (!(this.f1434m == null || this.e == null)) {
                this.e.mo393a(this.f1434m);
            }
        }
        if (this.f1434m == null) {
            this.f1434m = mo424a(c0581b);
        }
        return this.f1434m;
    }

    public View m2661b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if (this.f1433L == null) {
            this.f1433L = new C0586m();
        }
        if (f1421t) {
            boolean a = attributeSet instanceof XmlPullParser ? ((XmlPullParser) attributeSet).getDepth() > 1 : m2631a((ViewParent) view);
            z = a;
        } else {
            z = false;
        }
        return this.f1433L.m2743a(view, str, context, attributeSet, z, f1421t, true, br.m4592a());
    }

    public void mo435b(int i) {
        m2639w();
        ViewGroup viewGroup = (ViewGroup) this.f1445y.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void mo436b(Bundle bundle) {
        m2639w();
    }

    void m2664b(C0643h c0643h) {
        if (!this.f1425D) {
            this.f1425D = true;
            this.f1441u.mo585k();
            Callback q = m2622q();
            if (!(q == null || m2621p())) {
                q.onPanelClosed(108, c0643h);
            }
            this.f1425D = false;
        }
    }

    public void mo437b(View view, LayoutParams layoutParams) {
        m2639w();
        ((ViewGroup) this.f1445y.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void mo438b(CharSequence charSequence) {
        if (this.f1441u != null) {
            this.f1441u.setWindowTitle(charSequence);
        } else if (m2618m() != null) {
            m2618m().mo461a(charSequence);
        } else if (this.f1446z != null) {
            this.f1446z.setText(charSequence);
        }
    }

    boolean m2667b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f1428G;
                this.f1428G = false;
                C0583d a = m2643a(0, false);
                if (a == null || !a.f1492o) {
                    if (m2682u()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m2652a(a, true);
                    return true;
                }
                break;
            case 82:
                m2637e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean mo439b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        C0546a a = mo413a();
        if (a == null) {
            return true;
        }
        a.mo470e(true);
        return true;
    }

    public boolean mo440c(int i) {
        int h = m2638h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                m2642z();
                this.l = true;
                return true;
            case 2:
                m2642z();
                this.f1423B = true;
                return true;
            case 5:
                m2642z();
                this.f1424C = true;
                return true;
            case 10:
                m2642z();
                this.j = true;
                return true;
            case 108:
                m2642z();
                this.h = true;
                return true;
            case 109:
                m2642z();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean m2670c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1428G = z;
                break;
            case 82:
                m2636d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            mo432a(i, keyEvent);
        }
        return false;
    }

    public void mo418d() {
        C0546a a = mo413a();
        if (a != null) {
            a.mo468d(false);
        }
    }

    public void mo441e() {
        C0546a a = mo413a();
        if (a != null) {
            a.mo468d(true);
        }
    }

    void m2673e(int i) {
        m2652a(m2643a(i, true), true);
    }

    public void mo442f() {
        C0546a a = mo413a();
        if (a == null || !a.mo471e()) {
            mo447d(0);
        }
    }

    void m2675f(int i) {
        C0583d a = m2643a(i, true);
        if (a.f1487j != null) {
            Bundle bundle = new Bundle();
            a.f1487j.m3084a(bundle);
            if (bundle.size() > 0) {
                a.f1496s = bundle;
            }
            a.f1487j.m3111g();
            a.f1487j.clear();
        }
        a.f1495r = true;
        a.f1494q = true;
        if ((i == 108 || i == 0) && this.f1441u != null) {
            a = m2643a(0, false);
            if (a != null) {
                a.f1490m = false;
                m2633b(a, null);
            }
        }
    }

    int m2676g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f1435n == null || !(this.f1435n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1435n.getLayoutParams();
            if (this.f1435n.isShown()) {
                if (this.f1431J == null) {
                    this.f1431J = new Rect();
                    this.f1432K = new Rect();
                }
                Rect rect = this.f1431J;
                Rect rect2 = this.f1432K;
                rect.set(0, i, 0, 0);
                bt.m4614a(this.f1445y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1422A == null) {
                        this.f1422A = new View(this.a);
                        this.f1422A.setBackgroundColor(this.a.getResources().getColor(C0521c.abc_input_method_navigation_guard));
                        this.f1445y.addView(this.f1422A, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f1422A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1422A.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f1422A == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f1435n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f1422A != null) {
            View view = this.f1422A;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    public void mo419g() {
        if (this.f1439r) {
            this.b.getDecorView().removeCallbacks(this.f1429H);
        }
        super.mo419g();
        if (this.f != null) {
            this.f.mo473g();
        }
    }

    public void mo443h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0401e.m1789b(from, this);
        } else if (!(from.getFactory2() instanceof C0561k)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void mo444l() {
        m2639w();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new C0600r((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new C0600r((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.mo466c(this.f1430I);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo445a(view, str, context, attributeSet);
        return a != null ? a : m2661b(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    final boolean m2680s() {
        return this.f1444x && this.f1445y != null && C0425s.m1986y(this.f1445y);
    }

    void m2681t() {
        if (this.f1438q != null) {
            this.f1438q.m2022b();
        }
    }

    boolean m2682u() {
        if (this.f1434m != null) {
            this.f1434m.mo483c();
            return true;
        }
        C0546a a = mo413a();
        return a != null && a.mo472f();
    }

    void m2683v() {
        if (this.f1441u != null) {
            this.f1441u.mo585k();
        }
        if (this.f1436o != null) {
            this.b.getDecorView().removeCallbacks(this.f1437p);
            if (this.f1436o.isShowing()) {
                try {
                    this.f1436o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1436o = null;
        }
        m2681t();
        C0583d a = m2643a(0, false);
        if (a != null && a.f1487j != null) {
            a.f1487j.close();
        }
    }
}
