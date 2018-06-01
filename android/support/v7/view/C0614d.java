package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.p021a.C0529a.C0527i;
import android.view.LayoutInflater;

public class C0614d extends ContextWrapper {
    private int f1589a;
    private Theme f1590b;
    private LayoutInflater f1591c;
    private Configuration f1592d;
    private Resources f1593e;

    public C0614d() {
        super(null);
    }

    public C0614d(Context context, int i) {
        super(context);
        this.f1589a = i;
    }

    public C0614d(Context context, Theme theme) {
        super(context);
        this.f1590b = theme;
    }

    private Resources m2880b() {
        if (this.f1593e == null) {
            if (this.f1592d == null) {
                this.f1593e = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.f1593e = createConfigurationContext(this.f1592d).getResources();
            }
        }
        return this.f1593e;
    }

    private void m2881c() {
        boolean z = this.f1590b == null;
        if (z) {
            this.f1590b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1590b.setTo(theme);
            }
        }
        m2883a(this.f1590b, this.f1589a, z);
    }

    public int m2882a() {
        return this.f1589a;
    }

    protected void m2883a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return m2880b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1591c == null) {
            this.f1591c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1591c;
    }

    public Theme getTheme() {
        if (this.f1590b != null) {
            return this.f1590b;
        }
        if (this.f1589a == 0) {
            this.f1589a = C0527i.Theme_AppCompat_Light;
        }
        m2881c();
        return this.f1590b;
    }

    public void setTheme(int i) {
        if (this.f1589a != i) {
            this.f1589a = i;
            m2881c();
        }
    }
}
