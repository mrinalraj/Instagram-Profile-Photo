package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class C0506j extends C0490c {
    private int f1250j;
    private int f1251k;
    private LayoutInflater f1252l;

    @Deprecated
    public C0506j(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1251k = i;
        this.f1250j = i;
        this.f1252l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo387a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1252l.inflate(this.f1250j, viewGroup, false);
    }

    public View mo388b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1252l.inflate(this.f1251k, viewGroup, false);
    }
}
