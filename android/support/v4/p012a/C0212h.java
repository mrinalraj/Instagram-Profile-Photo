package android.support.v4.p012a;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.C0013b;
import android.arch.lifecycle.C0013b.C0011a;
import android.arch.lifecycle.C0014c;
import android.arch.lifecycle.C0017d;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p008h.C0401e;
import android.support.v4.p018g.C0331l;
import android.support.v4.p018g.C0336d;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0212h implements C0014c, ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0331l<String, Class<?>> f619V = new C0331l();
    static final Object f620a = new Object();
    boolean f621A;
    boolean f622B;
    boolean f623C;
    boolean f624D;
    boolean f625E = true;
    boolean f626F;
    ViewGroup f627G;
    View f628H;
    View f629I;
    boolean f630J;
    boolean f631K = true;
    C0258v f632L;
    boolean f633M;
    boolean f634N;
    C0209a f635O;
    boolean f636P;
    boolean f637Q;
    float f638R;
    LayoutInflater f639S;
    boolean f640T;
    C0017d f641U = new C0017d(this);
    int f642b = 0;
    Bundle f643c;
    SparseArray<Parcelable> f644d;
    int f645e = -1;
    String f646f;
    Bundle f647g;
    C0212h f648h;
    int f649i = -1;
    int f650j;
    boolean f651k;
    boolean f652l;
    boolean f653m;
    boolean f654n;
    boolean f655o;
    boolean f656p;
    int f657q;
    C0233n f658r;
    C0214l f659s;
    C0233n f660t;
    C0234o f661u;
    C0212h f662v;
    int f663w;
    int f664x;
    String f665y;
    boolean f666z;

    class C02061 implements Runnable {
        final /* synthetic */ C0212h f598a;

        C02061(C0212h c0212h) {
            this.f598a = c0212h;
        }

        public void run() {
            this.f598a.m920W();
        }
    }

    class C02082 extends C0207j {
        final /* synthetic */ C0212h f599a;

        C02082(C0212h c0212h) {
            this.f599a = c0212h;
        }

        public C0212h mo158a(Context context, String str, Bundle bundle) {
            return this.f599a.f659s.mo158a(context, str, bundle);
        }

        public View mo159a(int i) {
            if (this.f599a.f628H != null) {
                return this.f599a.f628H.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean mo160a() {
            return this.f599a.f628H != null;
        }
    }

    static class C0209a {
        View f600a;
        Animator f601b;
        int f602c;
        int f603d;
        int f604e;
        int f605f;
        C0261y f606g = null;
        C0261y f607h = null;
        boolean f608i;
        C0211c f609j;
        boolean f610k;
        private Object f611l = null;
        private Object f612m = C0212h.f620a;
        private Object f613n = null;
        private Object f614o = C0212h.f620a;
        private Object f615p = null;
        private Object f616q = C0212h.f620a;
        private Boolean f617r;
        private Boolean f618s;

        C0209a() {
        }
    }

    public static class C0210b extends RuntimeException {
        public C0210b(String str, Exception exception) {
            super(str, exception);
        }
    }

    interface C0211c {
        void mo179a();

        void mo180b();
    }

    private void m920W() {
        C0211c c0211c = null;
        if (this.f635O != null) {
            this.f635O.f608i = false;
            C0211c c0211c2 = this.f635O.f609j;
            this.f635O.f609j = null;
            c0211c = c0211c2;
        }
        if (c0211c != null) {
            c0211c.mo179a();
        }
    }

    private C0209a m921X() {
        if (this.f635O == null) {
            this.f635O = new C0209a();
        }
        return this.f635O;
    }

    public static C0212h m922a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f619V.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f619V.put(str, cls);
            }
            C0212h c0212h = (C0212h) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(c0212h.getClass().getClassLoader());
                c0212h.m975b(bundle);
            }
            return c0212h;
        } catch (Exception e) {
            throw new C0210b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0210b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0210b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        } catch (Exception e222) {
            throw new C0210b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e222);
        } catch (Exception e2222) {
            throw new C0210b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e2222);
        }
    }

    static boolean m923a(Context context, String str) {
        try {
            Class cls = (Class) f619V.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f619V.put(str, cls);
            }
            return C0212h.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public void m925A() {
        if (this.f658r == null || this.f658r.f736m == null) {
            m921X().f608i = false;
        } else if (Looper.myLooper() != this.f658r.f736m.m1040h().getLooper()) {
            this.f658r.f736m.m1040h().postAtFrontOfQueue(new C02061(this));
        } else {
            m920W();
        }
    }

    void m926B() {
        if (this.f659s == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.f660t = new C0233n();
        this.f660t.m1176a(this.f659s, new C02082(this), this);
    }

    void m927C() {
        if (this.f660t != null) {
            this.f660t.m1220k();
            this.f660t.m1206e();
        }
        this.f642b = 4;
        this.f626F = false;
        m1003j();
        if (this.f626F) {
            if (this.f660t != null) {
                this.f660t.m1227n();
            }
            if (this.f632L != null) {
                this.f632L.m1324g();
            }
            this.f641U.m33a(C0011a.ON_START);
            return;
        }
        throw new C0262z("Fragment " + this + " did not call through to super.onStart()");
    }

    void m928D() {
        if (this.f660t != null) {
            this.f660t.m1220k();
            this.f660t.m1206e();
        }
        this.f642b = 5;
        this.f626F = false;
        m1005k();
        if (this.f626F) {
            if (this.f660t != null) {
                this.f660t.m1228o();
                this.f660t.m1206e();
            }
            this.f641U.m33a(C0011a.ON_RESUME);
            return;
        }
        throw new C0262z("Fragment " + this + " did not call through to super.onResume()");
    }

    void m929E() {
        if (this.f660t != null) {
            this.f660t.m1220k();
        }
    }

    void m930F() {
        onLowMemory();
        if (this.f660t != null) {
            this.f660t.m1235u();
        }
    }

    void m931G() {
        this.f641U.m33a(C0011a.ON_PAUSE);
        if (this.f660t != null) {
            this.f660t.m1230p();
        }
        this.f642b = 4;
        this.f626F = false;
        m1007l();
        if (!this.f626F) {
            throw new C0262z("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m932H() {
        this.f641U.m33a(C0011a.ON_STOP);
        if (this.f660t != null) {
            this.f660t.m1231q();
        }
        this.f642b = 3;
        this.f626F = false;
        m1009m();
        if (!this.f626F) {
            throw new C0262z("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m933I() {
        if (this.f660t != null) {
            this.f660t.m1232r();
        }
        this.f642b = 2;
        if (this.f633M) {
            this.f633M = false;
            if (!this.f634N) {
                this.f634N = true;
                this.f632L = this.f659s.m1024a(this.f646f, this.f633M, false);
            }
            if (this.f632L == null) {
                return;
            }
            if (this.f659s.m1042j()) {
                this.f632L.m1321d();
            } else {
                this.f632L.m1320c();
            }
        }
    }

    void m934J() {
        if (this.f660t != null) {
            this.f660t.m1233s();
        }
        this.f642b = 1;
        this.f626F = false;
        m1011n();
        if (this.f626F) {
            if (this.f632L != null) {
                this.f632L.m1323f();
            }
            this.f656p = false;
            return;
        }
        throw new C0262z("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    void m935K() {
        this.f641U.m33a(C0011a.ON_DESTROY);
        if (this.f660t != null) {
            this.f660t.m1234t();
        }
        this.f642b = 0;
        this.f626F = false;
        this.f640T = false;
        m1012o();
        if (this.f626F) {
            this.f660t = null;
            return;
        }
        throw new C0262z("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void m936L() {
        this.f626F = false;
        m1014q();
        this.f639S = null;
        if (!this.f626F) {
            throw new C0262z("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.f660t == null) {
        } else {
            if (this.f623C) {
                this.f660t.m1234t();
                this.f660t = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }

    int m937M() {
        return this.f635O == null ? 0 : this.f635O.f603d;
    }

    int m938N() {
        return this.f635O == null ? 0 : this.f635O.f604e;
    }

    int m939O() {
        return this.f635O == null ? 0 : this.f635O.f605f;
    }

    C0261y m940P() {
        return this.f635O == null ? null : this.f635O.f606g;
    }

    C0261y m941Q() {
        return this.f635O == null ? null : this.f635O.f607h;
    }

    View m942R() {
        return this.f635O == null ? null : this.f635O.f600a;
    }

    Animator m943S() {
        return this.f635O == null ? null : this.f635O.f601b;
    }

    int m944T() {
        return this.f635O == null ? 0 : this.f635O.f602c;
    }

    boolean m945U() {
        return this.f635O == null ? false : this.f635O.f608i;
    }

    boolean m946V() {
        return this.f635O == null ? false : this.f635O.f610k;
    }

    public C0013b mo156a() {
        return this.f641U;
    }

    C0212h m948a(String str) {
        return str.equals(this.f646f) ? this : this.f660t != null ? this.f660t.m1186b(str) : null;
    }

    public View m949a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation m950a(int i, boolean z, int i2) {
        return null;
    }

    void m951a(int i) {
        if (this.f635O != null || i != 0) {
            m921X().f603d = i;
        }
    }

    void m952a(int i, int i2) {
        if (this.f635O != null || i != 0 || i2 != 0) {
            m921X();
            this.f635O.f604e = i;
            this.f635O.f605f = i2;
        }
    }

    public void m953a(int i, int i2, Intent intent) {
    }

    final void m954a(int i, C0212h c0212h) {
        this.f645e = i;
        if (c0212h != null) {
            this.f646f = c0212h.f646f + ":" + this.f645e;
        } else {
            this.f646f = "android:fragment:" + this.f645e;
        }
    }

    public void m955a(int i, String[] strArr, int[] iArr) {
    }

    void m956a(Animator animator) {
        m921X().f601b = animator;
    }

    @Deprecated
    public void m957a(Activity activity) {
        this.f626F = true;
    }

    @Deprecated
    public void m958a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f626F = true;
    }

    public void m959a(Context context) {
        this.f626F = true;
        Activity f = this.f659s == null ? null : this.f659s.m1038f();
        if (f != null) {
            this.f626F = false;
            m957a(f);
        }
    }

    public void m960a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f626F = true;
        Activity f = this.f659s == null ? null : this.f659s.m1038f();
        if (f != null) {
            this.f626F = false;
            m958a(f, attributeSet, bundle);
        }
    }

    void m961a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f660t != null) {
            this.f660t.m1166a(configuration);
        }
    }

    final void m962a(Bundle bundle) {
        if (this.f644d != null) {
            this.f629I.restoreHierarchyState(this.f644d);
            this.f644d = null;
        }
        this.f626F = false;
        m1002i(bundle);
        if (!this.f626F) {
            throw new C0262z("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    void m963a(C0211c c0211c) {
        m921X();
        if (c0211c != this.f635O.f609j) {
            if (c0211c == null || this.f635O.f609j == null) {
                if (this.f635O.f608i) {
                    this.f635O.f609j = c0211c;
                }
                if (c0211c != null) {
                    c0211c.mo180b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void m964a(C0212h c0212h) {
    }

    public void m965a(Menu menu) {
    }

    public void m966a(Menu menu, MenuInflater menuInflater) {
    }

    void m967a(View view) {
        m921X().f600a = view;
    }

    public void m968a(View view, Bundle bundle) {
    }

    public void m969a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f663w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f664x));
        printWriter.print(" mTag=");
        printWriter.println(this.f665y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f642b);
        printWriter.print(" mIndex=");
        printWriter.print(this.f645e);
        printWriter.print(" mWho=");
        printWriter.print(this.f646f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f657q);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f651k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f652l);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f653m);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f654n);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f666z);
        printWriter.print(" mDetached=");
        printWriter.print(this.f621A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f625E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f624D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f622B);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f623C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f631K);
        if (this.f658r != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f658r);
        }
        if (this.f659s != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f659s);
        }
        if (this.f662v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f662v);
        }
        if (this.f647g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f647g);
        }
        if (this.f643c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f643c);
        }
        if (this.f644d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f644d);
        }
        if (this.f648h != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f648h);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f650j);
        }
        if (m937M() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(m937M());
        }
        if (this.f627G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f627G);
        }
        if (this.f628H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f628H);
        }
        if (this.f629I != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f628H);
        }
        if (m942R() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(m942R());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(m944T());
        }
        if (this.f632L != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f632L.m1317a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f660t != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f660t + ":");
            this.f660t.mo181a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void m970a(boolean z) {
    }

    public boolean m971a(MenuItem menuItem) {
        return false;
    }

    public Animator m972b(int i, boolean z, int i2) {
        return null;
    }

    View m973b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f660t != null) {
            this.f660t.m1220k();
        }
        this.f656p = true;
        return m949a(layoutInflater, viewGroup, bundle);
    }

    void m974b(int i) {
        m921X().f602c = i;
    }

    public void m975b(Bundle bundle) {
        if (this.f645e < 0 || !m983c()) {
            this.f647g = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    public void m976b(Menu menu) {
    }

    public void m977b(boolean z) {
    }

    final boolean m978b() {
        return this.f657q > 0;
    }

    boolean m979b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f666z) {
            return false;
        }
        if (this.f624D && this.f625E) {
            z = true;
            m966a(menu, menuInflater);
        }
        return this.f660t != null ? z | this.f660t.m1182a(menu, menuInflater) : z;
    }

    public boolean m980b(MenuItem menuItem) {
        return false;
    }

    public LayoutInflater m981c(Bundle bundle) {
        return m992e(bundle);
    }

    public void m982c(boolean z) {
    }

    public final boolean m983c() {
        return this.f658r == null ? false : this.f658r.mo184c();
    }

    boolean m984c(Menu menu) {
        boolean z = false;
        if (this.f666z) {
            return false;
        }
        if (this.f624D && this.f625E) {
            z = true;
            m965a(menu);
        }
        return this.f660t != null ? z | this.f660t.m1181a(menu) : z;
    }

    boolean m985c(MenuItem menuItem) {
        if (!this.f666z) {
            if (this.f624D && this.f625E && m971a(menuItem)) {
                return true;
            }
            if (this.f660t != null && this.f660t.m1183a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final C0217i m986d() {
        return this.f659s == null ? null : (C0217i) this.f659s.m1038f();
    }

    LayoutInflater m987d(Bundle bundle) {
        this.f639S = m981c(bundle);
        return this.f639S;
    }

    void m988d(Menu menu) {
        if (!this.f666z) {
            if (this.f624D && this.f625E) {
                m976b(menu);
            }
            if (this.f660t != null) {
                this.f660t.m1192b(menu);
            }
        }
    }

    void m989d(boolean z) {
        m977b(z);
        if (this.f660t != null) {
            this.f660t.m1178a(z);
        }
    }

    boolean m990d(MenuItem menuItem) {
        if (!this.f666z) {
            if (m980b(menuItem)) {
                return true;
            }
            if (this.f660t != null && this.f660t.m1194b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final Resources m991e() {
        if (this.f659s != null) {
            return this.f659s.m1039g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater m992e(Bundle bundle) {
        if (this.f659s == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater b = this.f659s.mo163b();
        m997g();
        C0401e.m1789b(b, this.f660t.m1237w());
        return b;
    }

    void m993e(boolean z) {
        m982c(z);
        if (this.f660t != null) {
            this.f660t.m1193b(z);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final C0221m m994f() {
        return this.f658r;
    }

    public void m995f(Bundle bundle) {
        this.f626F = true;
        m998g(bundle);
        if (this.f660t != null && !this.f660t.m1180a(1)) {
            this.f660t.m1222l();
        }
    }

    void m996f(boolean z) {
        m921X().f610k = z;
    }

    public final C0221m m997g() {
        if (this.f660t == null) {
            m926B();
            if (this.f642b >= 5) {
                this.f660t.m1228o();
            } else if (this.f642b >= 4) {
                this.f660t.m1227n();
            } else if (this.f642b >= 2) {
                this.f660t.m1224m();
            } else if (this.f642b >= 1) {
                this.f660t.m1222l();
            }
        }
        return this.f660t;
    }

    void m998g(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f660t == null) {
                    m926B();
                }
                this.f660t.m1168a(parcelable, this.f661u);
                this.f661u = null;
                this.f660t.m1222l();
            }
        }
    }

    C0221m m999h() {
        return this.f660t;
    }

    public void m1000h(Bundle bundle) {
        this.f626F = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public View m1001i() {
        return this.f628H;
    }

    public void m1002i(Bundle bundle) {
        this.f626F = true;
    }

    public void m1003j() {
        this.f626F = true;
        if (!this.f633M) {
            this.f633M = true;
            if (!this.f634N) {
                this.f634N = true;
                this.f632L = this.f659s.m1024a(this.f646f, this.f633M, false);
            } else if (this.f632L != null) {
                this.f632L.m1319b();
            }
        }
    }

    public void m1004j(Bundle bundle) {
    }

    public void m1005k() {
        this.f626F = true;
    }

    void m1006k(Bundle bundle) {
        if (this.f660t != null) {
            this.f660t.m1220k();
        }
        this.f642b = 1;
        this.f626F = false;
        m995f(bundle);
        this.f640T = true;
        if (this.f626F) {
            this.f641U.m33a(C0011a.ON_CREATE);
            return;
        }
        throw new C0262z("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void m1007l() {
        this.f626F = true;
    }

    void m1008l(Bundle bundle) {
        if (this.f660t != null) {
            this.f660t.m1220k();
        }
        this.f642b = 2;
        this.f626F = false;
        m1000h(bundle);
        if (!this.f626F) {
            throw new C0262z("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f660t != null) {
            this.f660t.m1224m();
        }
    }

    public void m1009m() {
        this.f626F = true;
    }

    void m1010m(Bundle bundle) {
        m1004j(bundle);
        if (this.f660t != null) {
            Parcelable j = this.f660t.m1218j();
            if (j != null) {
                bundle.putParcelable("android:support:fragments", j);
            }
        }
    }

    public void m1011n() {
        this.f626F = true;
    }

    public void m1012o() {
        this.f626F = true;
        if (!this.f634N) {
            this.f634N = true;
            this.f632L = this.f659s.m1024a(this.f646f, this.f633M, false);
        }
        if (this.f632L != null) {
            this.f632L.m1325h();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f626F = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m986d().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.f626F = true;
    }

    void m1013p() {
        this.f645e = -1;
        this.f646f = null;
        this.f651k = false;
        this.f652l = false;
        this.f653m = false;
        this.f654n = false;
        this.f655o = false;
        this.f657q = 0;
        this.f658r = null;
        this.f660t = null;
        this.f659s = null;
        this.f663w = 0;
        this.f664x = 0;
        this.f665y = null;
        this.f666z = false;
        this.f621A = false;
        this.f623C = false;
        this.f632L = null;
        this.f633M = false;
        this.f634N = false;
    }

    public void m1014q() {
        this.f626F = true;
    }

    public void m1015r() {
    }

    public Object m1016s() {
        return this.f635O == null ? null : this.f635O.f611l;
    }

    public Object m1017t() {
        return this.f635O == null ? null : this.f635O.f612m == f620a ? m1016s() : this.f635O.f612m;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0336d.m1635a(this, stringBuilder);
        if (this.f645e >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f645e);
        }
        if (this.f663w != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f663w));
        }
        if (this.f665y != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f665y);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object m1018u() {
        return this.f635O == null ? null : this.f635O.f613n;
    }

    public Object m1019v() {
        return this.f635O == null ? null : this.f635O.f614o == f620a ? m1018u() : this.f635O.f614o;
    }

    public Object m1020w() {
        return this.f635O == null ? null : this.f635O.f615p;
    }

    public Object m1021x() {
        return this.f635O == null ? null : this.f635O.f616q == f620a ? m1020w() : this.f635O.f616q;
    }

    public boolean m1022y() {
        return (this.f635O == null || this.f635O.f618s == null) ? true : this.f635O.f618s.booleanValue();
    }

    public boolean m1023z() {
        return (this.f635O == null || this.f635O.f617r == null) ? true : this.f635O.f617r.booleanValue();
    }
}
