package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.p021a.C0529a.C0522d;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.p021a.C0529a.C0527i;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class bq {
    private final Context f2663a;
    private final View f2664b;
    private final TextView f2665c;
    private final LayoutParams f2666d = new LayoutParams();
    private final Rect f2667e = new Rect();
    private final int[] f2668f = new int[2];
    private final int[] f2669g = new int[2];

    bq(Context context) {
        this.f2663a = context;
        this.f2664b = LayoutInflater.from(this.f2663a).inflate(C0525g.tooltip, null);
        this.f2665c = (TextView) this.f2664b.findViewById(C0524f.message);
        this.f2666d.setTitle(getClass().getSimpleName());
        this.f2666d.packageName = this.f2663a.getPackageName();
        this.f2666d.type = 1002;
        this.f2666d.width = -2;
        this.f2666d.height = -2;
        this.f2666d.format = -3;
        this.f2666d.windowAnimations = C0527i.Animation_AppCompat_Tooltip;
        this.f2666d.flags = 24;
    }

    private static View m4587a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return view.getRootView();
    }

    private void m4588a(View view, int i, int i2, boolean z, LayoutParams layoutParams) {
        int i3;
        int dimensionPixelOffset = this.f2663a.getResources().getDimensionPixelOffset(C0522d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            dimensionPixelOffset = this.f2663a.getResources().getDimensionPixelOffset(C0522d.tooltip_precise_anchor_extra_offset);
            i3 = i2 + dimensionPixelOffset;
            dimensionPixelOffset = i2 - dimensionPixelOffset;
        } else {
            i3 = view.getHeight();
            dimensionPixelOffset = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset2 = this.f2663a.getResources().getDimensionPixelOffset(z ? C0522d.tooltip_y_offset_touch : C0522d.tooltip_y_offset_non_touch);
        View a = m4587a(view);
        if (a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a.getWindowVisibleDisplayFrame(this.f2667e);
        if (this.f2667e.left < 0 && this.f2667e.top < 0) {
            Resources resources = this.f2663a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            identifier = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f2667e.set(0, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a.getLocationOnScreen(this.f2669g);
        view.getLocationOnScreen(this.f2668f);
        int[] iArr = this.f2668f;
        iArr[0] = iArr[0] - this.f2669g[0];
        iArr = this.f2668f;
        iArr[1] = iArr[1] - this.f2669g[1];
        layoutParams.x = (this.f2668f[0] + i) - (this.f2667e.width() / 2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.f2664b.measure(makeMeasureSpec, makeMeasureSpec);
        makeMeasureSpec = this.f2664b.getMeasuredHeight();
        dimensionPixelOffset = ((dimensionPixelOffset + this.f2668f[1]) - dimensionPixelOffset2) - makeMeasureSpec;
        i3 = (i3 + this.f2668f[1]) + dimensionPixelOffset2;
        if (z) {
            if (dimensionPixelOffset >= 0) {
                layoutParams.y = dimensionPixelOffset;
            } else {
                layoutParams.y = i3;
            }
        } else if (makeMeasureSpec + i3 <= this.f2667e.height()) {
            layoutParams.y = i3;
        } else {
            layoutParams.y = dimensionPixelOffset;
        }
    }

    void m4589a() {
        if (m4591b()) {
            ((WindowManager) this.f2663a.getSystemService("window")).removeView(this.f2664b);
        }
    }

    void m4590a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m4591b()) {
            m4589a();
        }
        this.f2665c.setText(charSequence);
        m4588a(view, i, i2, z, this.f2666d);
        ((WindowManager) this.f2663a.getSystemService("window")).addView(this.f2664b, this.f2666d);
    }

    boolean m4591b() {
        return this.f2664b.getParent() != null;
    }
}
