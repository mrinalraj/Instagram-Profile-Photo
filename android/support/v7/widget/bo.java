package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class bo {
    private static final C0795c f2651a;

    private interface C0795c {
        void mo771a(View view, CharSequence charSequence);
    }

    @TargetApi(26)
    private static class C0796a implements C0795c {
        private C0796a() {
        }

        public void mo771a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private static class C0797b implements C0795c {
        private C0797b() {
        }

        public void mo771a(View view, CharSequence charSequence) {
            bp.m4585a(view, charSequence);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f2651a = new C0796a();
        } else {
            f2651a = new C0797b();
        }
    }

    public static void m4581a(View view, CharSequence charSequence) {
        f2651a.mo771a(view, charSequence);
    }
}
