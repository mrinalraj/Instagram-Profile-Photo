package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p008h.C0398d;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0522d;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.widget.au;
import android.support.v7.widget.av;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class C0639e extends C0638m implements C0628o, OnKeyListener, OnDismissListener {
    final Handler f1745a;
    final List<C0636a> f1746b = new ArrayList();
    View f1747c;
    boolean f1748d;
    private final Context f1749e;
    private final int f1750f;
    private final int f1751g;
    private final int f1752h;
    private final boolean f1753i;
    private final List<C0643h> f1754j = new LinkedList();
    private final OnGlobalLayoutListener f1755k = new C06321(this);
    private final OnAttachStateChangeListener f1756l = new C06332(this);
    private final au f1757m = new C06353(this);
    private int f1758n = 0;
    private int f1759o = 0;
    private View f1760p;
    private int f1761q;
    private boolean f1762r;
    private boolean f1763s;
    private int f1764t;
    private int f1765u;
    private boolean f1766v;
    private boolean f1767w;
    private C0577a f1768x;
    private ViewTreeObserver f1769y;
    private OnDismissListener f1770z;

    class C06321 implements OnGlobalLayoutListener {
        final /* synthetic */ C0639e f1734a;

        C06321(C0639e c0639e) {
            this.f1734a = c0639e;
        }

        public void onGlobalLayout() {
            if (this.f1734a.mo545d() && this.f1734a.f1746b.size() > 0 && !((C0636a) this.f1734a.f1746b.get(0)).f1741a.m4349g()) {
                View view = this.f1734a.f1747c;
                if (view == null || !view.isShown()) {
                    this.f1734a.mo542c();
                    return;
                }
                for (C0636a c0636a : this.f1734a.f1746b) {
                    c0636a.f1741a.mo535a();
                }
            }
        }
    }

    class C06332 implements OnAttachStateChangeListener {
        final /* synthetic */ C0639e f1735a;

        C06332(C0639e c0639e) {
            this.f1735a = c0639e;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f1735a.f1769y != null) {
                if (!this.f1735a.f1769y.isAlive()) {
                    this.f1735a.f1769y = view.getViewTreeObserver();
                }
                this.f1735a.f1769y.removeGlobalOnLayoutListener(this.f1735a.f1755k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class C06353 implements au {
        final /* synthetic */ C0639e f1740a;

        C06353(C0639e c0639e) {
            this.f1740a = c0639e;
        }

        public void mo533a(C0643h c0643h, MenuItem menuItem) {
            this.f1740a.f1745a.removeCallbacksAndMessages(c0643h);
        }

        public void mo534b(final C0643h c0643h, final MenuItem menuItem) {
            int i;
            this.f1740a.f1745a.removeCallbacksAndMessages(null);
            int size = this.f1740a.f1746b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c0643h == ((C0636a) this.f1740a.f1746b.get(i2)).f1742b) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                i++;
                final C0636a c0636a = i < this.f1740a.f1746b.size() ? (C0636a) this.f1740a.f1746b.get(i) : null;
                this.f1740a.f1745a.postAtTime(new Runnable(this) {
                    final /* synthetic */ C06353 f1739d;

                    public void run() {
                        if (c0636a != null) {
                            this.f1739d.f1740a.f1748d = true;
                            c0636a.f1742b.m3091a(false);
                            this.f1739d.f1740a.f1748d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            c0643h.m3093a(menuItem, 4);
                        }
                    }
                }, c0643h, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    private static class C0636a {
        public final av f1741a;
        public final C0643h f1742b;
        public final int f1743c;

        public C0636a(av avVar, C0643h c0643h, int i) {
            this.f1741a = avVar;
            this.f1742b = c0643h;
            this.f1743c = i;
        }

        public ListView m3002a() {
            return this.f1741a.mo546e();
        }
    }

    public C0639e(Context context, View view, int i, int i2, boolean z) {
        this.f1749e = context;
        this.f1760p = view;
        this.f1751g = i;
        this.f1752h = i2;
        this.f1753i = z;
        this.f1766v = false;
        this.f1761q = m3033i();
        Resources resources = context.getResources();
        this.f1750f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0522d.abc_config_prefDialogWidth));
        this.f1745a = new Handler();
    }

    private MenuItem m3024a(C0643h c0643h, C0643h c0643h2) {
        int size = c0643h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0643h.getItem(i);
            if (item.hasSubMenu() && c0643h2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View m3025a(C0636a c0636a, C0643h c0643h) {
        int i = 0;
        MenuItem a = m3024a(c0636a.f1742b, c0643h);
        if (a == null) {
            return null;
        }
        int headersCount;
        C0642g c0642g;
        int i2;
        ListView a2 = c0636a.m3002a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0642g = (C0642g) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0642g = (C0642g) adapter;
            headersCount = 0;
        }
        int count = c0642g.getCount();
        while (i < count) {
            if (a == c0642g.m3065a(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        return (i2 < 0 || i2 >= a2.getChildCount()) ? null : a2.getChildAt(i2);
    }

    private void m3029c(C0643h c0643h) {
        View a;
        LayoutInflater from = LayoutInflater.from(this.f1749e);
        Object c0642g = new C0642g(c0643h, from, this.f1753i);
        if (!mo545d() && this.f1766v) {
            c0642g.m3066a(true);
        } else if (mo545d()) {
            c0642g.m3066a(C0638m.m3009b(c0643h));
        }
        int a2 = C0638m.m3007a(c0642g, null, this.f1749e, this.f1750f);
        av h = m3032h();
        h.mo789a((ListAdapter) c0642g);
        h.m4348g(a2);
        h.m4346e(this.f1759o);
        if (this.f1746b.size() > 0) {
            C0636a c0636a = (C0636a) this.f1746b.get(this.f1746b.size() - 1);
            a = m3025a(c0636a, c0643h);
            C0636a c0636a2 = c0636a;
        } else {
            a = null;
            Object obj = null;
        }
        if (a != null) {
            int i;
            h.mo719c(false);
            h.m4364a(null);
            int d = m3030d(a2);
            boolean z = d == 1;
            this.f1761q = d;
            if (VERSION.SDK_INT >= 26) {
                h.m4339b(a);
                d = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f1760p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                a.getLocationOnScreen(iArr2);
                i = iArr2[0] - iArr[0];
                d = iArr2[1] - iArr[1];
            }
            int width = (this.f1759o & 5) == 5 ? z ? i + a2 : i - a.getWidth() : z ? a.getWidth() + i : i - a2;
            h.m4342c(width);
            h.m4340b(true);
            h.m4343d(d);
        } else {
            if (this.f1762r) {
                h.m4342c(this.f1764t);
            }
            if (this.f1763s) {
                h.m4343d(this.f1765u);
            }
            h.m4332a(m3023g());
        }
        this.f1746b.add(new C0636a(h, c0643h, this.f1761q));
        h.mo535a();
        ViewGroup e = h.mo546e();
        e.setOnKeyListener(this);
        if (c0636a2 == null && this.f1767w && c0643h.m3117m() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0525g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(c0643h.m3117m());
            e.addHeaderView(frameLayout, null, false);
            h.mo535a();
        }
    }

    private int m3030d(int i) {
        ListView a = ((C0636a) this.f1746b.get(this.f1746b.size() - 1)).m3002a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1747c.getWindowVisibleDisplayFrame(rect);
        if (this.f1761q != 1) {
            return iArr[0] - i < 0 ? 1 : 0;
        } else {
            return (a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
    }

    private int m3031d(C0643h c0643h) {
        int size = this.f1746b.size();
        for (int i = 0; i < size; i++) {
            if (c0643h == ((C0636a) this.f1746b.get(i)).f1742b) {
                return i;
            }
        }
        return -1;
    }

    private av m3032h() {
        av avVar = new av(this.f1749e, null, this.f1751g, this.f1752h);
        avVar.m4363a(this.f1757m);
        avVar.m4334a((OnItemClickListener) this);
        avVar.m4336a((OnDismissListener) this);
        avVar.m4339b(this.f1760p);
        avVar.m4346e(this.f1759o);
        avVar.m4337a(true);
        avVar.m4351h(2);
        return avVar;
    }

    private int m3033i() {
        return C0425s.m1966f(this.f1760p) == 1 ? 0 : 1;
    }

    public void mo535a() {
        if (!mo545d()) {
            for (C0643h c : this.f1754j) {
                m3029c(c);
            }
            this.f1754j.clear();
            this.f1747c = this.f1760p;
            if (this.f1747c != null) {
                Object obj = this.f1769y == null ? 1 : null;
                this.f1769y = this.f1747c.getViewTreeObserver();
                if (obj != null) {
                    this.f1769y.addOnGlobalLayoutListener(this.f1755k);
                }
                this.f1747c.addOnAttachStateChangeListener(this.f1756l);
            }
        }
    }

    public void mo536a(int i) {
        if (this.f1758n != i) {
            this.f1758n = i;
            this.f1759o = C0398d.m1784a(i, C0425s.m1966f(this.f1760p));
        }
    }

    public void mo537a(C0643h c0643h) {
        c0643h.m3088a((C0628o) this, this.f1749e);
        if (mo545d()) {
            m3029c(c0643h);
        } else {
            this.f1754j.add(c0643h);
        }
    }

    public void mo526a(C0643h c0643h, boolean z) {
        int d = m3031d(c0643h);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.f1746b.size()) {
                ((C0636a) this.f1746b.get(i)).f1742b.m3091a(false);
            }
            C0636a c0636a = (C0636a) this.f1746b.remove(d);
            c0636a.f1742b.m3098b((C0628o) this);
            if (this.f1748d) {
                c0636a.f1741a.m4366b(null);
                c0636a.f1741a.m4338b(0);
            }
            c0636a.f1741a.mo542c();
            d = this.f1746b.size();
            if (d > 0) {
                this.f1761q = ((C0636a) this.f1746b.get(d - 1)).f1743c;
            } else {
                this.f1761q = m3033i();
            }
            if (d == 0) {
                mo542c();
                if (this.f1768x != null) {
                    this.f1768x.mo452a(c0643h, true);
                }
                if (this.f1769y != null) {
                    if (this.f1769y.isAlive()) {
                        this.f1769y.removeGlobalOnLayoutListener(this.f1755k);
                    }
                    this.f1769y = null;
                }
                this.f1747c.removeOnAttachStateChangeListener(this.f1756l);
                this.f1770z.onDismiss();
            } else if (z) {
                ((C0636a) this.f1746b.get(0)).f1742b.m3091a(false);
            }
        }
    }

    public void mo527a(C0577a c0577a) {
        this.f1768x = c0577a;
    }

    public void mo538a(View view) {
        if (this.f1760p != view) {
            this.f1760p = view;
            this.f1759o = C0398d.m1784a(this.f1758n, C0425s.m1966f(this.f1760p));
        }
    }

    public void mo539a(OnDismissListener onDismissListener) {
        this.f1770z = onDismissListener;
    }

    public void mo540a(boolean z) {
        this.f1766v = z;
    }

    public boolean mo529a(C0661u c0661u) {
        for (C0636a c0636a : this.f1746b) {
            if (c0661u == c0636a.f1742b) {
                c0636a.m3002a().requestFocus();
                return true;
            }
        }
        if (!c0661u.hasVisibleItems()) {
            return false;
        }
        mo537a((C0643h) c0661u);
        if (this.f1768x != null) {
            this.f1768x.mo453a(c0661u);
        }
        return true;
    }

    public void mo541b(int i) {
        this.f1762r = true;
        this.f1764t = i;
    }

    public void mo530b(boolean z) {
        for (C0636a a : this.f1746b) {
            C0638m.m3008a(a.m3002a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean mo531b() {
        return false;
    }

    public void mo542c() {
        int size = this.f1746b.size();
        if (size > 0) {
            C0636a[] c0636aArr = (C0636a[]) this.f1746b.toArray(new C0636a[size]);
            for (size--; size >= 0; size--) {
                C0636a c0636a = c0636aArr[size];
                if (c0636a.f1741a.mo545d()) {
                    c0636a.f1741a.mo542c();
                }
            }
        }
    }

    public void mo543c(int i) {
        this.f1763s = true;
        this.f1765u = i;
    }

    public void mo544c(boolean z) {
        this.f1767w = z;
    }

    public boolean mo545d() {
        return this.f1746b.size() > 0 && ((C0636a) this.f1746b.get(0)).f1741a.mo545d();
    }

    public ListView mo546e() {
        return this.f1746b.isEmpty() ? null : ((C0636a) this.f1746b.get(this.f1746b.size() - 1)).m3002a();
    }

    protected boolean mo547f() {
        return false;
    }

    public void onDismiss() {
        C0636a c0636a;
        int size = this.f1746b.size();
        for (int i = 0; i < size; i++) {
            c0636a = (C0636a) this.f1746b.get(i);
            if (!c0636a.f1741a.mo545d()) {
                break;
            }
        }
        c0636a = null;
        if (c0636a != null) {
            c0636a.f1742b.m3091a(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo542c();
        return true;
    }
}
