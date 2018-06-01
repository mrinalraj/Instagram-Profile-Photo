package android.support.v7.widget;

class bc {
    private int f2559a = 0;
    private int f2560b = 0;
    private int f2561c = Integer.MIN_VALUE;
    private int f2562d = Integer.MIN_VALUE;
    private int f2563e = 0;
    private int f2564f = 0;
    private boolean f2565g = false;
    private boolean f2566h = false;

    bc() {
    }

    public int m4459a() {
        return this.f2559a;
    }

    public void m4460a(int i, int i2) {
        this.f2561c = i;
        this.f2562d = i2;
        this.f2566h = true;
        if (this.f2565g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2559a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2560b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2559a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2560b = i2;
        }
    }

    public void m4461a(boolean z) {
        if (z != this.f2565g) {
            this.f2565g = z;
            if (!this.f2566h) {
                this.f2559a = this.f2563e;
                this.f2560b = this.f2564f;
            } else if (z) {
                this.f2559a = this.f2562d != Integer.MIN_VALUE ? this.f2562d : this.f2563e;
                this.f2560b = this.f2561c != Integer.MIN_VALUE ? this.f2561c : this.f2564f;
            } else {
                this.f2559a = this.f2561c != Integer.MIN_VALUE ? this.f2561c : this.f2563e;
                this.f2560b = this.f2562d != Integer.MIN_VALUE ? this.f2562d : this.f2564f;
            }
        }
    }

    public int m4462b() {
        return this.f2560b;
    }

    public void m4463b(int i, int i2) {
        this.f2566h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2563e = i;
            this.f2559a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2564f = i2;
            this.f2560b = i2;
        }
    }

    public int m4464c() {
        return this.f2565g ? this.f2560b : this.f2559a;
    }

    public int m4465d() {
        return this.f2565g ? this.f2559a : this.f2560b;
    }
}
