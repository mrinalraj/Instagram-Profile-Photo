package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p009e.C0313d;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
    static final boolean f1095a = Log.isLoggable("MediaBrowserCompat", 3);

    private static class CustomActionResultReceiver extends C0313d {
        private final String f1085d;
        private final Bundle f1086e;
        private final C0437a f1087f;

        protected void mo298a(int i, Bundle bundle) {
            if (this.f1087f != null) {
                switch (i) {
                    case -1:
                        this.f1087f.m2041c(this.f1085d, this.f1086e, bundle);
                        return;
                    case 0:
                        this.f1087f.m2040b(this.f1085d, this.f1086e, bundle);
                        return;
                    case 1:
                        this.f1087f.m2039a(this.f1085d, this.f1086e, bundle);
                        return;
                    default:
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f1086e + ", resultData=" + bundle + ")");
                        return;
                }
            }
        }
    }

    private static class ItemReceiver extends C0313d {
        private final String f1088d;
        private final C0438b f1089e;

        protected void mo298a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
                Parcelable parcelable = bundle.getParcelable("media_item");
                if (parcelable == null || (parcelable instanceof MediaItem)) {
                    this.f1089e.m2042a((MediaItem) parcelable);
                    return;
                } else {
                    this.f1089e.m2043a(this.f1088d);
                    return;
                }
            }
            this.f1089e.m2043a(this.f1088d);
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C04361();
        private final int f1090a;
        private final MediaDescriptionCompat f1091b;

        static class C04361 implements Creator<MediaItem> {
            C04361() {
            }

            public MediaItem m2036a(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public MediaItem[] m2037a(int i) {
                return new MediaItem[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2036a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2037a(i);
            }
        }

        MediaItem(Parcel parcel) {
            this.f1090a = parcel.readInt();
            this.f1091b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.f1090a);
            stringBuilder.append(", mDescription=").append(this.f1091b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1090a);
            this.f1091b.writeToParcel(parcel, i);
        }
    }

    private static class SearchResultReceiver extends C0313d {
        private final String f1092d;
        private final Bundle f1093e;
        private final C0439c f1094f;

        protected void mo298a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("search_results")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
                List list = null;
                if (parcelableArray != null) {
                    List arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaItem) parcelable);
                    }
                    list = arrayList;
                }
                this.f1094f.m2045a(this.f1092d, this.f1093e, list);
                return;
            }
            this.f1094f.m2044a(this.f1092d, this.f1093e);
        }
    }

    public static abstract class C0437a {
        public void m2039a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void m2040b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void m2041c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class C0438b {
        public void m2042a(MediaItem mediaItem) {
        }

        public void m2043a(String str) {
        }
    }

    public static abstract class C0439c {
        public void m2044a(String str, Bundle bundle) {
        }

        public void m2045a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }
}
