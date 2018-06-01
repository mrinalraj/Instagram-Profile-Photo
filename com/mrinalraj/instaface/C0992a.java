package com.mrinalraj.instaface;

import android.app.Activity;
import android.content.Context;
import android.support.v4.p012a.C0191a;
import android.support.v4.p013b.C0190a;

public class C0992a {
    Context f3270a;

    public C0992a(Context context) {
        this.f3270a = context;
        if (C0190a.m864a(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            C0191a.m870a((Activity) context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        }
    }
}
