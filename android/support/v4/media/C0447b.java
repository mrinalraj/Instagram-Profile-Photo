package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.support.v4.media.C0445a.C0444a;

class C0447b extends C0445a {

    static class C0446a extends C0444a {
        public static void m2082b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri m2083h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
