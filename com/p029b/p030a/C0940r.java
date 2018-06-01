package com.p029b.p030a;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.p029b.p030a.C0901j.C0929a;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;
import java.io.IOException;
import java.io.InputStream;

class C0940r extends C0908y {
    private final C0901j f3088a;
    private final aa f3089b;

    static class C0939a extends IOException {
        public C0939a(String str) {
            super(str);
        }
    }

    public C0940r(C0901j c0901j, aa aaVar) {
        this.f3088a = c0901j;
        this.f3089b = aaVar;
    }

    int mo821a() {
        return 2;
    }

    public C0959a mo814a(C0957w c0957w, int i) {
        C0929a a = this.f3088a.mo813a(c0957w.f3160d, c0957w.f3159c);
        if (a == null) {
            return null;
        }
        C0947d c0947d = a.f3054c ? C0947d.DISK : C0947d.NETWORK;
        Bitmap b = a.m5102b();
        if (b != null) {
            return new C0959a(b, c0947d);
        }
        InputStream a2 = a.m5101a();
        if (a2 == null) {
            return null;
        }
        if (c0947d == C0947d.DISK && a.m5103c() == 0) {
            ag.m5009a(a2);
            throw new C0939a("Received response with 0 content-length header.");
        }
        if (c0947d == C0947d.NETWORK && a.m5103c() > 0) {
            this.f3089b.m4969a(a.m5103c());
        }
        return new C0959a(a2, c0947d);
    }

    public boolean mo815a(C0957w c0957w) {
        String scheme = c0957w.f3160d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    boolean mo822a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    boolean mo823b() {
        return true;
    }
}
