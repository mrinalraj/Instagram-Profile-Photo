package android.support.v4.p008h;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class C0429t {
    static final C0426c f1071a;

    static class C0426c {
        C0426c() {
        }

        public void mo291a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0106l) {
                ((C0106l) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo292a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0106l) {
                ((C0106l) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo293a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0106l) {
                ((C0106l) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo294a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof C0106l ? ((C0106l) viewParent).onNestedPreFling(view, f, f2) : false;
        }

        public boolean mo295a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof C0106l ? ((C0106l) viewParent).onNestedFling(view, f, f2, z) : false;
        }

        public boolean mo296a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof C0106l ? ((C0106l) viewParent).onStartNestedScroll(view, view2, i) : false;
        }

        public void mo297b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0106l) {
                ((C0106l) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    static class C0427a extends C0426c {
        C0427a() {
        }
    }

    static class C0428b extends C0427a {
        C0428b() {
        }

        public void mo291a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStopNestedScroll", e);
            }
        }

        public void mo292a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScroll", e);
            }
        }

        public void mo293a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreScroll", e);
            }
        }

        public boolean mo294a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedPreFling", e);
                return false;
            }
        }

        public boolean mo295a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedFling", e);
                return false;
            }
        }

        public boolean mo296a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onStartNestedScroll", e);
                return false;
            }
        }

        public void mo297b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (Throwable e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface " + "method onNestedScrollAccepted", e);
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1071a = new C0428b();
        } else if (VERSION.SDK_INT >= 19) {
            f1071a = new C0427a();
        } else {
            f1071a = new C0426c();
        }
    }

    public static void m2002a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof C0410m) {
            ((C0410m) viewParent).m1836a(view, i);
        } else if (i == 0) {
            f1071a.mo291a(viewParent, view);
        }
    }

    public static void m2003a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof C0410m) {
            ((C0410m) viewParent).m1837a(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            f1071a.mo292a(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void m2004a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof C0410m) {
            ((C0410m) viewParent).m1838a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            f1071a.mo293a(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean m2005a(ViewParent viewParent, View view, float f, float f2) {
        return f1071a.mo294a(viewParent, view, f, f2);
    }

    public static boolean m2006a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1071a.mo295a(viewParent, view, f, f2, z);
    }

    public static boolean m2007a(ViewParent viewParent, View view, View view2, int i, int i2) {
        return viewParent instanceof C0410m ? ((C0410m) viewParent).m1839a(view, view2, i, i2) : i2 == 0 ? f1071a.mo296a(viewParent, view, view2, i) : false;
    }

    public static void m2008b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof C0410m) {
            ((C0410m) viewParent).m1840b(view, view2, i, i2);
        } else if (i2 == 0) {
            f1071a.mo297b(viewParent, view, view2, i);
        }
    }
}
