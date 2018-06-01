package android.support.v4.p012a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class C0238q implements Parcelable {
    public static final Creator<C0238q> CREATOR = new C02371();
    final String f756a;
    final int f757b;
    final boolean f758c;
    final int f759d;
    final int f760e;
    final String f761f;
    final boolean f762g;
    final boolean f763h;
    final Bundle f764i;
    final boolean f765j;
    Bundle f766k;
    C0212h f767l;

    static class C02371 implements Creator<C0238q> {
        C02371() {
        }

        public C0238q m1242a(Parcel parcel) {
            return new C0238q(parcel);
        }

        public C0238q[] m1243a(int i) {
            return new C0238q[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1242a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1243a(i);
        }
    }

    public C0238q(Parcel parcel) {
        boolean z = true;
        this.f756a = parcel.readString();
        this.f757b = parcel.readInt();
        this.f758c = parcel.readInt() != 0;
        this.f759d = parcel.readInt();
        this.f760e = parcel.readInt();
        this.f761f = parcel.readString();
        this.f762g = parcel.readInt() != 0;
        this.f763h = parcel.readInt() != 0;
        this.f764i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f765j = z;
        this.f766k = parcel.readBundle();
    }

    public C0238q(C0212h c0212h) {
        this.f756a = c0212h.getClass().getName();
        this.f757b = c0212h.f645e;
        this.f758c = c0212h.f653m;
        this.f759d = c0212h.f663w;
        this.f760e = c0212h.f664x;
        this.f761f = c0212h.f665y;
        this.f762g = c0212h.f622B;
        this.f763h = c0212h.f621A;
        this.f764i = c0212h.f647g;
        this.f765j = c0212h.f666z;
    }

    public C0212h m1244a(C0214l c0214l, C0207j c0207j, C0212h c0212h, C0234o c0234o) {
        if (this.f767l == null) {
            Context g = c0214l.m1039g();
            if (this.f764i != null) {
                this.f764i.setClassLoader(g.getClassLoader());
            }
            if (c0207j != null) {
                this.f767l = c0207j.mo158a(g, this.f756a, this.f764i);
            } else {
                this.f767l = C0212h.m922a(g, this.f756a, this.f764i);
            }
            if (this.f766k != null) {
                this.f766k.setClassLoader(g.getClassLoader());
                this.f767l.f643c = this.f766k;
            }
            this.f767l.m954a(this.f757b, c0212h);
            this.f767l.f653m = this.f758c;
            this.f767l.f655o = true;
            this.f767l.f663w = this.f759d;
            this.f767l.f664x = this.f760e;
            this.f767l.f665y = this.f761f;
            this.f767l.f622B = this.f762g;
            this.f767l.f621A = this.f763h;
            this.f767l.f666z = this.f765j;
            this.f767l.f658r = c0214l.f671d;
            if (C0233n.f718a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f767l);
            }
        }
        this.f767l.f661u = c0234o;
        return this.f767l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f756a);
        parcel.writeInt(this.f757b);
        parcel.writeInt(this.f758c ? 1 : 0);
        parcel.writeInt(this.f759d);
        parcel.writeInt(this.f760e);
        parcel.writeString(this.f761f);
        parcel.writeInt(this.f762g ? 1 : 0);
        parcel.writeInt(this.f763h ? 1 : 0);
        parcel.writeBundle(this.f764i);
        if (!this.f765j) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f766k);
    }
}
