package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.p008h.C0079a;
import android.support.v4.widget.C0490c;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0522d;
import android.support.v7.view.C0613c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends ar implements C0613c {
    static final C0727a f2206i = new C0727a();
    private OnClickListener f2207A;
    private boolean f2208B;
    private boolean f2209C;
    private boolean f2210D;
    private CharSequence f2211E;
    private boolean f2212F;
    private boolean f2213G;
    private int f2214H;
    private boolean f2215I;
    private CharSequence f2216J;
    private boolean f2217K;
    private int f2218L;
    private Bundle f2219M;
    private final Runnable f2220N;
    private Runnable f2221O;
    private final WeakHashMap<String, ConstantState> f2222P;
    final SearchAutoComplete f2223a;
    final ImageView f2224b;
    final ImageView f2225c;
    final ImageView f2226d;
    final ImageView f2227e;
    OnFocusChangeListener f2228f;
    C0490c f2229g;
    SearchableInfo f2230h;
    private final View f2231j;
    private final View f2232k;
    private C0733f f2233l;
    private Rect f2234m;
    private Rect f2235n;
    private int[] f2236o;
    private int[] f2237p;
    private final ImageView f2238q;
    private final Drawable f2239r;
    private final int f2240s;
    private final int f2241t;
    private final Intent f2242u;
    private final Intent f2243v;
    private final CharSequence f2244w;
    private C0729c f2245x;
    private C0728b f2246y;
    private C0730d f2247z;

    public static class SearchAutoComplete extends C0726g {
        final Runnable f2192a;
        private int f2193b;
        private SearchView f2194c;
        private boolean f2195d;

        class C07251 implements Runnable {
            final /* synthetic */ SearchAutoComplete f2188a;

            C07251(SearchAutoComplete searchAutoComplete) {
                this.f2188a = searchAutoComplete;
            }

            public void run() {
                this.f2188a.m3855a();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0519a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2192a = new C07251(this);
            this.f2193b = getThreshold();
        }

        private void m3855a() {
            if (this.f2195d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2195d = false;
            }
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            return (i < 960 || i2 < 720 || configuration.orientation != 2) ? (i >= 600 || (i >= 640 && i2 >= 480)) ? 192 : 160 : 256;
        }

        private void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f2195d = false;
                removeCallbacks(this.f2192a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f2195d = false;
                removeCallbacks(this.f2192a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f2195d = true;
            }
        }

        public boolean enoughToFilter() {
            return this.f2193b <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2195d) {
                removeCallbacks(this.f2192a);
                post(this.f2192a);
            }
            return onCreateInputConnection;
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f2194c.m3891g();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2194c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f2194c.hasFocus() && getVisibility() == 0) {
                this.f2195d = true;
                if (SearchView.m3870a(getContext())) {
                    SearchView.f2206i.m3859a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f2194c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f2193b = i;
        }
    }

    private static class C0727a {
        private Method f2196a;
        private Method f2197b;
        private Method f2198c;

        C0727a() {
            try {
                this.f2196a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f2196a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f2197b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f2197b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f2198c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f2198c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
        }

        void m3858a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f2196a != null) {
                try {
                    this.f2196a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m3859a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f2198c != null) {
                try {
                    this.f2198c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        void m3860b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f2197b != null) {
                try {
                    this.f2197b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }
    }

    public interface C0728b {
        boolean m3861a();
    }

    public interface C0729c {
        boolean m3862a(String str);
    }

    public interface C0730d {
    }

    static class C0732e extends C0079a {
        public static final Creator<C0732e> CREATOR = new C07311();
        boolean f2199a;

        static class C07311 implements ClassLoaderCreator<C0732e> {
            C07311() {
            }

            public C0732e m3863a(Parcel parcel) {
                return new C0732e(parcel, null);
            }

            public C0732e m3864a(Parcel parcel, ClassLoader classLoader) {
                return new C0732e(parcel, classLoader);
            }

            public C0732e[] m3865a(int i) {
                return new C0732e[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3863a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m3864a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3865a(i);
            }
        }

        public C0732e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2199a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        C0732e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2199a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f2199a));
        }
    }

    private static class C0733f extends TouchDelegate {
        private final View f2200a;
        private final Rect f2201b = new Rect();
        private final Rect f2202c = new Rect();
        private final Rect f2203d = new Rect();
        private final int f2204e;
        private boolean f2205f;

        public C0733f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2204e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            m3866a(rect, rect2);
            this.f2200a = view;
        }

        public void m3866a(Rect rect, Rect rect2) {
            this.f2201b.set(rect);
            this.f2203d.set(rect);
            this.f2203d.inset(-this.f2204e, -this.f2204e);
            this.f2202c.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r1 = 1;
            r0 = 0;
            r2 = r7.getX();
            r3 = (int) r2;
            r2 = r7.getY();
            r4 = (int) r2;
            r2 = r7.getAction();
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0048;
                case 2: goto L_0x0048;
                case 3: goto L_0x0056;
                default: goto L_0x0013;
            };
        L_0x0013:
            r2 = r0;
        L_0x0014:
            if (r2 == 0) goto L_0x003b;
        L_0x0016:
            if (r1 == 0) goto L_0x005b;
        L_0x0018:
            r0 = r6.f2202c;
            r0 = r0.contains(r3, r4);
            if (r0 != 0) goto L_0x005b;
        L_0x0020:
            r0 = r6.f2200a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.f2200a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0035:
            r0 = r6.f2200a;
            r0 = r0.dispatchTouchEvent(r7);
        L_0x003b:
            return r0;
        L_0x003c:
            r2 = r6.f2201b;
            r2 = r2.contains(r3, r4);
            if (r2 == 0) goto L_0x0013;
        L_0x0044:
            r6.f2205f = r1;
            r2 = r1;
            goto L_0x0014;
        L_0x0048:
            r2 = r6.f2205f;
            if (r2 == 0) goto L_0x0014;
        L_0x004c:
            r5 = r6.f2203d;
            r5 = r5.contains(r3, r4);
            if (r5 != 0) goto L_0x0014;
        L_0x0054:
            r1 = r0;
            goto L_0x0014;
        L_0x0056:
            r2 = r6.f2205f;
            r6.f2205f = r0;
            goto L_0x0014;
        L_0x005b:
            r0 = r6.f2202c;
            r0 = r0.left;
            r0 = r3 - r0;
            r0 = (float) r0;
            r1 = r6.f2202c;
            r1 = r1.top;
            r1 = r4 - r1;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0035;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    private Intent m3867a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2216J);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f2219M != null) {
            intent.putExtra("app_data", this.f2219M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f2230h.getSearchActivity());
        return intent;
    }

    private void m3868a(View view, Rect rect) {
        view.getLocationInWindow(this.f2236o);
        getLocationInWindow(this.f2237p);
        int i = this.f2236o[1] - this.f2237p[1];
        int i2 = this.f2236o[0] - this.f2237p[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private void m3869a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f2209C = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f2223a.getText());
        this.f2224b.setVisibility(i2);
        m3872b(z3);
        this.f2231j.setVisibility(z ? 8 : 0);
        if (!(this.f2238q.getDrawable() == null || this.f2208B)) {
            i = 0;
        }
        this.f2238q.setVisibility(i);
        m3877m();
        if (z3) {
            z2 = false;
        }
        m3873c(z2);
        m3876l();
    }

    static boolean m3870a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence m3871b(CharSequence charSequence) {
        if (!this.f2208B || this.f2239r == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f2223a.getTextSize()) * 1.25d);
        this.f2239r.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f2239r), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m3872b(boolean z) {
        int i = 8;
        if (this.f2210D && m3875k() && hasFocus() && (z || !this.f2215I)) {
            i = 0;
        }
        this.f2225c.setVisibility(i);
    }

    private void m3873c(boolean z) {
        int i;
        if (this.f2215I && !m3887c() && z) {
            i = 0;
            this.f2225c.setVisibility(8);
        } else {
            i = 8;
        }
        this.f2227e.setVisibility(i);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0522d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0522d.abc_search_view_preferred_width);
    }

    private boolean m3874i() {
        if (this.f2230h == null || !this.f2230h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f2230h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f2242u;
        } else if (this.f2230h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f2243v;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean m3875k() {
        return (this.f2210D || this.f2215I) && !m3887c();
    }

    private void m3876l() {
        int i = 8;
        if (m3875k() && (this.f2225c.getVisibility() == 0 || this.f2227e.getVisibility() == 0)) {
            i = 0;
        }
        this.f2232k.setVisibility(i);
    }

    private void m3877m() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f2223a.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f2208B || this.f2217K)) {
            i = 0;
        }
        ImageView imageView = this.f2226d;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f2226d.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m3878n() {
        post(this.f2220N);
    }

    private void m3879o() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f2223a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m3871b(queryHint));
    }

    private void m3880p() {
        int i = 1;
        this.f2223a.setThreshold(this.f2230h.getSuggestThreshold());
        this.f2223a.setImeOptions(this.f2230h.getImeOptions());
        int inputType = this.f2230h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2230h.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f2223a.setInputType(inputType);
        if (this.f2229g != null) {
            this.f2229g.mo374a(null);
        }
        if (this.f2230h.getSuggestAuthority() != null) {
            this.f2229g = new bg(getContext(), this, this.f2230h, this.f2222P);
            this.f2223a.setAdapter(this.f2229g);
            bg bgVar = (bg) this.f2229g;
            if (this.f2212F) {
                i = 2;
            }
            bgVar.m4497a(i);
        }
    }

    private void m3881q() {
        this.f2223a.dismissDropDown();
    }

    private void setQuery(CharSequence charSequence) {
        this.f2223a.setText(charSequence);
        this.f2223a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void mo553a() {
        if (!this.f2217K) {
            this.f2217K = true;
            this.f2218L = this.f2223a.getImeOptions();
            this.f2223a.setImeOptions(this.f2218L | 33554432);
            this.f2223a.setText("");
            setIconified(false);
        }
    }

    void m3883a(int i, String str, String str2) {
        getContext().startActivity(m3867a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    void m3884a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void m3885a(CharSequence charSequence, boolean z) {
        this.f2223a.setText(charSequence);
        if (charSequence != null) {
            this.f2223a.setSelection(this.f2223a.length());
            this.f2216J = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m3888d();
        }
    }

    public void mo554b() {
        m3885a((CharSequence) "", false);
        clearFocus();
        m3869a(true);
        this.f2223a.setImeOptions(this.f2218L);
        this.f2217K = false;
    }

    public boolean m3887c() {
        return this.f2209C;
    }

    public void clearFocus() {
        this.f2213G = true;
        super.clearFocus();
        this.f2223a.clearFocus();
        this.f2223a.setImeVisibility(false);
        this.f2213G = false;
    }

    void m3888d() {
        CharSequence text = this.f2223a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f2245x == null || !this.f2245x.m3862a(text.toString())) {
                if (this.f2230h != null) {
                    m3883a(0, null, text.toString());
                }
                this.f2223a.setImeVisibility(false);
                m3881q();
            }
        }
    }

    void m3889e() {
        if (!TextUtils.isEmpty(this.f2223a.getText())) {
            this.f2223a.setText("");
            this.f2223a.requestFocus();
            this.f2223a.setImeVisibility(true);
        } else if (!this.f2208B) {
        } else {
            if (this.f2246y == null || !this.f2246y.m3861a()) {
                clearFocus();
                m3869a(true);
            }
        }
    }

    void m3890f() {
        m3869a(false);
        this.f2223a.requestFocus();
        this.f2223a.setImeVisibility(true);
        if (this.f2207A != null) {
            this.f2207A.onClick(this);
        }
    }

    void m3891g() {
        m3869a(m3887c());
        m3878n();
        if (this.f2223a.hasFocus()) {
            m3892h();
        }
    }

    public int getImeOptions() {
        return this.f2223a.getImeOptions();
    }

    public int getInputType() {
        return this.f2223a.getInputType();
    }

    public int getMaxWidth() {
        return this.f2214H;
    }

    public CharSequence getQuery() {
        return this.f2223a.getText();
    }

    public CharSequence getQueryHint() {
        return this.f2211E != null ? this.f2211E : (this.f2230h == null || this.f2230h.getHintId() == 0) ? this.f2244w : getContext().getText(this.f2230h.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f2241t;
    }

    int getSuggestionRowLayout() {
        return this.f2240s;
    }

    public C0490c getSuggestionsAdapter() {
        return this.f2229g;
    }

    void m3892h() {
        f2206i.m3858a(this.f2223a);
        f2206i.m3860b(this.f2223a);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f2220N);
        post(this.f2221O);
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m3868a(this.f2223a, this.f2234m);
            this.f2235n.set(this.f2234m.left, 0, this.f2234m.right, i4 - i2);
            if (this.f2233l == null) {
                this.f2233l = new C0733f(this.f2235n, this.f2234m, this.f2223a);
                setTouchDelegate(this.f2233l);
                return;
            }
            this.f2233l.m3866a(this.f2235n, this.f2234m);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (m3887c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f2214H <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f2214H, size);
                    break;
                }
            case 0:
                if (this.f2214H <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f2214H;
                    break;
                }
            case 1073741824:
                if (this.f2214H > 0) {
                    size = Math.min(this.f2214H, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
                mode = Math.min(getPreferredHeight(), mode);
                break;
            case 0:
                mode = getPreferredHeight();
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0732e) {
            C0732e c0732e = (C0732e) parcelable;
            super.onRestoreInstanceState(c0732e.m320a());
            m3869a(c0732e.f2199a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0732e = new C0732e(super.onSaveInstanceState());
        c0732e.f2199a = m3887c();
        return c0732e;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m3878n();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f2213G || !isFocusable()) {
            return false;
        }
        if (m3887c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f2223a.requestFocus(i, rect);
        if (requestFocus) {
            m3869a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2219M = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m3889e();
        } else {
            m3890f();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f2208B != z) {
            this.f2208B = z;
            m3869a(z);
            m3879o();
        }
    }

    public void setImeOptions(int i) {
        this.f2223a.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f2223a.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f2214H = i;
        requestLayout();
    }

    public void setOnCloseListener(C0728b c0728b) {
        this.f2246y = c0728b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f2228f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(C0729c c0729c) {
        this.f2245x = c0729c;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f2207A = onClickListener;
    }

    public void setOnSuggestionListener(C0730d c0730d) {
        this.f2247z = c0730d;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2211E = charSequence;
        m3879o();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f2212F = z;
        if (this.f2229g instanceof bg) {
            ((bg) this.f2229g).m4497a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2230h = searchableInfo;
        if (this.f2230h != null) {
            m3880p();
            m3879o();
        }
        this.f2215I = m3874i();
        if (this.f2215I) {
            this.f2223a.setPrivateImeOptions("nm");
        }
        m3869a(m3887c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f2210D = z;
        m3869a(m3887c());
    }

    public void setSuggestionsAdapter(C0490c c0490c) {
        this.f2229g = c0490c;
        this.f2223a.setAdapter(this.f2229g);
    }
}
