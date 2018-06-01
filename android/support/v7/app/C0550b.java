package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController.C0540a;
import android.support.v7.p021a.C0529a.C0519a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class C0550b extends C0549l implements DialogInterface {
    final AlertController f1391a = new AlertController(getContext(), this, getWindow());

    public static class C0547a {
        private final C0540a f1388a;
        private final int f1389b;

        public C0547a(Context context) {
            this(context, C0550b.m2562a(context, 0));
        }

        public C0547a(Context context, int i) {
            this.f1388a = new C0540a(new ContextThemeWrapper(context, C0550b.m2562a(context, i)));
            this.f1389b = i;
        }

        public Context m2542a() {
            return this.f1388a.f1319a;
        }

        public C0547a m2543a(OnKeyListener onKeyListener) {
            this.f1388a.f1336r = onKeyListener;
            return this;
        }

        public C0547a m2544a(Drawable drawable) {
            this.f1388a.f1322d = drawable;
            return this;
        }

        public C0547a m2545a(View view) {
            this.f1388a.f1325g = view;
            return this;
        }

        public C0547a m2546a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f1388a.f1338t = listAdapter;
            this.f1388a.f1339u = onClickListener;
            return this;
        }

        public C0547a m2547a(CharSequence charSequence) {
            this.f1388a.f1324f = charSequence;
            return this;
        }

        public C0547a m2548a(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1388a.f1327i = charSequence;
            this.f1388a.f1328j = onClickListener;
            return this;
        }

        public C0547a m2549b(CharSequence charSequence) {
            this.f1388a.f1326h = charSequence;
            return this;
        }

        public C0547a m2550b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1388a.f1329k = charSequence;
            this.f1388a.f1330l = onClickListener;
            return this;
        }

        public C0550b m2551b() {
            C0550b c0550b = new C0550b(this.f1388a.f1319a, this.f1389b);
            this.f1388a.m2492a(c0550b.f1391a);
            c0550b.setCancelable(this.f1388a.f1333o);
            if (this.f1388a.f1333o) {
                c0550b.setCanceledOnTouchOutside(true);
            }
            c0550b.setOnCancelListener(this.f1388a.f1334p);
            c0550b.setOnDismissListener(this.f1388a.f1335q);
            if (this.f1388a.f1336r != null) {
                c0550b.setOnKeyListener(this.f1388a.f1336r);
            }
            return c0550b;
        }

        public C0550b m2552c() {
            C0550b b = m2551b();
            b.show();
            return b;
        }
    }

    protected C0550b(Context context, int i) {
        super(context, C0550b.m2562a(context, i));
    }

    static int m2562a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0519a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1391a.m2505a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1391a.m2511a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1391a.m2515b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1391a.m2510a(charSequence);
    }
}
