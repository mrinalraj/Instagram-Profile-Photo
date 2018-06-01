package android.support.v4.p018g;

public class C0345i<F, S> {
    public final F f1010a;
    public final S f1011b;

    private static boolean m1657a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0345i)) {
            return false;
        }
        C0345i c0345i = (C0345i) obj;
        return C0345i.m1657a(c0345i.f1010a, this.f1010a) && C0345i.m1657a(c0345i.f1011b, this.f1011b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f1010a == null ? 0 : this.f1010a.hashCode();
        if (this.f1011b != null) {
            i = this.f1011b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1010a) + " " + String.valueOf(this.f1011b) + "}";
    }
}
