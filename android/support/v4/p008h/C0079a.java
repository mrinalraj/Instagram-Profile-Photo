package android.support.v4.p008h;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class C0079a implements Parcelable {
    public static final Creator<C0079a> CREATOR = new C03532();
    public static final C0079a f236d = new C03521();
    private final Parcelable f237a;

    static class C03521 extends C0079a {
        C03521() {
            super();
        }
    }

    static class C03532 implements ClassLoaderCreator<C0079a> {
        C03532() {
        }

        public C0079a m1678a(Parcel parcel) {
            return m1679a(parcel, null);
        }

        public C0079a m1679a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return C0079a.f236d;
            }
            throw new IllegalStateException("superState must be null");
        }

        public C0079a[] m1680a(int i) {
            return new C0079a[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1678a(parcel);
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return m1679a(parcel, classLoader);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1680a(i);
        }
    }

    private C0079a() {
        this.f237a = null;
    }

    protected C0079a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = f236d;
        }
        this.f237a = readParcelable;
    }

    protected C0079a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == f236d) {
            parcelable = null;
        }
        this.f237a = parcelable;
    }

    public final Parcelable m320a() {
        return this.f237a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f237a, i);
    }
}
