package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class C0491d extends Filter {
    C0489a f1241a;

    interface C0489a {
        Cursor mo372a();

        Cursor mo373a(CharSequence charSequence);

        void mo374a(Cursor cursor);

        CharSequence mo375c(Cursor cursor);
    }

    C0491d(C0489a c0489a) {
        this.f1241a = c0489a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1241a.mo375c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1241a.mo373a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1241a.mo372a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1241a.mo374a((Cursor) filterResults.values);
        }
    }
}
