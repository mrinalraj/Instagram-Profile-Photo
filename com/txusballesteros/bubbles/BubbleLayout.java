package com.txusballesteros.bubbles;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.txusballesteros.bubbles.C1042f.C1041a;

public class BubbleLayout extends C1030a {
    private float f3363a;
    private float f3364b;
    private int f3365c;
    private int f3366d;
    private C1029c f3367e;
    private C1022b f3368f;
    private long f3369g;
    private C1028a f3370h = new C1028a();
    private int f3371i;
    private WindowManager f3372j;
    private boolean f3373k = true;

    public interface C1022b {
        void mo847a(BubbleLayout bubbleLayout);
    }

    private class C1028a implements Runnable {
        final /* synthetic */ BubbleLayout f3355a;
        private Handler f3356b;
        private float f3357c;
        private float f3358d;
        private long f3359e;

        private C1028a(BubbleLayout bubbleLayout) {
            this.f3355a = bubbleLayout;
            this.f3356b = new Handler(Looper.getMainLooper());
        }

        private void m5305a() {
            this.f3356b.removeCallbacks(this);
        }

        private void m5306a(float f, float f2) {
            this.f3357c = f;
            this.f3358d = f2;
            this.f3359e = System.currentTimeMillis();
            this.f3356b.post(this);
        }

        public void run() {
            if (this.f3355a.getRootView() != null && this.f3355a.getRootView().getParent() != null) {
                float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f3359e)) / 400.0f);
                this.f3355a.m5310a((this.f3357c - ((float) this.f3355a.getViewParams().x)) * min, (this.f3358d - ((float) this.f3355a.getViewParams().y)) * min);
                if (min < 1.0f) {
                    this.f3356b.post(this);
                }
            }
        }
    }

    public interface C1029c {
        void m5309a(BubbleLayout bubbleLayout);
    }

    public BubbleLayout(Context context) {
        super(context);
        this.f3372j = (WindowManager) context.getSystemService("window");
        m5312c();
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3372j = (WindowManager) context.getSystemService("window");
        m5312c();
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3372j = (WindowManager) context.getSystemService("window");
        m5312c();
    }

    private void m5310a(float f, float f2) {
        LayoutParams viewParams = getViewParams();
        viewParams.x = (int) (((float) viewParams.x) + f);
        viewParams = getViewParams();
        viewParams.y = (int) (((float) viewParams.y) + f2);
        this.f3372j.updateViewLayout(this, getViewParams());
    }

    private void m5312c() {
        setClickable(true);
    }

    private void m5313d() {
        if (!isInEditMode()) {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), C1041a.bubble_shown_animator);
            animatorSet.setTarget(this);
            animatorSet.start();
        }
    }

    private void m5314e() {
        if (!isInEditMode()) {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), C1041a.bubble_down_click_animator);
            animatorSet.setTarget(this);
            animatorSet.start();
        }
    }

    private void m5315f() {
        if (!isInEditMode()) {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), C1041a.bubble_up_click_animator);
            animatorSet.setTarget(this);
            animatorSet.start();
        }
    }

    private void m5316g() {
        this.f3372j.getDefaultDisplay().getMetrics(new DisplayMetrics());
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f3371i = point.x - getWidth();
    }

    void m5317a() {
        if (this.f3367e != null) {
            this.f3367e.m5309a(this);
        }
    }

    public void m5318b() {
        if (this.f3373k) {
            this.f3370h.m5306a(getViewParams().x >= this.f3371i / 2 ? (float) this.f3371i : 0.0f, (float) getViewParams().y);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m5313d();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f3365c = getViewParams().x;
                    this.f3366d = getViewParams().y;
                    this.f3363a = motionEvent.getRawX();
                    this.f3364b = motionEvent.getRawY();
                    m5314e();
                    this.f3369g = System.currentTimeMillis();
                    m5316g();
                    this.f3370h.m5305a();
                    break;
                case 1:
                    m5318b();
                    if (getLayoutCoordinator() != null) {
                        getLayoutCoordinator().m5346a(this);
                        m5315f();
                    }
                    if (System.currentTimeMillis() - this.f3369g < 150 && this.f3368f != null) {
                        this.f3368f.mo847a(this);
                        break;
                    }
                case 2:
                    int rawX = this.f3365c + ((int) (motionEvent.getRawX() - this.f3363a));
                    int rawY = this.f3366d + ((int) (motionEvent.getRawY() - this.f3364b));
                    getViewParams().x = rawX;
                    getViewParams().y = rawY;
                    getWindowManager().updateViewLayout(this, getViewParams());
                    if (getLayoutCoordinator() != null) {
                        getLayoutCoordinator().m5347a(this, rawX, rawY);
                        break;
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnBubbleClickListener(C1022b c1022b) {
        this.f3368f = c1022b;
    }

    public void setOnBubbleRemoveListener(C1029c c1029c) {
        this.f3367e = c1029c;
    }

    public void setShouldStickToWall(boolean z) {
        this.f3373k = z;
    }
}
