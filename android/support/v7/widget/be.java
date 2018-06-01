package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.C0546a.C0545c;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.view.C0612a;
import android.support.v7.widget.ar.C0670a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class be extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2577j = new DecelerateInterpolator();
    Runnable f2578a;
    ar f2579b;
    int f2580c;
    int f2581d;
    private C0789b f2582e;
    private Spinner f2583f;
    private boolean f2584g;
    private int f2585h;
    private int f2586i;

    private class C0788a extends BaseAdapter {
        final /* synthetic */ be f2569a;

        C0788a(be beVar) {
            this.f2569a = beVar;
        }

        public int getCount() {
            return this.f2569a.f2579b.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0790c) this.f2569a.f2579b.getChildAt(i)).m4471b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f2569a.m4476a((C0545c) getItem(i), true);
            }
            ((C0790c) view).m4470a((C0545c) getItem(i));
            return view;
        }
    }

    private class C0789b implements OnClickListener {
        final /* synthetic */ be f2570a;

        C0789b(be beVar) {
            this.f2570a = beVar;
        }

        public void onClick(View view) {
            ((C0790c) view).m4471b().m2522d();
            int childCount = this.f2570a.f2579b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f2570a.f2579b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class C0790c extends ar {
        final /* synthetic */ be f2571a;
        private final int[] f2572b = new int[]{16842964};
        private C0545c f2573c;
        private TextView f2574d;
        private ImageView f2575e;
        private View f2576f;

        public C0790c(be beVar, Context context, C0545c c0545c, boolean z) {
            this.f2571a = beVar;
            super(context, null, C0519a.actionBarTabStyle);
            this.f2573c = c0545c;
            bm a = bm.m4513a(context, null, this.f2572b, C0519a.actionBarTabStyle, 0);
            if (a.m4531g(0)) {
                setBackgroundDrawable(a.m4517a(0));
            }
            a.m4518a();
            if (z) {
                setGravity(8388627);
            }
            m4469a();
        }

        public void m4469a() {
            C0545c c0545c = this.f2573c;
            View c = c0545c.m2521c();
            if (c != null) {
                C0790c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f2576f = c;
                if (this.f2574d != null) {
                    this.f2574d.setVisibility(8);
                }
                if (this.f2575e != null) {
                    this.f2575e.setVisibility(8);
                    this.f2575e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f2576f != null) {
                removeView(this.f2576f);
                this.f2576f = null;
            }
            Drawable a = c0545c.m2519a();
            CharSequence b = c0545c.m2520b();
            if (a != null) {
                if (this.f2575e == null) {
                    View appCompatImageView = new AppCompatImageView(getContext());
                    LayoutParams c0670a = new C0670a(-2, -2);
                    c0670a.f1963h = 16;
                    appCompatImageView.setLayoutParams(c0670a);
                    addView(appCompatImageView, 0);
                    this.f2575e = appCompatImageView;
                }
                this.f2575e.setImageDrawable(a);
                this.f2575e.setVisibility(0);
            } else if (this.f2575e != null) {
                this.f2575e.setVisibility(8);
                this.f2575e.setImageDrawable(null);
            }
            int i = !TextUtils.isEmpty(b) ? 1 : 0;
            if (i != 0) {
                if (this.f2574d == null) {
                    appCompatImageView = new aa(getContext(), null, C0519a.actionBarTabTextStyle);
                    appCompatImageView.setEllipsize(TruncateAt.END);
                    c0670a = new C0670a(-2, -2);
                    c0670a.f1963h = 16;
                    appCompatImageView.setLayoutParams(c0670a);
                    addView(appCompatImageView);
                    this.f2574d = appCompatImageView;
                }
                this.f2574d.setText(b);
                this.f2574d.setVisibility(0);
            } else if (this.f2574d != null) {
                this.f2574d.setVisibility(8);
                this.f2574d.setText(null);
            }
            if (this.f2575e != null) {
                this.f2575e.setContentDescription(c0545c.m2523e());
            }
            bo.m4581a(this, i != 0 ? null : c0545c.m2523e());
        }

        public void m4470a(C0545c c0545c) {
            this.f2573c = c0545c;
            m4469a();
        }

        public C0545c m4471b() {
            return this.f2573c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0545c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0545c.class.getName());
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f2571a.f2580c > 0 && getMeasuredWidth() > this.f2571a.f2580c) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2571a.f2580c, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private boolean m4472a() {
        return this.f2583f != null && this.f2583f.getParent() == this;
    }

    private void m4473b() {
        if (!m4472a()) {
            if (this.f2583f == null) {
                this.f2583f = m4475d();
            }
            removeView(this.f2579b);
            addView(this.f2583f, new LayoutParams(-2, -1));
            if (this.f2583f.getAdapter() == null) {
                this.f2583f.setAdapter(new C0788a(this));
            }
            if (this.f2578a != null) {
                removeCallbacks(this.f2578a);
                this.f2578a = null;
            }
            this.f2583f.setSelection(this.f2586i);
        }
    }

    private boolean m4474c() {
        if (m4472a()) {
            removeView(this.f2583f);
            addView(this.f2579b, new LayoutParams(-2, -1));
            setTabSelected(this.f2583f.getSelectedItemPosition());
        }
        return false;
    }

    private Spinner m4475d() {
        Spinner c0844x = new C0844x(getContext(), null, C0519a.actionDropDownStyle);
        c0844x.setLayoutParams(new C0670a(-2, -1));
        c0844x.setOnItemSelectedListener(this);
        return c0844x;
    }

    C0790c m4476a(C0545c c0545c, boolean z) {
        C0790c c0790c = new C0790c(this, getContext(), c0545c, z);
        if (z) {
            c0790c.setBackgroundDrawable(null);
            c0790c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2585h));
        } else {
            c0790c.setFocusable(true);
            if (this.f2582e == null) {
                this.f2582e = new C0789b(this);
            }
            c0790c.setOnClickListener(this.f2582e);
        }
        return c0790c;
    }

    public void m4477a(int i) {
        final View childAt = this.f2579b.getChildAt(i);
        if (this.f2578a != null) {
            removeCallbacks(this.f2578a);
        }
        this.f2578a = new Runnable(this) {
            final /* synthetic */ be f2568b;

            public void run() {
                this.f2568b.smoothScrollTo(childAt.getLeft() - ((this.f2568b.getWidth() - childAt.getWidth()) / 2), 0);
                this.f2568b.f2578a = null;
            }
        };
        post(this.f2578a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2578a != null) {
            post(this.f2578a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0612a a = C0612a.m2870a(getContext());
        setContentHeight(a.m2875e());
        this.f2581d = a.m2877g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2578a != null) {
            removeCallbacks(this.f2578a);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0790c) view).m4471b().m2522d();
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2579b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2580c = -1;
        } else {
            if (childCount > 2) {
                this.f2580c = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2580c = MeasureSpec.getSize(i) / 2;
            }
            this.f2580c = Math.min(this.f2580c, this.f2581d);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f2585h, 1073741824);
        if (z || !this.f2584g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2579b.measure(0, mode);
            if (this.f2579b.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m4473b();
            } else {
                m4474c();
            }
        } else {
            m4474c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f2586i);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f2584g = z;
    }

    public void setContentHeight(int i) {
        this.f2585h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f2586i = i;
        int childCount = this.f2579b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2579b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m4477a(i);
            }
            i2++;
        }
        if (this.f2583f != null && i >= 0) {
            this.f2583f.setSelection(i);
        }
    }
}
