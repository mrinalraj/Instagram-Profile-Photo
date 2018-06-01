package com.p029b.p030a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.p029b.p030a.C0951t.C0947d;

final class ad extends C0896a<ac> {
    ad(C0951t c0951t, ac acVar, C0957w c0957w, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(c0951t, acVar, c0957w, i, i2, i3, drawable, str, obj, false);
    }

    void mo811a() {
        ac acVar = (ac) m4957d();
        if (acVar == null) {
            return;
        }
        if (this.g != 0) {
            acVar.mo832a(this.a.f3117c.getResources().getDrawable(this.g));
        } else {
            acVar.mo832a(this.h);
        }
    }

    void mo812a(Bitmap bitmap, C0947d c0947d) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ac acVar = (ac) m4957d();
        if (acVar != null) {
            acVar.mo831a(bitmap, c0947d);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }
}
