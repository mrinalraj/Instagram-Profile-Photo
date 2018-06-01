package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.p008h.C0425s;
import android.support.v4.widget.C0505i;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.menu.C0637s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class as implements C0637s {
    private static Method f2478a;
    private static Method f2479b;
    private static Method f2480h;
    private Drawable f2481A;
    private OnItemClickListener f2482B;
    private OnItemSelectedListener f2483C;
    private final C0778d f2484D;
    private final C0777c f2485E;
    private final C0775a f2486F;
    private Runnable f2487G;
    private final Rect f2488H;
    private Rect f2489I;
    private boolean f2490J;
    am f2491c;
    int f2492d;
    final C0779e f2493e;
    final Handler f2494f;
    PopupWindow f2495g;
    private Context f2496i;
    private ListAdapter f2497j;
    private int f2498k;
    private int f2499l;
    private int f2500m;
    private int f2501n;
    private int f2502o;
    private boolean f2503p;
    private boolean f2504q;
    private boolean f2505r;
    private boolean f2506s;
    private int f2507t;
    private boolean f2508u;
    private boolean f2509v;
    private View f2510w;
    private int f2511x;
    private DataSetObserver f2512y;
    private View f2513z;

    class C07731 implements Runnable {
        final /* synthetic */ as f2471a;

        C07731(as asVar) {
            this.f2471a = asVar;
        }

        public void run() {
            View i = this.f2471a.m4352i();
            if (i != null && i.getWindowToken() != null) {
                this.f2471a.mo535a();
            }
        }
    }

    class C07742 implements OnItemSelectedListener {
        final /* synthetic */ as f2472a;

        C07742(as asVar) {
            this.f2472a = asVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                am amVar = this.f2472a.f2491c;
                if (amVar != null) {
                    amVar.setListSelectionHidden(false);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class C0775a implements Runnable {
        final /* synthetic */ as f2473a;

        C0775a(as asVar) {
            this.f2473a = asVar;
        }

        public void run() {
            this.f2473a.m4357m();
        }
    }

    private class C0776b extends DataSetObserver {
        final /* synthetic */ as f2474a;

        C0776b(as asVar) {
            this.f2474a = asVar;
        }

        public void onChanged() {
            if (this.f2474a.mo545d()) {
                this.f2474a.mo535a();
            }
        }

        public void onInvalidated() {
            this.f2474a.mo542c();
        }
    }

    private class C0777c implements OnScrollListener {
        final /* synthetic */ as f2475a;

        C0777c(as asVar) {
            this.f2475a = asVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f2475a.m4358n() && this.f2475a.f2495g.getContentView() != null) {
                this.f2475a.f2494f.removeCallbacks(this.f2475a.f2493e);
                this.f2475a.f2493e.run();
            }
        }
    }

    private class C0778d implements OnTouchListener {
        final /* synthetic */ as f2476a;

        C0778d(as asVar) {
            this.f2476a = asVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f2476a.f2495g != null && this.f2476a.f2495g.isShowing() && x >= 0 && x < this.f2476a.f2495g.getWidth() && y >= 0 && y < this.f2476a.f2495g.getHeight()) {
                this.f2476a.f2494f.postDelayed(this.f2476a.f2493e, 250);
            } else if (action == 1) {
                this.f2476a.f2494f.removeCallbacks(this.f2476a.f2493e);
            }
            return false;
        }
    }

    private class C0779e implements Runnable {
        final /* synthetic */ as f2477a;

        C0779e(as asVar) {
            this.f2477a = asVar;
        }

        public void run() {
            if (this.f2477a.f2491c != null && C0425s.m1936A(this.f2477a.f2491c) && this.f2477a.f2491c.getCount() > this.f2477a.f2491c.getChildCount() && this.f2477a.f2491c.getChildCount() <= this.f2477a.f2492d) {
                this.f2477a.f2495g.setInputMethodMode(2);
                this.f2477a.mo535a();
            }
        }
    }

    static {
        try {
            f2478a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f2479b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f2480h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException e3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public as(Context context) {
        this(context, null, C0519a.listPopupWindowStyle);
    }

    public as(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public as(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2498k = -2;
        this.f2499l = -2;
        this.f2502o = 1002;
        this.f2504q = true;
        this.f2507t = 0;
        this.f2508u = false;
        this.f2509v = false;
        this.f2492d = Integer.MAX_VALUE;
        this.f2511x = 0;
        this.f2493e = new C0779e(this);
        this.f2484D = new C0778d(this);
        this.f2485E = new C0777c(this);
        this.f2486F = new C0775a(this);
        this.f2488H = new Rect();
        this.f2496i = context;
        this.f2494f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.ListPopupWindow, i, i2);
        this.f2500m = obtainStyledAttributes.getDimensionPixelOffset(C0528j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2501n = obtainStyledAttributes.getDimensionPixelOffset(C0528j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2501n != 0) {
            this.f2503p = true;
        }
        obtainStyledAttributes.recycle();
        this.f2495g = new C0832r(context, attributeSet, i, i2);
        this.f2495g.setInputMethodMode(1);
    }

    private int m4325a(View view, int i, boolean z) {
        if (f2479b != null) {
            try {
                return ((Integer) f2479b.invoke(this.f2495g, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2495g.getMaxAvailableHeight(view, i);
    }

    private void mo790b() {
        if (this.f2510w != null) {
            ViewParent parent = this.f2510w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2510w);
            }
        }
    }

    private void mo719c(boolean z) {
        if (f2478a != null) {
            try {
                f2478a.invoke(this.f2495g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int mo791f() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f2491c == null) {
            Context context = this.f2496i;
            this.f2487G = new C07731(this);
            this.f2491c = mo718a(context, !this.f2490J);
            if (this.f2481A != null) {
                this.f2491c.setSelector(this.f2481A);
            }
            this.f2491c.setAdapter(this.f2497j);
            this.f2491c.setOnItemClickListener(this.f2482B);
            this.f2491c.setFocusable(true);
            this.f2491c.setFocusableInTouchMode(true);
            this.f2491c.setOnItemSelectedListener(new C07742(this));
            this.f2491c.setOnScrollListener(this.f2485E);
            if (this.f2483C != null) {
                this.f2491c.setOnItemSelectedListener(this.f2483C);
            }
            View view2 = this.f2491c;
            View view3 = this.f2510w;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f2511x) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f2511x);
                        break;
                }
                if (this.f2499l >= 0) {
                    i = this.f2499l;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f2495g.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2495g.getContentView();
            view = this.f2510w;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f2495g.getBackground();
        if (background != null) {
            background.getPadding(this.f2488H);
            i2 = this.f2488H.top + this.f2488H.bottom;
            if (this.f2503p) {
                i4 = i2;
            } else {
                this.f2501n = -this.f2488H.top;
                i4 = i2;
            }
        } else {
            this.f2488H.setEmpty();
            i4 = 0;
        }
        if (this.f2495g.getInputMethodMode() != 2) {
            z = false;
        }
        i = m4325a(m4352i(), this.f2501n, z);
        if (this.f2508u || this.f2498k == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f2499l) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2496i.getResources().getDisplayMetrics().widthPixels - (this.f2488H.left + this.f2488H.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2496i.getResources().getDisplayMetrics().widthPixels - (this.f2488H.left + this.f2488H.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2499l, 1073741824);
                break;
        }
        i2 = this.f2491c.m4293a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += (this.f2491c.getPaddingTop() + this.f2491c.getPaddingBottom()) + i4;
        }
        return i2 + i3;
    }

    am mo718a(Context context, boolean z) {
        return new am(context, z);
    }

    public void mo535a() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int f = mo791f();
        boolean n = m4358n();
        C0505i.m2429a(this.f2495g, this.f2502o);
        PopupWindow popupWindow;
        if (!this.f2495g.isShowing()) {
            int width = this.f2499l == -1 ? -1 : this.f2499l == -2 ? m4352i().getWidth() : this.f2499l;
            if (this.f2498k == -1) {
                f = -1;
            } else if (this.f2498k != -2) {
                f = this.f2498k;
            }
            this.f2495g.setWidth(width);
            this.f2495g.setHeight(f);
            mo719c(true);
            popupWindow = this.f2495g;
            if (this.f2509v || this.f2508u) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.f2495g.setTouchInterceptor(this.f2484D);
            if (this.f2506s) {
                C0505i.m2431a(this.f2495g, this.f2505r);
            }
            if (f2480h != null) {
                try {
                    f2480h.invoke(this.f2495g, new Object[]{this.f2489I});
                } catch (Throwable e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            C0505i.m2430a(this.f2495g, m4352i(), this.f2500m, this.f2501n, this.f2507t);
            this.f2491c.setSelection(-1);
            if (!this.f2490J || this.f2491c.isInTouchMode()) {
                m4357m();
            }
            if (!this.f2490J) {
                this.f2494f.post(this.f2486F);
            }
        } else if (C0425s.m1936A(m4352i())) {
            int i2;
            int width2 = this.f2499l == -1 ? -1 : this.f2499l == -2 ? m4352i().getWidth() : this.f2499l;
            if (this.f2498k == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.f2495g.setWidth(this.f2499l == -1 ? -1 : 0);
                    this.f2495g.setHeight(0);
                    i2 = f;
                } else {
                    this.f2495g.setWidth(this.f2499l == -1 ? -1 : 0);
                    this.f2495g.setHeight(-1);
                    i2 = f;
                }
            } else {
                i2 = this.f2498k == -2 ? f : this.f2498k;
            }
            popupWindow = this.f2495g;
            if (!(this.f2509v || this.f2508u)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.f2495g;
            View i3 = m4352i();
            f = this.f2500m;
            int i4 = this.f2501n;
            if (width2 < 0) {
                width2 = -1;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(i3, f, i4, width2, i);
        }
    }

    public void m4331a(int i) {
        this.f2511x = i;
    }

    public void m4332a(Rect rect) {
        this.f2489I = rect;
    }

    public void m4333a(Drawable drawable) {
        this.f2495g.setBackgroundDrawable(drawable);
    }

    public void m4334a(OnItemClickListener onItemClickListener) {
        this.f2482B = onItemClickListener;
    }

    public void mo789a(ListAdapter listAdapter) {
        if (this.f2512y == null) {
            this.f2512y = new C0776b(this);
        } else if (this.f2497j != null) {
            this.f2497j.unregisterDataSetObserver(this.f2512y);
        }
        this.f2497j = listAdapter;
        if (this.f2497j != null) {
            listAdapter.registerDataSetObserver(this.f2512y);
        }
        if (this.f2491c != null) {
            this.f2491c.setAdapter(this.f2497j);
        }
    }

    public void m4336a(OnDismissListener onDismissListener) {
        this.f2495g.setOnDismissListener(onDismissListener);
    }

    public void m4337a(boolean z) {
        this.f2490J = z;
        this.f2495g.setFocusable(z);
    }

    public void m4338b(int i) {
        this.f2495g.setAnimationStyle(i);
    }

    public void m4339b(View view) {
        this.f2513z = view;
    }

    public void m4340b(boolean z) {
        this.f2506s = true;
        this.f2505r = z;
    }

    public void mo542c() {
        this.f2495g.dismiss();
        mo790b();
        this.f2495g.setContentView(null);
        this.f2491c = null;
        this.f2494f.removeCallbacks(this.f2493e);
    }

    public void m4342c(int i) {
        this.f2500m = i;
    }

    public void m4343d(int i) {
        this.f2501n = i;
        this.f2503p = true;
    }

    public boolean mo545d() {
        return this.f2495g.isShowing();
    }

    public ListView mo546e() {
        return this.f2491c;
    }

    public void m4346e(int i) {
        this.f2507t = i;
    }

    public void m4347f(int i) {
        this.f2499l = i;
    }

    public void m4348g(int i) {
        Drawable background = this.f2495g.getBackground();
        if (background != null) {
            background.getPadding(this.f2488H);
            this.f2499l = (this.f2488H.left + this.f2488H.right) + i;
            return;
        }
        m4347f(i);
    }

    public boolean m4349g() {
        return this.f2490J;
    }

    public Drawable m4350h() {
        return this.f2495g.getBackground();
    }

    public void m4351h(int i) {
        this.f2495g.setInputMethodMode(i);
    }

    public View m4352i() {
        return this.f2513z;
    }

    public void m4353i(int i) {
        am amVar = this.f2491c;
        if (mo545d() && amVar != null) {
            amVar.setListSelectionHidden(false);
            amVar.setSelection(i);
            if (amVar.getChoiceMode() != 0) {
                amVar.setItemChecked(i, true);
            }
        }
    }

    public int m4354j() {
        return this.f2500m;
    }

    public int m4355k() {
        return !this.f2503p ? 0 : this.f2501n;
    }

    public int m4356l() {
        return this.f2499l;
    }

    public void m4357m() {
        am amVar = this.f2491c;
        if (amVar != null) {
            amVar.setListSelectionHidden(true);
            amVar.requestLayout();
        }
    }

    public boolean m4358n() {
        return this.f2495g.getInputMethodMode() == 2;
    }
}
