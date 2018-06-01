package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p023c.p024a.C0608b;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class C0821k extends CheckedTextView {
    private static final int[] f2752a = new int[]{16843016};
    private final C0845y f2753b;

    public C0821k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0821k(Context context, AttributeSet attributeSet, int i) {
        super(bj.m4508a(context), attributeSet, i);
        this.f2753b = C0845y.m4791a((TextView) this);
        this.f2753b.mo793a(attributeSet, i);
        this.f2753b.mo792a();
        bm a = bm.m4513a(getContext(), attributeSet, f2752a, i, 0);
        setCheckMarkDrawable(a.m4517a(0));
        a.m4518a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2753b != null) {
            this.f2753b.mo792a();
        }
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0608b.m2863b(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2753b != null) {
            this.f2753b.m4798a(context, i);
        }
    }
}
