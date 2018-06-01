package android.support.v4.p017f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class C0328c {
    private final Object f948a = new Object();
    private HandlerThread f949b;
    private Handler f950c;
    private int f951d;
    private Callback f952e = new C03241(this);
    private final int f953f;
    private final int f954g;
    private final String f955h;

    public interface C0317a<T> {
        void mo213a(T t);
    }

    class C03241 implements Callback {
        final /* synthetic */ C0328c f935a;

        C03241(C0328c c0328c) {
            this.f935a = c0328c;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f935a.m1563a();
                    break;
                case 1:
                    this.f935a.m1567b((Runnable) message.obj);
                    break;
            }
            return true;
        }
    }

    public C0328c(String str, int i, int i2) {
        this.f955h = str;
        this.f954g = i;
        this.f953f = i2;
        this.f951d = 0;
    }

    private void m1563a() {
        synchronized (this.f948a) {
            if (this.f950c.hasMessages(1)) {
                return;
            }
            this.f949b.quit();
            this.f949b = null;
            this.f950c = null;
        }
    }

    private void m1566a(Runnable runnable) {
        synchronized (this.f948a) {
            if (this.f949b == null) {
                this.f949b = new HandlerThread(this.f955h, this.f954g);
                this.f949b.start();
                this.f950c = new Handler(this.f949b.getLooper(), this.f952e);
                this.f951d++;
            }
            this.f950c.removeMessages(0);
            this.f950c.sendMessage(this.f950c.obtainMessage(1, runnable));
        }
    }

    private void m1567b(Runnable runnable) {
        runnable.run();
        synchronized (this.f948a) {
            this.f950c.removeMessages(0);
            this.f950c.sendMessageDelayed(this.f950c.obtainMessage(0), (long) this.f953f);
        }
    }

    public <T> T m1568a(Callable<T> callable, int i) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final Callable<T> callable2 = callable;
        m1566a(new Runnable(this) {
            final /* synthetic */ C0328c f947f;

            public void run() {
                try {
                    atomicReference.set(callable2.call());
                } catch (Exception e) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            T t;
            if (atomicBoolean.get()) {
                long toNanos = TimeUnit.MILLISECONDS.toNanos((long) i);
                while (true) {
                    try {
                        toNanos = newCondition.awaitNanos(toNanos);
                    } catch (InterruptedException e) {
                    }
                    if (!atomicBoolean.get()) {
                        break;
                    } else if (toNanos <= 0) {
                        throw new InterruptedException("timeout");
                    }
                }
                t = atomicReference.get();
                reentrantLock.unlock();
            } else {
                t = atomicReference.get();
            }
            return t;
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> void m1569a(final Callable<T> callable, final C0317a<T> c0317a) {
        final Handler handler = new Handler();
        m1566a(new Runnable(this) {
            final /* synthetic */ C0328c f941d;

            public void run() {
                Object call;
                try {
                    call = callable.call();
                } catch (Exception e) {
                    call = null;
                }
                handler.post(new Runnable(this) {
                    final /* synthetic */ C03262 f937b;

                    public void run() {
                        c0317a.mo213a(call);
                    }
                });
            }
        });
    }
}
