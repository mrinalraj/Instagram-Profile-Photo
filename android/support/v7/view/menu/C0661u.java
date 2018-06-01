package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.C0643h.C0560a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class C0661u extends C0643h implements SubMenu {
    private C0643h f1897d;
    private C0646j f1898e;

    public C0661u(Context context, C0643h c0643h, C0646j c0646j) {
        super(context);
        this.f1897d = c0643h;
        this.f1898e = c0646j;
    }

    public String mo560a() {
        int itemId = this.f1898e != null ? this.f1898e.getItemId() : 0;
        return itemId == 0 ? null : super.mo560a() + ":" + itemId;
    }

    public void mo561a(C0560a c0560a) {
        this.f1897d.mo561a(c0560a);
    }

    boolean mo562a(C0643h c0643h, MenuItem menuItem) {
        return super.mo562a(c0643h, menuItem) || this.f1897d.mo562a(c0643h, menuItem);
    }

    public boolean mo563b() {
        return this.f1897d.mo563b();
    }

    public boolean mo564c() {
        return this.f1897d.mo564c();
    }

    public boolean mo565c(C0646j c0646j) {
        return this.f1897d.mo565c(c0646j);
    }

    public boolean mo566d(C0646j c0646j) {
        return this.f1897d.mo566d(c0646j);
    }

    public MenuItem getItem() {
        return this.f1898e;
    }

    public C0643h mo567p() {
        return this.f1897d.mo567p();
    }

    public Menu m3217s() {
        return this.f1897d;
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m3109e(i);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m3078a(drawable);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m3106d(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m3080a(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m3079a(view);
    }

    public SubMenu setIcon(int i) {
        this.f1898e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1898e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f1897d.setQwertyMode(z);
    }
}
