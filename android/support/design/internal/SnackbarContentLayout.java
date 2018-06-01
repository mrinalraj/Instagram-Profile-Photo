package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0066a.C0059d;
import android.support.design.C0066a.C0061f;
import android.support.design.C0066a.C0065j;
import android.support.design.widget.C0113b.C0073c;
import android.support.v4.p008h.C0425s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements C0073c {
    private TextView f229a;
    private Button f230b;
    private int f231c;
    private int f232d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.SnackbarLayout);
        this.f231c = obtainStyledAttributes.getDimensionPixelSize(C0065j.SnackbarLayout_android_maxWidth, -1);
        this.f232d = obtainStyledAttributes.getDimensionPixelSize(C0065j.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void m307a(View view, int i, int i2) {
        if (C0425s.m1982u(view)) {
            C0425s.m1944a(view, C0425s.m1969h(view), i, C0425s.m1970i(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean m308a(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.f229a.getPaddingTop() == i2 && this.f229a.getPaddingBottom() == i3) {
            return z;
        }
        m307a(this.f229a, i2, i3);
        return true;
    }

    public void mo32a(int i, int i2) {
        C0425s.m1959c(this.f229a, 0.0f);
        C0425s.m1976o(this.f229a).m2014a(1.0f).m2015a((long) i2).m2021b((long) i).m2024c();
        if (this.f230b.getVisibility() == 0) {
            C0425s.m1959c(this.f230b, 0.0f);
            C0425s.m1976o(this.f230b).m2014a(1.0f).m2015a((long) i2).m2021b((long) i).m2024c();
        }
    }

    public void mo33b(int i, int i2) {
        C0425s.m1959c(this.f229a, 1.0f);
        C0425s.m1976o(this.f229a).m2014a(0.0f).m2015a((long) i2).m2021b((long) i).m2024c();
        if (this.f230b.getVisibility() == 0) {
            C0425s.m1959c(this.f230b, 1.0f);
            C0425s.m1976o(this.f230b).m2014a(0.0f).m2015a((long) i2).m2021b((long) i).m2024c();
        }
    }

    public Button getActionView() {
        return this.f230b;
    }

    public TextView getMessageView() {
        return this.f229a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f229a = (TextView) findViewById(C0061f.snackbar_text);
        this.f230b = (Button) findViewById(C0061f.snackbar_action);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f231c > 0 && getMeasuredWidth() > this.f231c) {
            i = MeasureSpec.makeMeasureSpec(this.f231c, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0059d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0059d.design_snackbar_padding_vertical);
        int i3 = this.f229a.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.f232d <= 0 || this.f230b.getMeasuredWidth() <= this.f232d) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (m308a(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (m308a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }
}
