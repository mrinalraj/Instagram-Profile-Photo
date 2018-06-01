package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class C0470c {

    public interface C0454a {
        void mo311a();

        void mo312a(int i, int i2, int i3, int i4, int i5);

        void mo313a(Bundle bundle);

        void mo314a(CharSequence charSequence);

        void mo315a(Object obj);

        void mo316a(String str, Bundle bundle);

        void mo317a(List<?> list);

        void mo318b(Object obj);
    }

    static class C0468b<T extends C0454a> extends Callback {
        protected final T f1167a;

        public C0468b(T t) {
            this.f1167a = t;
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.f1167a.mo312a(playbackInfo.getPlaybackType(), C0469c.m2277b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }

        public void onExtrasChanged(Bundle bundle) {
            this.f1167a.mo313a(bundle);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f1167a.mo318b(mediaMetadata);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f1167a.mo315a((Object) playbackState);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.f1167a.mo317a((List) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f1167a.mo314a(charSequence);
        }

        public void onSessionDestroyed() {
            this.f1167a.mo311a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f1167a.mo316a(str, bundle);
        }
    }

    public static class C0469c {
        private static int m2275a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }

        public static AudioAttributes m2276a(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        public static int m2277b(Object obj) {
            return C0469c.m2275a(C0469c.m2276a(obj));
        }
    }

    public static Object m2278a(C0454a c0454a) {
        return new C0468b(c0454a);
    }
}
