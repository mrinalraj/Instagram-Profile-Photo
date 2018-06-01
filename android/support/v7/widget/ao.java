package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.C0637s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ao implements OnAttachStateChangeListener, OnTouchListener {
    private final float f1657a;
    private final int f1658b;
    final View f1659c;
    private final int f1660d;
    private Runnable f1661e;
    private Runnable f1662f;
    private boolean f1663g;
    private int f1664h;
    private final int[] f1665i = new int[2];

    private class C0768a implements Runnable {
        final /* synthetic */ ao f2445a;

        C0768a(ao aoVar) {
            this.f2445a = aoVar;
        }

        public void run() {
            ViewParent parent = this.f2445a.f1659c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class C0769b implements Runnable {
        final /* synthetic */ ao f2446a;

        C0769b(ao aoVar) {
            this.f2446a = aoVar;
        }

        public void run() {
            this.f2446a.m2938d();
        }
    }

    public ao(View view) {
        this.f1659c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1657a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1658b = ViewConfiguration.getTapTimeout();
        this.f1660d = (this.f1658b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean m2929a(MotionEvent motionEvent) {
        View view = this.f1659c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f1664h = motionEvent.getPointerId(0);
                if (this.f1661e == null) {
                    this.f1661e = new C0768a(this);
                }
                view.postDelayed(this.f1661e, (long) this.f1658b);
                if (this.f1662f == null) {
                    this.f1662f = new C0769b(this);
                }
                view.postDelayed(this.f1662f, (long) this.f1660d);
                return false;
            case 1:
            case 3:
                m2934e();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1664h);
                if (findPointerIndex < 0 || m2930a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1657a)) {
                    return false;
                }
                m2934e();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private static boolean m2930a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean m2931a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1665i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean m2932b(MotionEvent motionEvent) {
        View view = this.f1659c;
        C0637s a = mo497a();
        if (a == null || !a.mo545d()) {
            return false;
        }
        am amVar = (am) a.mo546e();
        if (amVar == null || !amVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m2933b(view, obtainNoHistory);
        m2931a(amVar, obtainNoHistory);
        boolean a2 = amVar.mo713a(obtainNoHistory, this.f1664h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        boolean z = (actionMasked == 1 || actionMasked == 3) ? false : true;
        z = a2 && z;
        return z;
    }

    private boolean m2933b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1665i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void m2934e() {
        if (this.f1662f != null) {
            this.f1659c.removeCallbacks(this.f1662f);
        }
        if (this.f1661e != null) {
            this.f1659c.removeCallbacks(this.f1661e);
        }
    }

    public abstract C0637s mo497a();

    protected boolean mo498b() {
        C0637s a = mo497a();
        if (!(a == null || a.mo545d())) {
            a.mo535a();
        }
        return true;
    }

    protected boolean mo774c() {
        C0637s a = mo497a();
        if (a != null && a.mo545d()) {
            a.mo542c();
        }
        return true;
    }

    void m2938d() {
        m2934e();
        View view = this.f1659c;
        if (view.isEnabled() && !view.isLongClickable() && mo498b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1663g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1663g;
        if (z2) {
            z = m2932b(motionEvent) || !mo774c();
        } else {
            boolean z3 = m2929a(motionEvent) && mo498b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1659c.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        }
        this.f1663g = z;
        return z || z2;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1663g = false;
        this.f1664h = -1;
        if (this.f1661e != null) {
            this.f1659c.removeCallbacks(this.f1661e);
        }
    }
}
