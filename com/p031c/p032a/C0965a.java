package com.p031c.p032a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p013b.C0190a;
import android.support.v7.p023c.p024a.C0608b;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.p031c.p033b.C0976a.C0971a;
import com.p031c.p033b.C0976a.C0972b;
import com.p031c.p033b.C0976a.C0973c;
import com.p031c.p033b.C0976a.C0974d;
import com.p031c.p033b.C0976a.C0975e;

public class C0965a extends FrameLayout implements OnClickListener, AnimationListener {
    private FrameLayout f3197a;
    private FrameLayout f3198b;
    private TextView f3199c;
    private TextView f3200d;
    private ImageView f3201e;
    private ViewGroup f3202f;
    private ProgressBar f3203g;
    private Animation f3204h;
    private Animation f3205i;
    private C0970d f3206j;
    private C0969c f3207k;
    private long f3208l = 3000;
    private boolean f3209m = true;
    private boolean f3210n;
    private boolean f3211o;
    private Runnable f3212p;
    private boolean f3213q;
    private boolean f3214r = true;

    class C09611 implements Runnable {
        final /* synthetic */ C0965a f3193a;

        C09611(C0965a c0965a) {
            this.f3193a = c0965a;
        }

        public void run() {
            this.f3193a.m5194a();
        }
    }

    class C09622 implements AnimatorUpdateListener {
        final /* synthetic */ C0965a f3194a;

        C09622(C0965a c0965a) {
            this.f3194a = c0965a;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3194a.f3203g.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    class C09633 implements AnimationListener {
        final /* synthetic */ C0965a f3195a;

        C09633(C0965a c0965a) {
            this.f3195a = c0965a;
        }

        public void onAnimationEnd(Animation animation) {
            this.f3195a.m5193d();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f3195a.f3198b.setOnClickListener(null);
            this.f3195a.f3198b.setClickable(false);
        }
    }

    class C09644 implements Runnable {
        final /* synthetic */ C0965a f3196a;

        C09644(C0965a c0965a) {
            this.f3196a = c0965a;
        }

        public void run() {
            try {
                if (this.f3196a.getParent() == null) {
                    Log.e(getClass().getSimpleName(), "getParent() returning Null");
                    return;
                }
                try {
                    ((ViewGroup) this.f3196a.getParent()).removeView(this.f3196a);
                    if (this.f3196a.f3207k != null) {
                        this.f3196a.f3207k.m5210a();
                    }
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "Cannot remove from parent layout");
                }
            } catch (Throwable e2) {
                Log.e(getClass().getSimpleName(), Log.getStackTraceString(e2));
            }
        }
    }

    public C0965a(Context context) {
        super(context, null, C0972b.alertStyle);
        m5189b();
    }

    private void m5189b() {
        C0965a.inflate(getContext(), C0975e.alerter_alert_view, this);
        setHapticFeedbackEnabled(true);
        this.f3198b = (FrameLayout) findViewById(C0974d.flAlertBackground);
        this.f3197a = (FrameLayout) findViewById(C0974d.flClickShield);
        this.f3201e = (ImageView) findViewById(C0974d.ivIcon);
        this.f3199c = (TextView) findViewById(C0974d.tvTitle);
        this.f3200d = (TextView) findViewById(C0974d.tvText);
        this.f3202f = (ViewGroup) findViewById(C0974d.rlContainer);
        this.f3203g = (ProgressBar) findViewById(C0974d.pbProgress);
        this.f3198b.setOnClickListener(this);
        this.f3204h = AnimationUtils.loadAnimation(getContext(), C0971a.alerter_slide_in_from_top);
        this.f3205i = AnimationUtils.loadAnimation(getContext(), C0971a.alerter_slide_out_to_top);
        this.f3204h.setAnimationListener(this);
        setAnimation(this.f3204h);
    }

    @TargetApi(11)
    private void m5190c() {
        if (!this.f3210n) {
            this.f3212p = new C09611(this);
            postDelayed(this.f3212p, this.f3208l);
        }
        if (this.f3211o && VERSION.SDK_INT >= 11) {
            this.f3203g.setVisibility(0);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
            ofInt.setDuration(this.f3208l);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.addUpdateListener(new C09622(this));
            ofInt.start();
        }
    }

    private void m5193d() {
        postDelayed(new C09644(this), 100);
    }

