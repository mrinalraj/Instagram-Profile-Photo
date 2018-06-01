package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0643h.C0626b;
import android.support.v7.widget.bm;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0626b, C0072p, OnItemClickListener {
    private static final int[] f1680a = new int[]{16842964, 16843049};
    private C0643h f1681b;
    private int f1682c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        bm a = bm.m4513a(context, attributeSet, f1680a, i, 0);
        if (a.m4531g(0)) {
            setBackgroundDrawable(a.m4517a(0));
        }
        if (a.m4531g(1)) {
            setDivider(a.m4517a(1));
        }
        a.m4518a();
    }

    public void mo31a(C0643h c0643h) {
        this.f1681b = c0643h;
    }

    public boolean mo501a(C0646j c0646j) {
        return this.f1681b.m3093a((MenuItem) c0646j, 0);
    }

    public int getWindowAnimations() {
        return this.f1682c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo501a((C0646j) getAdapter().getItem(i));
    }
}
