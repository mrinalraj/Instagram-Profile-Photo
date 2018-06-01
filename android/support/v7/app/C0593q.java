package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p013b.C0272c;
import android.util.Log;
import java.util.Calendar;

class C0593q {
    private static C0593q f1534a;
    private final Context f1535b;
    private final LocationManager f1536c;
    private final C0592a f1537d = new C0592a();

    private static class C0592a {
        boolean f1528a;
        long f1529b;
        long f1530c;
        long f1531d;
        long f1532e;
        long f1533f;

        C0592a() {
        }
    }

    C0593q(Context context, LocationManager locationManager) {
        this.f1535b = context;
        this.f1536c = locationManager;
    }

    private Location m2772a(String str) {
        if (this.f1536c != null) {
            try {
                if (this.f1536c.isProviderEnabled(str)) {
                    return this.f1536c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    static C0593q m2773a(Context context) {
        if (f1534a == null) {
            Context applicationContext = context.getApplicationContext();
            f1534a = new C0593q(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1534a;
    }

    private void m2774a(Location location) {
        long j;
        C0592a c0592a = this.f1537d;
        long currentTimeMillis = System.currentTimeMillis();
        C0591p a = C0591p.m2770a();
        a.m2771a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1525a;
        a.m2771a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1527c == 1;
        long j3 = a.f1526b;
        long j4 = a.f1525a;
        a.m2771a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f1526b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        c0592a.f1528a = z;
        c0592a.f1529b = j2;
        c0592a.f1530c = j3;
        c0592a.f1531d = j4;
        c0592a.f1532e = j5;
        c0592a.f1533f = j;
    }

    private Location m2775b() {
        Location location = null;
        Location a = C0272c.m1379a(this.f1535b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m2772a("network") : null;
        if (C0272c.m1379a(this.f1535b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m2772a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        } else {
            if (location == null) {
                location = a;
            }
            return location;
        }
    }

    private boolean m2776c() {
        return this.f1537d != null && this.f1537d.f1533f > System.currentTimeMillis();
    }

    boolean m2777a() {
        C0592a c0592a = this.f1537d;
        if (m2776c()) {
            return c0592a.f1528a;
        }
        Location b = m2775b();
        if (b != null) {
            m2774a(b);
            return c0592a.f1528a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
