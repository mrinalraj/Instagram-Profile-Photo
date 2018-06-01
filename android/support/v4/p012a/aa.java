package android.support.v4.p012a;

import android.app.Activity;
import android.arch.lifecycle.C0013b;
import android.arch.lifecycle.C0013b.C0012b;
import android.arch.lifecycle.C0014c;
import android.arch.lifecycle.C0017d;
import android.arch.lifecycle.C0021g;
import android.os.Bundle;
import android.support.v4.p018g.C0331l;

public class aa extends Activity implements C0014c {
    private C0331l<Class<? extends Object>, Object> f549a = new C0331l();
    private C0017d f550b = new C0017d(this);

    public C0013b mo156a() {
        return this.f550b;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0021g.m40a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.f550b.m34a(C0012b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
