package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.C0642g;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class av extends as implements au {
    private static Method f2519a;
    private au f2520b;

    public static class C0781a extends am {
        final int f2515g;
        final int f2516h;
        private au f2517i;
        private MenuItem f2518j;

        public C0781a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f2515g = 22;
                this.f2516h = 21;
                return;
            }
            this.f2515g = 21;
            this.f2516h = 22;
        }

        public /* bridge */ /* synthetic */ boolean mo713a(MotionEvent motionEvent, int i) {
            return super.mo713a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.f2517i != null) {
                int headersCount;
                C0642g c0642g;
                MenuItem a;
                MenuItem menuItem;
                C0643h a2;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0642g = (C0642g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    c0642g = (C0642g) adapter;
                }
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        headersCount = pointToPosition - headersCount;
                        if (headersCount >= 0 && headersCount < c0642g.getCount()) {
                            a = c0642g.m3065a(headersCount);
                            menuItem = this.f2518j;
                            if (menuItem != a) {
                                a2 = c0642g.m3064a();
                                if (menuItem != null) {
                                    this.f2517i.mo533a(a2, menuItem);
                                }
                                this.f2518j = a;
                                if (a != null) {
                                    this.f2517i.mo534b(a2, a);
                                }
                            }
                        }
                    }
                }
                a = null;
                menuItem = this.f2518j;
                if (menuItem != a) {
                    a2 = c0642g.m3064a();
                    if (menuItem != null) {
                        this.f2517i.mo533a(a2, menuItem);
                    }
                    this.f2518j = a;
                    if (a != null) {
                        this.f2517i.mo534b(a2, a);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f2515g) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f2516h) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0642g) getAdapter()).m3064a().m3091a(false);
                return true;
            }
        }

        public void setHoverListener(au auVar) {
            this.f2517i = auVar;
        }
    }

    static {
        try {
            f2519a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public av(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    am mo718a(Context context, boolean z) {
        am c0781a = new C0781a(context, z);
        c0781a.setHoverListener(this);
        return c0781a;
    }

    public void mo533a(C0643h c0643h, MenuItem menuItem) {
        if (this.f2520b != null) {
            this.f2520b.mo533a(c0643h, menuItem);
        }
    }

    public void m4363a(au auVar) {
        this.f2520b = auVar;
    }

    public void m4364a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    public void mo534b(C0643h c0643h, MenuItem menuItem) {
        if (this.f2520b != null) {
            this.f2520b.mo534b(c0643h, menuItem);
        }
    }

    public void m4366b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void mo719c(boolean z) {
        if (f2519a != null) {
            try {
                f2519a.invoke(this.g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}
