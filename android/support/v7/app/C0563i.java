package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.C0556f.C0555a;
import android.support.v7.view.C0597b;
import android.support.v7.view.C0597b.C0580a;
import android.support.v7.view.C0617f.C0616a;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0563i extends C0562h {
    private int f1447t = -100;
    private boolean f1448u;
    private boolean f1449v = true;
    private C0567b f1450w;

    class C0557a extends C0555a {
        final /* synthetic */ C0563i f1418c;

        C0557a(C0563i c0563i, Callback callback) {
            this.f1418c = c0563i;
            super(c0563i, callback);
        }

        final ActionMode m2624a(ActionMode.Callback callback) {
            Object c0616a = new C0616a(this.f1418c.a, callback);
            C0597b b = this.f1418c.m2660b((C0580a) c0616a);
            return b != null ? c0616a.m2904b(b) : null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.f1418c.mo448o() ? m2624a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    final class C0567b {
        final /* synthetic */ C0563i f1453a;
        private C0593q f1454b;
        private boolean f1455c;
        private BroadcastReceiver f1456d;
        private IntentFilter f1457e;

        class C05661 extends BroadcastReceiver {
            final /* synthetic */ C0567b f1452a;

            C05661(C0567b c0567b) {
                this.f1452a = c0567b;
            }

            public void onReceive(Context context, Intent intent) {
                this.f1452a.m2702b();
            }
        }

        C0567b(C0563i c0563i, C0593q c0593q) {
            this.f1453a = c0563i;
            this.f1454b = c0593q;
            this.f1455c = c0593q.m2777a();
        }

        final int m2701a() {
            this.f1455c = this.f1454b.m2777a();
            return this.f1455c ? 2 : 1;
        }

        final void m2702b() {
            boolean a = this.f1454b.m2777a();
            if (a != this.f1455c) {
                this.f1455c = a;
                this.f1453a.mo420i();
            }
        }

        final void m2703c() {
            m2704d();
            if (this.f1456d == null) {
                this.f1456d = new C05661(this);
            }
            if (this.f1457e == null) {
                this.f1457e = new IntentFilter();
                this.f1457e.addAction("android.intent.action.TIME_SET");
                this.f1457e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f1457e.addAction("android.intent.action.TIME_TICK");
            }
            this.f1453a.a.registerReceiver(this.f1456d, this.f1457e);
        }

        final void m2704d() {
            if (this.f1456d != null) {
                this.f1453a.a.unregisterReceiver(this.f1456d);
                this.f1456d = null;
            }
        }
    }

    C0563i(Context context, Window window, C0548d c0548d) {
        super(context, window, c0548d);
    }

    private boolean m2685h(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (m2688y()) {
            ((Activity) this.a).recreate();
        } else {
            Configuration configuration2 = new Configuration(configuration);
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration2.uiMode = i3 | (configuration2.uiMode & -49);
            resources.updateConfiguration(configuration2, displayMetrics);
            if (VERSION.SDK_INT < 26) {
                C0587n.m2744a(resources);
            }
        }
        return true;
    }

    private int m2686w() {
        return this.f1447t != -100 ? this.f1447t : C0552e.m2579j();
    }

    private void m2687x() {
        if (this.f1450w == null) {
            this.f1450w = new C0567b(this, C0593q.m2773a(this.a));
        }
    }

    private boolean m2688y() {
        if (!this.f1448u || !(this.a instanceof Activity)) {
            return false;
        }
        try {
            return (this.a.getPackageManager().getActivityInfo(new ComponentName(this.a, this.a.getClass()), 0).configChanges & 512) == 0;
        } catch (Throwable e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    Callback mo446a(Callback callback) {
        return new C0557a(this, callback);
    }

    public void mo428a(Bundle bundle) {
        super.mo428a(bundle);
        if (bundle != null && this.f1447t == -100) {
            this.f1447t = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void mo416c() {
        super.mo416c();
        mo420i();
    }

    public void mo417c(Bundle bundle) {
        super.mo417c(bundle);
        if (this.f1447t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f1447t);
        }
    }

    int mo447d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                m2687x();
                return this.f1450w.m2701a();
            default:
                return i;
        }
    }

    public void mo418d() {
        super.mo418d();
        if (this.f1450w != null) {
            this.f1450w.m2704d();
        }
    }

    public void mo419g() {
        super.mo419g();
        if (this.f1450w != null) {
            this.f1450w.m2704d();
        }
    }

    public boolean mo420i() {
        boolean z = false;
        int w = m2686w();
        int d = mo447d(w);
        if (d != -1) {
            z = m2685h(d);
        }
        if (w == 0) {
            m2687x();
            this.f1450w.m2703c();
        }
        this.f1448u = true;
        return z;
    }

    public boolean mo448o() {
        return this.f1449v;
    }
}
