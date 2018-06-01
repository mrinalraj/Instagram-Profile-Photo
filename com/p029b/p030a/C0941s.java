package com.p029b.p030a;

import android.content.Context;
import android.net.Uri;
import com.p029b.p030a.C0901j.C0929a;
import com.p029b.p030a.C0901j.C0930b;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class C0941s implements C0901j {
    private final OkHttpClient f3090a;

    public C0941s(Context context) {
        this(ag.m5013b(context));
    }

    public C0941s(OkHttpClient okHttpClient) {
        this.f3090a = okHttpClient;
    }

    public C0941s(File file) {
        this(file, ag.m4998a(file));
    }

    public C0941s(File file, long j) {
        this(C0941s.m5133a());
        try {
            this.f3090a.setCache(new Cache(file, j));
        } catch (IOException e) {
        }
    }

    private static OkHttpClient m5133a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public C0929a mo813a(Uri uri, int i) {
        CacheControl cacheControl = null;
        if (i != 0) {
            if (C0938q.m5127c(i)) {
                cacheControl = CacheControl.FORCE_CACHE;
            } else {
                Builder builder = new Builder();
                if (!C0938q.m5125a(i)) {
                    builder.noCache();
                }
                if (!C0938q.m5126b(i)) {
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.f3090a.newCall(url.build()).execute();
        int code = execute.code();
        if (code >= 300) {
            execute.body().close();
            throw new C0930b(code + " " + execute.message(), i, code);
        }
        boolean z = execute.cacheResponse() != null;
        ResponseBody body = execute.body();
        return new C0929a(body.byteStream(), z, body.contentLength());
    }
}
