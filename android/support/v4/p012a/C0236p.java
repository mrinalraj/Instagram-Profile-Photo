package android.support.v4.p012a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class C0236p implements Parcelable {
    public static final Creator<C0236p> CREATOR = new C02351();
    C0238q[] f751a;
    int[] f752b;
    C0201d[] f753c;
    int f754d = -1;
    int f755e;

    static class C02351 implements Creator<C0236p> {
        C02351() {
        }

        public C0236p m1240a(Parcel parcel) {
            return new C0236p(parcel);
        }

        public C0236p[] m1241a(int i) {
            return new C0236p[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1240a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1241a(i);
        }
    }

    public C0236p(Parcel parcel) {
        this.f751a = (C0238q[]) parcel.createTypedArray(C0238q.CREATOR);
        this.f752b = parcel.createIntArray();
        this.f753c = (C0201d[]) parcel.createTypedArray(C0201d.CREATOR);
        this.f754d = parcel.readInt();
        this.f755e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f751a, i);
        parcel.writeIntArray(this.f752b);
        parcel.writeTypedArray(this.f753c, i);
        parcel.writeInt(this.f754d);
        parcel.writeInt(this.f755e);
    }
}
