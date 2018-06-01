package android.support.v7.view;

import android.content.Context;
import android.support.v4.p015d.p016a.C0302a;
import android.support.v4.p015d.p016a.C0303b;
import android.support.v4.p018g.C0331l;
import android.support.v7.view.C0597b.C0580a;
import android.support.v7.view.menu.C0656q;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class C0617f extends ActionMode {
    final Context f1605a;
    final C0597b f1606b;

    public static class C0616a implements C0580a {
        final Callback f1601a;
        final Context f1602b;
        final ArrayList<C0617f> f1603c = new ArrayList();
        final C0331l<Menu, Menu> f1604d = new C0331l();

        public C0616a(Context context, Callback callback) {
            this.f1602b = context;
            this.f1601a = callback;
        }

        private Menu m2900a(Menu menu) {
            Menu menu2 = (Menu) this.f1604d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0656q.m3185a(this.f1602b, (C0302a) menu);
            this.f1604d.put(menu, menu2);
            return menu2;
        }

        public void mo454a(C0597b c0597b) {
            this.f1601a.onDestroyActionMode(m2904b(c0597b));
        }

        public boolean mo455a(C0597b c0597b, Menu menu) {
            return this.f1601a.onCreateActionMode(m2904b(c0597b), m2900a(menu));
        }

        public boolean mo456a(C0597b c0597b, MenuItem menuItem) {
            return this.f1601a.onActionItemClicked(m2904b(c0597b), C0656q.m3186a(this.f1602b, (C0303b) menuItem));
        }

        public ActionMode m2904b(C0597b c0597b) {
            int size = this.f1603c.size();
            for (int i = 0; i < size; i++) {
                C0617f c0617f = (C0617f) this.f1603c.get(i);
                if (c0617f != null && c0617f.f1606b == c0597b) {
                    return c0617f;
                }
            }
            ActionMode c0617f2 = new C0617f(this.f1602b, c0597b);
            this.f1603c.add(c0617f2);
            return c0617f2;
        }

        public boolean mo457b(C0597b c0597b, Menu menu) {
            return this.f1601a.onPrepareActionMode(m2904b(c0597b), m2900a(menu));
        }
    }

    public C0617f(Context context, C0597b c0597b) {
        this.f1605a = context;
        this.f1606b = c0597b;
    }

    public void finish() {
        this.f1606b.mo483c();
    }

    public View getCustomView() {
        return this.f1606b.mo488i();
    }

    public Menu getMenu() {
        return C0656q.m3185a(this.f1605a, (C0302a) this.f1606b.mo480b());
    }

    public MenuInflater getMenuInflater() {
        return this.f1606b.mo475a();
    }

    public CharSequence getSubtitle() {
        return this.f1606b.mo486g();
    }

    public Object getTag() {
        return this.f1606b.m2796j();
    }

    public CharSequence getTitle() {
        return this.f1606b.mo485f();
    }

    public boolean getTitleOptionalHint() {
        return this.f1606b.m2797k();
    }

    public void invalidate() {
        this.f1606b.mo484d();
    }

    public boolean isTitleOptional() {
        return this.f1606b.mo487h();
    }

    public void setCustomView(View view) {
        this.f1606b.mo477a(view);
    }

    public void setSubtitle(int i) {
        this.f1606b.mo481b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1606b.mo478a(charSequence);
    }

    public void setTag(Object obj) {
        this.f1606b.m2785a(obj);
    }

    public void setTitle(int i) {
        this.f1606b.mo476a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1606b.mo482b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1606b.mo479a(z);
    }
}
