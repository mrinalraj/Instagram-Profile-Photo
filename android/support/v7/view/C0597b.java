package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class C0597b {
    private Object f1541a;
    private boolean f1542b;

    public interface C0580a {
        void mo454a(C0597b c0597b);

        boolean mo455a(C0597b c0597b, Menu menu);

        boolean mo456a(C0597b c0597b, MenuItem menuItem);

        boolean mo457b(C0597b c0597b, Menu menu);
    }

    public abstract MenuInflater mo475a();

    public abstract void mo476a(int i);

    public abstract void mo477a(View view);

    public abstract void mo478a(CharSequence charSequence);

    public void m2785a(Object obj) {
        this.f1541a = obj;
    }

    public void mo479a(boolean z) {
        this.f1542b = z;
    }

    public abstract Menu mo480b();

    public abstract void mo481b(int i);

    public abstract void mo482b(CharSequence charSequence);

    public abstract void mo483c();

    public abstract void mo484d();

    public abstract CharSequence mo485f();

    public abstract CharSequence mo486g();

    public boolean mo487h() {
        return false;
    }

    public abstract View mo488i();

    public Object m2796j() {
        return this.f1541a;
    }

    public boolean m2797k() {
        return this.f1542b;
    }
}
