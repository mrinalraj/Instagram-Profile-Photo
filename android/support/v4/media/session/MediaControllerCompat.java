package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.C0449a.C0450a;
import android.support.v4.media.session.C0465b.C0467a;
import android.support.v4.media.session.C0470c.C0454a;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.p012a.C0205g;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    static class MediaControllerImplApi21 {
        private final List<C0456a> f1123a;
        private C0465b f1124b;
        private HashMap<C0456a, C0452a> f1125c;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> f1121a;

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f1121a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.f1124b = C0467a.m2274a(C0205g.m903a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.m2117a();
                }
            }
        }

        private static class C0452a extends C0451c {
            C0452a(C0456a c0456a) {
                super(c0456a);
            }

            public void mo299a() {
                throw new AssertionError();
            }

            public void mo301a(Bundle bundle) {
                throw new AssertionError();
            }

            public void mo302a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public void mo303a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            public void mo305a(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void mo307a(List<QueueItem> list) {
                throw new AssertionError();
            }
        }

        private void m2117a() {
            if (this.f1124b != null) {
                synchronized (this.f1123a) {
                    for (C0456a c0456a : this.f1123a) {
                        C0449a c0452a = new C0452a(c0456a);
                        this.f1125c.put(c0456a, c0452a);
                        c0456a.f1130b = true;
                        try {
                            this.f1124b.mo327a(c0452a);
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.f1123a.clear();
                }
            }
        }
    }

    public static abstract class C0456a implements DeathRecipient {
        C0453a f1129a;
        boolean f1130b;
        private final Object f1131c;

        private static class C0451c extends C0450a {
            private final WeakReference<C0456a> f1122a;

            C0451c(C0456a c0456a) {
                this.f1122a = new WeakReference(c0456a);
            }

            public void mo299a() {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(8, null, null);
                }
            }

            public void mo300a(int i) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(9, Integer.valueOf(i), null);
                }
            }

            public void mo301a(Bundle bundle) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(7, bundle, null);
                }
            }

            public void mo302a(MediaMetadataCompat mediaMetadataCompat) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(3, mediaMetadataCompat, null);
                }
            }

            public void mo303a(ParcelableVolumeInfo parcelableVolumeInfo) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(4, parcelableVolumeInfo != null ? new C0457b(parcelableVolumeInfo.f1143a, parcelableVolumeInfo.f1144b, parcelableVolumeInfo.f1145c, parcelableVolumeInfo.f1146d, parcelableVolumeInfo.f1147e) : null, null);
                }
            }

            public void mo304a(PlaybackStateCompat playbackStateCompat) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(2, playbackStateCompat, null);
                }
            }

            public void mo305a(CharSequence charSequence) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(6, charSequence, null);
                }
            }

            public void mo306a(String str, Bundle bundle) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(1, str, bundle);
                }
            }

            public void mo307a(List<QueueItem> list) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(5, list, null);
                }
            }

            public void mo308a(boolean z) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(10, Boolean.valueOf(z), null);
                }
            }

            public void mo309b(int i) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(12, Integer.valueOf(i), null);
                }
            }

            public void mo310b(boolean z) {
                C0456a c0456a = (C0456a) this.f1122a.get();
                if (c0456a != null) {
                    c0456a.m2137a(11, Boolean.valueOf(z), null);
                }
            }
        }

        private class C0453a extends Handler {
            boolean f1126a;
            final /* synthetic */ C0456a f1127b;

            public void handleMessage(Message message) {
                if (this.f1126a) {
                    switch (message.what) {
                        case 1:
                            this.f1127b.m2143a((String) message.obj, message.getData());
                            return;
                        case 2:
                            this.f1127b.m2141a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.f1127b.m2139a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.f1127b.m2140a((C0457b) message.obj);
                            return;
                        case 5:
                            this.f1127b.m2144a((List) message.obj);
                            return;
                        case 6:
                            this.f1127b.m2142a((CharSequence) message.obj);
                            return;
                        case 7:
                            this.f1127b.m2138a((Bundle) message.obj);
                            return;
                        case 8:
                            this.f1127b.m2135a();
                            return;
                        case 9:
                            this.f1127b.m2136a(((Integer) message.obj).intValue());
                            return;
                        case 10:
                            this.f1127b.m2147b(((Boolean) message.obj).booleanValue());
                            return;
                        case 11:
                            this.f1127b.m2145a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.f1127b.m2146b(((Integer) message.obj).intValue());
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private static class C0455b implements C0454a {
            private final WeakReference<C0456a> f1128a;

            C0455b(C0456a c0456a) {
                this.f1128a = new WeakReference(c0456a);
            }

            public void mo311a() {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a != null) {
                    c0456a.m2135a();
                }
            }

            public void mo312a(int i, int i2, int i3, int i4, int i5) {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a != null) {
                    c0456a.m2140a(new C0457b(i, i2, i3, i4, i5));
                }
            }

            public void mo313a(Bundle bundle) {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a != null) {
                    c0456a.m2138a(bundle);
                }
            }

            public void mo314a(CharSequence charSequence) {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a != null) {
                    c0456a.m2142a(charSequence);
                }
            }

            public void mo315a(Object obj) {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a != null && !c0456a.f1130b) {
                    c0456a.m2141a(PlaybackStateCompat.m2163a(obj));
                }
            }

            public void mo316a(String str, Bundle bundle) {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a == null) {
                    return;
                }
                if (!c0456a.f1130b || VERSION.SDK_INT >= 23) {
                    c0456a.m2143a(str, bundle);
                }
            }

            public void mo317a(List<?> list) {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a != null) {
                    c0456a.m2144a(QueueItem.m2151a((List) list));
                }
            }

            public void mo318b(Object obj) {
                C0456a c0456a = (C0456a) this.f1128a.get();
                if (c0456a != null) {
                    c0456a.m2139a(MediaMetadataCompat.m2061a(obj));
                }
            }
        }

        public C0456a() {
            if (VERSION.SDK_INT >= 21) {
                this.f1131c = C0470c.m2278a(new C0455b(this));
            } else {
                this.f1131c = new C0451c(this);
            }
        }

        public void m2135a() {
        }

        public void m2136a(int i) {
        }

        void m2137a(int i, Object obj, Bundle bundle) {
            if (this.f1129a != null) {
                Message obtainMessage = this.f1129a.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void m2138a(Bundle bundle) {
        }

        public void m2139a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void m2140a(C0457b c0457b) {
        }

        public void m2141a(PlaybackStateCompat playbackStateCompat) {
        }

        public void m2142a(CharSequence charSequence) {
        }

        public void m2143a(String str, Bundle bundle) {
        }

        public void m2144a(List<QueueItem> list) {
        }

        public void m2145a(boolean z) {
        }

        public void m2146b(int i) {
        }

        @Deprecated
        public void m2147b(boolean z) {
        }
    }

    public static final class C0457b {
        private final int f1132a;
        private final int f1133b;
        private final int f1134c;
        private final int f1135d;
        private final int f1136e;

        C0457b(int i, int i2, int i3, int i4, int i5) {
            this.f1132a = i;
            this.f1133b = i2;
            this.f1134c = i3;
            this.f1135d = i4;
            this.f1136e = i5;
        }
    }
}
