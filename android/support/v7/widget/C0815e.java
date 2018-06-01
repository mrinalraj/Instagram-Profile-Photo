package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class C0815e extends DataSetObservable {
    static final String f2715a = C0815e.class.getSimpleName();
    private static final Object f2716e = new Object();
    private static final Map<String, C0815e> f2717f = new HashMap();
    final Context f2718b;
    final String f2719c;
    boolean f2720d;
    private final Object f2721g;
    private final List<C0810a> f2722h;
    private final List<C0812c> f2723i;
    private Intent f2724j;
    private C0811b f2725k;
    private int f2726l;
    private boolean f2727m;
    private boolean f2728n;
    private boolean f2729o;
    private C0813d f2730p;

    public static final class C0810a implements Comparable<C0810a> {
        public final ResolveInfo f2709a;
        public float f2710b;

        public C0810a(ResolveInfo resolveInfo) {
            this.f2709a = resolveInfo;
        }

        public int m4657a(C0810a c0810a) {
            return Float.floatToIntBits(c0810a.f2710b) - Float.floatToIntBits(this.f2710b);
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m4657a((C0810a) obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.f2710b) == Float.floatToIntBits(((C0810a) obj).f2710b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2710b) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f2709a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2710b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C0811b {
        void m4658a(Intent intent, List<C0810a> list, List<C0812c> list2);
    }

    public static final class C0812c {
        public final ComponentName f2711a;
        public final long f2712b;
        public final float f2713c;

        public C0812c(ComponentName componentName, long j, float f) {
            this.f2711a = componentName;
            this.f2712b = j;
            this.f2713c = f;
        }

        public C0812c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0812c c0812c = (C0812c) obj;
            if (this.f2711a == null) {
                if (c0812c.f2711a != null) {
                    return false;
                }
            } else if (!this.f2711a.equals(c0812c.f2711a)) {
                return false;
            }
            return this.f2712b != c0812c.f2712b ? false : Float.floatToIntBits(this.f2713c) == Float.floatToIntBits(c0812c.f2713c);
        }

        public int hashCode() {
            return (((((this.f2711a == null ? 0 : this.f2711a.hashCode()) + 31) * 31) + ((int) (this.f2712b ^ (this.f2712b >>> 32)))) * 31) + Float.floatToIntBits(this.f2713c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f2711a);
            stringBuilder.append("; time:").append(this.f2712b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2713c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C0813d {
        boolean m4659a(C0815e c0815e, Intent intent);
    }

    private final class C0814e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ C0815e f2714a;

        C0814e(C0815e c0815e) {
            this.f2714a = c0815e;
        }

        public Void m4660a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f2714a.f2718b.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C0812c c0812c = (C0812c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c0812c.f2711a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c0812c.f2712b));
                        newSerializer.attribute(null, "weight", String.valueOf(c0812c.f2713c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f2714a.f2720d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(C0815e.f2715a, "Error writing historical record file: " + this.f2714a.f2719c, e2);
                    this.f2714a.f2720d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(C0815e.f2715a, "Error writing historical record file: " + this.f2714a.f2719c, e22);
                    this.f2714a.f2720d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(C0815e.f2715a, "Error writing historical record file: " + this.f2714a.f2719c, e222);
                    this.f2714a.f2720d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f2714a.f2720d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(C0815e.f2715a, "Error writing historical record file: " + str, e2222);
            }
            return null;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4660a(objArr);
        }
    }

    private boolean m4661a(C0812c c0812c) {
        boolean add = this.f2723i.add(c0812c);
        if (add) {
            this.f2728n = true;
            m4667h();
            m4662c();
            m4664e();
            notifyChanged();
        }
        return add;
    }

    private void m4662c() {
        if (!this.f2727m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2728n) {
            this.f2728n = false;
            if (!TextUtils.isEmpty(this.f2719c)) {
                new C0814e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f2723i), this.f2719c});
            }
        }
    }

    private void m4663d() {
        int f = m4665f() | m4666g();
        m4667h();
        if (f != 0) {
            m4664e();
            notifyChanged();
        }
    }

    private boolean m4664e() {
        if (this.f2725k == null || this.f2724j == null || this.f2722h.isEmpty() || this.f2723i.isEmpty()) {
            return false;
        }
        this.f2725k.m4658a(this.f2724j, this.f2722h, Collections.unmodifiableList(this.f2723i));
        return true;
    }

    private boolean m4665f() {
        if (!this.f2729o || this.f2724j == null) {
            return false;
        }
        this.f2729o = false;
        this.f2722h.clear();
        List queryIntentActivities = this.f2718b.getPackageManager().queryIntentActivities(this.f2724j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2722h.add(new C0810a((ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m4666g() {
        if (!this.f2720d || !this.f2728n || TextUtils.isEmpty(this.f2719c)) {
            return false;
        }
        this.f2720d = false;
        this.f2727m = true;
        m4668i();
        return true;
    }

    private void m4667h() {
        int size = this.f2723i.size() - this.f2726l;
        if (size > 0) {
            this.f2728n = true;
            for (int i = 0; i < size; i++) {
                C0812c c0812c = (C0812c) this.f2723i.remove(0);
            }
        }
    }

    private void m4668i() {
        try {
            InputStream openFileInput = this.f2718b.openFileInput(this.f2719c);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f2723i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0812c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f2715a, "Error reading historical recrod file: " + this.f2719c, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f2715a, "Error reading historical recrod file: " + this.f2719c, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }

    public int m4669a() {
        int size;
        synchronized (this.f2721g) {
            m4663d();
            size = this.f2722h.size();
        }
        return size;
    }

    public int m4670a(ResolveInfo resolveInfo) {
        synchronized (this.f2721g) {
            m4663d();
            List list = this.f2722h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0810a) list.get(i)).f2709a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo m4671a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2721g) {
            m4663d();
            resolveInfo = ((C0810a) this.f2722h.get(i)).f2709a;
        }
        return resolveInfo;
    }

    public Intent m4672b(int i) {
        synchronized (this.f2721g) {
            if (this.f2724j == null) {
                return null;
            }
            m4663d();
            C0810a c0810a = (C0810a) this.f2722h.get(i);
            ComponentName componentName = new ComponentName(c0810a.f2709a.activityInfo.packageName, c0810a.f2709a.activityInfo.name);
            Intent intent = new Intent(this.f2724j);
            intent.setComponent(componentName);
            if (this.f2730p != null) {
                if (this.f2730p.m4659a(this, new Intent(intent))) {
                    return null;
                }
            }
            m4661a(new C0812c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m4673b() {
        synchronized (this.f2721g) {
            m4663d();
            if (this.f2722h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0810a) this.f2722h.get(0)).f2709a;
            return resolveInfo;
        }
    }

    public void m4674c(int i) {
        synchronized (this.f2721g) {
            m4663d();
            C0810a c0810a = (C0810a) this.f2722h.get(i);
            C0810a c0810a2 = (C0810a) this.f2722h.get(0);
            m4661a(new C0812c(new ComponentName(c0810a.f2709a.activityInfo.packageName, c0810a.f2709a.activityInfo.name), System.currentTimeMillis(), c0810a2 != null ? (c0810a2.f2710b - c0810a.f2710b) + 5.0f : 1.0f));
        }
    }
}
