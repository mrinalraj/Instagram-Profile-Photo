package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0066a.C0059d;
import android.support.design.C0066a.C0060e;
import android.support.design.C0066a.C0061f;
import android.support.design.C0066a.C0063h;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.p008h.C0067b;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.p019a.C0369b;
import android.support.v4.p013b.p014a.C0269c;
import android.support.v4.widget.C0514l;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.view.menu.C0072p.C0070a;
import android.support.v7.view.menu.C0646j;
import android.support.v7.widget.ar.C0670a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C0069a implements C0070a {
    private static final int[] f169d = new int[]{16842912};
    boolean f170c;
    private final int f171e;
    private boolean f172f;
    private final CheckedTextView f173g;
    private FrameLayout f174h;
    private C0646j f175i;
    private ColorStateList f176j;
    private boolean f177k;
    private Drawable f178l;
    private final C0067b f179m;

    class C00681 extends C0067b {
        final /* synthetic */ NavigationMenuItemView f147a;

        C00681(NavigationMenuItemView navigationMenuItemView) {
            this.f147a = navigationMenuItemView;
        }

        public void mo25a(View view, C0369b c0369b) {
            super.mo25a(view, c0369b);
            c0369b.m1709a(this.f147a.f170c);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f179m = new C00681(this);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0063h.design_navigation_menu_item, this, true);
        this.f171e = context.getResources().getDimensionPixelSize(C0059d.design_navigation_icon_size);
        this.f173g = (CheckedTextView) findViewById(C0061f.design_menu_item_text);
        this.f173g.setDuplicateParentStateEnabled(true);
        C0425s.m1948a(this.f173g, this.f179m);
    }

    private boolean m189b() {
        return this.f175i.getTitle() == null && this.f175i.getIcon() == null && this.f175i.getActionView() != null;
    }

    private void m190c() {
        if (m189b()) {
            this.f173g.setVisibility(8);
            if (this.f174h != null) {
                C0670a c0670a = (C0670a) this.f174h.getLayoutParams();
                c0670a.width = -1;
                this.f174h.setLayoutParams(c0670a);
                return;
            }
            return;
        }
        this.f173g.setVisibility(0);
        if (this.f174h != null) {
            c0670a = (C0670a) this.f174h.getLayoutParams();
            c0670a.width = -2;
            this.f174h.setLayoutParams(c0670a);
        }
    }

    private StateListDrawable m191d() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0519a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f169d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f174h == null) {
                this.f174h = (FrameLayout) ((ViewStub) findViewById(C0061f.design_menu_item_action_area_stub)).inflate();
            }
            this.f174h.removeAllViews();
            this.f174h.addView(view);
        }
    }

    public void mo27a(C0646j c0646j, int i) {
        this.f175i = c0646j;
        setVisibility(c0646j.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            C0425s.m1947a((View) this, m191d());
        }
        setCheckable(c0646j.isCheckable());
        setChecked(c0646j.isChecked());
        setEnabled(c0646j.isEnabled());
        setTitle(c0646j.getTitle());
        setIcon(c0646j.getIcon());
        setActionView(c0646j.getActionView());
        m190c();
    }

    public boolean mo28a() {
        return false;
    }

    public C0646j getItemData() {
        return this.f175i;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f175i != null && this.f175i.isCheckable() && this.f175i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f169d);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f170c != z) {
            this.f170c = z;
            this.f179m.m157a(this.f173g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f173g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f177k) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C0279a.m1431f(drawable).mutate();
                C0279a.m1421a(drawable, this.f176j);
            }
            drawable.setBounds(0, 0, this.f171e, this.f171e);
        } else if (this.f172f) {
            if (this.f178l == null) {
                this.f178l = C0269c.m1356a(getResources(), C0060e.navigation_empty_icon, getContext().getTheme());
                if (this.f178l != null) {
                    this.f178l.setBounds(0, 0, this.f171e, this.f171e);
                }
            }
            drawable = this.f178l;
        }
        C0514l.m2452a(this.f173g, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f176j = colorStateList;
        this.f177k = this.f176j != null;
        if (this.f175i != null) {
            setIcon(this.f175i.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f172f = z;
    }

    public void setTextAppearance(int i) {
        C0514l.m2451a(this.f173g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f173g.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f173g.setText(charSequence);
    }
}
