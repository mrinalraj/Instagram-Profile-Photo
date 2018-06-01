package com.mrinalraj.instaface.p035b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C0696a;
import android.support.v7.widget.RecyclerView.C0724w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mrinalraj.instaface.R;
import com.p029b.p030a.C0951t;
import java.util.List;

public class C1013a extends C0696a<C1012a> {
    Context f3309a;
    private List<C1016c> f3310b;

    public class C1012a extends C0724w {
        public TextView f3306n;
        public ImageView f3307o;
        final /* synthetic */ C1013a f3308p;

        public C1012a(C1013a c1013a, View view) {
            this.f3308p = c1013a;
            super(view);
            this.f3306n = (TextView) view.findViewById(R.id.username);
            this.f3307o = (ImageView) view.findViewById(R.id.userimg);
        }
    }

    public C1013a(Context context, List<C1016c> list) {
        this.f3310b = list;
        this.f3309a = context;
    }

    public int mo839a() {
        return this.f3310b.size();
    }

    public /* synthetic */ C0724w mo840a(ViewGroup viewGroup, int i) {
        return m5280c(viewGroup, i);
    }

    public void m5279a(C1012a c1012a, int i) {
        C1016c c1016c = (C1016c) this.f3310b.get(i);
        c1012a.f3306n.setText(c1016c.m5284a());
        C0951t.m5139a(this.f3309a).m5145a(c1016c.m5285b()).m5177a(c1012a.f3307o);
    }

    public C1012a m5280c(ViewGroup viewGroup, int i) {
        return new C1012a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_list, viewGroup, false));
    }
}
