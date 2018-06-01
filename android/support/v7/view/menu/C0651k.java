package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p008h.C0397c;
import android.support.v4.p015d.p016a.C0303b;
import android.support.v7.view.C0613c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class C0651k extends C0631c<C0303b> implements MenuItem {
    private Method f1859c;

    class C0647a extends C0397c {
        final ActionProvider f1854a;
        final /* synthetic */ C0651k f1855b;

        public C0647a(C0651k c0651k, Context context, ActionProvider actionProvider) {
            this.f1855b = c0651k;
            super(context);
            this.f1854a = actionProvider;
        }

        public View mo549a() {
            return this.f1854a.onCreateActionView();
        }

        public void mo550a(SubMenu subMenu) {
            this.f1854a.onPrepareSubMenu(this.f1855b.m2994a(subMenu));
        }

        public boolean mo551d() {
            return this.f1854a.onPerformDefaultAction();
        }

        public boolean mo552e() {
            return this.f1854a.hasSubMenu();
        }
    }

    static class C0648b extends FrameLayout implements C0613c {
        final CollapsibleActionView f1856a;

        C0648b(View view) {
            super(view.getContext());
            this.f1856a = (CollapsibleActionView) view;
            addView(view);
        }

        public void mo553a() {
            this.f1856a.onActionViewExpanded();
        }

        public void mo554b() {
            this.f1856a.onActionViewCollapsed();
        }

        View m3163c() {
            return (View) this.f1856a;
        }
    }

    private class C0649c extends C0630d<OnActionExpandListener> implements OnActionExpandListener {
        final /* synthetic */ C0651k f1857a;

        C0649c(C0651k c0651k, OnActionExpandListener onActionExpandListener) {
            this.f1857a = c0651k;
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1857a.m2993a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1857a.m2993a(menuItem));
        }
    }

    private class C0650d extends C0630d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0651k f1858a;

        C0650d(C0651k c0651k, OnMenuItemClickListener onMenuItemClickListener) {
            this.f1858a = c0651k;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1858a.m2993a(menuItem));
        }
    }

    C0651k(Context context, C0303b c0303b) {
        super(context, c0303b);
    }

    C0647a mo559a(ActionProvider actionProvider) {
        return new C0647a(this, this.a, actionProvider);
    }

    public void m3165a(boolean z) {
        try {
            if (this.f1859c == null) {
                this.f1859c = ((C0303b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1859c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((C0303b) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((C0303b) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0397c a = ((C0303b) this.b).mo504a();
        return a instanceof C0647a ? ((C0647a) a).f1854a : null;
    }

    public View getActionView() {
        View actionView = ((C0303b) this.b).getActionView();
        return actionView instanceof C0648b ? ((C0648b) actionView).m3163c() : actionView;
    }

    public int getAlphabeticModifiers() {
        return ((C0303b) this.b).getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return ((C0303b) this.b).getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return ((C0303b) this.b).getContentDescription();
    }

    public int getGroupId() {
        return ((C0303b) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0303b) this.b).getIcon();
    }

    public ColorStateList getIconTintList() {
        return ((C0303b) this.b).getIconTintList();
    }

    public Mode getIconTintMode() {
        return ((C0303b) this.b).getIconTintMode();
    }

    public Intent getIntent() {
        return ((C0303b) this.b).getIntent();
    }

    public int getItemId() {
        return ((C0303b) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0303b) this.b).getMenuInfo();
    }

    public int getNumericModifiers() {
        return ((C0303b) this.b).getNumericModifiers();
    }

    public char getNumericShortcut() {
        return ((C0303b) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0303b) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return m2994a(((C0303b) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0303b) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0303b) this.b).getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return ((C0303b) this.b).getTooltipText();
    }

    public boolean hasSubMenu() {
        return ((C0303b) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0303b) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0303b) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((C0303b) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((C0303b) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((C0303b) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0303b) this.b).mo502a(actionProvider != null ? mo559a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0303b) this.b).setActionView(i);
        View actionView = ((C0303b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0303b) this.b).setActionView(new C0648b(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0648b(view);
        }
        ((C0303b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0303b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((C0303b) this.b).setAlphabeticShortcut(c, i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0303b) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0303b) this.b).setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((C0303b) this.b).mo503a(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0303b) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0303b) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0303b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((C0303b) this.b).setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((C0303b) this.b).setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0303b) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0303b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((C0303b) this.b).setNumericShortcut(c, i);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0303b) this.b).setOnActionExpandListener(onActionExpandListener != null ? new C0649c(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0303b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0650d(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0303b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((C0303b) this.b).setShortcut(c, c2, i, i2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0303b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0303b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0303b) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0303b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0303b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((C0303b) this.b).mo505b(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0303b) this.b).setVisible(z);
    }
}
