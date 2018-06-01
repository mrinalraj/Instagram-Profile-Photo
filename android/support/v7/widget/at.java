package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p005c.p006a.C0279a;
import android.support.v7.p010d.p011a.C0157a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class at extends ListView {
    private static final int[] f2431g = new int[]{0};
    final Rect f2432a = new Rect();
    int f2433b = 0;
    int f2434c = 0;
    int f2435d = 0;
    int f2436e = 0;
    protected int f2437f;
    private Field f2438h;
    private C0780a f2439i;

    private static class C0780a extends C0157a {
        private boolean f2514a = true;

        public C0780a(Drawable drawable) {
            super(drawable);
        }

        void m4359a(boolean z) {
            this.f2514a = z;
        }

        public void draw(Canvas canvas) {
            if (this.f2514a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f2514a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2514a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            return this.f2514a ? super.setState(iArr) : false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.f2514a ? super.setVisible(z, z2) : false;
        }
    }

    public at(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f2438h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2438h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int m4293a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            listPaddingTop = (i8 > 0 ? listPaddingBottom + dividerHeight : listPaddingBottom) + view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            }
        }
        return listPaddingBottom;
    }

    protected void m4294a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m4299b(i, view);
        if (z2) {
            Rect rect = this.f2432a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0279a.m1418a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m4295a(int i, View view, float f, float f2) {
        m4294a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0279a.m1418a(selector, f, f2);
        }
    }

    protected void m4296a(Canvas canvas) {
        if (!this.f2432a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2432a);
                selector.draw(canvas);
            }
        }
    }

    protected boolean mo707a() {
        return false;
    }

    protected void m4298b() {
        Drawable selector = getSelector();
        if (selector != null && m4300c()) {
            selector.setState(getDrawableState());
        }
    }

    protected void m4299b(int i, View view) {
        Rect rect = this.f2432a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2433b;
        rect.top -= this.f2434c;
        rect.right += this.f2435d;
        rect.bottom += this.f2436e;
        try {
            boolean z = this.f2438h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2438h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected boolean m4300c() {
        return mo707a() && isPressed();
    }

    protected void dispatchDraw(Canvas canvas) {
        m4296a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m4298b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f2437f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        this.f2439i = drawable != null ? new C0780a(drawable) : null;
        super.setSelector(this.f2439i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2433b = rect.left;
        this.f2434c = rect.top;
        this.f2435d = rect.right;
        this.f2436e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2439i != null) {
            this.f2439i.m4359a(z);
        }
    }
}
