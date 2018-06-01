package com.p026a.p027a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class C0886m {
    private AtomicInteger f2923a;
    private final Map<String, Queue<C0862l<?>>> f2924b;
    private final Set<C0862l<?>> f2925c;
    private final PriorityBlockingQueue<C0862l<?>> f2926d;
    private final PriorityBlockingQueue<C0862l<?>> f2927e;
    private final C0854b f2928f;
    private final C0847f f2929g;
    private final C0876o f2930h;
    private C0878g[] f2931i;
    private C0871c f2932j;
    private List<C0885a> f2933k;

    public interface C0885a<T> {
        void m4933a(C0862l<T> c0862l);
    }

    public C0886m(C0854b c0854b, C0847f c0847f) {
        this(c0854b, c0847f, 4);
    }

    public C0886m(C0854b c0854b, C0847f c0847f, int i) {
        this(c0854b, c0847f, i, new C0877e(new Handler(Looper.getMainLooper())));
    }

    public C0886m(C0854b c0854b, C0847f c0847f, int i, C0876o c0876o) {
        this.f2923a = new AtomicInteger();
        this.f2924b = new HashMap();
        this.f2925c = new HashSet();
        this.f2926d = new PriorityBlockingQueue();
        this.f2927e = new PriorityBlockingQueue();
        this.f2933k = new ArrayList();
        this.f2928f = c0854b;
        this.f2929g = c0847f;
        this.f2931i = new C0878g[i];
        this.f2930h = c0876o;
    }

    public <T> C0862l<T> m4934a(C0862l<T> c0862l) {
        c0862l.m4874a(this);
        synchronized (this.f2925c) {
            this.f2925c.add(c0862l);
        }
        c0862l.m4872a(m4938c());
        c0862l.m4879a("add-to-queue");
        if (c0862l.m4896p()) {
            synchronized (this.f2924b) {
                String d = c0862l.m4884d();
                if (this.f2924b.containsKey(d)) {
                    Queue queue = (Queue) this.f2924b.get(d);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(c0862l);
                    this.f2924b.put(d, queue);
                    if (C0894t.f2945b) {
                        C0894t.m4947a("Request for cacheKey=%s is in flight, putting on hold.", d);
                    }
                } else {
                    this.f2924b.put(d, null);
                    this.f2926d.add(c0862l);
                }
            }
        } else {
            this.f2927e.add(c0862l);
        }
        return c0862l;
    }

    public void m4935a() {
        m4936b();
        this.f2932j = new C0871c(this.f2926d, this.f2927e, this.f2928f, this.f2930h);
        this.f2932j.start();
        for (int i = 0; i < this.f2931i.length; i++) {
            C0878g c0878g = new C0878g(this.f2927e, this.f2929g, this.f2928f, this.f2930h);
            this.f2931i[i] = c0878g;
            c0878g.start();
        }
    }

    public void m4936b() {
        if (this.f2932j != null) {
            this.f2932j.m4916a();
        }
        for (int i = 0; i < this.f2931i.length; i++) {
            if (this.f2931i[i] != null) {
                this.f2931i[i].m4932a();
            }
        }
    }

    <T> void m4937b(C0862l<T> c0862l) {
        synchronized (this.f2925c) {
            this.f2925c.remove(c0862l);
        }
        synchronized (this.f2933k) {
            for (C0885a a : this.f2933k) {
                a.m4933a(c0862l);
            }
        }
        if (c0862l.m4896p()) {
            synchronized (this.f2924b) {
                Queue queue = (Queue) this.f2924b.remove(c0862l.m4884d());
                if (queue != null) {
                    if (C0894t.f2945b) {
                        C0894t.m4947a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f2926d.addAll(queue);
                }
            }
        }
    }

    public int m4938c() {
        return this.f2923a.incrementAndGet();
    }
}
