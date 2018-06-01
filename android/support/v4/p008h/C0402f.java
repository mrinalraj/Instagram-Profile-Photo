package android.support.v4.p008h;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class C0402f {
    public static int m1790a(MarginLayoutParams marginLayoutParams) {
        return VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginStart() : marginLayoutParams.leftMargin;
    }

    public static int m1791b(MarginLayoutParams marginLayoutParams) {
        return VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginEnd() : marginLayoutParams.rightMargin;
    }
}
