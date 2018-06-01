package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class C0181u {
    private static final C0178a f534a;

    private interface C0178a {
        void mo154a(ViewGroup viewGroup, View view, Rect rect);
    }

    private static class C0179b implements C0178a {
        C0179b() {
        }

        public void mo154a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    private static class C0180c implements C0178a {
        C0180c() {
        }

        public void mo154a(ViewGroup viewGroup, View view, Rect rect) {
            C0182v.m851a(viewGroup, view, rect);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f534a = new C0180c();
        } else {
            f534a = new C0179b();
        }
    }

    static void m849a(ViewGroup viewGroup, View view, Rect rect) {
        f534a.mo154a(viewGroup, view, rect);
    }

    static void m850b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        C0181u.m849a(viewGroup, view, rect);
    }
}
