package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class ad implements ag {
    ad() {
    }

    private ba m4155j(af afVar) {
        return (ba) afVar.mo601c();
    }

    public float mo679a(af afVar) {
        return m4155j(afVar).m4433a();
    }

    public void mo680a() {
    }

    public void mo681a(af afVar, float f) {
        m4155j(afVar).m4434a(f);
    }

    public void mo682a(af afVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        afVar.mo598a(new ba(colorStateList, f));
        View d = afVar.mo602d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        mo685b(afVar, f3);
    }

    public void mo683a(af afVar, ColorStateList colorStateList) {
        m4155j(afVar).m4436a(colorStateList);
    }

    public float mo684b(af afVar) {
        return mo688d(afVar) * 2.0f;
    }

    public void mo685b(af afVar, float f) {
        m4155j(afVar).m4435a(f, afVar.mo599a(), afVar.mo600b());
        m4167f(afVar);
    }

    public float mo686c(af afVar) {
        return mo688d(afVar) * 2.0f;
    }

    public void mo687c(af afVar, float f) {
        afVar.mo602d().setElevation(f);
    }

    public float mo688d(af afVar) {
        return m4155j(afVar).m4437b();
    }

    public float mo689e(af afVar) {
        return afVar.mo602d().getElevation();
    }

    public void m4167f(af afVar) {
        if (afVar.mo599a()) {
            float a = mo679a(afVar);
            float d = mo688d(afVar);
            int ceil = (int) Math.ceil((double) bb.m4442b(a, d, afVar.mo600b()));
            int ceil2 = (int) Math.ceil((double) bb.m4439a(a, d, afVar.mo600b()));
            afVar.mo597a(ceil, ceil2, ceil, ceil2);
            return;
        }
        afVar.mo597a(0, 0, 0, 0);
    }

    public void mo690g(af afVar) {
        mo685b(afVar, mo679a(afVar));
    }

    public void mo691h(af afVar) {
        mo685b(afVar, mo679a(afVar));
    }

    public ColorStateList mo692i(af afVar) {
        return m4155j(afVar).m4438c();
    }
}
