package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.p008h.C0067b;
import android.support.v4.p008h.p019a.C0369b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class ay extends C0067b {
    final RecyclerView f2526a;
    final C0067b f2527c = new C07851(this);

    class C07851 extends C0067b {
        final /* synthetic */ ay f2525a;

        C07851(ay ayVar) {
            this.f2525a = ayVar;
        }

        public void mo25a(View view, C0369b c0369b) {
            super.mo25a(view, c0369b);
            if (!this.f2525a.m4428b() && this.f2525a.f2526a.getLayoutManager() != null) {
                this.f2525a.f2526a.getLayoutManager().m3391a(view, c0369b);
            }
        }

        public boolean mo368a(View view, int i, Bundle bundle) {
            return super.mo368a(view, i, bundle) ? true : (this.f2525a.m4428b() || this.f2525a.f2526a.getLayoutManager() == null) ? false : this.f2525a.f2526a.getLayoutManager().m3405a(view, i, bundle);
        }
    }

    public ay(RecyclerView recyclerView) {
        this.f2526a = recyclerView;
    }

    public void mo25a(View view, C0369b c0369b) {
        super.mo25a(view, c0369b);
        c0369b.m1707a(RecyclerView.class.getName());
        if (!m4428b() && this.f2526a.getLayoutManager() != null) {
            this.f2526a.getLayoutManager().m3372a(c0369b);
        }
    }

    public void mo72a(View view, AccessibilityEvent accessibilityEvent) {
        super.mo72a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m4428b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo614a(accessibilityEvent);
            }
        }
    }

    public boolean mo368a(View view, int i, Bundle bundle) {
        return super.mo368a(view, i, bundle) ? true : (m4428b() || this.f2526a.getLayoutManager() == null) ? false : this.f2526a.getLayoutManager().m3396a(i, bundle);
    }

    boolean m4428b() {
        return this.f2526a.m300v();
    }

    public C0067b m4429c() {
        return this.f2527c;
    }
}
