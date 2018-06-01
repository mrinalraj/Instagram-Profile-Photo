package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.C0066a.C0056a;
import android.support.design.C0066a.C0063h;
import android.support.design.C0066a.C0065j;
import android.support.design.widget.C0161o.C0124a;
import android.support.design.widget.CoordinatorLayout.C0081a;
import android.support.design.widget.CoordinatorLayout.C0101d;
import android.support.design.widget.SwipeDismissBehavior.C0115a;
import android.support.v4.p008h.C0097o;
import android.support.v4.p008h.C0120w;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0435y;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;

public abstract class C0113b<B extends C0113b<B>> {
    static final Handler f375a = new Handler(Looper.getMainLooper(), new C01211());
    final C0112f f376b;
    final C0124a f377c = new C01254(this);
    private final ViewGroup f378d;
    private final Context f379e;
    private final C0073c f380f;
    private int f381g;
    private List<C0134a<B>> f382h;
    private final AccessibilityManager f383i;

    public interface C0073c {
        void mo32a(int i, int i2);

        void mo33b(int i, int i2);
    }

    static class C0112f extends FrameLayout {
        private C0130e f373a;
        private C0128d f374b;

        C0112f(Context context) {
            this(context, null);
        }

        C0112f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(C0065j.SnackbarLayout_elevation)) {
                C0425s.m1962d((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C0065j.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f374b != null) {
                this.f374b.mo107a(this);
            }
            C0425s.m1979r(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f374b != null) {
                this.f374b.mo108b(this);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f373a != null) {
                this.f373a.mo109a(this, i, i2, i3, i4);
            }
        }

        void setOnAttachStateChangeListener(C0128d c0128d) {
            this.f374b = c0128d;
        }

        void setOnLayoutChangeListener(C0130e c0130e) {
            this.f373a = c0130e;
        }
    }

    static class C01211 implements Callback {
        C01211() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((C0113b) message.obj).m598c();
                    return true;
                case 1:
                    ((C0113b) message.obj).m599c(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    }

    class C01233 implements C0097o {
        final /* synthetic */ C0113b f409a;

        C01233(C0113b c0113b) {
            this.f409a = c0113b;
        }

