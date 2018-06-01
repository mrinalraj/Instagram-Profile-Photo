package com.singh.daman.proprogressviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.singh.daman.proprogressviews.C1026a.C1025a;

public class DotsZoomProgress extends View {
    Paint f3333a = new Paint();
    Paint f3334b = new Paint();
    Paint f3335c = new Paint();
    float f3336d;
    float f3337e;
    float f3338f;
    float f3339g;
    float f3340h;
    boolean f3341i = false;
    boolean f3342j = false;
    boolean f3343k = false;
    Runnable f3344l = new C10241(this);
    private float f3345m;
    private float f3346n;
    private int f3347o;
    private int f3348p;
    private float f3349q;
    private int f3350r;
    private int f3351s;
    private int f3352t;
    private float f3353u;
    private float f3354v;

    class C10241 implements Runnable {
        final /* synthetic */ DotsZoomProgress f3332a;

        C10241(DotsZoomProgress dotsZoomProgress) {
            this.f3332a = dotsZoomProgress;
        }

        public void run() {
            if (this.f3332a.f3341i) {
                DotsZoomProgress dotsZoomProgress = this.f3332a;
                dotsZoomProgress.f3336d -= this.f3332a.f3354v;
            }
            if (!this.f3332a.f3341i) {
                dotsZoomProgress = this.f3332a;
                dotsZoomProgress.f3336d += this.f3332a.f3354v;
            }
            if (this.f3332a.f3336d >= this.f3332a.f3346n) {
                this.f3332a.f3341i = true;
            }
            if (this.f3332a.f3336d <= this.f3332a.f3353u + this.f3332a.f3339g) {
                this.f3332a.f3341i = false;
            }
            if (this.f3332a.f3343k) {
                dotsZoomProgress = this.f3332a;
                dotsZoomProgress.f3338f -= this.f3332a.f3354v;
            }
            if (!this.f3332a.f3343k) {
                dotsZoomProgress = this.f3332a;
                dotsZoomProgress.f3338f += this.f3332a.f3354v;
            }
            if (this.f3332a.f3338f >= this.f3332a.f3349q) {
                this.f3332a.f3343k = true;
            }
            if (this.f3332a.f3338f <= this.f3332a.f3353u + this.f3332a.f3340h) {
                this.f3332a.f3343k = false;
            }
            if (this.f3332a.f3342j) {
                dotsZoomProgress = this.f3332a;
                dotsZoomProgress.f3337e -= this.f3332a.f3354v;
            }
            if (!this.f3332a.f3342j) {
                dotsZoomProgress = this.f3332a;
                dotsZoomProgress.f3337e += this.f3332a.f3354v;
            }
            if (this.f3332a.f3337e >= this.f3332a.f3345m) {
                this.f3332a.f3342j = true;
            }
            if (this.f3332a.f3337e <= this.f3332a.f3353u) {
                this.f3332a.f3342j = false;
            }
            this.f3332a.invalidate();
            this.f3332a.postDelayed(this, 30);
        }
    }

    public DotsZoomProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3333a.setStyle(Style.FILL);
        this.f3333a.setFlags(1);
        this.f3334b.setStyle(Style.FILL);
        this.f3334b.setFlags(1);
        this.f3335c.setStyle(Style.FILL);
        this.f3335c.setFlags(1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1025a.DotsZoomProgress, 0, 0);
        try {
            this.f3345m = obtainStyledAttributes.getDimension(C1025a.DotsZoomProgress_inner_radius, 50.0f);
            this.f3347o = obtainStyledAttributes.getColor(C1025a.DotsZoomProgress_inner_color, Color.parseColor("#5C6BC0"));
            this.f3346n = obtainStyledAttributes.getDimension(C1025a.DotsZoomProgress_outer_radius, 90.0f);
            this.f3348p = obtainStyledAttributes.getColor(C1025a.DotsZoomProgress_outer_color, Color.parseColor("#1A237E"));
            this.f3349q = obtainStyledAttributes.getDimension(C1025a.DotsZoomProgress_mid_radius, 70.0f);
            this.f3350r = obtainStyledAttributes.getColor(C1025a.DotsZoomProgress_mid_color, Color.parseColor("#1A237E"));
            this.f3353u = obtainStyledAttributes.getDimension(C1025a.DotsZoomProgress_min_radius, 10.0f);
            this.f3354v = obtainStyledAttributes.getFloat(C1025a.DotsZoomProgress_zoom_speed, 10.0f);
            this.f3352t = obtainStyledAttributes.getInteger(C1025a.DotsZoomProgress_mid_alpha, 50);
            this.f3351s = obtainStyledAttributes.getInt(C1025a.DotsZoomProgress_outer_alpha, 100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obtainStyledAttributes.recycle();
        }
        this.f3333a.setColor(this.f3348p);
        this.f3334b.setColor(this.f3347o);
        this.f3335c.setColor(this.f3350r);
        this.f3333a.setAlpha(this.f3351s);
        this.f3335c.setAlpha(this.f3352t);
        this.f3339g = this.f3346n - this.f3345m;
        this.f3340h = this.f3349q - this.f3345m;
        this.f3354v /= 10.0f;
        post(this.f3344l);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.f3336d, this.f3333a);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.f3338f, this.f3335c);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.f3337e, this.f3334b);
    }
}
