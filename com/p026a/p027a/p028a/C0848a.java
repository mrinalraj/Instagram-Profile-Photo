package com.p026a.p027a.p028a;

import com.p026a.p027a.C0847f;
import com.p026a.p027a.C0854b.C0869a;
import com.p026a.p027a.C0862l;
import com.p026a.p027a.C0867s;
import com.p026a.p027a.C0872p;
import com.p026a.p027a.C0890q;
import com.p026a.p027a.C0894t;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class C0848a implements C0847f {
    protected static final boolean f2834a = C0894t.f2945b;
    private static int f2835d = 3000;
    private static int f2836e = 4096;
    protected final C0857f f2837b;
    protected final C0850b f2838c;

    public C0848a(C0857f c0857f) {
        this(c0857f, new C0850b(f2836e));
    }

    public C0848a(C0857f c0857f, C0850b c0850b) {
        this.f2837b = c0857f;
        this.f2838c = c0850b;
    }

    protected static Map<String, String> m4814a(Header[] headerArr) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void m4815a(long j, C0862l<?> c0862l, byte[] bArr, StatusLine statusLine) {
        if (f2834a || j > ((long) f2835d)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = c0862l;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(c0862l.m4899s().mo807b());
            C0894t.m4949b(str, objArr);
        }
    }

    private static void m4816a(String str, C0862l<?> c0862l, C0867s c0867s) {
        C0872p s = c0862l.m4899s();
        int r = c0862l.m4898r();
        try {
            s.mo806a(c0867s);
            c0862l.m4879a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
        } catch (C0867s e) {
            c0862l.m4879a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
            throw e;
        }
    }

    private void m4817a(Map<String, String> map, C0869a c0869a) {
        if (c0869a != null) {
            if (c0869a.f2880b != null) {
                map.put("If-None-Match", c0869a.f2880b);
            }
            if (c0869a.f2882d > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(c0869a.f2882d)));
            }
        }
    }

    private byte[] m4818a(HttpEntity httpEntity) {
        C0865j c0865j = new C0865j(this.f2838c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new C0890q();
            }
            bArr = this.f2838c.m4823a(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                c0865j.write(bArr, 0, read);
            }
            byte[] toByteArray = c0865j.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                C0894t.m4947a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f2838c.m4822a(bArr);
            c0865j.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.p026a.p027a.C0880i mo794a(com.p026a.p027a.C0862l<?> r19) {
        /*
        r18 = this;
        r16 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r3 = 0;
        r14 = 0;
        r6 = java.util.Collections.emptyMap();
        r2 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
        r4 = r19.m4885e();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
        r0 = r18;
        r0.m4817a(r2, r4);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
        r0 = r18;
        r4 = r0.f2837b;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
        r0 = r19;
        r15 = r4.mo798a(r0, r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00e2 }
        r12 = r15.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r4 = r12.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r2 = r15.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r6 = com.p026a.p027a.p028a.C0848a.m4814a(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r2) goto L_0x0065;
    L_0x0036:
        r2 = r19.m4885e();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        if (r2 != 0) goto L_0x004c;
    L_0x003c:
        r3 = new com.a.a.i;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r4 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r5 = 0;
        r7 = 1;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
    L_0x004b:
        return r3;
    L_0x004c:
        r3 = r2.f2885g;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r3.putAll(r6);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r7 = new com.a.a.i;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r8 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r9 = r2.f2879a;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r10 = r2.f2885g;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r11 = 1;
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r12 = r2 - r16;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r3 = r7;
        goto L_0x004b;
    L_0x0065:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        if (r2 == 0) goto L_0x009f;
    L_0x006b:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r0 = r18;
        r11 = r0.m4818a(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
    L_0x0075:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        r8 = r2 - r16;
        r7 = r18;
        r10 = r19;
        r7.m4815a(r8, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 < r2) goto L_0x008a;
    L_0x0086:
        r2 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r4 <= r2) goto L_0x00a3;
    L_0x008a:
        r2 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        throw r2;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
    L_0x0090:
        r2 = move-exception;
        r2 = "socket";
        r3 = new com.a.a.r;
        r3.<init>();
        r0 = r19;
        com.p026a.p027a.p028a.C0848a.m4816a(r2, r0, r3);
        goto L_0x0004;
    L_0x009f:
        r2 = 0;
        r11 = new byte[r2];	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        goto L_0x0075;
    L_0x00a3:
        r3 = new com.a.a.i;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        r8 = r8 - r16;
        r5 = r11;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013f }
        goto L_0x004b;
    L_0x00b1:
        r2 = move-exception;
        r2 = "connection";
        r3 = new com.a.a.r;
        r3.<init>();
        r0 = r19;
        com.p026a.p027a.p028a.C0848a.m4816a(r2, r0, r3);
        goto L_0x0004;
    L_0x00c0:
        r2 = move-exception;
        r3 = r2;
        r4 = new java.lang.RuntimeException;
        r5 = "Bad URL ";
        r2 = r19.m4883c();
        r2 = java.lang.String.valueOf(r2);
        r6 = r2.length();
        if (r6 == 0) goto L_0x00dc;
    L_0x00d4:
        r2 = r5.concat(r2);
    L_0x00d8:
        r4.<init>(r2, r3);
        throw r4;
    L_0x00dc:
        r2 = new java.lang.String;
        r2.<init>(r5);
        goto L_0x00d8;
    L_0x00e2:
        r2 = move-exception;
        r5 = r14;
    L_0x00e4:
        r7 = 0;
        if (r3 == 0) goto L_0x0129;
    L_0x00e7:
        r2 = r3.getStatusLine();
        r4 = r2.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r4);
        r3[r8] = r9;
        r8 = 1;
        r9 = r19.m4883c();
        r3[r8] = r9;
        com.p026a.p027a.C0894t.m4950c(r2, r3);
        if (r5 == 0) goto L_0x0135;
    L_0x0107:
        r3 = new com.a.a.i;
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);
        r2 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r2) goto L_0x011b;
    L_0x0117:
        r2 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r4 != r2) goto L_0x012f;
    L_0x011b:
        r2 = "auth";
        r4 = new com.a.a.a;
        r4.<init>(r3);
        r0 = r19;
        com.p026a.p027a.p028a.C0848a.m4816a(r2, r0, r4);
        goto L_0x0004;
    L_0x0129:
        r3 = new com.a.a.j;
        r3.<init>(r2);
        throw r3;
    L_0x012f:
        r2 = new com.a.a.q;
        r2.<init>(r3);
        throw r2;
    L_0x0135:
        r2 = new com.a.a.h;
        r2.<init>(r7);
        throw r2;
    L_0x013b:
        r2 = move-exception;
        r5 = r14;
        r3 = r15;
        goto L_0x00e4;
    L_0x013f:
        r2 = move-exception;
        r5 = r11;
        r3 = r15;
        goto L_0x00e4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.a.a(com.a.a.l):com.a.a.i");
    }
}
