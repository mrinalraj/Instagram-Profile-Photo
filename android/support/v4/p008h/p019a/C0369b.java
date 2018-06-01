package android.support.v4.p008h.p019a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class C0369b {
    static final C0358i f1023a;
    public int f1024b = -1;
    private final AccessibilityNodeInfo f1025c;

    static class C0358i {
        C0358i() {
        }

        public Object mo228a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public Object mo229a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public String mo227a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public void mo230a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }

        public void mo231b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }
    }

    static class C0359a extends C0358i {
        C0359a() {
        }
    }

    static class C0360b extends C0359a {
        C0360b() {
        }
    }

    static class C0361c extends C0360b {
        C0361c() {
        }

        public String mo227a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getViewIdResourceName();
        }
    }

    static class C0362d extends C0361c {
        C0362d() {
        }

        public Object mo228a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        public Object mo229a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, z);
        }

        public void mo230a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionInfo((CollectionInfo) obj);
        }

        public void mo231b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionItemInfo((CollectionItemInfo) obj);
        }
    }

    static class C0363e extends C0362d {
        C0363e() {
        }

        public Object mo228a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
        }

        public Object mo229a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, z, i3);
        }
    }

    static class C0364f extends C0363e {
        C0364f() {
        }
    }

    static class C0365g extends C0364f {
        C0365g() {
        }
    }

    static class C0366h extends C0365g {
        C0366h() {
        }
    }

    public static class C0367j {
        final Object f1021a;

        C0367j(Object obj) {
            this.f1021a = obj;
        }

        public static C0367j m1700a(int i, int i2, boolean z, int i3) {
            return new C0367j(C0369b.f1023a.mo229a(i, i2, z, i3));
        }
    }

    public static class C0368k {
        final Object f1022a;

        C0368k(Object obj) {
            this.f1022a = obj;
        }

        public static C0368k m1701a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new C0368k(C0369b.f1023a.mo228a(i, i2, i3, i4, z, z2));
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            f1023a = new C0366h();
        } else if (VERSION.SDK_INT >= 23) {
            f1023a = new C0365g();
        } else if (VERSION.SDK_INT >= 22) {
            f1023a = new C0364f();
        } else if (VERSION.SDK_INT >= 21) {
            f1023a = new C0363e();
        } else if (VERSION.SDK_INT >= 19) {
            f1023a = new C0362d();
        } else if (VERSION.SDK_INT >= 18) {
            f1023a = new C0361c();
        } else if (VERSION.SDK_INT >= 17) {
            f1023a = new C0360b();
        } else if (VERSION.SDK_INT >= 16) {
            f1023a = new C0359a();
        } else {
            f1023a = new C0358i();
        }
    }

    private C0369b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1025c = accessibilityNodeInfo;
    }

    public static C0369b m1702a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0369b(accessibilityNodeInfo);
    }

    private static String m1703b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public AccessibilityNodeInfo m1704a() {
        return this.f1025c;
    }

    public void m1705a(int i) {
        this.f1025c.addAction(i);
    }

    public void m1706a(Rect rect) {
        this.f1025c.getBoundsInParent(rect);
    }

    public void m1707a(CharSequence charSequence) {
        this.f1025c.setClassName(charSequence);
    }

    public void m1708a(Object obj) {
        f1023a.mo230a(this.f1025c, ((C0367j) obj).f1021a);
    }

    public void m1709a(boolean z) {
        this.f1025c.setCheckable(z);
    }

    public int m1710b() {
        return this.f1025c.getActions();
    }

    public void m1711b(Rect rect) {
        this.f1025c.getBoundsInScreen(rect);
    }

    public void m1712b(Object obj) {
        f1023a.mo231b(this.f1025c, ((C0368k) obj).f1022a);
    }

    public void m1713b(boolean z) {
        this.f1025c.setChecked(z);
    }

    public void m1714c(boolean z) {
        this.f1025c.setScrollable(z);
    }

    public boolean m1715c() {
        return this.f1025c.isCheckable();
    }

    public boolean m1716d() {
        return this.f1025c.isChecked();
    }

    public boolean m1717e() {
        return this.f1025c.isFocusable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0369b c0369b = (C0369b) obj;
        return this.f1025c == null ? c0369b.f1025c == null : this.f1025c.equals(c0369b.f1025c);
    }

    public boolean m1718f() {
        return this.f1025c.isFocused();
    }

    public boolean m1719g() {
        return this.f1025c.isSelected();
    }

    public boolean m1720h() {
        return this.f1025c.isClickable();
    }

    public int hashCode() {
        return this.f1025c == null ? 0 : this.f1025c.hashCode();
    }

    public boolean m1721i() {
        return this.f1025c.isLongClickable();
    }

    public boolean m1722j() {
        return this.f1025c.isEnabled();
    }

    public boolean m1723k() {
        return this.f1025c.isPassword();
    }

    public boolean m1724l() {
        return this.f1025c.isScrollable();
    }

    public CharSequence m1725m() {
        return this.f1025c.getPackageName();
    }

    public CharSequence m1726n() {
        return this.f1025c.getClassName();
    }

    public CharSequence m1727o() {
        return this.f1025c.getText();
    }

    public CharSequence m1728p() {
        return this.f1025c.getContentDescription();
    }

    public String m1729q() {
        return f1023a.mo227a(this.f1025c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1706a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m1711b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m1725m());
        stringBuilder.append("; className: ").append(m1726n());
        stringBuilder.append("; text: ").append(m1727o());
        stringBuilder.append("; contentDescription: ").append(m1728p());
        stringBuilder.append("; viewId: ").append(m1729q());
        stringBuilder.append("; checkable: ").append(m1715c());
        stringBuilder.append("; checked: ").append(m1716d());
        stringBuilder.append("; focusable: ").append(m1717e());
        stringBuilder.append("; focused: ").append(m1718f());
        stringBuilder.append("; selected: ").append(m1719g());
        stringBuilder.append("; clickable: ").append(m1720h());
        stringBuilder.append("; longClickable: ").append(m1721i());
        stringBuilder.append("; enabled: ").append(m1722j());
        stringBuilder.append("; password: ").append(m1723k());
        stringBuilder.append("; scrollable: " + m1724l());
        stringBuilder.append("; [");
        int b = m1710b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0369b.m1703b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
