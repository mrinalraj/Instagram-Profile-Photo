package com.p026a.p027a.p028a;

import com.p026a.p027a.C0862l;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class C0861g implements C0857f {
    private final C0860a f2858a;
    private final SSLSocketFactory f2859b;

    public interface C0860a {
        String m4859a(String str);
    }

    public C0861g() {
        this(null);
    }

    public C0861g(C0860a c0860a) {
        this(c0860a, null);
    }

    public C0861g(C0860a c0860a, SSLSocketFactory sSLSocketFactory) {
        this.f2858a = c0860a;
        this.f2859b = sSLSocketFactory;
    }

    private HttpURLConnection m4860a(URL url, C0862l<?> c0862l) {
        HttpURLConnection a = m4865a(url);
        int r = c0862l.m4898r();
        a.setConnectTimeout(r);
        a.setReadTimeout(r);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f2859b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f2859b);
        }
        return a;
    }

    private static HttpEntity m4861a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void m4862a(HttpURLConnection httpURLConnection, C0862l<?> c0862l) {
        switch (c0862l.m4870a()) {
            case -1:
                byte[] k = c0862l.mo802k();
                if (k != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", c0862l.mo801j());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(k);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                C0861g.m4864b(httpURLConnection, c0862l);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                C0861g.m4864b(httpURLConnection, c0862l);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                C0861g.m4864b(httpURLConnection, c0862l);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static boolean m4863a(int i, int i2) {
        return (i == 4 || ((100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304)) ? false : true;
    }

    private static void m4864b(HttpURLConnection httpURLConnection, C0862l<?> c0862l) {
        byte[] o = c0862l.mo804o();
        if (o != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", c0862l.mo803n());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(o);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m4865a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public HttpResponse mo798a(C0862l<?> c0862l, Map<String, String> map) {
        String a;
        String c = c0862l.m4883c();
        HashMap hashMap = new HashMap();
        hashMap.putAll(c0862l.m4887g());
        hashMap.putAll(map);
        if (this.f2858a != null) {
            a = this.f2858a.m4859a(c);
            if (a == null) {
                String str = "URL blocked by rewriter: ";
                a = String.valueOf(c);
                throw new IOException(a.length() != 0 ? str.concat(a) : new String(str));
            }
        }
        a = c;
        HttpURLConnection a2 = m4860a(new URL(a), (C0862l) c0862l);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        C0861g.m4862a(a2, (C0862l) c0862l);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        StatusLine basicStatusLine = new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage());
        HttpResponse basicHttpResponse = new BasicHttpResponse(basicStatusLine);
        if (C0861g.m4863a(c0862l.m4870a(), basicStatusLine.getStatusCode())) {
            basicHttpResponse.setEntity(C0861g.m4861a(a2));
        }
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
