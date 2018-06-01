package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.p008h.C0397c;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.p021a.C0529a.C0526h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    final C0674a f1991a;
    final FrameLayout f1992b;
    final FrameLayout f1993c;
    C0397c f1994d;
    final DataSetObserver f1995e;
    OnDismissListener f1996f;
    boolean f1997g;
    int f1998h;
    private final C0675b f1999i;
    private final ar f2000j;
    private final ImageView f2001k;
    private final int f2002l;
    private final OnGlobalLayoutListener f2003m;
    private as f2004n;
    private boolean f2005o;
    private int f2006p;

    public static class InnerLayout extends ar {
        private static final int[] f1983a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            bm a = bm.m4512a(context, attributeSet, f1983a);
            setBackgroundDrawable(a.m4517a(0));
            a.m4518a();
        }
    }

    private class C0674a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView f1984a;
        private C0815e f1985b;
        private int f1986c;
        private boolean f1987d;
        private boolean f1988e;
        private boolean f1989f;

        public int m3291a() {
            int i = 0;
            int i2 = this.f1986c;
            this.f1986c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f1986c = i2;
            return i3;
        }

        public void m3292a(int i) {
            if (this.f1986c != i) {
                this.f1986c = i;
                notifyDataSetChanged();
            }
        }

        public void m3293a(C0815e c0815e) {
            C0815e d = this.f1984a.f1991a.m3298d();
            if (d != null && this.f1984a.isShown()) {
                d.unregisterObserver(this.f1984a.f1995e);
            }
            this.f1985b = c0815e;
            if (c0815e != null && this.f1984a.isShown()) {
                c0815e.registerObserver(this.f1984a.f1995e);
            }
            notifyDataSetChanged();
        }

        public void m3294a(boolean z) {
            if (this.f1989f != z) {
                this.f1989f = z;
                notifyDataSetChanged();
            }
        }

        public void m3295a(boolean z, boolean z2) {
            if (this.f1987d != z || this.f1988e != z2) {
                this.f1987d = z;
                this.f1988e = z2;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m3296b() {
            return this.f1985b.m4673b();
        }

        public int m3297c() {
            return this.f1985b.m4669a();
        }

        public C0815e m3298d() {
            return this.f1985b;
        }

        public boolean m3299e() {
            return this.f1987d;
        }

        public int getCount() {
            int a = this.f1985b.m4669a();
            if (!(this.f1987d || this.f1985b.m4673b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1986c);
            return this.f1989f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f1987d || this.f1985b.m4673b() == null)) {
                        i++;
                    }
                    return this.f1985b.m4671a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (this.f1989f && i == getCount() - 1) ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0524f.list_item) {
                        view = LayoutInflater.from(this.f1984a.getContext()).inflate(C0525g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1984a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0524f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0524f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1987d && i == 0 && this.f1988e) {
                        view.setActivated(true);
                        return view;
                    }
                    view.setActivated(false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f1984a.getContext()).inflate(C0525g.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(C0524f.title)).setText(this.f1984a.getContext().getString(C0526h.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class C0675b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f1990a;

        private void m3300a() {
            if (this.f1990a.f1996f != null) {
                this.f1990a.f1996f.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == this.f1990a.f1993c) {
                this.f1990a.m3303b();
                Intent b = this.f1990a.f1991a.m3298d().m4672b(this.f1990a.f1991a.m3298d().m4670a(this.f1990a.f1991a.m3296b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f1990a.getContext().startActivity(b);
                }
            } else if (view == this.f1990a.f1992b) {
                this.f1990a.f1997g = false;
                this.f1990a.m3301a(this.f1990a.f1998h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m3300a();
            if (this.f1990a.f1994d != null) {
                this.f1990a.f1994d.m1778a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0674a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f1990a.m3303b();
                    if (!this.f1990a.f1997g) {
                        if (!this.f1990a.f1991a.m3299e()) {
                            i++;
                        }
                        Intent b = this.f1990a.f1991a.m3298d().m4672b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f1990a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f1990a.f1991a.m3298d().m4674c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f1990a.m3301a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1990a.f1993c) {
                if (this.f1990a.f1991a.getCount() > 0) {
                    this.f1990a.f1997g = true;
                    this.f1990a.m3301a(this.f1990a.f1998h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    void m3301a(int i) {
        if (this.f1991a.m3298d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f2003m);
        boolean z = this.f1993c.getVisibility() == 0;
        int c = this.f1991a.m3297c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f1991a.m3294a(false);
            this.f1991a.m3292a(i);
        } else {
            this.f1991a.m3294a(true);
            this.f1991a.m3292a(i - 1);
        }
        as listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.mo545d()) {
            if (this.f1997g || !z) {
                this.f1991a.m3295a(true, z);
            } else {
                this.f1991a.m3295a(false, false);
            }
            listPopupWindow.m4348g(Math.min(this.f1991a.m3291a(), this.f2002l));
            listPopupWindow.mo535a();
            if (this.f1994d != null) {
                this.f1994d.m1778a(true);
            }
            listPopupWindow.mo546e().setContentDescription(getContext().getString(C0526h.abc_activitychooserview_choose_application));
            listPopupWindow.mo546e().setSelector(new ColorDrawable(0));
        }
    }

    public boolean m3302a() {
        if (m3304c() || !this.f2005o) {
            return false;
        }
        this.f1997g = false;
        m3301a(this.f1998h);
        return true;
    }

    public boolean m3303b() {
        if (m3304c()) {
            getListPopupWindow().mo542c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f2003m);
            }
        }
        return true;
    }

    public boolean m3304c() {
        return getListPopupWindow().mo545d();
    }

    public C0815e getDataModel() {
        return this.f1991a.m3298d();
    }

    as getListPopupWindow() {
        if (this.f2004n == null) {
            this.f2004n = new as(getContext());
            this.f2004n.mo789a(this.f1991a);
            this.f2004n.m4339b((View) this);
            this.f2004n.m4337a(true);
            this.f2004n.m4334a(this.f1999i);
            this.f2004n.m4336a(this.f1999i);
        }
        return this.f2004n;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0815e d = this.f1991a.m3298d();
        if (d != null) {
            d.registerObserver(this.f1995e);
        }
        this.f2005o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0815e d = this.f1991a.m3298d();
        if (d != null) {
            d.unregisterObserver(this.f1995e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2003m);
        }
        if (m3304c()) {
            m3303b();
        }
        this.f2005o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2000j.layout(0, 0, i3 - i, i4 - i2);
        if (!m3304c()) {
            m3303b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f2000j;
        if (this.f1993c.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0815e c0815e) {
        this.f1991a.m3293a(c0815e);
        if (m3304c()) {
            m3303b();
            m3302a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f2006p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f2001k.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2001k.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1998h = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1996f = onDismissListener;
    }

    public void setProvider(C0397c c0397c) {
        this.f1994d = c0397c;
    }
}
