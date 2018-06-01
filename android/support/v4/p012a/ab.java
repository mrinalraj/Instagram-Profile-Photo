package android.support.v4.p012a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p013b.C0190a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class ab implements Iterable<Intent> {
    private static final C0193c f551a;
    private final ArrayList<Intent> f552b = new ArrayList();
    private final Context f553c;

    public interface C0192a {
        Intent a_();
    }

    static class C0193c {
        C0193c() {
        }
    }

    static class C0194b extends C0193c {
        C0194b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f551a = new C0194b();
        } else {
            f551a = new C0193c();
        }
    }

    private ab(Context context) {
        this.f553c = context;
    }

    public static ab m872a(Context context) {
        return new ab(context);
    }

    public ab m873a(Activity activity) {
        Intent intent = null;
        if (activity instanceof C0192a) {
            intent = ((C0192a) activity).a_();
        }
        Intent a = intent == null ? C0259w.m1326a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f553c.getPackageManager());
            }
            m874a(component);
            m875a(a);
        }
        return this;
    }

    public ab m874a(ComponentName componentName) {
        int size = this.f552b.size();
        try {
            Intent a = C0259w.m1327a(this.f553c, componentName);
            while (a != null) {
                this.f552b.add(size, a);
                a = C0259w.m1327a(this.f553c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public ab m875a(Intent intent) {
        this.f552b.add(intent);
        return this;
    }

    public void m876a() {
        m877a(null);
    }

    public void m877a(Bundle bundle) {
        if (this.f552b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f552b.toArray(new Intent[this.f552b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0190a.m866a(this.f553c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f553c.startActivity(intent);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f552b.iterator();
    }
}
