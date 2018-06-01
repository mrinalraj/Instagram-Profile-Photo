package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.p008h.C0397c;
import android.support.v4.p013b.C0190a;
import android.support.v4.p015d.p016a.C0303b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class C0627a implements C0303b {
    private final int f1698a;
    private final int f1699b;
    private final int f1700c;
    private final int f1701d;
    private CharSequence f1702e;
    private CharSequence f1703f;
    private Intent f1704g;
    private char f1705h;
    private int f1706i = 4096;
    private char f1707j;
    private int f1708k = 4096;
    private Drawable f1709l;
    private int f1710m = 0;
    private Context f1711n;
    private OnMenuItemClickListener f1712o;
    private CharSequence f1713p;
    private CharSequence f1714q;
    private ColorStateList f1715r = null;
    private Mode f1716s = null;
    private boolean f1717t = false;
    private boolean f1718u = false;
    private int f1719v = 16;

    public C0627a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1711n = context;
        this.f1698a = i2;
        this.f1699b = i;
        this.f1700c = i3;
        this.f1701d = i4;
        this.f1702e = charSequence;
    }

    private void m2960b() {
        if (this.f1709l == null) {
            return;
        }
        if (this.f1717t || this.f1718u) {
            this.f1709l = C0279a.m1431f(this.f1709l);
            this.f1709l = this.f1709l.mutate();
            if (this.f1717t) {
                C0279a.m1421a(this.f1709l, this.f1715r);
            }
            if (this.f1718u) {
                C0279a.m1424a(this.f1709l, this.f1716s);
            }
        }
    }

    public C0303b m2961a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0303b mo502a(C0397c c0397c) {
        throw new UnsupportedOperationException();
    }

    public C0303b m2963a(View view) {
        throw new UnsupportedOperationException();
    }

    public C0303b mo503a(CharSequence charSequence) {
        this.f1713p = charSequence;
        return this;
    }

    public C0397c mo504a() {
        return null;
    }

    public C0303b m2966b(int i) {
        setShowAsAction(i);
        return this;
    }

    public C0303b mo505b(CharSequence charSequence) {
        this.f1714q = charSequence;
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f1708k;
    }

    public char getAlphabeticShortcut() {
        return this.f1707j;
    }

    public CharSequence getContentDescription() {
        return this.f1713p;
    }

    public int getGroupId() {
        return this.f1699b;
    }

    public Drawable getIcon() {
        return this.f1709l;
    }

    public ColorStateList getIconTintList() {
        return this.f1715r;
    }

    public Mode getIconTintMode() {
        return this.f1716s;
    }

    public Intent getIntent() {
        return this.f1704g;
    }

    public int getItemId() {
        return this.f1698a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f1706i;
    }

    public char getNumericShortcut() {
        return this.f1705h;
    }

    public int getOrder() {
        return this.f1701d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1702e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1703f != null ? this.f1703f : this.f1702e;
    }

    public CharSequence getTooltipText() {
        return this.f1714q;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1719v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1719v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1719v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1719v & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m2961a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m2963a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1707j = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f1707j = Character.toLowerCase(c);
        this.f1708k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1719v = (z ? 1 : 0) | (this.f1719v & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1719v = (z ? 2 : 0) | (this.f1719v & -3);
        return this;
    }

    public /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return mo503a(charSequence);
    }

    public MenuItem setEnabled(boolean z) {
        this.f1719v = (z ? 16 : 0) | (this.f1719v & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1710m = i;
        this.f1709l = C0190a.m865a(this.f1711n, i);
        m2960b();
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1709l = drawable;
        this.f1710m = 0;
        m2960b();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1715r = colorStateList;
        this.f1717t = true;
        m2960b();
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f1716s = mode;
        this.f1718u = true;
        m2960b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1704g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1705h = c;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f1705h = c;
        this.f1706i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1712o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1705h = c;
        this.f1707j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1705h = c;
        this.f1706i = KeyEvent.normalizeMetaState(i);
        this.f1707j = Character.toLowerCase(c2);
        this.f1708k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m2966b(i);
    }

    public MenuItem setTitle(int i) {
        this.f1702e = this.f1711n.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1702e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1703f = charSequence;
        return this;
    }

    public /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return mo505b(charSequence);
    }

    public MenuItem setVisible(boolean z) {
        this.f1719v = (z ? 0 : 8) | (this.f1719v & 8);
        return this;
    }
}
