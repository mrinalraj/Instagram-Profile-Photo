package android.support.v4.p005c.p006a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0283c.C0281a;

class C0285d extends C0283c {

    private static class C0284a extends C0281a {
        C0284a(C0281a c0281a, Resources resources) {
            super(c0281a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0285d(this, resources);
        }
    }

    C0285d(Drawable drawable) {
        super(drawable);
    }

    C0285d(C0281a c0281a, Resources resources) {
        super(c0281a, resources);
    }

    C0281a mo204b() {
        return new C0284a(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
