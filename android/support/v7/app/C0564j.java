package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.C0563i.C0557a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0564j extends C0563i {
    private final UiModeManager f1451t;

    class C0558a extends C0557a {
        final /* synthetic */ C0564j f1419d;

        C0558a(C0564j c0564j, Callback callback) {
            this.f1419d = c0564j;
            super(c0564j, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.f1419d.mo448o()) {
                switch (i) {
                    case 0:
                        return m2624a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    C0564j(Context context, Window window, C0548d c0548d) {
        super(context, window, c0548d);
        this.f1451t = (UiModeManager) context.getSystemService("uimode");
    }

    Callback mo446a(Callback callback) {
        return new C0558a(this, callback);
    }

    int mo447d(int i) {
        return (i == 0 && this.f1451t.getNightMode() == 0) ? -1 : super.mo447d(i);
    }
}
