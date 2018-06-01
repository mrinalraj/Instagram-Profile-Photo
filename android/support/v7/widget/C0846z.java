package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.widget.TextView;

class C0846z extends C0845y {
    private bk f2832b;
    private bk f2833c;

    C0846z(TextView textView) {
        super(textView);
    }

    void mo792a() {
        super.mo792a();
        if (this.f2832b != null || this.f2833c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m4799a(compoundDrawablesRelative[0], this.f2832b);
            m4799a(compoundDrawablesRelative[2], this.f2833c);
        }
    }

    void mo793a(AttributeSet attributeSet, int i) {
        super.mo793a(attributeSet, i);
        Context context = this.a.getContext();
        C0827m a = C0827m.m4729a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTextHelper_android_drawableStart)) {
            this.f2832b = C0845y.m4790a(context, a, obtainStyledAttributes.getResourceId(C0528j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTextHelper_android_drawableEnd)) {
            this.f2833c = C0845y.m4790a(context, a, obtainStyledAttributes.getResourceId(C0528j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
