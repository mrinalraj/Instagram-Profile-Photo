package android.support.p003b.p004a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.v4.p008h.p020b.C0392a;
import android.support.v4.p008h.p020b.C0393b;
import android.support.v4.p008h.p020b.C0394c;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import org.xmlpull.v1.XmlPullParser;

public class C0032d {
    public static Interpolator m51a(Context context, int i) {
        NotFoundException notFoundException;
        if (VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        XmlResourceParser xmlResourceParser = null;
        Interpolator c0392a;
        if (i == 17563663) {
            try {
                c0392a = new C0392a();
                if (xmlResourceParser == null) {
                    return c0392a;
                }
                xmlResourceParser.close();
                return c0392a;
            } catch (Throwable e) {
                notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (Throwable e2) {
                notFoundException = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e2);
                throw notFoundException;
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else if (i == 17563661) {
            c0392a = new C0393b();
            if (xmlResourceParser == null) {
                return c0392a;
            }
            xmlResourceParser.close();
            return c0392a;
        } else if (i == 17563662) {
            c0392a = new C0394c();
            if (xmlResourceParser == null) {
                return c0392a;
            }
            xmlResourceParser.close();
            return c0392a;
        } else {
            xmlResourceParser = context.getResources().getAnimation(i);
            c0392a = C0032d.m52a(context, context.getResources(), context.getTheme(), xmlResourceParser);
            if (xmlResourceParser == null) {
                return c0392a;
            }
            xmlResourceParser.close();
            return c0392a;
        }
    }

    private static Interpolator m52a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser) {
        Interpolator interpolator = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                    String name = xmlPullParser.getName();
                    if (name.equals("linearInterpolator")) {
                        interpolator = new LinearInterpolator();
                    } else if (name.equals("accelerateInterpolator")) {
                        interpolator = new AccelerateInterpolator(context, asAttributeSet);
                    } else if (name.equals("decelerateInterpolator")) {
                        interpolator = new DecelerateInterpolator(context, asAttributeSet);
                    } else if (name.equals("accelerateDecelerateInterpolator")) {
                        interpolator = new AccelerateDecelerateInterpolator();
                    } else if (name.equals("cycleInterpolator")) {
                        interpolator = new CycleInterpolator(context, asAttributeSet);
                    } else if (name.equals("anticipateInterpolator")) {
                        interpolator = new AnticipateInterpolator(context, asAttributeSet);
                    } else if (name.equals("overshootInterpolator")) {
                        interpolator = new OvershootInterpolator(context, asAttributeSet);
                    } else if (name.equals("anticipateOvershootInterpolator")) {
                        interpolator = new AnticipateOvershootInterpolator(context, asAttributeSet);
                    } else if (name.equals("bounceInterpolator")) {
                        interpolator = new BounceInterpolator();
                    } else if (name.equals("pathInterpolator")) {
                        interpolator = new C0037g(context, asAttributeSet, xmlPullParser);
                    } else {
                        throw new RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                    }
                }
            }
        }
        return interpolator;
    }
}
