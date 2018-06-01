package com.p029b.p030a;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import com.p029b.p030a.C0901j.C0929a;
import com.p029b.p030a.C0901j.C0930b;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class af implements C0901j {
    static volatile Object f2990a;
    private static final Object f2991b = new Object();
    private static final ThreadLocal<StringBuilder> f2992c = new C08991();
    private final Context f2993d;

    static class C08991 extends ThreadLocal<StringBuilder> {
        C08991() {
        }

        protected StringBuilder m4987a() {
            return new StringBuilder();
        }

        protected /* synthetic */ Object initialValue() {
            return m4987a();
        }
    }

    private static class C0900a {
        static Object m4988a(Context context) {
            File b = ag.m5013b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(b, ag.m4998a(b)) : installed;
        }
    }

    public af(Context context) {
        this.f2993d = context.getApplicationContext();
    }

    private static void m4990a(Context context) {
        if (f2990a == null) {
            try {
                synchronized (f2991b) {
                    if (f2990a == null) {
                        f2990a = C0900a.m4988a(context);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    public C0929a mo813a(Uri uri, int i) {
        if (VERSION.SDK_INT >= 14) {
            af.m4990a(this.f2993d);
        }
        HttpURLConnection a = m4992a(uri);
        a.setUseCaches(true);
        if (i != 0) {
            String str;
            if (C0938q.m5127c(i)) {
                str = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder stringBuilder = (StringBuilder) f2992c.get();
                stringBuilder.setLength(0);
                if (!C0938q.m5125a(i)) {
                    stringBuilder.append("no-cache");
                }
                if (!C0938q.m5126b(i)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append("no-store");
                }
                str = stringBuilder.toString();
            }
            a.setRequestProperty("Cache-Control", str);
        }
        int responseCode = a.getResponseCode();
        if (responseCode >= 300) {
            a.disconnect();
            throw new C0930b(responseCode + " " + a.getResponseMessage(), i, responseCode);
        }
        long headerFieldInt = (long) a.getHeaderFieldInt("Content-Length", -1);
        return new C0929a(a.getInputStream(), ag.m5012a(a.getHeaderField("X-Android-Response-Source")), headerFieldInt);
    }

    protected HttpURLConnection m4992a(Uri uri) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }
}
