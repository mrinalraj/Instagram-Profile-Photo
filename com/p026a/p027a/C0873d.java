package com.p026a.p027a;

public class C0873d implements C0872p {
    private int f2894a;
    private int f2895b;
    private final int f2896c;
    private final float f2897d;

    public C0873d() {
        this(2500, 1, 1.0f);
    }

    public C0873d(int i, int i2, float f) {
        this.f2894a = i;
        this.f2896c = i2;
        this.f2897d = f;
    }

    public int mo805a() {
        return this.f2894a;
    }

    public void mo806a(C0867s c0867s) {
        this.f2895b++;
        this.f2894a = (int) (((float) this.f2894a) + (((float) this.f2894a) * this.f2897d));
        if (!m4923c()) {
            throw c0867s;
        }
    }

    public int mo807b() {
        return this.f2895b;
    }

    protected boolean m4923c() {
        return this.f2895b <= this.f2896c;
    }
}
