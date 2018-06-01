package android.support.v4.p008h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class C0433u {
    Runnable f1080a = null;
    Runnable f1081b = null;
    int f1082c = -1;
    private WeakReference<View> f1083d;

    static class C0432a implements C0119v {
        C0433u f1078a;
        boolean f1079b;

        C0432a(C0433u c0433u) {
            this.f1078a = c0433u;
        }

        public void mo100a(View view) {
            this.f1079b = false;
            if (this.f1078a.f1082c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f1078a.f1080a != null) {
                Runnable runnable = this.f1078a.f1080a;
                this.f1078a.f1080a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            C0119v c0119v = tag instanceof C0119v ? (C0119v) tag : null;
            if (c0119v != null) {
                c0119v.mo100a(view);
            }
        }

        public void mo101b(View view) {
            if (this.f1078a.f1082c > -1) {
                view.setLayerType(this.f1078a.f1082c, null);
                this.f1078a.f1082c = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.f1079b) {
                if (this.f1078a.f1081b != null) {
                    Runnable runnable = this.f1078a.f1081b;
                    this.f1078a.f1081b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                C0119v c0119v = tag instanceof C0119v ? (C0119v) tag : null;
                if (c0119v != null) {
                    c0119v.mo101b(view);
                }
                this.f1079b = true;
            }
        }

        public void mo102c(View view) {
            Object tag = view.getTag(2113929216);
            C0119v c0119v = tag instanceof C0119v ? (C0119v) tag : null;
            if (c0119v != null) {
                c0119v.mo102c(view);
            }
        }
    }

    C0433u(View view) {
        this.f1083d = new WeakReference(view);
    }

    private void m2012a(final View view, final C0119v c0119v) {
        if (c0119v != null) {
            view.animate().setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ C0433u f1074c;

                public void onAnimationCancel(Animator animator) {
                    c0119v.mo102c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    c0119v.mo101b(view);
                }

                public void onAnimationStart(Animator animator) {
                    c0119v.mo100a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public long m2013a() {
        View view = (View) this.f1083d.get();
        return view != null ? view.animate().getDuration() : 0;
    }

    public C0433u m2014a(float f) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public C0433u m2015a(long j) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public C0433u m2016a(C0119v c0119v) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                m2012a(view, c0119v);
            } else {
                view.setTag(2113929216, c0119v);
                m2012a(view, new C0432a(this));
            }
        }
        return this;
    }

    public C0433u m2017a(final C0434x c0434x) {
        final View view = (View) this.f1083d.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (c0434x != null) {
                animatorUpdateListener = new AnimatorUpdateListener(this) {
                    final /* synthetic */ C0433u f1077c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        c0434x.mo474a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public C0433u m2018a(Interpolator interpolator) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public C0433u m2019a(Runnable runnable) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                view.animate().withEndAction(runnable);
            } else {
                m2012a(view, new C0432a(this));
                this.f1081b = runnable;
            }
        }
        return this;
    }

    public C0433u m2020b(float f) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public C0433u m2021b(long j) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void m2022b() {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public C0433u m2023c(float f) {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public void m2024c() {
        View view = (View) this.f1083d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
