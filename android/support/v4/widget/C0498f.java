package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class C0498f {
    static final C0495b f1244a;

    interface C0495b {
        ColorStateList mo377a(ImageView imageView);

        void mo378a(ImageView imageView, ColorStateList colorStateList);

        void mo379a(ImageView imageView, Mode mode);

        Mode mo380b(ImageView imageView);
    }

    static class C0496a implements C0495b {
        C0496a() {
        }

        public ColorStateList mo377a(ImageView imageView) {
            return imageView instanceof C0095n ? ((C0095n) imageView).getSupportImageTintList() : null;
        }

        public void mo378a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof C0095n) {
                ((C0095n) imageView).setSupportImageTintList(colorStateList);
            }
        }

        public void mo379a(ImageView imageView, Mode mode) {
            if (imageView instanceof C0095n) {
                ((C0095n) imageView).setSupportImageTintMode(mode);
            }
        }

        public Mode mo380b(ImageView imageView) {
            return imageView instanceof C0095n ? ((C0095n) imageView).getSupportImageTintMode() : null;
        }
    }

    static class C0497c extends C0496a {
        C0497c() {
        }

        public ColorStateList mo377a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public void mo378a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (drawable != null && obj != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        public void mo379a(ImageView imageView, Mode mode) {
            imageView.setImageTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (drawable != null && obj != null) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        public Mode mo380b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1244a = new C0497c();
        } else {
            f1244a = new C0496a();
        }
    }

    public static ColorStateList m2414a(ImageView imageView) {
        return f1244a.mo377a(imageView);
    }

    public static void m2415a(ImageView imageView, ColorStateList colorStateList) {
        f1244a.mo378a(imageView, colorStateList);
    }

    public static void m2416a(ImageView imageView, Mode mode) {
        f1244a.mo379a(imageView, mode);
    }

    public static Mode m2417b(ImageView imageView) {
        return f1244a.mo380b(imageView);
    }
}
