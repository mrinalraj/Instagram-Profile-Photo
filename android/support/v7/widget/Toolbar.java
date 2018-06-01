package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.p008h.C0079a;
import android.support.v4.p008h.C0398d;
import android.support.v4.p008h.C0402f;
import android.support.v4.p008h.C0425s;
import android.support.v7.app.C0546a.C0543a;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.p023c.p024a.C0608b;
import android.support.v7.view.C0613c;
import android.support.v7.view.C0620g;
import android.support.v7.view.menu.C0628o;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0643h.C0560a;
import android.support.v7.view.menu.C0646j;
import android.support.v7.view.menu.C0661u;
import android.support.v7.widget.ActionMenuView.C0673e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int f2313A;
    private int f2314B;
    private boolean f2315C;
    private boolean f2316D;
    private final ArrayList<View> f2317E;
    private final ArrayList<View> f2318F;
    private final int[] f2319G;
    private final C0673e f2320H;
    private bn f2321I;
    private C0809d f2322J;
    private C0746a f2323K;
    private C0577a f2324L;
    private C0560a f2325M;
    private boolean f2326N;
    private final Runnable f2327O;
    ImageButton f2328a;
    View f2329b;
    int f2330c;
    C0748c f2331d;
    private ActionMenuView f2332e;
    private TextView f2333f;
    private TextView f2334g;
    private ImageButton f2335h;
    private ImageView f2336i;
    private Drawable f2337j;
    private CharSequence f2338k;
    private Context f2339l;
    private int f2340m;
    private int f2341n;
    private int f2342o;
    private int f2343p;
    private int f2344q;
    private int f2345r;
    private int f2346s;
    private int f2347t;
    private bc f2348u;
    private int f2349v;
    private int f2350w;
    private int f2351x;
    private CharSequence f2352y;
    private CharSequence f2353z;

    class C07431 implements C0673e {
        final /* synthetic */ Toolbar f2304a;

        C07431(Toolbar toolbar) {
            this.f2304a = toolbar;
        }

        public boolean mo677a(MenuItem menuItem) {
            return this.f2304a.f2331d != null ? this.f2304a.f2331d.m4044a(menuItem) : false;
        }
    }

    class C07442 implements Runnable {
        final /* synthetic */ Toolbar f2305a;

        C07442(Toolbar toolbar) {
            this.f2305a = toolbar;
        }

        public void run() {
            this.f2305a.m4079d();
        }
    }

    class C07453 implements OnClickListener {
        final /* synthetic */ Toolbar f2306a;

        C07453(Toolbar toolbar) {
            this.f2306a = toolbar;
        }

        public void onClick(View view) {
            this.f2306a.m4083h();
        }
    }

    private class C0746a implements C0628o {
        C0643h f2307a;
        C0646j f2308b;
        final /* synthetic */ Toolbar f2309c;

        C0746a(Toolbar toolbar) {
            this.f2309c = toolbar;
        }

        public void mo525a(Context context, C0643h c0643h) {
            if (!(this.f2307a == null || this.f2308b == null)) {
                this.f2307a.mo566d(this.f2308b);
            }
            this.f2307a = c0643h;
        }

        public void mo526a(C0643h c0643h, boolean z) {
        }

        public void mo527a(C0577a c0577a) {
        }

        public boolean mo528a(C0643h c0643h, C0646j c0646j) {
            this.f2309c.m4084i();
            if (this.f2309c.f2328a.getParent() != this.f2309c) {
                this.f2309c.addView(this.f2309c.f2328a);
            }
            this.f2309c.f2329b = c0646j.getActionView();
            this.f2308b = c0646j;
            if (this.f2309c.f2329b.getParent() != this.f2309c) {
                LayoutParams j = this.f2309c.m4085j();
                j.a = 8388611 | (this.f2309c.f2330c & 112);
                j.f2310b = 2;
                this.f2309c.f2329b.setLayoutParams(j);
                this.f2309c.addView(this.f2309c.f2329b);
            }
            this.f2309c.m4086k();
            this.f2309c.requestLayout();
            c0646j.m3147e(true);
            if (this.f2309c.f2329b instanceof C0613c) {
                ((C0613c) this.f2309c.f2329b).mo553a();
            }
            return true;
        }

        public boolean mo529a(C0661u c0661u) {
            return false;
        }

        public void mo530b(boolean z) {
            Object obj = null;
            if (this.f2308b != null) {
                if (this.f2307a != null) {
                    int size = this.f2307a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f2307a.getItem(i) == this.f2308b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo532b(this.f2307a, this.f2308b);
                }
            }
        }

        public boolean mo531b() {
            return false;
        }

        public boolean mo532b(C0643h c0643h, C0646j c0646j) {
            if (this.f2309c.f2329b instanceof C0613c) {
                ((C0613c) this.f2309c.f2329b).mo554b();
            }
            this.f2309c.removeView(this.f2309c.f2329b);
            this.f2309c.removeView(this.f2309c.f2328a);
            this.f2309c.f2329b = null;
            this.f2309c.m4087l();
            this.f2308b = null;
            this.f2309c.requestLayout();
            c0646j.m3147e(false);
            return true;
        }
    }

    public static class C0747b extends C0543a {
        int f2310b;

        public C0747b(int i, int i2) {
            super(i, i2);
            this.f2310b = 0;
            this.a = 8388627;
        }

        public C0747b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2310b = 0;
        }

        public C0747b(C0543a c0543a) {
            super(c0543a);
            this.f2310b = 0;
        }

        public C0747b(C0747b c0747b) {
            super((C0543a) c0747b);
            this.f2310b = 0;
            this.f2310b = c0747b.f2310b;
        }

        public C0747b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2310b = 0;
        }

        public C0747b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f2310b = 0;
            m4043a(marginLayoutParams);
        }

        void m4043a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface C0748c {
        boolean m4044a(MenuItem menuItem);
    }

    public static class C0750d extends C0079a {
        public static final Creator<C0750d> CREATOR = new C07491();
        int f2311a;
        boolean f2312b;

        static class C07491 implements ClassLoaderCreator<C0750d> {
            C07491() {
            }

            public C0750d m4045a(Parcel parcel) {
                return new C0750d(parcel, null);
            }

            public C0750d m4046a(Parcel parcel, ClassLoader classLoader) {
                return new C0750d(parcel, classLoader);
            }

            public C0750d[] m4047a(int i) {
                return new C0750d[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4045a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m4046a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4047a(i);
            }
        }

        public C0750d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2311a = parcel.readInt();
            this.f2312b = parcel.readInt() != 0;
        }

        public C0750d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2311a);
            parcel.writeInt(this.f2312b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2351x = 8388627;
        this.f2317E = new ArrayList();
        this.f2318F = new ArrayList();
        this.f2319G = new int[2];
        this.f2320H = new C07431(this);
        this.f2327O = new C07442(this);
        bm a = bm.m4513a(getContext(), attributeSet, C0528j.Toolbar, i, 0);
        this.f2341n = a.m4530g(C0528j.Toolbar_titleTextAppearance, 0);
        this.f2342o = a.m4530g(C0528j.Toolbar_subtitleTextAppearance, 0);
        this.f2351x = a.m4522c(C0528j.Toolbar_android_gravity, this.f2351x);
        this.f2330c = a.m4522c(C0528j.Toolbar_buttonGravity, 48);
        int d = a.m4524d(C0528j.Toolbar_titleMargin, 0);
        if (a.m4531g(C0528j.Toolbar_titleMargins)) {
            d = a.m4524d(C0528j.Toolbar_titleMargins, d);
        }
        this.f2347t = d;
        this.f2346s = d;
        this.f2345r = d;
        this.f2344q = d;
        d = a.m4524d(C0528j.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f2344q = d;
        }
        d = a.m4524d(C0528j.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f2345r = d;
        }
        d = a.m4524d(C0528j.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f2346s = d;
        }
        d = a.m4524d(C0528j.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f2347t = d;
        }
        this.f2343p = a.m4526e(C0528j.Toolbar_maxButtonHeight, -1);
        d = a.m4524d(C0528j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m4524d(C0528j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = a.m4526e(C0528j.Toolbar_contentInsetLeft, 0);
        int e2 = a.m4526e(C0528j.Toolbar_contentInsetRight, 0);
        m4068s();
        this.f2348u.m4463b(e, e2);
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f2348u.m4460a(d, d2);
        }
        this.f2349v = a.m4524d(C0528j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f2350w = a.m4524d(C0528j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2337j = a.m4517a(C0528j.Toolbar_collapseIcon);
        this.f2338k = a.m4523c(C0528j.Toolbar_collapseContentDescription);
        CharSequence c = a.m4523c(C0528j.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m4523c(C0528j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f2339l = getContext();
        setPopupTheme(a.m4530g(C0528j.Toolbar_popupTheme, 0));
        Drawable a2 = a.m4517a(C0528j.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m4523c(C0528j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m4517a(C0528j.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m4523c(C0528j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m4531g(C0528j.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m4520b(C0528j.Toolbar_titleTextColor, -1));
        }
        if (a.m4531g(C0528j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m4520b(C0528j.Toolbar_subtitleTextColor, -1));
        }
        a.m4518a();
    }

    private int m4048a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f2351x & 112;
        }
    }

    private int m4049a(View view, int i) {
        C0747b c0747b = (C0747b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m4048a(c0747b.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0747b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0747b.topMargin) {
                    i3 = c0747b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0747b.bottomMargin ? Math.max(0, i2 - (c0747b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m4050a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int m4051a(View view, int i, int[] iArr, int i2) {
        C0747b c0747b = (C0747b) view.getLayoutParams();
        int i3 = c0747b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m4049a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0747b.rightMargin + measuredWidth) + max;
    }

    private int m4052a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0747b c0747b = (C0747b) view.getLayoutParams();
            i6 = c0747b.leftMargin - i6;
            i = c0747b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void m4053a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void m4054a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m4085j();
        } else if (checkLayoutParams(layoutParams)) {
            C0747b c0747b = (C0747b) layoutParams;
        } else {
            layoutParams = m4070a(layoutParams);
        }
        layoutParams.f2310b = 1;
        if (!z || this.f2329b == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f2318F.add(view);
    }

    private void m4055a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (C0425s.m1966f(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0398d.m1784a(i, C0425s.m1966f(this));
        list.clear();
        C0747b c0747b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0747b = (C0747b) childAt.getLayoutParams();
                if (c0747b.f2310b == 0 && m4056a(childAt) && m4057b(c0747b.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0747b = (C0747b) childAt2.getLayoutParams();
            if (c0747b.f2310b == 0 && m4056a(childAt2) && m4057b(c0747b.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean m4056a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m4057b(int i) {
        int f = C0425s.m1966f(this);
        int a = C0398d.m1784a(i, f) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return f == 1 ? 5 : 3;
        }
    }

    private int m4058b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0402f.m1791b(marginLayoutParams) + C0402f.m1790a(marginLayoutParams);
    }

    private int m4059b(View view, int i, int[] iArr, int i2) {
        C0747b c0747b = (C0747b) view.getLayoutParams();
        int i3 = c0747b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m4049a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0747b.leftMargin + measuredWidth);
    }

    private int m4060c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean m4061d(View view) {
        return view.getParent() == this || this.f2318F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new C0620g(getContext());
    }

    private void m4062m() {
        if (this.f2336i == null) {
            this.f2336i = new AppCompatImageView(getContext());
        }
    }

    private void m4063n() {
        m4064o();
        if (this.f2332e.m3284d() == null) {
            C0643h c0643h = (C0643h) this.f2332e.getMenu();
            if (this.f2323K == null) {
                this.f2323K = new C0746a(this);
            }
            this.f2332e.setExpandedActionViewsExclusive(true);
            c0643h.m3088a(this.f2323K, this.f2339l);
        }
    }

    private void m4064o() {
        if (this.f2332e == null) {
            this.f2332e = new ActionMenuView(getContext());
            this.f2332e.setPopupTheme(this.f2340m);
            this.f2332e.setOnMenuItemClickListener(this.f2320H);
            this.f2332e.m3276a(this.f2324L, this.f2325M);
            LayoutParams j = m4085j();
            j.a = 8388613 | (this.f2330c & 112);
            this.f2332e.setLayoutParams(j);
            m4054a(this.f2332e, false);
        }
    }

    private void m4065p() {
        if (this.f2335h == null) {
            this.f2335h = new C0096o(getContext(), null, C0519a.toolbarNavigationButtonStyle);
            LayoutParams j = m4085j();
            j.a = 8388611 | (this.f2330c & 112);
            this.f2335h.setLayoutParams(j);
        }
    }

    private void m4066q() {
        removeCallbacks(this.f2327O);
        post(this.f2327O);
    }

    private boolean m4067r() {
        if (!this.f2326N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m4056a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void m4068s() {
        if (this.f2348u == null) {
            this.f2348u = new bc();
        }
    }

    public C0747b m4069a(AttributeSet attributeSet) {
        return new C0747b(getContext(), attributeSet);
    }

    protected C0747b m4070a(LayoutParams layoutParams) {
        return layoutParams instanceof C0747b ? new C0747b((C0747b) layoutParams) : layoutParams instanceof C0543a ? new C0747b((C0543a) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0747b((MarginLayoutParams) layoutParams) : new C0747b(layoutParams);
    }

    public void m4071a(int i, int i2) {
        m4068s();
        this.f2348u.m4460a(i, i2);
    }

    public void m4072a(Context context, int i) {
        this.f2341n = i;
        if (this.f2333f != null) {
            this.f2333f.setTextAppearance(context, i);
        }
    }

    public void m4073a(C0643h c0643h, C0809d c0809d) {
        if (c0643h != null || this.f2332e != null) {
            m4064o();
            C0643h d = this.f2332e.m3284d();
            if (d != c0643h) {
                if (d != null) {
                    d.m3098b(this.f2322J);
                    d.m3098b(this.f2323K);
                }
                if (this.f2323K == null) {
                    this.f2323K = new C0746a(this);
                }
                c0809d.m4650d(true);
                if (c0643h != null) {
                    c0643h.m3088a((C0628o) c0809d, this.f2339l);
                    c0643h.m3088a(this.f2323K, this.f2339l);
                } else {
                    c0809d.mo525a(this.f2339l, null);
                    this.f2323K.mo525a(this.f2339l, null);
                    c0809d.mo530b(true);
                    this.f2323K.mo530b(true);
                }
                this.f2332e.setPopupTheme(this.f2340m);
                this.f2332e.setPresenter(c0809d);
                this.f2322J = c0809d;
            }
        }
    }

    public void m4074a(C0577a c0577a, C0560a c0560a) {
        this.f2324L = c0577a;
        this.f2325M = c0560a;
        if (this.f2332e != null) {
            this.f2332e.m3276a(c0577a, c0560a);
        }
    }

    public boolean m4075a() {
        return getVisibility() == 0 && this.f2332e != null && this.f2332e.m3277a();
    }

    public void m4076b(Context context, int i) {
        this.f2342o = i;
        if (this.f2334g != null) {
            this.f2334g.setTextAppearance(context, i);
        }
    }

    public boolean m4077b() {
        return this.f2332e != null && this.f2332e.m3287g();
    }

    public boolean m4078c() {
        return this.f2332e != null && this.f2332e.m3288h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0747b);
    }

    public boolean m4079d() {
        return this.f2332e != null && this.f2332e.m3285e();
    }

    public boolean m4080e() {
        return this.f2332e != null && this.f2332e.m3286f();
    }

    public void m4081f() {
        if (this.f2332e != null) {
            this.f2332e.m3289i();
        }
    }

    public boolean m4082g() {
        return (this.f2323K == null || this.f2323K.f2308b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m4085j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m4069a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m4070a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.f2348u != null ? this.f2348u.m4465d() : 0;
    }

    public int getContentInsetEndWithActions() {
        return this.f2350w != Integer.MIN_VALUE ? this.f2350w : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        return this.f2348u != null ? this.f2348u.m4459a() : 0;
    }

    public int getContentInsetRight() {
        return this.f2348u != null ? this.f2348u.m4462b() : 0;
    }

    public int getContentInsetStart() {
        return this.f2348u != null ? this.f2348u.m4464c() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.f2349v != Integer.MIN_VALUE ? this.f2349v : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.f2332e != null) {
            C0643h d = this.f2332e.m3284d();
            i = (d == null || !d.hasVisibleItems()) ? 0 : 1;
        } else {
            i = 0;
        }
        return i != 0 ? Math.max(getContentInsetEnd(), Math.max(this.f2350w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return C0425s.m1966f(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return C0425s.m1966f(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2349v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        return this.f2336i != null ? this.f2336i.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.f2336i != null ? this.f2336i.getContentDescription() : null;
    }

    public Menu getMenu() {
        m4063n();
        return this.f2332e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.f2335h != null ? this.f2335h.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.f2335h != null ? this.f2335h.getDrawable() : null;
    }

    C0809d getOuterActionMenuPresenter() {
        return this.f2322J;
    }

    public Drawable getOverflowIcon() {
        m4063n();
        return this.f2332e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f2339l;
    }

    public int getPopupTheme() {
        return this.f2340m;
    }

    public CharSequence getSubtitle() {
        return this.f2353z;
    }

    public CharSequence getTitle() {
        return this.f2352y;
    }

    public int getTitleMarginBottom() {
        return this.f2347t;
    }

    public int getTitleMarginEnd() {
        return this.f2345r;
    }

    public int getTitleMarginStart() {
        return this.f2344q;
    }

    public int getTitleMarginTop() {
        return this.f2346s;
    }

    public aj getWrapper() {
        if (this.f2321I == null) {
            this.f2321I = new bn(this, true);
        }
        return this.f2321I;
    }

    public void m4083h() {
        C0646j c0646j = this.f2323K == null ? null : this.f2323K.f2308b;
        if (c0646j != null) {
            c0646j.collapseActionView();
        }
    }

    void m4084i() {
        if (this.f2328a == null) {
            this.f2328a = new C0096o(getContext(), null, C0519a.toolbarNavigationButtonStyle);
            this.f2328a.setImageDrawable(this.f2337j);
            this.f2328a.setContentDescription(this.f2338k);
            LayoutParams j = m4085j();
            j.a = 8388611 | (this.f2330c & 112);
            j.f2310b = 2;
            this.f2328a.setLayoutParams(j);
            this.f2328a.setOnClickListener(new C07453(this));
        }
    }

    protected C0747b m4085j() {
        return new C0747b(-2, -2);
    }

    void m4086k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0747b) childAt.getLayoutParams()).f2310b == 2 || childAt == this.f2332e)) {
                removeViewAt(childCount);
                this.f2318F.add(childAt);
            }
        }
    }

    void m4087l() {
        for (int size = this.f2318F.size() - 1; size >= 0; size--) {
            addView((View) this.f2318F.get(size));
        }
        this.f2318F.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2327O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2316D = false;
        }
        if (!this.f2316D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2316D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2316D = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        int measuredWidth;
        Object obj = C0425s.m1966f(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i5 = width - paddingRight;
        int[] iArr = this.f2319G;
        iArr[1] = 0;
        iArr[0] = 0;
        int n = C0425s.m1975n(this);
        int min = n >= 0 ? Math.min(n, i4 - i2) : 0;
        if (!m4056a(this.f2335h)) {
            n = i5;
            i5 = paddingLeft;
        } else if (obj != null) {
            n = m4059b(this.f2335h, i5, iArr, min);
            i5 = paddingLeft;
        } else {
            int i6 = i5;
            i5 = m4051a(this.f2335h, paddingLeft, iArr, min);
            n = i6;
        }
        if (m4056a(this.f2328a)) {
            if (obj != null) {
                n = m4059b(this.f2328a, n, iArr, min);
            } else {
                i5 = m4051a(this.f2328a, i5, iArr, min);
            }
        }
        if (m4056a(this.f2332e)) {
            if (obj != null) {
                i5 = m4051a(this.f2332e, i5, iArr, min);
            } else {
                n = m4059b(this.f2332e, n, iArr, min);
            }
        }
        int currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - ((width - paddingRight) - n));
        i5 = Math.max(i5, currentContentInsetLeft);
        n = Math.min(n, (width - paddingRight) - currentContentInsetRight);
        if (m4056a(this.f2329b)) {
            if (obj != null) {
                n = m4059b(this.f2329b, n, iArr, min);
            } else {
                i5 = m4051a(this.f2329b, i5, iArr, min);
            }
        }
        if (!m4056a(this.f2336i)) {
            currentContentInsetLeft = n;
            currentContentInsetRight = i5;
        } else if (obj != null) {
            currentContentInsetLeft = m4059b(this.f2336i, n, iArr, min);
            currentContentInsetRight = i5;
        } else {
            currentContentInsetLeft = n;
            currentContentInsetRight = m4051a(this.f2336i, i5, iArr, min);
        }
        boolean a = m4056a(this.f2333f);
        boolean a2 = m4056a(this.f2334g);
        i5 = 0;
        if (a) {
            C0747b c0747b = (C0747b) this.f2333f.getLayoutParams();
            i5 = 0 + (c0747b.bottomMargin + (c0747b.topMargin + this.f2333f.getMeasuredHeight()));
        }
        if (a2) {
            c0747b = (C0747b) this.f2334g.getLayoutParams();
            measuredHeight = (c0747b.bottomMargin + (c0747b.topMargin + this.f2334g.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0747b = (C0747b) (a ? this.f2333f : this.f2334g).getLayoutParams();
            C0747b c0747b2 = (C0747b) (a2 ? this.f2334g : this.f2333f).getLayoutParams();
            Object obj2 = ((!a || this.f2333f.getMeasuredWidth() <= 0) && (!a2 || this.f2334g.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f2351x & 112) {
                case 48:
                    paddingTop2 = (c0747b.topMargin + getPaddingTop()) + this.f2346s;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - c0747b2.bottomMargin) - this.f2347t) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0747b.topMargin + this.f2346s) {
                        n = c0747b.topMargin + this.f2346s;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        n = measuredHeight < c0747b.bottomMargin + this.f2347t ? Math.max(0, paddingTop2 - ((c0747b2.bottomMargin + this.f2347t) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + n;
                    break;
            }
            if (obj != null) {
                n = (obj2 != null ? this.f2344q : 0) - iArr[1];
                i5 = currentContentInsetLeft - Math.max(0, n);
                iArr[1] = Math.max(0, -n);
                if (a) {
                    c0747b = (C0747b) this.f2333f.getLayoutParams();
                    measuredWidth = i5 - this.f2333f.getMeasuredWidth();
                    currentContentInsetLeft = this.f2333f.getMeasuredHeight() + paddingTop2;
                    this.f2333f.layout(measuredWidth, paddingTop2, i5, currentContentInsetLeft);
                    paddingTop2 = currentContentInsetLeft + c0747b.bottomMargin;
                    currentContentInsetLeft = measuredWidth - this.f2345r;
                } else {
                    currentContentInsetLeft = i5;
                }
                if (a2) {
                    c0747b = (C0747b) this.f2334g.getLayoutParams();
                    measuredWidth = c0747b.topMargin + paddingTop2;
                    measuredHeight = this.f2334g.getMeasuredHeight() + measuredWidth;
                    this.f2334g.layout(i5 - this.f2334g.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    n = c0747b.bottomMargin + measuredHeight;
                    n = i5 - this.f2345r;
                } else {
                    n = i5;
                }
                currentContentInsetLeft = obj2 != null ? Math.min(currentContentInsetLeft, n) : i5;
            } else {
                n = (obj2 != null ? this.f2344q : 0) - iArr[0];
                currentContentInsetRight += Math.max(0, n);
                iArr[0] = Math.max(0, -n);
                if (a) {
                    c0747b = (C0747b) this.f2333f.getLayoutParams();
                    i5 = this.f2333f.getMeasuredWidth() + currentContentInsetRight;
                    measuredWidth = this.f2333f.getMeasuredHeight() + paddingTop2;
                    this.f2333f.layout(currentContentInsetRight, paddingTop2, i5, measuredWidth);
                    n = c0747b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f2345r;
                    i5 = n;
                } else {
                    measuredWidth = currentContentInsetRight;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0747b = (C0747b) this.f2334g.getLayoutParams();
                    i5 += c0747b.topMargin;
                    paddingTop2 = this.f2334g.getMeasuredWidth() + currentContentInsetRight;
                    measuredHeight = this.f2334g.getMeasuredHeight() + i5;
                    this.f2334g.layout(currentContentInsetRight, i5, paddingTop2, measuredHeight);
                    n = c0747b.bottomMargin + measuredHeight;
                    n = this.f2345r + paddingTop2;
                } else {
                    n = currentContentInsetRight;
                }
                if (obj2 != null) {
                    currentContentInsetRight = Math.max(measuredWidth, n);
                }
            }
        }
        m4055a(this.f2317E, 3);
        int size = this.f2317E.size();
        i5 = currentContentInsetRight;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m4051a((View) this.f2317E.get(measuredWidth), i5, iArr, min);
        }
        m4055a(this.f2317E, 5);
        currentContentInsetRight = this.f2317E.size();
        for (measuredWidth = 0; measuredWidth < currentContentInsetRight; measuredWidth++) {
            currentContentInsetLeft = m4059b((View) this.f2317E.get(measuredWidth), currentContentInsetLeft, iArr, min);
        }
        m4055a(this.f2317E, 1);
        measuredWidth = m4052a(this.f2317E, iArr);
        n = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += n;
        if (n < i5) {
            n = i5;
        } else if (measuredWidth > currentContentInsetLeft) {
            n -= measuredWidth - currentContentInsetLeft;
        }
        paddingLeft = this.f2317E.size();
        measuredWidth = n;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m4051a((View) this.f2317E.get(i5), measuredWidth, iArr, min);
        }
        this.f2317E.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f2319G;
        if (bt.m4615a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m4056a(this.f2335h)) {
            m4053a(this.f2335h, i, 0, i2, 0, this.f2343p);
            i7 = this.f2335h.getMeasuredWidth() + m4058b(this.f2335h);
            max = Math.max(0, this.f2335h.getMeasuredHeight() + m4060c(this.f2335h));
            i6 = View.combineMeasuredStates(0, this.f2335h.getMeasuredState());
            i5 = max;
        }
        if (m4056a(this.f2328a)) {
            m4053a(this.f2328a, i, 0, i2, 0, this.f2343p);
            i7 = this.f2328a.getMeasuredWidth() + m4058b(this.f2328a);
            i5 = Math.max(i5, this.f2328a.getMeasuredHeight() + m4060c(this.f2328a));
            i6 = View.combineMeasuredStates(i6, this.f2328a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, i7);
        iArr[i4] = Math.max(0, currentContentInsetStart - i7);
        i7 = 0;
        if (m4056a(this.f2332e)) {
            m4053a(this.f2332e, i, max2, i2, 0, this.f2343p);
            i7 = this.f2332e.getMeasuredWidth() + m4058b(this.f2332e);
            i5 = Math.max(i5, this.f2332e.getMeasuredHeight() + m4060c(this.f2332e));
            i6 = View.combineMeasuredStates(i6, this.f2332e.getMeasuredState());
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, i7);
        iArr[i3] = Math.max(0, currentContentInsetStart - i7);
        if (m4056a(this.f2329b)) {
            max2 += m4050a(this.f2329b, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2329b.getMeasuredHeight() + m4060c(this.f2329b));
            i6 = View.combineMeasuredStates(i6, this.f2329b.getMeasuredState());
        }
        if (m4056a(this.f2336i)) {
            max2 += m4050a(this.f2336i, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2336i.getMeasuredHeight() + m4060c(this.f2336i));
            i6 = View.combineMeasuredStates(i6, this.f2336i.getMeasuredState());
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0747b) childAt.getLayoutParams()).f2310b != 0) {
                i7 = i5;
                currentContentInsetStart = i8;
            } else if (m4056a(childAt)) {
                max2 += m4050a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m4060c(childAt));
                i7 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
                currentContentInsetStart = max;
            } else {
                i7 = i5;
                currentContentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = currentContentInsetStart;
        }
        currentContentInsetStart = 0;
        i7 = 0;
        i6 = this.f2346s + this.f2347t;
        max = this.f2344q + this.f2345r;
        if (m4056a(this.f2333f)) {
            m4050a(this.f2333f, i, max2 + max, i2, i6, iArr);
            currentContentInsetStart = m4058b(this.f2333f) + this.f2333f.getMeasuredWidth();
            i7 = this.f2333f.getMeasuredHeight() + m4060c(this.f2333f);
            i5 = View.combineMeasuredStates(i5, this.f2333f.getMeasuredState());
        }
        if (m4056a(this.f2334g)) {
            currentContentInsetStart = Math.max(currentContentInsetStart, m4050a(this.f2334g, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f2334g.getMeasuredHeight() + m4060c(this.f2334g);
            i5 = View.combineMeasuredStates(i5, this.f2334g.getMeasuredState());
        }
        currentContentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        currentContentInsetStart = View.resolveSizeAndState(Math.max(currentContentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m4067r()) {
            i7 = 0;
        }
        setMeasuredDimension(currentContentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0750d) {
            C0750d c0750d = (C0750d) parcelable;
            super.onRestoreInstanceState(c0750d.m320a());
            Menu d = this.f2332e != null ? this.f2332e.m3284d() : null;
            if (!(c0750d.f2311a == 0 || this.f2323K == null || d == null)) {
                MenuItem findItem = d.findItem(c0750d.f2311a);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (c0750d.f2312b) {
                m4066q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m4068s();
        bc bcVar = this.f2348u;
        if (i != 1) {
            z = false;
        }
        bcVar.m4461a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0750d = new C0750d(super.onSaveInstanceState());
        if (!(this.f2323K == null || this.f2323K.f2308b == null)) {
            c0750d.f2311a = this.f2323K.f2308b.getItemId();
        }
        c0750d.f2312b = m4077b();
        return c0750d;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2315C = false;
        }
        if (!this.f2315C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2315C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2315C = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f2326N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2350w) {
            this.f2350w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2349v) {
            this.f2349v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(C0608b.m2863b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m4062m();
            if (!m4061d(this.f2336i)) {
                m4054a(this.f2336i, true);
            }
        } else if (this.f2336i != null && m4061d(this.f2336i)) {
            removeView(this.f2336i);
            this.f2318F.remove(this.f2336i);
        }
        if (this.f2336i != null) {
            this.f2336i.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4062m();
        }
        if (this.f2336i != null) {
            this.f2336i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4065p();
        }
        if (this.f2335h != null) {
            this.f2335h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C0608b.m2863b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m4065p();
            if (!m4061d(this.f2335h)) {
                m4054a(this.f2335h, true);
            }
        } else if (this.f2335h != null && m4061d(this.f2335h)) {
            removeView(this.f2335h);
            this.f2318F.remove(this.f2335h);
        }
        if (this.f2335h != null) {
            this.f2335h.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m4065p();
        this.f2335h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(C0748c c0748c) {
        this.f2331d = c0748c;
    }

    public void setOverflowIcon(Drawable drawable) {
        m4063n();
        this.f2332e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f2340m != i) {
            this.f2340m = i;
            if (i == 0) {
                this.f2339l = getContext();
            } else {
                this.f2339l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2334g == null) {
                Context context = getContext();
                this.f2334g = new aa(context);
                this.f2334g.setSingleLine();
                this.f2334g.setEllipsize(TruncateAt.END);
                if (this.f2342o != 0) {
                    this.f2334g.setTextAppearance(context, this.f2342o);
                }
                if (this.f2314B != 0) {
                    this.f2334g.setTextColor(this.f2314B);
                }
            }
            if (!m4061d(this.f2334g)) {
                m4054a(this.f2334g, true);
            }
        } else if (this.f2334g != null && m4061d(this.f2334g)) {
            removeView(this.f2334g);
            this.f2318F.remove(this.f2334g);
        }
        if (this.f2334g != null) {
            this.f2334g.setText(charSequence);
        }
        this.f2353z = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f2314B = i;
        if (this.f2334g != null) {
            this.f2334g.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2333f == null) {
                Context context = getContext();
                this.f2333f = new aa(context);
                this.f2333f.setSingleLine();
                this.f2333f.setEllipsize(TruncateAt.END);
                if (this.f2341n != 0) {
                    this.f2333f.setTextAppearance(context, this.f2341n);
                }
                if (this.f2313A != 0) {
                    this.f2333f.setTextColor(this.f2313A);
                }
            }
            if (!m4061d(this.f2333f)) {
                m4054a(this.f2333f, true);
            }
        } else if (this.f2333f != null && m4061d(this.f2333f)) {
            removeView(this.f2333f);
            this.f2318F.remove(this.f2333f);
        }
        if (this.f2333f != null) {
            this.f2333f.setText(charSequence);
        }
        this.f2352y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.f2347t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f2345r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f2344q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f2346s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.f2313A = i;
        if (this.f2333f != null) {
            this.f2333f.setTextColor(i);
        }
    }
}
