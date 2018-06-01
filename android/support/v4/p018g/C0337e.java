package android.support.v4.p018g;

import android.util.Log;
import java.io.Writer;

public class C0337e extends Writer {
    private final String f983a;
    private StringBuilder f984b = new StringBuilder(128);

    public C0337e(String str) {
        this.f983a = str;
    }

    private void m1636a() {
        if (this.f984b.length() > 0) {
            Log.d(this.f983a, this.f984b.toString());
            this.f984b.delete(0, this.f984b.length());
        }
    }

    public void close() {
        m1636a();
    }

    public void flush() {
        m1636a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1636a();
            } else {
                this.f984b.append(c);
            }
        }
    }
}
