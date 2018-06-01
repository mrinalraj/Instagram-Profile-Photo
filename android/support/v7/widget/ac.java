package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.bb.C0753a;

class ac extends ae {

    class C07541 implements C0753a {
        final /* synthetic */ ac f2374a;

        C07541(ac acVar) {
            this.f2374a = acVar;
        }

        public void mo678a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    ac() {
    }

    public void mo680a() {
        bb.f2541a = new C07541(this);
    }
}
