package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class C0552e {
    private static int f1395a = -1;
    private static boolean f1396b = false;

    C0552e() {
    }

    public static C0552e m2576a(Activity activity, C0548d c0548d) {
        return C0552e.m2578a(activity, activity.getWindow(), c0548d);
    }

    public static C0552e m2577a(Dialog dialog, C0548d c0548d) {
        return C0552e.m2578a(dialog.getContext(), dialog.getWindow(), c0548d);
    }

    private static C0552e m2578a(Context context, Window window, C0548d c0548d) {
        return VERSION.SDK_INT >= 24 ? new C0565g(context, window, c0548d) : VERSION.SDK_INT >= 23 ? new C0564j(context, window, c0548d) : VERSION.SDK_INT >= 14 ? new C0563i(context, window, c0548d) : VERSION.SDK_INT >= 11 ? new C0562h(context, window, c0548d) : new C0561k(context, window, c0548d);
    }

    public static int m2579j() {
        return f1395a;
    }

    public static boolean m2580k() {
        return f1396b;
    }

    public abstract C0546a mo413a();

    public abstract <T extends View> T mo425a(int i);

    public abstract void mo427a(Configuration configuration);

    public abstract void mo428a(Bundle bundle);

    public abstract void mo430a(View view);

    public abstract void mo431a(View view, LayoutParams layoutParams);

    public abstract void mo414a(CharSequence charSequence);

    public abstract MenuInflater mo415b();

    public abstract void mo435b(int i);

    public abstract void mo436b(Bundle bundle);

    public abstract void mo437b(View view, LayoutParams layoutParams);

    public abstract void mo416c();

    public abstract void mo417c(Bundle bundle);

    public abstract boolean mo440c(int i);

    public abstract void mo418d();

    public abstract void mo441e();

    public abstract void mo442f();

    public abstract void mo419g();

    public abstract void mo443h();

    public abstract boolean mo420i();
}