    public void m5194a() {
        try {
            this.f3205i.setAnimationListener(new C09633(this));
            startAnimation(this.f3205i);
        } catch (Throwable e) {
            Log.e(getClass().getSimpleName(), Log.getStackTraceString(e));
        }
    }

    public FrameLayout getAlertBackground() {
        return this.f3198b;
    }

    public int getContentGravity() {
        return ((LayoutParams) this.f3202f.getLayoutParams()).gravity;
    }

    public long getDuration() {
        return this.f3208l;
    }

    public ImageView getIcon() {
        return this.f3201e;
    }

    public TextView getText() {
        return this.f3200d;
    }

    public TextView getTitle() {
        return this.f3199c;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f3209m && this.f3201e.getVisibility() == 0) {
            try {
                this.f3201e.startAnimation(AnimationUtils.loadAnimation(getContext(), C0971a.alerter_pulse));
            } catch (Throwable e) {
                Log.e(getClass().getSimpleName(), Log.getStackTraceString(e));
            }
        }
        if (this.f3206j != null) {
            this.f3206j.m5211a();
        }
        m5190c();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        if (!isInEditMode()) {
            if (this.f3214r) {
                performHapticFeedback(1);
            }
            setVisibility(0);
        }
    }

    public void onClick(View view) {
        m5194a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3204h.setAnimationListener(null);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.f3213q) {
            this.f3213q = true;
            ((MarginLayoutParams) getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(C0973c.alerter_alert_negative_margin_top);
            requestLayout();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        performClick();
        return super.onTouchEvent(motionEvent);
    }

    public void setAlertBackgroundColor(int i) {
        this.f3198b.setBackgroundColor(i);
    }

    public void setAlertBackgroundDrawable(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            this.f3198b.setBackground(drawable);
        } else {
            this.f3198b.setBackgroundDrawable(drawable);
        }
    }

    public void setAlertBackgroundResource(int i) {
        this.f3198b.setBackgroundResource(i);
    }

    public void setContentGravity(int i) {
        ((LayoutParams) this.f3202f.getLayoutParams()).gravity = i;
        this.f3202f.requestLayout();
    }

    public void setDuration(long j) {
        this.f3208l = j;
    }

    public void setEnableInfiniteDuration(boolean z) {
        this.f3210n = z;
    }

    public void setEnableProgress(boolean z) {
        this.f3211o = z;
    }

    public void setIcon(int i) {
        this.f3201e.setImageDrawable(C0608b.m2863b(getContext(), i));
    }

    public void setIcon(Bitmap bitmap) {
        this.f3201e.setImageBitmap(bitmap);
    }

    public void setIcon(Drawable drawable) {
        this.f3201e.setImageDrawable(drawable);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f3198b.setOnClickListener(onClickListener);
    }

    public void setOnHideListener(C0969c c0969c) {
        this.f3207k = c0969c;
    }

    public void setOnShowListener(C0970d c0970d) {
        this.f3206j = c0970d;
    }

    public void setProgressColorInt(int i) {
        this.f3203g.getProgressDrawable().setColorFilter(new LightingColorFilter(-16777216, i));
    }

    public void setProgressColorRes(int i) {
        this.f3203g.getProgressDrawable().setColorFilter(new LightingColorFilter(-16777216, C0190a.m868c(getContext(), i)));
    }

    public void setText(int i) {
        setText(getContext().getString(i));
    }

    public void setText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3200d.setVisibility(0);
            this.f3200d.setText(str);
        }
    }

    public void setTextAppearance(int i) {
        if (VERSION.SDK_INT >= 23) {
            this.f3200d.setTextAppearance(i);
        } else {
            this.f3200d.setTextAppearance(this.f3200d.getContext(), i);
        }
    }

    public void setTextTypeface(Typeface typeface) {
        this.f3200d.setTypeface(typeface);
    }

    public void setTitle(int i) {
        setTitle(getContext().getString(i));
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3199c.setVisibility(0);
            this.f3199c.setText(str);
        }
    }

    public void setTitleAppearance(int i) {
        if (VERSION.SDK_INT >= 23) {
            this.f3199c.setTextAppearance(i);
        } else {
            this.f3199c.setTextAppearance(this.f3199c.getContext(), i);
        }
    }

    public void setTitleTypeface(Typeface typeface) {
        this.f3199c.setTypeface(typeface);
    }

    public void setVibrationEnabled(boolean z) {
        this.f3214r = z;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setVisibility(i);
        }
    }
}
