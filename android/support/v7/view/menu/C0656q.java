package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p015d.p016a.C0302a;
import android.support.v4.p015d.p016a.C0303b;
import android.support.v4.p015d.p016a.C0304c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class C0656q {
    public static Menu m3185a(Context context, C0302a c0302a) {
        return new C0657r(context, c0302a);
    }

    public static MenuItem m3186a(Context context, C0303b c0303b) {
        return VERSION.SDK_INT >= 16 ? new C0653l(context, c0303b) : new C0651k(context, c0303b);
    }

    public static SubMenu m3187a(Context context, C0304c c0304c) {
        return new C0662v(context, c0304c);
    }
}
