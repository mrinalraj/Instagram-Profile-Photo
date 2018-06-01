package com.joaquimley.faboptions;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.design.widget.CoordinatorLayout.C0099b;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.p013b.C0190a;
import android.support.v7.view.C0620g;
import android.support.v7.view.menu.C0643h;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.joaquimley.faboptions.C0984a.C0979a;
import com.joaquimley.faboptions.C0984a.C0980b;
import com.joaquimley.faboptions.C0984a.C0981c;
import com.joaquimley.faboptions.C0984a.C0982d;
import com.joaquimley.faboptions.C0984a.C0983e;

@C0099b(a = FabOptionsBehavior.class)
public class FabOptions extends FrameLayout implements OnClickListener {
    private boolean f3221a;
    private OnClickListener f3222b;
    private Menu f3223c;
    private FloatingActionButton f3224d;
    private View f3225e;
    private View f3226f;
    private FabOptionsButtonContainer f3227g;

    private class C0977a extends TransitionSet {
        final /* synthetic */ FabOptions f3219a;

        C0977a(FabOptions fabOptions, ViewGroup viewGroup) {
            this.f3219a = fabOptions;
            Transition changeBounds = new ChangeBounds();
            changeBounds.excludeChildren(C0981c.button_container, true);
            if (VERSION.SDK_INT >= 21) {
                Transition changeTransform = new ChangeTransform();
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeTransform.addTarget(viewGroup.getChildAt(i));
                }
                changeTransform.setDuration(70);
                addTransition(changeTransform);
            }
            addTransition(changeBounds);
            setOrdering(0);
        }
    }

    private class C0978b extends TransitionSet {
        final /* synthetic */ FabOptions f3220a;

        C0978b(FabOptions fabOptions, ViewGroup viewGroup) {
            this.f3220a = fabOptions;
            Transition changeBounds = new ChangeBounds();
            changeBounds.excludeChildren(C0981c.button_container, true);
            addTransition(changeBounds);
            if (VERSION.SDK_INT >= 21) {
                Transition changeTransform = new ChangeTransform();
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeTransform.addTarget(viewGroup.getChildAt(i));
                }
                addTransition(changeTransform);
            }
            setOrdering(1);
        }
    }

    public FabOptions(Context context) {
        this(context, null, 0);
    }

    public FabOptions(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FabOptions(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3221a = false;
        m5213a(context);
        m5212a();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0983e.FabOptions, 0, 0);
        m5214a(context, obtainStyledAttributes);
        m5221b(context, obtainStyledAttributes);
    }

    private void m5212a() {
        if (VERSION.SDK_INT >= 21) {
            this.f3224d.setImageDrawable((VectorDrawable) getResources().getDrawable(C0980b.faboptions_ic_overflow, null));
            return;
        }
        this.f3224d.setImageResource(C0980b.faboptions_ic_overflow);
    }

    private void m5213a(Context context) {
        inflate(context, C0982d.faboptions_layout, this);
        this.f3225e = findViewById(C0981c.background);
        this.f3227g = (FabOptionsButtonContainer) findViewById(C0981c.button_container);
        this.f3224d = (FloatingActionButton) findViewById(C0981c.faboptions_fab);
        this.f3224d.setOnClickListener(this);
    }

    private void m5214a(Context context, TypedArray typedArray) {
        int color = typedArray.getColor(C0983e.FabOptions_fab_color, m5218b(context));
        m5220b(context, typedArray.getColor(C0983e.FabOptions_background_color, color));
        this.f3224d.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    private void m5215a(Context context, Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            m5216a(context, menu.getItem(i));
        }
    }

    private void m5216a(Context context, MenuItem menuItem) {
        this.f3227g.m5231a(context, menuItem.getItemId(), menuItem.getTitle(), menuItem.getIcon()).setOnClickListener(this);
    }

    private void m5217a(boolean z) {
        LayoutParams layoutParams = this.f3225e.getLayoutParams();
        layoutParams.width = z ? this.f3227g.getMeasuredWidth() : 0;
        this.f3225e.setLayoutParams(layoutParams);
    }

    private int m5218b(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0979a.colorAccent, typedValue, true);
        return typedValue.data;
    }

    private void m5219b() {
        if (VERSION.SDK_INT >= 21) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getResources().getDrawable(C0980b.faboptions_ic_menu_animatable, null);
            this.f3224d.setImageDrawable(animatedVectorDrawable);
            animatedVectorDrawable.start();
        } else {
            this.f3224d.setImageResource(C0980b.faboptions_ic_close);
        }
        if (VERSION.SDK_INT >= 19) {
            TransitionManager.beginDelayedTransition(this, new C0978b(this, this.f3227g));
        }
        m5217a(true);
        m5222b(true);
        this.f3221a = true;
    }

    private void m5220b(Context context, int i) {
        Drawable a = C0190a.m865a(context, C0980b.faboptions_background);
        a.setColorFilter(i, Mode.ADD);
        if (VERSION.SDK_INT >= 16) {
            this.f3225e.setBackground(a);
        } else {
            this.f3225e.setBackgroundDrawable(a);
        }
    }

    private void m5221b(Context context, TypedArray typedArray) {
        if (typedArray.hasValue(C0983e.FabOptions_button_menu)) {
            m5224a(context, typedArray.getResourceId(C0983e.FabOptions_button_menu, 0));
        }
    }

    private void m5222b(boolean z) {
        for (int i = 0; i < this.f3227g.getChildCount(); i++) {
            this.f3227g.getChildAt(i).setScaleX(z ? 1.0f : 0.0f);
            this.f3227g.getChildAt(i).setScaleY(z ? 1.0f : 0.0f);
        }
    }

    private void m5223c() {
        if (VERSION.SDK_INT >= 21) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getResources().getDrawable(C0980b.faboptions_ic_close_animatable, null);
            this.f3224d.setImageDrawable(animatedVectorDrawable);
            animatedVectorDrawable.start();
        } else {
            this.f3224d.setImageResource(C0980b.faboptions_ic_overflow);
        }
        if (VERSION.SDK_INT >= 19) {
            TransitionManager.beginDelayedTransition(this, new C0977a(this, this.f3227g));
        }
        m5222b(false);
        m5217a(false);
        this.f3221a = false;
    }

    @Deprecated
    public void m5224a(Context context, int i) {
        this.f3223c = new C0643h(context);
        new C0620g(context).inflate(i, this.f3223c);
        m5215a(context, this.f3223c);
        this.f3226f = this.f3227g.m5233a(context);
        m5222b(false);
    }

    public void onClick(View view) {
        if (view.getId() == C0981c.faboptions_fab) {
            if (this.f3221a) {
                m5223c();
            } else {
                m5219b();
            }
        } else if (this.f3222b != null && this.f3221a) {
            this.f3222b.onClick(view);
            m5223c();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3226f != null) {
            LayoutParams layoutParams = this.f3226f.getLayoutParams();
            layoutParams.width = this.f3224d.getMeasuredWidth();
            layoutParams.height = this.f3224d.getMeasuredHeight();
            this.f3226f.setLayoutParams(layoutParams);
        }
    }

    public void setBackgroundColor(int i) {
        Context context = getContext();
        if (context != null) {
            m5220b(context, C0190a.m868c(context, i));
        } else {
            Log.w("FabOptions", "Couldn't set background color, context is null");
        }
    }

    public void setButtonsMenu(int i) {
        Context context = getContext();
        if (context != null) {
            m5224a(context, i);
        } else {
            Log.w("FabOptions", "Couldn't set buttons, context is null");
        }
    }

    public void setFabColor(int i) {
        Context context = getContext();
        if (context != null) {
            this.f3224d.setBackgroundTintList(ColorStateList.valueOf(C0190a.m868c(context, i)));
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f3222b = onClickListener;
    }
}
