package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p008h.C0397c;
import android.support.v4.p013b.C0190a;
import android.support.v4.p015d.p016a.C0302a;
import android.support.v7.p021a.C0529a.C0520b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class C0643h implements C0302a {
    private static final int[] f1788d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f1789a;
    Drawable f1790b;
    View f1791c;
    private final Context f1792e;
    private final Resources f1793f;
    private boolean f1794g;
    private boolean f1795h;
    private C0560a f1796i;
    private ArrayList<C0646j> f1797j;
    private ArrayList<C0646j> f1798k;
    private boolean f1799l;
    private ArrayList<C0646j> f1800m;
    private ArrayList<C0646j> f1801n;
    private boolean f1802o;
    private int f1803p = 0;
    private ContextMenuInfo f1804q;
    private boolean f1805r = false;
    private boolean f1806s = false;
    private boolean f1807t = false;
    private boolean f1808u = false;
    private boolean f1809v = false;
    private ArrayList<C0646j> f1810w = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<C0628o>> f1811x = new CopyOnWriteArrayList();
    private C0646j f1812y;
    private boolean f1813z;

    public interface C0560a {
        void mo429a(C0643h c0643h);

        boolean mo433a(C0643h c0643h, MenuItem menuItem);
    }

    public interface C0626b {
        boolean mo501a(C0646j c0646j);
    }

    public C0643h(Context context) {
        this.f1792e = context;
        this.f1793f = context.getResources();
        this.f1797j = new ArrayList();
        this.f1798k = new ArrayList();
        this.f1799l = true;
        this.f1800m = new ArrayList();
        this.f1801n = new ArrayList();
        this.f1802o = true;
        m3074e(true);
    }

    private static int m3068a(ArrayList<C0646j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0646j) arrayList.get(size)).m3142c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0646j m3069a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0646j(this, i, i2, i3, i4, charSequence, i5);
    }

    private void m3070a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m3105d();
        if (view != null) {
            this.f1791c = view;
            this.f1789a = null;
            this.f1790b = null;
        } else {
            if (i > 0) {
                this.f1789a = d.getText(i);
            } else if (charSequence != null) {
                this.f1789a = charSequence;
            }
            if (i2 > 0) {
                this.f1790b = C0190a.m865a(m3108e(), i2);
            } else if (drawable != null) {
                this.f1790b = drawable;
            }
            this.f1791c = null;
        }
        m3099b(false);
    }

    private void m3071a(int i, boolean z) {
        if (i >= 0 && i < this.f1797j.size()) {
            this.f1797j.remove(i);
            if (z) {
                m3099b(true);
            }
        }
    }

    private boolean m3072a(C0661u c0661u, C0628o c0628o) {
        boolean z = false;
        if (this.f1811x.isEmpty()) {
            return false;
        }
        if (c0628o != null) {
            z = c0628o.mo529a(c0661u);
        }
        Iterator it = this.f1811x.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0628o c0628o2 = (C0628o) weakReference.get();
            if (c0628o2 == null) {
                this.f1811x.remove(weakReference);
                z = z2;
            } else {
                z = !z2 ? c0628o2.mo529a(c0661u) : z2;
            }
            z2 = z;
        }
        return z2;
    }

    private void m3073d(boolean z) {
        if (!this.f1811x.isEmpty()) {
            m3111g();
            Iterator it = this.f1811x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.f1811x.remove(weakReference);
                } else {
                    c0628o.mo530b(z);
                }
            }
            m3112h();
        }
    }

    private void m3074e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1793f.getConfiguration().keyboard != 1 && this.f1793f.getBoolean(C0520b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1795h = z2;
    }

    private static int m3075f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1788d.length) {
            return (f1788d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public int m3076a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0646j) this.f1797j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public C0643h m3077a(int i) {
        this.f1803p = i;
        return this;
    }

    protected C0643h m3078a(Drawable drawable) {
        m3070a(0, null, 0, drawable, null);
        return this;
    }

    protected C0643h m3079a(View view) {
        m3070a(0, null, 0, null, view);
        return this;
    }

    protected C0643h m3080a(CharSequence charSequence) {
        m3070a(0, charSequence, 0, null, null);
        return this;
    }

    C0646j m3081a(int i, KeyEvent keyEvent) {
        List list = this.f1810w;
        list.clear();
        m3090a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0646j) list.get(0);
        }
        boolean b = mo563b();
        for (int i2 = 0; i2 < size; i2++) {
            C0646j c0646j = (C0646j) list.get(i2);
            char alphabeticShortcut = b ? c0646j.getAlphabeticShortcut() : c0646j.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0646j;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0646j;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0646j;
            }
        }
        return null;
    }

    protected MenuItem m3082a(int i, int i2, int i3, CharSequence charSequence) {
        int f = C0643h.m3075f(i3);
        MenuItem a = m3069a(i, i2, i3, f, charSequence, this.f1803p);
        if (this.f1804q != null) {
            a.m3136a(this.f1804q);
        }
        this.f1797j.add(C0643h.m3068a(this.f1797j, f), a);
        m3099b(true);
        return a;
    }

    protected String mo560a() {
        return "android:menu:actionviewstates";
    }

    public void m3084a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0661u) item.getSubMenu()).m3084a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo560a(), sparseArray);
        }
    }

    public void mo561a(C0560a c0560a) {
        this.f1796i = c0560a;
    }

    void m3086a(C0646j c0646j) {
        this.f1799l = true;
        m3099b(true);
    }

    public void m3087a(C0628o c0628o) {
        m3088a(c0628o, this.f1792e);
    }

    public void m3088a(C0628o c0628o, Context context) {
        this.f1811x.add(new WeakReference(c0628o));
        c0628o.mo525a(context, this);
        this.f1802o = true;
    }

    void m3089a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1797j.size();
        m3111g();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0646j) this.f1797j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m3149g() && menuItem2.isCheckable()) {
                menuItem2.m3140b(menuItem2 == menuItem);
            }
        }
        m3112h();
    }

    void m3090a(List<C0646j> list, int i, KeyEvent keyEvent) {
        boolean b = mo563b();
        int modifiers = keyEvent.getModifiers();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1797j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0646j c0646j = (C0646j) this.f1797j.get(i2);
                if (c0646j.hasSubMenu()) {
                    ((C0643h) c0646j.getSubMenu()).m3090a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0646j.getAlphabeticShortcut() : c0646j.getNumericShortcut();
                if (!(((modifiers & 69647) == ((b ? c0646j.getAlphabeticModifiers() : c0646j.getNumericModifiers()) & 69647) ? 1 : 0) == 0 || alphabeticShortcut == '\u0000' || ((alphabeticShortcut != keyData.meta[0] && alphabeticShortcut != keyData.meta[2] && (!b || alphabeticShortcut != '\b' || i != 67)) || !c0646j.isEnabled()))) {
                    list.add(c0646j);
                }
            }
        }
    }

    public final void m3091a(boolean z) {
        if (!this.f1809v) {
            this.f1809v = true;
            Iterator it = this.f1811x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.f1811x.remove(weakReference);
                } else {
                    c0628o.mo526a(this, z);
                }
            }
            this.f1809v = false;
        }
    }

    boolean mo562a(C0643h c0643h, MenuItem menuItem) {
        return this.f1796i != null && this.f1796i.mo433a(c0643h, menuItem);
    }

    public boolean m3093a(MenuItem menuItem, int i) {
        return m3094a(menuItem, null, i);
    }

    public boolean m3094a(MenuItem menuItem, C0628o c0628o, int i) {
        C0646j c0646j = (C0646j) menuItem;
        if (c0646j == null || !c0646j.isEnabled()) {
            return false;
        }
        boolean b = c0646j.m3141b();
        C0397c a = c0646j.mo504a();
        boolean z = a != null && a.mo552e();
        boolean expandActionView;
        if (c0646j.m3156n()) {
            expandActionView = c0646j.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m3091a(true);
            return expandActionView;
        } else if (c0646j.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                m3091a(false);
            }
            if (!c0646j.hasSubMenu()) {
                c0646j.m3135a(new C0661u(m3108e(), this, c0646j));
            }
            C0661u c0661u = (C0661u) c0646j.getSubMenu();
            if (z) {
                a.mo550a((SubMenu) c0661u);
            }
            expandActionView = m3072a(c0661u, c0628o) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m3091a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m3091a(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return m3082a(0, 0, 0, this.f1793f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3082a(i, i2, i3, this.f1793f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3082a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3082a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1792e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1793f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1793f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0646j c0646j = (C0646j) m3082a(i, i2, i3, charSequence);
        C0661u c0661u = new C0661u(this.f1792e, this, c0646j);
        c0646j.m3135a(c0661u);
        return c0661u;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int m3095b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0646j) this.f1797j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void m3096b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo560a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0661u) item.getSubMenu()).m3096b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    item.expandActionView();
                }
            }
        }
    }

    void m3097b(C0646j c0646j) {
        this.f1802o = true;
        m3099b(true);
    }

    public void m3098b(C0628o c0628o) {
        Iterator it = this.f1811x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0628o c0628o2 = (C0628o) weakReference.get();
            if (c0628o2 == null || c0628o2 == c0628o) {
                this.f1811x.remove(weakReference);
            }
        }
    }

    public void m3099b(boolean z) {
        if (this.f1805r) {
            this.f1806s = true;
            if (z) {
                this.f1807t = true;
                return;
            }
            return;
        }
        if (z) {
            this.f1799l = true;
            this.f1802o = true;
        }
        m3073d(z);
    }

    boolean mo563b() {
        return this.f1794g;
    }

    public int m3101c(int i) {
        return m3076a(i, 0);
    }

    public void m3102c(boolean z) {
        this.f1813z = z;
    }

    public boolean mo564c() {
        return this.f1795h;
    }

    public boolean mo565c(C0646j c0646j) {
        boolean z = false;
        if (!this.f1811x.isEmpty()) {
            m3111g();
            Iterator it = this.f1811x.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.f1811x.remove(weakReference);
                    z = z2;
                } else {
                    z = c0628o.mo528a(this, c0646j);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3112h();
            if (z) {
                this.f1812y = c0646j;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f1812y != null) {
            mo566d(this.f1812y);
        }
        this.f1797j.clear();
        m3099b(true);
    }

    public void clearHeader() {
        this.f1790b = null;
        this.f1789a = null;
        this.f1791c = null;
        m3099b(false);
    }

    public void close() {
        m3091a(true);
    }

    Resources m3105d() {
        return this.f1793f;
    }

    protected C0643h m3106d(int i) {
        m3070a(i, null, 0, null, null);
        return this;
    }

    public boolean mo566d(C0646j c0646j) {
        boolean z = false;
        if (!this.f1811x.isEmpty() && this.f1812y == c0646j) {
            m3111g();
            Iterator it = this.f1811x.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.f1811x.remove(weakReference);
                    z = z2;
                } else {
                    z = c0628o.mo532b(this, c0646j);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3112h();
            if (z) {
                this.f1812y = null;
            }
        }
        return z;
    }

    public Context m3108e() {
        return this.f1792e;
    }

    protected C0643h m3109e(int i) {
        m3070a(0, null, i, null, null);
        return this;
    }

    public void m3110f() {
        if (this.f1796i != null) {
            this.f1796i.mo429a(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0646j c0646j = (C0646j) this.f1797j.get(i2);
            if (c0646j.getItemId() == i) {
                return c0646j;
            }
            if (c0646j.hasSubMenu()) {
                MenuItem findItem = c0646j.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void m3111g() {
        if (!this.f1805r) {
            this.f1805r = true;
            this.f1806s = false;
            this.f1807t = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1797j.get(i);
    }

    public void m3112h() {
        this.f1805r = false;
        if (this.f1806s) {
            this.f1806s = false;
            m3099b(this.f1807t);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1813z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0646j) this.f1797j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<C0646j> m3113i() {
        if (!this.f1799l) {
            return this.f1798k;
        }
        this.f1798k.clear();
        int size = this.f1797j.size();
        for (int i = 0; i < size; i++) {
            C0646j c0646j = (C0646j) this.f1797j.get(i);
            if (c0646j.isVisible()) {
                this.f1798k.add(c0646j);
            }
        }
        this.f1799l = false;
        this.f1802o = true;
        return this.f1798k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3081a(i, keyEvent) != null;
    }

    public void m3114j() {
        ArrayList i = m3113i();
        if (this.f1802o) {
            Iterator it = this.f1811x.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0628o c0628o = (C0628o) weakReference.get();
                if (c0628o == null) {
                    this.f1811x.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0628o.mo531b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1800m.clear();
                this.f1801n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0646j c0646j = (C0646j) i.get(i4);
                    if (c0646j.m3152j()) {
                        this.f1800m.add(c0646j);
                    } else {
                        this.f1801n.add(c0646j);
                    }
                }
            } else {
                this.f1800m.clear();
                this.f1801n.clear();
                this.f1801n.addAll(m3113i());
            }
            this.f1802o = false;
        }
    }

    public ArrayList<C0646j> m3115k() {
        m3114j();
        return this.f1800m;
    }

    public ArrayList<C0646j> m3116l() {
        m3114j();
        return this.f1801n;
    }

    public CharSequence m3117m() {
        return this.f1789a;
    }

    public Drawable m3118n() {
        return this.f1790b;
    }

    public View m3119o() {
        return this.f1791c;
    }

    public C0643h mo567p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m3093a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m3081a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m3093a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m3091a(true);
        }
        return z;
    }

    boolean m3121q() {
        return this.f1808u;
    }

    public C0646j m3122r() {
        return this.f1812y;
    }

    public void removeGroup(int i) {
        int c = m3101c(i);
        if (c >= 0) {
            int size = this.f1797j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0646j) this.f1797j.get(c)).getGroupId() != i) {
                    m3099b(true);
                } else {
                    m3071a(c, false);
                    i2 = i3;
                }
            }
            m3099b(true);
        }
    }

    public void removeItem(int i) {
        m3071a(m3095b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1797j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0646j c0646j = (C0646j) this.f1797j.get(i2);
            if (c0646j.getGroupId() == i) {
                c0646j.m3137a(z2);
                c0646j.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1797j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0646j c0646j = (C0646j) this.f1797j.get(i2);
            if (c0646j.getGroupId() == i) {
                c0646j.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1797j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0646j c0646j = (C0646j) this.f1797j.get(i2);
            boolean z3 = (c0646j.getGroupId() == i && c0646j.m3143c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            m3099b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f1794g = z;
        m3099b(false);
    }

    public int size() {
        return this.f1797j.size();
    }
}
