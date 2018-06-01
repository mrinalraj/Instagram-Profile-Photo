package com.p029b.p030a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

final class ag {
    static final StringBuilder f2994a = new StringBuilder();

    @TargetApi(11)
    private static class C0903a {
        static int m4993a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    private static class C0904b {
        static int m4994a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    private static class C0905c {
        static C0901j m4995a(Context context) {
            return new C0941s(context);
        }
    }

    private static class C0906d extends Thread {
        public C0906d(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class C0907e implements ThreadFactory {
        C0907e() {
        }

        public Thread newThread(Runnable runnable) {
            return new C0906d(runnable);
        }
    }

    static int m4996a(Resources resources, C0957w c0957w) {
        if (c0957w.f3161e != 0 || c0957w.f3160d == null) {
            return c0957w.f3161e;
        }
        String authority = c0957w.f3160d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c0957w.f3160d);
        }
        List pathSegments = c0957w.f3160d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + c0957w.f3160d);
        } else if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt((String) pathSegments.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + c0957w.f3160d);
            }
        } else if (pathSegments.size() == 2) {
            return resources.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
        } else {
            throw new FileNotFoundException("More than two path segments: " + c0957w.f3160d);
        }
    }

    static int m4997a(Bitmap bitmap) {
        int a = VERSION.SDK_INT >= 12 ? C0904b.m4994a(bitmap) : bitmap.getRowBytes() * bitmap.getHeight();
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static long m4998a(File file) {
        long blockSize;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            blockSize = 5242880;
        }
        return Math.max(Math.min(blockSize, 52428800), 5242880);
    }

    static Resources m4999a(Context context, C0957w c0957w) {
        if (c0957w.f3161e != 0 || c0957w.f3160d == null) {
            return context.getResources();
        }
        String authority = c0957w.f3160d.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c0957w.f3160d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + c0957w.f3160d);
        }
    }

    static C0901j m5000a(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return C0905c.m4995a(context);
        } catch (ClassNotFoundException e) {
            return new af(context);
        }
    }

    static <T> T m5001a(Context context, String str) {
        return context.getSystemService(str);
    }

    static <T> T m5002a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static String m5003a(C0916c c0916c) {
        return ag.m5004a(c0916c, "");
    }

    static String m5004a(C0916c c0916c, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        C0896a i = c0916c.m5053i();
        if (i != null) {
            stringBuilder.append(i.f2948b.m5166a());
        }
        List k = c0916c.m5055k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || i != null) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C0896a) k.get(i2)).f2948b.m5166a());
            }
        }
        return stringBuilder.toString();
    }

    static String m5005a(C0957w c0957w) {
        String a = ag.m5006a(c0957w, f2994a);
        f2994a.setLength(0);
        return a;
    }

    static String m5006a(C0957w c0957w, StringBuilder stringBuilder) {
        if (c0957w.f3162f != null) {
            stringBuilder.ensureCapacity(c0957w.f3162f.length() + 50);
            stringBuilder.append(c0957w.f3162f);
        } else if (c0957w.f3160d != null) {
            String uri = c0957w.f3160d.toString();
            stringBuilder.ensureCapacity(uri.length() + 50);
            stringBuilder.append(uri);
        } else {
            stringBuilder.ensureCapacity(50);
            stringBuilder.append(c0957w.f3161e);
        }
        stringBuilder.append('\n');
        if (c0957w.f3169m != 0.0f) {
            stringBuilder.append("rotation:").append(c0957w.f3169m);
            if (c0957w.f3172p) {
                stringBuilder.append('@').append(c0957w.f3170n).append('x').append(c0957w.f3171o);
            }
            stringBuilder.append('\n');
        }
        if (c0957w.m5169d()) {
            stringBuilder.append("resize:").append(c0957w.f3164h).append('x').append(c0957w.f3165i);
            stringBuilder.append('\n');
        }
        if (c0957w.f3166j) {
            stringBuilder.append("centerCrop").append('\n');
        } else if (c0957w.f3167k) {
            stringBuilder.append("centerInside").append('\n');
        }
        if (c0957w.f3163g != null) {
            int size = c0957w.f3163g.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(((ae) c0957w.f3163g.get(i)).m4986a());
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }

    static void m5007a() {
        if (!ag.m5014b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static void m5008a(Looper looper) {
        Handler c09021 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        c09021.sendMessageDelayed(c09021.obtainMessage(), 1000);
    }

    static void m5009a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    static void m5010a(String str, String str2, String str3) {
        ag.m5011a(str, str2, str3, "");
    }

    static void m5011a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    static boolean m5012a(String str) {
        boolean z = true;
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ", 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if (!("CONDITIONAL_CACHE".equals(split[0]) && Integer.parseInt(split[1]) == 304)) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static File m5013b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static boolean m5014b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static boolean m5015b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static byte[] m5016b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static int m5017c(Context context) {
        ActivityManager activityManager = (ActivityManager) ag.m5001a(context, "activity");
        int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || VERSION.SDK_INT < 11) ? activityManager.getMemoryClass() : C0903a.m4993a(activityManager);
        return (memoryClass * 1048576) / 7;
    }

    static boolean m5018c(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    static boolean m5019d(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
