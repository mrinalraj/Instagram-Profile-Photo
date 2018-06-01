package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.C0515m;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p023c.p024a.C0608b;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class C0820j extends CheckBox implements C0515m {
    private final C0822l f2751a;

    public C0820j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.checkboxStyle);
    }

    public C0820j(Context context, AttributeSet attributeSet, int i) {
        super(bj.m4508a(context), attributeSet, i);
        this.f2751a = new C0822l(this);
        this.f2751a.m4713a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2751a != null ? this.f2751a.m4709a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f2751a != null ? this.f2751a.m4710a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.f2751a != null ? this.f2751a.m4714b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(C0608b.m2863b(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2751a != null) {
            this.f2751a.m4715c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2751a != null) {
            this.f2751a.m4711a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f2751a != null) {
            this.f2751a.m4712a(mode);
        }
    }
}
