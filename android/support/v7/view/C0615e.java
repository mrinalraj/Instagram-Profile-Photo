package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0597b.C0580a;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0643h.C0560a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class C0615e extends C0597b implements C0560a {
    private Context f1594a;
    private ActionBarContextView f1595b;
    private C0580a f1596c;
    private WeakReference<View> f1597d;
    private boolean f1598e;
    private boolean f1599f;
    private C0643h f1600g;

    public C0615e(Context context, ActionBarContextView actionBarContextView, C0580a c0580a, boolean z) {
        this.f1594a = context;
        this.f1595b = actionBarContextView;
        this.f1596c = c0580a;
        this.f1600g = new C0643h(actionBarContextView.getContext()).m3077a(1);
        this.f1600g.mo561a((C0560a) this);
        this.f1599f = z;
    }

    public MenuInflater mo475a() {
        return new C0620g(this.f1595b.getContext());
    }

    public void mo476a(int i) {
        mo482b(this.f1594a.getString(i));
    }

    public void mo429a(C0643h c0643h) {
        mo484d();
        this.f1595b.mo570a();
    }

    public void mo477a(View view) {
        this.f1595b.setCustomView(view);
        this.f1597d = view != null ? new WeakReference(view) : null;
    }

    public void mo478a(CharSequence charSequence) {
        this.f1595b.setSubtitle(charSequence);
    }

    public void mo479a(boolean z) {
        super.mo479a(z);
        this.f1595b.setTitleOptional(z);
    }

    public boolean mo433a(C0643h c0643h, MenuItem menuItem) {
        return this.f1596c.mo456a((C0597b) this, menuItem);
    }

    public Menu mo480b() {
        return this.f1600g;
    }

    public void mo481b(int i) {
        mo478a(this.f1594a.getString(i));
    }

    public void mo482b(CharSequence charSequence) {
        this.f1595b.setTitle(charSequence);
    }

    public void mo483c() {
        if (!this.f1598e) {
            this.f1598e = true;
            this.f1595b.sendAccessibilityEvent(32);
            this.f1596c.mo454a(this);
        }
    }

    public void mo484d() {
        this.f1596c.mo457b(this, this.f1600g);
    }

    public CharSequence mo485f() {
        return this.f1595b.getTitle();
    }

    public CharSequence mo486g() {
        return this.f1595b.getSubtitle();
    }

    public boolean mo487h() {
        return this.f1595b.m3234d();
    }

    public View mo488i() {
        return this.f1597d != null ? (View) this.f1597d.get() : null;
    }
}
