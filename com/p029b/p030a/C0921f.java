package com.p029b.p030a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;
import java.io.InputStream;

class C0921f extends C0908y {
    private static final UriMatcher f3026a = new UriMatcher(-1);
    private final Context f3027b;

    @TargetApi(14)
    private static class C0920a {
        static InputStream m5069a(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f3026a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f3026a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f3026a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f3026a.addURI("com.android.contacts", "contacts/#", 3);
        f3026a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C0921f(Context context) {
        this.f3027b = context;
    }

    private InputStream m5070b(C0957w c0957w) {
        ContentResolver contentResolver = this.f3027b.getContentResolver();
        Uri uri = c0957w.f3160d;
        switch (f3026a.match(uri)) {
            case 1:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        return VERSION.SDK_INT < 14 ? Contacts.openContactPhotoInputStream(contentResolver, uri) : C0920a.m5069a(contentResolver, uri);
    }

    public C0959a mo814a(C0957w c0957w, int i) {
        InputStream b = m5070b(c0957w);
        return b != null ? new C0959a(b, C0947d.DISK) : null;
    }

    public boolean mo815a(C0957w c0957w) {
        Uri uri = c0957w.f3160d;
        return "content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f3026a.match(c0957w.f3160d) != -1;
    }
}
