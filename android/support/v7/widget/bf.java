package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0703e;
import android.support.v7.widget.RecyclerView.C0703e.C0702c;
import android.support.v7.widget.RecyclerView.C0724w;
import android.view.View;

public abstract class bf extends C0703e {
    boolean f2417h = true;

    public final void m4245a(C0724w c0724w, boolean z) {
        m4256d(c0724w, z);
        m3692f(c0724w);
    }

    public abstract boolean mo699a(C0724w c0724w);

    public abstract boolean mo700a(C0724w c0724w, int i, int i2, int i3, int i4);

    public boolean mo693a(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
        int i = c0702c.f2101a;
        int i2 = c0702c.f2102b;
        View view = c0724w.f2170a;
        int left = c0702c2 == null ? view.getLeft() : c0702c2.f2101a;
        int top = c0702c2 == null ? view.getTop() : c0702c2.f2102b;
        if (c0724w.m3847q() || (i == left && i2 == top)) {
            return mo699a(c0724w);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo700a(c0724w, i, i2, left, top);
    }

    public abstract boolean mo701a(C0724w c0724w, C0724w c0724w2, int i, int i2, int i3, int i4);

    public boolean mo694a(C0724w c0724w, C0724w c0724w2, C0702c c0702c, C0702c c0702c2) {
        int i;
        int i2;
        int i3 = c0702c.f2101a;
        int i4 = c0702c.f2102b;
        if (c0724w2.m3833c()) {
            i = c0702c.f2101a;
            i2 = c0702c.f2102b;
        } else {
            i = c0702c2.f2101a;
            i2 = c0702c2.f2102b;
        }
        return mo701a(c0724w, c0724w2, i3, i4, i, i2);
    }

    public final void m4251b(C0724w c0724w, boolean z) {
        m4254c(c0724w, z);
    }

    public abstract boolean mo704b(C0724w c0724w);

    public boolean mo695b(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
        if (c0702c == null || (c0702c.f2101a == c0702c2.f2101a && c0702c.f2102b == c0702c2.f2102b)) {
            return mo704b(c0724w);
        }
        return mo700a(c0724w, c0702c.f2101a, c0702c.f2102b, c0702c2.f2101a, c0702c2.f2102b);
    }

    public void m4254c(C0724w c0724w, boolean z) {
    }

    public boolean mo696c(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
        if (c0702c.f2101a == c0702c2.f2101a && c0702c.f2102b == c0702c2.f2102b) {
            m4259j(c0724w);
            return false;
        }
        return mo700a(c0724w, c0702c.f2101a, c0702c.f2102b, c0702c2.f2101a, c0702c2.f2102b);
    }

    public void m4256d(C0724w c0724w, boolean z) {
    }

    public boolean mo697h(C0724w c0724w) {
        return !this.f2417h || c0724w.m3844n();
    }

    public final void m4258i(C0724w c0724w) {
        m4265p(c0724w);
        m3692f(c0724w);
    }

    public final void m4259j(C0724w c0724w) {
        m4269t(c0724w);
        m3692f(c0724w);
    }

    public final void m4260k(C0724w c0724w) {
        m4267r(c0724w);
        m3692f(c0724w);
    }

    public final void m4261l(C0724w c0724w) {
        m4264o(c0724w);
    }

    public final void m4262m(C0724w c0724w) {
        m4268s(c0724w);
    }

    public final void m4263n(C0724w c0724w) {
        m4266q(c0724w);
    }

    public void m4264o(C0724w c0724w) {
    }

    public void m4265p(C0724w c0724w) {
    }

    public void m4266q(C0724w c0724w) {
    }

    public void m4267r(C0724w c0724w) {
    }

    public void m4268s(C0724w c0724w) {
    }

    public void m4269t(C0724w c0724w) {
    }
}
