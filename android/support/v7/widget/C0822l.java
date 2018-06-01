package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.widget.C0486b;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.p023c.p024a.C0608b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class C0822l {
    private final CompoundButton f2754a;
    private ColorStateList f2755b = null;
    private Mode f2756c = null;
    private boolean f2757d = false;
    private boolean f2758e = false;
    private boolean f2759f;

    C0822l(CompoundButton compoundButton) {
        this.f2754a = compoundButton;
    }

    int m4709a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0486b.m2376a(this.f2754a);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    ColorStateList m4710a() {
        return this.f2755b;
    }

    void m4711a(ColorStateList colorStateList) {
        this.f2755b = colorStateList;
        this.f2757d = true;
        m4716d();
    }

    void m4712a(Mode mode) {
        this.f2756c = mode;
        this.f2758e = true;
        m4716d();
    }

    void m4713a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2754a.getContext().obtainStyledAttributes(attributeSet, C0528j.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0528j.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0528j.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f2754a.setButtonDrawable(C0608b.m2863b(this.f2754a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0528j.CompoundButton_buttonTint)) {
                C0486b.m2377a(this.f2754a, obtainStyledAttributes.getColorStateList(C0528j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0528j.CompoundButton_buttonTintMode)) {
                C0486b.m2378a(this.f2754a, al.m4289a(obtainStyledAttributes.getInt(C0528j.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m4714b() {
        return this.f2756c;
    }

    void m4715c() {
        if (this.f2759f) {
            this.f2759f = false;
            return;
        }
        this.f2759f = true;
        m4716d();
    }

    void m4716d() {
        Drawable a = C0486b.m2376a(this.f2754a);
        if (a == null) {
            return;
        }
        if (this.f2757d || this.f2758e) {
            a = C0279a.m1431f(a).mutate();
            if (this.f2757d) {
                C0279a.m1421a(a, this.f2755b);
            }
            if (this.f2758e) {
                C0279a.m1424a(a, this.f2756c);
            }
            if (a.isStateful()) {
                a.setState(this.f2754a.getDrawableState());
            }
            this.f2754a.setButtonDrawable(a);
        }
    }
}
