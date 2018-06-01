package com.p029b.p030a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;

class C0909b extends C0908y {
    private static final int f2995a = "file:///android_asset/".length();
    private final AssetManager f2996b;

    public C0909b(Context context) {
        this.f2996b = context.getAssets();
    }

    static String m5029b(C0957w c0957w) {
        return c0957w.f3160d.toString().substring(f2995a);
    }

    public C0959a mo814a(C0957w c0957w, int i) {
        return new C0959a(this.f2996b.open(C0909b.m5029b(c0957w)), C0947d.DISK);
    }

    public boolean mo815a(C0957w c0957w) {
        Uri uri = c0957w.f3160d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
