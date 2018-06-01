package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class aa extends ImageButton {
    private int f360a;

    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f360a = getVisibility();
    }

    final void m583a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f360a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f360a;
    }

    public void setVisibility(int i) {
        m583a(i, true);
    }
}
