package android.support.v4.p012a;

import android.os.Build.VERSION;
import android.support.v4.p012a.C0212h.C0211c;
import android.support.v4.p012a.C0233n.C0198f;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class C0199c extends C0197r implements C0198f {
    static final boolean f560a = (VERSION.SDK_INT >= 21);
    final C0233n f561b;
    ArrayList<C0196a> f562c = new ArrayList();
    int f563d;
    int f564e;
    int f565f;
    int f566g;
    int f567h;
    int f568i;
    boolean f569j;
    boolean f570k = true;
    String f571l;
    boolean f572m;
    int f573n = -1;
    int f574o;
    CharSequence f575p;
    int f576q;
    CharSequence f577r;
    ArrayList<String> f578s;
    ArrayList<String> f579t;
    boolean f580u = false;
    ArrayList<Runnable> f581v;

    static final class C0196a {
        int f554a;
        C0212h f555b;
        int f556c;
        int f557d;
        int f558e;
        int f559f;

        C0196a() {
        }

        C0196a(int i, C0212h c0212h) {
            this.f554a = i;
            this.f555b = c0212h;
        }
    }

    public C0199c(C0233n c0233n) {
        this.f561b = c0233n;
    }

    private static boolean m881b(C0196a c0196a) {
        C0212h c0212h = c0196a.f555b;
        return (c0212h == null || !c0212h.f651k || c0212h.f628H == null || c0212h.f621A || c0212h.f666z || !c0212h.m945U()) ? false : true;
    }

    C0212h m882a(ArrayList<C0212h> arrayList, C0212h c0212h) {
        int i = 0;
        while (i < this.f562c.size()) {
            C0196a c0196a = (C0196a) this.f562c.get(i);
            switch (c0196a.f554a) {
                case 1:
                case 7:
                    arrayList.add(c0196a.f555b);
                    break;
                case 2:
                    C0212h c0212h2 = c0196a.f555b;
                    int i2 = c0212h2.f664x;
                    Object obj = null;
                    int size = arrayList.size() - 1;
                    C0212h c0212h3 = c0212h;
                    int i3 = i;
                    while (size >= 0) {
                        Object obj2;
                        C0212h c0212h4 = (C0212h) arrayList.get(size);
                        if (c0212h4.f664x != i2) {
                            obj2 = obj;
                        } else if (c0212h4 == c0212h2) {
                            obj2 = 1;
                        } else {
                            if (c0212h4 == c0212h3) {
                                this.f562c.add(i3, new C0196a(9, c0212h4));
                                i3++;
                                c0212h3 = null;
                            }
                            C0196a c0196a2 = new C0196a(3, c0212h4);
                            c0196a2.f556c = c0196a.f556c;
                            c0196a2.f558e = c0196a.f558e;
                            c0196a2.f557d = c0196a.f557d;
                            c0196a2.f559f = c0196a.f559f;
                            this.f562c.add(i3, c0196a2);
                            arrayList.remove(c0212h4);
                            i3++;
                            obj2 = obj;
                        }
                        size--;
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.f562c.remove(i3);
                        i3--;
                    } else {
                        c0196a.f554a = 1;
                        arrayList.add(c0212h2);
                    }
                    i = i3;
                    c0212h = c0212h3;
                    break;
                case 3:
                case 6:
                    arrayList.remove(c0196a.f555b);
                    if (c0196a.f555b != c0212h) {
                        break;
                    }
                    this.f562c.add(i, new C0196a(9, c0196a.f555b));
                    i++;
                    c0212h = null;
                    break;
                case 8:
                    this.f562c.add(i, new C0196a(9, c0212h));
                    i++;
                    c0212h = c0196a.f555b;
                    break;
                default:
                    break;
            }
            i++;
        }
        return c0212h;
    }

    public void m883a() {
        if (this.f581v != null) {
            int size = this.f581v.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.f581v.get(i)).run();
            }
            this.f581v = null;
        }
    }

    void m884a(int i) {
        if (this.f569j) {
            if (C0233n.f718a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f562c.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0196a c0196a = (C0196a) this.f562c.get(i2);
                if (c0196a.f555b != null) {
                    C0212h c0212h = c0196a.f555b;
                    c0212h.f657q += i;
                    if (C0233n.f718a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0196a.f555b + " to " + c0196a.f555b.f657q);
                    }
                }
            }
        }
    }

    void m885a(C0196a c0196a) {
        this.f562c.add(c0196a);
        c0196a.f556c = this.f563d;
        c0196a.f557d = this.f564e;
        c0196a.f558e = this.f565f;
        c0196a.f559f = this.f566g;
    }

    void m886a(C0211c c0211c) {
        for (int i = 0; i < this.f562c.size(); i++) {
            C0196a c0196a = (C0196a) this.f562c.get(i);
            if (C0199c.m881b(c0196a)) {
                c0196a.f555b.m963a(c0211c);
            }
        }
    }

    public void m887a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m888a(str, printWriter, true);
    }

    public void m888a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f571l);
            printWriter.print(" mIndex=");
            printWriter.print(this.f573n);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f572m);
            if (this.f567h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f567h));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f568i));
            }
            if (!(this.f563d == 0 && this.f564e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f563d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f564e));
            }
            if (!(this.f565f == 0 && this.f566g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f565f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f566g));
            }
            if (!(this.f574o == 0 && this.f575p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f574o));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f575p);
            }
            if (!(this.f576q == 0 && this.f577r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f576q));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f577r);
            }
        }
        if (!this.f562c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.f562c.size();
            for (int i = 0; i < size; i++) {
                String str2;
                C0196a c0196a = (C0196a) this.f562c.get(i);
                switch (c0196a.f554a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + c0196a.f554a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(c0196a.f555b);
                if (z) {
                    if (!(c0196a.f556c == 0 && c0196a.f557d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0196a.f556c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0196a.f557d));
                    }
                    if (c0196a.f558e != 0 || c0196a.f559f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0196a.f558e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0196a.f559f));
                    }
                }
            }
        }
    }

    void m889a(boolean z) {
        for (int size = this.f562c.size() - 1; size >= 0; size--) {
            C0196a c0196a = (C0196a) this.f562c.get(size);
            C0212h c0212h = c0196a.f555b;
            if (c0212h != null) {
                c0212h.m952a(C0233n.m1155d(this.f567h), this.f568i);
            }
            switch (c0196a.f554a) {
                case 1:
                    c0212h.m951a(c0196a.f559f);
                    this.f561b.m1214h(c0212h);
                    break;
                case 3:
                    c0212h.m951a(c0196a.f558e);
                    this.f561b.m1175a(c0212h, false);
                    break;
                case 4:
                    c0212h.m951a(c0196a.f558e);
                    this.f561b.m1219j(c0212h);
                    break;
                case 5:
                    c0212h.m951a(c0196a.f559f);
                    this.f561b.m1217i(c0212h);
                    break;
                case 6:
                    c0212h.m951a(c0196a.f558e);
                    this.f561b.m1223l(c0212h);
                    break;
                case 7:
                    c0212h.m951a(c0196a.f559f);
                    this.f561b.m1221k(c0212h);
                    break;
                case 8:
                    this.f561b.m1229o(null);
                    break;
                case 9:
                    this.f561b.m1229o(c0212h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0196a.f554a);
            }
            if (!(this.f580u || c0196a.f554a == 3 || c0212h == null)) {
                this.f561b.m1204e(c0212h);
            }
        }
        if (!this.f580u && z) {
            this.f561b.m1165a(this.f561b.f735l, true);
        }
    }

    boolean m890a(ArrayList<C0199c> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f562c.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            int i5;
            C0196a c0196a = (C0196a) this.f562c.get(i4);
            int i6 = c0196a.f555b != null ? c0196a.f555b.f664x : 0;
            if (i6 == 0 || i6 == i3) {
                i5 = i3;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    C0199c c0199c = (C0199c) arrayList.get(i7);
                    int size2 = c0199c.f562c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        C0196a c0196a2 = (C0196a) c0199c.f562c.get(i8);
                        if ((c0196a2.f555b != null ? c0196a2.f555b.f664x : 0) == i6) {
                            return true;
                        }
                    }
                }
                i5 = i6;
            }
            i4++;
            i3 = i5;
        }
        return false;
    }

    public boolean mo157a(ArrayList<C0199c> arrayList, ArrayList<Boolean> arrayList2) {
        if (C0233n.f718a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.f569j) {
            this.f561b.m1169a(this);
        }
        return true;
    }

    C0212h m892b(ArrayList<C0212h> arrayList, C0212h c0212h) {
        for (int i = 0; i < this.f562c.size(); i++) {
            C0196a c0196a = (C0196a) this.f562c.get(i);
            switch (c0196a.f554a) {
                case 1:
                case 7:
                    arrayList.remove(c0196a.f555b);
                    break;
                case 3:
                case 6:
                    arrayList.add(c0196a.f555b);
                    break;
                case 8:
                    c0212h = null;
                    break;
                case 9:
                    c0212h = c0196a.f555b;
                    break;
                default:
                    break;
            }
        }
        return c0212h;
    }

    void m893b() {
        int size = this.f562c.size();
        for (int i = 0; i < size; i++) {
            C0196a c0196a = (C0196a) this.f562c.get(i);
            C0212h c0212h = c0196a.f555b;
            if (c0212h != null) {
                c0212h.m952a(this.f567h, this.f568i);
            }
            switch (c0196a.f554a) {
                case 1:
                    c0212h.m951a(c0196a.f556c);
                    this.f561b.m1175a(c0212h, false);
                    break;
                case 3:
                    c0212h.m951a(c0196a.f557d);
                    this.f561b.m1214h(c0212h);
                    break;
                case 4:
                    c0212h.m951a(c0196a.f557d);
                    this.f561b.m1217i(c0212h);
                    break;
                case 5:
                    c0212h.m951a(c0196a.f556c);
                    this.f561b.m1219j(c0212h);
                    break;
                case 6:
                    c0212h.m951a(c0196a.f557d);
                    this.f561b.m1221k(c0212h);
                    break;
                case 7:
                    c0212h.m951a(c0196a.f556c);
                    this.f561b.m1223l(c0212h);
                    break;
                case 8:
                    this.f561b.m1229o(c0212h);
                    break;
                case 9:
                    this.f561b.m1229o(null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0196a.f554a);
            }
            if (!(this.f580u || c0196a.f554a == 1 || c0212h == null)) {
                this.f561b.m1204e(c0212h);
            }
        }
        if (!this.f580u) {
            this.f561b.m1165a(this.f561b.f735l, true);
        }
    }

    boolean m894b(int i) {
        int size = this.f562c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0196a c0196a = (C0196a) this.f562c.get(i2);
            int i3 = c0196a.f555b != null ? c0196a.f555b.f664x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    boolean m895c() {
        for (int i = 0; i < this.f562c.size(); i++) {
            if (C0199c.m881b((C0196a) this.f562c.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String m896d() {
        return this.f571l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f573n >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f573n);
        }
        if (this.f571l != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f571l);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
