package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C0101d;
import android.support.v4.p008h.C0398d;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0435y;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class C0084k extends C0082w<View> {
    final Rect f260a = new Rect();
    final Rect f261b = new Rect();
    private int f262c = 0;
    private int f263d;

    public C0084k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int m401c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float mo58a(View view) {
        return 1.0f;
    }

    final int m403a() {
        return this.f262c;
    }

    public boolean mo50a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View b = mo61b(coordinatorLayout.m552c(view));
            if (b != null) {
                if (C0425s.m1980s(b) && !C0425s.m1980s(view)) {
                    C0425s.m1952a(view, true);
                    if (C0425s.m1980s(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.m543a(view, i, i2, MeasureSpec.makeMeasureSpec(mo60b(b) + (size - b.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    int mo60b(View view) {
        return view.getMeasuredHeight();
    }

    abstract View mo61b(List<View> list);

    public final void m407b(int i) {
        this.f263d = i;
    }

    protected void mo57b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = mo61b(coordinatorLayout.m552c(view));
        if (b != null) {
            C0101d c0101d = (C0101d) view.getLayoutParams();
            Rect rect = this.f260a;
            rect.set(coordinatorLayout.getPaddingLeft() + c0101d.leftMargin, b.getBottom() + c0101d.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0101d.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0101d.bottomMargin);
            C0435y lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !C0425s.m1980s(coordinatorLayout) || C0425s.m1980s(view))) {
                rect.left += lastWindowInsets.m2028a();
                rect.right -= lastWindowInsets.m2031c();
            }
            Rect rect2 = this.f261b;
            C0398d.m1785a(C0084k.m401c(c0101d.f312c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = m409c(b);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f262c = rect2.top - b.getBottom();
            return;
        }
        super.mo57b(coordinatorLayout, view, i);
        this.f262c = 0;
    }

    final int m409c(View view) {
        return this.f263d == 0 ? 0 : C0156l.m747a((int) (mo58a(view) * ((float) this.f263d)), 0, this.f263d);
    }

    public final int m410d() {
        return this.f263d;
    }
}
