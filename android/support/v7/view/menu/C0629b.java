package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0072p.C0070a;
import android.support.v7.view.menu.C0628o.C0577a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class C0629b implements C0628o {
    protected Context f1720a;
    protected Context f1721b;
    protected C0643h f1722c;
    protected LayoutInflater f1723d;
    protected LayoutInflater f1724e;
    protected C0072p f1725f;
    private C0577a f1726g;
    private int f1727h;
    private int f1728i;
    private int f1729j;

    public C0629b(Context context, int i, int i2) {
        this.f1720a = context;
        this.f1723d = LayoutInflater.from(context);
        this.f1727h = i;
        this.f1728i = i2;
    }

    public C0577a m2976a() {
        return this.f1726g;
    }

    public C0072p mo775a(ViewGroup viewGroup) {
        if (this.f1725f == null) {
            this.f1725f = (C0072p) this.f1723d.inflate(this.f1727h, viewGroup, false);
            this.f1725f.mo31a(this.f1722c);
            mo530b(true);
        }
        return this.f1725f;
    }

    public View mo776a(C0646j c0646j, View view, ViewGroup viewGroup) {
        C0070a b = view instanceof C0070a ? (C0070a) view : m2989b(viewGroup);
        mo777a(c0646j, b);
        return (View) b;
    }

    public void m2979a(int i) {
        this.f1729j = i;
    }

    public void mo525a(Context context, C0643h c0643h) {
        this.f1721b = context;
        this.f1724e = LayoutInflater.from(this.f1721b);
        this.f1722c = c0643h;
    }

    public void mo526a(C0643h c0643h, boolean z) {
        if (this.f1726g != null) {
            this.f1726g.mo452a(c0643h, z);
        }
    }

    public abstract void mo777a(C0646j c0646j, C0070a c0070a);

    public void mo527a(C0577a c0577a) {
        this.f1726g = c0577a;
    }

    protected void m2984a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1725f).addView(view, i);
    }

    public boolean mo779a(int i, C0646j c0646j) {
        return true;
    }

    public boolean mo528a(C0643h c0643h, C0646j c0646j) {
        return false;
    }

    public boolean mo529a(C0661u c0661u) {
        return this.f1726g != null ? this.f1726g.mo453a(c0661u) : false;
    }

    protected boolean mo780a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public C0070a m2989b(ViewGroup viewGroup) {
        return (C0070a) this.f1723d.inflate(this.f1728i, viewGroup, false);
    }

    public void mo530b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1725f;
        if (viewGroup != null) {
            int i;
            if (this.f1722c != null) {
                this.f1722c.m3114j();
                ArrayList i2 = this.f1722c.m3113i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0646j c0646j = (C0646j) i2.get(i3);
                    if (mo779a(i, c0646j)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0646j itemData = childAt instanceof C0070a ? ((C0070a) childAt).getItemData() : null;
                        View a = mo776a(c0646j, childAt, viewGroup);
                        if (c0646j != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            m2984a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo780a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean mo531b() {
        return false;
    }

    public boolean mo532b(C0643h c0643h, C0646j c0646j) {
        return false;
    }
}
