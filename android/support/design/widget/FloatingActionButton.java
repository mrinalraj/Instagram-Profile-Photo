package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0066a.C0059d;
import android.support.design.C0066a.C0064i;
import android.support.design.C0066a.C0065j;
import android.support.design.widget.C0147h.C0107a;
import android.support.design.widget.CoordinatorLayout.C0081a;
import android.support.design.widget.CoordinatorLayout.C0099b;
import android.support.design.widget.CoordinatorLayout.C0101d;
import android.support.v4.p008h.C0425s;
import android.support.v4.p013b.p014a.C0263a;
import android.support.v7.widget.C0829p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

@C0099b(a = Behavior.class)
public class FloatingActionButton extends aa {
    int f361a;
    boolean f362b;
    final Rect f363c;
    private ColorStateList f364d;
    private Mode f365e;
    private int f366f;
    private int f367g;
    private int f368h;
    private int f369i;
    private final Rect f370j;
    private C0829p f371k;
    private C0147h f372l;

    public static class Behavior extends C0081a<FloatingActionButton> {
        private Rect f356a;
        private C0109a f357b;
        private boolean f358c;

        public Behavior() {
            this.f358c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.FloatingActionButton_Behavior_Layout);
            this.f358c = obtainStyledAttributes.getBoolean(C0065j.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private void m561a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect rect = floatingActionButton.f363c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                C0101d c0101d = (C0101d) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0101d.rightMargin ? rect.right : floatingActionButton.getLeft() <= c0101d.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - c0101d.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= c0101d.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    C0425s.m1965e(floatingActionButton, i);
                }
                if (i2 != 0) {
                    C0425s.m1967f(floatingActionButton, i2);
                }
            }
        }

        private boolean m562a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m564a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f356a == null) {
                this.f356a = new Rect();
            }
            Rect rect = this.f356a;
            C0181u.m850b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m591b(this.f357b, false);
            } else {
                floatingActionButton.m589a(this.f357b, false);
            }
            return true;
        }

        private static boolean m563a(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            return layoutParams instanceof C0101d ? ((C0101d) layoutParams).m498b() instanceof BottomSheetBehavior : false;
        }

        private boolean m564a(View view, FloatingActionButton floatingActionButton) {
            return !this.f358c ? false : ((C0101d) floatingActionButton.getLayoutParams()).m492a() != view.getId() ? false : floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean m565b(View view, FloatingActionButton floatingActionButton) {
            if (!m564a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((C0101d) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.m591b(this.f357b, false);
            } else {
                floatingActionButton.m589a(this.f357b, false);
            }
            return true;
        }

        public void mo91a(C0101d c0101d) {
            if (c0101d.f317h == 0) {
                c0101d.f317h = 80;
            }
        }

        public boolean m567a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List c = coordinatorLayout.m552c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) c.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (m563a(view) && m565b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m562a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m542a((View) floatingActionButton, i);
            m561a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean m568a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f363c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean m569a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m562a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (m563a(view)) {
                m565b(view, floatingActionButton);
            }
            return false;
        }

        public /* synthetic */ boolean mo63c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m569a(coordinatorLayout, (FloatingActionButton) view, view2);
        }
    }

    public static abstract class C0109a {
        public void m573a(FloatingActionButton floatingActionButton) {
        }

        public void m574b(FloatingActionButton floatingActionButton) {
        }
    }

    private class C0111b implements C0110n {
        final /* synthetic */ FloatingActionButton f359a;

        C0111b(FloatingActionButton floatingActionButton) {
            this.f359a = floatingActionButton;
        }

        public float mo93a() {
            return ((float) this.f359a.getSizeDimension()) / 2.0f;
        }

        public void mo94a(int i, int i2, int i3, int i4) {
            this.f359a.f363c.set(i, i2, i3, i4);
            this.f359a.setPadding(this.f359a.f361a + i, this.f359a.f361a + i2, this.f359a.f361a + i3, this.f359a.f361a + i4);
        }

        public void mo95a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean mo96b() {
            return this.f359a.f362b;
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f363c = new Rect();
        this.f370j = new Rect();
        C0165q.m782a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.FloatingActionButton, i, C0064i.Widget_Design_FloatingActionButton);
        this.f364d = obtainStyledAttributes.getColorStateList(C0065j.FloatingActionButton_backgroundTint);
        this.f365e = C0185y.m859a(obtainStyledAttributes.getInt(C0065j.FloatingActionButton_backgroundTintMode, -1), null);
        this.f367g = obtainStyledAttributes.getColor(C0065j.FloatingActionButton_rippleColor, 0);
        this.f368h = obtainStyledAttributes.getInt(C0065j.FloatingActionButton_fabSize, -1);
        this.f366f = obtainStyledAttributes.getDimensionPixelSize(C0065j.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(C0065j.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0065j.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f362b = obtainStyledAttributes.getBoolean(C0065j.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.f371k = new C0829p(this);
        this.f371k.m4758a(attributeSet, i);
        this.f369i = (int) getResources().getDimension(C0059d.design_fab_image_size);
        getImpl().mo120a(this.f364d, this.f365e, this.f367g, this.f366f);
        getImpl().m689a(dimension);
        getImpl().m699b(dimension2);
    }

    private int m584a(int i) {
        Resources resources = getResources();
        switch (i) {
            case -1:
                return Math.max(C0263a.m1338b(resources), C0263a.m1337a(resources)) < 470 ? m584a(1) : m584a(0);
            case 1:
                return resources.getDimensionPixelSize(C0059d.design_fab_size_mini);
            default:
                return resources.getDimensionPixelSize(C0059d.design_fab_size_normal);
        }
    }

    private static int m585a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private C0107a m586a(final C0109a c0109a) {
        return c0109a == null ? null : new C0107a(this) {
            final /* synthetic */ FloatingActionButton f355b;

            public void mo89a() {
                c0109a.m573a(this.f355b);
            }

            public void mo90b() {
                c0109a.m574b(this.f355b);
            }
        };
    }

    private C0147h m587a() {
        int i = VERSION.SDK_INT;
        return i >= 21 ? new C0154i(this, new C0111b(this), C0185y.f542a) : i >= 14 ? new C0151g(this, new C0111b(this), C0185y.f542a) : new C0148f(this, new C0111b(this), C0185y.f542a);
    }

    private C0147h getImpl() {
        if (this.f372l == null) {
            this.f372l = m587a();
        }
        return this.f372l;
    }

    void m589a(C0109a c0109a, boolean z) {
        getImpl().mo126b(m586a(c0109a), z);
    }

    public boolean m590a(Rect rect) {
        if (!C0425s.m1986y(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.f363c.left;
        rect.top += this.f363c.top;
        rect.right -= this.f363c.right;
        rect.bottom -= this.f363c.bottom;
        return true;
    }

    void m591b(C0109a c0109a, boolean z) {
        getImpl().mo123a(m586a(c0109a), z);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo124a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f364d;
    }

    public Mode getBackgroundTintMode() {
        return this.f365e;
    }

    public float getCompatElevation() {
        return getImpl().mo116a();
    }

    public Drawable getContentBackground() {
        return getImpl().m705f();
    }

    public int getRippleColor() {
        return this.f367g;
    }

    public int getSize() {
        return this.f368h;
    }

    int getSizeDimension() {
        return m584a(this.f368h);
    }

    public boolean getUseCompatPadding() {
        return this.f362b;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo125b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m707h();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m708i();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f361a = (sizeDimension - this.f369i) / 2;
        getImpl().m706g();
        sizeDimension = Math.min(m585a(sizeDimension, i), m585a(sizeDimension, i2));
        setMeasuredDimension((this.f363c.left + sizeDimension) + this.f363c.right, (sizeDimension + this.f363c.top) + this.f363c.bottom);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (m590a(this.f370j) && !this.f370j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f364d != colorStateList) {
            this.f364d = colorStateList;
            getImpl().mo119a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f365e != mode) {
            this.f365e = mode;
            getImpl().mo121a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().m689a(f);
    }

    public void setImageResource(int i) {
        this.f371k.m4755a(i);
    }

    public void setRippleColor(int i) {
        if (this.f367g != i) {
            this.f367g = i;
            getImpl().mo118a(i);
        }
    }

    public void setSize(int i) {
        if (i != this.f368h) {
            this.f368h = i;
            requestLayout();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f362b != z) {
            this.f362b = z;
            getImpl().mo127c();
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
