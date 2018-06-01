package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0066a.C0059d;
import android.support.design.C0066a.C0065j;
import android.support.design.widget.CoordinatorLayout.C0081a;
import android.support.v4.p008h.C0071i;
import android.support.v4.p008h.C0079a;
import android.support.v4.p008h.C0407h;
import android.support.v4.p008h.C0413r;
import android.support.v4.p008h.C0425s;
import android.support.v4.p009e.C0077c;
import android.support.v4.p009e.C0309b;
import android.support.v4.widget.C0518o;
import android.support.v4.widget.C0518o.C0087a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends C0081a<V> {
    int f281a;
    int f282b;
    boolean f283c;
    int f284d = 4;
    C0518o f285e;
    int f286f;
    WeakReference<V> f287g;
    WeakReference<View> f288h;
    int f289i;
    boolean f290j;
    private float f291k;
    private int f292l;
    private boolean f293m;
    private int f294n;
    private boolean f295o;
    private boolean f296p;
    private int f297q;
    private boolean f298r;
    private C0089a f299s;
    private VelocityTracker f300t;
    private int f301u;
    private final C0087a f302v = new C00881(this);

    class C00881 extends C0087a {
        final /* synthetic */ BottomSheetBehavior f276a;

        C00881(BottomSheetBehavior bottomSheetBehavior) {
            this.f276a = bottomSheetBehavior;
        }

        public int mo64a(View view) {
            return this.f276a.f283c ? this.f276a.f286f - this.f276a.f281a : this.f276a.f282b - this.f276a.f281a;
        }

        public int mo65a(View view, int i, int i2) {
            return C0156l.m747a(i, this.f276a.f281a, this.f276a.f283c ? this.f276a.f286f : this.f276a.f282b);
        }

        public void mo66a(int i) {
            if (i == 1) {
                this.f276a.m480b(1);
            }
        }

        public void mo67a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = this.f276a.f281a;
            } else if (this.f276a.f283c && this.f276a.m478a(view, f2)) {
                i = this.f276a.f286f;
                i2 = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.f276a.f281a) < Math.abs(top - this.f276a.f282b)) {
                    i = this.f276a.f281a;
                } else {
                    i = this.f276a.f282b;
                    i2 = 4;
                }
            } else {
                i = this.f276a.f282b;
                i2 = 4;
            }
            if (this.f276a.f285e.m2477a(view.getLeft(), i)) {
                this.f276a.m480b(2);
                C0425s.m1950a(view, new C0092c(this.f276a, view, i2));
                return;
            }
            this.f276a.m480b(i2);
        }

        public void mo68a(View view, int i, int i2, int i3, int i4) {
            this.f276a.m483c(i2);
        }

        public boolean mo69a(View view, int i) {
            if (this.f276a.f284d == 1 || this.f276a.f290j) {
                return false;
            }
            if (this.f276a.f284d == 3 && this.f276a.f289i == i) {
                View view2 = (View) this.f276a.f288h.get();
                if (view2 != null && C0425s.m1957b(view2, -1)) {
                    return false;
                }
            }
            boolean z = this.f276a.f287g != null && this.f276a.f287g.get() == view;
            return z;
        }

        public int mo70b(View view, int i, int i2) {
            return view.getLeft();
        }
    }

    public static abstract class C0089a {
        public abstract void m460a(View view, float f);

        public abstract void m461a(View view, int i);
    }

    protected static class C0091b extends C0079a {
        public static final Creator<C0091b> CREATOR = C0309b.m1523a(new C00901());
        final int f277a;

        static class C00901 implements C0077c<C0091b> {
            C00901() {
            }

            public C0091b m462a(Parcel parcel, ClassLoader classLoader) {
                return new C0091b(parcel, classLoader);
            }

            public C0091b[] m463a(int i) {
                return new C0091b[i];
            }

            public /* synthetic */ Object mo35b(Parcel parcel, ClassLoader classLoader) {
                return m462a(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo36b(int i) {
                return m463a(i);
            }
        }

        public C0091b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f277a = parcel.readInt();
        }

        public C0091b(Parcelable parcelable, int i) {
            super(parcelable);
            this.f277a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f277a);
        }
    }

    private class C0092c implements Runnable {
        final /* synthetic */ BottomSheetBehavior f278a;
        private final View f279b;
        private final int f280c;

        C0092c(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.f278a = bottomSheetBehavior;
            this.f279b = view;
            this.f280c = i;
        }

        public void run() {
            if (this.f278a.f285e == null || !this.f278a.f285e.m2480a(true)) {
                this.f278a.m480b(this.f280c);
            } else {
                C0425s.m1950a(this.f279b, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(C0065j.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            m469a(obtainStyledAttributes.getDimensionPixelSize(C0065j.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            m469a(peekValue.data);
        }
        m473a(obtainStyledAttributes.getBoolean(C0065j.BottomSheetBehavior_Layout_behavior_hideable, false));
        m481b(obtainStyledAttributes.getBoolean(C0065j.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f291k = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private View m466a(View view) {
        if (view instanceof C0071i) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = m466a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    private void m467a() {
        this.f289i = -1;
        if (this.f300t != null) {
            this.f300t.recycle();
            this.f300t = null;
        }
    }

    private float m468b() {
        this.f300t.computeCurrentVelocity(1000, this.f291k);
        return C0413r.m1849b(this.f300t, this.f289i);
    }

    public final void m469a(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.f293m) {
                this.f293m = true;
            }
            z = false;
        } else {
            if (this.f293m || this.f292l != i) {
                this.f293m = false;
                this.f292l = Math.max(0, i);
                this.f282b = this.f286f - i;
            }
            z = false;
        }
        if (z && this.f284d == 4 && this.f287g != null) {
            View view = (View) this.f287g.get();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public void mo45a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        C0091b c0091b = (C0091b) parcelable;
        super.mo45a(coordinatorLayout, (View) v, c0091b.m320a());
        if (c0091b.f277a == 1 || c0091b.f277a == 2) {
            this.f284d = 4;
        } else {
            this.f284d = c0091b.f277a;
        }
    }

    public void mo46a(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.f281a) {
            m480b(3);
        } else if (view == this.f288h.get() && this.f298r) {
            int i2;
            if (this.f297q > 0) {
                i2 = this.f281a;
            } else if (this.f283c && m478a(v, m468b())) {
                i2 = this.f286f;
                i = 5;
            } else if (this.f297q == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.f281a) < Math.abs(top - this.f282b)) {
                    i2 = this.f281a;
                } else {
                    i2 = this.f282b;
                    i = 4;
                }
            } else {
                i2 = this.f282b;
                i = 4;
            }
            if (this.f285e.m2479a((View) v, v.getLeft(), i2)) {
                m480b(2);
                C0425s.m1950a((View) v, new C0092c(this, v, i));
            } else {
                m480b(i);
            }
            this.f298r = false;
        }
    }

    public void mo48a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.f288h.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.f281a) {
                    iArr[1] = top - this.f281a;
                    C0425s.m1965e(v, -iArr[1]);
                    m480b(3);
                } else {
                    iArr[1] = i2;
                    C0425s.m1965e(v, -i2);
                    m480b(1);
                }
            } else if (i2 < 0 && !C0425s.m1957b(view, -1)) {
                if (i3 <= this.f282b || this.f283c) {
                    iArr[1] = i2;
                    C0425s.m1965e(v, -i2);
                    m480b(1);
                } else {
                    iArr[1] = top - this.f282b;
                    C0425s.m1965e(v, -iArr[1]);
                    m480b(4);
                }
            }
            m483c(v.getTop());
            this.f297q = i2;
            this.f298r = true;
        }
    }

    public void m473a(boolean z) {
        this.f283c = z;
    }

    public boolean mo38a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int max;
        if (C0425s.m1980s(coordinatorLayout) && !C0425s.m1980s(v)) {
            C0425s.m1952a((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.m542a((View) v, i);
        this.f286f = coordinatorLayout.getHeight();
        if (this.f293m) {
            if (this.f294n == 0) {
                this.f294n = coordinatorLayout.getResources().getDimensionPixelSize(C0059d.design_bottom_sheet_peek_height_min);
            }
            max = Math.max(this.f294n, this.f286f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            max = this.f292l;
        }
        this.f281a = Math.max(0, this.f286f - v.getHeight());
        this.f282b = Math.max(this.f286f - max, this.f281a);
        if (this.f284d == 3) {
            C0425s.m1965e(v, this.f281a);
        } else if (this.f283c && this.f284d == 5) {
            C0425s.m1965e(v, this.f286f);
        } else if (this.f284d == 4) {
            C0425s.m1965e(v, this.f282b);
        } else if (this.f284d == 1 || this.f284d == 2) {
            C0425s.m1965e(v, top - v.getTop());
        }
        if (this.f285e == null) {
            this.f285e = C0518o.m2458a((ViewGroup) coordinatorLayout, this.f302v);
        }
        this.f287g = new WeakReference(v);
        this.f288h = new WeakReference(m466a((View) v));
        return true;
    }

    public boolean mo39a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (v.isShown()) {
            View view;
            int a = C0407h.m1818a(motionEvent);
            if (a == 0) {
                m467a();
            }
            if (this.f300t == null) {
                this.f300t = VelocityTracker.obtain();
            }
            this.f300t.addMovement(motionEvent);
            switch (a) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.f301u = (int) motionEvent.getY();
                    view = (View) this.f288h.get();
                    if (view != null && coordinatorLayout.m547a(view, x, this.f301u)) {
                        this.f289i = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f290j = true;
                    }
                    boolean z2 = this.f289i == -1 && !coordinatorLayout.m547a((View) v, x, this.f301u);
                    this.f296p = z2;
                    break;
                case 1:
                case 3:
                    this.f290j = false;
                    this.f289i = -1;
                    if (this.f296p) {
                        this.f296p = false;
                        return false;
                    }
                    break;
            }
            if (!this.f296p && this.f285e.m2478a(motionEvent)) {
                return true;
            }
            view = (View) this.f288h.get();
            if (a != 2 || view == null || this.f296p || this.f284d == 1 || coordinatorLayout.m547a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f301u) - motionEvent.getY()) <= ((float) this.f285e.m2474a())) {
                z = false;
            }
            return z;
        }
        this.f296p = true;
        return false;
    }

    public boolean mo71a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f288h.get() && (this.f284d != 3 || super.mo71a(coordinatorLayout, (View) v, view, f, f2));
    }

    public boolean mo52a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.f297q = 0;
        this.f298r = false;
        return (i & 2) != 0;
    }

    boolean m478a(View view, float f) {
        return this.f295o ? true : view.getTop() < this.f282b ? false : Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.f282b)) / ((float) this.f292l) > 0.5f;
    }

    public Parcelable mo55b(CoordinatorLayout coordinatorLayout, V v) {
        return new C0091b(super.mo55b(coordinatorLayout, v), this.f284d);
    }

    void m480b(int i) {
        if (this.f284d != i) {
            this.f284d = i;
            View view = (View) this.f287g.get();
            if (view != null && this.f299s != null) {
                this.f299s.m461a(view, i);
            }
        }
    }

    public void m481b(boolean z) {
        this.f295o = z;
    }

    public boolean mo40b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int a = C0407h.m1818a(motionEvent);
        if (this.f284d == 1 && a == 0) {
            return true;
        }
        this.f285e.m2483b(motionEvent);
        if (a == 0) {
            m467a();
        }
        if (this.f300t == null) {
            this.f300t = VelocityTracker.obtain();
        }
        this.f300t.addMovement(motionEvent);
        if (a == 2 && !this.f296p && Math.abs(((float) this.f301u) - motionEvent.getY()) > ((float) this.f285e.m2474a())) {
            this.f285e.m2475a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f296p;
    }

    void m483c(int i) {
        View view = (View) this.f287g.get();
        if (view != null && this.f299s != null) {
            if (i > this.f282b) {
                this.f299s.m460a(view, ((float) (this.f282b - i)) / ((float) (this.f286f - this.f282b)));
            } else {
                this.f299s.m460a(view, ((float) (this.f282b - i)) / ((float) (this.f282b - this.f281a)));
            }
        }
    }
}
