package android.support.v7.p023c.p024a;

import java.lang.reflect.Array;

final class C0609c {
    static final /* synthetic */ boolean f1587a = (!C0609c.class.desiredAssertionStatus());

    private C0609c() {
    }

    public static int m2867a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    public static int[] m2868a(int[] iArr, int i, int i2) {
        if (f1587a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[C0609c.m2867a(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static <T> T[] m2869a(T[] tArr, int i, T t) {
        if (f1587a || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), C0609c.m2867a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }
}
