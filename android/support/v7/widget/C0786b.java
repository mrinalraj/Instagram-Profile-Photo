package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class C0786b extends Drawable {
    final ActionBarContainer f2529a;

    public C0786b(ActionBarContainer actionBarContainer) {
        this.f2529a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2529a.f1902d) {
            if (this.f2529a.f1899a != null) {
                this.f2529a.f1899a.draw(canvas);
            }
            if (this.f2529a.f1900b != null && this.f2529a.f1903e) {
                this.f2529a.f1900b.draw(canvas);
            }
        } else if (this.f2529a.f1901c != null) {
            this.f2529a.f1901c.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
