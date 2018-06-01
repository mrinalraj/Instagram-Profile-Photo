package com.p026a.p027a.p028a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.p026a.p027a.C0886m;
import java.io.File;

public class C0866k {
    public static C0886m m4910a(Context context) {
        return C0866k.m4911a(context, null);
    }

    public static C0886m m4911a(Context context, C0857f c0857f) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            packageName = String.valueOf(String.valueOf(packageName));
            str = new StringBuilder(packageName.length() + 12).append(packageName).append("/").append(packageInfo.versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (c0857f == null) {
            c0857f = VERSION.SDK_INT >= 9 ? new C0861g() : new C0858d(AndroidHttpClient.newInstance(str));
        }
        C0886m c0886m = new C0886m(new C0855c(file), new C0848a(c0857f));
        c0886m.m4935a();
        return c0886m;
    }
}
