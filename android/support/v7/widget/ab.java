package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.p021a.C0529a.C0528j;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class ab {
    private static final RectF f2362a = new RectF();
    private static Hashtable<String, Method> f2363b = new Hashtable();
    private int f2364c = 0;
    private boolean f2365d = false;
    private float f2366e = -1.0f;
    private float f2367f = -1.0f;
    private float f2368g = -1.0f;
    private int[] f2369h = new int[0];
    private boolean f2370i = false;
    private TextPaint f2371j;
    private final TextView f2372k;
    private final Context f2373l;

    ab(TextView textView) {
        this.f2372k = textView;
        this.f2373l = this.f2372k.getContext();
    }

    private int m4094a(RectF rectF) {
        int length = this.f2369h.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 0;
        int i2 = 1;
        length--;
        while (i2 <= length) {
            i = (i2 + length) / 2;
            if (m4102a(this.f2369h[i], rectF)) {
                int i3 = i + 1;
                i = i2;
                i2 = i3;
            } else {
                length = i - 1;
                i = length;
            }
        }
        return this.f2369h[i];
    }

    @TargetApi(14)
    private StaticLayout m4095a(CharSequence charSequence, Alignment alignment, int i) {
        float lineSpacingMultiplier;
        float lineSpacingExtra;
        boolean includeFontPadding;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.f2372k.getLineSpacingMultiplier();
            lineSpacingExtra = this.f2372k.getLineSpacingExtra();
            includeFontPadding = this.f2372k.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) m4097a(this.f2372k, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            lineSpacingExtra = ((Float) m4097a(this.f2372k, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            includeFontPadding = ((Boolean) m4097a(this.f2372k, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
        }
        return new StaticLayout(charSequence, this.f2371j, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
    }

    @TargetApi(23)
    private StaticLayout m4096a(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) m4097a(this.f2372k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        Builder hyphenationFrequency = Builder.obtain(charSequence, 0, charSequence.length(), this.f2371j, i).setAlignment(alignment).setLineSpacing(this.f2372k.getLineSpacingExtra(), this.f2372k.getLineSpacingMultiplier()).setIncludePad(this.f2372k.getIncludeFontPadding()).setBreakStrategy(this.f2372k.getBreakStrategy()).setHyphenationFrequency(this.f2372k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    private <T> T m4097a(Object obj, String str, T t) {
        try {
            t = m4098a(str).invoke(obj, new Object[0]);
            return t == null ? t : t;
        } catch (Throwable e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return null != null ? null : t;
        } catch (Throwable th) {
            if (null == null && 1 == 0) {
            }
        }
    }

    private Method m4098a(String str) {
        try {
            Method method = (Method) f2363b.get(str);
            if (method != null) {
                return method;
            }
            method = TextView.class.getDeclaredMethod(str, new Class[0]);
            if (method == null) {
                return method;
            }
            method.setAccessible(true);
            f2363b.put(str, method);
            return method;
        } catch (Throwable e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    private void m4099a(float f) {
        if (f != this.f2372k.getPaint().getTextSize()) {
            this.f2372k.getPaint().setTextSize(f);
            boolean isInLayout = VERSION.SDK_INT >= 18 ? this.f2372k.isInLayout() : false;
            if (this.f2372k.getLayout() != null) {
                this.f2365d = false;
                String str = "nullLayouts";
                try {
                    Method a = m4098a("nullLayouts");
                    if (a != null) {
                        a.invoke(this.f2372k, new Object[0]);
                    }
                } catch (Throwable e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (isInLayout) {
                    this.f2372k.forceLayout();
                } else {
                    this.f2372k.requestLayout();
                }
                this.f2372k.invalidate();
            }
        }
    }

    private void m4100a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size " + "text size (" + f + "px)");
        } else if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        } else {
            this.f2364c = 1;
            this.f2367f = f;
            this.f2368g = f2;
            this.f2366e = f3;
            this.f2370i = false;
        }
    }

    private void m4101a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f2369h = m4103a(iArr);
            m4104h();
        }
    }

    private boolean m4102a(int i, RectF rectF) {
        CharSequence text = this.f2372k.getText();
        int maxLines = VERSION.SDK_INT >= 16 ? this.f2372k.getMaxLines() : -1;
        if (this.f2371j == null) {
            this.f2371j = new TextPaint();
        } else {
            this.f2371j.reset();
        }
        this.f2371j.set(this.f2372k.getPaint());
        this.f2371j.setTextSize((float) i);
        Alignment alignment = (Alignment) m4097a(this.f2372k, "getLayoutAlignment", Alignment.ALIGN_NORMAL);
        StaticLayout a = VERSION.SDK_INT >= 23 ? m4096a(text, alignment, Math.round(rectF.right), maxLines) : m4095a(text, alignment, Math.round(rectF.right));
        return (maxLines == -1 || (a.getLineCount() <= maxLines && a.getLineEnd(a.getLineCount() - 1) == text.length())) ? ((float) a.getHeight()) <= rectF.bottom : false;
    }

    private int[] m4103a(int[] iArr) {
        int size;
        if (size != 0) {
            int i;
            Arrays.sort(iArr);
            List arrayList = new ArrayList();
            for (int i2 : iArr) {
                if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (size != arrayList.size()) {
                size = arrayList.size();
                iArr = new int[size];
                for (i = 0; i < size; i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
            }
        }
        return iArr;
    }

    private boolean m4104h() {
        int length = this.f2369h.length;
        this.f2370i = length > 0;
        if (this.f2370i) {
            this.f2364c = 1;
            this.f2367f = (float) this.f2369h[0];
            this.f2368g = (float) this.f2369h[length - 1];
            this.f2366e = -1.0f;
        }
        return this.f2370i;
    }

    private boolean m4105i() {
        if (m4107k() && this.f2364c == 1) {
            if (!this.f2370i || this.f2369h.length == 0) {
                float round = (float) Math.round(this.f2367f);
                int i = 1;
                while (Math.round(this.f2366e + round) <= Math.round(this.f2368g)) {
                    i++;
                    round += this.f2366e;
                }
                int[] iArr = new int[i];
                float f = this.f2367f;
                for (int i2 = false; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.f2366e;
                }
                this.f2369h = m4103a(iArr);
            }
            this.f2365d = true;
        } else {
            this.f2365d = false;
        }
        return this.f2365d;
    }

    private void m4106j() {
        this.f2364c = 0;
        this.f2367f = -1.0f;
        this.f2368g = -1.0f;
        this.f2366e = -1.0f;
        this.f2369h = new int[0];
        this.f2365d = false;
    }

    private boolean m4107k() {
        return !(this.f2372k instanceof C0828n);
    }

    int m4108a() {
        return this.f2364c;
    }

    void m4109a(int i) {
        if (m4107k()) {
            switch (i) {
                case 0:
                    m4106j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.f2373l.getResources().getDisplayMetrics();
                    m4100a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (m4105i()) {
                        m4118f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    void m4110a(int i, float f) {
        m4099a(TypedValue.applyDimension(i, f, (this.f2373l == null ? Resources.getSystem() : this.f2373l.getResources()).getDisplayMetrics()));
    }

    void m4111a(int i, int i2, int i3, int i4) {
        if (m4107k()) {
            DisplayMetrics displayMetrics = this.f2373l.getResources().getDisplayMetrics();
            m4100a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (m4105i()) {
                m4118f();
            }
        }
    }

    void m4112a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2373l.obtainStyledAttributes(attributeSet, C0528j.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTextView_autoSizeTextType)) {
            this.f2364c = obtainStyledAttributes.getInt(C0528j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(C0528j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(C0528j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(C0528j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(C0528j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(C0528j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(C0528j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(C0528j.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = obtainStyledAttributes.getResourceId(C0528j.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                m4101a(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!m4107k()) {
            this.f2364c = 0;
        } else if (this.f2364c == 1) {
            if (!this.f2370i) {
                DisplayMetrics displayMetrics = this.f2373l.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m4100a(dimension2, dimension3, dimension);
            }
            m4105i();
        }
    }

    void m4113a(int[] iArr, int i) {
        int i2 = 0;
        if (m4107k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f2373l.getResources().getDisplayMetrics();
                    while (i2 < length) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                        i2++;
                    }
                }
                this.f2369h = m4103a(iArr2);
                if (!m4104h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            }
            this.f2370i = false;
            if (m4105i()) {
                m4118f();
            }
        }
    }

    int m4114b() {
        return Math.round(this.f2366e);
    }

    int m4115c() {
        return Math.round(this.f2367f);
    }

    int m4116d() {
        return Math.round(this.f2368g);
    }

    int[] m4117e() {
        return this.f2369h;
    }

    void m4118f() {
        if (m4119g()) {
            if (this.f2365d) {
                if (this.f2372k.getMeasuredHeight() > 0 && this.f2372k.getMeasuredWidth() > 0) {
                    int measuredWidth = ((Boolean) m4097a(this.f2372k, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue() ? 1048576 : (this.f2372k.getMeasuredWidth() - this.f2372k.getTotalPaddingLeft()) - this.f2372k.getTotalPaddingRight();
                    int height = (this.f2372k.getHeight() - this.f2372k.getCompoundPaddingBottom()) - this.f2372k.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        synchronized (f2362a) {
                            f2362a.setEmpty();
                            f2362a.right = (float) measuredWidth;
                            f2362a.bottom = (float) height;
                            float a = (float) m4094a(f2362a);
                            if (a != this.f2372k.getTextSize()) {
                                m4110a(0, a);
                            }
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            this.f2365d = true;
        }
    }

    boolean m4119g() {
        return m4107k() && this.f2364c != 0;
    }
}
