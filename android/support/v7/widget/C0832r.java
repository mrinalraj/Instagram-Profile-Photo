package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.C0505i;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

class C0832r extends PopupWindow {
    private static final boolean f2788a = (VERSION.SDK_INT < 21);
    private boolean f2789b;

    public C0832r(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m4763a(context, attributeSet, i, i2);
    }

    private void m4763a(Context context, AttributeSet attributeSet, int i, int i2) {
        bm a = bm.m4513a(context, attributeSet, C0528j.PopupWindow, i, i2);
        if (a.m4531g(C0528j.PopupWindow_overlapAnchor)) {
            m4765a(a.m4519a(C0528j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m4517a(C0528j.PopupWindow_android_popupBackground));
        int i3 = VERSION.SDK_INT;
        if (i2 != 0 && i3 < 11 && a.m4531g(C0528j.PopupWindow_android_popupAnimationStyle)) {
            setAnimationStyle(a.m4530g(C0528j.PopupWindow_android_popupAnimationStyle, -1));
        }
        a.m4518a();
        if (VERSION.SDK_INT < 14) {
            C0832r.m4764a((PopupWindow) this);
        }
    }

    private static void m4764a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m4765a(boolean z) {
        if (f2788a) {
            this.f2789b = z;
        } else {
            C0505i.m2431a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2788a && this.f2789b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2788a && this.f2789b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height = (f2788a && this.f2789b) ? i2 - view.getHeight() : i2;
        super.update(view, i, height, i3, i4);
    }
}
