package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.C0474e.C0473a;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C04621();
    final int f1153a;
    final long f1154b;
    final long f1155c;
    final float f1156d;
    final long f1157e;
    final int f1158f;
    final CharSequence f1159g;
    final long f1160h;
    List<CustomAction> f1161i;
    final long f1162j;
    final Bundle f1163k;
    private Object f1164l;

    static class C04621 implements Creator<PlaybackStateCompat> {
        C04621() {
        }

        public PlaybackStateCompat m2158a(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public PlaybackStateCompat[] m2159a(int i) {
            return new PlaybackStateCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m2158a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m2159a(i);
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C04631();
        private final String f1148a;
        private final CharSequence f1149b;
        private final int f1150c;
        private final Bundle f1151d;
        private Object f1152e;

        static class C04631 implements Creator<CustomAction> {
            C04631() {
            }

            public CustomAction m2160a(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public CustomAction[] m2161a(int i) {
                return new CustomAction[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2160a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2161a(i);
            }
        }

        CustomAction(Parcel parcel) {
            this.f1148a = parcel.readString();
            this.f1149b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f1150c = parcel.readInt();
            this.f1151d = parcel.readBundle();
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f1148a = str;
            this.f1149b = charSequence;
            this.f1150c = i;
            this.f1151d = bundle;
        }

        public static CustomAction m2162a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0473a.m2281a(obj), C0473a.m2282b(obj), C0473a.m2283c(obj), C0473a.m2284d(obj));
            customAction.f1152e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f1149b + ", mIcon=" + this.f1150c + ", mExtras=" + this.f1151d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1148a);
            TextUtils.writeToParcel(this.f1149b, parcel, i);
            parcel.writeInt(this.f1150c);
            parcel.writeBundle(this.f1151d);
        }
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f1153a = i;
        this.f1154b = j;
        this.f1155c = j2;
        this.f1156d = f;
        this.f1157e = j3;
        this.f1158f = i2;
        this.f1159g = charSequence;
        this.f1160h = j4;
        this.f1161i = new ArrayList(list);
        this.f1162j = j5;
        this.f1163k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f1153a = parcel.readInt();
        this.f1154b = parcel.readLong();
        this.f1156d = parcel.readFloat();
        this.f1160h = parcel.readLong();
        this.f1155c = parcel.readLong();
        this.f1157e = parcel.readLong();
        this.f1159g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1161i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f1162j = parcel.readLong();
        this.f1163k = parcel.readBundle();
        this.f1158f = parcel.readInt();
    }

    public static PlaybackStateCompat m2163a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h = C0474e.m2292h(obj);
        List list = null;
        if (h != null) {
            list = new ArrayList(h.size());
            for (Object a : h) {
                list.add(CustomAction.m2162a(a));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0474e.m2285a(obj), C0474e.m2286b(obj), C0474e.m2287c(obj), C0474e.m2288d(obj), C0474e.m2289e(obj), 0, C0474e.m2290f(obj), C0474e.m2291g(obj), list, C0474e.m2293i(obj), VERSION.SDK_INT >= 22 ? C0475f.m2294a(obj) : null);
        playbackStateCompat.f1164l = obj;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.f1153a);
        stringBuilder.append(", position=").append(this.f1154b);
        stringBuilder.append(", buffered position=").append(this.f1155c);
        stringBuilder.append(", speed=").append(this.f1156d);
        stringBuilder.append(", updated=").append(this.f1160h);
        stringBuilder.append(", actions=").append(this.f1157e);
        stringBuilder.append(", error code=").append(this.f1158f);
        stringBuilder.append(", error message=").append(this.f1159g);
        stringBuilder.append(", custom actions=").append(this.f1161i);
        stringBuilder.append(", active item id=").append(this.f1162j);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1153a);
        parcel.writeLong(this.f1154b);
        parcel.writeFloat(this.f1156d);
        parcel.writeLong(this.f1160h);
        parcel.writeLong(this.f1155c);
        parcel.writeLong(this.f1157e);
        TextUtils.writeToParcel(this.f1159g, parcel, i);
        parcel.writeTypedList(this.f1161i);
        parcel.writeLong(this.f1162j);
        parcel.writeBundle(this.f1163k);
        parcel.writeInt(this.f1158f);
    }
}
