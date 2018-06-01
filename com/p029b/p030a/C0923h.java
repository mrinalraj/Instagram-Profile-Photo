package com.p029b.p030a;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class C0923h implements OnPreDrawListener {
    final C0958x f3029a;
    final WeakReference<ImageView> f3030b;
    C0919e f3031c;

    C0923h(C0958x c0958x, ImageView imageView, C0919e c0919e) {
        this.f3029a = c0958x;
        this.f3030b = new WeakReference(imageView);
        this.f3031c = c0919e;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    void m5076a() {
        this.f3031c = null;
        ImageView imageView = (ImageView) this.f3030b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f3030b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    this.f3029a.m5175a().m5176a(width, height).m5178a(imageView, this.f3031c);
                }
            }
        }
        return true;
    }
}
