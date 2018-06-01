package android.support.p007c;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class C0055d {

    static class C0054a {
        long f141a;
        long f142b;

        C0054a() {
        }
    }

    static long m152a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = C0055d.m153a(randomAccessFile, C0055d.m154a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    static long m153a(RandomAccessFile randomAccessFile, C0054a c0054a) {
        CRC32 crc32 = new CRC32();
        long j = c0054a.f142b;
        randomAccessFile.seek(c0054a.f141a);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }

    static C0054a m154a(RandomAccessFile randomAccessFile) {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C0054a c0054a = new C0054a();
                c0054a.f142b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                c0054a.f141a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return c0054a;
            }
            j2--;
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
