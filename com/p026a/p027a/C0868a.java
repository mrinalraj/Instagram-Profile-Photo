package com.p026a.p027a;

import android.content.Intent;

public class C0868a extends C0867s {
    private Intent f2878b;

    public C0868a(C0880i c0880i) {
        super(c0880i);
    }

    public String getMessage() {
        return this.f2878b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
