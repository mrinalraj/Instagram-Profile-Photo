package android.support.v4.p012a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p008h.C0425s;
import android.support.v4.p012a.C0212h.C0211c;
import android.support.v4.p012a.C0221m.C0219a;
import android.support.v4.p012a.C0221m.C0220b;
import android.support.v4.p018g.C0334b;
import android.support.v4.p018g.C0336d;
import android.support.v4.p018g.C0337e;
import android.support.v4.p018g.C0345i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class C0233n extends C0221m implements Factory2 {
    static final Interpolator f714E = new DecelerateInterpolator(2.5f);
    static final Interpolator f715F = new DecelerateInterpolator(1.5f);
    static final Interpolator f716G = new AccelerateInterpolator(2.5f);
    static final Interpolator f717H = new AccelerateInterpolator(1.5f);
    static boolean f718a = false;
    static Field f719q = null;
    SparseArray<Parcelable> f720A = null;
    ArrayList<C0232g> f721B;
    C0234o f722C;
    Runnable f723D = new C02221(this);
    private final CopyOnWriteArrayList<C0345i<C0219a, Boolean>> f724I = new CopyOnWriteArrayList();
    ArrayList<C0198f> f725b;
    boolean f726c;
    int f727d = 0;
    final ArrayList<C0212h> f728e = new ArrayList();
    SparseArray<C0212h> f729f;
    ArrayList<C0199c> f730g;
    ArrayList<C0212h> f731h;
    ArrayList<C0199c> f732i;
    ArrayList<Integer> f733j;
    ArrayList<C0220b> f734k;
    int f735l = 0;
    C0214l f736m;
    C0207j f737n;
    C0212h f738o;
    C0212h f739p;
    boolean f740r;
    boolean f741s;
    boolean f742t;
    String f743u;
    boolean f744v;
    ArrayList<C0199c> f745w;
    ArrayList<Boolean> f746x;
    ArrayList<C0212h> f747y;
    Bundle f748z = null;

    interface C0198f {
        boolean mo157a(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2);
    }

    class C02221 implements Runnable {
        final /* synthetic */ C0233n f693a;

        C02221(C0233n c0233n) {
            this.f693a = c0233n;
        }

        public void run() {
            this.f693a.m1206e();
        }
    }

    private static class C0223b implements AnimationListener {
        private final AnimationListener f694a;

        private C0223b(AnimationListener animationListener) {
            this.f694a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f694a != null) {
                this.f694a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f694a != null) {
                this.f694a.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.f694a != null) {
                this.f694a.onAnimationStart(animation);
            }
        }
    }

    private static class C0228a extends C0223b {
        View f706a;

        class C02271 implements Runnable {
            final /* synthetic */ C0228a f705a;

            C02271(C0228a c0228a) {
                this.f705a = c0228a;
            }

            public void run() {
                this.f705a.f706a.setLayerType(0, null);
            }
        }

        C0228a(View view, AnimationListener animationListener) {
            super(animationListener);
            this.f706a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (C0425s.m1936A(this.f706a) || VERSION.SDK_INT >= 24) {
                this.f706a.post(new C02271(this));
            } else {
                this.f706a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    private static class C0229c {
        public final Animation f707a;
        public final Animator f708b;

        private C0229c(Animator animator) {
            this.f707a = null;
            this.f708b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        private C0229c(Animation animation) {
            this.f707a = animation;
            this.f708b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class C0230d extends AnimatorListenerAdapter {
        View f709a;

        C0230d(View view) {
            this.f709a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f709a.setLayerType(0, null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.f709a.setLayerType(2, null);
        }
    }

    static class C0231e {
        public static final int[] f710a = new int[]{16842755, 16842960, 16842961};
    }

    static class C0232g implements C0211c {
        private final boolean f711a;
        private final C0199c f712b;
        private int f713c;

        C0232g(C0199c c0199c, boolean z) {
            this.f711a = z;
            this.f712b = c0199c;
        }

        public void mo179a() {
            this.f713c--;
            if (this.f713c == 0) {
                this.f712b.f561b.m1159y();
            }
        }

        public void mo180b() {
            this.f713c++;
        }

        public boolean m1125c() {
            return this.f713c == 0;
        }

        public void m1126d() {
            boolean z = false;
            boolean z2 = this.f713c > 0;
            C0233n c0233n = this.f712b.f561b;
            int size = c0233n.f728e.size();
            for (int i = 0; i < size; i++) {
                C0212h c0212h = (C0212h) c0233n.f728e.get(i);
                c0212h.m963a(null);
                if (z2 && c0212h.m945U()) {
                    c0212h.m925A();
                }
            }
            C0233n c0233n2 = this.f712b.f561b;
            C0199c c0199c = this.f712b;
            boolean z3 = this.f711a;
            if (!z2) {
                z = true;
            }
            c0233n2.m1135a(c0199c, z3, z, true);
        }

        public void m1127e() {
            this.f712b.f561b.m1135a(this.f712b, this.f711a, false, false);
        }
    }

    C0233n() {
    }

    private void m1128A() {
        if (this.f721B != null) {
            while (!this.f721B.isEmpty()) {
                ((C0232g) this.f721B.remove(0)).m1126d();
            }
        }
    }

    private void m1129B() {
        int size = this.f729f == null ? 0 : this.f729f.size();
        for (int i = 0; i < size; i++) {
            C0212h c0212h = (C0212h) this.f729f.valueAt(i);
            if (c0212h != null) {
                if (c0212h.m942R() != null) {
                    int T = c0212h.m944T();
                    View R = c0212h.m942R();
                    c0212h.m967a(null);
                    Animation animation = R.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        R.clearAnimation();
                    }
                    m1171a(c0212h, T, 0, 0, false);
                } else if (c0212h.m943S() != null) {
                    c0212h.m943S().end();
                }
            }
        }
    }

    private void m1130C() {
        if (this.f729f != null) {
            for (int size = this.f729f.size() - 1; size >= 0; size--) {
                if (this.f729f.valueAt(size) == null) {
                    this.f729f.delete(this.f729f.keyAt(size));
                }
            }
        }
    }

    private int m1131a(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0334b<C0212h> c0334b) {
        int i3 = i2 - 1;
        int i4 = i2;
        while (i3 >= i) {
            int i5;
            C0199c c0199c = (C0199c) arrayList.get(i3);
            boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
            boolean z = c0199c.m895c() && !c0199c.m890a((ArrayList) arrayList, i3 + 1, i2);
            if (z) {
                if (this.f721B == null) {
                    this.f721B = new ArrayList();
                }
                C0211c c0232g = new C0232g(c0199c, booleanValue);
                this.f721B.add(c0232g);
                c0199c.m886a(c0232g);
                if (booleanValue) {
                    c0199c.m893b();
                } else {
                    c0199c.m889a(false);
                }
                int i6 = i4 - 1;
                if (i3 != i6) {
                    arrayList.remove(i3);
                    arrayList.add(i6, c0199c);
                }
                m1149b((C0334b) c0334b);
                i5 = i6;
            } else {
                i5 = i4;
            }
            i3--;
            i4 = i5;
        }
        return i4;
    }

    static C0229c m1132a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f715F);
        alphaAnimation.setDuration(220);
        return new C0229c(alphaAnimation);
    }

    static C0229c m1133a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f714E);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f715F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return new C0229c(animationSet);
    }

    private static AnimationListener m1134a(Animation animation) {
        try {
            if (f719q == null) {
                f719q = Animation.class.getDeclaredField("mListener");
                f719q.setAccessible(true);
            }
            return (AnimationListener) f719q.get(animation);
        } catch (Throwable e) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
            return null;
        } catch (Throwable e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        }
    }

    private void m1135a(C0199c c0199c, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0199c.m889a(z3);
        } else {
            c0199c.m893b();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0199c);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0244s.m1259a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            m1165a(this.f735l, true);
        }
        if (this.f729f != null) {
            int size = this.f729f.size();
            for (int i = 0; i < size; i++) {
                C0212h c0212h = (C0212h) this.f729f.valueAt(i);
                if (c0212h != null && c0212h.f628H != null && c0212h.f636P && c0199c.m894b(c0212h.f664x)) {
                    if (c0212h.f638R > 0.0f) {
                        c0212h.f628H.setAlpha(c0212h.f638R);
                    }
                    if (z3) {
                        c0212h.f638R = 0.0f;
                    } else {
                        c0212h.f638R = -1.0f;
                        c0212h.f636P = false;
                    }
                }
            }
        }
    }

    private void m1136a(final C0212h c0212h, C0229c c0229c, int i) {
        final View view = c0212h.f628H;
        c0212h.m974b(i);
        if (c0229c.f707a != null) {
            Animation animation = c0229c.f707a;
            c0212h.m967a(c0212h.f628H);
            animation.setAnimationListener(new C0223b(this, C0233n.m1134a(animation)) {
                final /* synthetic */ C0233n f696b;

                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c0212h.m942R() != null) {
                        c0212h.m967a(null);
                        this.f696b.m1171a(c0212h, c0212h.m944T(), 0, 0, false);
                    }
                }
            });
            C0233n.m1150b(view, c0229c);
            c0212h.f628H.startAnimation(animation);
            return;
        }
        Animator animator = c0229c.f708b;
        c0212h.m956a(c0229c.f708b);
        final ViewGroup viewGroup = c0212h.f627G;
        if (viewGroup != null) {
            viewGroup.startViewTransition(view);
        }
        animator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ C0233n f700d;

            public void onAnimationEnd(Animator animator) {
                if (viewGroup != null) {
                    viewGroup.endViewTransition(view);
                }
                if (c0212h.m943S() != null) {
                    c0212h.m956a(null);
                    this.f700d.m1171a(c0212h, c0212h.m944T(), 0, 0, false);
                }
            }
        });
        animator.setTarget(c0212h.f628H);
        C0233n.m1150b(c0212h.f628H, c0229c);
        animator.start();
    }

    private static void m1139a(C0234o c0234o) {
        if (c0234o != null) {
            List<C0212h> a = c0234o.m1238a();
            if (a != null) {
                for (C0212h c0212h : a) {
                    c0212h.f623C = true;
                }
            }
            List<C0234o> b = c0234o.m1239b();
            if (b != null) {
                for (C0234o a2 : b) {
                    C0233n.m1139a(a2);
                }
            }
        }
    }

    private void m1140a(C0334b<C0212h> c0334b) {
        int size = c0334b.size();
        for (int i = 0; i < size; i++) {
            C0212h c0212h = (C0212h) c0334b.m1627b(i);
            if (!c0212h.f651k) {
                View i2 = c0212h.m1001i();
                c0212h.f638R = i2.getAlpha();
                i2.setAlpha(0.0f);
            }
        }
    }

    private void m1141a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0337e("FragmentManager"));
        if (this.f736m != null) {
            try {
                this.f736m.mo161a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo181a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    private void m1142a(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        int size = this.f721B == null ? 0 : this.f721B.size();
        while (i < size) {
            int indexOf;
            int i2;
            C0232g c0232g = (C0232g) this.f721B.get(i);
            if (!(arrayList == null || c0232g.f711a)) {
                indexOf = arrayList.indexOf(c0232g.f712b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    c0232g.m1127e();
                    i2 = i;
                    indexOf = size;
                    i = i2 + 1;
                    size = indexOf;
                }
            }
            if (c0232g.m1125c() || (arrayList != null && c0232g.f712b.m890a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.f721B.remove(i);
                i--;
                size--;
                if (!(arrayList == null || c0232g.f711a)) {
                    indexOf = arrayList.indexOf(c0232g.f712b);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        c0232g.m1127e();
                        i2 = i;
                        indexOf = size;
                        i = i2 + 1;
                        size = indexOf;
                    }
                }
                c0232g.m1126d();
            }
            i2 = i;
            indexOf = size;
            i = i2 + 1;
            size = indexOf;
        }
    }

    private void m1143a(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int a;
        boolean z = ((C0199c) arrayList.get(i)).f580u;
        if (this.f747y == null) {
            this.f747y = new ArrayList();
        } else {
            this.f747y.clear();
        }
        this.f747y.addAll(this.f728e);
        int i3 = i;
        C0212h v = m1236v();
        boolean z2 = false;
        while (i3 < i2) {
            C0199c c0199c = (C0199c) arrayList.get(i3);
            C0212h a2 = !((Boolean) arrayList2.get(i3)).booleanValue() ? c0199c.m882a(this.f747y, v) : c0199c.m892b(this.f747y, v);
            boolean z3 = z2 || c0199c.f569j;
            i3++;
            v = a2;
            z2 = z3;
        }
        this.f747y.clear();
        if (!z) {
            C0244s.m1259a(this, arrayList, arrayList2, i, i2, false);
        }
        C0233n.m1152b(arrayList, arrayList2, i, i2);
        if (z) {
            C0334b c0334b = new C0334b();
            m1149b(c0334b);
            a = m1131a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2, c0334b);
            m1140a(c0334b);
        } else {
            a = i2;
        }
        if (a != i && z) {
            C0244s.m1259a(this, arrayList, arrayList2, i, a, true);
            m1165a(this.f735l, true);
        }
        while (i < i2) {
            c0199c = (C0199c) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue() && c0199c.f573n >= 0) {
                m1195c(c0199c.f573n);
                c0199c.f573n = -1;
            }
            c0199c.m883a();
            i++;
        }
        if (z2) {
            m1210g();
        }
    }

    static boolean m1144a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
            return false;
        } else if (!(animator instanceof AnimatorSet)) {
            return false;
        } else {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (C0233n.m1144a((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    static boolean m1145a(C0229c c0229c) {
        if (c0229c.f707a instanceof AlphaAnimation) {
            return true;
        }
        if (!(c0229c.f707a instanceof AnimationSet)) {
            return C0233n.m1144a(c0229c.f708b);
        }
        List animations = ((AnimationSet) c0229c.f707a).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m1146a(View view, C0229c c0229c) {
        return view != null && c0229c != null && VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && C0425s.m1981t(view) && C0233n.m1145a(c0229c);
    }

    private boolean m1147a(String str, int i, int i2) {
        m1206e();
        m1153c(true);
        if (this.f739p != null && i < 0 && str == null) {
            C0221m h = this.f739p.m999h();
            if (h != null && h.mo182a()) {
                return true;
            }
        }
        boolean a = m1184a(this.f745w, this.f746x, str, i, i2);
        if (a) {
            this.f726c = true;
            try {
                m1151b(this.f745w, this.f746x);
            } finally {
                m1160z();
            }
        }
        m1207f();
        m1130C();
        return a;
    }

    public static int m1148b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void m1149b(C0334b<C0212h> c0334b) {
        if (this.f735l >= 1) {
            int min = Math.min(this.f735l, 4);
            int size = this.f728e.size();
            for (int i = 0; i < size; i++) {
                C0212h c0212h = (C0212h) this.f728e.get(i);
                if (c0212h.f642b < min) {
                    m1171a(c0212h, min, c0212h.m937M(), c0212h.m938N(), false);
                    if (!(c0212h.f628H == null || c0212h.f666z || !c0212h.f636P)) {
                        c0334b.add(c0212h);
                    }
                }
            }
        }
    }

    private static void m1150b(View view, C0229c c0229c) {
        if (view != null && c0229c != null && C0233n.m1146a(view, c0229c)) {
            if (c0229c.f708b != null) {
                c0229c.f708b.addListener(new C0230d(view));
                return;
            }
            AnimationListener a = C0233n.m1134a(c0229c.f707a);
            view.setLayerType(2, null);
            c0229c.f707a.setAnimationListener(new C0228a(view, a));
        }
    }

    private void m1151b(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m1142a((ArrayList) arrayList, (ArrayList) arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            while (i < size) {
                int i3;
                if (((C0199c) arrayList.get(i)).f580u) {
                    i3 = i;
                } else {
                    if (i2 != i) {
                        m1143a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((C0199c) arrayList.get(i2)).f580u) {
                            i2++;
                        }
                    }
                    i3 = i2;
                    m1143a((ArrayList) arrayList, (ArrayList) arrayList2, i, i3);
                    i2 = i3;
                    i3--;
                }
                i = i3 + 1;
            }
            if (i2 != size) {
                m1143a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
            }
        }
    }

    private static void m1152b(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0199c c0199c = (C0199c) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                c0199c.m884a(-1);
                c0199c.m889a(i == i2 + -1);
            } else {
                c0199c.m884a(1);
                c0199c.m893b();
            }
            i++;
        }
    }

    private void m1153c(boolean z) {
        if (this.f726c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.f736m.m1040h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                m1158x();
            }
            if (this.f745w == null) {
                this.f745w = new ArrayList();
                this.f746x = new ArrayList();
            }
            this.f726c = true;
            try {
                m1142a(null, null);
            } finally {
                this.f726c = false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m1154c(java.util.ArrayList<android.support.v4.p012a.C0199c> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        r0 = 0;
        monitor-enter(r4);
        r1 = r4.f725b;	 Catch:{ all -> 0x003e }
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r1 = r4.f725b;	 Catch:{ all -> 0x003e }
        r1 = r1.size();	 Catch:{ all -> 0x003e }
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = r4.f725b;	 Catch:{ all -> 0x003e }
        r3 = r1.size();	 Catch:{ all -> 0x003e }
        r2 = r0;
        r1 = r0;
    L_0x0018:
        if (r2 >= r3) goto L_0x002b;
    L_0x001a:
        r0 = r4.f725b;	 Catch:{ all -> 0x003e }
        r0 = r0.get(r2);	 Catch:{ all -> 0x003e }
        r0 = (android.support.v4.p012a.C0233n.C0198f) r0;	 Catch:{ all -> 0x003e }
        r0 = r0.mo157a(r5, r6);	 Catch:{ all -> 0x003e }
        r1 = r1 | r0;
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0018;
    L_0x002b:
        r0 = r4.f725b;	 Catch:{ all -> 0x003e }
        r0.clear();	 Catch:{ all -> 0x003e }
        r0 = r4.f736m;	 Catch:{ all -> 0x003e }
        r0 = r0.m1040h();	 Catch:{ all -> 0x003e }
        r2 = r4.f723D;	 Catch:{ all -> 0x003e }
        r0.removeCallbacks(r2);	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r1;
        goto L_0x000f;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.n.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public static int m1155d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m1156e(int i) {
        try {
            this.f726c = true;
            m1165a(i, false);
            m1206e();
        } finally {
            this.f726c = false;
        }
    }

    private C0212h m1157p(C0212h c0212h) {
        ViewGroup viewGroup = c0212h.f627G;
        View view = c0212h.f628H;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.f728e.indexOf(c0212h) - 1; indexOf >= 0; indexOf--) {
            C0212h c0212h2 = (C0212h) this.f728e.get(indexOf);
            if (c0212h2.f627G == viewGroup && c0212h2.f628H != null) {
                return c0212h2;
            }
        }
        return null;
    }

    private void m1158x() {
        if (this.f741s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f743u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f743u);
        }
    }

    private void m1159y() {
        Object obj = 1;
        synchronized (this) {
            Object obj2 = (this.f721B == null || this.f721B.isEmpty()) ? null : 1;
            if (this.f725b == null || this.f725b.size() != 1) {
                obj = null;
            }
            if (!(obj2 == null && r0 == null)) {
                this.f736m.m1040h().removeCallbacks(this.f723D);
                this.f736m.m1040h().post(this.f723D);
            }
        }
    }

    private void m1160z() {
        this.f726c = false;
        this.f746x.clear();
        this.f745w.clear();
    }

    public C0212h m1161a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        C0212h c0212h = (C0212h) this.f729f.get(i);
        if (c0212h != null) {
            return c0212h;
        }
        m1141a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return c0212h;
    }

    public C0212h m1162a(String str) {
        int size;
        C0212h c0212h;
        if (str != null) {
            for (size = this.f728e.size() - 1; size >= 0; size--) {
                c0212h = (C0212h) this.f728e.get(size);
                if (c0212h != null && str.equals(c0212h.f665y)) {
                    return c0212h;
                }
            }
        }
        if (!(this.f729f == null || str == null)) {
            for (size = this.f729f.size() - 1; size >= 0; size--) {
                c0212h = (C0212h) this.f729f.valueAt(size);
                if (c0212h != null && str.equals(c0212h.f665y)) {
                    return c0212h;
                }
            }
        }
        return null;
    }

    C0229c m1163a(C0212h c0212h, int i, boolean z, int i2) {
        int M = c0212h.m937M();
        Animation a = c0212h.m950a(i, z, M);
        if (a != null) {
            return new C0229c(a);
        }
        Animator b = c0212h.m972b(i, z, M);
        if (b != null) {
            return new C0229c(b);
        }
        if (M != 0) {
            Object obj;
            boolean equals = "anim".equals(this.f736m.m1039g().getResources().getResourceTypeName(M));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f736m.m1039g(), M);
                    if (loadAnimation != null) {
                        return new C0229c(loadAnimation);
                    }
                    obj = 1;
                } catch (NotFoundException e) {
                    throw e;
                } catch (RuntimeException e2) {
                    obj = null;
                }
            } else {
                obj = null;
            }
            if (obj == null) {
                try {
                    b = AnimatorInflater.loadAnimator(this.f736m.m1039g(), M);
                    if (b != null) {
                        return new C0229c(b);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    a = AnimationUtils.loadAnimation(this.f736m.m1039g(), M);
                    if (a != null) {
                        return new C0229c(a);
                    }
                }
            }
        }
        if (i == 0) {
            return null;
        }
        int b2 = C0233n.m1148b(i, z);
        if (b2 < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return C0233n.m1133a(this.f736m.m1039g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0233n.m1133a(this.f736m.m1039g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0233n.m1133a(this.f736m.m1039g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0233n.m1133a(this.f736m.m1039g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0233n.m1132a(this.f736m.m1039g(), 0.0f, 1.0f);
            case 6:
                return C0233n.m1132a(this.f736m.m1039g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f736m.mo166d()) {
                    i2 = this.f736m.mo167e();
                }
                return i2 == 0 ? null : null;
        }
    }

    public void m1164a(int i, C0199c c0199c) {
        synchronized (this) {
            if (this.f732i == null) {
                this.f732i = new ArrayList();
            }
            int size = this.f732i.size();
            if (i < size) {
                if (f718a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0199c);
                }
                this.f732i.set(i, c0199c);
            } else {
                while (size < i) {
                    this.f732i.add(null);
                    if (this.f733j == null) {
                        this.f733j = new ArrayList();
                    }
                    if (f718a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f733j.add(Integer.valueOf(size));
                    size++;
                }
                if (f718a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0199c);
                }
                this.f732i.add(c0199c);
            }
        }
    }

    void m1165a(int i, boolean z) {
        if (this.f736m == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.f735l) {
            this.f735l = i;
            if (this.f729f != null) {
                C0212h c0212h;
                int size = this.f728e.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    c0212h = (C0212h) this.f728e.get(i2);
                    m1204e(c0212h);
                    i2++;
                    i3 = c0212h.f632L != null ? c0212h.f632L.mo185a() | i3 : i3;
                }
                size = this.f729f.size();
                i2 = 0;
                while (i2 < size) {
                    int a;
                    c0212h = (C0212h) this.f729f.valueAt(i2);
                    if (c0212h != null && ((c0212h.f652l || c0212h.f621A) && !c0212h.f636P)) {
                        m1204e(c0212h);
                        if (c0212h.f632L != null) {
                            a = c0212h.f632L.mo185a() | i3;
                            i2++;
                            i3 = a;
                        }
                    }
                    a = i3;
                    i2++;
                    i3 = a;
                }
                if (i3 == 0) {
                    m1200d();
                }
                if (this.f740r && this.f736m != null && this.f735l == 5) {
                    this.f736m.mo165c();
                    this.f740r = false;
                }
            }
        }
    }

    public void m1166a(Configuration configuration) {
        for (int i = 0; i < this.f728e.size(); i++) {
            C0212h c0212h = (C0212h) this.f728e.get(i);
            if (c0212h != null) {
                c0212h.m961a(configuration);
            }
        }
    }

    public void m1167a(Bundle bundle, String str, C0212h c0212h) {
        if (c0212h.f645e < 0) {
            m1141a(new IllegalStateException("Fragment " + c0212h + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, c0212h.f645e);
    }

    void m1168a(Parcelable parcelable, C0234o c0234o) {
        if (parcelable != null) {
            C0236p c0236p = (C0236p) parcelable;
            if (c0236p.f751a != null) {
                int size;
                C0212h c0212h;
                int i;
                List list;
                if (c0234o != null) {
                    List a = c0234o.m1238a();
                    List b = c0234o.m1239b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean z = false;
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        c0212h = (C0212h) a.get(i2);
                        if (f718a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + c0212h);
                        }
                        i = 0;
                        while (i < c0236p.f751a.length && c0236p.f751a[i].f757b != c0212h.f645e) {
                            i++;
                        }
                        if (i == c0236p.f751a.length) {
                            m1141a(new IllegalStateException("Could not find active fragment with index " + c0212h.f645e));
                        }
                        C0238q c0238q = c0236p.f751a[i];
                        c0238q.f767l = c0212h;
                        c0212h.f644d = null;
                        c0212h.f657q = 0;
                        c0212h.f654n = false;
                        c0212h.f651k = false;
                        c0212h.f648h = null;
                        if (c0238q.f766k != null) {
                            c0238q.f766k.setClassLoader(this.f736m.m1039g().getClassLoader());
                            c0212h.f644d = c0238q.f766k.getSparseParcelableArray("android:view_state");
                            c0212h.f643c = c0238q.f766k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f729f = new SparseArray(c0236p.f751a.length);
                i = 0;
                while (i < c0236p.f751a.length) {
                    C0238q c0238q2 = c0236p.f751a[i];
                    if (c0238q2 != null) {
                        C0234o c0234o2 = (list == null || i >= list.size()) ? null : (C0234o) list.get(i);
                        c0212h = c0238q2.m1244a(this.f736m, this.f737n, this.f738o, c0234o2);
                        if (f718a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + c0212h);
                        }
                        this.f729f.put(c0212h.f645e, c0212h);
                        c0238q2.f767l = null;
                    }
                    i++;
                }
                if (c0234o != null) {
                    List a2 = c0234o.m1238a();
                    if (a2 != null) {
                        i = a2.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (int i3 = 0; i3 < i; i3++) {
                        c0212h = (C0212h) a2.get(i3);
                        if (c0212h.f649i >= 0) {
                            c0212h.f648h = (C0212h) this.f729f.get(c0212h.f649i);
                            if (c0212h.f648h == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + c0212h + " target no longer exists: " + c0212h.f649i);
                            }
                        }
                    }
                }
                this.f728e.clear();
                if (c0236p.f752b != null) {
                    for (size = 0; size < c0236p.f752b.length; size++) {
                        c0212h = (C0212h) this.f729f.get(c0236p.f752b[size]);
                        if (c0212h == null) {
                            m1141a(new IllegalStateException("No instantiated fragment for index #" + c0236p.f752b[size]));
                        }
                        c0212h.f651k = true;
                        if (f718a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + c0212h);
                        }
                        if (this.f728e.contains(c0212h)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.f728e) {
                            this.f728e.add(c0212h);
                        }
                    }
                }
                if (c0236p.f753c != null) {
                    this.f730g = new ArrayList(c0236p.f753c.length);
                    for (int i4 = 0; i4 < c0236p.f753c.length; i4++) {
                        C0199c a3 = c0236p.f753c[i4].m899a(this);
                        if (f718a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + a3.f573n + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new C0337e("FragmentManager"));
                            a3.m888a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f730g.add(a3);
                        if (a3.f573n >= 0) {
                            m1164a(a3.f573n, a3);
                        }
                    }
                } else {
                    this.f730g = null;
                }
                if (c0236p.f754d >= 0) {
                    this.f739p = (C0212h) this.f729f.get(c0236p.f754d);
                }
                this.f727d = c0236p.f755e;
            }
        }
    }

    void m1169a(C0199c c0199c) {
        if (this.f730g == null) {
            this.f730g = new ArrayList();
        }
        this.f730g.add(c0199c);
    }

    public void m1170a(C0212h c0212h) {
        if (!c0212h.f630J) {
            return;
        }
        if (this.f726c) {
            this.f744v = true;
            return;
        }
        c0212h.f630J = false;
        m1171a(c0212h, this.f735l, 0, 0, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1171a(android.support.v4.p012a.C0212h r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.f651k;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f621A;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f652l;
        if (r0 == 0) goto L_0x0023;
    L_0x0014:
        r0 = r11.f642b;
        if (r12 <= r0) goto L_0x0023;
    L_0x0018:
        r0 = r11.f642b;
        if (r0 != 0) goto L_0x003b;
    L_0x001c:
        r0 = r11.m978b();
        if (r0 == 0) goto L_0x003b;
    L_0x0022:
        r12 = r5;
    L_0x0023:
        r0 = r11.f630J;
        if (r0 == 0) goto L_0x002e;
    L_0x0027:
        r0 = r11.f642b;
        if (r0 >= r9) goto L_0x002e;
    L_0x002b:
        if (r12 <= r6) goto L_0x002e;
    L_0x002d:
        r12 = r6;
    L_0x002e:
        r0 = r11.f642b;
        if (r0 > r12) goto L_0x032e;
    L_0x0032:
        r0 = r11.f653m;
        if (r0 == 0) goto L_0x003e;
    L_0x0036:
        r0 = r11.f654n;
        if (r0 != 0) goto L_0x003e;
    L_0x003a:
        return;
    L_0x003b:
        r12 = r11.f642b;
        goto L_0x0023;
    L_0x003e:
        r0 = r11.m942R();
        if (r0 != 0) goto L_0x004a;
    L_0x0044:
        r0 = r11.m943S();
        if (r0 == 0) goto L_0x005a;
    L_0x004a:
        r11.m967a(r7);
        r11.m956a(r7);
        r2 = r11.m944T();
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m1171a(r1, r2, r3, r4, r5);
    L_0x005a:
        r0 = r11.f642b;
        switch(r0) {
            case 0: goto L_0x009a;
            case 1: goto L_0x01c2;
            case 2: goto L_0x02c0;
            case 3: goto L_0x02c5;
            case 4: goto L_0x02e9;
            default: goto L_0x005f;
        };
    L_0x005f:
        r0 = r11.f642b;
        if (r0 == r12) goto L_0x003a;
    L_0x0063:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.f642b;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f642b = r12;
        goto L_0x003a;
    L_0x009a:
        if (r12 <= 0) goto L_0x01c2;
    L_0x009c:
        r0 = f718a;
        if (r0 == 0) goto L_0x00b8;
    L_0x00a0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00b8:
        r0 = r11.f643c;
        if (r0 == 0) goto L_0x0100;
    L_0x00bc:
        r0 = r11.f643c;
        r1 = r10.f736m;
        r1 = r1.m1039g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f643c;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f644d = r0;
        r0 = r11.f643c;
        r1 = "android:target_state";
        r0 = r10.m1161a(r0, r1);
        r11.f648h = r0;
        r0 = r11.f648h;
        if (r0 == 0) goto L_0x00ed;
    L_0x00e3:
        r0 = r11.f643c;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f650j = r0;
    L_0x00ed:
        r0 = r11.f643c;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f631K = r0;
        r0 = r11.f631K;
        if (r0 != 0) goto L_0x0100;
    L_0x00fb:
        r11.f630J = r5;
        if (r12 <= r6) goto L_0x0100;
    L_0x00ff:
        r12 = r6;
    L_0x0100:
        r0 = r10.f736m;
        r11.f659s = r0;
        r0 = r10.f738o;
        r11.f662v = r0;
        r0 = r10.f738o;
        if (r0 == 0) goto L_0x014f;
    L_0x010c:
        r0 = r10.f738o;
        r0 = r0.f660t;
    L_0x0110:
        r11.f658r = r0;
        r0 = r11.f648h;
        if (r0 == 0) goto L_0x0164;
    L_0x0116:
        r0 = r10.f729f;
        r1 = r11.f648h;
        r1 = r1.f645e;
        r0 = r0.get(r1);
        r1 = r11.f648h;
        if (r0 == r1) goto L_0x0156;
    L_0x0124:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " declared target fragment ";
        r1 = r1.append(r2);
        r2 = r11.f648h;
        r1 = r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x014f:
        r0 = r10.f736m;
        r0 = r0.m1041i();
        goto L_0x0110;
    L_0x0156:
        r0 = r11.f648h;
        r0 = r0.f642b;
        if (r0 >= r5) goto L_0x0164;
    L_0x015c:
        r1 = r11.f648h;
        r0 = r10;
        r2 = r5;
        r4 = r3;
        r0.m1171a(r1, r2, r3, r4, r5);
    L_0x0164:
        r0 = r10.f736m;
        r0 = r0.m1039g();
        r10.m1172a(r11, r0, r3);
        r11.f626F = r3;
        r0 = r10.f736m;
        r0 = r0.m1039g();
        r11.m959a(r0);
        r0 = r11.f626F;
        if (r0 != 0) goto L_0x019b;
    L_0x017c:
        r0 = new android.support.v4.a.z;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x019b:
        r0 = r11.f662v;
        if (r0 != 0) goto L_0x0313;
    L_0x019f:
        r0 = r10.f736m;
        r0.mo164b(r11);
    L_0x01a4:
        r0 = r10.f736m;
        r0 = r0.m1039g();
        r10.m1189b(r11, r0, r3);
        r0 = r11.f640T;
        if (r0 != 0) goto L_0x031a;
    L_0x01b1:
        r0 = r11.f643c;
        r10.m1173a(r11, r0, r3);
        r0 = r11.f643c;
        r11.m1006k(r0);
        r0 = r11.f643c;
        r10.m1190b(r11, r0, r3);
    L_0x01c0:
        r11.f623C = r3;
    L_0x01c2:
        r10.m1196c(r11);
        if (r12 <= r5) goto L_0x02c0;
    L_0x01c7:
        r0 = f718a;
        if (r0 == 0) goto L_0x01e3;
    L_0x01cb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x01e3:
        r0 = r11.f653m;
        if (r0 != 0) goto L_0x02ab;
    L_0x01e7:
        r0 = r11.f664x;
        if (r0 == 0) goto L_0x04a1;
    L_0x01eb:
        r0 = r11.f664x;
        r1 = -1;
        if (r0 != r1) goto L_0x0211;
    L_0x01f0:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m1141a(r0);
    L_0x0211:
        r0 = r10.f737n;
        r1 = r11.f664x;
        r0 = r0.mo159a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0260;
    L_0x021d:
        r1 = r11.f655o;
        if (r1 != 0) goto L_0x0260;
    L_0x0221:
        r1 = r11.m991e();	 Catch:{ NotFoundException -> 0x0323 }
        r2 = r11.f664x;	 Catch:{ NotFoundException -> 0x0323 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0323 }
    L_0x022b:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.f664x;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.m1141a(r2);
    L_0x0260:
        r11.f627G = r0;
        r1 = r11.f643c;
        r1 = r11.m987d(r1);
        r2 = r11.f643c;
        r1 = r11.m973b(r1, r0, r2);
        r11.f628H = r1;
        r1 = r11.f628H;
        if (r1 == 0) goto L_0x032a;
    L_0x0274:
        r1 = r11.f628H;
        r11.f629I = r1;
        r1 = r11.f628H;
        r1.setSaveFromParentEnabled(r3);
        if (r0 == 0) goto L_0x0284;
    L_0x027f:
        r1 = r11.f628H;
        r0.addView(r1);
    L_0x0284:
        r0 = r11.f666z;
        if (r0 == 0) goto L_0x028f;
    L_0x0288:
        r0 = r11.f628H;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x028f:
        r0 = r11.f628H;
        r1 = r11.f643c;
        r11.m968a(r0, r1);
        r0 = r11.f628H;
        r1 = r11.f643c;
        r10.m1174a(r11, r0, r1, r3);
        r0 = r11.f628H;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0328;
    L_0x02a5:
        r0 = r11.f627G;
        if (r0 == 0) goto L_0x0328;
    L_0x02a9:
        r11.f636P = r5;
    L_0x02ab:
        r0 = r11.f643c;
        r11.m1008l(r0);
        r0 = r11.f643c;
        r10.m1197c(r11, r0, r3);
        r0 = r11.f628H;
        if (r0 == 0) goto L_0x02be;
    L_0x02b9:
        r0 = r11.f643c;
        r11.m962a(r0);
    L_0x02be:
        r11.f643c = r7;
    L_0x02c0:
        r0 = 2;
        if (r12 <= r0) goto L_0x02c5;
    L_0x02c3:
        r11.f642b = r6;
    L_0x02c5:
        if (r12 <= r6) goto L_0x02e9;
    L_0x02c7:
        r0 = f718a;
        if (r0 == 0) goto L_0x02e3;
    L_0x02cb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02e3:
        r11.m927C();
        r10.m1191b(r11, r3);
    L_0x02e9:
        if (r12 <= r9) goto L_0x005f;
    L_0x02eb:
        r0 = f718a;
        if (r0 == 0) goto L_0x0307;
    L_0x02ef:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0307:
        r11.m928D();
        r10.m1198c(r11, r3);
        r11.f643c = r7;
        r11.f644d = r7;
        goto L_0x005f;
    L_0x0313:
        r0 = r11.f662v;
        r0.m964a(r11);
        goto L_0x01a4;
    L_0x031a:
        r0 = r11.f643c;
        r11.m998g(r0);
        r11.f642b = r5;
        goto L_0x01c0;
    L_0x0323:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x022b;
    L_0x0328:
        r5 = r3;
        goto L_0x02a9;
    L_0x032a:
        r11.f629I = r7;
        goto L_0x02ab;
    L_0x032e:
        r0 = r11.f642b;
        if (r0 <= r12) goto L_0x005f;
    L_0x0332:
        r0 = r11.f642b;
        switch(r0) {
            case 1: goto L_0x0339;
            case 2: goto L_0x03cb;
            case 3: goto L_0x03aa;
            case 4: goto L_0x0386;
            case 5: goto L_0x0361;
            default: goto L_0x0337;
        };
    L_0x0337:
        goto L_0x005f;
    L_0x0339:
        if (r12 >= r5) goto L_0x005f;
    L_0x033b:
        r0 = r10.f742t;
        if (r0 == 0) goto L_0x034f;
    L_0x033f:
        r0 = r11.m942R();
        if (r0 == 0) goto L_0x044b;
    L_0x0345:
        r0 = r11.m942R();
        r11.m967a(r7);
        r0.clearAnimation();
    L_0x034f:
        r0 = r11.m942R();
        if (r0 != 0) goto L_0x035b;
    L_0x0355:
        r0 = r11.m943S();
        if (r0 == 0) goto L_0x045d;
    L_0x035b:
        r11.m974b(r12);
        r12 = r5;
        goto L_0x005f;
    L_0x0361:
        r0 = 5;
        if (r12 >= r0) goto L_0x0386;
    L_0x0364:
        r0 = f718a;
        if (r0 == 0) goto L_0x0380;
    L_0x0368:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0380:
        r11.m931G();
        r10.m1203d(r11, r3);
    L_0x0386:
        if (r12 >= r9) goto L_0x03aa;
    L_0x0388:
        r0 = f718a;
        if (r0 == 0) goto L_0x03a4;
    L_0x038c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03a4:
        r11.m932H();
        r10.m1205e(r11, r3);
    L_0x03aa:
        if (r12 >= r6) goto L_0x03cb;
    L_0x03ac:
        r0 = f718a;
        if (r0 == 0) goto L_0x03c8;
    L_0x03b0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03c8:
        r11.m933I();
    L_0x03cb:
        r0 = 2;
        if (r12 >= r0) goto L_0x0339;
    L_0x03ce:
        r0 = f718a;
        if (r0 == 0) goto L_0x03ea;
    L_0x03d2:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ea:
        r0 = r11.f628H;
        if (r0 == 0) goto L_0x03fd;
    L_0x03ee:
        r0 = r10.f736m;
        r0 = r0.mo162a(r11);
        if (r0 == 0) goto L_0x03fd;
    L_0x03f6:
        r0 = r11.f644d;
        if (r0 != 0) goto L_0x03fd;
    L_0x03fa:
        r10.m1225m(r11);
    L_0x03fd:
        r11.m934J();
        r10.m1209f(r11, r3);
        r0 = r11.f628H;
        if (r0 == 0) goto L_0x0441;
    L_0x0407:
        r0 = r11.f627G;
        if (r0 == 0) goto L_0x0441;
    L_0x040b:
        r0 = r11.f628H;
        r0.clearAnimation();
        r0 = r11.f627G;
        r1 = r11.f628H;
        r0.endViewTransition(r1);
        r0 = r10.f735l;
        if (r0 <= 0) goto L_0x049f;
    L_0x041b:
        r0 = r10.f742t;
        if (r0 != 0) goto L_0x049f;
    L_0x041f:
        r0 = r11.f628H;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x049f;
    L_0x0427:
        r0 = r11.f638R;
        r1 = 0;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x049f;
    L_0x042e:
        r0 = r10.m1163a(r11, r13, r3, r14);
    L_0x0432:
        r1 = 0;
        r11.f638R = r1;
        if (r0 == 0) goto L_0x043a;
    L_0x0437:
        r10.m1136a(r11, r0, r12);
    L_0x043a:
        r0 = r11.f627G;
        r1 = r11.f628H;
        r0.removeView(r1);
    L_0x0441:
        r11.f627G = r7;
        r11.f628H = r7;
        r11.f629I = r7;
        r11.f654n = r3;
        goto L_0x0339;
    L_0x044b:
        r0 = r11.m943S();
        if (r0 == 0) goto L_0x034f;
    L_0x0451:
        r0 = r11.m943S();
        r11.m956a(r7);
        r0.cancel();
        goto L_0x034f;
    L_0x045d:
        r0 = f718a;
        if (r0 == 0) goto L_0x0479;
    L_0x0461:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0479:
        r0 = r11.f623C;
        if (r0 != 0) goto L_0x0494;
    L_0x047d:
        r11.m935K();
        r10.m1212g(r11, r3);
    L_0x0483:
        r11.m936L();
        r10.m1215h(r11, r3);
        if (r15 != 0) goto L_0x005f;
    L_0x048b:
        r0 = r11.f623C;
        if (r0 != 0) goto L_0x0497;
    L_0x048f:
        r10.m1211g(r11);
        goto L_0x005f;
    L_0x0494:
        r11.f642b = r3;
        goto L_0x0483;
    L_0x0497:
        r11.f659s = r7;
        r11.f662v = r7;
        r11.f658r = r7;
        goto L_0x005f;
    L_0x049f:
        r0 = r7;
        goto L_0x0432;
    L_0x04a1:
        r0 = r7;
        goto L_0x0260;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.n.a(android.support.v4.a.h, int, int, int, boolean):void");
    }

    void m1172a(C0212h c0212h, Context context, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1172a(c0212h, context, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1103a((C0221m) this, c0212h, context);
            }
        }
    }

    void m1173a(C0212h c0212h, Bundle bundle, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1173a(c0212h, bundle, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1104a((C0221m) this, c0212h, bundle);
            }
        }
    }

    void m1174a(C0212h c0212h, View view, Bundle bundle, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1174a(c0212h, view, bundle, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1105a(this, c0212h, view, bundle);
            }
        }
    }

    public void m1175a(C0212h c0212h, boolean z) {
        if (f718a) {
            Log.v("FragmentManager", "add: " + c0212h);
        }
        m1208f(c0212h);
        if (!c0212h.f621A) {
            if (this.f728e.contains(c0212h)) {
                throw new IllegalStateException("Fragment already added: " + c0212h);
            }
            synchronized (this.f728e) {
                this.f728e.add(c0212h);
            }
            c0212h.f651k = true;
            c0212h.f652l = false;
            if (c0212h.f628H == null) {
                c0212h.f637Q = false;
            }
            if (c0212h.f624D && c0212h.f625E) {
                this.f740r = true;
            }
            if (z) {
                m1188b(c0212h);
            }
        }
    }

    public void m1176a(C0214l c0214l, C0207j c0207j, C0212h c0212h) {
        if (this.f736m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f736m = c0214l;
        this.f737n = c0207j;
        this.f738o = c0212h;
    }

    public void mo181a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        C0212h c0212h;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f729f != null) {
            size = this.f729f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    c0212h = (C0212h) this.f729f.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0212h);
                    if (c0212h != null) {
                        c0212h.m969a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.f728e.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                c0212h = (C0212h) this.f728e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(c0212h.toString());
            }
        }
        if (this.f731h != null) {
            size = this.f731h.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c0212h = (C0212h) this.f731h.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0212h.toString());
                }
            }
        }
        if (this.f730g != null) {
            size = this.f730g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0199c c0199c = (C0199c) this.f730g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0199c.toString());
                    c0199c.m887a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f732i != null) {
                int size2 = this.f732i.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0199c = (C0199c) this.f732i.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0199c);
                    }
                }
            }
            if (this.f733j != null && this.f733j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f733j.toArray()));
            }
        }
        if (this.f725b != null) {
            i = this.f725b.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    C0198f c0198f = (C0198f) this.f725b.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(c0198f);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f736m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f737n);
        if (this.f738o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f738o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f735l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f741s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f742t);
        if (this.f740r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f740r);
        }
        if (this.f743u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f743u);
        }
    }

    public void m1178a(boolean z) {
        for (int size = this.f728e.size() - 1; size >= 0; size--) {
            C0212h c0212h = (C0212h) this.f728e.get(size);
            if (c0212h != null) {
                c0212h.m989d(z);
            }
        }
    }

    public boolean mo182a() {
        m1158x();
        return m1147a(null, -1, 0);
    }

    boolean m1180a(int i) {
        return this.f735l >= i;
    }

    public boolean m1181a(Menu menu) {
        boolean z = false;
        for (int i = 0; i < this.f728e.size(); i++) {
            C0212h c0212h = (C0212h) this.f728e.get(i);
            if (c0212h != null && c0212h.m984c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m1182a(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        ArrayList arrayList = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.f728e.size()) {
            C0212h c0212h = (C0212h) this.f728e.get(i2);
            if (c0212h != null && c0212h.m979b(menu, menuInflater)) {
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c0212h);
            }
            i2++;
            z = z;
        }
        if (this.f731h != null) {
            while (i < this.f731h.size()) {
                c0212h = (C0212h) this.f731h.get(i);
                if (arrayList == null || !arrayList.contains(c0212h)) {
                    c0212h.m1015r();
                }
                i++;
            }
        }
        this.f731h = arrayList;
        return z;
    }

    public boolean m1183a(MenuItem menuItem) {
        for (int i = 0; i < this.f728e.size(); i++) {
            C0212h c0212h = (C0212h) this.f728e.get(i);
            if (c0212h != null && c0212h.m985c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean m1184a(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.f730g == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f730g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f730g.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                C0199c c0199c;
                size2 = this.f730g.size() - 1;
                while (size2 >= 0) {
                    c0199c = (C0199c) this.f730g.get(size2);
                    if ((str != null && str.equals(c0199c.m896d())) || (i >= 0 && i == c0199c.f573n)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0199c = (C0199c) this.f730g.get(size2);
                        if ((str == null || !str.equals(c0199c.m896d())) && (i < 0 || i != c0199c.f573n)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f730g.size() - 1) {
                return false;
            }
            for (size2 = this.f730g.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f730g.remove(size2));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    public C0212h m1185b(int i) {
        int size;
        for (size = this.f728e.size() - 1; size >= 0; size--) {
            C0212h c0212h = (C0212h) this.f728e.get(size);
            if (c0212h != null && c0212h.f663w == i) {
                return c0212h;
            }
        }
        if (this.f729f != null) {
            for (size = this.f729f.size() - 1; size >= 0; size--) {
                c0212h = (C0212h) this.f729f.valueAt(size);
                if (c0212h != null && c0212h.f663w == i) {
                    return c0212h;
                }
            }
        }
        return null;
    }

    public C0212h m1186b(String str) {
        if (!(this.f729f == null || str == null)) {
            for (int size = this.f729f.size() - 1; size >= 0; size--) {
                C0212h c0212h = (C0212h) this.f729f.valueAt(size);
                if (c0212h != null) {
                    c0212h = c0212h.m948a(str);
                    if (c0212h != null) {
                        return c0212h;
                    }
                }
            }
        }
        return null;
    }

    public List<C0212h> mo183b() {
        if (this.f728e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<C0212h> list;
        synchronized (this.f728e) {
            list = (List) this.f728e.clone();
        }
        return list;
    }

    void m1188b(C0212h c0212h) {
        m1171a(c0212h, this.f735l, 0, 0, false);
    }

    void m1189b(C0212h c0212h, Context context, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1189b(c0212h, context, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1107b((C0221m) this, c0212h, context);
            }
        }
    }

    void m1190b(C0212h c0212h, Bundle bundle, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1190b(c0212h, bundle, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1108b((C0221m) this, c0212h, bundle);
            }
        }
    }

    void m1191b(C0212h c0212h, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1191b(c0212h, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1102a(this, c0212h);
            }
        }
    }

    public void m1192b(Menu menu) {
        for (int i = 0; i < this.f728e.size(); i++) {
            C0212h c0212h = (C0212h) this.f728e.get(i);
            if (c0212h != null) {
                c0212h.m988d(menu);
            }
        }
    }

    public void m1193b(boolean z) {
        for (int size = this.f728e.size() - 1; size >= 0; size--) {
            C0212h c0212h = (C0212h) this.f728e.get(size);
            if (c0212h != null) {
                c0212h.m993e(z);
            }
        }
    }

    public boolean m1194b(MenuItem menuItem) {
        for (int i = 0; i < this.f728e.size(); i++) {
            C0212h c0212h = (C0212h) this.f728e.get(i);
            if (c0212h != null && c0212h.m990d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m1195c(int i) {
        synchronized (this) {
            this.f732i.set(i, null);
            if (this.f733j == null) {
                this.f733j = new ArrayList();
            }
            if (f718a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f733j.add(Integer.valueOf(i));
        }
    }

    void m1196c(C0212h c0212h) {
        if (c0212h.f653m && !c0212h.f656p) {
            c0212h.f628H = c0212h.m973b(c0212h.m987d(c0212h.f643c), null, c0212h.f643c);
            if (c0212h.f628H != null) {
                c0212h.f629I = c0212h.f628H;
                c0212h.f628H.setSaveFromParentEnabled(false);
                if (c0212h.f666z) {
                    c0212h.f628H.setVisibility(8);
                }
                c0212h.m968a(c0212h.f628H, c0212h.f643c);
                m1174a(c0212h, c0212h.f628H, c0212h.f643c, false);
                return;
            }
            c0212h.f629I = null;
        }
    }

    void m1197c(C0212h c0212h, Bundle bundle, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1197c(c0212h, bundle, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1110c(this, c0212h, bundle);
            }
        }
    }

    void m1198c(C0212h c0212h, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1198c(c0212h, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1106b(this, c0212h);
            }
        }
    }

    public boolean mo184c() {
        return this.f741s;
    }

    void m1200d() {
        if (this.f729f != null) {
            for (int i = 0; i < this.f729f.size(); i++) {
                C0212h c0212h = (C0212h) this.f729f.valueAt(i);
                if (c0212h != null) {
                    m1170a(c0212h);
                }
            }
        }
    }

    void m1201d(final C0212h c0212h) {
        if (c0212h.f628H != null) {
            C0229c a = m1163a(c0212h, c0212h.m938N(), !c0212h.f666z, c0212h.m939O());
            if (a == null || a.f708b == null) {
                if (a != null) {
                    C0233n.m1150b(c0212h.f628H, a);
                    c0212h.f628H.startAnimation(a.f707a);
                    a.f707a.start();
                }
                int i = (!c0212h.f666z || c0212h.m946V()) ? 0 : 8;
                c0212h.f628H.setVisibility(i);
                if (c0212h.m946V()) {
                    c0212h.m996f(false);
                }
            } else {
                a.f708b.setTarget(c0212h.f628H);
                if (!c0212h.f666z) {
                    c0212h.f628H.setVisibility(0);
                } else if (c0212h.m946V()) {
                    c0212h.m996f(false);
                } else {
                    final ViewGroup viewGroup = c0212h.f627G;
                    final View view = c0212h.f628H;
                    viewGroup.startViewTransition(view);
                    a.f708b.addListener(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ C0233n f704d;

                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (c0212h.f628H != null) {
                                c0212h.f628H.setVisibility(8);
                            }
                        }
                    });
                }
                C0233n.m1150b(c0212h.f628H, a);
                a.f708b.start();
            }
        }
        if (c0212h.f651k && c0212h.f624D && c0212h.f625E) {
            this.f740r = true;
        }
        c0212h.f637Q = false;
        c0212h.m970a(c0212h.f666z);
    }

    void m1202d(C0212h c0212h, Bundle bundle, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1202d(c0212h, bundle, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1112d(this, c0212h, bundle);
            }
        }
    }

    void m1203d(C0212h c0212h, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1203d(c0212h, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1109c(this, c0212h);
            }
        }
    }

    void m1204e(C0212h c0212h) {
        if (c0212h != null) {
            int i = this.f735l;
            if (c0212h.f652l) {
                i = c0212h.m978b() ? Math.min(i, 1) : Math.min(i, 0);
            }
            m1171a(c0212h, i, c0212h.m938N(), c0212h.m939O(), false);
            if (c0212h.f628H != null) {
                C0212h p = m1157p(c0212h);
                if (p != null) {
                    View view = p.f628H;
                    ViewGroup viewGroup = c0212h.f627G;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    i = viewGroup.indexOfChild(c0212h.f628H);
                    if (i < indexOfChild) {
                        viewGroup.removeViewAt(i);
                        viewGroup.addView(c0212h.f628H, indexOfChild);
                    }
                }
                if (c0212h.f636P && c0212h.f627G != null) {
                    if (c0212h.f638R > 0.0f) {
                        c0212h.f628H.setAlpha(c0212h.f638R);
                    }
                    c0212h.f638R = 0.0f;
                    c0212h.f636P = false;
                    C0229c a = m1163a(c0212h, c0212h.m938N(), true, c0212h.m939O());
                    if (a != null) {
                        C0233n.m1150b(c0212h.f628H, a);
                        if (a.f707a != null) {
                            c0212h.f628H.startAnimation(a.f707a);
                        } else {
                            a.f708b.setTarget(c0212h.f628H);
                            a.f708b.start();
                        }
                    }
                }
            }
            if (c0212h.f637Q) {
                m1201d(c0212h);
            }
        }
    }

    void m1205e(C0212h c0212h, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1205e(c0212h, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1111d(this, c0212h);
            }
        }
    }

    public boolean m1206e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r1 = 1;
        r4.m1153c(r1);
        r0 = 0;
    L_0x0005:
        r2 = r4.f745w;
        r3 = r4.f746x;
        r2 = r4.m1154c(r2, r3);
        if (r2 == 0) goto L_0x0022;
    L_0x000f:
        r4.f726c = r1;
        r0 = r4.f745w;	 Catch:{ all -> 0x001d }
        r2 = r4.f746x;	 Catch:{ all -> 0x001d }
        r4.m1151b(r0, r2);	 Catch:{ all -> 0x001d }
        r4.m1160z();
        r0 = r1;
        goto L_0x0005;
    L_0x001d:
        r0 = move-exception;
        r4.m1160z();
        throw r0;
    L_0x0022:
        r4.m1207f();
        r4.m1130C();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.n.e():boolean");
    }

    void m1207f() {
        if (this.f744v) {
            int i = 0;
            for (int i2 = 0; i2 < this.f729f.size(); i2++) {
                C0212h c0212h = (C0212h) this.f729f.valueAt(i2);
                if (!(c0212h == null || c0212h.f632L == null)) {
                    i |= c0212h.f632L.mo185a();
                }
            }
            if (i == 0) {
                this.f744v = false;
                m1200d();
            }
        }
    }

    void m1208f(C0212h c0212h) {
        if (c0212h.f645e < 0) {
            int i = this.f727d;
            this.f727d = i + 1;
            c0212h.m954a(i, this.f738o);
            if (this.f729f == null) {
                this.f729f = new SparseArray();
            }
            this.f729f.put(c0212h.f645e, c0212h);
            if (f718a) {
                Log.v("FragmentManager", "Allocated fragment index " + c0212h);
            }
        }
    }

    void m1209f(C0212h c0212h, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1209f(c0212h, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1113e(this, c0212h);
            }
        }
    }

    void m1210g() {
        if (this.f734k != null) {
            for (int i = 0; i < this.f734k.size(); i++) {
                ((C0220b) this.f734k.get(i)).m1116a();
            }
        }
    }

    void m1211g(C0212h c0212h) {
        if (c0212h.f645e >= 0) {
            if (f718a) {
                Log.v("FragmentManager", "Freeing fragment index " + c0212h);
            }
            this.f729f.put(c0212h.f645e, null);
            this.f736m.m1027a(c0212h.f646f);
            c0212h.m1013p();
        }
    }

    void m1212g(C0212h c0212h, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1212g(c0212h, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1114f(this, c0212h);
            }
        }
    }

    C0234o m1213h() {
        C0233n.m1139a(this.f722C);
        return this.f722C;
    }

    public void m1214h(C0212h c0212h) {
        if (f718a) {
            Log.v("FragmentManager", "remove: " + c0212h + " nesting=" + c0212h.f657q);
        }
        boolean z = !c0212h.m978b();
        if (!c0212h.f621A || z) {
            synchronized (this.f728e) {
                this.f728e.remove(c0212h);
            }
            if (c0212h.f624D && c0212h.f625E) {
                this.f740r = true;
            }
            c0212h.f651k = false;
            c0212h.f652l = true;
        }
    }

    void m1215h(C0212h c0212h, boolean z) {
        if (this.f738o != null) {
            C0221m f = this.f738o.m994f();
            if (f instanceof C0233n) {
                ((C0233n) f).m1215h(c0212h, true);
            }
        }
        Iterator it = this.f724I.iterator();
        while (it.hasNext()) {
            C0345i c0345i = (C0345i) it.next();
            if (!z || ((Boolean) c0345i.f1011b).booleanValue()) {
                ((C0219a) c0345i.f1010a).m1115g(this, c0212h);
            }
        }
    }

    void m1216i() {
        List list;
        List list2;
        if (this.f729f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f729f.size()) {
                ArrayList arrayList;
                ArrayList arrayList2;
                C0212h c0212h = (C0212h) this.f729f.valueAt(i);
                if (c0212h != null) {
                    ArrayList arrayList3;
                    Object obj;
                    if (c0212h.f622B) {
                        if (list2 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(c0212h);
                        c0212h.f649i = c0212h.f648h != null ? c0212h.f648h.f645e : -1;
                        if (f718a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + c0212h);
                        }
                    }
                    if (c0212h.f660t != null) {
                        c0212h.f660t.m1216i();
                        obj = c0212h.f660t.f722C;
                    } else {
                        C0234o c0234o = c0212h.f661u;
                    }
                    if (list == null && obj != null) {
                        list = new ArrayList(this.f729f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list.add(null);
                        }
                    }
                    arrayList = list;
                    if (arrayList != null) {
                        arrayList.add(obj);
                    }
                    arrayList2 = arrayList3;
                } else {
                    List list3 = list;
                    list = list2;
                }
                i++;
                Object obj2 = arrayList2;
                Object obj3 = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            this.f722C = null;
        } else {
            this.f722C = new C0234o(list2, list);
        }
    }

    public void m1217i(C0212h c0212h) {
        boolean z = true;
        if (f718a) {
            Log.v("FragmentManager", "hide: " + c0212h);
        }
        if (!c0212h.f666z) {
            c0212h.f666z = true;
            if (c0212h.f637Q) {
                z = false;
            }
            c0212h.f637Q = z;
        }
    }

    Parcelable m1218j() {
        C0201d[] c0201dArr = null;
        m1128A();
        m1129B();
        m1206e();
        this.f741s = true;
        this.f722C = null;
        if (this.f729f == null || this.f729f.size() <= 0) {
            return null;
        }
        int size = this.f729f.size();
        C0238q[] c0238qArr = new C0238q[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            C0212h c0212h = (C0212h) this.f729f.valueAt(i);
            if (c0212h != null) {
                if (c0212h.f645e < 0) {
                    m1141a(new IllegalStateException("Failure saving state: active " + c0212h + " has cleared index: " + c0212h.f645e));
                }
                C0238q c0238q = new C0238q(c0212h);
                c0238qArr[i] = c0238q;
                if (c0212h.f642b <= 0 || c0238q.f766k != null) {
                    c0238q.f766k = c0212h.f643c;
                } else {
                    c0238q.f766k = m1226n(c0212h);
                    if (c0212h.f648h != null) {
                        if (c0212h.f648h.f645e < 0) {
                            m1141a(new IllegalStateException("Failure saving state: " + c0212h + " has target not in fragment manager: " + c0212h.f648h));
                        }
                        if (c0238q.f766k == null) {
                            c0238q.f766k = new Bundle();
                        }
                        m1167a(c0238q.f766k, "android:target_state", c0212h.f648h);
                        if (c0212h.f650j != 0) {
                            c0238q.f766k.putInt("android:target_req_state", c0212h.f650j);
                        }
                    }
                }
                if (f718a) {
                    Log.v("FragmentManager", "Saved state of " + c0212h + ": " + c0238q.f766k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            i = this.f728e.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((C0212h) this.f728e.get(i2)).f645e;
                    if (iArr[i2] < 0) {
                        m1141a(new IllegalStateException("Failure saving state: active " + this.f728e.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (f718a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f728e.get(i2));
                    }
                }
            } else {
                iArr = null;
            }
            if (this.f730g != null) {
                i = this.f730g.size();
                if (i > 0) {
                    c0201dArr = new C0201d[i];
                    for (i2 = 0; i2 < i; i2++) {
                        c0201dArr[i2] = new C0201d((C0199c) this.f730g.get(i2));
                        if (f718a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f730g.get(i2));
                        }
                    }
                }
            }
            C0236p c0236p = new C0236p();
            c0236p.f751a = c0238qArr;
            c0236p.f752b = iArr;
            c0236p.f753c = c0201dArr;
            if (this.f739p != null) {
                c0236p.f754d = this.f739p.f645e;
            }
            c0236p.f755e = this.f727d;
            m1216i();
            return c0236p;
        } else if (!f718a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m1219j(C0212h c0212h) {
        boolean z = false;
        if (f718a) {
            Log.v("FragmentManager", "show: " + c0212h);
        }
        if (c0212h.f666z) {
            c0212h.f666z = false;
            if (!c0212h.f637Q) {
                z = true;
            }
            c0212h.f637Q = z;
        }
    }

    public void m1220k() {
        this.f722C = null;
        this.f741s = false;
        int size = this.f728e.size();
        for (int i = 0; i < size; i++) {
            C0212h c0212h = (C0212h) this.f728e.get(i);
            if (c0212h != null) {
                c0212h.m929E();
            }
        }
    }

    public void m1221k(C0212h c0212h) {
        if (f718a) {
            Log.v("FragmentManager", "detach: " + c0212h);
        }
        if (!c0212h.f621A) {
            c0212h.f621A = true;
            if (c0212h.f651k) {
                if (f718a) {
                    Log.v("FragmentManager", "remove from detach: " + c0212h);
                }
                synchronized (this.f728e) {
                    this.f728e.remove(c0212h);
                }
                if (c0212h.f624D && c0212h.f625E) {
                    this.f740r = true;
                }
                c0212h.f651k = false;
            }
        }
    }

    public void m1222l() {
        this.f741s = false;
        m1156e(1);
    }

    public void m1223l(C0212h c0212h) {
        if (f718a) {
            Log.v("FragmentManager", "attach: " + c0212h);
        }
        if (c0212h.f621A) {
            c0212h.f621A = false;
            if (!c0212h.f651k) {
                if (this.f728e.contains(c0212h)) {
                    throw new IllegalStateException("Fragment already added: " + c0212h);
                }
                if (f718a) {
                    Log.v("FragmentManager", "add from attach: " + c0212h);
                }
                synchronized (this.f728e) {
                    this.f728e.add(c0212h);
                }
                c0212h.f651k = true;
                if (c0212h.f624D && c0212h.f625E) {
                    this.f740r = true;
                }
            }
        }
    }

    public void m1224m() {
        this.f741s = false;
        m1156e(2);
    }

    void m1225m(C0212h c0212h) {
        if (c0212h.f629I != null) {
            if (this.f720A == null) {
                this.f720A = new SparseArray();
            } else {
                this.f720A.clear();
            }
            c0212h.f629I.saveHierarchyState(this.f720A);
            if (this.f720A.size() > 0) {
                c0212h.f644d = this.f720A;
                this.f720A = null;
            }
        }
    }

    Bundle m1226n(C0212h c0212h) {
        Bundle bundle;
        if (this.f748z == null) {
            this.f748z = new Bundle();
        }
        c0212h.m1010m(this.f748z);
        m1202d(c0212h, this.f748z, false);
        if (this.f748z.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f748z;
            this.f748z = null;
        }
        if (c0212h.f628H != null) {
            m1225m(c0212h);
        }
        if (c0212h.f644d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", c0212h.f644d);
        }
        if (!c0212h.f631K) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", c0212h.f631K);
        }
        return bundle;
    }

    public void m1227n() {
        this.f741s = false;
        m1156e(4);
    }

    public void m1228o() {
        this.f741s = false;
        m1156e(5);
    }

    public void m1229o(C0212h c0212h) {
        if (c0212h == null || (this.f729f.get(c0212h.f645e) == c0212h && (c0212h.f659s == null || c0212h.m994f() == this))) {
            this.f739p = c0212h;
            return;
        }
        throw new IllegalArgumentException("Fragment " + c0212h + " is not an active fragment of FragmentManager " + this);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0231e.f710a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C0212h.m923a(this.f736m.m1039g(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        C0212h c0212h;
        C0212h b = resourceId != -1 ? m1185b(resourceId) : null;
        if (b == null && string2 != null) {
            b = m1162a(string2);
        }
        if (b == null && id != -1) {
            b = m1185b(id);
        }
        if (f718a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + b);
        }
        if (b == null) {
            C0212h a = this.f737n.mo158a(context, string, null);
            a.f653m = true;
            a.f663w = resourceId != 0 ? resourceId : id;
            a.f664x = id;
            a.f665y = string2;
            a.f654n = true;
            a.f658r = this;
            a.f659s = this.f736m;
            a.m960a(this.f736m.m1039g(), attributeSet, a.f643c);
            m1175a(a, true);
            c0212h = a;
        } else if (b.f654n) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            b.f654n = true;
            b.f659s = this.f736m;
            if (!b.f623C) {
                b.m960a(this.f736m.m1039g(), attributeSet, b.f643c);
            }
            c0212h = b;
        }
        if (this.f735l >= 1 || !c0212h.f653m) {
            m1188b(c0212h);
        } else {
            m1171a(c0212h, 1, 0, 0, false);
        }
        if (c0212h.f628H == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            c0212h.f628H.setId(resourceId);
        }
        if (c0212h.f628H.getTag() == null) {
            c0212h.f628H.setTag(string2);
        }
        return c0212h.f628H;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void m1230p() {
        m1156e(4);
    }

    public void m1231q() {
        this.f741s = true;
        m1156e(3);
    }

    public void m1232r() {
        m1156e(2);
    }

    public void m1233s() {
        m1156e(1);
    }

    public void m1234t() {
        this.f742t = true;
        m1206e();
        m1156e(0);
        this.f736m = null;
        this.f737n = null;
        this.f738o = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f738o != null) {
            C0336d.m1635a(this.f738o, stringBuilder);
        } else {
            C0336d.m1635a(this.f736m, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m1235u() {
        for (int i = 0; i < this.f728e.size(); i++) {
            C0212h c0212h = (C0212h) this.f728e.get(i);
            if (c0212h != null) {
                c0212h.m930F();
            }
        }
    }

    public C0212h m1236v() {
        return this.f739p;
    }

    Factory2 m1237w() {
        return this;
    }
}
