package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.p013b.p014a.C0269c;
import android.support.v7.p023c.p024a.C0608b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class bm {
    private final Context f2626a;
    private final TypedArray f2627b;
    private TypedValue f2628c;

    private bm(Context context, TypedArray typedArray) {
        this.f2626a = context;
        this.f2627b = typedArray;
    }

    public static bm m4511a(Context context, int i, int[] iArr) {
        return new bm(context, context.obtainStyledAttributes(i, iArr));
    }

    public static bm m4512a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new bm(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static bm m4513a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bm(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float m4514a(int i, float f) {
        return this.f2627b.getFloat(i, f);
    }

    public int m4515a(int i, int i2) {
        return this.f2627b.getInt(i, i2);
    }

    public Typeface m4516a(int i, int i2, TextView textView) {
        int resourceId = this.f2627b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2628c == null) {
            this.f2628c = new TypedValue();
        }
        return C0269c.m1354a(this.f2626a, resourceId, this.f2628c, i2, textView);
    }

    public Drawable m4517a(int i) {
        if (this.f2627b.hasValue(i)) {
            int resourceId = this.f2627b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0608b.m2863b(this.f2626a, resourceId);
            }
        }
        return this.f2627b.getDrawable(i);
    }

    public void m4518a() {
        this.f2627b.recycle();
    }

    public boolean m4519a(int i, boolean z) {
        return this.f2627b.getBoolean(i, z);
    }

    public int m4520b(int i, int i2) {
        return this.f2627b.getColor(i, i2);
    }

    public Drawable m4521b(int i) {
        if (this.f2627b.hasValue(i)) {
            int resourceId = this.f2627b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0827m.m4729a().m4749a(this.f2626a, resourceId, true);
            }
        }
        return null;
    }

    public int m4522c(int i, int i2) {
        return this.f2627b.getInteger(i, i2);
    }

    public CharSequence m4523c(int i) {
        return this.f2627b.getText(i);
    }

    public int m4524d(int i, int i2) {
        return this.f2627b.getDimensionPixelOffset(i, i2);
    }

    public String m4525d(int i) {
        return this.f2627b.getString(i);
    }

    public int m4526e(int i, int i2) {
        return this.f2627b.getDimensionPixelSize(i, i2);
    }

    public ColorStateList m4527e(int i) {
        if (this.f2627b.hasValue(i)) {
            int resourceId = this.f2627b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = C0608b.m2860a(this.f2626a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.f2627b.getColorStateList(i);
    }

    public int m4528f(int i, int i2) {
        return this.f2627b.getLayoutDimension(i, i2);
    }

    public CharSequence[] m4529f(int i) {
        return this.f2627b.getTextArray(i);
    }

    public int m4530g(int i, int i2) {
        return this.f2627b.getResourceId(i, i2);
    }

    public boolean m4531g(int i) {
        return this.f2627b.hasValue(i);
    }
}
