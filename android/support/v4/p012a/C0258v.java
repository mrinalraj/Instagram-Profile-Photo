package android.support.v4.p012a;

import android.os.Bundle;
import android.support.v4.p012a.C0254u.C0253a;
import android.support.v4.p013b.C0271b;
import android.support.v4.p013b.C0271b.C0255a;
import android.support.v4.p013b.C0271b.C0256b;
import android.support.v4.p018g.C0336d;
import android.support.v4.p018g.C0351m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class C0258v extends C0254u {
    static boolean f834a = false;
    final C0351m<C0257a> f835b = new C0351m();
    final C0351m<C0257a> f836c = new C0351m();
    final String f837d;
    boolean f838e;
    boolean f839f;
    C0214l f840g;

    final class C0257a implements C0255a<Object>, C0256b<Object> {
        final int f819a;
        final Bundle f820b;
        C0253a<Object> f821c;
        C0271b<Object> f822d;
        boolean f823e;
        boolean f824f;
        Object f825g;
        boolean f826h;
        boolean f827i;
        boolean f828j;
        boolean f829k;
        boolean f830l;
        boolean f831m;
        C0257a f832n;
        final /* synthetic */ C0258v f833o;

        void m1308a() {
            if (this.f827i && this.f828j) {
                this.f826h = true;
            } else if (!this.f826h) {
                this.f826h = true;
                if (C0258v.f834a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f822d == null && this.f821c != null) {
                    this.f822d = this.f821c.m1304a(this.f819a, this.f820b);
                }
                if (this.f822d == null) {
                    return;
                }
                if (!this.f822d.getClass().isMemberClass() || Modifier.isStatic(this.f822d.getClass().getModifiers())) {
                    if (!this.f831m) {
                        this.f822d.m1369a(this.f819a, this);
                        this.f822d.m1370a((C0255a) this);
                        this.f831m = true;
                    }
                    this.f822d.m1368a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f822d);
            }
        }

        void m1309a(C0271b<Object> c0271b, Object obj) {
            String str;
            if (this.f821c != null) {
                if (this.f833o.f840g != null) {
                    String str2 = this.f833o.f840g.f671d.f743u;
                    this.f833o.f840g.f671d.f743u = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (C0258v.f834a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0271b + ": " + c0271b.m1367a(obj));
                    }
                    this.f821c.m1306a((C0271b) c0271b, obj);
                    this.f824f = true;
                } finally {
                    if (this.f833o.f840g != null) {
                        this.f833o.f840g.f671d.f743u = str;
                    }
                }
            }
        }

        public void m1310a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f819a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f820b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f821c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f822d);
            if (this.f822d != null) {
                this.f822d.m1372a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f823e || this.f824f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f823e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f824f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f825g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f826h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f829k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f830l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f827i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f828j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f831m);
            if (this.f832n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f832n);
                printWriter.println(":");
                this.f832n.m1310a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        void m1311b() {
            if (C0258v.f834a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f827i = true;
            this.f828j = this.f826h;
            this.f826h = false;
            this.f821c = null;
        }

        void m1312c() {
            if (this.f827i) {
                if (C0258v.f834a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f827i = false;
                if (!(this.f826h == this.f828j || this.f826h)) {
                    m1314e();
                }
            }
            if (this.f826h && this.f823e && !this.f829k) {
                m1309a(this.f822d, this.f825g);
            }
        }

        void m1313d() {
            if (this.f826h && this.f829k) {
                this.f829k = false;
                if (this.f823e && !this.f827i) {
                    m1309a(this.f822d, this.f825g);
                }
            }
        }

        void m1314e() {
            if (C0258v.f834a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f826h = false;
            if (!this.f827i && this.f822d != null && this.f831m) {
                this.f831m = false;
                this.f822d.m1371a((C0256b) this);
                this.f822d.m1374b(this);
                this.f822d.m1375c();
            }
        }

        void m1315f() {
            String str;
            C0253a c0253a = null;
            if (C0258v.f834a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f830l = true;
            boolean z = this.f824f;
            this.f824f = false;
            if (this.f821c != null && this.f822d != null && this.f823e && z) {
                if (C0258v.f834a) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }
                if (this.f833o.f840g != null) {
                    String str2 = this.f833o.f840g.f671d.f743u;
                    this.f833o.f840g.f671d.f743u = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f821c.m1305a(this.f822d);
                } finally {
                    c0253a = this.f833o.f840g;
                    if (c0253a != null) {
                        c0253a = this.f833o.f840g.f671d;
                        c0253a.f743u = str;
                    }
                }
            }
            this.f821c = c0253a;
            this.f825g = c0253a;
            this.f823e = false;
            if (this.f822d != null) {
                if (this.f831m) {
                    this.f831m = false;
                    this.f822d.m1371a((C0256b) this);
                    this.f822d.m1374b(this);
                }
                this.f822d.m1377e();
            }
            if (this.f832n != null) {
                this.f832n.m1315f();
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f819a);
            stringBuilder.append(" : ");
            C0336d.m1635a(this.f822d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    C0258v(String str, C0214l c0214l, boolean z) {
        this.f837d = str;
        this.f840g = c0214l;
        this.f838e = z;
    }

    void m1316a(C0214l c0214l) {
        this.f840g = c0214l;
    }

    public void m1317a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f835b.m1670b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f835b.m1670b(); i2++) {
                C0257a c0257a = (C0257a) this.f835b.m1677e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f835b.m1676d(i2));
                printWriter.print(": ");
                printWriter.println(c0257a.toString());
                c0257a.m1310a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f836c.m1670b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f836c.m1670b()) {
                c0257a = (C0257a) this.f836c.m1677e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f836c.m1676d(i));
                printWriter.print(": ");
                printWriter.println(c0257a.toString());
                c0257a.m1310a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo185a() {
        int b = this.f835b.m1670b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            C0257a c0257a = (C0257a) this.f835b.m1677e(i);
            int i2 = (!c0257a.f826h || c0257a.f824f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m1319b() {
        if (f834a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f838e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f838e = true;
        for (int b = this.f835b.m1670b() - 1; b >= 0; b--) {
            ((C0257a) this.f835b.m1677e(b)).m1308a();
        }
    }

    void m1320c() {
        if (f834a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f838e) {
            for (int b = this.f835b.m1670b() - 1; b >= 0; b--) {
                ((C0257a) this.f835b.m1677e(b)).m1314e();
            }
            this.f838e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m1321d() {
        if (f834a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f838e) {
            this.f839f = true;
            this.f838e = false;
            for (int b = this.f835b.m1670b() - 1; b >= 0; b--) {
                ((C0257a) this.f835b.m1677e(b)).m1311b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m1322e() {
        if (this.f839f) {
            if (f834a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f839f = false;
            for (int b = this.f835b.m1670b() - 1; b >= 0; b--) {
                ((C0257a) this.f835b.m1677e(b)).m1312c();
            }
        }
    }

    void m1323f() {
        for (int b = this.f835b.m1670b() - 1; b >= 0; b--) {
            ((C0257a) this.f835b.m1677e(b)).f829k = true;
        }
    }

    void m1324g() {
        for (int b = this.f835b.m1670b() - 1; b >= 0; b--) {
            ((C0257a) this.f835b.m1677e(b)).m1313d();
        }
    }

    void m1325h() {
        int b;
        if (!this.f839f) {
            if (f834a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f835b.m1670b() - 1; b >= 0; b--) {
                ((C0257a) this.f835b.m1677e(b)).m1315f();
            }
            this.f835b.m1673c();
        }
        if (f834a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f836c.m1670b() - 1; b >= 0; b--) {
            ((C0257a) this.f836c.m1677e(b)).m1315f();
        }
        this.f836c.m1673c();
        this.f840g = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0336d.m1635a(this.f840g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
