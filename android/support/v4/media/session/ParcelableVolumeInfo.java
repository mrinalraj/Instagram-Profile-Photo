package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C04611();
    public int f1143a;
    public int f1144b;
    public int f1145c;
    public int f1146d;
    public int f1147e;

    static class C04611 implements Creator<ParcelableVolumeInfo> {
        C04611() {
        }

        public ParcelableVolumeInfo m2156a(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public ParcelableVolumeInfo[] m2157a(int i) {
            return new ParcelableVolumeInfo[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m2156a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m2157a(i);
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f1143a = parcel.readInt();
        this.f1145c = parcel.readInt();
        this.f1146d = parcel.readInt();
        this.f1147e = parcel.readInt();
        this.f1144b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1143a);
        parcel.writeInt(this.f1145c);
        parcel.writeInt(this.f1146d);
        parcel.writeInt(this.f1147e);
        parcel.writeInt(this.f1144b);
    }
}
