package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C04431();
    private final int f1119a;
    private final float f1120b;

    static class C04431 implements Creator<RatingCompat> {
        C04431() {
        }

        public RatingCompat m2062a(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public RatingCompat[] m2063a(int i) {
            return new RatingCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m2062a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m2063a(i);
        }
    }

    RatingCompat(int i, float f) {
        this.f1119a = i;
        this.f1120b = f;
    }

    public int describeContents() {
        return this.f1119a;
    }

    public String toString() {
        return "Rating:style=" + this.f1119a + " rating=" + (this.f1120b < 0.0f ? "unrated" : String.valueOf(this.f1120b));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1119a);
        parcel.writeFloat(this.f1120b);
    }
}
