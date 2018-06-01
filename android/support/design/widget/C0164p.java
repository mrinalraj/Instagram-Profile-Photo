package android.support.design.widget;

import android.support.design.widget.C0172r.C0141a;
import android.support.design.widget.C0172r.C0142b;
import android.util.StateSet;
import java.util.ArrayList;

final class C0164p {
    C0172r f507a = null;
    private final ArrayList<C0163a> f508b = new ArrayList();
    private C0163a f509c = null;
    private final C0141a f510d = new C01621(this);

    class C01621 extends C0142b {
        final /* synthetic */ C0164p f504a;

        C01621(C0164p c0164p) {
            this.f504a = c0164p;
        }

        public void mo112b(C0172r c0172r) {
            if (this.f504a.f507a == c0172r) {
                this.f504a.f507a = null;
            }
        }
    }

    static class C0163a {
        final int[] f505a;
        final C0172r f506b;

        C0163a(int[] iArr, C0172r c0172r) {
            this.f505a = iArr;
            this.f506b = c0172r;
        }
    }

    C0164p() {
    }

    private void m777a(C0163a c0163a) {
        this.f507a = c0163a.f506b;
        this.f507a.m804a();
    }

    private void m778b() {
        if (this.f507a != null) {
            this.f507a.m813d();
            this.f507a = null;
        }
    }

    public void m779a() {
        if (this.f507a != null) {
            this.f507a.m815f();
            this.f507a = null;
        }
    }

    void m780a(int[] iArr) {
        C0163a c0163a;
        int size = this.f508b.size();
        for (int i = 0; i < size; i++) {
            c0163a = (C0163a) this.f508b.get(i);
            if (StateSet.stateSetMatches(c0163a.f505a, iArr)) {
                break;
            }
        }
        c0163a = null;
        if (c0163a != this.f509c) {
            if (this.f509c != null) {
                m778b();
            }
            this.f509c = c0163a;
            if (c0163a != null) {
                m777a(c0163a);
            }
        }
    }

    public void m781a(int[] iArr, C0172r c0172r) {
        C0163a c0163a = new C0163a(iArr, c0172r);
        c0172r.m808a(this.f510d);
        this.f508b.add(c0163a);
    }
}
