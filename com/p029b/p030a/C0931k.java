package com.p029b.p030a;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;

class C0931k extends C0922g {
    C0931k(Context context) {
        super(context);
    }

    static int m5104a(Uri uri) {
        switch (new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1)) {
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public C0959a mo814a(C0957w c0957w, int i) {
        return new C0959a(null, m5075b(c0957w), C0947d.DISK, C0931k.m5104a(c0957w.f3160d));
    }

    public boolean mo815a(C0957w c0957w) {
        return "file".equals(c0957w.f3160d.getScheme());
    }
}
