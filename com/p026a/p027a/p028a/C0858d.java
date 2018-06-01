package com.p026a.p027a.p028a;

import com.p026a.p027a.C0862l;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class C0858d implements C0857f {
    protected final HttpClient f2857a;

    public static final class C0856a extends HttpEntityEnclosingRequestBase {
        public C0856a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public C0858d(HttpClient httpClient) {
        this.f2857a = httpClient;
    }

    private static void m4851a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, C0862l<?> c0862l) {
        byte[] o = c0862l.mo804o();
        if (o != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(o));
        }
    }

    private static void m4852a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    static HttpUriRequest m4853b(C0862l<?> c0862l, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (c0862l.m4870a()) {
            case -1:
                byte[] k = c0862l.mo802k();
                if (k == null) {
                    return new HttpGet(c0862l.m4883c());
                }
                HttpUriRequest httpPost2 = new HttpPost(c0862l.m4883c());
                httpPost2.addHeader("Content-Type", c0862l.mo801j());
                httpPost2.setEntity(new ByteArrayEntity(k));
                return httpPost2;
            case 0:
                return new HttpGet(c0862l.m4883c());
            case 1:
                httpPost = new HttpPost(c0862l.m4883c());
                httpPost.addHeader("Content-Type", c0862l.mo803n());
                C0858d.m4851a(httpPost, (C0862l) c0862l);
                return httpPost;
            case 2:
                httpPost = new HttpPut(c0862l.m4883c());
                httpPost.addHeader("Content-Type", c0862l.mo803n());
                C0858d.m4851a(httpPost, (C0862l) c0862l);
                return httpPost;
            case 3:
                return new HttpDelete(c0862l.m4883c());
            case 4:
                return new HttpHead(c0862l.m4883c());
            case 5:
                return new HttpOptions(c0862l.m4883c());
            case 6:
                return new HttpTrace(c0862l.m4883c());
            case 7:
                httpPost = new C0856a(c0862l.m4883c());
                httpPost.addHeader("Content-Type", c0862l.mo803n());
                C0858d.m4851a(httpPost, (C0862l) c0862l);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse mo798a(C0862l<?> c0862l, Map<String, String> map) {
        HttpUriRequest b = C0858d.m4853b(c0862l, map);
        C0858d.m4852a(b, (Map) map);
        C0858d.m4852a(b, c0862l.m4887g());
        m4855a(b);
        HttpParams params = b.getParams();
        int r = c0862l.m4898r();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, r);
        return this.f2857a.execute(b);
    }

    protected void m4855a(HttpUriRequest httpUriRequest) {
    }
}
