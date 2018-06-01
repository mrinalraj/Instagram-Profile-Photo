package android.support.v4.p012a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p012a.C0199c.C0196a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class C0201d implements Parcelable {
    public static final Creator<C0201d> CREATOR = new C02001();
    final int[] f582a;
    final int f583b;
    final int f584c;
    final String f585d;
    final int f586e;
    final int f587f;
    final CharSequence f588g;
    final int f589h;
    final CharSequence f590i;
    final ArrayList<String> f591j;
    final ArrayList<String> f592k;
    final boolean f593l;

    static class C02001 implements Creator<C0201d> {
        C02001() {
        }

        public C0201d m897a(Parcel parcel) {
            return new C0201d(parcel);
        }

        public C0201d[] m898a(int i) {
            return new C0201d[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m897a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m898a(i);
        }
    }

    public C0201d(Parcel parcel) {
        this.f582a = parcel.createIntArray();
        this.f583b = parcel.readInt();
        this.f584c = parcel.readInt();
        this.f585d = parcel.readString();
        this.f586e = parcel.readInt();
        this.f587f = parcel.readInt();
        this.f588g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f589h = parcel.readInt();
        this.f590i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f591j = parcel.createStringArrayList();
        this.f592k = parcel.createStringArrayList();
        this.f593l = parcel.readInt() != 0;
    }

    public C0201d(C0199c c0199c) {
        int size = c0199c.f562c.size();
        this.f582a = new int[(size * 6)];
        if (c0199c.f569j) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C0196a c0196a = (C0196a) c0199c.f562c.get(i2);
                int i3 = i + 1;
                this.f582a[i] = c0196a.f554a;
                int i4 = i3 + 1;
                this.f582a[i3] = c0196a.f555b != null ? c0196a.f555b.f645e : -1;
                int i5 = i4 + 1;
                this.f582a[i4] = c0196a.f556c;
                i3 = i5 + 1;
                this.f582a[i5] = c0196a.f557d;
                i5 = i3 + 1;
                this.f582a[i3] = c0196a.f558e;
                i = i5 + 1;
                this.f582a[i5] = c0196a.f559f;
            }
            this.f583b = c0199c.f567h;
            this.f584c = c0199c.f568i;
            this.f585d = c0199c.f571l;
            this.f586e = c0199c.f573n;
            this.f587f = c0199c.f574o;
            this.f588g = c0199c.f575p;
            this.f589h = c0199c.f576q;
            this.f590i = c0199c.f577r;
            this.f591j = c0199c.f578s;
            this.f592k = c0199c.f579t;
            this.f593l = c0199c.f580u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0199c m899a(C0233n c0233n) {
        int i = 0;
        C0199c c0199c = new C0199c(c0233n);
        int i2 = 0;
        while (i < this.f582a.length) {
            C0196a c0196a = new C0196a();
            int i3 = i + 1;
            c0196a.f554a = this.f582a[i];
            if (C0233n.f718a) {
                Log.v("FragmentManager", "Instantiate " + c0199c + " op #" + i2 + " base fragment #" + this.f582a[i3]);
            }
            int i4 = i3 + 1;
            i = this.f582a[i3];
            if (i >= 0) {
                c0196a.f555b = (C0212h) c0233n.f729f.get(i);
            } else {
                c0196a.f555b = null;
            }
            i3 = i4 + 1;
            c0196a.f556c = this.f582a[i4];
            i4 = i3 + 1;
            c0196a.f557d = this.f582a[i3];
            i3 = i4 + 1;
            c0196a.f558e = this.f582a[i4];
            i4 = i3 + 1;
            c0196a.f559f = this.f582a[i3];
            c0199c.f563d = c0196a.f556c;
            c0199c.f564e = c0196a.f557d;
            c0199c.f565f = c0196a.f558e;
            c0199c.f566g = c0196a.f559f;
            c0199c.m885a(c0196a);
            i2++;
            i = i4;
        }
        c0199c.f567h = this.f583b;
        c0199c.f568i = this.f584c;
        c0199c.f571l = this.f585d;
        c0199c.f573n = this.f586e;
        c0199c.f569j = true;
        c0199c.f574o = this.f587f;
        c0199c.f575p = this.f588g;
        c0199c.f576q = this.f589h;
        c0199c.f577r = this.f590i;
        c0199c.f578s = this.f591j;
        c0199c.f579t = this.f592k;
        c0199c.f580u = this.f593l;
        c0199c.m884a(1);
        return c0199c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeIntArray(this.f582a);
        parcel.writeInt(this.f583b);
        parcel.writeInt(this.f584c);
        parcel.writeString(this.f585d);
        parcel.writeInt(this.f586e);
        parcel.writeInt(this.f587f);
        TextUtils.writeToParcel(this.f588g, parcel, 0);
        parcel.writeInt(this.f589h);
        TextUtils.writeToParcel(this.f590i, parcel, 0);
        parcel.writeStringList(this.f591j);
        parcel.writeStringList(this.f592k);
        if (this.f593l) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}
