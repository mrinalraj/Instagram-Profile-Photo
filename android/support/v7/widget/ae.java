package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.bb.C0753a;

class ae implements ag {
    private final RectF f2375a = new RectF();

    class C07551 implements C0753a {
        final /* synthetic */ ae f2376a;

        C07551(ae aeVar) {
            this.f2376a = aeVar;
        }

        public void mo678a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                this.f2376a.f2375a.set(-f3, -f3, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(this.f2376a.f2375a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2376a.f2375a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2376a.f2375a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2376a.f2375a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, 1.0f + (rectF.right - f3), rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    ae() {
    }

    private bb m4137a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new bb(context.getResources(), colorStateList, f, f2, f3);
    }

    private bb m4138j(af afVar) {
        return (bb) afVar.mo601c();
    }

    public float mo679a(af afVar) {
        return m4138j(afVar).m4454c();
    }

    public void mo680a() {
        bb.f2541a = new C07551(this);
    }

    public void mo681a(af afVar, float f) {
        m4138j(afVar).m4448a(f);
        m4150f(afVar);
    }

    public void mo682a(af afVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        Drawable a = m4137a(context, colorStateList, f, f2, f3);
        a.m4451a(afVar.mo600b());
        afVar.mo598a(a);
        m4150f(afVar);
    }

    public void mo683a(af afVar, ColorStateList colorStateList) {
        m4138j(afVar).m4449a(colorStateList);
    }

    public float mo684b(af afVar) {
        return m4138j(afVar).m4456d();
    }

    public void mo685b(af afVar, float f) {
        m4138j(afVar).m4455c(f);
        m4150f(afVar);
    }

    public float mo686c(af afVar) {
        return m4138j(afVar).m4457e();
    }

    public void mo687c(af afVar, float f) {
        m4138j(afVar).m4453b(f);
    }

    public float mo688d(af afVar) {
        return m4138j(afVar).m4447a();
    }

    public float mo689e(af afVar) {
        return m4138j(afVar).m4452b();
    }

    public void m4150f(af afVar) {
        Rect rect = new Rect();
        m4138j(afVar).m4450a(rect);
        afVar.mo596a((int) Math.ceil((double) mo684b(afVar)), (int) Math.ceil((double) mo686c(afVar)));
        afVar.mo597a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void mo690g(af afVar) {
    }

    public void mo691h(af afVar) {
        m4138j(afVar).m4451a(afVar.mo600b());
        m4150f(afVar);
    }

    public ColorStateList mo692i(af afVar) {
        return m4138j(afVar).m4458f();
    }
}
