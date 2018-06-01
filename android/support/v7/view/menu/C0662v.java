package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p015d.p016a.C0304c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class C0662v extends C0657r implements SubMenu {
    C0662v(Context context, C0304c c0304c) {
        super(context, c0304c);
    }

    public C0304c m3218b() {
        return (C0304c) this.b;
    }

    public void clearHeader() {
        m3218b().clearHeader();
    }

    public MenuItem getItem() {
        return m2993a(m3218b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        m3218b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m3218b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        m3218b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m3218b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m3218b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        m3218b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m3218b().setIcon(drawable);
        return this;
    }
}
