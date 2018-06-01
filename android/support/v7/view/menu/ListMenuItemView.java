package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.menu.C0072p.C0070a;
import android.support.v7.widget.bm;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0070a {
    private C0646j f1683a;
    private ImageView f1684b;
    private RadioButton f1685c;
    private TextView f1686d;
    private CheckBox f1687e;
    private TextView f1688f;
    private ImageView f1689g;
    private Drawable f1690h;
    private int f1691i;
    private Context f1692j;
    private boolean f1693k;
    private Drawable f1694l;
    private int f1695m;
    private LayoutInflater f1696n;
    private boolean f1697o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        bm a = bm.m4513a(getContext(), attributeSet, C0528j.MenuView, i, 0);
        this.f1690h = a.m4517a(C0528j.MenuView_android_itemBackground);
        this.f1691i = a.m4530g(C0528j.MenuView_android_itemTextAppearance, -1);
        this.f1693k = a.m4519a(C0528j.MenuView_preserveIconSpacing, false);
        this.f1692j = context;
        this.f1694l = a.m4517a(C0528j.MenuView_subMenuArrow);
        a.m4518a();
    }

    private void m2954b() {
        this.f1684b = (ImageView) getInflater().inflate(C0525g.abc_list_menu_item_icon, this, false);
        addView(this.f1684b, 0);
    }

    private void m2955c() {
        this.f1685c = (RadioButton) getInflater().inflate(C0525g.abc_list_menu_item_radio, this, false);
        addView(this.f1685c);
    }

    private void m2956d() {
        this.f1687e = (CheckBox) getInflater().inflate(C0525g.abc_list_menu_item_checkbox, this, false);
        addView(this.f1687e);
    }

    private LayoutInflater getInflater() {
        if (this.f1696n == null) {
            this.f1696n = LayoutInflater.from(getContext());
        }
        return this.f1696n;
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f1689g != null) {
            this.f1689g.setVisibility(z ? 0 : 8);
        }
    }

    public void mo27a(C0646j c0646j, int i) {
        this.f1683a = c0646j;
        this.f1695m = i;
        setVisibility(c0646j.isVisible() ? 0 : 8);
        setTitle(c0646j.m3134a((C0070a) this));
        setCheckable(c0646j.isCheckable());
        m2958a(c0646j.m3148f(), c0646j.m3144d());
        setIcon(c0646j.getIcon());
        setEnabled(c0646j.isEnabled());
        setSubMenuArrowVisible(c0646j.hasSubMenu());
        setContentDescription(c0646j.getContentDescription());
    }

    public void m2958a(boolean z, char c) {
        int i = (z && this.f1683a.m3148f()) ? 0 : 8;
        if (i == 0) {
            this.f1688f.setText(this.f1683a.m3146e());
        }
        if (this.f1688f.getVisibility() != i) {
            this.f1688f.setVisibility(i);
        }
    }

    public boolean mo28a() {
        return false;
    }

    public C0646j getItemData() {
        return this.f1683a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        C0425s.m1947a((View) this, this.f1690h);
        this.f1686d = (TextView) findViewById(C0524f.title);
        if (this.f1691i != -1) {
            this.f1686d.setTextAppearance(this.f1692j, this.f1691i);
        }
        this.f1688f = (TextView) findViewById(C0524f.shortcut);
        this.f1689g = (ImageView) findViewById(C0524f.submenuarrow);
        if (this.f1689g != null) {
            this.f1689g.setImageDrawable(this.f1694l);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1684b != null && this.f1693k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1684b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.f1685c != null || this.f1687e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1683a.m3149g()) {
                if (this.f1685c == null) {
                    m2955c();
                }
                compoundButton = this.f1685c;
                compoundButton2 = this.f1687e;
            } else {
                if (this.f1687e == null) {
                    m2956d();
                }
                compoundButton = this.f1687e;
                compoundButton2 = this.f1685c;
            }
            if (z) {
                compoundButton.setChecked(this.f1683a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1687e != null) {
                this.f1687e.setVisibility(8);
            }
            if (this.f1685c != null) {
                this.f1685c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1683a.m3149g()) {
            if (this.f1685c == null) {
                m2955c();
            }
            compoundButton = this.f1685c;
        } else {
            if (this.f1687e == null) {
                m2956d();
            }
            compoundButton = this.f1687e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1697o = z;
        this.f1693k = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1683a.m3151i() || this.f1697o) ? 1 : 0;
        if (i == 0 && !this.f1693k) {
            return;
        }
        if (this.f1684b != null || drawable != null || this.f1693k) {
            if (this.f1684b == null) {
                m2954b();
            }
            if (drawable != null || this.f1693k) {
                ImageView imageView = this.f1684b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1684b.getVisibility() != 0) {
                    this.f1684b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1684b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1686d.setText(charSequence);
            if (this.f1686d.getVisibility() != 0) {
                this.f1686d.setVisibility(0);
            }
        } else if (this.f1686d.getVisibility() != 8) {
            this.f1686d.setVisibility(8);
        }
    }
}
