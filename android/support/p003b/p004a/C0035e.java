package android.support.p003b.p004a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.v4.p005c.C0291b;
import android.support.v4.p005c.C0291b.C0290b;
import android.support.v4.p013b.p014a.C0270d;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class C0035e {

    private static class C0034a implements TypeEvaluator<C0290b[]> {
        private C0290b[] f65a;

        private C0034a() {
        }

        public C0290b[] m53a(float f, C0290b[] c0290bArr, C0290b[] c0290bArr2) {
            if (C0291b.m1460a(c0290bArr, c0290bArr2)) {
                if (this.f65a == null || !C0291b.m1460a(this.f65a, c0290bArr)) {
                    this.f65a = C0291b.m1462a(c0290bArr);
                }
                for (int i = 0; i < c0290bArr.length; i++) {
                    this.f65a[i].m1455a(c0290bArr[i], c0290bArr2[i], f);
                }
                return this.f65a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }

        public /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return m53a(f, (C0290b[]) obj, (C0290b[]) obj2);
        }
    }

    private static int m54a(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        int i = 0;
        TypedArray a = C0270d.m1360a(resources, theme, attributeSet, C0024a.f48j);
        TypedValue b = C0270d.m1365b(a, xmlPullParser, "value", 0);
        if ((b != null ? 1 : 0) != 0 && C0035e.m71a(b.type)) {
            i = 3;
        }
        a.recycle();
        return i;
    }

    private static int m55a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        int i3 = peekValue != null ? 1 : 0;
        int i4 = i3 != 0 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        int i5 = peekValue2 != null ? 1 : 0;
        return ((i3 == 0 || !C0035e.m71a(i4)) && (i5 == 0 || !C0035e.m71a(i5 != 0 ? peekValue2.type : 0))) ? 0 : 3;
    }

    public static Animator m56a(Context context, int i) {
        return VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : C0035e.m57a(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator m57a(Context context, Resources resources, Theme theme, int i) {
        return C0035e.m58a(context, resources, theme, i, 1.0f);
    }

    public static Animator m58a(Context context, Resources resources, Theme theme, int i, float f) {
        NotFoundException notFoundException;
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = resources.getAnimation(i);
            Animator a = C0035e.m59a(context, resources, theme, (XmlPullParser) xmlResourceParser, f);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return a;
        } catch (Throwable e) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (Throwable e2) {
            notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static Animator m59a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, float f) {
        return C0035e.m60a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    private static Animator m60a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        Animator animator = null;
        ArrayList arrayList = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    Object obj;
                    if (name.equals("objectAnimator")) {
                        animator = C0035e.m63a(context, resources, theme, attributeSet, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("animator")) {
                        animator = C0035e.m66a(context, resources, theme, attributeSet, null, f, xmlPullParser);
                        obj = null;
                    } else if (name.equals("set")) {
                        Animator animatorSet2 = new AnimatorSet();
                        TypedArray a = C0270d.m1360a(resources, theme, attributeSet, C0024a.f46h);
                        C0035e.m60a(context, resources, theme, xmlPullParser, attributeSet, (AnimatorSet) animatorSet2, C0270d.m1359a(a, xmlPullParser, "ordering", 0, 0), f);
                        a.recycle();
                        obj = null;
                        animator = animatorSet2;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] a2 = C0035e.m72a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (!(a2 == null || animator == null || !(animator instanceof ValueAnimator))) {
                            ((ValueAnimator) animator).setValues(a2);
                        }
                        obj = 1;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null && r4 == null) {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(animator);
                        arrayList = arrayList2;
                    }
                }
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                animatorArr[i2] = (Animator) it.next();
                i2 = i3;
            }
            if (i == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    private static Keyframe m61a(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    private static Keyframe m62a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        TypedArray a = C0270d.m1360a(resources, theme, attributeSet, C0024a.f48j);
        Keyframe keyframe = null;
        float a2 = C0270d.m1358a(a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b = C0270d.m1365b(a, xmlPullParser, "value", 0);
        int i2 = b != null ? 1 : 0;
        if (i == 4) {
            i = (i2 == 0 || !C0035e.m71a(b.type)) ? 0 : 3;
        }
        if (i2 != 0) {
            switch (i) {
                case 0:
                    keyframe = Keyframe.ofFloat(a2, C0270d.m1358a(a, xmlPullParser, "value", 0, 0.0f));
                    break;
                case 1:
                case 3:
                    keyframe = Keyframe.ofInt(a2, C0270d.m1359a(a, xmlPullParser, "value", 0, 0));
                    break;
            }
        }
        keyframe = i == 0 ? Keyframe.ofFloat(a2) : Keyframe.ofInt(a2);
        int c = C0270d.m1366c(a, xmlPullParser, "interpolator", 1, 0);
        if (c > 0) {
            keyframe.setInterpolator(C0032d.m51a(context, c));
        }
        a.recycle();
        return keyframe;
    }

    private static ObjectAnimator m63a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ValueAnimator objectAnimator = new ObjectAnimator();
        C0035e.m66a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder m64a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        Keyframe a;
        Keyframe keyframe;
        float fraction;
        int i2;
        PropertyValuesHolder ofKeyframe;
        ArrayList arrayList = null;
        int i3 = i;
        while (true) {
            int size;
            int i4;
            float fraction2;
            Keyframe[] keyframeArr;
            int next = xmlPullParser.next();
            if (next != 3 && next != 1) {
                ArrayList arrayList2;
                if (xmlPullParser.getName().equals("keyframe")) {
                    if (i3 == 4) {
                        i3 = C0035e.m54a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                    }
                    a = C0035e.m62a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                    if (a != null) {
                        arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(a);
                    } else {
                        arrayList2 = arrayList;
                    }
                    xmlPullParser.next();
                } else {
                    arrayList2 = arrayList;
                }
                arrayList = arrayList2;
            } else if (arrayList != null) {
                size = arrayList.size();
                if (size > 0) {
                    keyframe = (Keyframe) arrayList.get(0);
                    a = (Keyframe) arrayList.get(size - 1);
                    fraction = a.getFraction();
                    if (fraction < 1.0f) {
                        i4 = size;
                    } else if (fraction >= 0.0f) {
                        a.setFraction(1.0f);
                        i4 = size;
                    } else {
                        arrayList.add(arrayList.size(), C0035e.m61a(a, 1.0f));
                        i4 = size + 1;
                    }
                    fraction2 = keyframe.getFraction();
                    if (fraction2 != 0.0f) {
                        if (fraction2 >= 0.0f) {
                            keyframe.setFraction(0.0f);
                        } else {
                            arrayList.add(0, C0035e.m61a(keyframe, 0.0f));
                            i4++;
                        }
                    }
                    keyframeArr = new Keyframe[i4];
                    arrayList.toArray(keyframeArr);
                    for (i2 = 0; i2 < i4; i2++) {
                        keyframe = keyframeArr[i2];
                        if (keyframe.getFraction() >= 0.0f) {
                            if (i2 == 0) {
                                keyframe.setFraction(0.0f);
                            } else if (i2 != i4 - 1) {
                                keyframe.setFraction(1.0f);
                            } else {
                                next = i2 + 1;
                                size = i2;
                                while (next < i4 - 1 && keyframeArr[next].getFraction() < 0.0f) {
                                    size = next;
                                    next++;
                                }
                                C0035e.m70a(keyframeArr, keyframeArr[size + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, size);
                            }
                        }
                    }
                    ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                    if (i3 == 3) {
                        return ofKeyframe;
                    }
                    ofKeyframe.setEvaluator(C0036f.m73a());
                    return ofKeyframe;
                }
            }
        }
        if (arrayList != null) {
            size = arrayList.size();
            if (size > 0) {
                keyframe = (Keyframe) arrayList.get(0);
                a = (Keyframe) arrayList.get(size - 1);
                fraction = a.getFraction();
                if (fraction < 1.0f) {
                    i4 = size;
                } else if (fraction >= 0.0f) {
                    arrayList.add(arrayList.size(), C0035e.m61a(a, 1.0f));
                    i4 = size + 1;
                } else {
                    a.setFraction(1.0f);
                    i4 = size;
                }
                fraction2 = keyframe.getFraction();
                if (fraction2 != 0.0f) {
                    if (fraction2 >= 0.0f) {
                        arrayList.add(0, C0035e.m61a(keyframe, 0.0f));
                        i4++;
                    } else {
                        keyframe.setFraction(0.0f);
                    }
                }
                keyframeArr = new Keyframe[i4];
                arrayList.toArray(keyframeArr);
                for (i2 = 0; i2 < i4; i2++) {
                    keyframe = keyframeArr[i2];
                    if (keyframe.getFraction() >= 0.0f) {
                        if (i2 == 0) {
                            keyframe.setFraction(0.0f);
                        } else if (i2 != i4 - 1) {
                            next = i2 + 1;
                            size = i2;
                            while (next < i4 - 1) {
                                size = next;
                                next++;
                            }
                            C0035e.m70a(keyframeArr, keyframeArr[size + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, size);
                        } else {
                            keyframe.setFraction(1.0f);
                        }
                    }
                }
                ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i3 == 3) {
                    return ofKeyframe;
                }
                ofKeyframe.setEvaluator(C0036f.m73a());
                return ofKeyframe;
            }
        }
        return null;
    }

    private static PropertyValuesHolder m65a(TypedArray typedArray, int i, int i2, int i3, String str) {
        TypedValue peekValue = typedArray.peekValue(i2);
        Object obj = peekValue != null ? 1 : null;
        int i4 = obj != null ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        Object obj2 = peekValue2 != null ? 1 : null;
        int i5 = obj2 != null ? peekValue2.type : 0;
        if (i == 4) {
            i = ((obj == null || !C0035e.m71a(i4)) && (obj2 == null || !C0035e.m71a(i5))) ? 0 : 3;
        }
        Object obj3 = i == 0 ? 1 : null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            C0290b[] b = C0291b.m1464b(string);
            C0290b[] b2 = C0291b.m1464b(string2);
            if (!(b == null && b2 == null)) {
                if (b != null) {
                    TypeEvaluator c0034a = new C0034a();
                    if (b2 == null) {
                        return PropertyValuesHolder.ofObject(str, c0034a, new Object[]{b});
                    } else if (C0291b.m1460a(b, b2)) {
                        return PropertyValuesHolder.ofObject(str, c0034a, new Object[]{b, b2});
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else if (b2 != null) {
                    return PropertyValuesHolder.ofObject(str, new C0034a(), new Object[]{b2});
                }
            }
            return null;
        }
        PropertyValuesHolder ofFloat;
        TypeEvaluator typeEvaluator = null;
        if (i == 3) {
            typeEvaluator = C0036f.m73a();
        }
        if (obj3 != null) {
            float dimension;
            if (obj != null) {
                float dimension2 = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (obj2 != null) {
                    dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2, dimension});
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2});
                }
            } else {
                dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension});
            }
        } else if (obj != null) {
            int dimension3 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : C0035e.m71a(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            if (obj2 != null) {
                i4 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : C0035e.m71a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3, i4});
            } else {
                ofFloat = PropertyValuesHolder.ofInt(str, new int[]{dimension3});
            }
        } else if (obj2 != null) {
            i4 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : C0035e.m71a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            ofFloat = PropertyValuesHolder.ofInt(str, new int[]{i4});
        } else {
            ofFloat = null;
        }
        if (ofFloat == null || typeEvaluator == null) {
            return ofFloat;
        }
        ofFloat.setEvaluator(typeEvaluator);
        return ofFloat;
    }

    private static ValueAnimator m66a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray a = C0270d.m1360a(resources, theme, attributeSet, C0024a.f45g);
        TypedArray a2 = C0270d.m1360a(resources, theme, attributeSet, C0024a.f49k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        C0035e.m68a(valueAnimator, a, a2, f, xmlPullParser);
        int c = C0270d.m1366c(a, xmlPullParser, "interpolator", 0, 0);
        if (c > 0) {
            valueAnimator.setInterpolator(C0032d.m51a(context, c));
        }
        a.recycle();
        if (a2 != null) {
            a2.recycle();
        }
        return valueAnimator;
    }

    private static void m67a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String a = C0270d.m1361a(typedArray, xmlPullParser, "pathData", 1);
        if (a != null) {
            String a2 = C0270d.m1361a(typedArray, xmlPullParser, "propertyXName", 2);
            String a3 = C0270d.m1361a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2 && i != 4) {
                if (a2 == null) {
                }
                C0035e.m69a(C0291b.m1457a(a), objectAnimator, 0.5f * f, a2, a3);
                return;
            } else if (a2 == null || a3 != null) {
                C0035e.m69a(C0291b.m1457a(a), objectAnimator, 0.5f * f, a2, a3);
                return;
            } else {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
        }
        objectAnimator.setPropertyName(C0270d.m1361a(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void m68a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a = (long) C0270d.m1359a(typedArray, xmlPullParser, "duration", 1, 300);
        long a2 = (long) C0270d.m1359a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a3 = C0270d.m1359a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (C0270d.m1363a(xmlPullParser, "valueFrom") && C0270d.m1363a(xmlPullParser, "valueTo")) {
            if (a3 == 4) {
                a3 = C0035e.m55a(typedArray, 5, 6);
            }
            if (C0035e.m65a(typedArray, a3, 5, 6, "") != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{C0035e.m65a(typedArray, a3, 5, 6, "")});
            }
        }
        valueAnimator.setDuration(a);
        valueAnimator.setStartDelay(a2);
        valueAnimator.setRepeatCount(C0270d.m1359a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(C0270d.m1359a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            C0035e.m67a(valueAnimator, typedArray2, a3, f, xmlPullParser);
        }
    }

    private static void m69a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f2 = 0.0f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        int i = 0;
        float f3 = f2 / ((float) (min - 1));
        int i2 = 0;
        f2 = 0.0f;
        while (i2 < min) {
            int i3;
            pathMeasure2.getPosTan(f2, fArr3, null);
            pathMeasure2.getPosTan(f2, fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            float f4 = f2 + f3;
            if (i + 1 >= arrayList.size() || f4 <= ((Float) arrayList.get(i + 1)).floatValue()) {
                f2 = f4;
                i3 = i;
            } else {
                f2 = f4 - ((Float) arrayList.get(i + 1)).floatValue();
                i3 = i + 1;
                pathMeasure2.nextContour();
            }
            i2++;
            i = i3;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (str != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, fArr);
        }
        if (str2 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder2});
        } else if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else {
            objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder, propertyValuesHolder2});
        }
    }

    private static void m70a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((float) ((i2 - i) + 2));
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    private static boolean m71a(int i) {
        return i >= 28 && i <= 31;
    }

    private static PropertyValuesHolder[] m72a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 3 && eventType != 1) {
                if (eventType != 2) {
                    xmlPullParser.next();
                } else {
                    ArrayList arrayList2;
                    if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                        Object a;
                        TypedArray a2 = C0270d.m1360a(resources, theme, attributeSet, C0024a.f47i);
                        String a3 = C0270d.m1361a(a2, xmlPullParser, "propertyName", 3);
                        int a4 = C0270d.m1359a(a2, xmlPullParser, "valueType", 2, 4);
                        PropertyValuesHolder a5 = C0035e.m64a(context, resources, theme, xmlPullParser, a3, a4);
                        if (a5 == null) {
                            a = C0035e.m65a(a2, a4, 0, 1, a3);
                        } else {
                            PropertyValuesHolder propertyValuesHolder = a5;
                        }
                        if (a != null) {
                            arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList2.add(a);
                        } else {
                            arrayList2 = arrayList;
                        }
                        a2.recycle();
                    } else {
                        arrayList2 = arrayList;
                    }
                    xmlPullParser.next();
                    arrayList = arrayList2;
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (int i = 0; i < size; i++) {
            propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
        }
        return propertyValuesHolderArr;
    }
}
