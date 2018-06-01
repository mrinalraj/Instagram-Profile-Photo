package android.support.v4.p008h.p019a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class C0380d {

    interface C0371a {
        Object mo232a(int i);

        List<Object> mo233a(String str, int i);

        boolean mo234a(int i, int i2, Bundle bundle);
    }

    public static Object m1753a(final C0371a c0371a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0371a.mo232a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0371a.mo233a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0371a.mo234a(i, i2, bundle);
            }
        };
    }
}
