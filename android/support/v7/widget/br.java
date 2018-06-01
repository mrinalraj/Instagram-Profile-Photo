package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.C0552e;
import java.lang.ref.WeakReference;

public class br extends Resources {
    private final WeakReference<Context> f2670a;

    public br(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2670a = new WeakReference(context);
    }

    public static boolean m4592a() {
        return C0552e.m2580k() && VERSION.SDK_INT <= 20;
    }

    final Drawable m4593a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2670a.get();
        return context != null ? C0827m.m4729a().m4750a(context, this, i) : super.getDrawable(i);
    }
}
