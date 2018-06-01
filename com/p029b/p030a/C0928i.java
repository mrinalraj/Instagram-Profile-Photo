package com.p029b.p030a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.p029b.p030a.C0940r.C0939a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class C0928i {
    final C0926b f3036a = new C0926b();
    final Context f3037b;
    final ExecutorService f3038c;
    final C0901j f3039d;
    final Map<String, C0916c> f3040e;
    final Map<Object, C0896a> f3041f;
    final Map<Object, C0896a> f3042g;
    final Set<Object> f3043h;
    final Handler f3044i;
    final Handler f3045j;
    final C0917d f3046k;
    final aa f3047l;
    final List<C0916c> f3048m;
    final C0927c f3049n;
    final boolean f3050o;
    boolean f3051p;

    private static class C0925a extends Handler {
        private final C0928i f3034a;

        public C0925a(Looper looper, C0928i c0928i) {
            super(looper);
            this.f3034a = c0928i;
        }

        public void handleMessage(final Message message) {
            boolean z = true;
            switch (message.what) {
                case 1:
                    this.f3034a.m5096c((C0896a) message.obj);
                    return;
                case 2:
                    this.f3034a.m5098d((C0896a) message.obj);
                    return;
                case 4:
                    this.f3034a.m5100e((C0916c) message.obj);
                    return;
                case 5:
                    this.f3034a.m5099d((C0916c) message.obj);
                    return;
                case 6:
                    this.f3034a.m5088a((C0916c) message.obj, false);
                    return;
                case 7:
                    this.f3034a.m5083a();
                    return;
                case 9:
                    this.f3034a.m5091b((NetworkInfo) message.obj);
                    return;
                case 10:
                    C0928i c0928i = this.f3034a;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    c0928i.m5095b(z);
                    return;
                case 11:
                    this.f3034a.m5089a(message.obj);
                    return;
                case 12:
                    this.f3034a.m5094b(message.obj);
                    return;
                default:
                    C0951t.f3115a.post(new Runnable(this) {
                        final /* synthetic */ C0925a f3033b;

                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    return;
            }
        }
    }

    static class C0926b extends HandlerThread {
        C0926b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class C0927c extends BroadcastReceiver {
        private final C0928i f3035a;

        C0927c(C0928i c0928i) {
            this.f3035a = c0928i;
        }

        void m5077a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f3035a.f3050o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f3035a.f3037b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f3035a.m5090a(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f3035a.m5084a(((ConnectivityManager) ag.m5001a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    C0928i(Context context, ExecutorService executorService, Handler handler, C0901j c0901j, C0917d c0917d, aa aaVar) {
        this.f3036a.start();
        ag.m5008a(this.f3036a.getLooper());
        this.f3037b = context;
        this.f3038c = executorService;
        this.f3040e = new LinkedHashMap();
        this.f3041f = new WeakHashMap();
        this.f3042g = new WeakHashMap();
        this.f3043h = new HashSet();
        this.f3044i = new C0925a(this.f3036a.getLooper(), this);
        this.f3039d = c0901j;
        this.f3045j = handler;
        this.f3046k = c0917d;
        this.f3047l = aaVar;
        this.f3048m = new ArrayList(4);
        this.f3051p = ag.m5019d(this.f3037b);
        this.f3050o = ag.m5015b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f3049n = new C0927c(this);
        this.f3049n.m5077a();
    }

    private void m5078a(List<C0916c> list) {
        if (list != null && !list.isEmpty() && ((C0916c) list.get(0)).m5054j().f3126l) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C0916c c0916c : list) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(ag.m5003a(c0916c));
            }
            ag.m5010a("Dispatcher", "delivered", stringBuilder.toString());
        }
    }

    private void m5079b() {
        if (!this.f3041f.isEmpty()) {
            Iterator it = this.f3041f.values().iterator();
            while (it.hasNext()) {
                C0896a c0896a = (C0896a) it.next();
                it.remove();
                if (c0896a.m4963j().f3126l) {
                    ag.m5010a("Dispatcher", "replaying", c0896a.m4956c().m5166a());
                }
                m5086a(c0896a, false);
            }
        }
    }

    private void m5080e(C0896a c0896a) {
        Object d = c0896a.m4957d();
        if (d != null) {
            c0896a.f2957k = true;
            this.f3041f.put(d, c0896a);
        }
    }

    private void m5081f(C0916c c0916c) {
        C0896a i = c0916c.m5053i();
        if (i != null) {
            m5080e(i);
        }
        List k = c0916c.m5055k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                m5080e((C0896a) k.get(i2));
            }
        }
    }

    private void m5082g(C0916c c0916c) {
        if (!c0916c.m5047c()) {
            this.f3048m.add(c0916c);
            if (!this.f3044i.hasMessages(7)) {
                this.f3044i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    void m5083a() {
        List arrayList = new ArrayList(this.f3048m);
        this.f3048m.clear();
        this.f3045j.sendMessage(this.f3045j.obtainMessage(8, arrayList));
        m5078a(arrayList);
    }

    void m5084a(NetworkInfo networkInfo) {
        this.f3044i.sendMessage(this.f3044i.obtainMessage(9, networkInfo));
    }

    void m5085a(C0896a c0896a) {
        this.f3044i.sendMessage(this.f3044i.obtainMessage(1, c0896a));
    }

    void m5086a(C0896a c0896a, boolean z) {
        if (this.f3043h.contains(c0896a.m4965l())) {
            this.f3042g.put(c0896a.m4957d(), c0896a);
            if (c0896a.m4963j().f3126l) {
                ag.m5011a("Dispatcher", "paused", c0896a.f2948b.m5166a(), "because tag '" + c0896a.m4965l() + "' is paused");
                return;
            }
            return;
        }
        C0916c c0916c = (C0916c) this.f3040e.get(c0896a.m4958e());
        if (c0916c != null) {
            c0916c.m5043a(c0896a);
        } else if (!this.f3038c.isShutdown()) {
            Object a = C0916c.m5038a(c0896a.m4963j(), this, this.f3046k, this.f3047l, c0896a);
            a.f3019n = this.f3038c.submit(a);
            this.f3040e.put(c0896a.m4958e(), a);
            if (z) {
                this.f3041f.remove(c0896a.m4957d());
            }
            if (c0896a.m4963j().f3126l) {
                ag.m5010a("Dispatcher", "enqueued", c0896a.f2948b.m5166a());
            }
        } else if (c0896a.m4963j().f3126l) {
            ag.m5011a("Dispatcher", "ignored", c0896a.f2948b.m5166a(), "because shut down");
        }
    }

    void m5087a(C0916c c0916c) {
        this.f3044i.sendMessage(this.f3044i.obtainMessage(4, c0916c));
    }

    void m5088a(C0916c c0916c, boolean z) {
        if (c0916c.m5054j().f3126l) {
            ag.m5011a("Dispatcher", "batched", ag.m5003a(c0916c), "for error" + (z ? " (will replay)" : ""));
        }
        this.f3040e.remove(c0916c.m5050f());
        m5082g(c0916c);
    }

    void m5089a(Object obj) {
        if (this.f3043h.add(obj)) {
            Iterator it = this.f3040e.values().iterator();
            while (it.hasNext()) {
                C0916c c0916c = (C0916c) it.next();
                boolean z = c0916c.m5054j().f3126l;
                C0896a i = c0916c.m5053i();
                List k = c0916c.m5055k();
                Object obj2 = (k == null || k.isEmpty()) ? null : 1;
                if (i != null || obj2 != null) {
                    if (i != null && i.m4965l().equals(obj)) {
                        c0916c.m5045b(i);
                        this.f3042g.put(i.m4957d(), i);
                        if (z) {
                            ag.m5011a("Dispatcher", "paused", i.f2948b.m5166a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (obj2 != null) {
                        for (int size = k.size() - 1; size >= 0; size--) {
                            C0896a c0896a = (C0896a) k.get(size);
                            if (c0896a.m4965l().equals(obj)) {
                                c0916c.m5045b(c0896a);
                                this.f3042g.put(c0896a.m4957d(), c0896a);
                                if (z) {
                                    ag.m5011a("Dispatcher", "paused", c0896a.f2948b.m5166a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (c0916c.m5046b()) {
                        it.remove();
                        if (z) {
                            ag.m5011a("Dispatcher", "canceled", ag.m5003a(c0916c), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void m5090a(boolean z) {
        this.f3044i.sendMessage(this.f3044i.obtainMessage(10, z ? 1 : 0, 0));
    }

    void m5091b(NetworkInfo networkInfo) {
        if (this.f3038c instanceof C0954v) {
            ((C0954v) this.f3038c).m5161a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            m5079b();
        }
    }

    void m5092b(C0896a c0896a) {
        this.f3044i.sendMessage(this.f3044i.obtainMessage(2, c0896a));
    }

    void m5093b(C0916c c0916c) {
        this.f3044i.sendMessageDelayed(this.f3044i.obtainMessage(5, c0916c), 500);
    }

    void m5094b(Object obj) {
        if (this.f3043h.remove(obj)) {
            Object obj2 = null;
            Iterator it = this.f3042g.values().iterator();
            while (it.hasNext()) {
                C0896a c0896a = (C0896a) it.next();
                if (c0896a.m4965l().equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(c0896a);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.f3045j.sendMessage(this.f3045j.obtainMessage(13, obj2));
            }
        }
    }

    void m5095b(boolean z) {
        this.f3051p = z;
    }

    void m5096c(C0896a c0896a) {
        m5086a(c0896a, true);
    }

    void m5097c(C0916c c0916c) {
        this.f3044i.sendMessage(this.f3044i.obtainMessage(6, c0916c));
    }

    void m5098d(C0896a c0896a) {
        String e = c0896a.m4958e();
        C0916c c0916c = (C0916c) this.f3040e.get(e);
        if (c0916c != null) {
            c0916c.m5045b(c0896a);
            if (c0916c.m5046b()) {
                this.f3040e.remove(e);
                if (c0896a.m4963j().f3126l) {
                    ag.m5010a("Dispatcher", "canceled", c0896a.m4956c().m5166a());
                }
            }
        }
        if (this.f3043h.contains(c0896a.m4965l())) {
            this.f3042g.remove(c0896a.m4957d());
            if (c0896a.m4963j().f3126l) {
                ag.m5011a("Dispatcher", "canceled", c0896a.m4956c().m5166a(), "because paused request got canceled");
            }
        }
        C0896a c0896a2 = (C0896a) this.f3041f.remove(c0896a.m4957d());
        if (c0896a2 != null && c0896a2.m4963j().f3126l) {
            ag.m5011a("Dispatcher", "canceled", c0896a2.m4956c().m5166a(), "from replaying");
        }
    }

    void m5099d(C0916c c0916c) {
        boolean z = true;
        if (!c0916c.m5047c()) {
            if (this.f3038c.isShutdown()) {
                m5088a(c0916c, false);
                return;
            }
            NetworkInfo activeNetworkInfo = this.f3050o ? ((ConnectivityManager) ag.m5001a(this.f3037b, "connectivity")).getActiveNetworkInfo() : null;
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            boolean a = c0916c.m5044a(this.f3051p, activeNetworkInfo);
            boolean d = c0916c.m5048d();
            if (!a) {
                if (!(this.f3050o && d)) {
                    z = false;
                }
                m5088a(c0916c, z);
                if (z) {
                    m5081f(c0916c);
                }
            } else if (!this.f3050o || z2) {
                if (c0916c.m5054j().f3126l) {
                    ag.m5010a("Dispatcher", "retrying", ag.m5003a(c0916c));
                }
                if (c0916c.m5056l() instanceof C0939a) {
                    c0916c.f3014i |= C0938q.NO_CACHE.f3087d;
                }
                c0916c.f3019n = this.f3038c.submit(c0916c);
            } else {
                m5088a(c0916c, d);
                if (d) {
                    m5081f(c0916c);
                }
            }
        }
    }

    void m5100e(C0916c c0916c) {
        if (C0937p.m5124b(c0916c.m5051g())) {
            this.f3046k.mo818a(c0916c.m5050f(), c0916c.m5049e());
        }
        this.f3040e.remove(c0916c.m5050f());
        m5082g(c0916c);
        if (c0916c.m5054j().f3126l) {
            ag.m5011a("Dispatcher", "batched", ag.m5003a(c0916c), "for completion");
        }
    }
}
