package android.support.v4.p008h;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p008h.p019a.C0369b;
import android.support.v4.p008h.p019a.C0378c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class C0067b {
    private static final C0388b f144a;
    private static final AccessibilityDelegate f145c = new AccessibilityDelegate();
    final AccessibilityDelegate f146b = f144a.mo243a(this);

    static class C0388b {
        C0388b() {
        }

        public C0378c mo242a(AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public AccessibilityDelegate mo243a(final C0067b c0067b) {
            return new AccessibilityDelegate(this) {
                final /* synthetic */ C0388b f1039b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0067b.m163c(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0067b.mo72a(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0067b.mo25a(view, C0369b.m1702a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0067b.m164d(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0067b.m161a(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    c0067b.m157a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0067b.m162b(view, accessibilityEvent);
                }
            };
        }

        public boolean mo244a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class C0389a extends C0388b {
        C0389a() {
        }

        public C0378c mo242a(AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            return accessibilityNodeProvider != null ? new C0378c(accessibilityNodeProvider) : null;
        }

        public AccessibilityDelegate mo243a(final C0067b c0067b) {
            return new AccessibilityDelegate(this) {
                final /* synthetic */ C0389a f1037b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0067b.m163c(view, accessibilityEvent);
                }

                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    C0378c a = c0067b.m155a(view);
                    return a != null ? (AccessibilityNodeProvider) a.m1749a() : null;
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0067b.mo72a(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0067b.mo25a(view, C0369b.m1702a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0067b.m164d(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0067b.m161a(viewGroup, view, accessibilityEvent);
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return c0067b.mo368a(view, i, bundle);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    c0067b.m157a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0067b.m162b(view, accessibilityEvent);
                }
            };
        }

        public boolean mo244a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f144a = new C0389a();
        } else {
            f144a = new C0388b();
        }
    }

    public C0378c m155a(View view) {
        return f144a.mo242a(f145c, view);
    }

    AccessibilityDelegate m156a() {
        return this.f146b;
    }

    public void m157a(View view, int i) {
        f145c.sendAccessibilityEvent(view, i);
    }

    public void mo25a(View view, C0369b c0369b) {
        f145c.onInitializeAccessibilityNodeInfo(view, c0369b.m1704a());
    }

    public void mo72a(View view, AccessibilityEvent accessibilityEvent) {
        f145c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean mo368a(View view, int i, Bundle bundle) {
        return f144a.mo244a(f145c, view, i, bundle);
    }

    public boolean m161a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f145c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void m162b(View view, AccessibilityEvent accessibilityEvent) {
        f145c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean m163c(View view, AccessibilityEvent accessibilityEvent) {
        return f145c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void m164d(View view, AccessibilityEvent accessibilityEvent) {
        f145c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
}
