package com.p029b.p030a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.p029b.p030a.C0896a.C0895a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class C0951t {
    static final Handler f3115a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            List list;
            int size;
            int i;
            switch (message.what) {
                case 3:
                    C0896a c0896a = (C0896a) message.obj;
                    if (c0896a.m4963j().f3126l) {
                        ag.m5011a("Main", "canceled", c0896a.f2948b.m5166a(), "target got garbage collected");
                    }
                    c0896a.f2947a.m5142a(c0896a.m4957d());
                    return;
                case 8:
                    list = (List) message.obj;
                    size = list.size();
                    for (i = 0; i < size; i++) {
                        C0916c c0916c = (C0916c) list.get(i);
                        c0916c.f3007b.m5151a(c0916c);
                    }
                    return;
                case 13:
                    list = (List) message.obj;
                    size = list.size();
                    for (i = 0; i < size; i++) {
                        C0896a c0896a2 = (C0896a) list.get(i);
                        c0896a2.f2947a.m5154c(c0896a2);
                    }
                    return;
                default:
                    throw new AssertionError("Unknown handler message received: " + message.what);
            }
        }
    };
    static volatile C0951t f3116b = null;
    final Context f3117c;
    final C0928i f3118d;
    final C0917d f3119e;
    final aa f3120f;
    final Map<Object, C0896a> f3121g;
    final Map<ImageView, C0923h> f3122h;
    final ReferenceQueue<Object> f3123i;
    final Config f3124j;
    boolean f3125k;
    volatile boolean f3126l;
    boolean f3127m;
    private final C0946c f3128n;
    private final C0949f f3129o;
    private final C0945b f3130p;
    private final List<C0908y> f3131q;

    public static class C0943a {
        private final Context f3091a;
        private C0901j f3092b;
        private ExecutorService f3093c;
        private C0917d f3094d;
        private C0946c f3095e;
        private C0949f f3096f;
        private List<C0908y> f3097g;
        private Config f3098h;
        private boolean f3099i;
        private boolean f3100j;

        public C0943a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f3091a = context.getApplicationContext();
        }

        public C0951t m5135a() {
            Context context = this.f3091a;
            if (this.f3092b == null) {
                this.f3092b = ag.m5000a(context);
            }
            if (this.f3094d == null) {
                this.f3094d = new C0933m(context);
            }
            if (this.f3093c == null) {
                this.f3093c = new C0954v();
            }
            if (this.f3096f == null) {
                this.f3096f = C0949f.f3114a;
            }
            aa aaVar = new aa(this.f3094d);
            return new C0951t(context, new C0928i(context, this.f3093c, C0951t.f3115a, this.f3092b, this.f3094d, aaVar), this.f3094d, this.f3095e, this.f3096f, this.f3097g, aaVar, this.f3098h, this.f3099i, this.f3100j);
        }
    }

    private static class C0945b extends Thread {
        private final ReferenceQueue<Object> f3103a;
        private final Handler f3104b;

        C0945b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f3103a = referenceQueue;
            this.f3104b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    C0895a c0895a = (C0895a) this.f3103a.remove(1000);
                    Message obtainMessage = this.f3104b.obtainMessage();
                    if (c0895a != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = c0895a.f2946a;
                        this.f3104b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException e) {
                    return;
                } catch (final Exception e2) {
                    this.f3104b.post(new Runnable(this) {
                        final /* synthetic */ C0945b f3102b;

                        public void run() {
                            throw new RuntimeException(e2);
                        }
                    });
                    return;
                }
            }
        }
    }

    public interface C0946c {
        void m5136a(C0951t c0951t, Uri uri, Exception exception);
    }

    public enum C0947d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        final int f3109d;

        private C0947d(int i) {
            this.f3109d = i;
        }
    }

    public enum C0948e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface C0949f {
        public static final C0949f f3114a = new C09501();

        static class C09501 implements C0949f {
            C09501() {
            }

            public C0957w mo824a(C0957w c0957w) {
                return c0957w;
            }
        }

        C0957w mo824a(C0957w c0957w);
    }

    C0951t(Context context, C0928i c0928i, C0917d c0917d, C0946c c0946c, C0949f c0949f, List<C0908y> list, aa aaVar, Config config, boolean z, boolean z2) {
        this.f3117c = context;
        this.f3118d = c0928i;
        this.f3119e = c0917d;
        this.f3128n = c0946c;
        this.f3129o = c0949f;
        this.f3124j = config;
        List arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new C0960z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C0921f(context));
        arrayList.add(new C0936o(context));
        arrayList.add(new C0922g(context));
        arrayList.add(new C0909b(context));
        arrayList.add(new C0931k(context));
        arrayList.add(new C0940r(c0928i.f3039d, aaVar));
        this.f3131q = Collections.unmodifiableList(arrayList);
        this.f3120f = aaVar;
        this.f3121g = new WeakHashMap();
        this.f3122h = new WeakHashMap();
        this.f3125k = z;
        this.f3126l = z2;
        this.f3123i = new ReferenceQueue();
        this.f3130p = new C0945b(this.f3123i, f3115a);
        this.f3130p.start();
    }

    public static C0951t m5139a(Context context) {
        if (f3116b == null) {
            synchronized (C0951t.class) {
                if (f3116b == null) {
                    f3116b = new C0943a(context).m5135a();
                }
            }
        }
        return f3116b;
    }

    private void m5140a(Bitmap bitmap, C0947d c0947d, C0896a c0896a) {
        if (!c0896a.m4959f()) {
            if (!c0896a.m4960g()) {
                this.f3121g.remove(c0896a.m4957d());
            }
            if (bitmap == null) {
                c0896a.mo811a();
                if (this.f3126l) {
                    ag.m5010a("Main", "errored", c0896a.f2948b.m5166a());
                }
            } else if (c0947d == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                c0896a.mo812a(bitmap, c0947d);
                if (this.f3126l) {
                    ag.m5011a("Main", "completed", c0896a.f2948b.m5166a(), "from " + c0947d);
                }
            }
        }
    }

    private void m5142a(Object obj) {
        ag.m5007a();
        C0896a c0896a = (C0896a) this.f3121g.remove(obj);
        if (c0896a != null) {
            c0896a.mo820b();
            this.f3118d.m5092b(c0896a);
        }
        if (obj instanceof ImageView) {
            C0923h c0923h = (C0923h) this.f3122h.remove((ImageView) obj);
            if (c0923h != null) {
                c0923h.m5076a();
            }
        }
    }

    C0957w m5143a(C0957w c0957w) {
        C0957w a = this.f3129o.mo824a(c0957w);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Request transformer " + this.f3129o.getClass().getCanonicalName() + " returned null for " + c0957w);
    }

    public C0958x m5144a(Uri uri) {
        return new C0958x(this, uri, 0);
    }

    public C0958x m5145a(String str) {
        if (str == null) {
            return new C0958x(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return m5144a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    List<C0908y> m5146a() {
        return this.f3131q;
    }

    public void m5147a(ImageView imageView) {
        m5142a((Object) imageView);
    }

    void m5148a(ImageView imageView, C0923h c0923h) {
        this.f3122h.put(imageView, c0923h);
    }

    void m5149a(C0896a c0896a) {
        Object d = c0896a.m4957d();
        if (!(d == null || this.f3121g.get(d) == c0896a)) {
            m5142a(d);
            this.f3121g.put(d, c0896a);
        }
        m5153b(c0896a);
    }

    public void m5150a(ac acVar) {
        m5142a((Object) acVar);
    }

    void m5151a(C0916c c0916c) {
        Object obj = 1;
        C0896a i = c0916c.m5053i();
        List k = c0916c.m5055k();
        Object obj2 = (k == null || k.isEmpty()) ? null : 1;
        if (i == null && obj2 == null) {
            obj = null;
        }
        if (obj != null) {
            Uri uri = c0916c.m5052h().f3160d;
            Exception l = c0916c.m5056l();
            Bitmap e = c0916c.m5049e();
            C0947d m = c0916c.m5057m();
            if (i != null) {
                m5140a(e, m, i);
            }
            if (obj2 != null) {
                int size = k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m5140a(e, m, (C0896a) k.get(i2));
                }
            }
            if (this.f3128n != null && l != null) {
                this.f3128n.m5136a(this, uri, l);
            }
        }
    }

    Bitmap m5152b(String str) {
        Bitmap a = this.f3119e.mo817a(str);
        if (a != null) {
            this.f3120f.m4968a();
        } else {
            this.f3120f.m4972b();
        }
        return a;
    }

    void m5153b(C0896a c0896a) {
        this.f3118d.m5085a(c0896a);
    }

    void m5154c(C0896a c0896a) {
        Bitmap bitmap = null;
        if (C0937p.m5123a(c0896a.f2951e)) {
            bitmap = m5152b(c0896a.m4958e());
        }
        if (bitmap != null) {
            m5140a(bitmap, C0947d.MEMORY, c0896a);
            if (this.f3126l) {
                ag.m5011a("Main", "completed", c0896a.f2948b.m5166a(), "from " + C0947d.MEMORY);
                return;
            }
            return;
        }
        m5149a(c0896a);
        if (this.f3126l) {
            ag.m5010a("Main", "resumed", c0896a.f2948b.m5166a());
        }
    }
}
