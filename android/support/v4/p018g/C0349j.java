package android.support.v4.p018g;

public final class C0349j {

    public interface C0346a<T> {
        T mo223a();

        boolean mo224a(T t);
    }

    public static class C0347b<T> implements C0346a<T> {
        private final Object[] f1012a;
        private int f1013b;

        public C0347b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1012a = new Object[i];
        }

        private boolean m1660b(T t) {
            for (int i = 0; i < this.f1013b; i++) {
                if (this.f1012a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        public T mo223a() {
            if (this.f1013b <= 0) {
                return null;
            }
            int i = this.f1013b - 1;
            T t = this.f1012a[i];
            this.f1012a[i] = null;
            this.f1013b--;
            return t;
        }

        public boolean mo224a(T t) {
            if (m1660b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f1013b >= this.f1012a.length) {
                return false;
            } else {
                this.f1012a[this.f1013b] = t;
                this.f1013b++;
                return true;
            }
        }
    }

    public static class C0348c<T> extends C0347b<T> {
        private final Object f1014a = new Object();

        public C0348c(int i) {
            super(i);
        }

        public T mo223a() {
            T a;
            synchronized (this.f1014a) {
                a = super.mo223a();
            }
            return a;
        }

        public boolean mo224a(T t) {
            boolean a;
            synchronized (this.f1014a) {
                a = super.mo224a(t);
            }
            return a;
        }
    }
}
