package com.p029b.p030a;

import android.content.Context;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;
import java.io.InputStream;

class C0922g extends C0908y {
    final Context f3028a;

    C0922g(Context context) {
        this.f3028a = context;
    }

    public C0959a mo814a(C0957w c0957w, int i) {
        return new C0959a(m5075b(c0957w), C0947d.DISK);
    }

    public boolean mo815a(C0957w c0957w) {
        return "content".equals(c0957w.f3160d.getScheme());
    }

    InputStream m5075b(C0957w c0957w) {
        return this.f3028a.getContentResolver().openInputStream(c0957w.f3160d);
    }
}
