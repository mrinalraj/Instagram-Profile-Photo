package android.support.v4.p012a;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

abstract class C0203f extends C0202e {
    boolean f595b;

    C0203f() {
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!(this.f595b || i == -1)) {
            C0202e.m900b(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!(this.a || i == -1)) {
            C0202e.m900b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
