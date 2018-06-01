package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p012a.C0191a;
import android.support.v4.p012a.C0217i;
import android.support.v4.p012a.C0259w;
import android.support.v4.p012a.ab;
import android.support.v4.p012a.ab.C0192a;
import android.support.v7.view.C0597b;
import android.support.v7.view.C0597b.C0580a;
import android.support.v7.widget.br;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class C0551c extends C0217i implements C0192a, C0548d {
    private C0552e f1392m;
    private int f1393n = 0;
    private Resources f1394o;

    private boolean m2563a(int i, KeyEvent keyEvent) {
        if (!(VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()))) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                return true;
            }
        }
        return false;
    }

    public C0597b mo392a(C0580a c0580a) {
        return null;
    }

    public void m2565a(ab abVar) {
        abVar.m873a((Activity) this);
    }

    public void mo393a(C0597b c0597b) {
    }

    public boolean m2567a(Intent intent) {
        return C0259w.m1328a((Activity) this, intent);
    }

    public Intent a_() {
        return C0259w.m1326a(this);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m2575j().mo437b(view, layoutParams);
    }

    public void m2568b(Intent intent) {
        C0259w.m1331b((Activity) this, intent);
    }

    public void m2569b(ab abVar) {
    }

    public void mo394b(C0597b c0597b) {
    }

    public void closeOptionsMenu() {
        C0546a g = m2572g();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (g == null || !g.mo469d()) {
            super.closeOptionsMenu();
        }
    }

    public void mo398d() {
        m2575j().mo442f();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        C0546a g = m2572g();
        return (keyCode == 82 && g != null && g.mo464a(keyEvent)) ? true : super.dispatchKeyEvent(keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return m2575j().mo425a(i);
    }

    public C0546a m2572g() {
        return m2575j().mo413a();
    }

    public MenuInflater getMenuInflater() {
        return m2575j().mo415b();
    }

    public Resources getResources() {
        if (this.f1394o == null && br.m4592a()) {
            this.f1394o = new br(this, super.getResources());
        }
        return this.f1394o == null ? super.getResources() : this.f1394o;
    }

    public boolean m2573h() {
        Intent a_ = a_();
        if (a_ == null) {
            return false;
        }
        if (m2567a(a_)) {
            ab a = ab.m872a((Context) this);
            m2565a(a);
            m2569b(a);
            a.m876a();
            try {
                C0191a.m869a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m2568b(a_);
        }
        return true;
    }

    @Deprecated
    public void m2574i() {
    }

    public void invalidateOptionsMenu() {
        m2575j().mo442f();
    }

    public C0552e m2575j() {
        if (this.f1392m == null) {
            this.f1392m = C0552e.m2576a((Activity) this, (C0548d) this);
        }
        return this.f1392m;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2575j().mo427a(configuration);
        if (this.f1394o != null) {
            this.f1394o.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        m2574i();
    }

    protected void onCreate(Bundle bundle) {
        C0552e j = m2575j();
        j.mo443h();
        j.mo428a(bundle);
        if (j.mo420i() && this.f1393n != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f1393n, false);
            } else {
                setTheme(this.f1393n);
            }
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        m2575j().mo419g();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return m2563a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0546a g = m2572g();
        return (menuItem.getItemId() != 16908332 || g == null || (g.mo458a() & 4) == 0) ? false : m2573h();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m2575j().mo436b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        m2575j().mo441e();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m2575j().mo417c(bundle);
    }

    protected void onStart() {
        super.onStart();
        m2575j().mo416c();
    }

    protected void onStop() {
        super.onStop();
        m2575j().mo418d();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m2575j().mo414a(charSequence);
    }

    public void openOptionsMenu() {
        C0546a g = m2572g();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (g == null || !g.mo467c()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i) {
        m2575j().mo435b(i);
    }

    public void setContentView(View view) {
        m2575j().mo430a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m2575j().mo431a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f1393n = i;
    }
}
