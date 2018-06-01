package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.p008h.C0397c;
import android.support.v4.p008h.C0397c.C0395a;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.view.C0612a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0624b;
import android.support.v7.view.menu.C0072p;
import android.support.v7.view.menu.C0072p.C0070a;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.view.menu.C0629b;
import android.support.v7.view.menu.C0637s;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0646j;
import android.support.v7.view.menu.C0655n;
import android.support.v7.view.menu.C0661u;
import android.support.v7.widget.ActionMenuView.C0625a;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class C0809d extends C0629b implements C0395a {
    private C0803b f2688A;
    C0806d f2689g;
    C0807e f2690h;
    C0802a f2691i;
    C0804c f2692j;
    final C0808f f2693k = new C0808f(this);
    int f2694l;
    private Drawable f2695m;
    private boolean f2696n;
    private boolean f2697o;
    private boolean f2698p;
    private int f2699q;
    private int f2700r;
    private int f2701s;
    private boolean f2702t;
    private boolean f2703u;
    private boolean f2704v;
    private boolean f2705w;
    private int f2706x;
    private final SparseBooleanArray f2707y = new SparseBooleanArray();
    private View f2708z;

    private class C0802a extends C0655n {
        final /* synthetic */ C0809d f2678a;

        public C0802a(C0809d c0809d, Context context, C0661u c0661u, View view) {
            this.f2678a = c0809d;
            super(context, c0661u, view, false, C0519a.actionOverflowMenuStyle);
            if (!((C0646j) c0661u.getItem()).m3152j()) {
                m3176a(c0809d.f2689g == null ? (View) c0809d.f : c0809d.f2689g);
            }
            m3175a(c0809d.f2693k);
        }

        protected void mo772e() {
            this.f2678a.f2691i = null;
            this.f2678a.f2694l = 0;
            super.mo772e();
        }
    }

    private class C0803b extends C0624b {
        final /* synthetic */ C0809d f2679a;

        C0803b(C0809d c0809d) {
            this.f2679a = c0809d;
        }

        public C0637s mo773a() {
            return this.f2679a.f2691i != null ? this.f2679a.f2691i.m3180b() : null;
        }
    }

    private class C0804c implements Runnable {
        final /* synthetic */ C0809d f2680a;
        private C0807e f2681b;

        public C0804c(C0809d c0809d, C0807e c0807e) {
            this.f2680a = c0809d;
            this.f2681b = c0807e;
        }

        public void run() {
            if (this.f2680a.c != null) {
                this.f2680a.c.m3110f();
            }
            View view = (View) this.f2680a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f2681b.m3181c())) {
                this.f2680a.f2690h = this.f2681b;
            }
            this.f2680a.f2692j = null;
        }
    }

    private class C0806d extends AppCompatImageView implements C0625a {
        final /* synthetic */ C0809d f2684a;
        private final float[] f2685b = new float[2];

        public C0806d(final C0809d c0809d, Context context) {
            this.f2684a = c0809d;
            super(context, null, C0519a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            bo.m4581a(this, getContentDescription());
            setOnTouchListener(new ao(this, this) {
                final /* synthetic */ C0806d f2683b;

                public C0637s mo497a() {
                    return this.f2683b.f2684a.f2690h == null ? null : this.f2683b.f2684a.f2690h.m3180b();
                }

                public boolean mo498b() {
                    this.f2683b.f2684a.m4651d();
                    return true;
                }

                public boolean mo774c() {
                    if (this.f2683b.f2684a.f2692j != null) {
                        return false;
                    }
                    this.f2683b.f2684a.m4652e();
                    return true;
                }
            });
        }

        public boolean mo499c() {
            return false;
        }

        public boolean mo500d() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f2684a.m4651d();
            }
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0279a.m1420a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class C0807e extends C0655n {
        final /* synthetic */ C0809d f2686a;

        public C0807e(C0809d c0809d, Context context, C0643h c0643h, View view, boolean z) {
            this.f2686a = c0809d;
            super(context, c0643h, view, z, C0519a.actionOverflowMenuStyle);
            m3174a(8388613);
            m3175a(c0809d.f2693k);
        }

        protected void mo772e() {
            if (this.f2686a.c != null) {
                this.f2686a.c.close();
            }
            this.f2686a.f2690h = null;
            super.mo772e();
        }
    }

    private class C0808f implements C0577a {
        final /* synthetic */ C0809d f2687a;

        C0808f(C0809d c0809d) {
            this.f2687a = c0809d;
        }

        public void mo452a(C0643h c0643h, boolean z) {
            if (c0643h instanceof C0661u) {
                c0643h.mo567p().m3091a(false);
            }
            C0577a a = this.f2687a.m2976a();
            if (a != null) {
                a.mo452a(c0643h, z);
            }
        }

        public boolean mo453a(C0643h c0643h) {
            if (c0643h == null) {
                return false;
            }
            this.f2687a.f2694l = ((C0661u) c0643h).getItem().getItemId();
            C0577a a = this.f2687a.m2976a();
            return a != null ? a.mo453a(c0643h) : false;
        }
    }

    public C0809d(Context context) {
        super(context, C0525g.abc_action_menu_layout, C0525g.abc_action_menu_item_layout);
    }

    private View m4628a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0070a) && ((C0070a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public C0072p mo775a(ViewGroup viewGroup) {
        C0072p c0072p = this.f;
        C0072p a = super.mo775a(viewGroup);
        if (c0072p != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    public View mo776a(C0646j c0646j, View view, ViewGroup viewGroup) {
        View actionView = c0646j.getActionView();
        if (actionView == null || c0646j.m3156n()) {
            actionView = super.mo776a(c0646j, view, viewGroup);
        }
        actionView.setVisibility(c0646j.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m3274a(layoutParams));
        }
        return actionView;
    }

    public void mo525a(Context context, C0643h c0643h) {
        super.mo525a(context, c0643h);
        Resources resources = context.getResources();
        C0612a a = C0612a.m2870a(context);
        if (!this.f2698p) {
            this.f2697o = a.m2872b();
        }
        if (!this.f2704v) {
            this.f2699q = a.m2873c();
        }
        if (!this.f2702t) {
            this.f2701s = a.m2871a();
        }
        int i = this.f2699q;
        if (this.f2697o) {
            if (this.f2689g == null) {
                this.f2689g = new C0806d(this, this.a);
                if (this.f2696n) {
                    this.f2689g.setImageDrawable(this.f2695m);
                    this.f2695m = null;
                    this.f2696n = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2689g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2689g.getMeasuredWidth();
        } else {
            this.f2689g = null;
        }
        this.f2700r = i;
        this.f2706x = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2708z = null;
    }

    public void m4637a(Configuration configuration) {
        if (!this.f2702t) {
            this.f2701s = C0612a.m2870a(this.b).m2871a();
        }
        if (this.c != null) {
            this.c.m3099b(true);
        }
    }

    public void m4638a(Drawable drawable) {
        if (this.f2689g != null) {
            this.f2689g.setImageDrawable(drawable);
            return;
        }
        this.f2696n = true;
        this.f2695m = drawable;
    }

    public void mo526a(C0643h c0643h, boolean z) {
        m4653f();
        super.mo526a(c0643h, z);
    }

    public void mo777a(C0646j c0646j, C0070a c0070a) {
        c0070a.mo27a(c0646j, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0070a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f2688A == null) {
            this.f2688A = new C0803b(this);
        }
        actionMenuItemView.setPopupCallback(this.f2688A);
    }

    public void m4641a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.mo31a(this.c);
    }

    public void mo778a(boolean z) {
        if (z) {
            super.mo529a(null);
        } else if (this.c != null) {
            this.c.m3091a(false);
        }
    }

    public boolean mo779a(int i, C0646j c0646j) {
        return c0646j.m3152j();
    }

    public boolean mo529a(C0661u c0661u) {
        if (!c0661u.hasVisibleItems()) {
            return false;
        }
        C0661u c0661u2 = c0661u;
        while (c0661u2.m3217s() != this.c) {
            c0661u2 = (C0661u) c0661u2.m3217s();
        }
        View a = m4628a(c0661u2.getItem());
        if (a == null) {
            return false;
        }
        boolean z;
        this.f2694l = c0661u.getItem().getItemId();
        int size = c0661u.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0661u.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        z = false;
        this.f2691i = new C0802a(this, this.b, c0661u, a);
        this.f2691i.m3178a(z);
        this.f2691i.m3173a();
        super.mo529a(c0661u);
        return true;
    }

    public boolean mo780a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.f2689g ? false : super.mo780a(viewGroup, i);
    }

    public void mo530b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        super.mo530b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m3115k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0397c a = ((C0646j) k.get(i)).mo504a();
                if (a != null) {
                    a.m1775a((C0395a) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m3116l() : null;
        if (this.f2697o && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((C0646j) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f2689g == null) {
                this.f2689g = new C0806d(this, this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f2689g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2689g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f2689g, actionMenuView.m3283c());
            }
        } else if (this.f2689g != null && this.f2689g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f2689g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f2697o);
    }

    public boolean mo531b() {
        int size;
        ArrayList arrayList;
        int i;
        if (this.c != null) {
            ArrayList i2 = this.c.m3113i();
            size = i2.size();
            arrayList = i2;
        } else {
            size = 0;
            arrayList = null;
        }
        int i3 = this.f2701s;
        int i4 = this.f2700r;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0646j c0646j = (C0646j) arrayList.get(i7);
            if (c0646j.m3154l()) {
                i5++;
            } else if (c0646j.m3153k()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.f2705w && c0646j.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.f2697o && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f2707y;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f2703u) {
            i = i4 / this.f2706x;
            i6 = ((i4 % this.f2706x) / i) + this.f2706x;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0646j = (C0646j) arrayList.get(i8);
            int i10;
            if (c0646j.m3154l()) {
                View a = mo776a(c0646j, this.f2708z, viewGroup);
                if (this.f2708z == null) {
                    this.f2708z = a;
                }
                if (this.f2703u) {
                    i9 -= ActionMenuView.m3271a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0646j.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0646j.m3145d(true);
                i = i10;
                i3 = i7;
            } else if (c0646j.m3153k()) {
                boolean z;
                int groupId = c0646j.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f2703u || i9 > 0);
                if (z3) {
                    View a2 = mo776a(c0646j, this.f2708z, viewGroup);
                    if (this.f2708z == null) {
                        this.f2708z = a2;
                    }
                    boolean z4;
                    if (this.f2703u) {
                        int a3 = ActionMenuView.m3271a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f2703u) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0646j c0646j2 = (C0646j) arrayList.get(i7);
                        if (c0646j2.getGroupId() == groupId) {
                            if (c0646j2.m3152j()) {
                                i5++;
                            }
                            c0646j2.m3145d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0646j.m3145d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0646j.m3145d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public Drawable m4648c() {
        return this.f2689g != null ? this.f2689g.getDrawable() : this.f2696n ? this.f2695m : null;
    }

    public void m4649c(boolean z) {
        this.f2697o = z;
        this.f2698p = true;
    }

    public void m4650d(boolean z) {
        this.f2705w = z;
    }

    public boolean m4651d() {
        if (!this.f2697o || m4655h() || this.c == null || this.f == null || this.f2692j != null || this.c.m3116l().isEmpty()) {
            return false;
        }
        this.f2692j = new C0804c(this, new C0807e(this, this.b, this.c, this.f2689g, true));
        ((View) this.f).post(this.f2692j);
        super.mo529a(null);
        return true;
    }

    public boolean m4652e() {
        if (this.f2692j == null || this.f == null) {
            C0655n c0655n = this.f2690h;
            if (c0655n == null) {
                return false;
            }
            c0655n.m3182d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f2692j);
        this.f2692j = null;
        return true;
    }

    public boolean m4653f() {
        return m4652e() | m4654g();
    }

    public boolean m4654g() {
        if (this.f2691i == null) {
            return false;
        }
        this.f2691i.m3182d();
        return true;
    }

    public boolean m4655h() {
        return this.f2690h != null && this.f2690h.m3184f();
    }

    public boolean m4656i() {
        return this.f2692j != null || m4655h();
    }
}
