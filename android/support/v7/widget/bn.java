package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p008h.C0120w;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0433u;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0523e;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0526h;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.p023c.p024a.C0608b;
import android.support.v7.view.menu.C0627a;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0643h.C0560a;
import android.support.v7.widget.Toolbar.C0747b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class bn implements aj {
    Toolbar f2634a;
    CharSequence f2635b;
    Callback f2636c;
    boolean f2637d;
    private int f2638e;
    private View f2639f;
    private View f2640g;
    private Drawable f2641h;
    private Drawable f2642i;
    private Drawable f2643j;
    private boolean f2644k;
    private CharSequence f2645l;
    private CharSequence f2646m;
    private C0809d f2647n;
    private int f2648o;
    private int f2649p;
    private Drawable f2650q;

    class C07921 implements OnClickListener {
        final C0627a f2629a = new C0627a(this.f2630b.f2634a.getContext(), 0, 16908332, 0, 0, this.f2630b.f2635b);
        final /* synthetic */ bn f2630b;

        C07921(bn bnVar) {
            this.f2630b = bnVar;
        }

        public void onClick(View view) {
            if (this.f2630b.f2636c != null && this.f2630b.f2637d) {
                this.f2630b.f2636c.onMenuItemSelected(0, this.f2629a);
            }
        }
    }

    public bn(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0526h.abc_action_bar_up_description, C0523e.abc_ic_ab_back_material);
    }

    public bn(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2648o = 0;
        this.f2649p = 0;
        this.f2634a = toolbar;
        this.f2635b = toolbar.getTitle();
        this.f2645l = toolbar.getSubtitle();
        this.f2644k = this.f2635b != null;
        this.f2643j = toolbar.getNavigationIcon();
        bm a = bm.m4513a(toolbar.getContext(), null, C0528j.ActionBar, C0519a.actionBarStyle, 0);
        this.f2650q = a.m4517a(C0528j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.m4523c(C0528j.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m4554b(c);
            }
            c = a.m4523c(C0528j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m4558c(c);
            }
            Drawable a2 = a.m4517a(C0528j.ActionBar_logo);
            if (a2 != null) {
                m4553b(a2);
            }
            a2 = a.m4517a(C0528j.ActionBar_icon);
            if (a2 != null) {
                mo744a(a2);
            }
            if (this.f2643j == null && this.f2650q != null) {
                m4557c(this.f2650q);
            }
            mo754c(a.m4515a(C0528j.ActionBar_displayOptions, 0));
            int g = a.m4530g(C0528j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m4547a(LayoutInflater.from(this.f2634a.getContext()).inflate(g, this.f2634a, false));
                mo754c(this.f2638e | 16);
            }
            g = a.m4528f(C0528j.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f2634a.getLayoutParams();
                layoutParams.height = g;
                this.f2634a.setLayoutParams(layoutParams);
            }
            g = a.m4524d(C0528j.ActionBar_contentInsetStart, -1);
            int d = a.m4524d(C0528j.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f2634a.m4071a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m4530g(C0528j.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f2634a.m4072a(this.f2634a.getContext(), g);
            }
            g = a.m4530g(C0528j.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f2634a.m4076b(this.f2634a.getContext(), g);
            }
            int g2 = a.m4530g(C0528j.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f2634a.setPopupTheme(g2);
            }
        } else {
            this.f2638e = m4536r();
        }
        a.m4518a();
        m4564e(i);
        this.f2646m = this.f2634a.getNavigationContentDescription();
        this.f2634a.setNavigationOnClickListener(new C07921(this));
    }

    private void m4535e(CharSequence charSequence) {
        this.f2635b = charSequence;
        if ((this.f2638e & 8) != 0) {
            this.f2634a.setTitle(charSequence);
        }
    }

    private int m4536r() {
        if (this.f2634a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2650q = this.f2634a.getNavigationIcon();
        return 15;
    }

    private void m4537s() {
        Drawable drawable = null;
        if ((this.f2638e & 2) != 0) {
            drawable = (this.f2638e & 1) != 0 ? this.f2642i != null ? this.f2642i : this.f2641h : this.f2641h;
        }
        this.f2634a.setLogo(drawable);
    }

    private void m4538t() {
        if ((this.f2638e & 4) != 0) {
            this.f2634a.setNavigationIcon(this.f2643j != null ? this.f2643j : this.f2650q);
        } else {
            this.f2634a.setNavigationIcon(null);
        }
    }

    private void m4539u() {
        if ((this.f2638e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2646m)) {
            this.f2634a.setNavigationContentDescription(this.f2649p);
        } else {
            this.f2634a.setNavigationContentDescription(this.f2646m);
        }
    }

    public C0433u mo741a(final int i, long j) {
        return C0425s.m1976o(this.f2634a).m2014a(i == 0 ? 1.0f : 0.0f).m2015a(j).m2016a(new C0120w(this) {
            final /* synthetic */ bn f2632b;
            private boolean f2633c = false;

            public void mo100a(View view) {
                this.f2632b.f2634a.setVisibility(0);
            }

            public void mo101b(View view) {
                if (!this.f2633c) {
                    this.f2632b.f2634a.setVisibility(i);
                }
            }

            public void mo102c(View view) {
                this.f2633c = true;
            }
        });
    }

    public ViewGroup mo742a() {
        return this.f2634a;
    }

    public void mo743a(int i) {
        mo744a(i != 0 ? C0608b.m2863b(mo751b(), i) : null);
    }

    public void mo744a(Drawable drawable) {
        this.f2641h = drawable;
        m4537s();
    }

    public void mo745a(C0577a c0577a, C0560a c0560a) {
        this.f2634a.m4074a(c0577a, c0560a);
    }

    public void mo746a(be beVar) {
        if (this.f2639f != null && this.f2639f.getParent() == this.f2634a) {
            this.f2634a.removeView(this.f2639f);
        }
        this.f2639f = beVar;
        if (beVar != null && this.f2648o == 2) {
            this.f2634a.addView(this.f2639f, 0);
            C0747b c0747b = (C0747b) this.f2639f.getLayoutParams();
            c0747b.width = -2;
            c0747b.height = -2;
            c0747b.a = 8388691;
            beVar.setAllowCollapse(true);
        }
    }

    public void mo747a(Menu menu, C0577a c0577a) {
        if (this.f2647n == null) {
            this.f2647n = new C0809d(this.f2634a.getContext());
            this.f2647n.m2979a(C0524f.action_menu_presenter);
        }
        this.f2647n.mo527a(c0577a);
        this.f2634a.m4073a((C0643h) menu, this.f2647n);
    }

    public void m4547a(View view) {
        if (!(this.f2640g == null || (this.f2638e & 16) == 0)) {
            this.f2634a.removeView(this.f2640g);
        }
        this.f2640g = view;
        if (view != null && (this.f2638e & 16) != 0) {
            this.f2634a.addView(this.f2640g);
        }
    }

    public void mo748a(Callback callback) {
        this.f2636c = callback;
    }

    public void mo749a(CharSequence charSequence) {
        if (!this.f2644k) {
            m4535e(charSequence);
        }
    }

    public void mo750a(boolean z) {
        this.f2634a.setCollapsible(z);
    }

    public Context mo751b() {
        return this.f2634a.getContext();
    }

    public void mo752b(int i) {
        m4553b(i != 0 ? C0608b.m2863b(mo751b(), i) : null);
    }

    public void m4553b(Drawable drawable) {
        this.f2642i = drawable;
        m4537s();
    }

    public void m4554b(CharSequence charSequence) {
        this.f2644k = true;
        m4535e(charSequence);
    }

    public void mo753b(boolean z) {
    }

    public void mo754c(int i) {
        int i2 = this.f2638e ^ i;
        this.f2638e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m4539u();
                }
                m4538t();
            }
            if ((i2 & 3) != 0) {
                m4537s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2634a.setTitle(this.f2635b);
                    this.f2634a.setSubtitle(this.f2645l);
                } else {
                    this.f2634a.setTitle(null);
                    this.f2634a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f2640g != null) {
                if ((i & 16) != 0) {
                    this.f2634a.addView(this.f2640g);
                } else {
                    this.f2634a.removeView(this.f2640g);
                }
            }
        }
    }

    public void m4557c(Drawable drawable) {
        this.f2643j = drawable;
        m4538t();
    }

    public void m4558c(CharSequence charSequence) {
        this.f2645l = charSequence;
        if ((this.f2638e & 8) != 0) {
            this.f2634a.setSubtitle(charSequence);
        }
    }

    public boolean mo755c() {
        return this.f2634a.m4082g();
    }

    public void mo756d() {
        this.f2634a.m4083h();
    }

    public void mo757d(int i) {
        this.f2634a.setVisibility(i);
    }

    public void m4562d(CharSequence charSequence) {
        this.f2646m = charSequence;
        m4539u();
    }

    public CharSequence mo758e() {
        return this.f2634a.getTitle();
    }

    public void m4564e(int i) {
        if (i != this.f2649p) {
            this.f2649p = i;
            if (TextUtils.isEmpty(this.f2634a.getNavigationContentDescription())) {
                m4566f(this.f2649p);
            }
        }
    }

    public void mo759f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m4566f(int i) {
        m4562d(i == 0 ? null : mo751b().getString(i));
    }

    public void mo760g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean mo761h() {
        return this.f2634a.m4075a();
    }

    public boolean mo762i() {
        return this.f2634a.m4077b();
    }

    public boolean mo763j() {
        return this.f2634a.m4078c();
    }

    public boolean mo764k() {
        return this.f2634a.m4079d();
    }

    public boolean mo765l() {
        return this.f2634a.m4080e();
    }

    public void mo766m() {
        this.f2637d = true;
    }

    public void mo767n() {
        this.f2634a.m4081f();
    }

    public int mo768o() {
        return this.f2638e;
    }

    public int mo769p() {
        return this.f2648o;
    }

    public Menu mo770q() {
        return this.f2634a.getMenu();
    }
}
