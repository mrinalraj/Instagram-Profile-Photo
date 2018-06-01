package android.support.v4.p013b;

import android.content.Context;
import android.os.Process;
import android.support.v4.p012a.C0195b;

public final class C0272c {
    public static int m1379a(Context context, String str) {
        return C0272c.m1380a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int m1380a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0195b.m879a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0195b.m878a(context, a, str2) != 0 ? -2 : 0;
    }
}
