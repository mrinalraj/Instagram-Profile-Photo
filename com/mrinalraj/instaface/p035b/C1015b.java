package com.mrinalraj.instaface.p035b;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0710l;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class C1015b implements C0710l {
    private GestureDetector f3314a;
    private C0993a f3315b;

    public interface C0993a {
        void mo827a(View view, int i);

        void mo828b(View view, int i);
    }

    public C1015b(Context context, final RecyclerView recyclerView, final C0993a c0993a) {
        this.f3315b = c0993a;
        this.f3314a = new GestureDetector(context, new SimpleOnGestureListener(this) {
            final /* synthetic */ C1015b f3313c;

            public void onLongPress(MotionEvent motionEvent) {
                View a = recyclerView.m237a(motionEvent.getX(), motionEvent.getY());
                if (a != null && c0993a != null) {
                    c0993a.mo828b(a, recyclerView.m271f(a));
                }
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void mo842a(boolean z) {
    }

    public boolean mo843a(RecyclerView recyclerView, MotionEvent motionEvent) {
        View a = recyclerView.m237a(motionEvent.getX(), motionEvent.getY());
        if (!(a == null || this.f3315b == null || !this.f3314a.onTouchEvent(motionEvent))) {
            this.f3315b.mo827a(a, recyclerView.m271f(a));
        }
        return false;
    }

    public void mo844b(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
