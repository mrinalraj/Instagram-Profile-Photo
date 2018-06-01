package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p008h.C0397c.C0396b;
import android.support.v4.p015d.p016a.C0303b;
import android.support.v7.view.menu.C0651k.C0647a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

class C0653l extends C0651k {

    class C0652a extends C0647a implements VisibilityListener {
        C0396b f1860c;
        final /* synthetic */ C0653l f1861d;

        public C0652a(C0653l c0653l, Context context, ActionProvider actionProvider) {
            this.f1861d = c0653l;
            super(c0653l, context, actionProvider);
        }

        public View mo555a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public void mo556a(C0396b c0396b) {
            VisibilityListener visibilityListener;
            this.f1860c = c0396b;
            ActionProvider actionProvider = this.a;
            if (c0396b == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public boolean mo557b() {
            return this.a.overridesItemVisibility();
        }

        public boolean mo558c() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1860c != null) {
                this.f1860c.mo548a(z);
            }
        }
    }

    C0653l(Context context, C0303b c0303b) {
        super(context, c0303b);
    }

    C0647a mo559a(ActionProvider actionProvider) {
        return new C0652a(this, this.a, actionProvider);
    }
}
