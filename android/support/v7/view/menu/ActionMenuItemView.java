package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.menu.C0072p.C0070a;
import android.support.v7.view.menu.C0643h.C0626b;
import android.support.v7.widget.ActionMenuView.C0625a;
import android.support.v7.widget.aa;
import android.support.v7.widget.ao;
import android.support.v7.widget.bo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class ActionMenuItemView extends aa implements C0070a, C0625a, OnClickListener {
    C0646j f1669a;
    C0626b f1670b;
    C0624b f1671c;
    private CharSequence f1672d;
    private Drawable f1673e;
    private ao f1674f;
    private boolean f1675g;
    private boolean f1676h;
    private int f1677i;
    private int f1678j;
    private int f1679k;

    private class C0623a extends ao {
        final /* synthetic */ ActionMenuItemView f1666a;

        public C0623a(ActionMenuItemView actionMenuItemView) {
            this.f1666a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public C0637s mo497a() {
            return this.f1666a.f1671c != null ? this.f1666a.f1671c.mo773a() : null;
        }

        protected boolean mo498b() {
            if (this.f1666a.f1670b == null || !this.f1666a.f1670b.mo501a(this.f1666a.f1669a)) {
                return false;
            }
            C0637s a = mo497a();
            return a != null && a.mo545d();
        }
    }

    public static abstract class C0624b {
        public abstract C0637s mo773a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1675g = m2944e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.ActionMenuItemView, i, 0);
        this.f1677i = obtainStyledAttributes.getDimensionPixelSize(C0528j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1679k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1678j = -1;
        setSaveEnabled(false);
    }

    private boolean m2944e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || ((i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2);
    }

    private void m2945f() {
        int i = 0;
        CharSequence charSequence = null;
        int i2 = !TextUtils.isEmpty(this.f1672d) ? 1 : 0;
        if (this.f1673e == null || (this.f1669a.m3155m() && (this.f1675g || this.f1676h))) {
            i = 1;
        }
        int i3 = i2 & i;
        setText(i3 != 0 ? this.f1672d : null);
        CharSequence contentDescription = this.f1669a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(i3 != 0 ? null : this.f1669a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        contentDescription = this.f1669a.getTooltipText();
        if (TextUtils.isEmpty(contentDescription)) {
            if (i3 == 0) {
                charSequence = this.f1669a.getTitle();
            }
            bo.m4581a(this, charSequence);
            return;
        }
        bo.m4581a(this, contentDescription);
    }

    public void mo27a(C0646j c0646j, int i) {
        this.f1669a = c0646j;
        setIcon(c0646j.getIcon());
        setTitle(c0646j.m3134a((C0070a) this));
        setId(c0646j.getItemId());
        setVisibility(c0646j.isVisible() ? 0 : 8);
        setEnabled(c0646j.isEnabled());
        if (c0646j.hasSubMenu() && this.f1674f == null) {
            this.f1674f = new C0623a(this);
        }
    }

    public boolean mo28a() {
        return true;
    }

    public boolean m2948b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean mo499c() {
        return m2948b() && this.f1669a.getIcon() == null;
    }

    public boolean mo500d() {
        return m2948b();
    }

    public C0646j getItemData() {
        return this.f1669a;
    }

    public void onClick(View view) {
        if (this.f1670b != null) {
            this.f1670b.mo501a(this.f1669a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1675g = m2944e();
        m2945f();
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m2948b();
        if (b && this.f1678j >= 0) {
            super.setPadding(this.f1678j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f1677i) : this.f1677i;
        if (mode != 1073741824 && this.f1677i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1673e != null) {
            super.setPadding((getMeasuredWidth() - this.f1673e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1669a.hasSubMenu() && this.f1674f != null && this.f1674f.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1676h != z) {
            this.f1676h = z;
            if (this.f1669a != null) {
                this.f1669a.m3150h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1673e = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1679k) {
                f = ((float) this.f1679k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1679k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1679k) {
                f = ((float) this.f1679k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1679k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m2945f();
    }

    public void setItemInvoker(C0626b c0626b) {
        this.f1670b = c0626b;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1678j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0624b c0624b) {
        this.f1671c = c0624b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1672d = charSequence;
        m2945f();
    }
}
