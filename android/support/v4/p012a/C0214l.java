package android.support.v4.p012a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.p018g.C0331l;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class C0214l<E> extends C0207j {
    private final Activity f668a;
    final Context f669b;
    final int f670c;
    final C0233n f671d;
    private final Handler f672e;
    private C0331l<String, C0254u> f673f;
    private boolean f674g;
    private C0258v f675h;
    private boolean f676i;
    private boolean f677j;

    C0214l(Activity activity, Context context, Handler handler, int i) {
        this.f671d = new C0233n();
        this.f668a = activity;
        this.f669b = context;
        this.f672e = handler;
        this.f670c = i;
    }

    C0214l(C0217i c0217i) {
        this(c0217i, c0217i, c0217i.f682c, 0);
    }

    C0258v m1024a(String str, boolean z, boolean z2) {
        if (this.f673f == null) {
            this.f673f = new C0331l();
        }
        C0258v c0258v = (C0258v) this.f673f.get(str);
        if (c0258v == null && z2) {
            c0258v = new C0258v(str, this, z);
            this.f673f.put(str, c0258v);
            return c0258v;
        } else if (!z || c0258v == null || c0258v.f838e) {
            return c0258v;
        } else {
            c0258v.m1319b();
            return c0258v;
        }
    }

    public View mo159a(int i) {
        return null;
    }

    void m1026a(C0331l<String, C0254u> c0331l) {
        if (c0331l != null) {
            int size = c0331l.size();
            for (int i = 0; i < size; i++) {
                ((C0258v) c0331l.m1607c(i)).m1316a(this);
            }
        }
        this.f673f = c0331l;
    }

    void m1027a(String str) {
        if (this.f673f != null) {
            C0258v c0258v = (C0258v) this.f673f.get(str);
            if (c0258v != null && !c0258v.f839f) {
                c0258v.m1325h();
                this.f673f.remove(str);
            }
        }
    }

    public void mo161a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void m1029a(boolean z) {
        this.f674g = z;
        if (this.f675h != null && this.f677j) {
            this.f677j = false;
            if (z) {
                this.f675h.m1321d();
            } else {
                this.f675h.m1320c();
            }
        }
    }

    public boolean mo160a() {
        return true;
    }

    public boolean mo162a(C0212h c0212h) {
        return true;
    }

    public LayoutInflater mo163b() {
        return (LayoutInflater) this.f669b.getSystemService("layout_inflater");
    }

    void mo164b(C0212h c0212h) {
    }

    void m1034b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f677j);
        if (this.f675h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f675h)));
            printWriter.println(":");
            this.f675h.m1317a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void mo165c() {
    }

    public boolean mo166d() {
        return true;
    }

    public int mo167e() {
        return this.f670c;
    }

    Activity m1038f() {
        return this.f668a;
    }

    Context m1039g() {
        return this.f669b;
    }

    Handler m1040h() {
        return this.f672e;
    }

    C0233n m1041i() {
        return this.f671d;
    }

    boolean m1042j() {
        return this.f674g;
    }

    void m1043k() {
        if (!this.f677j) {
            this.f677j = true;
            if (this.f675h != null) {
                this.f675h.m1319b();
            } else if (!this.f676i) {
                this.f675h = m1024a("(root)", this.f677j, false);
                if (!(this.f675h == null || this.f675h.f838e)) {
                    this.f675h.m1319b();
                }
            }
            this.f676i = true;
        }
    }

    void m1044l() {
        if (this.f675h != null) {
            this.f675h.m1325h();
        }
    }

    void m1045m() {
        if (this.f673f != null) {
            int size = this.f673f.size();
            C0258v[] c0258vArr = new C0258v[size];
            for (int i = size - 1; i >= 0; i--) {
                c0258vArr[i] = (C0258v) this.f673f.m1607c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0258v c0258v = c0258vArr[i2];
                c0258v.m1322e();
                c0258v.m1324g();
            }
        }
    }

    C0331l<String, C0254u> m1046n() {
        int i;
        int i2 = 0;
        if (this.f673f != null) {
            int size = this.f673f.size();
            C0258v[] c0258vArr = new C0258v[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c0258vArr[i3] = (C0258v) this.f673f.m1607c(i3);
            }
            boolean j = m1042j();
            i = 0;
            while (i2 < size) {
                C0258v c0258v = c0258vArr[i2];
                if (!c0258v.f839f && j) {
                    if (!c0258v.f838e) {
                        c0258v.m1319b();
                    }
                    c0258v.m1321d();
                }
                if (c0258v.f839f) {
                    i = 1;
                } else {
                    c0258v.m1325h();
                    this.f673f.remove(c0258v.f837d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.f673f : null;
    }
}
