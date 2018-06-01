package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p008h.C0094q;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p023c.p024a.C0608b;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class C0726g extends AutoCompleteTextView implements C0094q {
    private static final int[] f2189a = new int[]{16843126};
    private final C0818h f2190b;
    private final C0845y f2191c;

    public C0726g(Context context) {
        this(context, null);
    }

    public C0726g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.autoCompleteTextViewStyle);
    }

    public C0726g(Context context, AttributeSet attributeSet, int i) {
        super(bj.m4508a(context), attributeSet, i);
        bm a = bm.m4513a(getContext(), attributeSet, f2189a, i, 0);
        if (a.m4531g(0)) {
            setDropDownBackgroundDrawable(a.m4517a(0));
        }
        a.m4518a();
        this.f2190b = new C0818h(this);
        this.f2190b.m4705a(attributeSet, i);
        this.f2191c = C0845y.m4791a((TextView) this);
        this.f2191c.mo793a(attributeSet, i);
        this.f2191c.mo792a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2190b != null) {
            this.f2190b.m4708c();
        }
        if (this.f2191c != null) {
            this.f2191c.mo792a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2190b != null ? this.f2190b.m4700a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2190b != null ? this.f2190b.m4706b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2190b != null) {
            this.f2190b.m4704a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2190b != null) {
            this.f2190b.m4701a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0608b.m2863b(getContext(), i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2190b != null) {
            this.f2190b.m4702a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2190b != null) {
            this.f2190b.m4703a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2191c != null) {
            this.f2191c.m4798a(context, i);
        }
    }
}
