package android.support.v4.p017f;

import android.support.v4.p018g.C0350k;
import android.util.Base64;
import java.util.List;

public final class C0315a {
    private final String f909a;
    private final String f910b;
    private final String f911c;
    private final List<List<byte[]>> f912d;
    private final int f913e = 0;
    private final String f914f = new StringBuilder(this.f909a).append("-").append(this.f910b).append("-").append(this.f911c).toString();

    public C0315a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f909a = (String) C0350k.m1665a(str);
        this.f910b = (String) C0350k.m1665a(str2);
        this.f911c = (String) C0350k.m1665a(str3);
        this.f912d = (List) C0350k.m1665a(list);
    }

    public String m1530a() {
        return this.f909a;
    }

    public String m1531b() {
        return this.f910b;
    }

    public String m1532c() {
        return this.f911c;
    }

    public List<List<byte[]>> m1533d() {
        return this.f912d;
    }

    public int m1534e() {
        return this.f913e;
    }

    public String m1535f() {
        return this.f914f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FontRequest {mProviderAuthority: " + this.f909a + ", mProviderPackage: " + this.f910b + ", mQuery: " + this.f911c + ", mCertificates:");
        for (int i = 0; i < this.f912d.size(); i++) {
            stringBuilder.append(" [");
            List list = (List) this.f912d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder.append("mCertificatesArray: " + this.f913e);
        return stringBuilder.toString();
    }
}
