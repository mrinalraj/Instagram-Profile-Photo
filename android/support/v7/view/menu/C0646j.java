package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.p008h.C0397c;
import android.support.v4.p008h.C0397c.C0396b;
import android.support.v4.p015d.p016a.C0303b;
import android.support.v7.p023c.p024a.C0608b;
import android.support.v7.view.menu.C0072p.C0070a;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class C0646j implements C0303b {
    private static String f1819F;
    private static String f1820G;
    private static String f1821H;
    private static String f1822I;
    private View f1823A;
    private C0397c f1824B;
    private OnActionExpandListener f1825C;
    private boolean f1826D = false;
    private ContextMenuInfo f1827E;
    C0643h f1828a;
    private final int f1829b;
    private final int f1830c;
    private final int f1831d;
    private final int f1832e;
    private CharSequence f1833f;
    private CharSequence f1834g;
    private Intent f1835h;
    private char f1836i;
    private int f1837j = 4096;
    private char f1838k;
    private int f1839l = 4096;
    private Drawable f1840m;
    private int f1841n = 0;
    private C0661u f1842o;
    private Runnable f1843p;
    private OnMenuItemClickListener f1844q;
    private CharSequence f1845r;
    private CharSequence f1846s;
    private ColorStateList f1847t = null;
    private Mode f1848u = null;
    private boolean f1849v = false;
    private boolean f1850w = false;
    private boolean f1851x = false;
    private int f1852y = 16;
    private int f1853z = 0;

    class C06451 implements C0396b {
        final /* synthetic */ C0646j f1818a;

        C06451(C0646j c0646j) {
            this.f1818a = c0646j;
        }

        public void mo548a(boolean z) {
            this.f1818a.f1828a.m3086a(this.f1818a);
        }
    }

    C0646j(C0643h c0643h, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1828a = c0643h;
        this.f1829b = i2;
        this.f1830c = i;
        this.f1831d = i3;
        this.f1832e = i4;
        this.f1833f = charSequence;
        this.f1853z = i5;
    }

    private Drawable m3128a(Drawable drawable) {
        if (drawable != null && this.f1851x && (this.f1849v || this.f1850w)) {
            drawable = C0279a.m1431f(drawable).mutate();
            if (this.f1849v) {
                C0279a.m1421a(drawable, this.f1847t);
            }
            if (this.f1850w) {
                C0279a.m1424a(drawable, this.f1848u);
            }
            this.f1851x = false;
        }
        return drawable;
    }

    public C0303b m3129a(int i) {
        Context e = this.f1828a.m3108e();
        m3131a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public C0303b mo502a(C0397c c0397c) {
        if (this.f1824B != null) {
            this.f1824B.m1783f();
        }
        this.f1823A = null;
        this.f1824B = c0397c;
        this.f1828a.m3099b(true);
        if (this.f1824B != null) {
            this.f1824B.mo556a(new C06451(this));
        }
        return this;
    }

    public C0303b m3131a(View view) {
        this.f1823A = view;
        this.f1824B = null;
        if (view != null && view.getId() == -1 && this.f1829b > 0) {
            view.setId(this.f1829b);
        }
        this.f1828a.m3097b(this);
        return this;
    }

    public C0303b mo503a(CharSequence charSequence) {
        this.f1845r = charSequence;
        this.f1828a.m3099b(false);
        return this;
    }

    public C0397c mo504a() {
        return this.f1824B;
    }

    CharSequence m3134a(C0070a c0070a) {
        return (c0070a == null || !c0070a.mo28a()) ? getTitle() : getTitleCondensed();
    }

    public void m3135a(C0661u c0661u) {
        this.f1842o = c0661u;
        c0661u.setHeaderTitle(getTitle());
    }

    void m3136a(ContextMenuInfo contextMenuInfo) {
        this.f1827E = contextMenuInfo;
    }

    public void m3137a(boolean z) {
        this.f1852y = (z ? 4 : 0) | (this.f1852y & -5);
    }

    public C0303b m3138b(int i) {
        setShowAsAction(i);
        return this;
    }

    public C0303b mo505b(CharSequence charSequence) {
        this.f1846s = charSequence;
        this.f1828a.m3099b(false);
        return this;
    }

    void m3140b(boolean z) {
        int i = this.f1852y;
        this.f1852y = (z ? 2 : 0) | (this.f1852y & -3);
        if (i != this.f1852y) {
            this.f1828a.m3099b(false);
        }
    }

    public boolean m3141b() {
        if ((this.f1844q != null && this.f1844q.onMenuItemClick(this)) || this.f1828a.mo562a(this.f1828a, (MenuItem) this)) {
            return true;
        }
        if (this.f1843p != null) {
            this.f1843p.run();
            return true;
        }
        if (this.f1835h != null) {
            try {
                this.f1828a.m3108e().startActivity(this.f1835h);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f1824B != null && this.f1824B.mo551d();
    }

    public int m3142c() {
        return this.f1832e;
    }

    boolean m3143c(boolean z) {
        int i = this.f1852y;
        this.f1852y = (z ? 0 : 8) | (this.f1852y & -9);
        return i != this.f1852y;
    }

    public boolean collapseActionView() {
        return (this.f1853z & 8) == 0 ? false : this.f1823A == null ? true : (this.f1825C == null || this.f1825C.onMenuItemActionCollapse(this)) ? this.f1828a.mo566d(this) : false;
    }

    char m3144d() {
        return this.f1828a.mo563b() ? this.f1838k : this.f1836i;
    }

    public void m3145d(boolean z) {
        if (z) {
            this.f1852y |= 32;
        } else {
            this.f1852y &= -33;
        }
    }

    String m3146e() {
        char d = m3144d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f1819F);
        switch (d) {
            case '\b':
                stringBuilder.append(f1821H);
                break;
            case '\n':
                stringBuilder.append(f1820G);
                break;
            case ' ':
                stringBuilder.append(f1822I);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void m3147e(boolean z) {
        this.f1826D = z;
        this.f1828a.m3099b(false);
    }

    public boolean expandActionView() {
        return !m3156n() ? false : (this.f1825C == null || this.f1825C.onMenuItemActionExpand(this)) ? this.f1828a.mo565c(this) : false;
    }

    boolean m3148f() {
        return this.f1828a.mo564c() && m3144d() != '\u0000';
    }

    public boolean m3149g() {
        return (this.f1852y & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f1823A != null) {
            return this.f1823A;
        }
        if (this.f1824B == null) {
            return null;
        }
        this.f1823A = this.f1824B.mo555a((MenuItem) this);
        return this.f1823A;
    }

    public int getAlphabeticModifiers() {
        return this.f1839l;
    }

    public char getAlphabeticShortcut() {
        return this.f1838k;
    }

    public CharSequence getContentDescription() {
        return this.f1845r;
    }

    public int getGroupId() {
        return this.f1830c;
    }

    public Drawable getIcon() {
        if (this.f1840m != null) {
            return m3128a(this.f1840m);
        }
        if (this.f1841n == 0) {
            return null;
        }
        Drawable b = C0608b.m2863b(this.f1828a.m3108e(), this.f1841n);
        this.f1841n = 0;
        this.f1840m = b;
        return m3128a(b);
    }

    public ColorStateList getIconTintList() {
        return this.f1847t;
    }

    public Mode getIconTintMode() {
        return this.f1848u;
    }

    public Intent getIntent() {
        return this.f1835h;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1829b;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1827E;
    }

    public int getNumericModifiers() {
        return this.f1837j;
    }

    public char getNumericShortcut() {
        return this.f1836i;
    }

    public int getOrder() {
        return this.f1831d;
    }

    public SubMenu getSubMenu() {
        return this.f1842o;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1833f;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1834g != null ? this.f1834g : this.f1833f;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.f1846s;
    }

    public void m3150h() {
        this.f1828a.m3097b(this);
    }

    public boolean hasSubMenu() {
        return this.f1842o != null;
    }

    public boolean m3151i() {
        return this.f1828a.m3121q();
    }

    public boolean isActionViewExpanded() {
        return this.f1826D;
    }

    public boolean isCheckable() {
        return (this.f1852y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f1852y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f1852y & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1824B == null || !this.f1824B.mo557b()) ? (this.f1852y & 8) == 0 : (this.f1852y & 8) == 0 && this.f1824B.mo558c();
    }

    public boolean m3152j() {
        return (this.f1852y & 32) == 32;
    }

    public boolean m3153k() {
        return (this.f1853z & 1) == 1;
    }

    public boolean m3154l() {
        return (this.f1853z & 2) == 2;
    }

    public boolean m3155m() {
        return (this.f1853z & 4) == 4;
    }

    public boolean m3156n() {
        if ((this.f1853z & 8) == 0) {
            return false;
        }
        if (this.f1823A == null && this.f1824B != null) {
            this.f1823A = this.f1824B.mo555a((MenuItem) this);
        }
        return this.f1823A != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3129a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3131a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1838k != c) {
            this.f1838k = Character.toLowerCase(c);
            this.f1828a.m3099b(false);
        }
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (!(this.f1838k == c && this.f1839l == i)) {
            this.f1838k = Character.toLowerCase(c);
            this.f1839l = KeyEvent.normalizeMetaState(i);
            this.f1828a.m3099b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1852y;
        this.f1852y = (z ? 1 : 0) | (this.f1852y & -2);
        if (i != this.f1852y) {
            this.f1828a.m3099b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1852y & 4) != 0) {
            this.f1828a.m3089a((MenuItem) this);
        } else {
            m3140b(z);
        }
        return this;
    }

    public /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        return mo503a(charSequence);
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1852y |= 16;
        } else {
            this.f1852y &= -17;
        }
        this.f1828a.m3099b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1840m = null;
        this.f1841n = i;
        this.f1851x = true;
        this.f1828a.m3099b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1841n = 0;
        this.f1840m = drawable;
        this.f1851x = true;
        this.f1828a.m3099b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1847t = colorStateList;
        this.f1849v = true;
        this.f1851x = true;
        this.f1828a.m3099b(false);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f1848u = mode;
        this.f1850w = true;
        this.f1851x = true;
        this.f1828a.m3099b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1835h = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1836i != c) {
            this.f1836i = c;
            this.f1828a.m3099b(false);
        }
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (!(this.f1836i == c && this.f1837j == i)) {
            this.f1836i = c;
            this.f1837j = KeyEvent.normalizeMetaState(i);
            this.f1828a.m3099b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.f1825C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1844q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1836i = c;
        this.f1838k = Character.toLowerCase(c2);
        this.f1828a.m3099b(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1836i = c;
        this.f1837j = KeyEvent.normalizeMetaState(i);
        this.f1838k = Character.toLowerCase(c2);
        this.f1839l = KeyEvent.normalizeMetaState(i2);
        this.f1828a.m3099b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1853z = i;
                this.f1828a.m3097b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3138b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1828a.m3108e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1833f = charSequence;
        this.f1828a.m3099b(false);
        if (this.f1842o != null) {
            this.f1842o.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1834g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1833f;
        }
        this.f1828a.m3099b(false);
        return this;
    }

    public /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        return mo505b(charSequence);
    }

    public MenuItem setVisible(boolean z) {
        if (m3143c(z)) {
            this.f1828a.m3086a(this);
        }
        return this;
    }

    public String toString() {
        return this.f1833f != null ? this.f1833f.toString() : null;
    }
}
