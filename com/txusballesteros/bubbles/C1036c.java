package com.txusballesteros.bubbles;

import android.view.View;
import android.view.WindowManager;

final class C1036c {
    private static C1036c f3387a;
    private C1034b f3388b;
    private WindowManager f3389c;
    private BubblesService f3390d;

    public static class C1035a {
        private C1036c f3386a = C1036c.m5342b();

        public C1035a(BubblesService bubblesService) {
            this.f3386a.f3390d = bubblesService;
        }

        public C1035a m5335a(WindowManager windowManager) {
            this.f3386a.f3389c = windowManager;
            return this;
        }

        public C1035a m5336a(C1034b c1034b) {
            this.f3386a.f3388b = c1034b;
            return this;
        }

        public C1036c m5337a() {
            return this.f3386a;
        }
    }

    private C1036c() {
    }

    private static C1036c m5342b() {
        if (f3387a == null) {
            f3387a = new C1036c();
        }
        return f3387a;
    }

    private void m5343b(BubbleLayout bubbleLayout) {
        View c = m5344c();
        int left = c.getLeft() + (c.getMeasuredWidth() / 2);
        int measuredHeight = ((c.getMeasuredHeight() / 2) + c.getTop()) - (bubbleLayout.getMeasuredHeight() / 2);
        bubbleLayout.getViewParams().x = left - (bubbleLayout.getMeasuredWidth() / 2);
        bubbleLayout.getViewParams().y = measuredHeight;
        this.f3389c.updateViewLayout(bubbleLayout, bubbleLayout.getViewParams());
    }

    private View m5344c() {
        return this.f3388b.getChildAt(0);
    }

    private boolean m5345c(BubbleLayout bubbleLayout) {
        if (this.f3388b.getVisibility() != 0) {
            return false;
        }
        View c = m5344c();
        int measuredWidth = c.getMeasuredWidth();
        int measuredHeight = c.getMeasuredHeight();
        int left = c.getLeft() - (measuredWidth / 2);
        measuredWidth = (measuredWidth / 2) + (c.getLeft() + measuredWidth);
        int top = c.getTop() - (measuredHeight / 2);
        int top2 = (c.getTop() + measuredHeight) + (measuredHeight / 2);
        measuredHeight = bubbleLayout.getMeasuredWidth();
        int measuredHeight2 = bubbleLayout.getMeasuredHeight();
        int i = bubbleLayout.getViewParams().x;
        measuredHeight += i;
        int i2 = bubbleLayout.getViewParams().y;
        return i >= left && measuredHeight <= measuredWidth && i2 >= top && measuredHeight2 + i2 <= top2;
    }

    public void m5346a(BubbleLayout bubbleLayout) {
        if (this.f3388b != null) {
            if (m5345c(bubbleLayout)) {
                this.f3390d.m5329a(bubbleLayout);
            }
            this.f3388b.setVisibility(8);
        }
    }

    public void m5347a(BubbleLayout bubbleLayout, int i, int i2) {
        if (this.f3388b != null) {
            this.f3388b.setVisibility(0);
            if (m5345c(bubbleLayout)) {
                this.f3388b.m5332a();
                this.f3388b.m5333b();
                m5343b(bubbleLayout);
                return;
            }
            this.f3388b.m5334c();
        }
    }
}
