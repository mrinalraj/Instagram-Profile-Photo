package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.C0561k.C0583d;
import android.support.v7.app.C0564j.C0558a;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

class C0565g extends C0564j {

    class C0559a extends C0558a {
        final /* synthetic */ C0565g f1420b;

        C0559a(C0565g c0565g, Callback callback) {
            this.f1420b = c0565g;
            super(c0565g, callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C0583d a = this.f1420b.m2643a(0, true);
            if (a == null || a.f1487j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a.f1487j, i);
            }
        }
    }

    C0565g(Context context, Window window, C0548d c0548d) {
        super(context, window, c0548d);
    }

    Callback mo446a(Callback callback) {
        return new C0559a(this, callback);
    }
}
