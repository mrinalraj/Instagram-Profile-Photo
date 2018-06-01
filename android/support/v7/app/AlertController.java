package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.p008h.C0425s;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.C0477b;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.widget.ar.C0670a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController {
    private boolean f1346A = false;
    private CharSequence f1347B;
    private CharSequence f1348C;
    private CharSequence f1349D;
    private int f1350E = 0;
    private Drawable f1351F;
    private ImageView f1352G;
    private TextView f1353H;
    private TextView f1354I;
    private View f1355J;
    private int f1356K;
    private int f1357L;
    private boolean f1358M;
    private int f1359N = 0;
    private final OnClickListener f1360O = new C05301(this);
    final C0549l f1361a;
    ListView f1362b;
    Button f1363c;
    Message f1364d;
    Button f1365e;
    Message f1366f;
    Button f1367g;
    Message f1368h;
    NestedScrollView f1369i;
    ListAdapter f1370j;
    int f1371k = -1;
    int f1372l;
    int f1373m;
    int f1374n;
    int f1375o;
    Handler f1376p;
    private final Context f1377q;
    private final Window f1378r;
    private CharSequence f1379s;
    private CharSequence f1380t;
    private View f1381u;
    private int f1382v;
    private int f1383w;
    private int f1384x;
    private int f1385y;
    private int f1386z;

    class C05301 implements OnClickListener {
        final /* synthetic */ AlertController f1279a;

        C05301(AlertController alertController) {
            this.f1279a = alertController;
        }

        public void onClick(View view) {
            Message obtain = (view != this.f1279a.f1363c || this.f1279a.f1364d == null) ? (view != this.f1279a.f1365e || this.f1279a.f1366f == null) ? (view != this.f1279a.f1367g || this.f1279a.f1368h == null) ? null : Message.obtain(this.f1279a.f1368h) : Message.obtain(this.f1279a.f1366f) : Message.obtain(this.f1279a.f1364d);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.f1279a.f1376p.obtainMessage(1, this.f1279a.f1361a).sendToTarget();
        }
    }

    public static class RecycleListView extends ListView {
        private final int f1292a;
        private final int f1293b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.RecycleListView);
            this.f1293b = obtainStyledAttributes.getDimensionPixelOffset(C0528j.RecycleListView_paddingBottomNoButtons, -1);
            this.f1292a = obtainStyledAttributes.getDimensionPixelOffset(C0528j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void m2489a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f1292a, getPaddingRight(), z2 ? getPaddingBottom() : this.f1293b);
            }
        }
    }

    public static class C0540a {
        public int f1306A;
        public boolean f1307B = false;
        public boolean[] f1308C;
        public boolean f1309D;
        public boolean f1310E;
        public int f1311F = -1;
        public OnMultiChoiceClickListener f1312G;
        public Cursor f1313H;
        public String f1314I;
        public String f1315J;
        public OnItemSelectedListener f1316K;
        public C0539a f1317L;
        public boolean f1318M = true;
        public final Context f1319a;
        public final LayoutInflater f1320b;
        public int f1321c = 0;
        public Drawable f1322d;
        public int f1323e = 0;
        public CharSequence f1324f;
        public View f1325g;
        public CharSequence f1326h;
        public CharSequence f1327i;
        public DialogInterface.OnClickListener f1328j;
        public CharSequence f1329k;
        public DialogInterface.OnClickListener f1330l;
        public CharSequence f1331m;
        public DialogInterface.OnClickListener f1332n;
        public boolean f1333o;
        public OnCancelListener f1334p;
        public OnDismissListener f1335q;
        public OnKeyListener f1336r;
        public CharSequence[] f1337s;
        public ListAdapter f1338t;
        public DialogInterface.OnClickListener f1339u;
        public int f1340v;
        public View f1341w;
        public int f1342x;
        public int f1343y;
        public int f1344z;

        public interface C0539a {
            void m2490a(ListView listView);
        }

        public C0540a(Context context) {
            this.f1319a = context;
            this.f1333o = true;
            this.f1320b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void m2491b(final AlertController alertController) {
            ListAdapter simpleCursorAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.f1320b.inflate(alertController.f1372l, null);
            if (!this.f1309D) {
                int i = this.f1310E ? alertController.f1374n : alertController.f1375o;
                simpleCursorAdapter = this.f1313H != null ? new SimpleCursorAdapter(this.f1319a, i, this.f1313H, new String[]{this.f1314I}, new int[]{16908308}) : this.f1338t != null ? this.f1338t : new C0542c(this.f1319a, i, 16908308, this.f1337s);
            } else if (this.f1313H == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this, this.f1319a, alertController.f1373m, 16908308, this.f1337s) {
                    final /* synthetic */ C0540a f1295b;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (this.f1295b.f1308C != null && this.f1295b.f1308C[i]) {
                            recycleListView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final AlertController alertController2 = alertController;
                Object c05362 = new CursorAdapter(this, this.f1319a, this.f1313H, false) {
                    final /* synthetic */ C0540a f1298c;
                    private final int f1299d;
                    private final int f1300e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1299d));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1300e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.f1298c.f1320b.inflate(alertController2.f1373m, viewGroup, false);
                    }
                };
            }
            if (this.f1317L != null) {
                this.f1317L.m2490a(recycleListView);
            }
            alertController.f1370j = simpleCursorAdapter;
            alertController.f1371k = this.f1311F;
            if (this.f1339u != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0540a f1302b;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.f1302b.f1339u.onClick(alertController.f1361a, i);
                        if (!this.f1302b.f1310E) {
                            alertController.f1361a.dismiss();
                        }
                    }
                });
            } else if (this.f1312G != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0540a f1305c;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.f1305c.f1308C != null) {
                            this.f1305c.f1308C[i] = recycleListView.isItemChecked(i);
                        }
                        this.f1305c.f1312G.onClick(alertController.f1361a, i, recycleListView.isItemChecked(i));
                    }
                });
            }
            if (this.f1316K != null) {
                recycleListView.setOnItemSelectedListener(this.f1316K);
            }
            if (this.f1310E) {
                recycleListView.setChoiceMode(1);
            } else if (this.f1309D) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f1362b = recycleListView;
        }

        public void m2492a(AlertController alertController) {
            if (this.f1325g != null) {
                alertController.m2513b(this.f1325g);
            } else {
                if (this.f1324f != null) {
                    alertController.m2510a(this.f1324f);
                }
                if (this.f1322d != null) {
                    alertController.m2508a(this.f1322d);
                }
                if (this.f1321c != 0) {
                    alertController.m2512b(this.f1321c);
                }
                if (this.f1323e != 0) {
                    alertController.m2512b(alertController.m2516c(this.f1323e));
                }
            }
            if (this.f1326h != null) {
                alertController.m2514b(this.f1326h);
            }
            if (this.f1327i != null) {
                alertController.m2507a(-1, this.f1327i, this.f1328j, null);
            }
            if (this.f1329k != null) {
                alertController.m2507a(-2, this.f1329k, this.f1330l, null);
            }
            if (this.f1331m != null) {
                alertController.m2507a(-3, this.f1331m, this.f1332n, null);
            }
            if (!(this.f1337s == null && this.f1313H == null && this.f1338t == null)) {
                m2491b(alertController);
            }
            if (this.f1341w != null) {
                if (this.f1307B) {
                    alertController.m2509a(this.f1341w, this.f1342x, this.f1343y, this.f1344z, this.f1306A);
                    return;
                }
                alertController.m2517c(this.f1341w);
            } else if (this.f1340v != 0) {
                alertController.m2506a(this.f1340v);
            }
        }
    }

    private static final class C0541b extends Handler {
        private WeakReference<DialogInterface> f1345a;

        public C0541b(DialogInterface dialogInterface) {
            this.f1345a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1345a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class C0542c extends ArrayAdapter<CharSequence> {
        public C0542c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, C0549l c0549l, Window window) {
        this.f1377q = context;
        this.f1361a = c0549l;
        this.f1378r = window;
        this.f1376p = new C0541b(c0549l);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0528j.AlertDialog, C0519a.alertDialogStyle, 0);
        this.f1356K = obtainStyledAttributes.getResourceId(C0528j.AlertDialog_android_layout, 0);
        this.f1357L = obtainStyledAttributes.getResourceId(C0528j.AlertDialog_buttonPanelSideLayout, 0);
        this.f1372l = obtainStyledAttributes.getResourceId(C0528j.AlertDialog_listLayout, 0);
        this.f1373m = obtainStyledAttributes.getResourceId(C0528j.AlertDialog_multiChoiceItemLayout, 0);
        this.f1374n = obtainStyledAttributes.getResourceId(C0528j.AlertDialog_singleChoiceItemLayout, 0);
        this.f1375o = obtainStyledAttributes.getResourceId(C0528j.AlertDialog_listItemLayout, 0);
        this.f1358M = obtainStyledAttributes.getBoolean(C0528j.AlertDialog_showTitle, true);
        obtainStyledAttributes.recycle();
        c0549l.m2560a(1);
    }

    private ViewGroup m2493a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    static void m2494a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m2495a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f1381u != null ? this.f1381u : this.f1382v != 0 ? LayoutInflater.from(this.f1377q).inflate(this.f1382v, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && m2499a(inflate))) {
            this.f1378r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1378r.findViewById(C0524f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.f1346A) {
                frameLayout.setPadding(this.f1383w, this.f1384x, this.f1385y, this.f1386z);
            }
            if (this.f1362b != null) {
                ((C0670a) viewGroup.getLayoutParams()).f1962g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m2496a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f1378r.findViewById(C0524f.scrollIndicatorUp);
        View findViewById2 = this.f1378r.findViewById(C0524f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            C0425s.m1943a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f1380t != null) {
                this.f1369i.setOnScrollChangeListener(new C0477b(this) {
                    final /* synthetic */ AlertController f1282c;

                    public void mo391a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.m2494a(nestedScrollView, findViewById, view2);
                    }
                });
                this.f1369i.post(new Runnable(this) {
                    final /* synthetic */ AlertController f1285c;

                    public void run() {
                        AlertController.m2494a(this.f1285c.f1369i, findViewById, view2);
                    }
                });
            } else if (this.f1362b != null) {
                this.f1362b.setOnScrollListener(new OnScrollListener(this) {
                    final /* synthetic */ AlertController f1288c;

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.m2494a(absListView, findViewById, view2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.f1362b.post(new Runnable(this) {
                    final /* synthetic */ AlertController f1291c;

                    public void run() {
                        AlertController.m2494a(this.f1291c.f1362b, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void m2497a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private static boolean m2498a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0519a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean m2499a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m2499a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int m2500b() {
        return this.f1357L == 0 ? this.f1356K : this.f1359N == 1 ? this.f1357L : this.f1356K;
    }

    private void m2501b(ViewGroup viewGroup) {
        if (this.f1355J != null) {
            viewGroup.addView(this.f1355J, 0, new LayoutParams(-1, -2));
            this.f1378r.findViewById(C0524f.title_template).setVisibility(8);
            return;
        }
        this.f1352G = (ImageView) this.f1378r.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f1379s) ? 1 : 0) == 0 || !this.f1358M) {
            this.f1378r.findViewById(C0524f.title_template).setVisibility(8);
            this.f1352G.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.f1353H = (TextView) this.f1378r.findViewById(C0524f.alertTitle);
        this.f1353H.setText(this.f1379s);
        if (this.f1350E != 0) {
            this.f1352G.setImageResource(this.f1350E);
        } else if (this.f1351F != null) {
            this.f1352G.setImageDrawable(this.f1351F);
        } else {
            this.f1353H.setPadding(this.f1352G.getPaddingLeft(), this.f1352G.getPaddingTop(), this.f1352G.getPaddingRight(), this.f1352G.getPaddingBottom());
            this.f1352G.setVisibility(8);
        }
    }

    private void m2502c() {
        View findViewById = this.f1378r.findViewById(C0524f.parentPanel);
        View findViewById2 = findViewById.findViewById(C0524f.topPanel);
        View findViewById3 = findViewById.findViewById(C0524f.contentPanel);
        View findViewById4 = findViewById.findViewById(C0524f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0524f.customPanel);
        m2495a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0524f.topPanel);
        View findViewById6 = viewGroup.findViewById(C0524f.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0524f.buttonPanel);
        ViewGroup a = m2493a(findViewById5, findViewById2);
        ViewGroup a2 = m2493a(findViewById6, findViewById3);
        ViewGroup a3 = m2493a(findViewById7, findViewById4);
        m2503c(a2);
        m2504d(a3);
        m2501b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById = a2.findViewById(C0524f.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (z2) {
            if (this.f1369i != null) {
                this.f1369i.setClipToPadding(true);
            }
            findViewById = null;
            if (!(this.f1380t == null && this.f1362b == null)) {
                findViewById = a.findViewById(C0524f.titleDividerNoCustom);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else if (a2 != null) {
            findViewById = a2.findViewById(C0524f.textSpacerNoTitle);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (this.f1362b instanceof RecycleListView) {
            ((RecycleListView) this.f1362b).m2489a(z2, z3);
        }
        if (!z) {
            findViewById3 = this.f1362b != null ? this.f1362b : this.f1369i;
            if (findViewById3 != null) {
                m2496a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f1362b;
        if (listView != null && this.f1370j != null) {
            listView.setAdapter(this.f1370j);
            int i = this.f1371k;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void m2503c(ViewGroup viewGroup) {
        this.f1369i = (NestedScrollView) this.f1378r.findViewById(C0524f.scrollView);
        this.f1369i.setFocusable(false);
        this.f1369i.setNestedScrollingEnabled(false);
        this.f1354I = (TextView) viewGroup.findViewById(16908299);
        if (this.f1354I != null) {
            if (this.f1380t != null) {
                this.f1354I.setText(this.f1380t);
                return;
            }
            this.f1354I.setVisibility(8);
            this.f1369i.removeView(this.f1354I);
            if (this.f1362b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1369i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1369i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1362b, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m2504d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f1363c = (Button) viewGroup.findViewById(16908313);
        this.f1363c.setOnClickListener(this.f1360O);
        if (TextUtils.isEmpty(this.f1347B)) {
            this.f1363c.setVisibility(8);
            i = 0;
        } else {
            this.f1363c.setText(this.f1347B);
            this.f1363c.setVisibility(0);
            i = 1;
        }
        this.f1365e = (Button) viewGroup.findViewById(16908314);
        this.f1365e.setOnClickListener(this.f1360O);
        if (TextUtils.isEmpty(this.f1348C)) {
            this.f1365e.setVisibility(8);
        } else {
            this.f1365e.setText(this.f1348C);
            this.f1365e.setVisibility(0);
            i |= 2;
        }
        this.f1367g = (Button) viewGroup.findViewById(16908315);
        this.f1367g.setOnClickListener(this.f1360O);
        if (TextUtils.isEmpty(this.f1349D)) {
            this.f1367g.setVisibility(8);
        } else {
            this.f1367g.setText(this.f1349D);
            this.f1367g.setVisibility(0);
            i |= 4;
        }
        if (m2498a(this.f1377q)) {
            if (i == 1) {
                m2497a(this.f1363c);
            } else if (i == 2) {
                m2497a(this.f1365e);
            } else if (i == 4) {
                m2497a(this.f1367g);
            }
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void m2505a() {
        this.f1361a.setContentView(m2500b());
        m2502c();
    }

    public void m2506a(int i) {
        this.f1381u = null;
        this.f1382v = i;
        this.f1346A = false;
    }

    public void m2507a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1376p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f1349D = charSequence;
                this.f1368h = message;
                return;
            case -2:
                this.f1348C = charSequence;
                this.f1366f = message;
                return;
            case -1:
                this.f1347B = charSequence;
                this.f1364d = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m2508a(Drawable drawable) {
        this.f1351F = drawable;
        this.f1350E = 0;
        if (this.f1352G == null) {
            return;
        }
        if (drawable != null) {
            this.f1352G.setVisibility(0);
            this.f1352G.setImageDrawable(drawable);
            return;
        }
        this.f1352G.setVisibility(8);
    }

    public void m2509a(View view, int i, int i2, int i3, int i4) {
        this.f1381u = view;
        this.f1382v = 0;
        this.f1346A = true;
        this.f1383w = i;
        this.f1384x = i2;
        this.f1385y = i3;
        this.f1386z = i4;
    }

    public void m2510a(CharSequence charSequence) {
        this.f1379s = charSequence;
        if (this.f1353H != null) {
            this.f1353H.setText(charSequence);
        }
    }

    public boolean m2511a(int i, KeyEvent keyEvent) {
        return this.f1369i != null && this.f1369i.m2326a(keyEvent);
    }

    public void m2512b(int i) {
        this.f1351F = null;
        this.f1350E = i;
        if (this.f1352G == null) {
            return;
        }
        if (i != 0) {
            this.f1352G.setVisibility(0);
            this.f1352G.setImageResource(this.f1350E);
            return;
        }
        this.f1352G.setVisibility(8);
    }

    public void m2513b(View view) {
        this.f1355J = view;
    }

    public void m2514b(CharSequence charSequence) {
        this.f1380t = charSequence;
        if (this.f1354I != null) {
            this.f1354I.setText(charSequence);
        }
    }

    public boolean m2515b(int i, KeyEvent keyEvent) {
        return this.f1369i != null && this.f1369i.m2326a(keyEvent);
    }

    public int m2516c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1377q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void m2517c(View view) {
        this.f1381u = view;
        this.f1382v = 0;
        this.f1346A = false;
    }
}
