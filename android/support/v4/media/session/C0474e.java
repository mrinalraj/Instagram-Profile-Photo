package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Bundle;
import java.util.List;

class C0474e {

    static final class C0473a {
        public static String m2281a(Object obj) {
            return ((CustomAction) obj).getAction();
        }

        public static CharSequence m2282b(Object obj) {
            return ((CustomAction) obj).getName();
        }

        public static int m2283c(Object obj) {
            return ((CustomAction) obj).getIcon();
        }

        public static Bundle m2284d(Object obj) {
            return ((CustomAction) obj).getExtras();
        }
    }

    public static int m2285a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long m2286b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long m2287c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float m2288d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long m2289e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence m2290f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long m2291g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static List<Object> m2292h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static long m2293i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
