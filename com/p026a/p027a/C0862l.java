package com.p026a.p027a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p026a.p027a.C0854b.C0869a;
import com.p026a.p027a.C0889n.C0887a;
import com.p026a.p027a.C0894t.C0893a;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public abstract class C0862l<T> implements Comparable<C0862l<T>> {
    private final C0893a f2860a;
    private final int f2861b;
    private final String f2862c;
    private final int f2863d;
    private final C0887a f2864e;
    private Integer f2865f;
    private C0886m f2866g;
    private boolean f2867h;
    private boolean f2868i;
    private boolean f2869j;
    private C0872p f2870k;
    private C0869a f2871l;

    public enum C0884a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public C0862l(int i, String str, C0887a c0887a) {
        this.f2860a = C0893a.f2941a ? new C0893a() : null;
        this.f2867h = true;
        this.f2868i = false;
        this.f2869j = false;
        this.f2871l = null;
        this.f2861b = i;
        this.f2862c = str;
        this.f2864e = c0887a;
        m4875a(new C0873d());
        this.f2863d = C0862l.m4869c(str);
    }

    private byte[] m4867a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Encoding not supported: ";
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    private static int m4869c(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    public int m4870a() {
        return this.f2861b;
    }

    public int m4871a(C0862l<T> c0862l) {
        C0884a q = m4897q();
        C0884a q2 = c0862l.m4897q();
        return q == q2 ? this.f2865f.intValue() - c0862l.f2865f.intValue() : q2.ordinal() - q.ordinal();
    }

    public final C0862l<?> m4872a(int i) {
        this.f2865f = Integer.valueOf(i);
        return this;
    }

    public C0862l<?> m4873a(C0869a c0869a) {
        this.f2871l = c0869a;
        return this;
    }

    public C0862l<?> m4874a(C0886m c0886m) {
        this.f2866g = c0886m;
        return this;
    }

    public C0862l<?> m4875a(C0872p c0872p) {
        this.f2870k = c0872p;
        return this;
    }

    protected abstract C0889n<T> mo799a(C0880i c0880i);

    protected C0867s m4877a(C0867s c0867s) {
        return c0867s;
    }

    protected abstract void mo800a(T t);

    public void m4879a(String str) {
        if (C0893a.f2941a) {
            this.f2860a.m4946a(str, Thread.currentThread().getId());
        }
    }

    public int m4880b() {
        return this.f2863d;
    }

    public void m4881b(C0867s c0867s) {
        if (this.f2864e != null) {
            this.f2864e.mo846a(c0867s);
        }
    }

    void m4882b(final String str) {
        if (this.f2866g != null) {
            this.f2866g.m4937b(this);
        }
        if (C0893a.f2941a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ C0862l f2917c;

                    public void run() {
                        this.f2917c.f2860a.m4946a(str, id);
                        this.f2917c.f2860a.m4945a(toString());
                    }
                });
                return;
            }
            this.f2860a.m4946a(str, id);
            this.f2860a.m4945a(toString());
        }
    }

    public String m4883c() {
        return this.f2862c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m4871a((C0862l) obj);
    }

    public String m4884d() {
        return m4883c();
    }

    public C0869a m4885e() {
        return this.f2871l;
    }

    public boolean m4886f() {
        return this.f2868i;
    }

    public Map<String, String> m4887g() {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> m4888h() {
        return m4892l();
    }

    @Deprecated
    protected String m4889i() {
        return m4893m();
    }

    @Deprecated
    public String mo801j() {
        return mo803n();
    }

    @Deprecated
    public byte[] mo802k() {
        Map h = m4888h();
        return (h == null || h.size() <= 0) ? null : m4867a(h, m4889i());
    }

    protected Map<String, String> m4892l() {
        return null;
    }

    protected String m4893m() {
        return "UTF-8";
    }

    public String mo803n() {
        String str = "application/x-www-form-urlencoded; charset=";
        String valueOf = String.valueOf(m4893m());
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public byte[] mo804o() {
        Map l = m4892l();
        return (l == null || l.size() <= 0) ? null : m4867a(l, m4893m());
    }

    public final boolean m4896p() {
        return this.f2867h;
    }

    public C0884a m4897q() {
        return C0884a.NORMAL;
    }

    public final int m4898r() {
        return this.f2870k.mo805a();
    }

    public C0872p m4899s() {
        return this.f2870k;
    }

    public void m4900t() {
        this.f2869j = true;
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(m4880b()));
        Object concat = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        str = String.valueOf(String.valueOf(this.f2868i ? "[X] " : "[ ] "));
        String valueOf2 = String.valueOf(String.valueOf(m4883c()));
        valueOf = String.valueOf(String.valueOf(concat));
        String valueOf3 = String.valueOf(String.valueOf(m4897q()));
        String valueOf4 = String.valueOf(String.valueOf(this.f2865f));
        return new StringBuilder(((((str.length() + 3) + valueOf2.length()) + valueOf.length()) + valueOf3.length()) + valueOf4.length()).append(str).append(valueOf2).append(" ").append(valueOf).append(" ").append(valueOf3).append(" ").append(valueOf4).toString();
    }

    public boolean m4901u() {
        return this.f2869j;
    }
}
