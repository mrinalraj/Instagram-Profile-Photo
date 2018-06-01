package android.support.v7.view.menu;

import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.view.menu.C0072p.C0070a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class C0642g extends BaseAdapter {
    static final int f1782a = C0525g.abc_popup_menu_item_layout;
    C0643h f1783b;
    private int f1784c = -1;
    private boolean f1785d;
    private final boolean f1786e;
    private final LayoutInflater f1787f;

    public C0642g(C0643h c0643h, LayoutInflater layoutInflater, boolean z) {
        this.f1786e = z;
        this.f1787f = layoutInflater;
        this.f1783b = c0643h;
        m3067b();
    }

    public C0643h m3064a() {
        return this.f1783b;
    }

    public C0646j m3065a(int i) {
        ArrayList l = this.f1786e ? this.f1783b.m3116l() : this.f1783b.m3113i();
        if (this.f1784c >= 0 && i >= this.f1784c) {
            i++;
        }
        return (C0646j) l.get(i);
    }

    public void m3066a(boolean z) {
        this.f1785d = z;
    }

    void m3067b() {
        C0646j r = this.f1783b.m3122r();
        if (r != null) {
            ArrayList l = this.f1783b.m3116l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0646j) l.get(i)) == r) {
                    this.f1784c = i;
                    return;
                }
            }
        }
        this.f1784c = -1;
    }

    public int getCount() {
        ArrayList l = this.f1786e ? this.f1783b.m3116l() : this.f1783b.m3113i();
        return this.f1784c < 0 ? l.size() : l.size() - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m3065a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f1787f.inflate(f1782a, viewGroup, false) : view;
        C0070a c0070a = (C0070a) inflate;
        if (this.f1785d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        c0070a.mo27a(m3065a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m3067b();
        super.notifyDataSetChanged();
    }
}
