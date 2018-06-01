package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p022b.C0605a.C0601a;
import android.support.v7.p022b.C0605a.C0603c;
import android.support.v7.p022b.C0605a.C0604d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] f2014e = new int[]{16842801};
    private static final ag f2015f;
    int f2016a;
    int f2017b;
    final Rect f2018c = new Rect();
    final Rect f2019d = new Rect();
    private boolean f2020g;
    private boolean f2021h;
    private final af f2022i = new C06761(this);

    class C06761 implements af {
        final /* synthetic */ CardView f2012a;
        private Drawable f2013b;

        C06761(CardView cardView) {
            this.f2012a = cardView;
        }

        public void mo596a(int i, int i2) {
            if (i > this.f2012a.f2016a) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.f2012a.f2017b) {
                super.setMinimumHeight(i2);
            }
        }

        public void mo597a(int i, int i2, int i3, int i4) {
            this.f2012a.f2019d.set(i, i2, i3, i4);
            super.setPadding(this.f2012a.f2018c.left + i, this.f2012a.f2018c.top + i2, this.f2012a.f2018c.right + i3, this.f2012a.f2018c.bottom + i4);
        }

        public void mo598a(Drawable drawable) {
            this.f2013b = drawable;
            this.f2012a.setBackgroundDrawable(drawable);
        }

        public boolean mo599a() {
            return this.f2012a.getUseCompatPadding();
        }

        public boolean mo600b() {
            return this.f2012a.getPreventCornerOverlap();
        }

        public Drawable mo601c() {
            return this.f2013b;
        }

        public View mo602d() {
            return this.f2012a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f2015f = new ad();
        } else if (VERSION.SDK_INT >= 17) {
            f2015f = new ac();
        } else {
            f2015f = new ae();
        }
        f2015f.mo680a();
    }

    public CardView(Context context) {
        super(context);
        m3325a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3325a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3325a(context, attributeSet, i);
    }

    private void m3325a(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0604d.CardView, i, C0603c.CardView);
        if (obtainStyledAttributes.hasValue(C0604d.CardView_cardBackgroundColor)) {
            colorStateList = obtainStyledAttributes.getColorStateList(C0604d.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f2014e);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateList = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(C0601a.cardview_light_background) : getResources().getColor(C0601a.cardview_dark_background));
        }
        float dimension = obtainStyledAttributes.getDimension(C0604d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0604d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(C0604d.CardView_cardMaxElevation, 0.0f);
        this.f2020g = obtainStyledAttributes.getBoolean(C0604d.CardView_cardUseCompatPadding, false);
        this.f2021h = obtainStyledAttributes.getBoolean(C0604d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0604d.CardView_contentPadding, 0);
        this.f2018c.left = obtainStyledAttributes.getDimensionPixelSize(C0604d.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f2018c.top = obtainStyledAttributes.getDimensionPixelSize(C0604d.CardView_contentPaddingTop, dimensionPixelSize);
        this.f2018c.right = obtainStyledAttributes.getDimensionPixelSize(C0604d.CardView_contentPaddingRight, dimensionPixelSize);
        this.f2018c.bottom = obtainStyledAttributes.getDimensionPixelSize(C0604d.CardView_contentPaddingBottom, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.f2016a = obtainStyledAttributes.getDimensionPixelSize(C0604d.CardView_android_minWidth, 0);
        this.f2017b = obtainStyledAttributes.getDimensionPixelSize(C0604d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f2015f.mo682a(this.f2022i, context, colorStateList, dimension, dimension2, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2015f.mo692i(this.f2022i);
    }

    public float getCardElevation() {
        return f2015f.mo689e(this.f2022i);
    }

    public int getContentPaddingBottom() {
        return this.f2018c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2018c.left;
    }

    public int getContentPaddingRight() {
        return this.f2018c.right;
    }

    public int getContentPaddingTop() {
        return this.f2018c.top;
    }

    public float getMaxCardElevation() {
        return f2015f.mo679a(this.f2022i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2021h;
    }

    public float getRadius() {
        return f2015f.mo688d(this.f2022i);
    }

    public boolean getUseCompatPadding() {
        return this.f2020g;
    }

    protected void onMeasure(int i, int i2) {
        if (f2015f instanceof ad) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2015f.mo684b(this.f2022i)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2015f.mo686c(this.f2022i)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f2015f.mo683a(this.f2022i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2015f.mo683a(this.f2022i, colorStateList);
    }

    public void setCardElevation(float f) {
        f2015f.mo687c(this.f2022i, f);
    }

    public void setMaxCardElevation(float f) {
        f2015f.mo685b(this.f2022i, f);
    }

    public void setMinimumHeight(int i) {
        this.f2017b = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.f2016a = i;
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f2021h) {
            this.f2021h = z;
            f2015f.mo691h(this.f2022i);
        }
    }

    public void setRadius(float f) {
        f2015f.mo681a(this.f2022i, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2020g != z) {
            this.f2020g = z;
            f2015f.mo690g(this.f2022i);
        }
    }
}
