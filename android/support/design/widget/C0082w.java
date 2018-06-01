package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.C0081a;
import android.util.AttributeSet;
import android.view.View;

class C0082w<V extends View> extends C0081a<V> {
    private C0183x f241a;
    private int f242b = 0;
    private int f243c = 0;

    public C0082w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo49a(int i) {
        if (this.f241a != null) {
            return this.f241a.m855a(i);
        }
        this.f242b = i;
        return false;
    }

    public boolean mo38a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo57b(coordinatorLayout, v, i);
        if (this.f241a == null) {
            this.f241a = new C0183x(v);
        }
        this.f241a.m854a();
        if (this.f242b != 0) {
            this.f241a.m855a(this.f242b);
            this.f242b = 0;
        }
        if (this.f243c != 0) {
            this.f241a.m857b(this.f243c);
            this.f243c = 0;
        }
        return true;
    }

    public int mo53b() {
        return this.f241a != null ? this.f241a.m856b() : 0;
    }

    protected void mo57b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m542a((View) v, i);
    }
}
