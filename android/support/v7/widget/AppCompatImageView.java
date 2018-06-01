package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v4.p008h.C0094q;
import android.support.v4.widget.C0095n;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements C0094q, C0095n {
    private final C0818h f2007a;
    private final C0829p f2008b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(bj.m4508a(context), attributeSet, i);
        this.f2007a = new C0818h(this);
        this.f2007a.m4705a(attributeSet, i);
        this.f2008b = new C0829p(this);
        this.f2008b.m4758a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2007a != null) {
            this.f2007a.m4708c();
        }
        if (this.f2008b != null) {
            this.f2008b.m4762d();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2007a != null ? this.f2007a.m4700a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2007a != null ? this.f2007a.m4706b() : null;
    }

    public ColorStateList getSupportImageTintList() {
        return this.f2008b != null ? this.f2008b.m4760b() : null;
    }

    public Mode getSupportImageTintMode() {
        return this.f2008b != null ? this.f2008b.m4761c() : null;
    }

    public boolean hasOverlappingRendering() {
        return this.f2008b.m4759a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2007a != null) {
            this.f2007a.m4704a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2007a != null) {
            this.f2007a.m4701a(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f2008b != null) {
            this.f2008b.m4762d();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f2008b != null) {
            this.f2008b.m4762d();
        }
    }

    public void setImageIcon(Icon icon) {
        super.setImageIcon(icon);
        if (this.f2008b != null) {
            this.f2008b.m4762d();
        }
    }

    public void setImageResource(int i) {
        if (this.f2008b != null) {
            this.f2008b.m4755a(i);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f2008b != null) {
            this.f2008b.m4762d();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2007a != null) {
            this.f2007a.m4702a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2007a != null) {
            this.f2007a.m4703a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f2008b != null) {
            this.f2008b.m4756a(colorStateList);
        }
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.f2008b != null) {
            this.f2008b.m4757a(mode);
        }
    }
}
