package com.p029b.p030a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p029b.p030a.C0951t.C0947d;

class C0932l extends C0896a<ImageView> {
    C0919e f3058m;

    C0932l(C0951t c0951t, ImageView imageView, C0957w c0957w, int i, int i2, int i3, Drawable drawable, String str, Object obj, C0919e c0919e, boolean z) {
        super(c0951t, imageView, c0957w, i, i2, i3, drawable, str, obj, z);
        this.f3058m = c0919e;
    }

    public void mo811a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.g != 0) {
                imageView.setImageResource(this.g);
            } else if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
            if (this.f3058m != null) {
                this.f3058m.mo830b();
            }
        }
    }

    public void mo812a(Bitmap bitmap, C0947d c0947d) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            C0947d c0947d2 = c0947d;
            C0952u.m5157a(imageView, this.a.f3117c, bitmap2, c0947d2, this.d, this.a.f3125k);
            if (this.f3058m != null) {
                this.f3058m.mo829a();
            }
        }
    }

    void mo820b() {
        super.mo820b();
        if (this.f3058m != null) {
            this.f3058m = null;
        }
    }
}
