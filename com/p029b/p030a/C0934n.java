package com.p029b.p030a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class C0934n extends InputStream {
    private final InputStream f3066a;
    private long f3067b;
    private long f3068c;
    private long f3069d;
    private long f3070e;

    public C0934n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public C0934n(InputStream inputStream, int i) {
        this.f3070e = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, i);
        }
        this.f3066a = inputStream;
    }

    private void m5115a(long j, long j2) {
        while (j < j2) {
            long skip = this.f3066a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    private void m5116b(long j) {
        try {
            if (this.f3068c >= this.f3067b || this.f3067b > this.f3069d) {
                this.f3068c = this.f3067b;
                this.f3066a.mark((int) (j - this.f3067b));
            } else {
                this.f3066a.reset();
                this.f3066a.mark((int) (j - this.f3068c));
                m5115a(this.f3068c, this.f3067b);
            }
            this.f3069d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public long m5117a(int i) {
        long j = this.f3067b + ((long) i);
        if (this.f3069d < j) {
            m5116b(j);
        }
        return this.f3067b;
    }

    public void m5118a(long j) {
        if (this.f3067b > this.f3069d || j < this.f3068c) {
            throw new IOException("Cannot reset");
        }
        this.f3066a.reset();
        m5115a(this.f3068c, j);
        this.f3067b = j;
    }

    public int available() {
        return this.f3066a.available();
    }

    public void close() {
        this.f3066a.close();
    }

    public void mark(int i) {
        this.f3070e = m5117a(i);
    }

    public boolean markSupported() {
        return this.f3066a.markSupported();
    }

    public int read() {
        int read = this.f3066a.read();
        if (read != -1) {
            this.f3067b++;
        }
        return read;
    }

    public int read(byte[] bArr) {
        int read = this.f3066a.read(bArr);
        if (read != -1) {
            this.f3067b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.f3066a.read(bArr, i, i2);
        if (read != -1) {
            this.f3067b += (long) read;
        }
        return read;
    }

    public void reset() {
        m5118a(this.f3070e);
    }

    public long skip(long j) {
        long skip = this.f3066a.skip(j);
        this.f3067b += skip;
        return skip;
    }
}
