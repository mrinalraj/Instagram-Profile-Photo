package android.support.v7.app;

class C0591p {
    private static C0591p f1524d;
    public long f1525a;
    public long f1526b;
    public int f1527c;

    C0591p() {
    }

    static C0591p m2770a() {
        if (f1524d == null) {
            f1524d = new C0591p();
        }
        return f1524d;
    }

    public void m2771a(long j, double d, double d2) {
        float f = ((float) (j - 946728000000L)) / 8.64E7f;
        float f2 = 6.24006f + (0.01720197f * f);
        double sin = ((((((double) f2) + (0.03341960161924362d * Math.sin((double) f2))) + (3.4906598739326E-4d * Math.sin((double) (2.0f * f2)))) + (5.236000106378924E-6d * Math.sin((double) (3.0f * f2)))) + 1.796593063d) + 3.141592653589793d;
        double d3 = (-d2) / 360.0d;
        double sin2 = ((Math.sin((double) f2) * 0.0053d) + (d3 + ((double) (((float) Math.round(((double) (f - 9.0E-4f)) - d3)) + 9.0E-4f)))) + (-0.0069d * Math.sin(2.0d * sin));
        sin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        d3 = 0.01745329238474369d * d;
        sin = (Math.sin(-0.10471975803375244d) - (Math.sin(d3) * Math.sin(sin))) / (Math.cos(sin) * Math.cos(d3));
        if (sin >= 1.0d) {
            this.f1527c = 1;
            this.f1525a = -1;
            this.f1526b = -1;
        } else if (sin <= -1.0d) {
            this.f1527c = 0;
            this.f1525a = -1;
            this.f1526b = -1;
        } else {
            float acos = (float) (Math.acos(sin) / 6.283185307179586d);
            this.f1525a = Math.round((((double) acos) + sin2) * 8.64E7d) + 946728000000L;
            this.f1526b = Math.round((sin2 - ((double) acos)) * 8.64E7d) + 946728000000L;
            if (this.f1526b >= j || this.f1525a <= j) {
                this.f1527c = 1;
            } else {
                this.f1527c = 0;
            }
        }
    }
}
