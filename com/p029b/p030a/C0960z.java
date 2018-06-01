package com.p029b.p030a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;

class C0960z extends C0908y {
    private final Context f3192a;

    C0960z(Context context) {
        this.f3192a = context;
    }

    private static Bitmap m5184a(Resources resources, int i, C0957w c0957w) {
        Options c = C0908y.m5023c(c0957w);
        if (C0908y.m5022a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            C0908y.m5021a(c0957w.f3164h, c0957w.f3165i, c, c0957w);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }

    public C0959a mo814a(C0957w c0957w, int i) {
        Resources a = ag.m4999a(this.f3192a, c0957w);
        return new C0959a(C0960z.m5184a(a, ag.m4996a(a, c0957w), c0957w), C0947d.DISK);
    }

    public boolean mo815a(C0957w c0957w) {
        return c0957w.f3161e != 0 ? true : "android.resource".equals(c0957w.f3160d.getScheme());
    }
}
