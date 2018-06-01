package com.p026a.p027a.p028a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class C0850b {
    protected static final Comparator<byte[]> f2839a = new C08491();
    private List<byte[]> f2840b = new LinkedList();
    private List<byte[]> f2841c = new ArrayList(64);
    private int f2842d = 0;
    private final int f2843e;

    static class C08491 implements Comparator<byte[]> {
        C08491() {
        }

        public int m4820a(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4820a((byte[]) obj, (byte[]) obj2);
        }
    }

    public C0850b(int i) {
        this.f2843e = i;
    }

    private synchronized void m4821a() {
        while (this.f2842d > this.f2843e) {
            byte[] bArr = (byte[]) this.f2840b.remove(0);
            this.f2841c.remove(bArr);
            this.f2842d -= bArr.length;
        }
    }

    public synchronized void m4822a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f2843e) {
                this.f2840b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f2841c, bArr, f2839a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f2841c.add(binarySearch, bArr);
                this.f2842d += bArr.length;
                m4821a();
            }
        }
    }

    public synchronized byte[] m4823a(int i) {
        byte[] bArr;
        for (int i2 = 0; i2 < this.f2841c.size(); i2++) {
            bArr = (byte[]) this.f2841c.get(i2);
            if (bArr.length >= i) {
                this.f2842d -= bArr.length;
                this.f2841c.remove(i2);
                this.f2840b.remove(bArr);
                break;
            }
        }
        bArr = new byte[i];
        return bArr;
    }
}
