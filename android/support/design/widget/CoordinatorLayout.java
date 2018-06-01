package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.C0066a.C0064i;
import android.support.design.C0066a.C0065j;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v4.p008h.C0079a;
import android.support.v4.p008h.C0097o;
import android.support.v4.p008h.C0106l;
import android.support.v4.p008h.C0398d;
import android.support.v4.p008h.C0407h;
import android.support.v4.p008h.C0411n;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0435y;
import android.support.v4.p009e.C0077c;
import android.support.v4.p009e.C0309b;
import android.support.v4.p013b.C0190a;
import android.support.v4.p018g.C0349j.C0346a;
import android.support.v4.p018g.C0349j.C0348c;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C0106l {
    static final String f329a;
    static final Class<?>[] f330b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<C0081a>>> f331c = new ThreadLocal();
    static final Comparator<View> f332d;
    private static final C0346a<Rect> f333f = new C0348c(12);
    OnHierarchyChangeListener f334e;
    private final List<View> f335g;
    private final C0138e<View> f336h;
    private final List<View> f337i;
    private final List<View> f338j;
    private final int[] f339k;
    private Paint f340l;
    private boolean f341m;
    private boolean f342n;
    private int[] f343o;
    private View f344p;
    private View f345q;
    private View f346r;
    private C0102e f347s;
    private boolean f348t;
    private C0435y f349u;
    private boolean f350v;
    private Drawable f351w;
    private C0097o f352x;
    private final C0411n f353y;

    public static abstract class C0081a<V extends View> {
        public C0081a(Context context, AttributeSet attributeSet) {
        }

        public C0435y m321a(CoordinatorLayout coordinatorLayout, V v, C0435y c0435y) {
            return c0435y;
        }

        public void mo91a(C0101d c0101d) {
        }

        public void mo45a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void mo46a(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void mo47a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void mo48a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public boolean mo38a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean mo50a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean mo92a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean mo59a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean mo39a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo71a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean mo51a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean mo52a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public Parcelable mo55b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        public void m336b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean mo40b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean mo62b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public int m339c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public void m340c() {
        }

        public boolean mo63c(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public float m342d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void mo825d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean m344e(CoordinatorLayout coordinatorLayout, V v) {
            return m342d(coordinatorLayout, v) > 0.0f;
        }
    }

    class C00981 implements C0097o {
        final /* synthetic */ CoordinatorLayout f308a;

        C00981(CoordinatorLayout coordinatorLayout) {
            this.f308a = coordinatorLayout;
        }

        public C0435y mo81a(View view, C0435y c0435y) {
            return this.f308a.m539a(c0435y);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface C0099b {
        Class<? extends C0081a> m488a();
    }

    private class C0100c implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout f309a;

        C0100c(CoordinatorLayout coordinatorLayout) {
            this.f309a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.f309a.f334e != null) {
                this.f309a.f334e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f309a.m541a(2);
            if (this.f309a.f334e != null) {
                this.f309a.f334e.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class C0101d extends MarginLayoutParams {
        C0081a f310a;
        boolean f311b = false;
        public int f312c = 0;
        public int f313d = 0;
        public int f314e = -1;
        int f315f = -1;
        public int f316g = 0;
        public int f317h = 0;
        int f318i;
        int f319j;
        View f320k;
        View f321l;
        final Rect f322m = new Rect();
        Object f323n;
        private boolean f324o;
        private boolean f325p;
        private boolean f326q;

        public C0101d(int i, int i2) {
            super(i, i2);
        }

        C0101d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.CoordinatorLayout_Layout);
            this.f312c = obtainStyledAttributes.getInteger(C0065j.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f315f = obtainStyledAttributes.getResourceId(C0065j.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f313d = obtainStyledAttributes.getInteger(C0065j.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f314e = obtainStyledAttributes.getInteger(C0065j.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f316g = obtainStyledAttributes.getInt(C0065j.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f317h = obtainStyledAttributes.getInt(C0065j.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f311b = obtainStyledAttributes.hasValue(C0065j.CoordinatorLayout_Layout_layout_behavior);
            if (this.f311b) {
                this.f310a = CoordinatorLayout.m514a(context, attributeSet, obtainStyledAttributes.getString(C0065j.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.f310a != null) {
                this.f310a.mo91a(this);
            }
        }

        public C0101d(C0101d c0101d) {
            super(c0101d);
        }

        public C0101d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0101d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        private void m489a(View view, CoordinatorLayout coordinatorLayout) {
            this.f320k = coordinatorLayout.findViewById(this.f315f);
            if (this.f320k != null) {
                if (this.f320k != coordinatorLayout) {
                    View view2 = this.f320k;
                    View parent = this.f320k.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f321l = null;
                            this.f320k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f321l = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f321l = null;
                    this.f320k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f321l = null;
                this.f320k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f315f) + " to anchor view " + view);
            }
        }

        private boolean m490a(View view, int i) {
            int a = C0398d.m1784a(((C0101d) view.getLayoutParams()).f316g, i);
            return a != 0 && (C0398d.m1784a(this.f317h, i) & a) == a;
        }

        private boolean m491b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f320k.getId() != this.f315f) {
                return false;
            }
            View view2 = this.f320k;
            View parent = this.f320k.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.f321l = null;
                    this.f320k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.f321l = view2;
            return true;
        }

        public int m492a() {
            return this.f315f;
        }

        void m493a(Rect rect) {
            this.f322m.set(rect);
        }

        public void m494a(C0081a c0081a) {
            if (this.f310a != c0081a) {
                if (this.f310a != null) {
                    this.f310a.m340c();
                }
                this.f310a = c0081a;
                this.f323n = null;
                this.f311b = true;
                if (c0081a != null) {
                    c0081a.mo91a(this);
                }
            }
        }

        void m495a(boolean z) {
            this.f325p = z;
        }

        boolean m496a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f324o) {
                return true;
            }
            boolean e = (this.f310a != null ? this.f310a.m344e(coordinatorLayout, view) : 0) | this.f324o;
            this.f324o = e;
            return e;
        }

        boolean m497a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f321l || m490a(view2, C0425s.m1966f(coordinatorLayout)) || (this.f310a != null && this.f310a.mo62b(coordinatorLayout, view, view2));
        }

        public C0081a m498b() {
            return this.f310a;
        }

        View m499b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f315f == -1) {
                this.f321l = null;
                this.f320k = null;
                return null;
            }
            if (this.f320k == null || !m491b(view, coordinatorLayout)) {
                m489a(view, coordinatorLayout);
            }
            return this.f320k;
        }

        void m500b(boolean z) {
            this.f326q = z;
        }

        Rect m501c() {
            return this.f322m;
        }

        boolean m502d() {
            return this.f320k == null && this.f315f != -1;
        }

        boolean m503e() {
            if (this.f310a == null) {
                this.f324o = false;
            }
            return this.f324o;
        }

        void m504f() {
            this.f324o = false;
        }

        void m505g() {
            this.f325p = false;
        }

        boolean m506h() {
            return this.f325p;
        }

        boolean m507i() {
            return this.f326q;
        }

        void m508j() {
            this.f326q = false;
        }
    }

    class C0102e implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout f327a;

        C0102e(CoordinatorLayout coordinatorLayout) {
            this.f327a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.f327a.m541a(0);
            return true;
        }
    }

    protected static class C0104f extends C0079a {
        public static final Creator<C0104f> CREATOR = C0309b.m1523a(new C01031());
        SparseArray<Parcelable> f328a;

        static class C01031 implements C0077c<C0104f> {
            C01031() {
            }

            public C0104f m509a(Parcel parcel, ClassLoader classLoader) {
                return new C0104f(parcel, classLoader);
            }

            public C0104f[] m510a(int i) {
                return new C0104f[i];
            }

            public /* synthetic */ Object mo35b(Parcel parcel, ClassLoader classLoader) {
                return m509a(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo36b(int i) {
                return m510a(i);
            }
        }

        public C0104f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f328a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f328a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public C0104f(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f328a != null ? this.f328a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f328a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f328a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static class C0105g implements Comparator<View> {
        C0105g() {
        }

        public int m513a(View view, View view2) {
            float z = C0425s.m1987z(view);
            float z2 = C0425s.m1987z(view2);
            return z > z2 ? -1 : z < z2 ? 1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m513a((View) obj, (View) obj2);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f329a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f332d = new C0105g();
        } else {
            f332d = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.f335g = new ArrayList();
        this.f336h = new C0138e();
        this.f337i = new ArrayList();
        this.f338j = new ArrayList();
        this.f339k = new int[2];
        this.f353y = new C0411n(this);
        C0165q.m782a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.CoordinatorLayout, i, C0064i.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(C0065j.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f343o = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f343o.length;
            while (i2 < length) {
                int[] iArr = this.f343o;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f351w = obtainStyledAttributes.getDrawable(C0065j.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        m535h();
        super.setOnHierarchyChangeListener(new C0100c(this));
    }

    static C0081a m514a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f329a)) {
            str = f329a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) f331c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f331c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(f330b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0081a) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static void m515a(Rect rect) {
        rect.setEmpty();
        f333f.mo224a(rect);
    }

    private void m516a(C0101d c0101d, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + c0101d.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - c0101d.rightMargin));
        height = Math.max(getPaddingTop() + c0101d.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - c0101d.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    private void m517a(View view, int i, Rect rect, Rect rect2, C0101d c0101d, int i2, int i3) {
        int a = C0398d.m1784a(m529e(c0101d.f312c), i);
        int a2 = C0398d.m1784a(m525c(c0101d.f313d), i);
        int i4 = a & 7;
        int i5 = a & 112;
        int i6 = a2 & 112;
        switch (a2 & 7) {
            case 1:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i6) {
            case 16:
                a = rect.top + (rect.height() / 2);
                break;
            case 80:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i4) {
            case 1:
                a2 -= i2 / 2;
                break;
            case 5:
                break;
            default:
                a2 -= i2;
                break;
        }
        switch (i5) {
            case 16:
                a -= i3 / 2;
                break;
            case 80:
                break;
            default:
                a -= i3;
                break;
        }
        rect2.set(a2, a, a2 + i2, a + i3);
    }

    private void m518a(View view, Rect rect, int i) {
        if (C0425s.m1986y(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0101d c0101d = (C0101d) view.getLayoutParams();
            C0081a b = c0101d.m498b();
            Rect e = m530e();
            Rect e2 = m530e();
            e2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b == null || !b.mo92a(this, view, e)) {
                e.set(e2);
            } else if (!e2.contains(e)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e.toShortString() + " | Bounds:" + e2.toShortString());
            }
            m515a(e2);
            if (e.isEmpty()) {
                m515a(e);
                return;
            }
            int i2;
            int height;
            int width;
            int a = C0398d.m1784a(c0101d.f317h, i);
            if ((a & 48) == 48) {
                i2 = (e.top - c0101d.topMargin) - c0101d.f319j;
                if (i2 < rect.top) {
                    m531e(view, rect.top - i2);
                    i2 = 1;
                    if ((a & 80) == 80) {
                        height = ((getHeight() - e.bottom) - c0101d.bottomMargin) + c0101d.f319j;
                        if (height < rect.bottom) {
                            m531e(view, height - rect.bottom);
                            i2 = 1;
                        }
                    }
                    if (i2 == 0) {
                        m531e(view, 0);
                    }
                    if ((a & 3) == 3) {
                        i2 = (e.left - c0101d.leftMargin) - c0101d.f318i;
                        if (i2 < rect.left) {
                            m528d(view, rect.left - i2);
                            i2 = 1;
                            if ((a & 5) == 5) {
                                width = c0101d.f318i + ((getWidth() - e.right) - c0101d.rightMargin);
                                if (width < rect.right) {
                                    m528d(view, width - rect.right);
                                    width = 1;
                                    if (width == 0) {
                                        m528d(view, 0);
                                    }
                                    m515a(e);
                                }
                            }
                            width = i2;
                            if (width == 0) {
                                m528d(view, 0);
                            }
                            m515a(e);
                        }
                    }
                    i2 = 0;
                    if ((a & 5) == 5) {
                        width = c0101d.f318i + ((getWidth() - e.right) - c0101d.rightMargin);
                        if (width < rect.right) {
                            m528d(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                m528d(view, 0);
                            }
                            m515a(e);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        m528d(view, 0);
                    }
                    m515a(e);
                }
            }
            i2 = 0;
            if ((a & 80) == 80) {
                height = ((getHeight() - e.bottom) - c0101d.bottomMargin) + c0101d.f319j;
                if (height < rect.bottom) {
                    m531e(view, height - rect.bottom);
                    i2 = 1;
                }
            }
            if (i2 == 0) {
                m531e(view, 0);
            }
            if ((a & 3) == 3) {
                i2 = (e.left - c0101d.leftMargin) - c0101d.f318i;
                if (i2 < rect.left) {
                    m528d(view, rect.left - i2);
                    i2 = 1;
                    if ((a & 5) == 5) {
                        width = c0101d.f318i + ((getWidth() - e.right) - c0101d.rightMargin);
                        if (width < rect.right) {
                            m528d(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                m528d(view, 0);
                            }
                            m515a(e);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        m528d(view, 0);
                    }
                    m515a(e);
                }
            }
            i2 = 0;
            if ((a & 5) == 5) {
                width = c0101d.f318i + ((getWidth() - e.right) - c0101d.rightMargin);
                if (width < rect.right) {
                    m528d(view, width - rect.right);
                    width = 1;
                    if (width == 0) {
                        m528d(view, 0);
                    }
                    m515a(e);
                }
            }
            width = i2;
            if (width == 0) {
                m528d(view, 0);
            }
            m515a(e);
        }
    }

    private void m519a(View view, View view2, int i) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        Rect e = m530e();
        Rect e2 = m530e();
        try {
            m545a(view2, e);
            m544a(view, i, e, e2);
            view.layout(e2.left, e2.top, e2.right, e2.bottom);
        } finally {
            m515a(e);
            m515a(e2);
        }
    }

    private void m520a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (f332d != null) {
            Collections.sort(list, f332d);
        }
    }

    private boolean m521a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int a = C0407h.m1818a(motionEvent);
        List list = this.f337i;
        m520a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            C0101d c0101d = (C0101d) view.getLayoutParams();
            C0081a b = c0101d.m498b();
            if ((!z2 && obj == null) || a == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case 0:
                            z2 = b.mo39a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = b.mo40b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.f344p = view;
                    }
                }
                z = z2;
                boolean e = c0101d.m503e();
                boolean a2 = c0101d.m496a(this, view);
                Object obj3 = (!a2 || e) ? null : 1;
                if (a2 && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        b.mo39a(this, view, motionEvent3);
                        break;
                    case 1:
                        b.mo40b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private int m522b(int i) {
        if (this.f343o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.f343o.length) {
            return this.f343o[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    private C0435y m523b(C0435y c0435y) {
        if (c0435y.m2033e()) {
            return c0435y;
        }
        C0435y a;
        int childCount = getChildCount();
        int i = 0;
        C0435y c0435y2 = c0435y;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (C0425s.m1980s(childAt)) {
                C0081a b = ((C0101d) childAt.getLayoutParams()).m498b();
                if (b != null) {
                    a = b.m321a(this, childAt, c0435y2);
                    if (a.m2033e()) {
                        break;
                    }
                    i++;
                    c0435y2 = a;
                }
            }
            a = c0435y2;
            i++;
            c0435y2 = a;
        }
        a = c0435y2;
        return a;
    }

    private void m524b(View view, int i, int i2) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        int a = C0398d.m1784a(m527d(c0101d.f312c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b = m522b(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case 1:
                b += measuredWidth / 2;
                break;
            case 5:
                b += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                a = 0 + (measuredHeight / 2);
                break;
            case 80:
                a = 0 + measuredHeight;
                break;
        }
        b = Math.max(getPaddingLeft() + c0101d.leftMargin, Math.min(b, ((width - getPaddingRight()) - measuredWidth) - c0101d.rightMargin));
        int max = Math.max(getPaddingTop() + c0101d.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - c0101d.bottomMargin));
        view.layout(b, max, b + measuredWidth, max + measuredHeight);
    }

    private static int m525c(int i) {
        return i == 0 ? 8388659 : i;
    }

    private void m526c(View view, int i) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        Rect e = m530e();
        e.set(getPaddingLeft() + c0101d.leftMargin, getPaddingTop() + c0101d.topMargin, (getWidth() - getPaddingRight()) - c0101d.rightMargin, (getHeight() - getPaddingBottom()) - c0101d.bottomMargin);
        if (!(this.f349u == null || !C0425s.m1980s(this) || C0425s.m1980s(view))) {
            e.left += this.f349u.m2028a();
            e.top += this.f349u.m2030b();
            e.right -= this.f349u.m2031c();
            e.bottom -= this.f349u.m2032d();
        }
        Rect e2 = m530e();
        C0398d.m1785a(m525c(c0101d.f312c), view.getMeasuredWidth(), view.getMeasuredHeight(), e, e2, i);
        view.layout(e2.left, e2.top, e2.right, e2.bottom);
        m515a(e);
        m515a(e2);
    }

    private static int m527d(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void m528d(View view, int i) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        if (c0101d.f318i != i) {
            C0425s.m1967f(view, i - c0101d.f318i);
            c0101d.f318i = i;
        }
    }

    private static int m529e(int i) {
        return i == 0 ? 17 : i;
    }

    private static Rect m530e() {
        Rect rect = (Rect) f333f.mo223a();
        return rect == null ? new Rect() : rect;
    }

    private void m531e(View view, int i) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        if (c0101d.f319j != i) {
            C0425s.m1965e(view, i - c0101d.f319j);
            c0101d.f319j = i;
        }
    }

    private boolean m532e(View view) {
        return this.f336h.m673e(view);
    }

    private void m533f() {
        if (this.f344p != null) {
            C0081a b = ((C0101d) this.f344p.getLayoutParams()).m498b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.mo40b(this, this.f344p, obtain);
                obtain.recycle();
            }
            this.f344p = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((C0101d) getChildAt(i).getLayoutParams()).m504f();
        }
        this.f341m = false;
    }

    private void m534g() {
        this.f335g.clear();
        this.f336h.m666a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            m537a((View) childAt).m499b(this, (View) childAt);
            this.f336h.m667a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    Object childAt2 = getChildAt(i2);
                    if (m537a((View) childAt2).m497a(this, childAt2, childAt)) {
                        if (!this.f336h.m670b(childAt2)) {
                            this.f336h.m667a(childAt2);
                        }
                        this.f336h.m668a(childAt, childAt2);
                    }
                }
            }
        }
        this.f335g.addAll(this.f336h.m669b());
        Collections.reverse(this.f335g);
    }

    private void m535h() {
        if (VERSION.SDK_INT >= 21) {
            if (C0425s.m1980s(this)) {
                if (this.f352x == null) {
                    this.f352x = new C00981(this);
                }
                C0425s.m1949a((View) this, this.f352x);
                setSystemUiVisibility(1280);
                return;
            }
            C0425s.m1949a((View) this, null);
        }
    }

    public C0101d m536a(AttributeSet attributeSet) {
        return new C0101d(getContext(), attributeSet);
    }

    C0101d m537a(View view) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        if (!c0101d.f311b) {
            C0099b c0099b = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                c0099b = (C0099b) cls.getAnnotation(C0099b.class);
                if (c0099b != null) {
                    break;
                }
            }
            C0099b c0099b2 = c0099b;
            if (c0099b2 != null) {
                try {
                    c0101d.m494a((C0081a) c0099b2.m488a().newInstance());
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + c0099b2.m488a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0101d.f311b = true;
        }
        return c0101d;
    }

    protected C0101d m538a(LayoutParams layoutParams) {
        return layoutParams instanceof C0101d ? new C0101d((C0101d) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0101d((MarginLayoutParams) layoutParams) : new C0101d(layoutParams);
    }

    final C0435y m539a(C0435y c0435y) {
        boolean z = true;
        if (C0185y.m861a(this.f349u, (Object) c0435y)) {
            return c0435y;
        }
        this.f349u = c0435y;
        boolean z2 = c0435y != null && c0435y.m2030b() > 0;
        this.f350v = z2;
        if (this.f350v || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        c0435y = m523b(c0435y);
        requestLayout();
        return c0435y;
    }

    void m540a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m532e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.f348t) {
            return;
        }
        if (z) {
            m548b();
        } else {
            m553c();
        }
    }

    final void m541a(int i) {
        int f = C0425s.m1966f(this);
        int size = this.f335g.size();
        Rect e = m530e();
        Rect e2 = m530e();
        Rect e3 = m530e();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f335g.get(i2);
            C0101d c0101d = (C0101d) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int i3;
                for (i3 = 0; i3 < i2; i3++) {
                    if (c0101d.f321l == ((View) this.f335g.get(i3))) {
                        m550b(view, f);
                    }
                }
                m546a(view, true, e2);
                if (!(c0101d.f316g == 0 || e2.isEmpty())) {
                    int a = C0398d.m1784a(c0101d.f316g, f);
                    switch (a & 112) {
                        case 48:
                            e.top = Math.max(e.top, e2.bottom);
                            break;
                        case 80:
                            e.bottom = Math.max(e.bottom, getHeight() - e2.top);
                            break;
                    }
                    switch (a & 7) {
                        case 3:
                            e.left = Math.max(e.left, e2.right);
                            break;
                        case 5:
                            e.right = Math.max(e.right, getWidth() - e2.left);
                            break;
                    }
                }
                if (c0101d.f317h != 0 && view.getVisibility() == 0) {
                    m518a(view, e, f);
                }
                if (i == 0) {
                    m554c(view, e3);
                    if (!e3.equals(e2)) {
                        m551b(view, e2);
                    }
                }
                for (i3 = i2 + 1; i3 < size; i3++) {
                    View view2 = (View) this.f335g.get(i3);
                    C0101d c0101d2 = (C0101d) view2.getLayoutParams();
                    C0081a b = c0101d2.m498b();
                    if (b != null && b.mo62b(this, view2, view)) {
                        if (i == 0 && c0101d2.m507i()) {
                            c0101d2.m508j();
                        } else {
                            boolean z;
                            switch (i) {
                                case 2:
                                    b.mo825d(this, view2, view);
                                    z = true;
                                    break;
                                default:
                                    z = b.mo63c(this, view2, view);
                                    break;
                            }
                            if (i == 1) {
                                c0101d2.m500b(z);
                            }
                        }
                    }
                }
            }
        }
        m515a(e);
        m515a(e2);
        m515a(e3);
    }

    public void m542a(View view, int i) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        if (c0101d.m502d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c0101d.f320k != null) {
            m519a(view, c0101d.f320k, i);
        } else if (c0101d.f314e >= 0) {
            m524b(view, c0101d.f314e, i);
        } else {
            m526c(view, i);
        }
    }

    public void m543a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void m544a(View view, int i, Rect rect, Rect rect2) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m517a(view, i, rect, rect2, c0101d, measuredWidth, measuredHeight);
        m516a(c0101d, rect2, measuredWidth, measuredHeight);
    }

    void m545a(View view, Rect rect) {
        C0181u.m850b(this, view, rect);
    }

    void m546a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            m545a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean m547a(View view, int i, int i2) {
        Rect e = m530e();
        m545a(view, e);
        try {
            boolean contains = e.contains(i, i2);
            return contains;
        } finally {
            m515a(e);
        }
    }

    void m548b() {
        if (this.f342n) {
            if (this.f347s == null) {
                this.f347s = new C0102e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f347s);
        }
        this.f348t = true;
    }

    public void m549b(View view) {
        List c = this.f336h.m671c(view);
        if (c != null && !c.isEmpty()) {
            for (int i = 0; i < c.size(); i++) {
                View view2 = (View) c.get(i);
                C0081a b = ((C0101d) view2.getLayoutParams()).m498b();
                if (b != null) {
                    b.mo63c(this, view2, view);
                }
            }
        }
    }

    void m550b(View view, int i) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        if (c0101d.f320k != null) {
            Rect e = m530e();
            Rect e2 = m530e();
            Rect e3 = m530e();
            m545a(c0101d.f320k, e);
            m546a(view, false, e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m517a(view, i, e, e3, c0101d, measuredWidth, measuredHeight);
            boolean z = (e3.left == e2.left && e3.top == e2.top) ? false : true;
            m516a(c0101d, e3, measuredWidth, measuredHeight);
            int i2 = e3.left - e2.left;
            int i3 = e3.top - e2.top;
            if (i2 != 0) {
                C0425s.m1967f(view, i2);
            }
            if (i3 != 0) {
                C0425s.m1965e(view, i3);
            }
            if (z) {
                C0081a b = c0101d.m498b();
                if (b != null) {
                    b.mo63c(this, view, c0101d.f320k);
                }
            }
            m515a(e);
            m515a(e2);
            m515a(e3);
        }
    }

    void m551b(View view, Rect rect) {
        ((C0101d) view.getLayoutParams()).m493a(rect);
    }

    public List<View> m552c(View view) {
        Collection d = this.f336h.m672d(view);
        this.f338j.clear();
        if (d != null) {
            this.f338j.addAll(d);
        }
        return this.f338j;
    }

    void m553c() {
        if (this.f342n && this.f347s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f347s);
        }
        this.f348t = false;
    }

    void m554c(View view, Rect rect) {
        rect.set(((C0101d) view.getLayoutParams()).m501c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0101d) && super.checkLayoutParams(layoutParams);
    }

    protected C0101d m555d() {
        return new C0101d(-2, -2);
    }

    public List<View> m556d(View view) {
        Collection c = this.f336h.m671c(view);
        this.f338j.clear();
        if (c != null) {
            this.f338j.addAll(c);
        }
        return this.f338j;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        C0101d c0101d = (C0101d) view.getLayoutParams();
        if (c0101d.f310a != null) {
            float d = c0101d.f310a.m342d(this, view);
            if (d > 0.0f) {
                if (this.f340l == null) {
                    this.f340l = new Paint();
                }
                this.f340l.setColor(c0101d.f310a.m339c(this, view));
                this.f340l.setAlpha(C0156l.m747a(Math.round(d * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f340l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f351w;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m555d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m536a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m538a(layoutParams);
    }

    final List<View> getDependencySortedChildren() {
        m534g();
        return Collections.unmodifiableList(this.f335g);
    }

    final C0435y getLastWindowInsets() {
        return this.f349u;
    }

    public int getNestedScrollAxes() {
        return this.f353y.m1841a();
    }

    public Drawable getStatusBarBackground() {
        return this.f351w;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m533f();
        if (this.f348t) {
            if (this.f347s == null) {
                this.f347s = new C0102e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f347s);
        }
        if (this.f349u == null && C0425s.m1980s(this)) {
            C0425s.m1979r(this);
        }
        this.f342n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m533f();
        if (this.f348t && this.f347s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f347s);
        }
        if (this.f346r != null) {
            onStopNestedScroll(this.f346r);
        }
        this.f342n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f350v && this.f351w != null) {
            int b = this.f349u != null ? this.f349u.m2030b() : 0;
            if (b > 0) {
                this.f351w.setBounds(0, 0, getWidth(), b);
                this.f351w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int a = C0407h.m1818a(motionEvent);
        if (a == 0) {
            m533f();
        }
        boolean a2 = m521a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (a == 1 || a == 3) {
            m533f();
        }
        return a2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int f = C0425s.m1966f(this);
        int size = this.f335g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f335g.get(i5);
            if (view.getVisibility() != 8) {
                C0081a b = ((C0101d) view.getLayoutParams()).m498b();
                if (b == null || !b.mo38a(this, view, f)) {
                    m542a(view, f);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m534g();
        m540a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int f = C0425s.m1966f(this);
        Object obj = f == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i5 = 0;
        Object obj2 = (this.f349u == null || !C0425s.m1980s(this)) ? null : 1;
        int size3 = this.f335g.size();
        int i6 = 0;
        while (i6 < size3) {
            int i7;
            View view = (View) this.f335g.get(i6);
            if (view.getVisibility() == 8) {
                i7 = i5;
                paddingTop = suggestedMinimumHeight;
                paddingBottom = suggestedMinimumWidth;
            } else {
                int i8;
                int i9;
                C0101d c0101d = (C0101d) view.getLayoutParams();
                int i10 = 0;
                if (c0101d.f314e >= 0 && mode != 0) {
                    i7 = m522b(c0101d.f314e);
                    paddingTop = C0398d.m1784a(m527d(c0101d.f312c), f) & 7;
                    if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                        i10 = Math.max(0, (size - paddingRight) - i7);
                    } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                        i10 = Math.max(0, i7 - paddingLeft);
                    }
                }
                if (obj2 == null || C0425s.m1980s(view)) {
                    i8 = i2;
                    i9 = i;
                } else {
                    paddingTop = this.f349u.m2030b() + this.f349u.m2032d();
                    i9 = MeasureSpec.makeMeasureSpec(size - (this.f349u.m2028a() + this.f349u.m2031c()), mode);
                    i8 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
                }
                C0081a b = c0101d.m498b();
                if (b == null || !b.mo50a(this, view, i9, i10, i8, 0)) {
                    m543a(view, i9, i10, i8, 0);
                }
                i9 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i3) + c0101d.leftMargin) + c0101d.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i4) + c0101d.topMargin) + c0101d.bottomMargin);
                i7 = C0425s.m1939a(i5, C0425s.m1968g(view));
                paddingBottom = i9;
            }
            i6++;
            i5 = i7;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = paddingBottom;
        }
        setMeasuredDimension(C0425s.m1940a(suggestedMinimumWidth, i, -16777216 & i5), C0425s.m1940a(suggestedMinimumHeight, i2, i5 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean z3;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z3 = z2;
            } else {
                C0101d c0101d = (C0101d) childAt.getLayoutParams();
                if (c0101d.m506h()) {
                    C0081a b = c0101d.m498b();
                    z3 = b != null ? b.mo51a(this, childAt, view, f, f2, z) | z2 : z2;
                } else {
                    z3 = z2;
                }
            }
            i++;
            z2 = z3;
        }
        if (z2) {
            m541a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean z2;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                C0101d c0101d = (C0101d) childAt.getLayoutParams();
                if (c0101d.m506h()) {
                    C0081a b = c0101d.m498b();
                    z2 = b != null ? b.mo71a(this, childAt, view, f, f2) | z : z;
                } else {
                    z2 = z;
                }
            }
            i++;
            z = z2;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3 = 0;
        int i4 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            int i6;
            int i7;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
                i6 = i3;
                i7 = i4;
            } else {
                C0101d c0101d = (C0101d) childAt.getLayoutParams();
                if (c0101d.m506h()) {
                    C0081a b = c0101d.m498b();
                    if (b != null) {
                        int[] iArr2 = this.f339k;
                        this.f339k[1] = 0;
                        iArr2[0] = 0;
                        b.mo48a(this, childAt, view, i, i2, this.f339k);
                        i6 = i > 0 ? Math.max(i3, this.f339k[0]) : Math.min(i3, this.f339k[0]);
                        i7 = i2 > 0 ? Math.max(i4, this.f339k[1]) : Math.min(i4, this.f339k[1]);
                        int i8 = 1;
                    } else {
                        obj2 = obj;
                        i6 = i3;
                        i7 = i4;
                    }
                } else {
                    obj2 = obj;
                    i6 = i3;
                    i7 = i4;
                }
            }
            i5++;
            i4 = i7;
            i3 = i6;
            obj = obj2;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        if (obj != null) {
            m541a(1);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Object obj = null;
        int i5 = 0;
        while (i5 < childCount) {
            Object obj2;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
            } else {
                C0101d c0101d = (C0101d) childAt.getLayoutParams();
                if (c0101d.m506h()) {
                    C0081a b = c0101d.m498b();
                    if (b != null) {
                        b.mo47a(this, childAt, view, i, i2, i3, i4);
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                } else {
                    obj2 = obj;
                }
            }
            i5++;
            obj = obj2;
        }
        if (obj != null) {
            m541a(1);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f353y.m1844a(view, view2, i);
        this.f345q = view;
        this.f346r = view2;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0101d c0101d = (C0101d) childAt.getLayoutParams();
            if (c0101d.m506h()) {
                C0081a b = c0101d.m498b();
                if (b != null) {
                    b.m336b(this, childAt, view, view2, i);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0104f) {
            C0104f c0104f = (C0104f) parcelable;
            super.onRestoreInstanceState(c0104f.m320a());
            SparseArray sparseArray = c0104f.f328a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                C0081a b = m537a(childAt).m498b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.mo45a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0104f = new C0104f(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0081a b = ((C0101d) childAt.getLayoutParams()).m498b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.mo55b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        c0104f.f328a = sparseArray;
        return c0104f;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        int childCount = getChildCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < childCount) {
            boolean z2;
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                C0101d c0101d = (C0101d) childAt.getLayoutParams();
                C0081a b = c0101d.m498b();
                if (b != null) {
                    boolean a = b.mo52a(this, childAt, view, view2, i);
                    z2 = z | a;
                    c0101d.m495a(a);
                } else {
                    c0101d.m495a(false);
                    z2 = z;
                }
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        this.f353y.m1842a(view);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0101d c0101d = (C0101d) childAt.getLayoutParams();
            if (c0101d.m506h()) {
                C0081a b = c0101d.m498b();
                if (b != null) {
                    b.mo46a(this, childAt, view);
                }
                c0101d.m505g();
                c0101d.m508j();
            }
        }
        this.f345q = null;
        this.f346r = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = null;
        int a = C0407h.m1818a(motionEvent);
        boolean z2;
        MotionEvent obtain;
        if (this.f344p == null) {
            boolean a2 = m521a(motionEvent, 1);
            if (a2) {
                z2 = a2;
            } else {
                z2 = a2;
                z = false;
                if (this.f344p == null) {
                    z |= super.onTouchEvent(motionEvent);
                } else if (z2) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z || a == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (a == 1 || a == 3) {
                        m533f();
                    }
                    return z;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                m533f();
                return z;
            }
        }
        z2 = false;
        C0081a b = ((C0101d) this.f344p.getLayoutParams()).m498b();
        z = b != null ? b.mo40b(this, this.f344p, motionEvent) : false;
        if (this.f344p == null) {
            z |= super.onTouchEvent(motionEvent);
        } else if (z2) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        m533f();
        return z;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        C0081a b = ((C0101d) view.getLayoutParams()).m498b();
        return (b == null || !b.mo59a(this, view, rect, z)) ? super.requestChildRectangleOnScreen(view, rect, z) : true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f341m) {
            m533f();
            this.f341m = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m535h();
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f334e = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f351w != drawable) {
            if (this.f351w != null) {
                this.f351w.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f351w = drawable2;
            if (this.f351w != null) {
                if (this.f351w.isStateful()) {
                    this.f351w.setState(getDrawableState());
                }
                C0279a.m1427b(this.f351w, C0425s.m1966f(this));
                this.f351w.setVisible(getVisibility() == 0, false);
                this.f351w.setCallback(this);
            }
            C0425s.m1958c(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0190a.m865a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f351w != null && this.f351w.isVisible() != z) {
            this.f351w.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f351w;
    }
}
