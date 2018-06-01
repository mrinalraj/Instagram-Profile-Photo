package android.support.v7.widget;

import android.support.v4.p008h.C0425s;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class bp implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {
    private static bp f2654i;
    private final View f2655a;
    private final CharSequence f2656b;
    private final Runnable f2657c = new C07981(this);
    private final Runnable f2658d = new C07992(this);
    private int f2659e;
    private int f2660f;
    private bq f2661g;
    private boolean f2662h;

    class C07981 implements Runnable {
        final /* synthetic */ bp f2652a;

        C07981(bp bpVar) {
            this.f2652a = bpVar;
        }

        public void run() {
            this.f2652a.m4586a(false);
        }
    }

    class C07992 implements Runnable {
        final /* synthetic */ bp f2653a;

        C07992(bp bpVar) {
            this.f2653a = bpVar;
        }

        public void run() {
            this.f2653a.m4582a();
        }
    }

    private bp(View view, CharSequence charSequence) {
        this.f2655a = view;
        this.f2656b = charSequence;
        this.f2655a.setOnLongClickListener(this);
        this.f2655a.setOnHoverListener(this);
    }

    private void m4582a() {
        if (f2654i == this) {
            f2654i = null;
            if (this.f2661g != null) {
                this.f2661g.m4589a();
                this.f2661g = null;
                this.f2655a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        this.f2655a.removeCallbacks(this.f2657c);
        this.f2655a.removeCallbacks(this.f2658d);
    }

    public static void m4585a(View view, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (f2654i != null && f2654i.f2655a == view) {
                f2654i.m4582a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        bp bpVar = new bp(view, charSequence);
    }

    private void m4586a(boolean z) {
        if (C0425s.m1936A(this.f2655a)) {
            if (f2654i != null) {
                f2654i.m4582a();
            }
            f2654i = this;
            this.f2662h = z;
            this.f2661g = new bq(this.f2655a.getContext());
            this.f2661g.m4590a(this.f2655a, this.f2659e, this.f2660f, this.f2662h, this.f2656b);
            this.f2655a.addOnAttachStateChangeListener(this);
            long longPressTimeout = this.f2662h ? 2500 : (C0425s.m1978q(this.f2655a) & 1) == 1 ? 3000 - ((long) ViewConfiguration.getLongPressTimeout()) : 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            this.f2655a.removeCallbacks(this.f2658d);
            this.f2655a.postDelayed(this.f2658d, longPressTimeout);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2661g == null || !this.f2662h) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2655a.getContext().getSystemService("accessibility");
            if (!(accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled())) {
                switch (motionEvent.getAction()) {
                    case 7:
                        if (this.f2655a.isEnabled() && this.f2661g == null) {
                            this.f2659e = (int) motionEvent.getX();
                            this.f2660f = (int) motionEvent.getY();
                            this.f2655a.removeCallbacks(this.f2657c);
                            this.f2655a.postDelayed(this.f2657c, (long) ViewConfiguration.getLongPressTimeout());
                            break;
                        }
                    case 10:
                        m4582a();
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f2659e = view.getWidth() / 2;
        this.f2660f = view.getHeight() / 2;
        m4586a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        m4582a();
    }
}
