package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0681h;
import android.support.v7.widget.RecyclerView.C0721t;
import android.view.View;

class bd {
    static int m4466a(C0721t c0721t, ax axVar, View view, View view2, C0681h c0681h, boolean z) {
        if (c0681h.m3472u() == 0 || c0721t.m3796e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(c0681h.m3432d(view) - c0681h.m3432d(view2)) + 1;
        }
        return Math.min(axVar.mo729f(), axVar.mo722b(view2) - axVar.mo720a(view));
    }

    static int m4467a(C0721t c0721t, ax axVar, View view, View view2, C0681h c0681h, boolean z, boolean z2) {
        if (c0681h.m3472u() == 0 || c0721t.m3796e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (c0721t.m3796e() - Math.max(c0681h.m3432d(view), c0681h.m3432d(view2))) - 1) : Math.max(0, Math.min(c0681h.m3432d(view), c0681h.m3432d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(axVar.mo722b(view2) - axVar.mo720a(view))) / ((float) (Math.abs(c0681h.m3432d(view) - c0681h.m3432d(view2)) + 1)))) + ((float) (axVar.mo723c() - axVar.mo720a(view))));
    }

    static int m4468b(C0721t c0721t, ax axVar, View view, View view2, C0681h c0681h, boolean z) {
        if (c0681h.m3472u() == 0 || c0721t.m3796e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0721t.m3796e();
        }
        return (int) ((((float) (axVar.mo722b(view2) - axVar.mo720a(view))) / ((float) (Math.abs(c0681h.m3432d(view) - c0681h.m3432d(view2)) + 1))) * ((float) c0721t.m3796e()));
    }
}
