package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0491d.C0489a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class C0490c extends BaseAdapter implements C0489a, Filterable {
    protected boolean f1232a;
    protected boolean f1233b;
    protected Cursor f1234c;
    protected Context f1235d;
    protected int f1236e;
    protected C0487a f1237f;
    protected DataSetObserver f1238g;
    protected C0491d f1239h;
    protected FilterQueryProvider f1240i;

    private class C0487a extends ContentObserver {
        final /* synthetic */ C0490c f1230a;

        C0487a(C0490c c0490c) {
            this.f1230a = c0490c;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f1230a.m2391b();
        }
    }

    private class C0488b extends DataSetObserver {
        final /* synthetic */ C0490c f1231a;

        C0488b(C0490c c0490c) {
            this.f1231a = c0490c;
        }

        public void onChanged() {
            this.f1231a.f1232a = true;
            this.f1231a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1231a.f1232a = false;
            this.f1231a.notifyDataSetInvalidated();
        }
    }

    public C0490c(Context context, Cursor cursor, boolean z) {
        m2386a(context, cursor, z ? 1 : 2);
    }

    public Cursor mo372a() {
        return this.f1234c;
    }

    public Cursor mo373a(CharSequence charSequence) {
        return this.f1240i != null ? this.f1240i.runQuery(charSequence) : this.f1234c;
    }

    public abstract View mo387a(Context context, Cursor cursor, ViewGroup viewGroup);

    void m2386a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f1233b = true;
        } else {
            this.f1233b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f1234c = cursor;
        this.f1232a = z;
        this.f1235d = context;
        this.f1236e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1237f = new C0487a(this);
            this.f1238g = new C0488b(this);
        } else {
            this.f1237f = null;
            this.f1238g = null;
        }
        if (z) {
            if (this.f1237f != null) {
                cursor.registerContentObserver(this.f1237f);
            }
            if (this.f1238g != null) {
                cursor.registerDataSetObserver(this.f1238g);
            }
        }
    }

    public void mo374a(Cursor cursor) {
        Cursor b = m2389b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public abstract void mo736a(View view, Context context, Cursor cursor);

    public Cursor m2389b(Cursor cursor) {
        if (cursor == this.f1234c) {
            return null;
        }
        Cursor cursor2 = this.f1234c;
        if (cursor2 != null) {
            if (this.f1237f != null) {
                cursor2.unregisterContentObserver(this.f1237f);
            }
            if (this.f1238g != null) {
                cursor2.unregisterDataSetObserver(this.f1238g);
            }
        }
        this.f1234c = cursor;
        if (cursor != null) {
            if (this.f1237f != null) {
                cursor.registerContentObserver(this.f1237f);
            }
            if (this.f1238g != null) {
                cursor.registerDataSetObserver(this.f1238g);
            }
            this.f1236e = cursor.getColumnIndexOrThrow("_id");
            this.f1232a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1236e = -1;
        this.f1232a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public View mo388b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo387a(context, cursor, viewGroup);
    }

    protected void m2391b() {
        if (this.f1233b && this.f1234c != null && !this.f1234c.isClosed()) {
            this.f1232a = this.f1234c.requery();
        }
    }

    public CharSequence mo375c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        return (!this.f1232a || this.f1234c == null) ? 0 : this.f1234c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1232a) {
            return null;
        }
        this.f1234c.moveToPosition(i);
        if (view == null) {
            view = mo388b(this.f1235d, this.f1234c, viewGroup);
        }
        mo736a(view, this.f1235d, this.f1234c);
        return view;
    }

    public Filter getFilter() {
        if (this.f1239h == null) {
            this.f1239h = new C0491d(this);
        }
        return this.f1239h;
    }

    public Object getItem(int i) {
        if (!this.f1232a || this.f1234c == null) {
            return null;
        }
        this.f1234c.moveToPosition(i);
        return this.f1234c;
    }

    public long getItemId(int i) {
        return (this.f1232a && this.f1234c != null && this.f1234c.moveToPosition(i)) ? this.f1234c.getLong(this.f1236e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1232a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1234c.moveToPosition(i)) {
            if (view == null) {
                view = mo387a(this.f1235d, this.f1234c, viewGroup);
            }
            mo736a(view, this.f1235d, this.f1234c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
