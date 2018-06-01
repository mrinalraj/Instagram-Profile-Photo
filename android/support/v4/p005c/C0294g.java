package android.support.v4.p005c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.p005c.C0293c.C0292a;
import android.support.v4.p013b.p014a.C0268b.C0265b;
import android.support.v4.p013b.p014a.C0268b.C0266c;
import android.support.v4.p017f.C0323b.C0322b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class C0294g implements C0292a {

    private interface C0298a<T> {
        boolean mo210a(T t);

        int mo211b(T t);
    }

    class C02991 implements C0298a<C0322b> {
        final /* synthetic */ C0294g f898a;

        C02991(C0294g c0294g) {
            this.f898a = c0294g;
        }

        public int m1501a(C0322b c0322b) {
            return c0322b.m1547c();
        }

        public /* synthetic */ boolean mo210a(Object obj) {
            return m1504b((C0322b) obj);
        }

        public /* synthetic */ int mo211b(Object obj) {
            return m1501a((C0322b) obj);
        }

        public boolean m1504b(C0322b c0322b) {
            return c0322b.m1548d();
        }
    }

    class C03002 implements C0298a<C0266c> {
        final /* synthetic */ C0294g f899a;

        C03002(C0294g c0294g) {
            this.f899a = c0294g;
        }

        public int m1505a(C0266c c0266c) {
            return c0266c.m1341b();
        }

        public /* synthetic */ boolean mo210a(Object obj) {
            return m1508b((C0266c) obj);
        }

        public /* synthetic */ int mo211b(Object obj) {
            return m1505a((C0266c) obj);
        }

        public boolean m1508b(C0266c c0266c) {
            return c0266c.m1342c();
        }
    }

    C0294g() {
    }

    private C0266c m1474a(C0265b c0265b, int i) {
        return (C0266c) C0294g.m1475a(c0265b.m1339a(), i, new C03002(this));
    }

    private static <T> T m1475a(T[] tArr, int i, C0298a<T> c0298a) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        int length = tArr.length;
        int i4 = 0;
        while (i4 < length) {
            T t2;
            T t3 = tArr[i4];
            int abs = (c0298a.mo210a(t3) == z ? 0 : 1) + (Math.abs(c0298a.mo211b(t3) - i2) * 2);
            if (t == null || r3 > abs) {
                i3 = abs;
                t2 = t3;
            } else {
                t2 = t;
            }
            i4++;
            t = t2;
        }
        return t;
    }

    public Typeface mo207a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typeface = null;
        File a = C0301h.m1509a(context);
        if (a != null) {
            try {
                if (C0301h.m1514a(a, resources, i)) {
                    typeface = Typeface.createFromFile(a.getPath());
                    a.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                a.delete();
            }
        }
        return typeface;
    }

    public Typeface mo208a(Context context, CancellationSignal cancellationSignal, C0322b[] c0322bArr, int i) {
        Closeable openInputStream;
        Throwable th;
        Typeface typeface = null;
        if (c0322bArr.length >= 1) {
            try {
                openInputStream = context.getContentResolver().openInputStream(m1480a(c0322bArr, i).m1545a());
                try {
                    typeface = m1479a(context, (InputStream) openInputStream);
                    C0301h.m1513a(openInputStream);
                } catch (IOException e) {
                    C0301h.m1513a(openInputStream);
                    return typeface;
                } catch (Throwable th2) {
                    th = th2;
                    C0301h.m1513a(openInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                openInputStream = typeface;
                C0301h.m1513a(openInputStream);
                return typeface;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                openInputStream = typeface;
                th = th4;
                C0301h.m1513a(openInputStream);
                throw th;
            }
        }
        return typeface;
    }

    public Typeface mo209a(Context context, C0265b c0265b, Resources resources, int i) {
        C0266c a = m1474a(c0265b, i);
        return a == null ? null : C0293c.m1469a(context, resources, a.m1343d(), a.m1340a(), i);
    }

    protected Typeface m1479a(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File a = C0301h.m1509a(context);
        if (a != null) {
            try {
                if (C0301h.m1515a(a, inputStream)) {
                    typeface = Typeface.createFromFile(a.getPath());
                    a.delete();
                }
            } catch (RuntimeException e) {
            } finally {
                a.delete();
            }
        }
        return typeface;
    }

    protected C0322b m1480a(C0322b[] c0322bArr, int i) {
        return (C0322b) C0294g.m1475a(c0322bArr, i, new C02991(this));
    }
}
