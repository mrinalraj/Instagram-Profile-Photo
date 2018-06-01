package android.support.v4.p013b;

import android.support.v4.p018g.C0336d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0271b<D> {
    int f853a;
    C0256b<D> f854b;
    C0255a<D> f855c;
    boolean f856d;
    boolean f857e;
    boolean f858f;
    boolean f859g;
    boolean f860h;

    public interface C0255a<D> {
    }

    public interface C0256b<D> {
    }

    public String m1367a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0336d.m1635a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m1368a() {
        this.f856d = true;
        this.f858f = false;
        this.f857e = false;
        m1373b();
    }

    public void m1369a(int i, C0256b<D> c0256b) {
        if (this.f854b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f854b = c0256b;
        this.f853a = i;
    }

    public void m1370a(C0255a<D> c0255a) {
        if (this.f855c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f855c = c0255a;
    }

    public void m1371a(C0256b<D> c0256b) {
        if (this.f854b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f854b != c0256b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f854b = null;
        }
    }

    public void m1372a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f853a);
        printWriter.print(" mListener=");
        printWriter.println(this.f854b);
        if (this.f856d || this.f859g || this.f860h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f856d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f859g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f860h);
        }
        if (this.f857e || this.f858f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f857e);
            printWriter.print(" mReset=");
            printWriter.println(this.f858f);
        }
    }

    protected void m1373b() {
    }

    public void m1374b(C0255a<D> c0255a) {
        if (this.f855c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f855c != c0255a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f855c = null;
        }
    }

    public void m1375c() {
        this.f856d = false;
        m1376d();
    }

    protected void m1376d() {
    }

    public void m1377e() {
        m1378f();
        this.f858f = true;
        this.f856d = false;
        this.f857e = false;
        this.f859g = false;
        this.f860h = false;
    }

    protected void m1378f() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0336d.m1635a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f853a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
