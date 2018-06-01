package com.p026a.p027a.p028a;

import java.io.ByteArrayOutputStream;

public class C0865j extends ByteArrayOutputStream {
    private final C0850b f2875a;

    public C0865j(C0850b c0850b, int i) {
        this.f2875a = c0850b;
        this.buf = this.f2875a.m4823a(Math.max(i, 256));
    }

    private void m4909a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f2875a.m4823a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f2875a.m4822a(this.buf);
            this.buf = a;
        }
    }

    public void close() {
        this.f2875a.m4822a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f2875a.m4822a(this.buf);
    }

    public synchronized void write(int i) {
        m4909a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m4909a(i2);
        super.write(bArr, i, i2);
    }
}
