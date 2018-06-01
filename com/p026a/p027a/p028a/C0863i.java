package com.p026a.p027a.p028a;

import com.p026a.p027a.C0862l;
import com.p026a.p027a.C0880i;
import com.p026a.p027a.C0889n;
import com.p026a.p027a.C0889n.C0887a;
import com.p026a.p027a.C0889n.C0888b;
import com.p026a.p027a.C0894t;
import java.io.UnsupportedEncodingException;

public abstract class C0863i<T> extends C0862l<T> {
    private static final String f2872a = String.format("application/json; charset=%s", new Object[]{"utf-8"});
    private final C0888b<T> f2873b;
    private final String f2874c;

    public C0863i(int i, String str, String str2, C0888b<T> c0888b, C0887a c0887a) {
        super(i, str, c0887a);
        this.f2873b = c0888b;
        this.f2874c = str2;
    }

    protected abstract C0889n<T> mo799a(C0880i c0880i);

    protected void mo800a(T t) {
        this.f2873b.mo845a(t);
    }

    public String mo801j() {
        return mo803n();
    }

    public byte[] mo802k() {
        return mo804o();
    }

    public String mo803n() {
        return f2872a;
    }

    public byte[] mo804o() {
        byte[] bArr = null;
        try {
            if (this.f2874c != null) {
                bArr = this.f2874c.getBytes("utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            C0894t.m4951d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f2874c, "utf-8");
        }
        return bArr;
    }
}
