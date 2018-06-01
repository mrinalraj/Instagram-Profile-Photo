package com.p029b.p030a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.p029b.p030a.C0908y.C0959a;
import com.p029b.p030a.C0951t.C0947d;

class C0936o extends C0922g {
    private static final String[] f3078b = new String[]{"orientation"};

    enum C0935a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        
        final int f3075d;
        final int f3076e;
        final int f3077f;

        private C0935a(int i, int i2, int i3) {
            this.f3075d = i;
            this.f3076e = i2;
            this.f3077f = i3;
        }
    }

    C0936o(Context context) {
        super(context);
    }

    static int m5119a(ContentResolver contentResolver, Uri uri) {
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = contentResolver.query(uri, f3078b, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (RuntimeException e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    static C0935a m5120a(int i, int i2) {
        return (i > C0935a.MICRO.f3076e || i2 > C0935a.MICRO.f3077f) ? (i > C0935a.MINI.f3076e || i2 > C0935a.MINI.f3077f) ? C0935a.FULL : C0935a.MINI : C0935a.MICRO;
    }

    public C0959a mo814a(C0957w c0957w, int i) {
        ContentResolver contentResolver = this.a.getContentResolver();
        int a = C0936o.m5119a(contentResolver, c0957w.f3160d);
        String type = contentResolver.getType(c0957w.f3160d);
        Object obj = (type == null || !type.startsWith("video/")) ? null : 1;
        if (c0957w.m5169d()) {
            C0935a a2 = C0936o.m5120a(c0957w.f3164h, c0957w.f3165i);
            if (obj == null && a2 == C0935a.FULL) {
                return new C0959a(null, m5075b(c0957w), C0947d.DISK, a);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(c0957w.f3160d);
            Options c = C0908y.m5023c(c0957w);
            c.inJustDecodeBounds = true;
            C0908y.m5020a(c0957w.f3164h, c0957w.f3165i, a2.f3076e, a2.f3077f, c, c0957w);
            if (obj != null) {
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, a2 == C0935a.FULL ? 1 : a2.f3075d, c);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, a2.f3075d, c);
            }
            if (thumbnail != null) {
                return new C0959a(thumbnail, null, C0947d.DISK, a);
            }
        }
        return new C0959a(null, m5075b(c0957w), C0947d.DISK, a);
    }

    public boolean mo815a(C0957w c0957w) {
        Uri uri = c0957w.f3160d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
