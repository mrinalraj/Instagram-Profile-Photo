package com.p026a.p027a.p028a;

import android.os.SystemClock;
import com.p026a.p027a.C0854b;
import com.p026a.p027a.C0854b.C0869a;
import com.p026a.p027a.C0894t;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C0855c implements C0854b {
    private final Map<String, C0852a> f2853a;
    private long f2854b;
    private final File f2855c;
    private final int f2856d;

    static class C0852a {
        public long f2844a;
        public String f2845b;
        public String f2846c;
        public long f2847d;
        public long f2848e;
        public long f2849f;
        public long f2850g;
        public Map<String, String> f2851h;

        private C0852a() {
        }

        public C0852a(String str, C0869a c0869a) {
            this.f2845b = str;
            this.f2844a = (long) c0869a.f2879a.length;
            this.f2846c = c0869a.f2880b;
            this.f2847d = c0869a.f2881c;
            this.f2848e = c0869a.f2882d;
            this.f2849f = c0869a.f2883e;
            this.f2850g = c0869a.f2884f;
            this.f2851h = c0869a.f2885g;
        }

        public static C0852a m4824a(InputStream inputStream) {
            C0852a c0852a = new C0852a();
            if (C0855c.m4831a(inputStream) != 538247942) {
                throw new IOException();
            }
            c0852a.f2845b = C0855c.m4840c(inputStream);
            c0852a.f2846c = C0855c.m4840c(inputStream);
            if (c0852a.f2846c.equals("")) {
                c0852a.f2846c = null;
            }
            c0852a.f2847d = C0855c.m4839b(inputStream);
            c0852a.f2848e = C0855c.m4839b(inputStream);
            c0852a.f2849f = C0855c.m4839b(inputStream);
            c0852a.f2850g = C0855c.m4839b(inputStream);
            c0852a.f2851h = C0855c.m4842d(inputStream);
            return c0852a;
        }

        public C0869a m4825a(byte[] bArr) {
            C0869a c0869a = new C0869a();
            c0869a.f2879a = bArr;
            c0869a.f2880b = this.f2846c;
            c0869a.f2881c = this.f2847d;
            c0869a.f2882d = this.f2848e;
            c0869a.f2883e = this.f2849f;
            c0869a.f2884f = this.f2850g;
            c0869a.f2885g = this.f2851h;
            return c0869a;
        }

        public boolean m4826a(OutputStream outputStream) {
            try {
                C0855c.m4833a(outputStream, 538247942);
                C0855c.m4835a(outputStream, this.f2845b);
                C0855c.m4835a(outputStream, this.f2846c == null ? "" : this.f2846c);
                C0855c.m4834a(outputStream, this.f2847d);
                C0855c.m4834a(outputStream, this.f2848e);
                C0855c.m4834a(outputStream, this.f2849f);
                C0855c.m4834a(outputStream, this.f2850g);
                C0855c.m4837a(this.f2851h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                C0894t.m4949b("%s", e.toString());
                return false;
            }
        }
    }

    private static class C0853b extends FilterInputStream {
        private int f2852a;

        private C0853b(InputStream inputStream) {
            super(inputStream);
            this.f2852a = 0;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f2852a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f2852a += read;
            }
            return read;
        }
    }

    public C0855c(File file) {
        this(file, 5242880);
    }

    public C0855c(File file, int i) {
        this.f2853a = new LinkedHashMap(16, 0.75f, true);
        this.f2854b = 0;
        this.f2855c = file;
        this.f2856d = i;
    }

    static int m4831a(InputStream inputStream) {
        return (((0 | (C0855c.m4843e(inputStream) << 0)) | (C0855c.m4843e(inputStream) << 8)) | (C0855c.m4843e(inputStream) << 16)) | (C0855c.m4843e(inputStream) << 24);
    }

    private void m4832a(int i) {
        if (this.f2854b + ((long) i) >= ((long) this.f2856d)) {
            int i2;
            if (C0894t.f2945b) {
                C0894t.m4947a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f2854b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f2853a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C0852a c0852a = (C0852a) ((Entry) it.next()).getValue();
                if (m4849c(c0852a.f2845b).delete()) {
                    this.f2854b -= c0852a.f2844a;
                } else {
                    C0894t.m4949b("Could not delete cache entry for key=%s, filename=%s", c0852a.f2845b, m4841d(c0852a.f2845b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f2854b + ((long) i))) < ((float) this.f2856d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (C0894t.f2945b) {
                C0894t.m4947a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f2854b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void m4833a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void m4834a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m4835a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        C0855c.m4834a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m4836a(String str, C0852a c0852a) {
        if (this.f2853a.containsKey(str)) {
            C0852a c0852a2 = (C0852a) this.f2853a.get(str);
            this.f2854b = (c0852a.f2844a - c0852a2.f2844a) + this.f2854b;
        } else {
            this.f2854b += c0852a.f2844a;
        }
        this.f2853a.put(str, c0852a);
    }

    static void m4837a(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            C0855c.m4833a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                C0855c.m4835a(outputStream, (String) entry.getKey());
                C0855c.m4835a(outputStream, (String) entry.getValue());
            }
            return;
        }
        C0855c.m4833a(outputStream, 0);
    }

    private static byte[] m4838a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long m4839b(InputStream inputStream) {
        return (((((((0 | ((((long) C0855c.m4843e(inputStream)) & 255) << null)) | ((((long) C0855c.m4843e(inputStream)) & 255) << 8)) | ((((long) C0855c.m4843e(inputStream)) & 255) << 16)) | ((((long) C0855c.m4843e(inputStream)) & 255) << 24)) | ((((long) C0855c.m4843e(inputStream)) & 255) << 32)) | ((((long) C0855c.m4843e(inputStream)) & 255) << 40)) | ((((long) C0855c.m4843e(inputStream)) & 255) << 48)) | ((((long) C0855c.m4843e(inputStream)) & 255) << 56);
    }

    static String m4840c(InputStream inputStream) {
        return new String(C0855c.m4838a(inputStream, (int) C0855c.m4839b(inputStream)), "UTF-8");
    }

    private String m4841d(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> m4842d(InputStream inputStream) {
        int a = C0855c.m4831a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(C0855c.m4840c(inputStream).intern(), C0855c.m4840c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m4843e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void m4844e(String str) {
        C0852a c0852a = (C0852a) this.f2853a.get(str);
        if (c0852a != null) {
            this.f2854b -= c0852a.f2844a;
            this.f2853a.remove(str);
        }
    }

    public synchronized C0869a mo795a(String str) {
        C0869a c0869a;
        C0853b c0853b;
        IOException e;
        Throwable th;
        C0852a c0852a = (C0852a) this.f2853a.get(str);
        if (c0852a == null) {
            c0869a = null;
        } else {
            File c = m4849c(str);
            try {
                c0853b = new C0853b(new BufferedInputStream(new FileInputStream(c)));
                try {
                    C0852a.m4824a((InputStream) c0853b);
                    c0869a = c0852a.m4825a(C0855c.m4838a((InputStream) c0853b, (int) (c.length() - ((long) c0853b.f2852a))));
                    if (c0853b != null) {
                        try {
                            c0853b.close();
                        } catch (IOException e2) {
                            c0869a = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C0894t.m4949b("%s: %s", c.getAbsolutePath(), e.toString());
                        m4848b(str);
                        if (c0853b != null) {
                            try {
                                c0853b.close();
                            } catch (IOException e4) {
                                c0869a = null;
                            }
                        }
                        c0869a = null;
                        return c0869a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c0853b != null) {
                            try {
                                c0853b.close();
                            } catch (IOException e5) {
                                c0869a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c0853b = null;
                C0894t.m4949b("%s: %s", c.getAbsolutePath(), e.toString());
                m4848b(str);
                if (c0853b != null) {
                    c0853b.close();
                }
                c0869a = null;
                return c0869a;
            } catch (Throwable th3) {
                th = th3;
                c0853b = null;
                if (c0853b != null) {
                    c0853b.close();
                }
                throw th;
            }
        }
        return c0869a;
    }

    public synchronized void mo796a() {
        Throwable th;
        if (this.f2855c.exists()) {
            File[] listFiles = this.f2855c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream = null;
                    BufferedInputStream bufferedInputStream2;
                    try {
                        bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            C0852a a = C0852a.m4824a((InputStream) bufferedInputStream2);
                            a.f2844a = file.length();
                            m4836a(a.f2845b, a);
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    bufferedInputStream = bufferedInputStream2;
                                    th = th3;
                                }
                            }
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        bufferedInputStream2 = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.f2855c.mkdirs()) {
            C0894t.m4950c("Unable to create cache dir %s", this.f2855c.getAbsolutePath());
        }
        return;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e5) {
            }
        }
        throw th;
        throw th;
    }

    public synchronized void mo797a(String str, C0869a c0869a) {
        m4832a(c0869a.f2879a.length);
        File c = m4849c(str);
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(c));
            C0852a c0852a = new C0852a(str, c0869a);
            if (c0852a.m4826a(bufferedOutputStream)) {
                bufferedOutputStream.write(c0869a.f2879a);
                bufferedOutputStream.close();
                m4836a(str, c0852a);
            } else {
                bufferedOutputStream.close();
                C0894t.m4949b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                C0894t.m4949b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m4848b(String str) {
        boolean delete = m4849c(str).delete();
        m4844e(str);
        if (!delete) {
            C0894t.m4949b("Could not delete cache entry for key=%s, filename=%s", str, m4841d(str));
        }
    }

    public File m4849c(String str) {
        return new File(this.f2855c, m4841d(str));
    }
}
