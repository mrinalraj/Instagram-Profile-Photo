package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.C0445a.C0444a;
import android.support.v4.media.C0447b.C0446a;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C04401();
    private final String f1104a;
    private final CharSequence f1105b;
    private final CharSequence f1106c;
    private final CharSequence f1107d;
    private final Bitmap f1108e;
    private final Uri f1109f;
    private final Bundle f1110g;
    private final Uri f1111h;
    private Object f1112i;

    static class C04401 implements Creator<MediaDescriptionCompat> {
        C04401() {
        }

        public MediaDescriptionCompat m2046a(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.m2057a(C0445a.m2073a(parcel));
        }

        public MediaDescriptionCompat[] m2047a(int i) {
            return new MediaDescriptionCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m2046a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m2047a(i);
        }
    }

    public static final class C0441a {
        private String f1096a;
        private CharSequence f1097b;
        private CharSequence f1098c;
        private CharSequence f1099d;
        private Bitmap f1100e;
        private Uri f1101f;
        private Bundle f1102g;
        private Uri f1103h;

        public C0441a m2048a(Bitmap bitmap) {
            this.f1100e = bitmap;
            return this;
        }

        public C0441a m2049a(Uri uri) {
            this.f1101f = uri;
            return this;
        }

        public C0441a m2050a(Bundle bundle) {
            this.f1102g = bundle;
            return this;
        }

        public C0441a m2051a(CharSequence charSequence) {
            this.f1097b = charSequence;
            return this;
        }

        public C0441a m2052a(String str) {
            this.f1096a = str;
            return this;
        }

        public MediaDescriptionCompat m2053a() {
            return new MediaDescriptionCompat(this.f1096a, this.f1097b, this.f1098c, this.f1099d, this.f1100e, this.f1101f, this.f1102g, this.f1103h);
        }

        public C0441a m2054b(Uri uri) {
            this.f1103h = uri;
            return this;
        }

        public C0441a m2055b(CharSequence charSequence) {
            this.f1098c = charSequence;
            return this;
        }

        public C0441a m2056c(CharSequence charSequence) {
            this.f1099d = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f1104a = parcel.readString();
        this.f1105b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1106c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1107d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1108e = (Bitmap) parcel.readParcelable(null);
        this.f1109f = (Uri) parcel.readParcelable(null);
        this.f1110g = parcel.readBundle();
        this.f1111h = (Uri) parcel.readParcelable(null);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f1104a = str;
        this.f1105b = charSequence;
        this.f1106c = charSequence2;
        this.f1107d = charSequence3;
        this.f1108e = bitmap;
        this.f1109f = uri;
        this.f1110g = bundle;
        this.f1111h = uri2;
    }

    public static MediaDescriptionCompat m2057a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Bundle bundle;
        MediaDescriptionCompat a;
        C0441a c0441a = new C0441a();
        c0441a.m2052a(C0445a.m2074a(obj));
        c0441a.m2051a(C0445a.m2076b(obj));
        c0441a.m2055b(C0445a.m2077c(obj));
        c0441a.m2056c(C0445a.m2078d(obj));
        c0441a.m2048a(C0445a.m2079e(obj));
        c0441a.m2049a(C0445a.m2080f(obj));
        Bundle g = C0445a.m2081g(obj);
        Uri uri = g == null ? null : (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        if (uri != null) {
            if (g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && g.size() == 2) {
                bundle = null;
                c0441a.m2050a(bundle);
                if (uri != null) {
                    c0441a.m2054b(uri);
                } else if (VERSION.SDK_INT >= 23) {
                    c0441a.m2054b(C0447b.m2083h(obj));
                }
                a = c0441a.m2053a();
                a.f1112i = obj;
                return a;
            }
            g.remove("android.support.v4.media.description.MEDIA_URI");
            g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = g;
        c0441a.m2050a(bundle);
        if (uri != null) {
            c0441a.m2054b(uri);
        } else if (VERSION.SDK_INT >= 23) {
            c0441a.m2054b(C0447b.m2083h(obj));
        }
        a = c0441a.m2053a();
        a.f1112i = obj;
        return a;
    }

    public Object m2058a() {
        if (this.f1112i != null || VERSION.SDK_INT < 21) {
            return this.f1112i;
        }
        Object a = C0444a.m2064a();
        C0444a.m2070a(a, this.f1104a);
        C0444a.m2069a(a, this.f1105b);
        C0444a.m2071b(a, this.f1106c);
        C0444a.m2072c(a, this.f1107d);
        C0444a.m2066a(a, this.f1108e);
        C0444a.m2067a(a, this.f1109f);
        Bundle bundle = this.f1110g;
        if (VERSION.SDK_INT < 23 && this.f1111h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f1111h);
        }
        C0444a.m2068a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            C0446a.m2082b(a, this.f1111h);
        }
        this.f1112i = C0444a.m2065a(a);
        return this.f1112i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f1105b + ", " + this.f1106c + ", " + this.f1107d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f1104a);
            TextUtils.writeToParcel(this.f1105b, parcel, i);
            TextUtils.writeToParcel(this.f1106c, parcel, i);
            TextUtils.writeToParcel(this.f1107d, parcel, i);
            parcel.writeParcelable(this.f1108e, i);
            parcel.writeParcelable(this.f1109f, i);
            parcel.writeBundle(this.f1110g);
            parcel.writeParcelable(this.f1111h, i);
            return;
        }
        C0445a.m2075a(m2058a(), parcel, i);
    }
}
