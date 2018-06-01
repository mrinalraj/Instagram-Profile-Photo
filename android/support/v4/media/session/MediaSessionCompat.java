package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.C0472d.C0471a;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new C04581();
        private final MediaDescriptionCompat f1137a;
        private final long f1138b;
        private Object f1139c;

        static class C04581 implements Creator<QueueItem> {
            C04581() {
            }

            public QueueItem m2148a(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] m2149a(int i) {
                return new QueueItem[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2148a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2149a(i);
            }
        }

        QueueItem(Parcel parcel) {
            this.f1137a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f1138b = parcel.readLong();
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.f1137a = mediaDescriptionCompat;
                this.f1138b = j;
                this.f1139c = obj;
            }
        }

        public static QueueItem m2150a(Object obj) {
            return (obj == null || VERSION.SDK_INT < 21) ? null : new QueueItem(obj, MediaDescriptionCompat.m2057a(C0471a.m2279a(obj)), C0471a.m2280b(obj));
        }

        public static List<QueueItem> m2151a(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            List<QueueItem> arrayList = new ArrayList();
            for (Object a : list) {
                arrayList.add(m2150a(a));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f1137a + ", Id=" + this.f1138b + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f1137a.writeToParcel(parcel, i);
            parcel.writeLong(this.f1138b);
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new C04591();
        private ResultReceiver f1140a;

        static class C04591 implements Creator<ResultReceiverWrapper> {
            C04591() {
            }

            public ResultReceiverWrapper m2152a(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] m2153a(int i) {
                return new ResultReceiverWrapper[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2152a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2153a(i);
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f1140a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f1140a.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C04601();
        private final Object f1141a;
        private final C0465b f1142b;

        static class C04601 implements Creator<Token> {
            C04601() {
            }

            public Token m2154a(Parcel parcel) {
                return new Token(VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
            }

            public Token[] m2155a(int i) {
                return new Token[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2154a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2155a(i);
            }
        }

        Token(Object obj) {
            this(obj, null);
        }

        Token(Object obj, C0465b c0465b) {
            this.f1141a = obj;
            this.f1142b = c0465b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            return this.f1141a == null ? token.f1141a == null : token.f1141a == null ? false : this.f1141a.equals(token.f1141a);
        }

        public int hashCode() {
            return this.f1141a == null ? 0 : this.f1141a.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f1141a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f1141a);
            }
        }
    }
}
