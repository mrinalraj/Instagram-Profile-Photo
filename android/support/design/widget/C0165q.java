package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p021a.C0529a.C0519a;

class C0165q {
    private static final int[] f511a = new int[]{C0519a.colorPrimary};

    static void m782a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f511a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
