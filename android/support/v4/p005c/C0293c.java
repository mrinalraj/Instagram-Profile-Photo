package android.support.v4.p005c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.support.v4.p013b.p014a.C0268b.C0264a;
import android.support.v4.p013b.p014a.C0268b.C0265b;
import android.support.v4.p013b.p014a.C0268b.C0267d;
import android.support.v4.p017f.C0323b;
import android.support.v4.p017f.C0323b.C0322b;
import android.support.v4.p018g.C0339g;
import android.widget.TextView;

public class C0293c {
    private static final C0292a f885a;
    private static final C0339g<String, Typeface> f886b = new C0339g(16);

    interface C0292a {
        Typeface mo207a(Context context, Resources resources, int i, String str, int i2);

        Typeface mo208a(Context context, CancellationSignal cancellationSignal, C0322b[] c0322bArr, int i);

        Typeface mo209a(Context context, C0265b c0265b, Resources resources, int i);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f885a = new C0297f();
        } else if (VERSION.SDK_INT >= 24 && C0296e.m1484a()) {
            f885a = new C0296e();
        } else if (VERSION.SDK_INT >= 21) {
            f885a = new C0295d();
        } else {
            f885a = new C0294g();
        }
    }

    public static Typeface m1469a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = f885a.mo207a(context, resources, i, str, i2);
        if (a != null) {
            f886b.m1650a(C0293c.m1473b(resources, i, i2), a);
        }
        return a;
    }

    public static Typeface m1470a(Context context, CancellationSignal cancellationSignal, C0322b[] c0322bArr, int i) {
        return f885a.mo208a(context, cancellationSignal, c0322bArr, i);
    }

    public static Typeface m1471a(Context context, C0264a c0264a, Resources resources, int i, int i2, TextView textView) {
        Typeface a;
        if (c0264a instanceof C0267d) {
            C0267d c0267d = (C0267d) c0264a;
            a = C0323b.m1552a(context, c0267d.m1344a(), textView, c0267d.m1345b(), c0267d.m1346c(), i2);
        } else {
            a = f885a.mo209a(context, (C0265b) c0264a, resources, i2);
        }
        if (a != null) {
            f886b.m1650a(C0293c.m1473b(resources, i, i2), a);
        }
        return a;
    }

    public static Typeface m1472a(Resources resources, int i, int i2) {
        return (Typeface) f886b.m1649a(C0293c.m1473b(resources, i, i2));
    }

    private static String m1473b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
