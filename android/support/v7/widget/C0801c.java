package android.support.v7.widget;

import android.graphics.Outline;

class C0801c extends C0786b {
    public C0801c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1902d) {
            if (this.a.f1901c != null) {
                this.a.f1901c.getOutline(outline);
            }
        } else if (this.a.f1899a != null) {
            this.a.f1899a.getOutline(outline);
        }
    }
}
