package android.support.v4.p008h.p019a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class C0382e {

    interface C0375a {
        Object mo236a(int i);

        List<Object> mo237a(String str, int i);

        boolean mo238a(int i, int i2, Bundle bundle);

        Object mo239b(int i);
    }

    public static Object m1754a(final C0375a c0375a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0375a.mo236a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0375a.mo237a(str, i);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) c0375a.mo239b(i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0375a.mo238a(i, i2, bundle);
            }
        };
    }
}
