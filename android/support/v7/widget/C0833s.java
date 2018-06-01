package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.p005c.p006a.C0280b;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class C0833s {
    private static final int[] f2790a = new int[]{16843067, 16843068};
    private final ProgressBar f2791b;
    private Bitmap f2792c;

    C0833s(ProgressBar progressBar) {
        this.f2791b = progressBar;
    }

    private Drawable mo786a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m4767a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private Drawable m4767a(Drawable drawable, boolean z) {
        int i = 0;
        Drawable a;
        if (drawable instanceof C0280b) {
            a = ((C0280b) drawable).mo202a();
            if (a != null) {
                ((C0280b) drawable).mo203a(m4767a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                boolean z2 = id == 16908301 || id == 16908303;
                drawableArr[i2] = m4767a(drawable2, z2);
            }
            a = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                a.setId(i, layerDrawable.getId(i));
                i++;
            }
            return a;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f2792c == null) {
                this.f2792c = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(mo788b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Shape mo788b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap m4769a() {
        return this.f2792c;
    }

    void mo787a(AttributeSet attributeSet, int i) {
        bm a = bm.m4513a(this.f2791b.getContext(), attributeSet, f2790a, i, 0);
        Drawable b = a.m4521b(0);
        if (b != null) {
            this.f2791b.setIndeterminateDrawable(mo786a(b));
        }
        b = a.m4521b(1);
        if (b != null) {
            this.f2791b.setProgressDrawable(m4767a(b, false));
        }
        a.m4518a();
    }
}
