package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p021a.C0529a.C0522d;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.widget.av;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class C0660t extends C0638m implements C0628o, OnKeyListener, OnItemClickListener, OnDismissListener {
    final av f1877a;
    View f1878b;
    private final Context f1879c;
    private final C0643h f1880d;
    private final C0642g f1881e;
    private final boolean f1882f;
    private final int f1883g;
    private final int f1884h;
    private final int f1885i;
    private final OnGlobalLayoutListener f1886j = new C06581(this);
    private final OnAttachStateChangeListener f1887k = new C06592(this);
    private OnDismissListener f1888l;
    private View f1889m;
    private C0577a f1890n;
    private ViewTreeObserver f1891o;
    private boolean f1892p;
    private boolean f1893q;
    private int f1894r;
    private int f1895s = 0;
    private boolean f1896t;

    class C06581 implements OnGlobalLayoutListener {
        final /* synthetic */ C0660t f1875a;

        C06581(C0660t c0660t) {
            this.f1875a = c0660t;
        }

        public void onGlobalLayout() {
            if (this.f1875a.mo545d() && !this.f1875a.f1877a.m4349g()) {
                View view = this.f1875a.f1878b;
                if (view == null || !view.isShown()) {
                    this.f1875a.mo542c();
                } else {
                    this.f1875a.f1877a.mo535a();
                }
            }
        }
    }

    class C06592 implements OnAttachStateChangeListener {
        final /* synthetic */ C0660t f1876a;

        C06592(C0660t c0660t) {
            this.f1876a = c0660t;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f1876a.f1891o != null) {
                if (!this.f1876a.f1891o.isAlive()) {
                    this.f1876a.f1891o = view.getViewTreeObserver();
                }
                this.f1876a.f1891o.removeGlobalOnLayoutListener(this.f1876a.f1886j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public C0660t(Context context, C0643h c0643h, View view, int i, int i2, boolean z) {
        this.f1879c = context;
        this.f1880d = c0643h;
        this.f1882f = z;
        this.f1881e = new C0642g(c0643h, LayoutInflater.from(context), this.f1882f);
        this.f1884h = i;
        this.f1885i = i2;
        Resources resources = context.getResources();
        this.f1883g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0522d.abc_config_prefDialogWidth));
        this.f1889m = view;
        this.f1877a = new av(this.f1879c, null, this.f1884h, this.f1885i);
        c0643h.m3088a((C0628o) this, context);
    }

    private boolean m3191h() {
        if (mo545d()) {
            return true;
        }
        if (this.f1892p || this.f1889m == null) {
            return false;
        }
        this.f1878b = this.f1889m;
        this.f1877a.m4336a((OnDismissListener) this);
        this.f1877a.m4334a((OnItemClickListener) this);
        this.f1877a.m4337a(true);
        View view = this.f1878b;
        boolean z = this.f1891o == null;
        this.f1891o = view.getViewTreeObserver();
        if (z) {
            this.f1891o.addOnGlobalLayoutListener(this.f1886j);
        }
        view.addOnAttachStateChangeListener(this.f1887k);
        this.f1877a.m4339b(view);
        this.f1877a.m4346e(this.f1895s);
        if (!this.f1893q) {
            this.f1894r = C0638m.m3007a(this.f1881e, null, this.f1879c, this.f1883g);
            this.f1893q = true;
        }
        this.f1877a.m4348g(this.f1894r);
        this.f1877a.m4351h(2);
        this.f1877a.m4332a(m3023g());
        this.f1877a.mo535a();
        ViewGroup e = this.f1877a.mo546e();
        e.setOnKeyListener(this);
        if (this.f1896t && this.f1880d.m3117m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1879c).inflate(C0525g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1880d.m3117m());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, null, false);
        }
        this.f1877a.mo789a(this.f1881e);
        this.f1877a.mo535a();
        return true;
    }

    public void mo535a() {
        if (!m3191h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void mo536a(int i) {
        this.f1895s = i;
    }

    public void mo537a(C0643h c0643h) {
    }

    public void mo526a(C0643h c0643h, boolean z) {
        if (c0643h == this.f1880d) {
            mo542c();
            if (this.f1890n != null) {
                this.f1890n.mo452a(c0643h, z);
            }
        }
    }

    public void mo527a(C0577a c0577a) {
        this.f1890n = c0577a;
    }

    public void mo538a(View view) {
        this.f1889m = view;
    }

    public void mo539a(OnDismissListener onDismissListener) {
        this.f1888l = onDismissListener;
    }

    public void mo540a(boolean z) {
        this.f1881e.m3066a(z);
    }

    public boolean mo529a(C0661u c0661u) {
        if (c0661u.hasVisibleItems()) {
            C0655n c0655n = new C0655n(this.f1879c, c0661u, this.f1878b, this.f1882f, this.f1884h, this.f1885i);
            c0655n.m3175a(this.f1890n);
            c0655n.m3178a(C0638m.m3009b((C0643h) c0661u));
            c0655n.m3174a(this.f1895s);
            c0655n.m3177a(this.f1888l);
            this.f1888l = null;
            this.f1880d.m3091a(false);
            if (c0655n.m3179a(this.f1877a.m4354j(), this.f1877a.m4355k())) {
                if (this.f1890n != null) {
                    this.f1890n.mo453a(c0661u);
                }
                return true;
            }
        }
        return false;
    }

    public void mo541b(int i) {
        this.f1877a.m4342c(i);
    }

    public void mo530b(boolean z) {
        this.f1893q = false;
        if (this.f1881e != null) {
            this.f1881e.notifyDataSetChanged();
        }
    }

    public boolean mo531b() {
        return false;
    }

    public void mo542c() {
        if (mo545d()) {
            this.f1877a.mo542c();
        }
    }

    public void mo543c(int i) {
        this.f1877a.m4343d(i);
    }

    public void mo544c(boolean z) {
        this.f1896t = z;
    }

    public boolean mo545d() {
        return !this.f1892p && this.f1877a.mo545d();
    }

    public ListView mo546e() {
        return this.f1877a.mo546e();
    }

    public void onDismiss() {
        this.f1892p = true;
        this.f1880d.close();
        if (this.f1891o != null) {
            if (!this.f1891o.isAlive()) {
                this.f1891o = this.f1878b.getViewTreeObserver();
            }
            this.f1891o.removeGlobalOnLayoutListener(this.f1886j);
            this.f1891o = null;
        }
        this.f1878b.removeOnAttachStateChangeListener(this.f1887k);
        if (this.f1888l != null) {
            this.f1888l.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo542c();
        return true;
    }
}