        public C0435y mo81a(View view, C0435y c0435y) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), c0435y.m2032d());
            return c0435y;
        }
    }

    class C01254 implements C0124a {
        final /* synthetic */ C0113b f410a;

        C01254(C0113b c0113b) {
            this.f410a = c0113b;
        }

        public void mo103a() {
            C0113b.f375a.sendMessage(C0113b.f375a.obtainMessage(0, this.f410a));
        }

        public void mo104a(int i) {
            C0113b.f375a.sendMessage(C0113b.f375a.obtainMessage(1, i, 0, this.f410a));
        }
    }

    class C01265 implements C0115a {
        final /* synthetic */ C0113b f411a;

        C01265(C0113b c0113b) {
            this.f411a = c0113b;
        }

        public void mo105a(int i) {
            switch (i) {
                case 0:
                    C0161o.m762a().m774d(this.f411a.f377c);
                    return;
                case 1:
                case 2:
                    C0161o.m762a().m773c(this.f411a.f377c);
                    return;
                default:
                    return;
            }
        }

        public void mo106a(View view) {
            view.setVisibility(8);
            this.f411a.m596b(0);
        }
    }

    interface C0128d {
        void mo107a(View view);

        void mo108b(View view);
    }

    class C01296 implements C0128d {
        final /* synthetic */ C0113b f413a;

        class C01271 implements Runnable {
            final /* synthetic */ C01296 f412a;

            C01271(C01296 c01296) {
                this.f412a = c01296;
            }

            public void run() {
                this.f412a.f413a.m601d(3);
            }
        }

        C01296(C0113b c0113b) {
            this.f413a = c0113b;
        }

        public void mo107a(View view) {
        }

        public void mo108b(View view) {
            if (this.f413a.m597b()) {
                C0113b.f375a.post(new C01271(this));
            }
        }
    }

    interface C0130e {
        void mo109a(View view, int i, int i2, int i3, int i4);
    }

    class C01317 implements C0130e {
        final /* synthetic */ C0113b f414a;

        C01317(C0113b c0113b) {
            this.f414a = c0113b;
        }

        public void mo109a(View view, int i, int i2, int i3, int i4) {
            this.f414a.f376b.setOnLayoutChangeListener(null);
            if (this.f414a.m603f()) {
                this.f414a.m600d();
            } else {
                this.f414a.m602e();
            }
        }
    }

    class C01328 extends C0120w {
        final /* synthetic */ C0113b f415a;

        C01328(C0113b c0113b) {
            this.f415a = c0113b;
        }

        public void mo100a(View view) {
            this.f415a.f380f.mo32a(70, 180);
        }

        public void mo101b(View view) {
            this.f415a.m602e();
        }
    }

    class C01339 implements AnimationListener {
        final /* synthetic */ C0113b f416a;

        C01339(C0113b c0113b) {
            this.f416a = c0113b;
        }

        public void onAnimationEnd(Animation animation) {
            this.f416a.m602e();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static abstract class C0134a<B> {
        public void m653a(B b) {
        }

        public void m654a(B b, int i) {
        }
    }

    final class C0135b extends SwipeDismissBehavior<C0112f> {
        final /* synthetic */ C0113b f417a;

        C0135b(C0113b c0113b) {
            this.f417a = c0113b;
        }

        public boolean m655a(CoordinatorLayout coordinatorLayout, C0112f c0112f, MotionEvent motionEvent) {
            if (coordinatorLayout.m547a((View) c0112f, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        C0161o.m762a().m773c(this.f417a.f377c);
                        break;
                    case 1:
                    case 3:
                        C0161o.m762a().m774d(this.f417a.f377c);
                        break;
                }
            }
            return super.mo39a(coordinatorLayout, (View) c0112f, motionEvent);
        }

        public boolean mo110a(View view) {
            return view instanceof C0112f;
        }
    }

    protected C0113b(ViewGroup viewGroup, View view, C0073c c0073c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (c0073c == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        } else {
            this.f378d = viewGroup;
            this.f380f = c0073c;
            this.f379e = viewGroup.getContext();
            C0165q.m782a(this.f379e);
            this.f376b = (C0112f) LayoutInflater.from(this.f379e).inflate(C0063h.design_layout_snackbar, this.f378d, false);
            this.f376b.addView(view);
            C0425s.m1963d(this.f376b, 1);
            C0425s.m1960c(this.f376b, 1);
            C0425s.m1952a(this.f376b, true);
            C0425s.m1949a(this.f376b, new C01233(this));
            this.f383i = (AccessibilityManager) this.f379e.getSystemService("accessibility");
        }
    }

    private void m593e(final int i) {
        if (VERSION.SDK_INT >= 14) {
            C0425s.m1976o(this.f376b).m2023c((float) this.f376b.getHeight()).m2018a(C0118a.f401b).m2015a(250).m2016a(new C0120w(this) {
                final /* synthetic */ C0113b f406b;

                public void mo100a(View view) {
                    this.f406b.f380f.mo33b(0, 180);
                }

                public void mo101b(View view) {
                    this.f406b.m601d(i);
                }
            }).m2024c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f376b.getContext(), C0056a.design_snackbar_out);
        loadAnimation.setInterpolator(C0118a.f401b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ C0113b f408b;

            public void onAnimationEnd(Animation animation) {
                this.f408b.m601d(i);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.f376b.startAnimation(loadAnimation);
    }

    public B m594a(int i) {
        this.f381g = i;
        return this;
    }

    public void m595a() {
        C0161o.m762a().m768a(this.f381g, this.f377c);
    }

    void m596b(int i) {
        C0161o.m762a().m770a(this.f377c, i);
    }

    public boolean m597b() {
        return C0161o.m762a().m775e(this.f377c);
    }

    final void m598c() {
        if (this.f376b.getParent() == null) {
            LayoutParams layoutParams = this.f376b.getLayoutParams();
            if (layoutParams instanceof C0101d) {
                C0101d c0101d = (C0101d) layoutParams;
                C0081a c0135b = new C0135b(this);
                c0135b.m622a(0.1f);
                c0135b.m627b(0.6f);
                c0135b.m623a(0);
                c0135b.m624a(new C01265(this));
                c0101d.m494a(c0135b);
                c0101d.f316g = 80;
            }
            this.f378d.addView(this.f376b);
        }
        this.f376b.setOnAttachStateChangeListener(new C01296(this));
        if (!C0425s.m1986y(this.f376b)) {
            this.f376b.setOnLayoutChangeListener(new C01317(this));
        } else if (m603f()) {
            m600d();
        } else {
            m602e();
        }
    }

    final void m599c(int i) {
        if (m603f() && this.f376b.getVisibility() == 0) {
            m593e(i);
        } else {
            m601d(i);
        }
    }

    void m600d() {
        if (VERSION.SDK_INT >= 14) {
            C0425s.m1955b(this.f376b, (float) this.f376b.getHeight());
            C0425s.m1976o(this.f376b).m2023c(0.0f).m2018a(C0118a.f401b).m2015a(250).m2016a(new C01328(this)).m2024c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f376b.getContext(), C0056a.design_snackbar_in);
        loadAnimation.setInterpolator(C0118a.f401b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C01339(this));
        this.f376b.startAnimation(loadAnimation);
    }

    void m601d(int i) {
        C0161o.m762a().m769a(this.f377c);
        if (this.f382h != null) {
            for (int size = this.f382h.size() - 1; size >= 0; size--) {
                ((C0134a) this.f382h.get(size)).m654a(this, i);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.f376b.setVisibility(8);
        }
        ViewParent parent = this.f376b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f376b);
        }
    }

    void m602e() {
        C0161o.m762a().m772b(this.f377c);
        if (this.f382h != null) {
            for (int size = this.f382h.size() - 1; size >= 0; size--) {
                ((C0134a) this.f382h.get(size)).m653a(this);
            }
        }
    }

    boolean m603f() {
        return !this.f383i.isEnabled();
    }
}
