package com.txusballesteros.bubbles;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Vibrator;
import com.txusballesteros.bubbles.C1042f.C1041a;

class C1034b extends C1030a {
    private boolean f3384a = false;
    private boolean f3385b = false;

    public C1034b(Context context) {
        super(context);
    }

    private void m5331a(int i) {
        if (!isInEditMode()) {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), i);
            animatorSet.setTarget(getChildAt(0));
            animatorSet.start();
        }
    }

    void m5332a() {
        if (!this.f3384a) {
            this.f3384a = true;
            m5331a(C1041a.bubble_trash_shown_magnetism_animator);
        }
    }

    void m5333b() {
        ((Vibrator) getContext().getSystemService("vibrator")).vibrate(70);
    }

    void m5334c() {
        if (this.f3384a) {
            this.f3384a = false;
            m5331a(C1041a.bubble_trash_hide_magnetism_animator);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3385b = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3385b = false;
    }

    public void setVisibility(int i) {
        if (this.f3385b && i != getVisibility()) {
            if (i == 0) {
                m5331a(C1041a.bubble_trash_shown_animator);
            } else {
                m5331a(C1041a.bubble_trash_hide_animator);
            }
        }
        super.setVisibility(i);
    }
}
