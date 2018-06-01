package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class C0638m implements C0628o, C0637s, OnItemClickListener {
    private Rect f1744a;

    C0638m() {
    }

    protected static int m3007a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            ViewGroup frameLayout = viewGroup2 == null ? new FrameLayout(context) : viewGroup2;
            view = listAdapter.getView(i2, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth <= i4) {
                measuredWidth = i4;
            }
            i2++;
            i4 = measuredWidth;
            viewGroup2 = frameLayout;
        }
        return i4;
    }

    protected static C0642g m3008a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0642g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0642g) listAdapter;
    }

    protected static boolean m3009b(C0643h c0643h) {
        int size = c0643h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0643h.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void mo536a(int i);

    public void mo525a(Context context, C0643h c0643h) {
    }

    public void m3012a(Rect rect) {
        this.f1744a = rect;
    }

    public abstract void mo537a(C0643h c0643h);

    public abstract void mo538a(View view);

    public abstract void mo539a(OnDismissListener onDismissListener);

    public abstract void mo540a(boolean z);

    public boolean mo528a(C0643h c0643h, C0646j c0646j) {
        return false;
    }

    public abstract void mo541b(int i);

    public boolean mo532b(C0643h c0643h, C0646j c0646j) {
        return false;
    }

    public abstract void mo543c(int i);

    public abstract void mo544c(boolean z);

    protected boolean mo547f() {
        return true;
    }

    public Rect m3023g() {
        return this.f1744a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        C0638m.m3008a(listAdapter).f1783b.m3094a((MenuItem) listAdapter.getItem(i), (C0628o) this, mo547f() ? 0 : 4);
    }
}
