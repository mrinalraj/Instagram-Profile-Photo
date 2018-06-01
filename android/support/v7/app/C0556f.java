package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.C0554i;
import android.support.v7.view.C0597b;
import android.support.v7.view.C0597b.C0580a;
import android.support.v7.view.C0620g;
import android.support.v7.view.menu.C0643h;
import android.support.v7.widget.bm;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.Thread.UncaughtExceptionHandler;

abstract class C0556f extends C0552e {
    private static boolean f1400m = true;
    private static final boolean f1401n = (VERSION.SDK_INT < 21);
    private static final int[] f1402o = new int[]{16842836};
    final Context f1403a;
    final Window f1404b;
    final Callback f1405c = this.f1404b.getCallback();
    final Callback f1406d;
    final C0548d f1407e;
    C0546a f1408f;
    MenuInflater f1409g;
    boolean f1410h;
    boolean f1411i;
    boolean f1412j;
    boolean f1413k;
    boolean f1414l;
    private CharSequence f1415p;
    private boolean f1416q;
    private boolean f1417r;

    class C0555a extends C0554i {
        final /* synthetic */ C0556f f1399a;

        C0555a(C0556f c0556f, Callback callback) {
            this.f1399a = c0556f;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1399a.mo434a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.f1399a.mo432a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (i != 0 || (menu instanceof C0643h)) ? super.onCreatePanelMenu(i, menu) : false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f1399a.mo439b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f1399a.mo426a(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0643h c0643h = menu instanceof C0643h ? (C0643h) menu : null;
            if (i == 0 && c0643h == null) {
                return false;
            }
            if (c0643h != null) {
                c0643h.m3102c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0643h == null) {
                return onPreparePanel;
            }
            c0643h.m3102c(false);
            return onPreparePanel;
        }
    }

    static {
        if (f1401n && !f1400m) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                private boolean m2601a(Throwable th) {
                    if (!(th instanceof NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    return message != null ? message.contains("drawable") || message.contains("Drawable") : false;
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (m2601a(th)) {
                        Throwable notFoundException = new NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    C0556f(Context context, Window window, C0548d c0548d) {
        this.f1403a = context;
        this.f1404b = window;
        this.f1407e = c0548d;
        if (this.f1405c instanceof C0555a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1406d = mo446a(this.f1405c);
        this.f1404b.setCallback(this.f1406d);
        bm a = bm.m4512a(context, null, f1402o);
        Drawable b = a.m4521b(0);
        if (b != null) {
            this.f1404b.setBackgroundDrawable(b);
        }
        a.m4518a();
    }

    public C0546a mo413a() {
        mo444l();
        return this.f1408f;
    }

    abstract C0597b mo424a(C0580a c0580a);

    Callback mo446a(Callback callback) {
        return new C0555a(this, callback);
    }

    abstract void mo426a(int i, Menu menu);

    public final void mo414a(CharSequence charSequence) {
        this.f1415p = charSequence;
        mo438b(charSequence);
    }

    abstract boolean mo432a(int i, KeyEvent keyEvent);

    abstract boolean mo434a(KeyEvent keyEvent);

    public MenuInflater mo415b() {
        if (this.f1409g == null) {
            mo444l();
            this.f1409g = new C0620g(this.f1408f != null ? this.f1408f.mo465b() : this.f1403a);
        }
        return this.f1409g;
    }

    abstract void mo438b(CharSequence charSequence);

    abstract boolean mo439b(int i, Menu menu);

    public void mo416c() {
        this.f1416q = true;
    }

    public void mo417c(Bundle bundle) {
    }

    public void mo418d() {
        this.f1416q = false;
    }

    public void mo419g() {
        this.f1417r = true;
    }

    public boolean mo420i() {
        return false;
    }

    abstract void mo444l();

    final C0546a m2618m() {
        return this.f1408f;
    }

    final Context m2619n() {
        Context context = null;
        C0546a a = mo413a();
        if (a != null) {
            context = a.mo465b();
        }
        return context == null ? this.f1403a : context;
    }

    public boolean mo448o() {
        return false;
    }

    final boolean m2621p() {
        return this.f1417r;
    }

    final Callback m2622q() {
        return this.f1404b.getCallback();
    }

    final CharSequence m2623r() {
        return this.f1405c instanceof Activity ? ((Activity) this.f1405c).getTitle() : this.f1415p;
    }
}
