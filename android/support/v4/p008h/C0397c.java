package android.support.v4.p008h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class C0397c {
    private final Context f1045a;
    private C0395a f1046b;
    private C0396b f1047c;

    public interface C0395a {
        void mo778a(boolean z);
    }

    public interface C0396b {
        void mo548a(boolean z);
    }

    public C0397c(Context context) {
        this.f1045a = context;
    }

    public abstract View mo549a();

    public View mo555a(MenuItem menuItem) {
        return mo549a();
    }

    public void m1775a(C0395a c0395a) {
        this.f1046b = c0395a;
    }

    public void mo556a(C0396b c0396b) {
        if (!(this.f1047c == null || c0396b == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1047c = c0396b;
    }

    public void mo550a(SubMenu subMenu) {
    }

    public void m1778a(boolean z) {
        if (this.f1046b != null) {
            this.f1046b.mo778a(z);
        }
    }

    public boolean mo557b() {
        return false;
    }

    public boolean mo558c() {
        return true;
    }

    public boolean mo551d() {
        return false;
    }

    public boolean mo552e() {
        return false;
    }

    public void m1783f() {
        this.f1047c = null;
        this.f1046b = null;
    }
}
