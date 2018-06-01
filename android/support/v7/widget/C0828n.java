package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p008h.C0094q;
import android.support.v7.p021a.C0529a.C0519a;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class C0828n extends EditText implements C0094q {
    private final C0818h f2776a;
    private final C0845y f2777b;

    public C0828n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.editTextStyle);
    }

    public C0828n(Context context, AttributeSet attributeSet, int i) {
        super(bj.m4508a(context), attributeSet, i);
        this.f2776a = new C0818h(this);
        this.f2776a.m4705a(attributeSet, i);
        this.f2777b = C0845y.m4791a((TextView) this);
        this.f2777b.mo793a(attributeSet, i);
        this.f2777b.mo792a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2776a != null) {
            this.f2776a.m4708c();
        }
        if (this.f2777b != null) {
            this.f2777b.mo792a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2776a != null ? this.f2776a.m4700a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2776a != null ? this.f2776a.m4706b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2776a != null) {
            this.f2776a.m4704a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2776a != null) {
            this.f2776a.m4701a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2776a != null) {
            this.f2776a.m4702a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2776a != null) {
            this.f2776a.m4703a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2777b != null) {
            this.f2777b.m4798a(context, i);
        }
    }
}
