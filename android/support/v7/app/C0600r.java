package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.p008h.C0119v;
import android.support.v4.p008h.C0120w;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0433u;
import android.support.v4.p008h.C0434x;
import android.support.v7.app.C0546a.C0544b;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.C0597b;
import android.support.v7.view.C0597b.C0580a;
import android.support.v7.view.C0612a;
import android.support.v7.view.C0620g;
import android.support.v7.view.C0622h;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0643h.C0560a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0599a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aj;
import android.support.v7.widget.be;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class C0600r extends C0546a implements C0599a {
    static final /* synthetic */ boolean f1548s = (!C0600r.class.desiredAssertionStatus());
    private static final Interpolator f1549t = new AccelerateInterpolator();
    private static final Interpolator f1550u = new DecelerateInterpolator();
    private boolean f1551A;
    private boolean f1552B;
    private ArrayList<C0544b> f1553C = new ArrayList();
    private boolean f1554D;
    private int f1555E = 0;
    private boolean f1556F;
    private boolean f1557G = true;
    private boolean f1558H;
    Context f1559a;
    ActionBarOverlayLayout f1560b;
    ActionBarContainer f1561c;
    aj f1562d;
    ActionBarContextView f1563e;
    View f1564f;
    be f1565g;
    C0598a f1566h;
    C0597b f1567i;
    C0580a f1568j;
    boolean f1569k = true;
    boolean f1570l;
    boolean f1571m;
    C0622h f1572n;
    boolean f1573o;
    final C0119v f1574p = new C05941(this);
    final C0119v f1575q = new C05952(this);
    final C0434x f1576r = new C05963(this);
    private Context f1577v;
    private Activity f1578w;
    private Dialog f1579x;
    private ArrayList<Object> f1580y = new ArrayList();
    private int f1581z = -1;

    class C05941 extends C0120w {
        final /* synthetic */ C0600r f1538a;

        C05941(C0600r c0600r) {
            this.f1538a = c0600r;
        }

        public void mo101b(View view) {
            if (this.f1538a.f1569k && this.f1538a.f1564f != null) {
                this.f1538a.f1564f.setTranslationY(0.0f);
                this.f1538a.f1561c.setTranslationY(0.0f);
            }
            this.f1538a.f1561c.setVisibility(8);
            this.f1538a.f1561c.setTransitioning(false);
            this.f1538a.f1572n = null;
            this.f1538a.m2846h();
            if (this.f1538a.f1560b != null) {
                C0425s.m1979r(this.f1538a.f1560b);
            }
        }
    }

    class C05952 extends C0120w {
        final /* synthetic */ C0600r f1539a;

        C05952(C0600r c0600r) {
            this.f1539a = c0600r;
        }

        public void mo101b(View view) {
            this.f1539a.f1572n = null;
            this.f1539a.f1561c.requestLayout();
        }
    }

    class C05963 implements C0434x {
        final /* synthetic */ C0600r f1540a;

        C05963(C0600r c0600r) {
            this.f1540a = c0600r;
        }

        public void mo474a(View view) {
            ((View) this.f1540a.f1561c.getParent()).invalidate();
        }
    }

    public class C0598a extends C0597b implements C0560a {
        final /* synthetic */ C0600r f1543a;
        private final Context f1544b;
        private final C0643h f1545c;
        private C0580a f1546d;
        private WeakReference<View> f1547e;

        public C0598a(C0600r c0600r, Context context, C0580a c0580a) {
            this.f1543a = c0600r;
            this.f1544b = context;
            this.f1546d = c0580a;
            this.f1545c = new C0643h(context).m3077a(1);
            this.f1545c.mo561a((C0560a) this);
        }

        public MenuInflater mo475a() {
            return new C0620g(this.f1544b);
        }

        public void mo476a(int i) {
            mo482b(this.f1543a.f1559a.getResources().getString(i));
        }

        public void mo429a(C0643h c0643h) {
            if (this.f1546d != null) {
                mo484d();
                this.f1543a.f1563e.mo570a();
            }
        }

        public void mo477a(View view) {
            this.f1543a.f1563e.setCustomView(view);
            this.f1547e = new WeakReference(view);
        }

        public void mo478a(CharSequence charSequence) {
            this.f1543a.f1563e.setSubtitle(charSequence);
        }

        public void mo479a(boolean z) {
            super.mo479a(z);
            this.f1543a.f1563e.setTitleOptional(z);
        }

        public boolean mo433a(C0643h c0643h, MenuItem menuItem) {
            return this.f1546d != null ? this.f1546d.mo456a((C0597b) this, menuItem) : false;
        }

        public Menu mo480b() {
            return this.f1545c;
        }

        public void mo481b(int i) {
            mo478a(this.f1543a.f1559a.getResources().getString(i));
        }

        public void mo482b(CharSequence charSequence) {
            this.f1543a.f1563e.setTitle(charSequence);
        }

        public void mo483c() {
            if (this.f1543a.f1566h == this) {
                if (C0600r.m2822a(this.f1543a.f1570l, this.f1543a.f1571m, false)) {
                    this.f1546d.mo454a(this);
                } else {
                    this.f1543a.f1567i = this;
                    this.f1543a.f1568j = this.f1546d;
                }
                this.f1546d = null;
                this.f1543a.m2851j(false);
                this.f1543a.f1563e.m3232b();
                this.f1543a.f1562d.mo742a().sendAccessibilityEvent(32);
                this.f1543a.f1560b.setHideOnContentScrollEnabled(this.f1543a.f1573o);
                this.f1543a.f1566h = null;
            }
        }

        public void mo484d() {
            if (this.f1543a.f1566h == this) {
                this.f1545c.m3111g();
                try {
                    this.f1546d.mo457b(this, this.f1545c);
                } finally {
                    this.f1545c.m3112h();
                }
            }
        }

        public boolean m2810e() {
            this.f1545c.m3111g();
            try {
                boolean a = this.f1546d.mo455a((C0597b) this, this.f1545c);
                return a;
            } finally {
                this.f1545c.m3112h();
            }
        }

        public CharSequence mo485f() {
            return this.f1543a.f1563e.getTitle();
        }

        public CharSequence mo486g() {
            return this.f1543a.f1563e.getSubtitle();
        }

        public boolean mo487h() {
            return this.f1543a.f1563e.m3234d();
        }

        public View mo488i() {
            return this.f1547e != null ? (View) this.f1547e.get() : null;
        }
    }

    public C0600r(Activity activity, boolean z) {
        this.f1578w = activity;
        View decorView = activity.getWindow().getDecorView();
        m2821a(decorView);
        if (!z) {
            this.f1564f = decorView.findViewById(16908290);
        }
    }

    public C0600r(Dialog dialog) {
        this.f1579x = dialog;
        m2821a(dialog.getWindow().getDecorView());
    }

    private void m2821a(View view) {
        this.f1560b = (ActionBarOverlayLayout) view.findViewById(C0524f.decor_content_parent);
        if (this.f1560b != null) {
            this.f1560b.setActionBarVisibilityCallback(this);
        }
        this.f1562d = m2823b(view.findViewById(C0524f.action_bar));
        this.f1563e = (ActionBarContextView) view.findViewById(C0524f.action_context_bar);
        this.f1561c = (ActionBarContainer) view.findViewById(C0524f.action_bar_container);
        if (this.f1562d == null || this.f1563e == null || this.f1561c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1559a = this.f1562d.mo751b();
        boolean z = (this.f1562d.mo768o() & 4) != 0;
        if (z) {
            this.f1551A = true;
        }
        C0612a a = C0612a.m2870a(this.f1559a);
        z = a.m2876f() || z;
        mo462a(z);
        m2824k(a.m2874d());
        TypedArray obtainStyledAttributes = this.f1559a.obtainStyledAttributes(null, C0528j.ActionBar, C0519a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0528j.ActionBar_hideOnContentScroll, false)) {
            mo491b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0528j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo459a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    static boolean m2822a(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private aj m2823b(View view) {
        if (view instanceof aj) {
            return (aj) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private void m2824k(boolean z) {
        boolean z2 = true;
        this.f1554D = z;
        if (this.f1554D) {
            this.f1561c.setTabContainer(null);
            this.f1562d.mo746a(this.f1565g);
        } else {
            this.f1562d.mo746a(null);
            this.f1561c.setTabContainer(this.f1565g);
        }
        boolean z3 = m2848i() == 2;
        if (this.f1565g != null) {
            if (z3) {
                this.f1565g.setVisibility(0);
                if (this.f1560b != null) {
                    C0425s.m1979r(this.f1560b);
                }
            } else {
                this.f1565g.setVisibility(8);
            }
        }
        aj ajVar = this.f1562d;
        boolean z4 = !this.f1554D && z3;
        ajVar.mo750a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1560b;
        if (this.f1554D || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void m2825l(boolean z) {
        if (C0600r.m2822a(this.f1570l, this.f1571m, this.f1556F)) {
            if (!this.f1557G) {
                this.f1557G = true;
                m2847h(z);
            }
        } else if (this.f1557G) {
            this.f1557G = false;
            m2849i(z);
        }
    }

    private void m2826n() {
        if (!this.f1556F) {
            this.f1556F = true;
            if (this.f1560b != null) {
                this.f1560b.setShowingForActionMode(true);
            }
            m2825l(false);
        }
    }

    private void m2827o() {
        if (this.f1556F) {
            this.f1556F = false;
            if (this.f1560b != null) {
                this.f1560b.setShowingForActionMode(false);
            }
            m2825l(false);
        }
    }

    private boolean m2828p() {
        return C0425s.m1986y(this.f1561c);
    }

    public int mo458a() {
        return this.f1562d.mo768o();
    }

    public C0597b mo489a(C0580a c0580a) {
        if (this.f1566h != null) {
            this.f1566h.mo483c();
        }
        this.f1560b.setHideOnContentScrollEnabled(false);
        this.f1563e.m3233c();
        C0597b c0598a = new C0598a(this, this.f1563e.getContext(), c0580a);
        if (!c0598a.m2810e()) {
            return null;
        }
        this.f1566h = c0598a;
        c0598a.mo484d();
        this.f1563e.m3230a(c0598a);
        m2851j(true);
        this.f1563e.sendAccessibilityEvent(32);
        return c0598a;
    }

    public void mo459a(float f) {
        C0425s.m1962d(this.f1561c, f);
    }

    public void mo490a(int i) {
        this.f1555E = i;
    }

    public void m2833a(int i, int i2) {
        int o = this.f1562d.mo768o();
        if ((i2 & 4) != 0) {
            this.f1551A = true;
        }
        this.f1562d.mo754c((o & (i2 ^ -1)) | (i & i2));
    }

    public void mo460a(Configuration configuration) {
        m2824k(C0612a.m2870a(this.f1559a).m2874d());
    }

    public void mo461a(CharSequence charSequence) {
        this.f1562d.mo749a(charSequence);
    }

    public void mo462a(boolean z) {
        this.f1562d.mo753b(z);
    }

    public boolean mo463a(int i, KeyEvent keyEvent) {
        if (this.f1566h == null) {
            return false;
        }
        Menu b = this.f1566h.mo480b();
        if (b == null) {
            return false;
        }
        b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return b.performShortcut(i, keyEvent, 0);
    }

    public Context mo465b() {
        if (this.f1577v == null) {
            TypedValue typedValue = new TypedValue();
            this.f1559a.getTheme().resolveAttribute(C0519a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1577v = new ContextThemeWrapper(this.f1559a, i);
            } else {
                this.f1577v = this.f1559a;
            }
        }
        return this.f1577v;
    }

    public void mo491b(boolean z) {
        if (!z || this.f1560b.m3255a()) {
            this.f1573o = z;
            this.f1560b.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void mo466c(boolean z) {
        if (!this.f1551A) {
            m2843f(z);
        }
    }

    public void mo468d(boolean z) {
        this.f1558H = z;
        if (!z && this.f1572n != null) {
            this.f1572n.m2928c();
        }
    }

    public void mo470e(boolean z) {
        if (z != this.f1552B) {
            this.f1552B = z;
            int size = this.f1553C.size();
            for (int i = 0; i < size; i++) {
                ((C0544b) this.f1553C.get(i)).m2518a(z);
            }
        }
    }

    public void m2843f(boolean z) {
        m2833a(z ? 4 : 0, 4);
    }

    public boolean mo472f() {
        if (this.f1562d == null || !this.f1562d.mo755c()) {
            return false;
        }
        this.f1562d.mo756d();
        return true;
    }

    public void mo492g(boolean z) {
        this.f1569k = z;
    }

    void m2846h() {
        if (this.f1568j != null) {
            this.f1568j.mo454a(this.f1567i);
            this.f1567i = null;
            this.f1568j = null;
        }
    }

    public void m2847h(boolean z) {
        if (this.f1572n != null) {
            this.f1572n.m2928c();
        }
        this.f1561c.setVisibility(0);
        if (this.f1555E == 0 && (this.f1558H || z)) {
            this.f1561c.setTranslationY(0.0f);
            float f = (float) (-this.f1561c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1561c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.f1561c.setTranslationY(f);
            C0622h c0622h = new C0622h();
            C0433u c = C0425s.m1976o(this.f1561c).m2023c(0.0f);
            c.m2017a(this.f1576r);
            c0622h.m2922a(c);
            if (this.f1569k && this.f1564f != null) {
                this.f1564f.setTranslationY(f);
                c0622h.m2922a(C0425s.m1976o(this.f1564f).m2023c(0.0f));
            }
            c0622h.m2925a(f1550u);
            c0622h.m2921a(250);
            c0622h.m2924a(this.f1575q);
            this.f1572n = c0622h;
            c0622h.m2926a();
        } else {
            this.f1561c.setAlpha(1.0f);
            this.f1561c.setTranslationY(0.0f);
            if (this.f1569k && this.f1564f != null) {
                this.f1564f.setTranslationY(0.0f);
            }
            this.f1575q.mo101b(null);
        }
        if (this.f1560b != null) {
            C0425s.m1979r(this.f1560b);
        }
    }

    public int m2848i() {
        return this.f1562d.mo769p();
    }

    public void m2849i(boolean z) {
        if (this.f1572n != null) {
            this.f1572n.m2928c();
        }
        if (this.f1555E == 0 && (this.f1558H || z)) {
            this.f1561c.setAlpha(1.0f);
            this.f1561c.setTransitioning(true);
            C0622h c0622h = new C0622h();
            float f = (float) (-this.f1561c.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1561c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            C0433u c = C0425s.m1976o(this.f1561c).m2023c(f);
            c.m2017a(this.f1576r);
            c0622h.m2922a(c);
            if (this.f1569k && this.f1564f != null) {
                c0622h.m2922a(C0425s.m1976o(this.f1564f).m2023c(f));
            }
            c0622h.m2925a(f1549t);
            c0622h.m2921a(250);
            c0622h.m2924a(this.f1574p);
            this.f1572n = c0622h;
            c0622h.m2926a();
            return;
        }
        this.f1574p.mo101b(null);
    }

    public void mo493j() {
        if (this.f1571m) {
            this.f1571m = false;
            m2825l(true);
        }
    }

    public void m2851j(boolean z) {
        if (z) {
            m2826n();
        } else {
            m2827o();
        }
        if (m2828p()) {
            C0433u a;
            C0433u a2;
            if (z) {
                a = this.f1562d.mo741a(4, 100);
                a2 = this.f1563e.mo569a(0, 200);
            } else {
                a2 = this.f1562d.mo741a(0, 200);
                a = this.f1563e.mo569a(8, 100);
            }
            C0622h c0622h = new C0622h();
            c0622h.m2923a(a, a2);
            c0622h.m2926a();
        } else if (z) {
            this.f1562d.mo757d(4);
            this.f1563e.setVisibility(0);
        } else {
            this.f1562d.mo757d(0);
            this.f1563e.setVisibility(8);
        }
    }

    public void mo494k() {
        if (!this.f1571m) {
            this.f1571m = true;
            m2825l(true);
        }
    }

    public void mo495l() {
        if (this.f1572n != null) {
            this.f1572n.m2928c();
            this.f1572n = null;
        }
    }

    public void mo496m() {
    }
}
