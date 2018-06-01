package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.view.menu.C0072p.C0070a;
import android.support.v7.view.menu.C0628o.C0577a;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class C0641f implements C0628o, OnItemClickListener {
    Context f1773a;
    LayoutInflater f1774b;
    C0643h f1775c;
    ExpandedMenuView f1776d;
    int f1777e;
    int f1778f;
    int f1779g;
    C0640a f1780h;
    private C0577a f1781i;

    private class C0640a extends BaseAdapter {
        final /* synthetic */ C0641f f1771a;
        private int f1772b = -1;

        public C0640a(C0641f c0641f) {
            this.f1771a = c0641f;
            m3053a();
        }

        public C0646j m3052a(int i) {
            ArrayList l = this.f1771a.f1775c.m3116l();
            int i2 = this.f1771a.f1777e + i;
            if (this.f1772b >= 0 && i2 >= this.f1772b) {
                i2++;
            }
            return (C0646j) l.get(i2);
        }

        void m3053a() {
            C0646j r = this.f1771a.f1775c.m3122r();
            if (r != null) {
                ArrayList l = this.f1771a.f1775c.m3116l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0646j) l.get(i)) == r) {
                        this.f1772b = i;
                        return;
                    }
                }
            }
            this.f1772b = -1;
        }

        public int getCount() {
            int size = this.f1771a.f1775c.m3116l().size() - this.f1771a.f1777e;
            return this.f1772b < 0 ? size : size - 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return m3052a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.f1771a.f1774b.inflate(this.f1771a.f1779g, viewGroup, false) : view;
            ((C0070a) inflate).mo27a(m3052a(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            m3053a();
            super.notifyDataSetChanged();
        }
    }

    public C0641f(int i, int i2) {
        this.f1779g = i;
        this.f1778f = i2;
    }

    public C0641f(Context context, int i) {
        this(i, 0);
        this.f1773a = context;
        this.f1774b = LayoutInflater.from(this.f1773a);
    }

    public C0072p m3054a(ViewGroup viewGroup) {
        if (this.f1776d == null) {
            this.f1776d = (ExpandedMenuView) this.f1774b.inflate(C0525g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1780h == null) {
                this.f1780h = new C0640a(this);
            }
            this.f1776d.setAdapter(this.f1780h);
            this.f1776d.setOnItemClickListener(this);
        }
        return this.f1776d;
    }

    public ListAdapter m3055a() {
        if (this.f1780h == null) {
            this.f1780h = new C0640a(this);
        }
        return this.f1780h;
    }

    public void mo525a(Context context, C0643h c0643h) {
        if (this.f1778f != 0) {
            this.f1773a = new ContextThemeWrapper(context, this.f1778f);
            this.f1774b = LayoutInflater.from(this.f1773a);
        } else if (this.f1773a != null) {
            this.f1773a = context;
            if (this.f1774b == null) {
                this.f1774b = LayoutInflater.from(this.f1773a);
            }
        }
        this.f1775c = c0643h;
        if (this.f1780h != null) {
            this.f1780h.notifyDataSetChanged();
        }
    }

    public void mo526a(C0643h c0643h, boolean z) {
        if (this.f1781i != null) {
            this.f1781i.mo452a(c0643h, z);
        }
    }

    public void mo527a(C0577a c0577a) {
        this.f1781i = c0577a;
    }

    public boolean mo528a(C0643h c0643h, C0646j c0646j) {
        return false;
    }

    public boolean mo529a(C0661u c0661u) {
        if (!c0661u.hasVisibleItems()) {
            return false;
        }
        new C0644i(c0661u).m3124a(null);
        if (this.f1781i != null) {
            this.f1781i.mo453a(c0661u);
        }
        return true;
    }

    public void mo530b(boolean z) {
        if (this.f1780h != null) {
            this.f1780h.notifyDataSetChanged();
        }
    }

    public boolean mo531b() {
        return false;
    }

    public boolean mo532b(C0643h c0643h, C0646j c0646j) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1775c.m3094a(this.f1780h.m3052a(i), (C0628o) this, 0);
    }
}
