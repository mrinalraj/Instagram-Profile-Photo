package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.p021a.C0529a.C0519a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class C0836v extends SeekBar {
    private final C0837w f2795a;

    public C0836v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.seekBarStyle);
    }

    public C0836v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2795a = new C0837w(this);
        this.f2795a.mo787a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2795a.m4776c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f2795a.mo788b();
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2795a.m4772a(canvas);
    }
}
