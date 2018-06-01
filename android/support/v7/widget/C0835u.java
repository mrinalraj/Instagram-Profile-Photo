package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.p021a.C0529a.C0519a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

public class C0835u extends RatingBar {
    private final C0833s f2794a;

    public C0835u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.ratingBarStyle);
    }

    public C0835u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2794a = new C0833s(this);
        this.f2794a.mo787a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f2794a.m4769a();
        if (a != null) {
            setMeasuredDimension(View.resolveSizeAndState(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
