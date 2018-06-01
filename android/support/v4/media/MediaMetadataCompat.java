package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p018g.C0332a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C04421();
    static final C0332a<String, Integer> f1113a = new C0332a();
    private static final String[] f1114c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] f1115d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] f1116e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    final Bundle f1117b;
    private Object f1118f;

    static class C04421 implements Creator<MediaMetadataCompat> {
        C04421() {
        }

        public MediaMetadataCompat m2059a(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        public MediaMetadataCompat[] m2060a(int i) {
            return new MediaMetadataCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m2059a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m2060a(i);
        }
    }

    static {
        f1113a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f1113a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f1113a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f1113a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f1113a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f1113a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f1113a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f1113a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f1113a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f1113a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f1113a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f1113a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f1113a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f1113a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f1113a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f1113a.put("android.media.metadata.ART", Integer.valueOf(2));
        f1113a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f1113a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f1113a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f1113a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f1113a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f1113a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f1113a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f1113a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f1113a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f1113a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f1113a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f1113a.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        f1113a.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        f1113a.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        f1113a.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f1117b = parcel.readBundle();
    }

    public static MediaMetadataCompat m2061a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        C0448c.m2084a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.f1118f = obj;
        return mediaMetadataCompat;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f1117b);
    }
}
