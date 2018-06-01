package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.v4.p008h.C0397c;
import android.support.v4.p008h.C0406g;
import android.support.v4.p015d.p016a.C0302a;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.menu.C0646j;
import android.support.v7.view.menu.C0651k;
import android.support.v7.widget.al;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class C0620g extends MenuInflater {
    static final Class<?>[] f1642a = new Class[]{Context.class};
    static final Class<?>[] f1643b = f1642a;
    final Object[] f1644c;
    final Object[] f1645d = this.f1644c;
    Context f1646e;
    private Object f1647f;

    private static class C0618a implements OnMenuItemClickListener {
        private static final Class<?>[] f1607a = new Class[]{MenuItem.class};
        private Object f1608b;
        private Method f1609c;

        public C0618a(Object obj, String str) {
            this.f1608b = obj;
            Class cls = obj.getClass();
            try {
                this.f1609c = cls.getMethod(str, f1607a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1609c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1609c.invoke(this.f1608b, new Object[]{menuItem})).booleanValue();
                }
                this.f1609c.invoke(this.f1608b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class C0619b {
        private String f1610A;
        private String f1611B;
        private CharSequence f1612C;
        private CharSequence f1613D;
        private ColorStateList f1614E = null;
        private Mode f1615F = null;
        C0397c f1616a;
        final /* synthetic */ C0620g f1617b;
        private Menu f1618c;
        private int f1619d;
        private int f1620e;
        private int f1621f;
        private int f1622g;
        private boolean f1623h;
        private boolean f1624i;
        private boolean f1625j;
        private int f1626k;
        private int f1627l;
        private CharSequence f1628m;
        private CharSequence f1629n;
        private int f1630o;
        private char f1631p;
        private int f1632q;
        private char f1633r;
        private int f1634s;
        private int f1635t;
        private boolean f1636u;
        private boolean f1637v;
        private boolean f1638w;
        private int f1639x;
        private int f1640y;
        private String f1641z;

        public C0619b(C0620g c0620g, Menu menu) {
            this.f1617b = c0620g;
            this.f1618c = menu;
            m2909a();
        }

        private char m2906a(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        private <T> T m2907a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f1617b.f1646e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void m2908a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1636u).setVisible(this.f1637v).setEnabled(this.f1638w).setCheckable(this.f1635t >= 1).setTitleCondensed(this.f1629n).setIcon(this.f1630o);
            if (this.f1639x >= 0) {
                menuItem.setShowAsAction(this.f1639x);
            }
            if (this.f1611B != null) {
                if (this.f1617b.f1646e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0618a(this.f1617b.m2917a(), this.f1611B));
            }
            if (menuItem instanceof C0646j) {
                C0646j c0646j = (C0646j) menuItem;
            }
            if (this.f1635t >= 2) {
                if (menuItem instanceof C0646j) {
                    ((C0646j) menuItem).m3137a(true);
                } else if (menuItem instanceof C0651k) {
                    ((C0651k) menuItem).m3165a(true);
                }
            }
            if (this.f1641z != null) {
                menuItem.setActionView((View) m2907a(this.f1641z, C0620g.f1642a, this.f1617b.f1644c));
            } else {
                z = false;
            }
            if (this.f1640y > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(this.f1640y);
                }
            }
            if (this.f1616a != null) {
                C0406g.m1810a(menuItem, this.f1616a);
            }
            C0406g.m1814a(menuItem, this.f1612C);
            C0406g.m1816b(menuItem, this.f1613D);
            C0406g.m1815b(menuItem, this.f1631p, this.f1632q);
            C0406g.m1811a(menuItem, this.f1633r, this.f1634s);
            if (this.f1615F != null) {
                C0406g.m1813a(menuItem, this.f1615F);
            }
            if (this.f1614E != null) {
                C0406g.m1812a(menuItem, this.f1614E);
            }
        }

        public void m2909a() {
            this.f1619d = 0;
            this.f1620e = 0;
            this.f1621f = 0;
            this.f1622g = 0;
            this.f1623h = true;
            this.f1624i = true;
        }

        public void m2910a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f1617b.f1646e.obtainStyledAttributes(attributeSet, C0528j.MenuGroup);
            this.f1619d = obtainStyledAttributes.getResourceId(C0528j.MenuGroup_android_id, 0);
            this.f1620e = obtainStyledAttributes.getInt(C0528j.MenuGroup_android_menuCategory, 0);
            this.f1621f = obtainStyledAttributes.getInt(C0528j.MenuGroup_android_orderInCategory, 0);
            this.f1622g = obtainStyledAttributes.getInt(C0528j.MenuGroup_android_checkableBehavior, 0);
            this.f1623h = obtainStyledAttributes.getBoolean(C0528j.MenuGroup_android_visible, true);
            this.f1624i = obtainStyledAttributes.getBoolean(C0528j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m2911b() {
            this.f1625j = true;
            m2908a(this.f1618c.add(this.f1619d, this.f1626k, this.f1627l, this.f1628m));
        }

        public void m2912b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f1617b.f1646e.obtainStyledAttributes(attributeSet, C0528j.MenuItem);
            this.f1626k = obtainStyledAttributes.getResourceId(C0528j.MenuItem_android_id, 0);
            this.f1627l = (obtainStyledAttributes.getInt(C0528j.MenuItem_android_menuCategory, this.f1620e) & -65536) | (obtainStyledAttributes.getInt(C0528j.MenuItem_android_orderInCategory, this.f1621f) & 65535);
            this.f1628m = obtainStyledAttributes.getText(C0528j.MenuItem_android_title);
            this.f1629n = obtainStyledAttributes.getText(C0528j.MenuItem_android_titleCondensed);
            this.f1630o = obtainStyledAttributes.getResourceId(C0528j.MenuItem_android_icon, 0);
            this.f1631p = m2906a(obtainStyledAttributes.getString(C0528j.MenuItem_android_alphabeticShortcut));
            this.f1632q = obtainStyledAttributes.getInt(C0528j.MenuItem_alphabeticModifiers, 4096);
            this.f1633r = m2906a(obtainStyledAttributes.getString(C0528j.MenuItem_android_numericShortcut));
            this.f1634s = obtainStyledAttributes.getInt(C0528j.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(C0528j.MenuItem_android_checkable)) {
                this.f1635t = obtainStyledAttributes.getBoolean(C0528j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1635t = this.f1622g;
            }
            this.f1636u = obtainStyledAttributes.getBoolean(C0528j.MenuItem_android_checked, false);
            this.f1637v = obtainStyledAttributes.getBoolean(C0528j.MenuItem_android_visible, this.f1623h);
            this.f1638w = obtainStyledAttributes.getBoolean(C0528j.MenuItem_android_enabled, this.f1624i);
            this.f1639x = obtainStyledAttributes.getInt(C0528j.MenuItem_showAsAction, -1);
            this.f1611B = obtainStyledAttributes.getString(C0528j.MenuItem_android_onClick);
            this.f1640y = obtainStyledAttributes.getResourceId(C0528j.MenuItem_actionLayout, 0);
            this.f1641z = obtainStyledAttributes.getString(C0528j.MenuItem_actionViewClass);
            this.f1610A = obtainStyledAttributes.getString(C0528j.MenuItem_actionProviderClass);
            if (this.f1610A == null) {
                z = false;
            }
            if (z && this.f1640y == 0 && this.f1641z == null) {
                this.f1616a = (C0397c) m2907a(this.f1610A, C0620g.f1643b, this.f1617b.f1645d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1616a = null;
            }
            this.f1612C = obtainStyledAttributes.getText(C0528j.MenuItem_contentDescription);
            this.f1613D = obtainStyledAttributes.getText(C0528j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(C0528j.MenuItem_iconTintMode)) {
                this.f1615F = al.m4289a(obtainStyledAttributes.getInt(C0528j.MenuItem_iconTintMode, -1), this.f1615F);
            } else {
                this.f1615F = null;
            }
            if (obtainStyledAttributes.hasValue(C0528j.MenuItem_iconTint)) {
                this.f1614E = obtainStyledAttributes.getColorStateList(C0528j.MenuItem_iconTint);
            } else {
                this.f1614E = null;
            }
            obtainStyledAttributes.recycle();
            this.f1625j = false;
        }

        public SubMenu m2913c() {
            this.f1625j = true;
            SubMenu addSubMenu = this.f1618c.addSubMenu(this.f1619d, this.f1626k, this.f1627l, this.f1628m);
            m2908a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m2914d() {
            return this.f1625j;
        }
    }

    public C0620g(Context context) {
        super(context);
        this.f1646e = context;
        this.f1644c = new Object[]{context};
    }

    private Object m2915a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m2915a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2916a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00dd;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d5;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m2910a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m2912b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m2913c();
        r10.m2916a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m2909a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00c9;
    L_0x00ab:
        r3 = r7.m2914d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f1616a;
        if (r3 == 0) goto L_0x00c3;
    L_0x00b5:
        r3 = r7.f1616a;
        r3 = r3.mo552e();
        if (r3 == 0) goto L_0x00c3;
    L_0x00bd:
        r7.m2913c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c3:
        r7.m2911b();
        r3 = r5;
        goto L_0x0029;
    L_0x00c9:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d1:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d5:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00dd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object m2917a() {
        if (this.f1647f == null) {
            this.f1647f = m2915a(this.f1646e);
        }
        return this.f1647f;
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0302a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f1646e.getResources().getLayout(i);
                m2916a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
