package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.p005c.C0288a;
import android.util.TypedValue;

class bh {
    static final int[] f2607a = new int[]{-16842910};
    static final int[] f2608b = new int[]{16842908};
    static final int[] f2609c = new int[]{16843518};
    static final int[] f2610d = new int[]{16842919};
    static final int[] f2611e = new int[]{16842912};
    static final int[] f2612f = new int[]{16842913};
    static final int[] f2613g = new int[]{-16842919, -16842908};
    static final int[] f2614h = new int[0];
    private static final ThreadLocal<TypedValue> f2615i = new ThreadLocal();
    private static final int[] f2616j = new int[1];

    public static int m4501a(Context context, int i) {
        f2616j[0] = i;
        bm a = bm.m4512a(context, null, f2616j);
        try {
            int b = a.m4520b(0, 0);
            return b;
        } finally {
            a.m4518a();
        }
    }

    static int m4502a(Context context, int i, float f) {
        int a = m4501a(context, i);
        return C0288a.m1449b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    private static TypedValue m4503a() {
        TypedValue typedValue = (TypedValue) f2615i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2615i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList m4504b(Context context, int i) {
        f2616j[0] = i;
        bm a = bm.m4512a(context, null, f2616j);
        try {
            ColorStateList e = a.m4527e(0);
            return e;
        } finally {
            a.m4518a();
        }
    }

    public static int m4505c(Context context, int i) {
        ColorStateList b = m4504b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2607a, b.getDefaultColor());
        }
        TypedValue a = m4503a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m4502a(context, i, a.getFloat());
    }
}
