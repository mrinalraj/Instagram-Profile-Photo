package android.support.v4.p013b.p014a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.p002a.C0023a.C0022a;
import android.support.v4.p017f.C0315a;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class C0268b {

    public interface C0264a {
    }

    public static final class C0265b implements C0264a {
        private final C0266c[] f845a;

        public C0265b(C0266c[] c0266cArr) {
            this.f845a = c0266cArr;
        }

        public C0266c[] m1339a() {
            return this.f845a;
        }
    }

    public static final class C0266c {
        private final String f846a;
        private int f847b;
        private boolean f848c;
        private int f849d;

        public C0266c(String str, int i, boolean z, int i2) {
            this.f846a = str;
            this.f847b = i;
            this.f848c = z;
            this.f849d = i2;
        }

        public String m1340a() {
            return this.f846a;
        }

        public int m1341b() {
            return this.f847b;
        }

        public boolean m1342c() {
            return this.f848c;
        }

        public int m1343d() {
            return this.f849d;
        }
    }

    public static final class C0267d implements C0264a {
        private final C0315a f850a;
        private final int f851b;
        private final int f852c;

        public C0267d(C0315a c0315a, int i, int i2) {
            this.f850a = c0315a;
            this.f852c = i;
            this.f851b = i2;
        }

        public C0315a m1344a() {
            return this.f850a;
        }

        public int m1345b() {
            return this.f852c;
        }

        public int m1346c() {
            return this.f851b;
        }
    }

    public static C0264a m1347a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return C0268b.m1351b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> m1348a(Resources resources, int i) {
        List<List<byte[]>> list = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                List<List<byte[]>> arrayList = new ArrayList();
                if ((obtainTypedArray.getResourceId(0, 0) != 0 ? 1 : 0) != 0) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        arrayList.add(C0268b.m1349a(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                    list = arrayList;
                } else {
                    arrayList.add(C0268b.m1349a(resources.getStringArray(i)));
                    list = arrayList;
                }
            }
            obtainTypedArray.recycle();
        }
        return list != null ? list : Collections.emptyList();
    }

    private static List<byte[]> m1349a(String[] strArr) {
        List<byte[]> arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static void m1350a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
    }

    private static C0264a m1351b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return C0268b.m1352c(xmlPullParser, resources);
        }
        C0268b.m1350a(xmlPullParser);
        return null;
    }

    private static C0264a m1352c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0022a.FontFamily);
        String string = obtainAttributes.getString(C0022a.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(C0022a.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(C0022a.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(C0022a.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(C0022a.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(C0022a.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            List arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(C0268b.m1353d(xmlPullParser, resources));
                    } else {
                        C0268b.m1350a(xmlPullParser);
                    }
                }
            }
            return arrayList.isEmpty() ? null : new C0265b((C0266c[]) arrayList.toArray(new C0266c[arrayList.size()]));
        } else {
            while (xmlPullParser.next() != 3) {
                C0268b.m1350a(xmlPullParser);
            }
            return new C0267d(new C0315a(string, string2, string3, C0268b.m1348a(resources, resourceId)), integer, integer2);
        }
    }

    private static C0266c m1353d(XmlPullParser xmlPullParser, Resources resources) {
        boolean z = true;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0022a.FontFamilyFont);
        int i = obtainAttributes.getInt(C0022a.FontFamilyFont_fontWeight, 400);
        if (1 != obtainAttributes.getInt(C0022a.FontFamilyFont_fontStyle, 0)) {
            z = false;
        }
        int resourceId = obtainAttributes.getResourceId(C0022a.FontFamilyFont_font, 0);
        String string = obtainAttributes.getString(C0022a.FontFamilyFont_font);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            C0268b.m1350a(xmlPullParser);
        }
        return new C0266c(string, i, z, resourceId);
    }
}
