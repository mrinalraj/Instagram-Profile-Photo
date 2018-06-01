package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class bl extends az {
    private final WeakReference<Context> f2625a;

    public bl(Context context, Resources resources) {
        super(resources);
        this.f2625a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f2625a.get();
        if (!(drawable == null || context == null)) {
            C0827m.m4729a();
            C0827m.m4735a(context, i, drawable);
        }
        return drawable;
    }
}
