package android.support.v4.p009e;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
public final class C0309b {

    static class C0308a<T> implements ClassLoaderCreator<T> {
        private final C0077c<T> f901a;

        C0308a(C0077c<T> c0077c) {
            this.f901a = c0077c;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f901a.mo35b(parcel, null);
        }

        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f901a.mo35b(parcel, classLoader);
        }

        public T[] newArray(int i) {
            return this.f901a.mo36b(i);
        }
    }

    @Deprecated
    public static <T> Creator<T> m1523a(C0077c<T> c0077c) {
        return new C0308a(c0077c);
    }
}
