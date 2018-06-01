package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0094q;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.p023c.p024a.C0608b;
import android.support.v7.view.C0614d;
import android.support.v7.view.menu.C0637s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class C0844x extends Spinner implements C0094q {
    private static final int[] f2815a = new int[]{16843505};
    private final C0818h f2816b;
    private final Context f2817c;
    private ao f2818d;
    private SpinnerAdapter f2819e;
    private final boolean f2820f;
    private C0843b f2821g;
    private int f2822h;
    private final Rect f2823i;

    private static class C0839a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f2804a;
        private ListAdapter f2805b;

        public C0839a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2804a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2805b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof bi) {
                bi biVar = (bi) spinnerAdapter;
                if (biVar.m4506a() == null) {
                    biVar.m4507a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2805b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.f2804a == null ? 0 : this.f2804a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.f2804a == null ? null : this.f2804a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.f2804a == null ? null : this.f2804a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f2804a == null ? -1 : this.f2804a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.f2804a != null && this.f2804a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2805b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2804a != null) {
                this.f2804a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2804a != null) {
                this.f2804a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class C0843b extends as {
        ListAdapter f2811a;
        final /* synthetic */ C0844x f2812b;
        private CharSequence f2813h;
        private final Rect f2814i = new Rect();

        class C08412 implements OnGlobalLayoutListener {
            final /* synthetic */ C0843b f2808a;

            C08412(C0843b c0843b) {
                this.f2808a = c0843b;
            }

            public void onGlobalLayout() {
                if (this.f2808a.m4783a(this.f2808a.f2812b)) {
                    this.f2808a.mo791f();
                    super.mo535a();
                    return;
                }
                this.f2808a.mo542c();
            }
        }

        public C0843b(final C0844x c0844x, Context context, AttributeSet attributeSet, int i) {
            this.f2812b = c0844x;
            super(context, attributeSet, i);
            m4339b((View) c0844x);
            m4337a(true);
            m4331a(0);
            m4334a(new OnItemClickListener(this) {
                final /* synthetic */ C0843b f2807b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f2807b.f2812b.setSelection(i);
                    if (this.f2807b.f2812b.getOnItemClickListener() != null) {
                        this.f2807b.f2812b.performItemClick(view, i, this.f2807b.f2811a.getItemId(i));
                    }
                    this.f2807b.mo542c();
                }
            });
        }

        public void mo535a() {
            boolean d = mo545d();
            mo791f();
            m4351h(2);
            super.mo535a();
            mo546e().setChoiceMode(1);
            m4353i(this.f2812b.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = this.f2812b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c08412 = new C08412(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c08412);
                    m4336a(new OnDismissListener(this) {
                        final /* synthetic */ C0843b f2810b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.f2810b.f2812b.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c08412);
                            }
                        }
                    });
                }
            }
        }

        public void mo789a(ListAdapter listAdapter) {
            super.mo789a(listAdapter);
            this.f2811a = listAdapter;
        }

        public void m4782a(CharSequence charSequence) {
            this.f2813h = charSequence;
        }

        boolean m4783a(View view) {
            return C0425s.m1936A(view) && view.getGlobalVisibleRect(this.f2814i);
        }

        public CharSequence mo790b() {
            return this.f2813h;
        }

        void mo791f() {
            int i;
            Drawable h = m4350h();
            if (h != null) {
                h.getPadding(this.f2812b.f2823i);
                i = bt.m4615a(this.f2812b) ? this.f2812b.f2823i.right : -this.f2812b.f2823i.left;
            } else {
                Rect b = this.f2812b.f2823i;
                this.f2812b.f2823i.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.f2812b.getPaddingLeft();
            int paddingRight = this.f2812b.getPaddingRight();
            int width = this.f2812b.getWidth();
            if (this.f2812b.f2822h == -2) {
                int a = this.f2812b.m4789a((SpinnerAdapter) this.f2811a, m4350h());
                int i2 = (this.f2812b.getContext().getResources().getDisplayMetrics().widthPixels - this.f2812b.f2823i.left) - this.f2812b.f2823i.right;
                if (a <= i2) {
                    i2 = a;
                }
                m4348g(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.f2812b.f2822h == -1) {
                m4348g((width - paddingLeft) - paddingRight);
            } else {
                m4348g(this.f2812b.f2822h);
            }
            m4342c(bt.m4615a(this.f2812b) ? ((width - paddingRight) - m4356l()) + i : i + paddingLeft);
        }
    }

    public C0844x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.spinnerStyle);
    }

    public C0844x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0844x(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public C0844x(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        TypedArray obtainStyledAttributes;
        Throwable e;
        final C0843b c0843b;
        bm a;
        CharSequence[] f;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f2823i = new Rect();
        bm a2 = bm.m4513a(context, attributeSet, C0528j.Spinner, i, 0);
        this.f2816b = new C0818h(this);
        if (theme != null) {
            this.f2817c = new C0614d(context, theme);
        } else {
            int g = a2.m4530g(C0528j.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f2817c = new C0614d(context, g);
            } else {
                this.f2817c = VERSION.SDK_INT < 23 ? context : null;
            }
        }
        if (this.f2817c != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2815a, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c0843b = new C0843b(this, this.f2817c, attributeSet, i);
                                    a = bm.m4513a(this.f2817c, attributeSet, C0528j.Spinner, i, 0);
                                    this.f2822h = a.m4528f(C0528j.Spinner_android_dropDownWidth, -2);
                                    c0843b.m4333a(a.m4517a(C0528j.Spinner_android_popupBackground));
                                    c0843b.m4782a(a2.m4525d(C0528j.Spinner_android_prompt));
                                    a.m4518a();
                                    this.f2821g = c0843b;
                                    this.f2818d = new ao(this, this) {
                                        final /* synthetic */ C0844x f2803b;

                                        public C0637s mo497a() {
                                            return c0843b;
                                        }

                                        public boolean mo498b() {
                                            if (!this.f2803b.f2821g.mo545d()) {
                                                this.f2803b.f2821g.mo535a();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                f = a2.m4529f(C0528j.Spinner_android_entries);
                                if (f != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, f);
                                    arrayAdapter.setDropDownViewResource(C0525g.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.m4518a();
                                this.f2820f = true;
                                if (this.f2819e != null) {
                                    setAdapter(this.f2819e);
                                    this.f2819e = null;
                                }
                                this.f2816b.m4705a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c0843b = new C0843b(this, this.f2817c, attributeSet, i);
                            a = bm.m4513a(this.f2817c, attributeSet, C0528j.Spinner, i, 0);
                            this.f2822h = a.m4528f(C0528j.Spinner_android_dropDownWidth, -2);
                            c0843b.m4333a(a.m4517a(C0528j.Spinner_android_popupBackground));
                            c0843b.m4782a(a2.m4525d(C0528j.Spinner_android_prompt));
                            a.m4518a();
                            this.f2821g = c0843b;
                            this.f2818d = /* anonymous class already generated */;
                        }
                        f = a2.m4529f(C0528j.Spinner_android_entries);
                        if (f != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, f);
                            arrayAdapter.setDropDownViewResource(C0525g.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.m4518a();
                        this.f2820f = true;
                        if (this.f2819e != null) {
                            setAdapter(this.f2819e);
                            this.f2819e = null;
                        }
                        this.f2816b.m4705a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c0843b = new C0843b(this, this.f2817c, attributeSet, i);
                a = bm.m4513a(this.f2817c, attributeSet, C0528j.Spinner, i, 0);
                this.f2822h = a.m4528f(C0528j.Spinner_android_dropDownWidth, -2);
                c0843b.m4333a(a.m4517a(C0528j.Spinner_android_popupBackground));
                c0843b.m4782a(a2.m4525d(C0528j.Spinner_android_prompt));
                a.m4518a();
                this.f2821g = c0843b;
                this.f2818d = /* anonymous class already generated */;
            }
        }
        f = a2.m4529f(C0528j.Spinner_android_entries);
        if (f != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, f);
            arrayAdapter.setDropDownViewResource(C0525g.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.m4518a();
        this.f2820f = true;
        if (this.f2819e != null) {
            setAdapter(this.f2819e);
            this.f2819e = null;
        }
        this.f2816b.m4705a(attributeSet, i);
    }

    int m4789a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f2823i);
        return (this.f2823i.left + this.f2823i.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2816b != null) {
            this.f2816b.m4708c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.f2821g != null ? this.f2821g.m4354j() : VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.f2821g != null ? this.f2821g.m4355k() : VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.f2821g != null ? this.f2822h : VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.f2821g != null ? this.f2821g.m4350h() : VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.f2821g != null ? this.f2817c : VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.f2821g != null ? this.f2821g.mo790b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2816b != null ? this.f2816b.m4700a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2816b != null ? this.f2816b.m4706b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2821g != null && this.f2821g.mo545d()) {
            this.f2821g.mo542c();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2821g != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m4789a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f2818d == null || !this.f2818d.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.f2821g == null) {
            return super.performClick();
        }
        if (!this.f2821g.mo545d()) {
            this.f2821g.mo535a();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f2820f) {
            super.setAdapter(spinnerAdapter);
            if (this.f2821g != null) {
                this.f2821g.mo789a(new C0839a(spinnerAdapter, (this.f2817c == null ? getContext() : this.f2817c).getTheme()));
                return;
            }
            return;
        }
        this.f2819e = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2816b != null) {
            this.f2816b.m4704a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2816b != null) {
            this.f2816b.m4701a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2821g != null) {
            this.f2821g.m4342c(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2821g != null) {
            this.f2821g.m4343d(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f2821g != null) {
            this.f2822h = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2821g != null) {
            this.f2821g.m4333a(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0608b.m2863b(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2821g != null) {
            this.f2821g.m4782a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2816b != null) {
            this.f2816b.m4702a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2816b != null) {
            this.f2816b.m4703a(mode);
        }
    }
}
