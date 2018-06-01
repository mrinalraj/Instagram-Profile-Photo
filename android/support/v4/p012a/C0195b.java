package android.support.v4.p012a;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class C0195b {
    public static int m878a(Context context, String str, String str2) {
        return VERSION.SDK_INT >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2) : 1;
    }

    public static String m879a(String str) {
        return VERSION.SDK_INT >= 23 ? AppOpsManager.permissionToOp(str) : null;
    }
}
