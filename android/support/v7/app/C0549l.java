package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.view.C0597b;
import android.support.v7.view.C0597b.C0580a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class C0549l extends Dialog implements C0548d {
    private C0552e f1390a;

    public C0549l(Context context, int i) {
        super(context, C0549l.m2556a(context, i));
        m2557a().mo428a(null);
        m2557a().mo420i();
    }

    private static int m2556a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0519a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public C0552e m2557a() {
        if (this.f1390a == null) {
            this.f1390a = C0552e.m2577a((Dialog) this, (C0548d) this);
        }
        return this.f1390a;
    }

    public C0597b mo392a(C0580a c0580a) {
        return null;
    }

    public void mo393a(C0597b c0597b) {
    }

    public boolean m2560a(int i) {
        return m2557a().mo440c(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m2557a().mo437b(view, layoutParams);
    }

    public void mo394b(C0597b c0597b) {
    }

    public <T extends View> T findViewById(int i) {
        return m2557a().mo425a(i);
    }

    public void invalidateOptionsMenu() {
        m2557a().mo442f();
    }

    protected void onCreate(Bundle bundle) {
        m2557a().mo443h();
        super.onCreate(bundle);
        m2557a().mo428a(bundle);
    }

    protected void onStop() {
        super.onStop();
        m2557a().mo418d();
    }

    public void setContentView(int i) {
        m2557a().mo435b(i);
    }

    public void setContentView(View view) {
        m2557a().mo430a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m2557a().mo431a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m2557a().mo414a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m2557a().mo414a(charSequence);
    }
}
