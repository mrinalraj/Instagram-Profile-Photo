package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.app.C0550b;
import android.support.v7.app.C0550b.C0547a;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.view.menu.C0628o.C0577a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class C0644i implements OnClickListener, OnDismissListener, OnKeyListener, C0577a {
    C0641f f1814a;
    private C0643h f1815b;
    private C0550b f1816c;
    private C0577a f1817d;

    public C0644i(C0643h c0643h) {
        this.f1815b = c0643h;
    }

    public void m3123a() {
        if (this.f1816c != null) {
            this.f1816c.dismiss();
        }
    }

    public void m3124a(IBinder iBinder) {
        C0643h c0643h = this.f1815b;
        C0547a c0547a = new C0547a(c0643h.m3108e());
        this.f1814a = new C0641f(c0547a.m2542a(), C0525g.abc_list_menu_item_layout);
        this.f1814a.mo527a((C0577a) this);
        this.f1815b.m3087a(this.f1814a);
        c0547a.m2546a(this.f1814a.m3055a(), (OnClickListener) this);
        View o = c0643h.m3119o();
        if (o != null) {
            c0547a.m2545a(o);
        } else {
            c0547a.m2544a(c0643h.m3118n()).m2547a(c0643h.m3117m());
        }
        c0547a.m2543a((OnKeyListener) this);
        this.f1816c = c0547a.m2551b();
        this.f1816c.setOnDismissListener(this);
        LayoutParams attributes = this.f1816c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1816c.show();
    }

    public void mo452a(C0643h c0643h, boolean z) {
        if (z || c0643h == this.f1815b) {
            m3123a();
        }
        if (this.f1817d != null) {
            this.f1817d.mo452a(c0643h, z);
        }
    }

    public boolean mo453a(C0643h c0643h) {
        return this.f1817d != null ? this.f1817d.mo453a(c0643h) : false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1815b.m3093a((C0646j) this.f1814a.m3055a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1814a.mo526a(this.f1815b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1816c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f1816c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1815b.m3091a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1815b.performShortcut(i, keyEvent, 0);
    }
}
