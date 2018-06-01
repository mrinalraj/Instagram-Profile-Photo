package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0425s;
import android.support.v4.p018g.C0332a;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.C0614d;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.C0096o;
import android.support.v7.widget.C0726g;
import android.support.v7.widget.C0819i;
import android.support.v7.widget.C0820j;
import android.support.v7.widget.C0821k;
import android.support.v7.widget.C0828n;
import android.support.v7.widget.C0830q;
import android.support.v7.widget.C0834t;
import android.support.v7.widget.C0835u;
import android.support.v7.widget.C0836v;
import android.support.v7.widget.C0844x;
import android.support.v7.widget.aa;
import android.support.v7.widget.bj;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

class C0586m {
    private static final Class<?>[] f1502a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] f1503b = new int[]{16843375};
    private static final String[] f1504c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> f1505d = new C0332a();
    private final Object[] f1506e = new Object[2];

    private static class C0585a implements OnClickListener {
        private final View f1498a;
        private final String f1499b;
        private Method f1500c;
        private Context f1501d;

        public C0585a(View view, String str) {
            this.f1498a = view;
            this.f1499b = str;
        }

        private void m2738a(Context context, String str) {
            for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.f1499b, new Class[]{View.class});
                        if (method != null) {
                            this.f1500c = method;
                            this.f1501d = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
            }
            int id = this.f1498a.getId();
            throw new IllegalStateException("Could not find method " + this.f1499b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f1498a.getClass() + (id == -1 ? "" : " with id '" + this.f1498a.getContext().getResources().getResourceEntryName(id) + "'"));
        }

        public void onClick(View view) {
            if (this.f1500c == null) {
                m2738a(this.f1498a.getContext(), this.f1499b);
            }
            try {
                this.f1500c.invoke(this.f1501d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    C0586m() {
    }

    private static Context m2739a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0528j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0528j.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? ((context instanceof C0614d) && ((C0614d) context).m2882a() == i) ? context : new C0614d(context, i) : context;
    }

    private View m2740a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f1506e[0] = context;
            this.f1506e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f1504c) {
                    a = m2741a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f1506e[0] = null;
                this.f1506e[1] = null;
                return null;
            }
            a = m2741a(context, str, null);
            this.f1506e[0] = null;
            this.f1506e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f1506e[0] = null;
            this.f1506e[1] = null;
        }
    }

    private View m2741a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f1505d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1502a);
                f1505d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1506e);
    }

    private void m2742a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || C0425s.m1937B(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1503b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0585a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View m2743a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = C0586m.m2739a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = bj.m4508a(context2);
        }
        View view2 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                view2 = new aa(context2, attributeSet);
                break;
            case 1:
                view2 = new AppCompatImageView(context2, attributeSet);
                break;
            case 2:
                view2 = new C0819i(context2, attributeSet);
                break;
            case 3:
                view2 = new C0828n(context2, attributeSet);
                break;
            case 4:
                view2 = new C0844x(context2, attributeSet);
                break;
            case 5:
                view2 = new C0096o(context2, attributeSet);
                break;
            case 6:
                view2 = new C0820j(context2, attributeSet);
                break;
            case 7:
                view2 = new C0834t(context2, attributeSet);
                break;
            case 8:
                view2 = new C0821k(context2, attributeSet);
                break;
            case 9:
                view2 = new C0726g(context2, attributeSet);
                break;
            case 10:
                view2 = new C0830q(context2, attributeSet);
                break;
            case 11:
                view2 = new C0835u(context2, attributeSet);
                break;
            case 12:
                view2 = new C0836v(context2, attributeSet);
                break;
        }
        View a = (view2 != null || context == context2) ? view2 : m2740a(context2, str, attributeSet);
        if (a != null) {
            m2742a(a, attributeSet);
        }
        return a;
    }
}
