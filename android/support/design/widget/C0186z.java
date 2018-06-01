package android.support.design.widget;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.support.design.C0066a.C0057b;
import android.support.design.C0066a.C0062g;
import android.view.View;

@TargetApi(21)
class C0186z {
    private static final int[] f543a = new int[]{16843848};

    static void m862a(View view, float f) {
        int integer = view.getResources().getInteger(C0062g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(new int[]{16842766, C0057b.state_collapsible, -C0057b.state_collapsed}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration((long) integer));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f}).setDuration((long) integer));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }
}
