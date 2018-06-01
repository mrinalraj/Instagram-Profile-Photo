package android.support.v4.p012a;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p013b.C0190a;

public class C0191a extends C0190a {

    public interface C0188a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface C0189b {
        void mo169a(int i);
    }

    public static void m869a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void m870a(final Activity activity, final String[] strArr, final int i) {
        if (VERSION.SDK_INT >= 23) {
            if (activity instanceof C0189b) {
                ((C0189b) activity).mo169a(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof C0188a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0188a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
