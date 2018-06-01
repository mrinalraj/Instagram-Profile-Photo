package com.p029b.p030a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.p029b.p030a.C0951t.C0947d;

final class C0952u extends BitmapDrawable {
    private static final Paint f3132e = new Paint();
    Drawable f3133a;
    long f3134b;
    boolean f3135c;
    int f3136d = 255;
    private final boolean f3137f;
    private final float f3138g;
    private final C0947d f3139h;

    C0952u(Context context, Bitmap bitmap, Drawable drawable, C0947d c0947d, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f3137f = z2;
        this.f3138g = context.getResources().getDisplayMetrics().density;
        this.f3139h = c0947d;
        boolean z3 = (c0947d == C0947d.MEMORY || z) ? false : true;
        if (z3) {
            this.f3133a = drawable;
            this.f3135c = true;
            this.f3134b = SystemClock.uptimeMillis();
        }
    }

    private static Path m5155a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }

    private void m5156a(Canvas canvas) {
        f3132e.setColor(-1);
        canvas.drawPath(C0952u.m5155a(new Point(0, 0), (int) (16.0f * this.f3138g)), f3132e);
        f3132e.setColor(this.f3139h.f3109d);
        canvas.drawPath(C0952u.m5155a(new Point(0, 0), (int) (15.0f * this.f3138g)), f3132e);
    }

    static void m5157a(ImageView imageView, Context context, Bitmap bitmap, C0947d c0947d, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new C0952u(context, bitmap, drawable, c0947d, z, z2));
    }

    static void m5158a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f3135c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f3134b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f3135c = false;
                this.f3133a = null;
                super.draw(canvas);
            } else {
                if (this.f3133a != null) {
                    this.f3133a.draw(canvas);
                }
                super.setAlpha((int) (uptimeMillis * ((float) this.f3136d)));
                super.draw(canvas);
                super.setAlpha(this.f3136d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f3137f) {
            m5156a(canvas);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f3133a != null) {
            this.f3133a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i) {
        this.f3136d = i;
        if (this.f3133a != null) {
            this.f3133a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f3133a != null) {
            this.f3133a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
