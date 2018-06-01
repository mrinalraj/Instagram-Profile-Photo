package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p013b.C0190a;
import android.support.v4.widget.C0506j;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0524f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class bg extends C0506j implements OnClickListener {
    private final SearchManager f2592j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f2593k;
    private final SearchableInfo f2594l;
    private final Context f2595m;
    private final WeakHashMap<String, ConstantState> f2596n;
    private final int f2597o;
    private boolean f2598p = false;
    private int f2599q = 1;
    private ColorStateList f2600r;
    private int f2601s = -1;
    private int f2602t = -1;
    private int f2603u = -1;
    private int f2604v = -1;
    private int f2605w = -1;
    private int f2606x = -1;

    private static final class C0791a {
        public final TextView f2587a;
        public final TextView f2588b;
        public final ImageView f2589c;
        public final ImageView f2590d;
        public final ImageView f2591e;

        public C0791a(View view) {
            this.f2587a = (TextView) view.findViewById(16908308);
            this.f2588b = (TextView) view.findViewById(16908309);
            this.f2589c = (ImageView) view.findViewById(16908295);
            this.f2590d = (ImageView) view.findViewById(16908296);
            this.f2591e = (ImageView) view.findViewById(C0524f.edit_query);
        }
    }

    public bg(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2593k = searchView;
        this.f2594l = searchableInfo;
        this.f2597o = searchView.getSuggestionCommitIconResId();
        this.f2595m = context;
        this.f2596n = weakHashMap;
    }

    private Drawable m4478a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2596n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f2596n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f2595m.getResources());
        } else {
            Drawable b = m4485b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f2596n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m4479a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2595m.getPackageName() + "/" + parseInt;
            b = m4487b(str2);
            if (b != null) {
                return b;
            }
            b = C0190a.m865a(this.f2595m, parseInt);
            m4484a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m4487b(str);
            if (b != null) {
                return b;
            }
            b = m4486b(Uri.parse(str));
            m4484a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private static String m4480a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    public static String m4481a(Cursor cursor, String str) {
        return m4480a(cursor, cursor.getColumnIndex(str));
    }

    private void m4482a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void m4483a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void m4484a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2596n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m4485b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable m4486b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m4495a(uri);
            }
            openInputStream = this.f2595m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m4487b(String str) {
        ConstantState constantState = (ConstantState) this.f2596n.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private CharSequence m4488b(CharSequence charSequence) {
        if (this.f2600r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0519a.textColorSearchUrl, typedValue, true);
            this.f2600r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2600r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m4489d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    private Drawable m4490e(Cursor cursor) {
        if (this.f2604v == -1) {
            return null;
        }
        Drawable a = m4479a(cursor.getString(this.f2604v));
        return a == null ? m4492g(cursor) : a;
    }

    private Drawable m4491f(Cursor cursor) {
        return this.f2605w == -1 ? null : m4479a(cursor.getString(this.f2605w));
    }

    private Drawable m4492g(Cursor cursor) {
        Drawable a = m4478a(this.f2594l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    Cursor m4493a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public Cursor mo373a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2593k.getVisibility() != 0 || this.f2593k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m4493a(this.f2594l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    Drawable m4495a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public View mo387a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo387a(context, cursor, viewGroup);
        a.setTag(new C0791a(a));
        ((ImageView) a.findViewById(C0524f.edit_query)).setImageResource(this.f2597o);
        return a;
    }

    public void m4497a(int i) {
        this.f2599q = i;
    }

    public void mo374a(Cursor cursor) {
        if (this.f2598p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo374a(cursor);
            if (cursor != null) {
                this.f2601s = cursor.getColumnIndex("suggest_text_1");
                this.f2602t = cursor.getColumnIndex("suggest_text_2");
                this.f2603u = cursor.getColumnIndex("suggest_text_2_url");
                this.f2604v = cursor.getColumnIndex("suggest_icon_1");
                this.f2605w = cursor.getColumnIndex("suggest_icon_2");
                this.f2606x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void mo736a(View view, Context context, Cursor cursor) {
        C0791a c0791a = (C0791a) view.getTag();
        int i = this.f2606x != -1 ? cursor.getInt(this.f2606x) : 0;
        if (c0791a.f2587a != null) {
            m4483a(c0791a.f2587a, m4480a(cursor, this.f2601s));
        }
        if (c0791a.f2588b != null) {
            CharSequence a = m4480a(cursor, this.f2603u);
            a = a != null ? m4488b(a) : m4480a(cursor, this.f2602t);
            if (TextUtils.isEmpty(a)) {
                if (c0791a.f2587a != null) {
                    c0791a.f2587a.setSingleLine(false);
                    c0791a.f2587a.setMaxLines(2);
                }
            } else if (c0791a.f2587a != null) {
                c0791a.f2587a.setSingleLine(true);
                c0791a.f2587a.setMaxLines(1);
            }
            m4483a(c0791a.f2588b, a);
        }
        if (c0791a.f2589c != null) {
            m4482a(c0791a.f2589c, m4490e(cursor), 4);
        }
        if (c0791a.f2590d != null) {
            m4482a(c0791a.f2590d, m4491f(cursor), 8);
        }
        if (this.f2599q == 2 || (this.f2599q == 1 && (i & 1) != 0)) {
            c0791a.f2591e.setVisibility(0);
            c0791a.f2591e.setTag(c0791a.f2587a.getText());
            c0791a.f2591e.setOnClickListener(this);
            return;
        }
        c0791a.f2591e.setVisibility(8);
    }

    public CharSequence mo375c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m4481a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f2594l.shouldRewriteQueryFromData()) {
            a = m4481a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f2594l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m4481a(cursor, "suggest_text_1");
        return a != null ? a : null;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View b = mo388b(this.d, this.c, viewGroup);
            if (b != null) {
                ((C0791a) b.getTag()).f2587a.setText(e.toString());
            }
            return b;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo387a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0791a) a.getTag()).f2587a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m4489d(mo372a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m4489d(mo372a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2593k.m3884a((CharSequence) tag);
        }
    }
}
