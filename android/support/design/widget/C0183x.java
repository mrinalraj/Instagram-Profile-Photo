package android.support.design.widget;

import android.support.v4.p008h.C0425s;
import android.view.View;

class C0183x {
    private final View f537a;
    private int f538b;
    private int f539c;
    private int f540d;
    private int f541e;

    public C0183x(View view) {
        this.f537a = view;
    }

    private void m853c() {
        C0425s.m1965e(this.f537a, this.f540d - (this.f537a.getTop() - this.f538b));
        C0425s.m1967f(this.f537a, this.f541e - (this.f537a.getLeft() - this.f539c));
    }

    public void m854a() {
        this.f538b = this.f537a.getTop();
        this.f539c = this.f537a.getLeft();
        m853c();
    }

    public boolean m855a(int i) {
        if (this.f540d == i) {
            return false;
        }
        this.f540d = i;
        m853c();
        return true;
    }

    public int m856b() {
        return this.f540d;
    }

    public boolean m857b(int i) {
        if (this.f541e == i) {
            return false;
        }
        this.f541e = i;
        m853c();
        return true;
    }
}
