package com.mrinalraj.instaface.activities;

import android.os.Bundle;
import android.support.v7.app.C0551c;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.ak;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.mrinalraj.instaface.R;
import com.mrinalraj.instaface.p035b.C1013a;
import com.mrinalraj.instaface.p035b.C1015b;
import com.mrinalraj.instaface.p035b.C1015b.C0993a;
import com.mrinalraj.instaface.p035b.C1016c;
import com.mrinalraj.instaface.p036c.C1017a;
import com.mrinalraj.instaface.p037d.C1020a;
import com.p026a.p027a.C0886m;
import com.p026a.p027a.p028a.C0866k;
import java.util.ArrayList;
import java.util.List;

public class History extends C0551c {
    TextView f3273m;
    C1017a f3274n;
    List<C1016c> f3275o = new ArrayList();
    RecyclerView f3276p;
    C1013a f3277q;
    String f3278r;
    C0886m f3279s;

    class C09941 implements C0993a {
        final /* synthetic */ History f3271a;

        C09941(History history) {
            this.f3271a = history;
        }

        public void mo827a(View view, int i) {
            C1016c c1016c = (C1016c) this.f3271a.f3275o.get(i);
            this.f3271a.f3278r = c1016c.m5284a();
            new C1020a(this.f3271a, this.f3271a.f3279s).m5295a(this.f3271a.f3278r);
        }

        public void mo828b(View view, int i) {
            this.f3271a.f3274n.m5289b(((C1016c) this.f3271a.f3275o.get(i)).m5284a());
            this.f3271a.m5256k();
        }
    }

    class C09952 implements OnClickListener {
        final /* synthetic */ History f3272a;

        C09952(History history) {
            this.f3272a = history;
        }

        public void onClick(View view) {
            this.f3272a.f3274n.m5291c();
            this.f3272a.m5256k();
        }
    }

    private void m5256k() {
        this.f3275o.clear();
        try {
            String[] a = this.f3274n.m5288a();
            String[] b = this.f3274n.m5290b();
            for (int i = 0; i < a.length; i++) {
                this.f3275o.add(new C1016c(a[i], b[i]));
            }
            Log.d("method running", "prepare data");
            this.f3277q.m3667c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_history);
        this.f3274n = new C1017a(this, null);
        this.f3279s = C0866k.m4910a(this);
        this.f3276p = (RecyclerView) findViewById(R.id.history_list);
        this.f3277q = new C1013a(this, this.f3275o);
        this.f3276p.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        this.f3276p.setItemAnimator(new ak());
        this.f3276p.setAdapter(this.f3277q);
        m5256k();
        this.f3276p.m244a(new C1015b(this, this.f3276p, new C09941(this)));
        this.f3273m = (TextView) findViewById(R.id.clearall);
        this.f3273m.setOnClickListener(new C09952(this));
    }
}
