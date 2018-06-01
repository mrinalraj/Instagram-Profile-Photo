package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bj extends ContextWrapper {
    private static final Object f2617a = new Object();
    private static ArrayList<WeakReference<bj>> f2618b;
    private final Resources f2619c;
    private final Theme f2620d;

    private bj(Context context) {
        super(context);
        if (br.m4592a()) {
            this.f2619c = new br(this, context.getResources());
            this.f2620d = this.f2619c.newTheme();
            this.f2620d.setTo(context.getTheme());
            return;
        }
        this.f2619c = new bl(this, context.getResources());
        this.f2620d = null;
    }

    public static Context m4508a(Context context) {
        if (!m4509b(context)) {
            return context;
        }
        synchronized (f2617a) {
            Context context2;
            if (f2618b == null) {
                f2618b = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = f2618b.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) f2618b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f2618b.remove(size);
                    }
                }
                size = f2618b.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) f2618b.get(size);
                    context2 = weakReference != null ? (bj) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            context2 = new bj(context);
            f2618b.add(new WeakReference(context2));
            return context2;
        }
    }

    private static boolean m4509b(Context context) {
        return ((context instanceof bj) || (context.getResources() instanceof bl) || (context.getResources() instanceof br)) ? false : VERSION.SDK_INT < 21 || br.m4592a();
    }

    public AssetManager getAssets() {
        return this.f2619c.getAssets();
    }

    public Resources getResources() {
        return this.f2619c;
    }

    public Theme getTheme() {
        return this.f2620d == null ? super.getTheme() : this.f2620d;
    }

    public void setTheme(int i) {
        if (this.f2620d == null) {
            super.setTheme(i);
        } else {
            this.f2620d.applyStyle(i, true);
        }
    }
}
