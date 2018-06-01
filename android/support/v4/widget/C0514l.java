package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class C0514l {
    static final C0508f f1254a;

    static class C0508f {
        C0508f() {
        }

        public void mo390a(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        public void mo389a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    static class C0509a extends C0508f {
        C0509a() {
        }
    }

    static class C0510b extends C0509a {
        C0510b() {
        }

        public void mo389a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
            Drawable drawable5 = obj != null ? drawable3 : drawable;
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }
    }

    static class C0511c extends C0510b {
        C0511c() {
        }

        public void mo389a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }
    }

    static class C0512d extends C0511c {
        C0512d() {
        }

        public void mo390a(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    static class C0513e extends C0512d {
        C0513e() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1254a = new C0513e();
        } else if (VERSION.SDK_INT >= 23) {
            f1254a = new C0512d();
        } else if (VERSION.SDK_INT >= 18) {
            f1254a = new C0511c();
        } else if (VERSION.SDK_INT >= 17) {
            f1254a = new C0510b();
        } else if (VERSION.SDK_INT >= 16) {
            f1254a = new C0509a();
        } else {
            f1254a = new C0508f();
        }
    }

    public static void m2451a(TextView textView, int i) {
        f1254a.mo390a(textView, i);
    }

    public static void m2452a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1254a.mo389a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
