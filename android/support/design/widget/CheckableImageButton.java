package android.support.design.widget;

import android.content.Context;
import android.support.v4.p008h.C0067b;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.p019a.C0369b;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.widget.C0096o;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends C0096o implements Checkable {
    private static final int[] f306a = new int[]{16842912};
    private boolean f307b;

    class C00931 extends C0067b {
        final /* synthetic */ CheckableImageButton f303a;

        C00931(CheckableImageButton checkableImageButton) {
            this.f303a = checkableImageButton;
        }

        public void mo25a(View view, C0369b c0369b) {
            super.mo25a(view, c0369b);
            c0369b.m1709a(true);
            c0369b.m1713b(this.f303a.isChecked());
        }

        public void mo72a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo72a(view, accessibilityEvent);
            accessibilityEvent.setChecked(this.f303a.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0425s.m1948a((View) this, new C00931(this));
    }

    public boolean isChecked() {
        return this.f307b;
    }

    public int[] onCreateDrawableState(int i) {
        return this.f307b ? mergeDrawableStates(super.onCreateDrawableState(f306a.length + i), f306a) : super.onCreateDrawableState(i);
    }

    public void setChecked(boolean z) {
        if (this.f307b != z) {
            this.f307b = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void toggle() {
        setChecked(!this.f307b);
    }
}
