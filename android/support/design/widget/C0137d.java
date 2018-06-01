package android.support.design.widget;

import android.annotation.TargetApi;
import android.graphics.Outline;

@TargetApi(21)
class C0137d extends C0136c {
    C0137d() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
