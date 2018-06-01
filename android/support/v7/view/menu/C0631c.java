package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p015d.p016a.C0303b;
import android.support.v4.p015d.p016a.C0304c;
import android.support.v4.p018g.C0332a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class C0631c<T> extends C0630d<T> {
    final Context f1731a;
    private Map<C0303b, MenuItem> f1732c;
    private Map<C0304c, SubMenu> f1733d;

    C0631c(Context context, T t) {
        super(t);
        this.f1731a = context;
    }

    final MenuItem m2993a(MenuItem menuItem) {
        if (!(menuItem instanceof C0303b)) {
            return menuItem;
        }
        C0303b c0303b = (C0303b) menuItem;
        if (this.f1732c == null) {
            this.f1732c = new C0332a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1732c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0656q.m3186a(this.f1731a, c0303b);
        this.f1732c.put(c0303b, menuItem2);
        return menuItem2;
    }

    final SubMenu m2994a(SubMenu subMenu) {
        if (!(subMenu instanceof C0304c)) {
            return subMenu;
        }
        C0304c c0304c = (C0304c) subMenu;
        if (this.f1733d == null) {
            this.f1733d = new C0332a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1733d.get(c0304c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0656q.m3187a(this.f1731a, c0304c);
        this.f1733d.put(c0304c, subMenu2);
        return subMenu2;
    }

    final void m2995a() {
        if (this.f1732c != null) {
            this.f1732c.clear();
        }
        if (this.f1733d != null) {
            this.f1733d.clear();
        }
    }

    final void m2996a(int i) {
        if (this.f1732c != null) {
            Iterator it = this.f1732c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m2997b(int i) {
        if (this.f1732c != null) {
            Iterator it = this.f1732c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
