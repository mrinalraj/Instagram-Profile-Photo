package android.support.v4.p013b.p014a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class C0270d {
    public static float m1358a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0270d.m1363a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int m1359a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0270d.m1363a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static TypedArray m1360a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static String m1361a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        return !C0270d.m1363a(xmlPullParser, str) ? null : typedArray.getString(i);
    }

    public static boolean m1362a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0270d.m1363a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean m1363a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int m1364b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0270d.m1363a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    public static TypedValue m1365b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        return !C0270d.m1363a(xmlPullParser, str) ? null : typedArray.peekValue(i);
    }

    public static int m1366c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0270d.m1363a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }
}
