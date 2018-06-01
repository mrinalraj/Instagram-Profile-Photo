package android.support.v4.p013b;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

@Deprecated
public abstract class C0273d extends BroadcastReceiver {
    private static final SparseArray<WakeLock> f861a = new SparseArray();
    private static int f862b = 1;

    public static ComponentName m1381a(Context context, Intent intent) {
        synchronized (f861a) {
            int i = f862b;
            f862b++;
            if (f862b <= 0) {
                f862b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f861a.put(i, newWakeLock);
            return startService;
        }
    }
}
