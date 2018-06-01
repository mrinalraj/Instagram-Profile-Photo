package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p021a.C0529a.C0528j;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class C0845y {
    final TextView f2824a;
    private bk f2825b;
    private bk f2826c;
    private bk f2827d;
    private bk f2828e;
    private final ab f2829f;
    private int f2830g = 0;
    private Typeface f2831h;

    C0845y(TextView textView) {
        this.f2824a = textView;
        this.f2829f = new ab(this.f2824a);
    }

    protected static bk m4790a(Context context, C0827m c0827m, int i) {
        ColorStateList b = c0827m.m4752b(context, i);
        if (b == null) {
            return null;
        }
        bk bkVar = new bk();
        bkVar.f2624d = true;
        bkVar.f2621a = b;
        return bkVar;
    }

    static C0845y m4791a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new C0846z(textView) : new C0845y(textView);
    }

    private void m4792a(Context context, bm bmVar) {
        this.f2830g = bmVar.m4515a(C0528j.TextAppearance_android_textStyle, this.f2830g);
        if (bmVar.m4531g(C0528j.TextAppearance_android_fontFamily) || bmVar.m4531g(C0528j.TextAppearance_fontFamily)) {
            this.f2831h = null;
            int i = bmVar.m4531g(C0528j.TextAppearance_android_fontFamily) ? C0528j.TextAppearance_android_fontFamily : C0528j.TextAppearance_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.f2831h = bmVar.m4516a(i, this.f2830g, this.f2824a);
                } catch (UnsupportedOperationException e) {
                } catch (NotFoundException e2) {
                }
            }
            if (this.f2831h == null) {
                this.f2831h = Typeface.create(bmVar.m4525d(i), this.f2830g);
            }
        }
    }

    private void m4793b(int i, float f) {
        this.f2829f.m4110a(i, f);
    }

    void mo792a() {
        if (this.f2825b != null || this.f2826c != null || this.f2827d != null || this.f2828e != null) {
            Drawable[] compoundDrawables = this.f2824a.getCompoundDrawables();
            m4799a(compoundDrawables[0], this.f2825b);
            m4799a(compoundDrawables[1], this.f2826c);
            m4799a(compoundDrawables[2], this.f2827d);
            m4799a(compoundDrawables[3], this.f2828e);
        }
    }

    void m4795a(int i) {
        this.f2829f.m4109a(i);
    }

    void m4796a(int i, float f) {
        if (VERSION.SDK_INT < 26 && !m4805c()) {
            m4793b(i, f);
        }
    }

    void m4797a(int i, int i2, int i3, int i4) {
        this.f2829f.m4111a(i, i2, i3, i4);
    }

    void m4798a(Context context, int i) {
        bm a = bm.m4511a(context, i, C0528j.TextAppearance);
        if (a.m4531g(C0528j.TextAppearance_textAllCaps)) {
            m4801a(a.m4519a(C0528j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.m4531g(C0528j.TextAppearance_android_textColor)) {
            ColorStateList e = a.m4527e(C0528j.TextAppearance_android_textColor);
            if (e != null) {
                this.f2824a.setTextColor(e);
            }
        }
        m4792a(context, a);
        a.m4518a();
        if (this.f2831h != null) {
            this.f2824a.setTypeface(this.f2831h, this.f2830g);
        }
    }

    final void m4799a(Drawable drawable, bk bkVar) {
        if (drawable != null && bkVar != null) {
            C0827m.m4732a(drawable, bkVar, this.f2824a.getDrawableState());
        }
    }

    void mo793a(AttributeSet attributeSet, int i) {
        bm a;
        boolean z;
        boolean z2;
        ColorStateList e;
        ColorStateList e2;
        ColorStateList colorStateList = null;
        Context context = this.f2824a.getContext();
        C0827m a2 = C0827m.m4729a();
        bm a3 = bm.m4513a(context, attributeSet, C0528j.AppCompatTextHelper, i, 0);
        int g = a3.m4530g(C0528j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.m4531g(C0528j.AppCompatTextHelper_android_drawableLeft)) {
            this.f2825b = C0845y.m4790a(context, a2, a3.m4530g(C0528j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.m4531g(C0528j.AppCompatTextHelper_android_drawableTop)) {
            this.f2826c = C0845y.m4790a(context, a2, a3.m4530g(C0528j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.m4531g(C0528j.AppCompatTextHelper_android_drawableRight)) {
            this.f2827d = C0845y.m4790a(context, a2, a3.m4530g(C0528j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.m4531g(C0528j.AppCompatTextHelper_android_drawableBottom)) {
            this.f2828e = C0845y.m4790a(context, a2, a3.m4530g(C0528j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a3.m4518a();
        boolean z3 = this.f2824a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g != -1) {
            a = bm.m4511a(context, g, C0528j.TextAppearance);
            if (z3 || !a.m4531g(C0528j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a.m4519a(C0528j.TextAppearance_textAllCaps, false);
                z = true;
            }
            m4792a(context, a);
            if (VERSION.SDK_INT < 23) {
                e = a.m4531g(C0528j.TextAppearance_android_textColor) ? a.m4527e(C0528j.TextAppearance_android_textColor) : null;
                e2 = a.m4531g(C0528j.TextAppearance_android_textColorHint) ? a.m4527e(C0528j.TextAppearance_android_textColorHint) : null;
                if (a.m4531g(C0528j.TextAppearance_android_textColorLink)) {
                    colorStateList = a.m4527e(C0528j.TextAppearance_android_textColorLink);
                }
            } else {
                e2 = null;
                e = null;
            }
            a.m4518a();
        } else {
            e2 = null;
            e = null;
            z = false;
            z2 = false;
        }
        a = bm.m4513a(context, attributeSet, C0528j.TextAppearance, i, 0);
        if (!z3 && a.m4531g(C0528j.TextAppearance_textAllCaps)) {
            z2 = a.m4519a(C0528j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a.m4531g(C0528j.TextAppearance_android_textColor)) {
                e = a.m4527e(C0528j.TextAppearance_android_textColor);
            }
            if (a.m4531g(C0528j.TextAppearance_android_textColorHint)) {
                e2 = a.m4527e(C0528j.TextAppearance_android_textColorHint);
            }
            if (a.m4531g(C0528j.TextAppearance_android_textColorLink)) {
                colorStateList = a.m4527e(C0528j.TextAppearance_android_textColorLink);
            }
        }
        m4792a(context, a);
        a.m4518a();
        if (e != null) {
            this.f2824a.setTextColor(e);
        }
        if (e2 != null) {
            this.f2824a.setHintTextColor(e2);
        }
        if (colorStateList != null) {
            this.f2824a.setLinkTextColor(colorStateList);
        }
        if (!z3 && r0) {
            m4801a(z2);
        }
        if (this.f2831h != null) {
            this.f2824a.setTypeface(this.f2831h, this.f2830g);
        }
        this.f2829f.m4112a(attributeSet, i);
        if (VERSION.SDK_INT >= 26 && this.f2829f.m4108a() != 0) {
            int[] e3 = this.f2829f.m4117e();
            if (e3.length <= 0) {
                return;
            }
            if (((float) this.f2824a.getAutoSizeStepGranularity()) != -1.0f) {
                this.f2824a.setAutoSizeTextTypeUniformWithConfiguration(this.f2829f.m4115c(), this.f2829f.m4116d(), this.f2829f.m4114b(), 0);
            } else {
                this.f2824a.setAutoSizeTextTypeUniformWithPresetSizes(e3, 0);
            }
        }
    }

    void m4801a(boolean z) {
        this.f2824a.setAllCaps(z);
    }

    void m4802a(boolean z, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT < 26) {
            m4804b();
        }
    }

    void m4803a(int[] iArr, int i) {
        this.f2829f.m4113a(iArr, i);
    }

    void m4804b() {
        this.f2829f.m4118f();
    }

    boolean m4805c() {
        return this.f2829f.m4119g();
    }

    int m4806d() {
        return this.f2829f.m4108a();
    }

    int m4807e() {
        return this.f2829f.m4114b();
    }

    int m4808f() {
        return this.f2829f.m4115c();
    }

    int m4809g() {
        return this.f2829f.m4116d();
    }

    int[] m4810h() {
        return this.f2829f.m4117e();
    }
}
