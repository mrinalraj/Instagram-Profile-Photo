package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0094q;
import android.util.AttributeSet;
import android.widget.TextView;

public class aa extends TextView implements C0094q {
    private final C0818h f1667a;
    private final C0845y f1668b;

    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        super(bj.m4508a(context), attributeSet, i);
        this.f1667a = new C0818h(this);
        this.f1667a.m4705a(attributeSet, i);
        this.f1668b = C0845y.m4791a((TextView) this);
        this.f1668b.mo793a(attributeSet, i);
        this.f1668b.mo792a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1667a != null) {
            this.f1667a.m4708c();
        }
        if (this.f1668b != null) {
            this.f1668b.mo792a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        return VERSION.SDK_INT >= 26 ? super.getAutoSizeMaxTextSize() : this.f1668b != null ? this.f1668b.m4809g() : -1;
    }

    public int getAutoSizeMinTextSize() {
        return VERSION.SDK_INT >= 26 ? super.getAutoSizeMinTextSize() : this.f1668b != null ? this.f1668b.m4808f() : -1;
    }

    public int getAutoSizeStepGranularity() {
        return VERSION.SDK_INT >= 26 ? super.getAutoSizeStepGranularity() : this.f1668b != null ? this.f1668b.m4807e() : -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return VERSION.SDK_INT >= 26 ? super.getAutoSizeTextAvailableSizes() : this.f1668b != null ? this.f1668b.m4810h() : new int[0];
    }

    public int getAutoSizeTextType() {
        return VERSION.SDK_INT >= 26 ? super.getAutoSizeTextType() == 1 ? 1 : 0 : this.f1668b != null ? this.f1668b.m4806d() : 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1667a != null ? this.f1667a.m4700a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1667a != null ? this.f1667a.m4706b() : null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1668b != null) {
            this.f1668b.m4802a(z, i, i2, i3, i4);
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f1668b != null && VERSION.SDK_INT < 26 && this.f1668b.m4805c()) {
            this.f1668b.m4804b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f1668b != null) {
            this.f1668b.m4797a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f1668b != null) {
            this.f1668b.m4803a(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f1668b != null) {
            this.f1668b.m4795a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1667a != null) {
            this.f1667a.m4704a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1667a != null) {
            this.f1667a.m4701a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1667a != null) {
            this.f1667a.m4702a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1667a != null) {
            this.f1667a.m4703a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1668b != null) {
            this.f1668b.m4798a(context, i);
        }
    }

    public void setTextSize(int i, float f) {
        if (VERSION.SDK_INT >= 26) {
            super.setTextSize(i, f);
        } else if (this.f1668b != null) {
            this.f1668b.m4796a(i, f);
        }
    }
}
