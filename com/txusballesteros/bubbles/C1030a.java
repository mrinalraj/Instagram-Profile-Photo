package com.txusballesteros.bubbles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;

class C1030a extends FrameLayout {
    private WindowManager f3360a;
    private LayoutParams f3361b;
    private C1036c f3362c;

    public C1030a(Context context) {
        super(context);
    }

    public C1030a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C1030a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    C1036c getLayoutCoordinator() {
        return this.f3362c;
    }

    LayoutParams getViewParams() {
        return this.f3361b;
    }

    WindowManager getWindowManager() {
        return this.f3360a;
    }

    void setLayoutCoordinator(C1036c c1036c) {
        this.f3362c = c1036c;
    }

    void setViewParams(LayoutParams layoutParams) {
        this.f3361b = layoutParams;
    }

    void setWindowManager(WindowManager windowManager) {
        this.f3360a = windowManager;
    }
}
