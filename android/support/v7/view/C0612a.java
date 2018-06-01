package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0520b;
import android.support.v7.p021a.C0529a.C0522d;
import android.support.v7.p021a.C0529a.C0528j;
import android.view.ViewConfiguration;

public class C0612a {
    private Context f1588a;

    private C0612a(Context context) {
        this.f1588a = context;
    }

    public static C0612a m2870a(Context context) {
        return new C0612a(context);
    }

    public int m2871a() {
        Configuration configuration = this.f1588a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        return (configuration.smallestScreenWidthDp > 600 || i > 600 || ((i > 960 && i2 > 720) || (i > 720 && i2 > 960))) ? 5 : (i >= 500 || ((i > 640 && i2 > 480) || (i > 480 && i2 > 640))) ? 4 : i >= 360 ? 3 : 2;
    }

    public boolean m2872b() {
        return VERSION.SDK_INT >= 19 || !ViewConfiguration.get(this.f1588a).hasPermanentMenuKey();
    }

    public int m2873c() {
        return this.f1588a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m2874d() {
        return this.f1588a.getResources().getBoolean(C0520b.abc_action_bar_embed_tabs);
    }

    public int m2875e() {
        TypedArray obtainStyledAttributes = this.f1588a.obtainStyledAttributes(null, C0528j.ActionBar, C0519a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0528j.ActionBar_height, 0);
        Resources resources = this.f1588a.getResources();
        if (!m2874d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0522d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m2876f() {
        return this.f1588a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m2877g() {
        return this.f1588a.getResources().getDimensionPixelSize(C0522d.abc_action_bar_stacked_tab_max_width);
    }
}
