package com.p029b.p030a;

import java.io.PrintWriter;

public class ab {
    public final int f2976a;
    public final int f2977b;
    public final long f2978c;
    public final long f2979d;
    public final long f2980e;
    public final long f2981f;
    public final long f2982g;
    public final long f2983h;
    public final long f2984i;
    public final long f2985j;
    public final int f2986k;
    public final int f2987l;
    public final int f2988m;
    public final long f2989n;

    public ab(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f2976a = i;
        this.f2977b = i2;
        this.f2978c = j;
        this.f2979d = j2;
        this.f2980e = j3;
        this.f2981f = j4;
        this.f2982g = j5;
        this.f2983h = j6;
        this.f2984i = j7;
        this.f2985j = j8;
        this.f2986k = i3;
        this.f2987l = i4;
        this.f2988m = i5;
        this.f2989n = j9;
    }

    public void m4979a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f2976a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f2977b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f2977b) / ((float) this.f2976a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f2978c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f2979d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f2986k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f2980e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f2983h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f2987l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f2981f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f2988m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f2982g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f2984i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f2985j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f2976a + ", size=" + this.f2977b + ", cacheHits=" + this.f2978c + ", cacheMisses=" + this.f2979d + ", downloadCount=" + this.f2986k + ", totalDownloadSize=" + this.f2980e + ", averageDownloadSize=" + this.f2983h + ", totalOriginalBitmapSize=" + this.f2981f + ", totalTransformedBitmapSize=" + this.f2982g + ", averageOriginalBitmapSize=" + this.f2984i + ", averageTransformedBitmapSize=" + this.f2985j + ", originalBitmapCount=" + this.f2987l + ", transformedBitmapCount=" + this.f2988m + ", timeStamp=" + this.f2989n + '}';
    }
}
