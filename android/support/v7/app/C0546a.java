package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.C0597b;
import android.support.v7.view.C0597b.C0580a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class C0546a {

    public static class C0543a extends MarginLayoutParams {
        public int f1387a;

        public C0543a(int i, int i2) {
            super(i, i2);
            this.f1387a = 0;
            this.f1387a = 8388627;
        }

        public C0543a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1387a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.ActionBarLayout);
            this.f1387a = obtainStyledAttributes.getInt(C0528j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0543a(C0543a c0543a) {
            super(c0543a);
            this.f1387a = 0;
            this.f1387a = c0543a.f1387a;
        }

        public C0543a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1387a = 0;
        }
    }

    public interface C0544b {
        void m2518a(boolean z);
    }

    @Deprecated
    public static abstract class C0545c {
        public abstract Drawable m2519a();

        public abstract CharSequence m2520b();

        public abstract View m2521c();

        public abstract void m2522d();

        public abstract CharSequence m2523e();
    }

    public abstract int mo458a();

    public C0597b mo489a(C0580a c0580a) {
        return null;
    }

    public void mo459a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void mo460a(Configuration configuration) {
    }

    public void mo461a(CharSequence charSequence) {
    }

    public void mo462a(boolean z) {
    }

    public boolean mo463a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean mo464a(KeyEvent keyEvent) {
        return false;
    }

    public Context mo465b() {
        return null;
    }

    public void mo491b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void mo466c(boolean z) {
    }

    public boolean mo467c() {
        return false;
    }

    public void mo468d(boolean z) {
    }

    public boolean mo469d() {
        return false;
    }

    public void mo470e(boolean z) {
    }

    public boolean mo471e() {
        return false;
    }

    public boolean mo472f() {
        return false;
    }

    void mo473g() {
    }
}
