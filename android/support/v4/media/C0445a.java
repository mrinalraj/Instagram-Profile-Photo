package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

class C0445a {

    static class C0444a {
        public static Object m2064a() {
            return new Builder();
        }

        public static Object m2065a(Object obj) {
            return ((Builder) obj).build();
        }

        public static void m2066a(Object obj, Bitmap bitmap) {
            ((Builder) obj).setIconBitmap(bitmap);
        }

        public static void m2067a(Object obj, Uri uri) {
            ((Builder) obj).setIconUri(uri);
        }

        public static void m2068a(Object obj, Bundle bundle) {
            ((Builder) obj).setExtras(bundle);
        }

        public static void m2069a(Object obj, CharSequence charSequence) {
            ((Builder) obj).setTitle(charSequence);
        }

        public static void m2070a(Object obj, String str) {
            ((Builder) obj).setMediaId(str);
        }

        public static void m2071b(Object obj, CharSequence charSequence) {
            ((Builder) obj).setSubtitle(charSequence);
        }

        public static void m2072c(Object obj, CharSequence charSequence) {
            ((Builder) obj).setDescription(charSequence);
        }
    }

    public static Object m2073a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    public static String m2074a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static void m2075a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static CharSequence m2076b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m2077c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m2078d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m2079e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m2080f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m2081g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }
}
