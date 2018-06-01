package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0081a;
import android.support.v4.p008h.C0407h;
import android.support.v4.p008h.C0425s;
import android.support.v4.widget.C0518o;
import android.support.v4.widget.C0518o.C0087a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends C0081a<V> {
    private boolean f390a;
    C0518o f391b;
    C0115a f392c;
    int f393d = 2;
    float f394e = 0.5f;
    float f395f = 0.0f;
    float f396g = 0.5f;
    private float f397h = 0.0f;
    private boolean f398i;
    private final C0087a f399j = new C01141(this);

    class C01141 extends C0087a {
        final /* synthetic */ SwipeDismissBehavior f384a;
        private int f385b;
        private int f386c = -1;

        C01141(SwipeDismissBehavior swipeDismissBehavior) {
            this.f384a = swipeDismissBehavior;
        }

        private boolean m607a(View view, float f) {
            if (f != 0.0f) {
                boolean z = C0425s.m1966f(view) == 1;
                return this.f384a.f393d == 2 ? true : this.f384a.f393d == 0 ? z ? f < 0.0f : f > 0.0f : this.f384a.f393d == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                return Math.abs(view.getLeft() - this.f385b) >= Math.round(((float) view.getWidth()) * this.f384a.f394e);
            }
        }

        public int mo65a(View view, int i, int i2) {
            return view.getTop();
        }

        public void mo66a(int i) {
            if (this.f384a.f392c != null) {
                this.f384a.f392c.mo105a(i);
            }
        }

        public void mo67a(View view, float f, float f2) {
            this.f386c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (m607a(view, f)) {
                width = view.getLeft() < this.f385b ? this.f385b - width : this.f385b + width;
                z = true;
            } else {
                width = this.f385b;
            }
            if (this.f384a.f391b.m2477a(width, view.getTop())) {
                C0425s.m1950a(view, new C0116b(this.f384a, view, z));
            } else if (z && this.f384a.f392c != null) {
                this.f384a.f392c.mo106a(view);
            }
        }

        public void mo68a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.f385b) + (((float) view.getWidth()) * this.f384a.f395f);
            float width2 = ((float) this.f385b) + (((float) view.getWidth()) * this.f384a.f396g);
            if (((float) i) <= width) {
                C0425s.m1959c(view, 1.0f);
            } else if (((float) i) >= width2) {
                C0425s.m1959c(view, 0.0f);
            } else {
                C0425s.m1959c(view, SwipeDismissBehavior.m618a(0.0f, 1.0f - SwipeDismissBehavior.m621b(width, width2, (float) i), 1.0f));
            }
        }

        public boolean mo69a(View view, int i) {
            return this.f386c == -1 && this.f384a.mo110a(view);
        }

        public int mo98b(View view) {
            return view.getWidth();
        }

        public int mo70b(View view, int i, int i2) {
            int width;
            int i3;
            Object obj = C0425s.m1966f(view) == 1 ? 1 : null;
            if (this.f384a.f393d == 0) {
                if (obj != null) {
                    width = this.f385b - view.getWidth();
                    i3 = this.f385b;
                } else {
                    width = this.f385b;
                    i3 = this.f385b + view.getWidth();
                }
            } else if (this.f384a.f393d != 1) {
                width = this.f385b - view.getWidth();
                i3 = this.f385b + view.getWidth();
            } else if (obj != null) {
                width = this.f385b;
                i3 = this.f385b + view.getWidth();
            } else {
                width = this.f385b - view.getWidth();
                i3 = this.f385b;
            }
            return SwipeDismissBehavior.m619a(width, i, i3);
        }

        public void mo99b(View view, int i) {
            this.f386c = i;
            this.f385b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public interface C0115a {
        void mo105a(int i);

        void mo106a(View view);
    }

    private class C0116b implements Runnable {
        final /* synthetic */ SwipeDismissBehavior f387a;
        private final View f388b;
        private final boolean f389c;

        C0116b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f387a = swipeDismissBehavior;
            this.f388b = view;
            this.f389c = z;
        }

        public void run() {
            if (this.f387a.f391b != null && this.f387a.f391b.m2480a(true)) {
                C0425s.m1950a(this.f388b, (Runnable) this);
            } else if (this.f389c && this.f387a.f392c != null) {
                this.f387a.f392c.mo106a(this.f388b);
            }
        }
    }

    static float m618a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int m619a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void m620a(ViewGroup viewGroup) {
        if (this.f391b == null) {
            this.f391b = this.f398i ? C0518o.m2457a(viewGroup, this.f397h, this.f399j) : C0518o.m2458a(viewGroup, this.f399j);
        }
    }

    static float m621b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public void m622a(float f) {
        this.f395f = m618a(0.0f, f, 1.0f);
    }

    public void m623a(int i) {
        this.f393d = i;
    }

    public void m624a(C0115a c0115a) {
        this.f392c = c0115a;
    }

    public boolean mo39a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f390a;
        switch (C0407h.m1818a(motionEvent)) {
            case 0:
                this.f390a = coordinatorLayout.m547a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.f390a;
                break;
            case 1:
            case 3:
                this.f390a = false;
                break;
        }
        if (!z) {
            return false;
        }
        m620a((ViewGroup) coordinatorLayout);
        return this.f391b.m2478a(motionEvent);
    }

    public boolean mo110a(View view) {
        return true;
    }

    public void m627b(float f) {
        this.f396g = m618a(0.0f, f, 1.0f);
    }

    public boolean mo40b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f391b == null) {
            return false;
        }
        this.f391b.m2483b(motionEvent);
        return true;
    }
}
