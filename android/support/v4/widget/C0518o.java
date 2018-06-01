package android.support.v4.widget;

import android.content.Context;
import android.support.v4.p008h.C0425s;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public class C0518o {
    private static final Interpolator f1256v = new C05161();
    private int f1257a;
    private int f1258b;
    private int f1259c = -1;
    private float[] f1260d;
    private float[] f1261e;
    private float[] f1262f;
    private float[] f1263g;
    private int[] f1264h;
    private int[] f1265i;
    private int[] f1266j;
    private int f1267k;
    private VelocityTracker f1268l;
    private float f1269m;
    private float f1270n;
    private int f1271o;
    private int f1272p;
    private OverScroller f1273q;
    private final C0087a f1274r;
    private View f1275s;
    private boolean f1276t;
    private final ViewGroup f1277u;
    private final Runnable f1278w = new C05172(this);

    public static abstract class C0087a {
        public int mo64a(View view) {
            return 0;
        }

        public int mo65a(View view, int i, int i2) {
            return 0;
        }

        public void mo66a(int i) {
        }

        public void m443a(int i, int i2) {
        }

        public void mo67a(View view, float f, float f2) {
        }

        public void mo68a(View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean mo69a(View view, int i);

        public int mo98b(View view) {
            return 0;
        }

        public int mo70b(View view, int i, int i2) {
            return 0;
        }

        public void m449b(int i, int i2) {
        }

        public void mo99b(View view, int i) {
        }

        public boolean m451b(int i) {
            return false;
        }

        public int m452c(int i) {
            return i;
        }
    }

    static class C05161 implements Interpolator {
        C05161() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C05172 implements Runnable {
        final /* synthetic */ C0518o f1255a;

        C05172(C0518o c0518o) {
            this.f1255a = c0518o;
        }

        public void run() {
            this.f1255a.m2482b(0);
        }
    }

    private C0518o(Context context, ViewGroup viewGroup, C0087a c0087a) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0087a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1277u = viewGroup;
            this.f1274r = c0087a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1271o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1258b = viewConfiguration.getScaledTouchSlop();
            this.f1269m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1270n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1273q = new OverScroller(context, f1256v);
        }
    }

    private float m2453a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    private float m2454a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m2455a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1277u.getWidth();
        int i4 = width / 2;
        float a = (m2453a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m2456a(View view, int i, int i2, int i3, int i4) {
        int b = m2464b(i3, (int) this.f1270n, (int) this.f1269m);
        int b2 = m2464b(i4, (int) this.f1270n, (int) this.f1269m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2455a(i2, b2, this.f1274r.mo64a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2455a(i, b, this.f1274r.mo98b(view)))));
    }

    public static C0518o m2457a(ViewGroup viewGroup, float f, C0087a c0087a) {
        C0518o a = C0518o.m2458a(viewGroup, c0087a);
        a.f1258b = (int) (((float) a.f1258b) * (1.0f / f));
        return a;
    }

    public static C0518o m2458a(ViewGroup viewGroup, C0087a c0087a) {
        return new C0518o(viewGroup.getContext(), viewGroup, c0087a);
    }

    private void m2459a(float f, float f2) {
        this.f1276t = true;
        this.f1274r.mo67a(this.f1275s, f, f2);
        this.f1276t = false;
        if (this.f1257a == 1) {
            m2482b(0);
        }
    }

    private void m2460a(float f, float f2, int i) {
        m2472d(i);
        float[] fArr = this.f1260d;
        this.f1262f[i] = f;
        fArr[i] = f;
        fArr = this.f1261e;
        this.f1263g[i] = f2;
        fArr[i] = f2;
        this.f1264h[i] = m2470d((int) f, (int) f2);
        this.f1267k |= 1 << i;
    }

    private boolean m2461a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1264h[i] & i2) != i2 || (this.f1272p & i2) == 0 || (this.f1266j[i] & i2) == i2 || (this.f1265i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1258b) && abs2 <= ((float) this.f1258b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f1274r.m451b(i2)) {
            return (this.f1265i[i] & i2) == 0 && abs > ((float) this.f1258b);
        } else {
            int[] iArr = this.f1266j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m2462a(int i, int i2, int i3, int i4) {
        int left = this.f1275s.getLeft();
        int top = this.f1275s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1273q.abortAnimation();
            m2482b(0);
            return false;
        }
        this.f1273q.startScroll(left, top, i5, i6, m2456a(this.f1275s, i5, i6, i3, i4));
        m2482b(2);
        return true;
    }

    private boolean m2463a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1274r.mo98b(view) > 0;
        boolean z2 = this.f1274r.mo64a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f1258b * this.f1258b)) : z ? Math.abs(f) > ((float) this.f1258b) : z2 ? Math.abs(f2) > ((float) this.f1258b) : false;
    }

    private int m2464b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m2465b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2461a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2461a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2461a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2461a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1265i;
            iArr[i] = iArr[i] | i2;
            this.f1274r.m449b(i2, i);
        }
    }

    private void m2466b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.f1275s.getLeft();
        int top = this.f1275s.getTop();
        if (i3 != 0) {
            b = this.f1274r.mo70b(this.f1275s, i, i3);
            C0425s.m1967f(this.f1275s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.f1274r.mo65a(this.f1275s, i2, i4);
            C0425s.m1965e(this.f1275s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1274r.mo68a(this.f1275s, b, a, b - left, a - top);
        }
    }

    private void m2467c() {
        if (this.f1260d != null) {
            Arrays.fill(this.f1260d, 0.0f);
            Arrays.fill(this.f1261e, 0.0f);
            Arrays.fill(this.f1262f, 0.0f);
            Arrays.fill(this.f1263g, 0.0f);
            Arrays.fill(this.f1264h, 0);
            Arrays.fill(this.f1265i, 0);
            Arrays.fill(this.f1266j, 0);
            this.f1267k = 0;
        }
    }

    private void m2468c(int i) {
        if (this.f1260d != null && m2476a(i)) {
            this.f1260d[i] = 0.0f;
            this.f1261e[i] = 0.0f;
            this.f1262f[i] = 0.0f;
            this.f1263g[i] = 0.0f;
            this.f1264h[i] = 0;
            this.f1265i[i] = 0;
            this.f1266j[i] = 0;
            this.f1267k &= (1 << i) ^ -1;
        }
    }

    private void m2469c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m2473e(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1262f[pointerId] = x;
                this.f1263g[pointerId] = y;
            }
        }
    }

    private int m2470d(int i, int i2) {
        int i3 = 0;
        if (i < this.f1277u.getLeft() + this.f1271o) {
            i3 = 1;
        }
        if (i2 < this.f1277u.getTop() + this.f1271o) {
            i3 |= 4;
        }
        if (i > this.f1277u.getRight() - this.f1271o) {
            i3 |= 2;
        }
        return i2 > this.f1277u.getBottom() - this.f1271o ? i3 | 8 : i3;
    }

    private void m2471d() {
        this.f1268l.computeCurrentVelocity(1000, this.f1269m);
        m2459a(m2454a(this.f1268l.getXVelocity(this.f1259c), this.f1270n, this.f1269m), m2454a(this.f1268l.getYVelocity(this.f1259c), this.f1270n, this.f1269m));
    }

    private void m2472d(int i) {
        if (this.f1260d == null || this.f1260d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1260d != null) {
                System.arraycopy(this.f1260d, 0, obj, 0, this.f1260d.length);
                System.arraycopy(this.f1261e, 0, obj2, 0, this.f1261e.length);
                System.arraycopy(this.f1262f, 0, obj3, 0, this.f1262f.length);
                System.arraycopy(this.f1263g, 0, obj4, 0, this.f1263g.length);
                System.arraycopy(this.f1264h, 0, obj5, 0, this.f1264h.length);
                System.arraycopy(this.f1265i, 0, obj6, 0, this.f1265i.length);
                System.arraycopy(this.f1266j, 0, obj7, 0, this.f1266j.length);
            }
            this.f1260d = obj;
            this.f1261e = obj2;
            this.f1262f = obj3;
            this.f1263g = obj4;
            this.f1264h = obj5;
            this.f1265i = obj6;
            this.f1266j = obj7;
        }
    }

    private boolean m2473e(int i) {
        if (m2476a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public int m2474a() {
        return this.f1258b;
    }

    public void m2475a(View view, int i) {
        if (view.getParent() != this.f1277u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1277u + ")");
        }
        this.f1275s = view;
        this.f1259c = i;
        this.f1274r.mo99b(view, i);
        m2482b(1);
    }

    public boolean m2476a(int i) {
        return (this.f1267k & (1 << i)) != 0;
    }

    public boolean m2477a(int i, int i2) {
        if (this.f1276t) {
            return m2462a(i, i2, (int) this.f1268l.getXVelocity(this.f1259c), (int) this.f1268l.getYVelocity(this.f1259c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2478a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = r14.getActionMasked();
        r1 = r14.getActionIndex();
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m2481b();
    L_0x000d:
        r2 = r13.f1268l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1268l = r2;
    L_0x0017:
        r2 = r13.f1268l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1257a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = r14.getPointerId(r2);
        r13.m2460a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m2487c(r0, r1);
        r1 = r13.f1275s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1257a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m2485b(r0, r2);
    L_0x0048:
        r0 = r13.f1264h;
        r0 = r0[r2];
        r1 = r13.f1272p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1274r;
        r3 = r13.f1272p;
        r0 = r0 & r3;
        r1.m443a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = r14.getPointerId(r1);
        r2 = r14.getX(r1);
        r1 = r14.getY(r1);
        r13.m2460a(r2, r1, r0);
        r3 = r13.f1257a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1264h;
        r1 = r1[r0];
        r2 = r13.f1272p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1274r;
        r3 = r13.f1272p;
        r1 = r1 & r3;
        r2.m443a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1257a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m2487c(r2, r1);
        r2 = r13.f1275s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m2485b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1260d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1261e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = r14.getPointerCount();
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = r14.getPointerId(r1);
        r0 = r13.m2473e(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = r14.getX(r1);
        r4 = r14.getY(r1);
        r5 = r13.f1260d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1261e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m2487c(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m2463a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1274r;
        r10 = (int) r5;
        r8 = r9.mo70b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1274r;
        r12 = (int) r6;
        r10 = r11.mo65a(r4, r10, r12);
        r11 = r13.f1274r;
        r11 = r11.mo98b(r4);
        r12 = r13.f1274r;
        r12 = r12.mo64a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m2469c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m2465b(r5, r6, r3);
        r5 = r13.f1257a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m2485b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = r14.getPointerId(r1);
        r13.m2468c(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m2481b();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.o.a(android.view.MotionEvent):boolean");
    }

    public boolean m2479a(View view, int i, int i2) {
        this.f1275s = view;
        this.f1259c = -1;
        boolean a = m2462a(i, i2, 0, 0);
        if (!(a || this.f1257a != 0 || this.f1275s == null)) {
            this.f1275s = null;
        }
        return a;
    }

    public boolean m2480a(boolean z) {
        if (this.f1257a == 2) {
            int i;
            boolean computeScrollOffset = this.f1273q.computeScrollOffset();
            int currX = this.f1273q.getCurrX();
            int currY = this.f1273q.getCurrY();
            int left = currX - this.f1275s.getLeft();
            int top = currY - this.f1275s.getTop();
            if (left != 0) {
                C0425s.m1967f(this.f1275s, left);
            }
            if (top != 0) {
                C0425s.m1965e(this.f1275s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1274r.mo68a(this.f1275s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1273q.getFinalX() && currY == this.f1273q.getFinalY()) {
                this.f1273q.abortAnimation();
                i = 0;
            } else {
                boolean z2 = computeScrollOffset;
            }
            if (i == 0) {
                if (z) {
                    this.f1277u.post(this.f1278w);
                } else {
                    m2482b(0);
                }
            }
        }
        return this.f1257a == 2;
    }

    public void m2481b() {
        this.f1259c = -1;
        m2467c();
        if (this.f1268l != null) {
            this.f1268l.recycle();
            this.f1268l = null;
        }
    }

    void m2482b(int i) {
        this.f1277u.removeCallbacks(this.f1278w);
        if (this.f1257a != i) {
            this.f1257a = i;
            this.f1274r.mo66a(i);
            if (this.f1257a == 0) {
                this.f1275s = null;
            }
        }
    }

    public void m2483b(MotionEvent motionEvent) {
        int i = 0;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m2481b();
        }
        if (this.f1268l == null) {
            this.f1268l = VelocityTracker.obtain();
        }
        this.f1268l.addMovement(motionEvent);
        float x;
        float y;
        View c;
        int i2;
        switch (actionMasked) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = motionEvent.getPointerId(0);
                c = m2487c((int) x, (int) y);
                m2460a(x, y, i);
                m2485b(c, i);
                i2 = this.f1264h[i];
                if ((this.f1272p & i2) != 0) {
                    this.f1274r.m443a(i2 & this.f1272p, i);
                    return;
                }
                return;
            case 1:
                if (this.f1257a == 1) {
                    m2471d();
                }
                m2481b();
                return;
            case 2:
                if (this.f1257a != 1) {
                    i2 = motionEvent.getPointerCount();
                    while (i < i2) {
                        actionMasked = motionEvent.getPointerId(i);
                        if (m2473e(actionMasked)) {
                            float x2 = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x2 - this.f1260d[actionMasked];
                            float f2 = y2 - this.f1261e[actionMasked];
                            m2465b(f, f2, actionMasked);
                            if (this.f1257a != 1) {
                                c = m2487c((int) x2, (int) y2);
                                if (m2463a(c, f, f2) && m2485b(c, actionMasked)) {
                                }
                            }
                            m2469c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m2469c(motionEvent);
                    return;
                } else if (m2473e(this.f1259c)) {
                    i = motionEvent.findPointerIndex(this.f1259c);
                    x = motionEvent.getX(i);
                    i2 = (int) (x - this.f1262f[this.f1259c]);
                    i = (int) (motionEvent.getY(i) - this.f1263g[this.f1259c]);
                    m2466b(this.f1275s.getLeft() + i2, this.f1275s.getTop() + i, i2, i);
                    m2469c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f1257a == 1) {
                    m2459a(0.0f, 0.0f);
                }
                m2481b();
                return;
            case 5:
                i = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                m2460a(x, y, i);
                if (this.f1257a == 0) {
                    m2485b(m2487c((int) x, (int) y), i);
                    i2 = this.f1264h[i];
                    if ((this.f1272p & i2) != 0) {
                        this.f1274r.m443a(i2 & this.f1272p, i);
                        return;
                    }
                    return;
                } else if (m2484b((int) x, (int) y)) {
                    m2485b(this.f1275s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.f1257a == 1 && actionMasked == this.f1259c) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.f1259c) {
                            if (m2487c((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.f1275s && m2485b(this.f1275s, pointerId)) {
                                i = this.f1259c;
                                if (i == -1) {
                                    m2471d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m2471d();
                    }
                }
                m2468c(actionMasked);
                return;
            default:
                return;
        }
    }

    public boolean m2484b(int i, int i2) {
        return m2486b(this.f1275s, i, i2);
    }

    boolean m2485b(View view, int i) {
        if (view == this.f1275s && this.f1259c == i) {
            return true;
        }
        if (view == null || !this.f1274r.mo69a(view, i)) {
            return false;
        }
        this.f1259c = i;
        m2475a(view, i);
        return true;
    }

    public boolean m2486b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m2487c(int i, int i2) {
        for (int childCount = this.f1277u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1277u.getChildAt(this.f1274r.m452c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
