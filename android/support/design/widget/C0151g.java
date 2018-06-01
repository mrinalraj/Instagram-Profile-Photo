package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.design.widget.C0147h.C0107a;
import android.support.design.widget.C0172r.C0170d;
import android.support.v4.p008h.C0425s;

@TargetApi(14)
class C0151g extends C0148f {
    private float f472q = this.n.getRotation();

    C0151g(aa aaVar, C0110n c0110n, C0170d c0170d) {
        super(aaVar, c0110n, c0170d);
    }

    private boolean m728o() {
        return C0425s.m1986y(this.n) && !this.n.isInEditMode();
    }

    private void m729p() {
        if (VERSION.SDK_INT == 19) {
            if (this.f472q % 90.0f != 0.0f) {
                if (this.n.getLayerType() != 1) {
                    this.n.setLayerType(1, null);
                }
            } else if (this.n.getLayerType() != 0) {
                this.n.setLayerType(0, null);
            }
        }
        if (this.a != null) {
            this.a.m757a(-this.f472q);
        }
        if (this.f != null) {
            this.f.m662b(-this.f472q);
        }
    }

    void mo123a(final C0107a c0107a, final boolean z) {
        if (!m713n()) {
            this.n.animate().cancel();
            if (m728o()) {
                this.c = 1;
                this.n.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0118a.f402c).setListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ C0151g f467c;
                    private boolean f468d;

                    public void onAnimationCancel(Animator animator) {
                        this.f468d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.f467c.c = 0;
                        if (!this.f468d) {
                            this.f467c.n.m583a(z ? 8 : 4, z);
                            if (c0107a != null) {
                                c0107a.mo90b();
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        this.f467c.n.m583a(0, z);
                        this.f468d = false;
                    }
                });
                return;
            }
            this.n.m583a(z ? 8 : 4, z);
            if (c0107a != null) {
                c0107a.mo90b();
            }
        }
    }

    void mo126b(final C0107a c0107a, final boolean z) {
        if (!m712m()) {
            this.n.animate().cancel();
            if (m728o()) {
                this.c = 2;
                if (this.n.getVisibility() != 0) {
                    this.n.setAlpha(0.0f);
                    this.n.setScaleY(0.0f);
                    this.n.setScaleX(0.0f);
                }
                this.n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0118a.f403d).setListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ C0151g f471c;

                    public void onAnimationEnd(Animator animator) {
                        this.f471c.c = 0;
                        if (c0107a != null) {
                            c0107a.mo89a();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        this.f471c.n.m583a(0, z);
                    }
                });
                return;
            }
            this.n.m583a(0, z);
            this.n.setAlpha(1.0f);
            this.n.setScaleY(1.0f);
            this.n.setScaleX(1.0f);
            if (c0107a != null) {
                c0107a.mo89a();
            }
        }
    }

    boolean mo128d() {
        return true;
    }

    void mo129e() {
        float rotation = this.n.getRotation();
        if (this.f472q != rotation) {
            this.f472q = rotation;
            m729p();
        }
    }
}
