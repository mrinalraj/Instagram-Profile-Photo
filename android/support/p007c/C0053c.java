package android.support.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class C0053c {

    private static class C0052a extends File {
        public long f140a = -1;

        public C0052a(File file, String str) {
            super(file, str);
        }
    }

    private static long m141a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static SharedPreferences m142a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static List<C0052a> m143a(Context context, File file, File file2, String str) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = file.getName() + ".classes";
        SharedPreferences a = C0053c.m142a(context);
        int i = a.getInt(str + "dex.number", 1);
        List<C0052a> arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            File c0052a = new C0052a(file2, str2 + i2 + ".zip");
            if (c0052a.isFile()) {
                c0052a.f140a = C0053c.m151b(c0052a);
                long j = a.getLong(str + "dex.crc." + i2, -1);
                long j2 = a.getLong(str + "dex.time." + i2, -1);
                long lastModified = c0052a.lastModified();
                if (j2 == lastModified && j == c0052a.f140a) {
                    arrayList.add(c0052a);
                    i2++;
                } else {
                    throw new IOException("Invalid extracted dex: " + c0052a + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + c0052a.f140a);
                }
            }
            throw new IOException("Missing extracted secondary dex file '" + c0052a.getPath() + "'");
        }
        return arrayList;
    }

    static List<? extends File> m144a(Context context, File file, File file2, String str, boolean z) {
        Throwable th;
        List a;
        Log.i("MultiDex", "MultiDexExtractor.load(" + file.getPath() + ", " + z + ", " + str + ")");
        long b = C0053c.m151b(file);
        File file3 = new File(file2, "MultiDex.lock");
        Closeable randomAccessFile = new RandomAccessFile(file3, "rw");
        Closeable closeable = null;
        FileLock fileLock = null;
        try {
            FileLock lock;
            List<? extends File> a2;
            Closeable channel = randomAccessFile.getChannel();
            try {
                IOException iOException;
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                lock = channel.lock();
                if (lock != null) {
                    try {
                        lock.release();
                        iOException = null;
                    } catch (IOException e) {
                        iOException = e;
                        Log.e("MultiDex", "Failed to release lock on " + file3.getPath());
                    }
                } else {
                    iOException = null;
                }
                if (channel != null) {
                    C0053c.m147a(channel);
                }
                C0053c.m147a(randomAccessFile);
                if (iOException != null) {
                    throw iOException;
                }
                Log.i("MultiDex", "load found " + a2.size() + " secondary dex files");
                return a2;
            } catch (Throwable th2) {
                th = th2;
                closeable = channel;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        Log.e("MultiDex", "Failed to release lock on " + file3.getPath());
                    }
                }
                if (closeable != null) {
                    C0053c.m147a(closeable);
                }
                C0053c.m147a(randomAccessFile);
                throw th;
            }
            try {
                Log.i("MultiDex", file3.getPath() + " locked");
                if (z || C0053c.m150a(context, file, b, str)) {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                    a = C0053c.m145a(file, file2);
                    C0053c.m146a(context, str, C0053c.m141a(file), b, a);
                } else {
                    a2 = C0053c.m143a(context, file, file2, str);
                }
            } catch (Throwable th3) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", th3);
                a = C0053c.m145a(file, file2);
                C0053c.m146a(context, str, C0053c.m141a(file), b, a);
            } catch (Throwable th4) {
                th3 = th4;
                fileLock = lock;
                closeable = channel;
                if (fileLock != null) {
                    fileLock.release();
                }
                if (closeable != null) {
                    C0053c.m147a(closeable);
                }
                C0053c.m147a(randomAccessFile);
                throw th3;
            }
        } catch (Throwable th5) {
            th3 = th5;
            if (fileLock != null) {
                fileLock.release();
            }
            if (closeable != null) {
                C0053c.m147a(closeable);
            }
            C0053c.m147a(randomAccessFile);
            throw th3;
        }
    }

    private static List<C0052a> m145a(File file, File file2) {
        String str = file.getName() + ".classes";
        C0053c.m148a(file2, str);
        List<C0052a> arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
        int i = 2;
        while (entry != null) {
            File c0052a = new C0052a(file2, str + i + ".zip");
            arrayList.add(c0052a);
            Log.i("MultiDex", "Extraction is needed for file " + c0052a);
            Object obj = null;
            int i2 = 0;
            while (i2 < 3 && obj == null) {
                int i3 = i2 + 1;
                C0053c.m149a(zipFile, entry, c0052a, str);
                try {
                    c0052a.f140a = C0053c.m151b(c0052a);
                    obj = 1;
                } catch (Throwable e) {
                    Log.w("MultiDex", "Failed to read crc from " + c0052a.getAbsolutePath(), e);
                    obj = null;
                } catch (Throwable th) {
                    try {
                        zipFile.close();
                    } catch (Throwable e2) {
                        Log.w("MultiDex", "Failed to close resource", e2);
                    }
                }
                Log.i("MultiDex", "Extraction " + (obj != null ? "succeeded" : "failed") + " - length " + c0052a.getAbsolutePath() + ": " + c0052a.length() + " - crc: " + c0052a.f140a);
                if (obj == null) {
                    c0052a.delete();
                    if (c0052a.exists()) {
                        Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + c0052a.getPath() + "'");
                        i2 = i3;
                    }
                }
                i2 = i3;
            }
            if (obj == null) {
                throw new IOException("Could not create zip file " + c0052a.getAbsolutePath() + " for secondary dex (" + i + ")");
            }
            int i4 = i + 1;
            entry = zipFile.getEntry("classes" + i4 + ".dex");
            i = i4;
        }
        try {
            zipFile.close();
        } catch (Throwable e3) {
            Log.w("MultiDex", "Failed to close resource", e3);
        }
        return arrayList;
    }

    private static void m146a(Context context, String str, long j, long j2, List<C0052a> list) {
        Editor edit = C0053c.m142a(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (C0052a c0052a : list) {
            edit.putLong(str + "dex.crc." + i, c0052a.f140a);
            edit.putLong(str + "dex.time." + i, c0052a.lastModified());
            i++;
        }
        edit.commit();
    }

    private static void m147a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    private static void m148a(File file, final String str) {
        File[] listFiles = file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                String name = file.getName();
                return (name.startsWith(str) || name.equals("MultiDex.lock")) ? false : true;
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (file2.delete()) {
                Log.i("MultiDex", "Deleted old file " + file2.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
            }
        }
    }

    private static void m149a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Closeable inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    C0053c.m147a(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            C0053c.m147a(inputStream);
            createTempFile.delete();
        }
    }

    private static boolean m150a(Context context, File file, long j, String str) {
        SharedPreferences a = C0053c.m142a(context);
        return (a.getLong(new StringBuilder().append(str).append("timestamp").toString(), -1) == C0053c.m141a(file) && a.getLong(str + "crc", -1) == j) ? false : true;
    }

    private static long m151b(File file) {
        long a = C0055d.m152a(file);
        return a == -1 ? a - 1 : a;
    }
}
