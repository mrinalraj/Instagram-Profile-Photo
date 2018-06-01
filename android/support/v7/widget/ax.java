package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.C0679i;
import android.support.v7.widget.RecyclerView.C0681h;
import android.view.View;

public abstract class ax {
    protected final C0681h f2522a;
    final Rect f2523b;
    private int f2524c;

    private ax(C0681h c0681h) {
        this.f2524c = Integer.MIN_VALUE;
        this.f2523b = new Rect();
        this.f2522a = c0681h;
    }

    public static ax m4376a(C0681h c0681h) {
        return new ax(c0681h) {
            public int mo720a(View view) {
                return this.a.m3452h(view) - ((C0679i) view.getLayoutParams()).leftMargin;
            }

            public void mo721a(int i) {
                this.a.mo674i(i);
            }

            public int mo722b(View view) {
                C0679i c0679i = (C0679i) view.getLayoutParams();
                return c0679i.rightMargin + this.a.m3456j(view);
            }

            public int mo723c() {
                return this.a.m3477z();
            }

            public int mo724c(View view) {
                this.a.m3393a(view, true, this.b);
                return this.b.right;
            }

            public int mo725d() {
                return this.a.m3475x() - this.a.m3353B();
            }

            public int mo726d(View view) {
                this.a.m3393a(view, true, this.b);
                return this.b.left;
            }

            public int mo727e() {
                return this.a.m3475x();
            }

            public int mo728e(View view) {
                C0679i c0679i = (C0679i) view.getLayoutParams();
                return c0679i.rightMargin + (this.a.m3445f(view) + c0679i.leftMargin);
            }

            public int mo729f() {
                return (this.a.m3475x() - this.a.m3477z()) - this.a.m3353B();
            }

            public int mo730f(View view) {
                C0679i c0679i = (C0679i) view.getLayoutParams();
                return c0679i.bottomMargin + (this.a.m3449g(view) + c0679i.topMargin);
            }

            public int mo731g() {
                return this.a.m3353B();
            }

            public int mo732h() {
                return this.a.m3473v();
            }

            public int mo733i() {
                return this.a.m3474w();
            }
        };
    }

    public static ax m4377a(C0681h c0681h, int i) {
        switch (i) {
            case 0:
                return m4376a(c0681h);
            case 1:
                return m4378b(c0681h);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static ax m4378b(C0681h c0681h) {
        return new ax(c0681h) {
            public int mo720a(View view) {
                return this.a.m3454i(view) - ((C0679i) view.getLayoutParams()).topMargin;
            }

            public void mo721a(int i) {
                this.a.mo675j(i);
            }

            public int mo722b(View view) {
                C0679i c0679i = (C0679i) view.getLayoutParams();
                return c0679i.bottomMargin + this.a.m3458k(view);
            }

            public int mo723c() {
                return this.a.m3352A();
            }

            public int mo724c(View view) {
                this.a.m3393a(view, true, this.b);
                return this.b.bottom;
            }

            public int mo725d() {
                return this.a.m3476y() - this.a.m3354C();
            }

            public int mo726d(View view) {
                this.a.m3393a(view, true, this.b);
                return this.b.top;
            }

            public int mo727e() {
                return this.a.m3476y();
            }

            public int mo728e(View view) {
                C0679i c0679i = (C0679i) view.getLayoutParams();
                return c0679i.bottomMargin + (this.a.m3449g(view) + c0679i.topMargin);
            }

            public int mo729f() {
                return (this.a.m3476y() - this.a.m3352A()) - this.a.m3354C();
            }

            public int mo730f(View view) {
                C0679i c0679i = (C0679i) view.getLayoutParams();
                return c0679i.rightMargin + (this.a.m3445f(view) + c0679i.leftMargin);
            }

            public int mo731g() {
                return this.a.m3354C();
            }

            public int mo732h() {
                return this.a.m3474w();
            }

            public int mo733i() {
                return this.a.m3473v();
            }
        };
    }

    public abstract int mo720a(View view);

    public void m4380a() {
        this.f2524c = mo729f();
    }

    public abstract void mo721a(int i);

    public int m4382b() {
        return Integer.MIN_VALUE == this.f2524c ? 0 : mo729f() - this.f2524c;
    }

    public abstract int mo722b(View view);

    public abstract int mo723c();

    public abstract int mo724c(View view);

    public abstract int mo725d();

    public abstract int mo726d(View view);

    public abstract int mo727e();

    public abstract int mo728e(View view);

    public abstract int mo729f();

    public abstract int mo730f(View view);

    public abstract int mo731g();

    public abstract int mo732h();

    public abstract int mo733i();
}
