package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.p008h.C0425s;
import android.support.v7.app.C0546a.C0544b;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0643h.C0560a;
import android.support.v7.widget.aj;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window.Callback;
import java.util.ArrayList;

class C0590o extends C0546a {
    aj f1518a;
    Callback f1519b;
    private boolean f1520c;
    private boolean f1521d;
    private ArrayList<C0544b> f1522e;
    private final Runnable f1523f;

    private final class C0588a implements C0577a {
        final /* synthetic */ C0590o f1515a;
        private boolean f1516b;

        C0588a(C0590o c0590o) {
            this.f1515a = c0590o;
        }

        public void mo452a(C0643h c0643h, boolean z) {
            if (!this.f1516b) {
                this.f1516b = true;
                this.f1515a.f1518a.mo767n();
                if (this.f1515a.f1519b != null) {
                    this.f1515a.f1519b.onPanelClosed(108, c0643h);
                }
                this.f1516b = false;
            }
        }

        public boolean mo453a(C0643h c0643h) {
            if (this.f1515a.f1519b == null) {
                return false;
            }
            this.f1515a.f1519b.onMenuOpened(108, c0643h);
            return true;
        }
    }

    private final class C0589b implements C0560a {
        final /* synthetic */ C0590o f1517a;

        C0589b(C0590o c0590o) {
            this.f1517a = c0590o;
        }

        public void mo429a(C0643h c0643h) {
            if (this.f1517a.f1519b == null) {
                return;
            }
            if (this.f1517a.f1518a.mo762i()) {
                this.f1517a.f1519b.onPanelClosed(108, c0643h);
            } else if (this.f1517a.f1519b.onPreparePanel(0, null, c0643h)) {
                this.f1517a.f1519b.onMenuOpened(108, c0643h);
            }
        }

        public boolean mo433a(C0643h c0643h, MenuItem menuItem) {
            return false;
        }
    }

    private Menu m2753h() {
        if (!this.f1520c) {
            this.f1518a.mo745a(new C0588a(this), new C0589b(this));
            this.f1520c = true;
        }
        return this.f1518a.mo770q();
    }

    public int mo458a() {
        return this.f1518a.mo768o();
    }

    public void mo459a(float f) {
        C0425s.m1962d(this.f1518a.mo742a(), f);
    }

    public void mo460a(Configuration configuration) {
        super.mo460a(configuration);
    }

    public void mo461a(CharSequence charSequence) {
        this.f1518a.mo749a(charSequence);
    }

    public void mo462a(boolean z) {
    }

    public boolean mo463a(int i, KeyEvent keyEvent) {
        Menu h = m2753h();
        if (h == null) {
            return false;
        }
        h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return h.performShortcut(i, keyEvent, 0);
    }

    public boolean mo464a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo467c();
        }
        return true;
    }

    public Context mo465b() {
        return this.f1518a.mo751b();
    }

    public void mo466c(boolean z) {
    }

    public boolean mo467c() {
        return this.f1518a.mo764k();
    }

    public void mo468d(boolean z) {
    }

    public boolean mo469d() {
        return this.f1518a.mo765l();
    }

    public void mo470e(boolean z) {
        if (z != this.f1521d) {
            this.f1521d = z;
            int size = this.f1522e.size();
            for (int i = 0; i < size; i++) {
                ((C0544b) this.f1522e.get(i)).m2518a(z);
            }
        }
    }

    public boolean mo471e() {
        this.f1518a.mo742a().removeCallbacks(this.f1523f);
        C0425s.m1950a(this.f1518a.mo742a(), this.f1523f);
        return true;
    }

    public boolean mo472f() {
        if (!this.f1518a.mo755c()) {
            return false;
        }
        this.f1518a.mo756d();
        return true;
    }

    void mo473g() {
        this.f1518a.mo742a().removeCallbacks(this.f1523f);
    }
}
