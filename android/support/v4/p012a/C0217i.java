package android.support.v4.p012a;

import android.arch.lifecycle.C0013b;
import android.arch.lifecycle.C0013b.C0012b;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.p012a.C0191a.C0188a;
import android.support.v4.p012a.C0191a.C0189b;
import android.support.v4.p018g.C0331l;
import android.support.v4.p018g.C0351m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0217i extends C0203f implements C0188a, C0189b {
    final Handler f682c = new C02131(this);
    final C0218k f683d = C0218k.m1068a(new C0215a(this));
    boolean f684e;
    boolean f685f;
    boolean f686g = true;
    boolean f687h = true;
    boolean f688i;
    boolean f689j;
    int f690k;
    C0351m<String> f691l;

    class C02131 extends Handler {
        final /* synthetic */ C0217i f667a;

        C02131(C0217i c0217i) {
            this.f667a = c0217i;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f667a.f686g) {
                        this.f667a.m1061a(false);
                        return;
                    }
                    return;
                case 2:
                    this.f667a.m1063b();
                    this.f667a.f683d.m1097n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    class C0215a extends C0214l<C0217i> {
        final /* synthetic */ C0217i f678a;

        public C0215a(C0217i c0217i) {
            this.f678a = c0217i;
            super(c0217i);
        }

        public View mo159a(int i) {
            return this.f678a.findViewById(i);
        }

        public void mo161a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f678a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean mo160a() {
            Window window = this.f678a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean mo162a(C0212h c0212h) {
            return !this.f678a.isFinishing();
        }

        public LayoutInflater mo163b() {
            return this.f678a.getLayoutInflater().cloneInContext(this.f678a);
        }

        public void mo164b(C0212h c0212h) {
            this.f678a.m1060a(c0212h);
        }

        public void mo165c() {
            this.f678a.mo398d();
        }

        public boolean mo166d() {
            return this.f678a.getWindow() != null;
        }

        public int mo167e() {
            Window window = this.f678a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }
    }

    static final class C0216b {
        Object f679a;
        C0234o f680b;
        C0331l<String, C0254u> f681c;

        C0216b() {
        }
    }

    private static void m1056a(C0221m c0221m, C0012b c0012b) {
        for (C0212h c0212h : c0221m.mo183b()) {
            if (c0212h != null) {
                c0212h.f641U.m34a(c0012b);
                C0217i.m1056a(c0212h.m997g(), c0012b);
            }
        }
    }

    public C0013b mo156a() {
        return super.mo156a();
    }

    final View mo168a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f683d.m1071a(view, str, context, attributeSet);
    }

    public final void mo169a(int i) {
        if (!this.f689j && i != -1) {
            C0202e.m900b(i);
        }
    }

    public void m1060a(C0212h c0212h) {
    }

    void m1061a(boolean z) {
        if (!this.f687h) {
            this.f687h = true;
            this.f688i = z;
            this.f682c.removeMessages(1);
            m1066e();
        } else if (z) {
            this.f683d.m1098o();
            this.f683d.m1086c(true);
        }
    }

    protected boolean m1062a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void m1063b() {
        this.f683d.m1091h();
    }

    public Object m1064c() {
        return null;
    }

    @Deprecated
    public void mo398d() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f684e);
        printWriter.print("mResumed=");
        printWriter.print(this.f685f);
        printWriter.print(" mStopped=");
        printWriter.print(this.f686g);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f687h);
        this.f683d.m1076a(str2, fileDescriptor, printWriter, strArr);
        this.f683d.m1070a().mo181a(str, fileDescriptor, printWriter, strArr);
    }

    void m1066e() {
        this.f683d.m1086c(this.f688i);
        this.f683d.m1094k();
    }

    public C0221m m1067f() {
        return this.f683d.m1070a();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f683d.m1081b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f691l.m1668a(i4);
            this.f691l.m1674c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            C0212h a = this.f683d.m1069a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.m953a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        C0221m a = this.f683d.m1070a();
        boolean c = a.mo184c();
        if (c && VERSION.SDK_INT <= 25) {
            return;
        }
        if (c || !a.mo182a()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f683d.m1072a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f683d.m1074a(null);
        super.onCreate(bundle);
        C0216b c0216b = (C0216b) getLastNonConfigurationInstance();
        if (c0216b != null) {
            this.f683d.m1075a(c0216b.f681c);
        }
        if (bundle != null) {
            this.f683d.m1073a(bundle.getParcelable("android:support:fragments"), c0216b != null ? c0216b.f680b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f690k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f691l = new C0351m(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f691l.m1672b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f691l == null) {
            this.f691l = new C0351m();
            this.f690k = 0;
        }
        this.f683d.m1088e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.f683d.m1079a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m1061a(false);
        this.f683d.m1095l();
        this.f683d.m1099p();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f683d.m1096m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f683d.m1080a(menuItem);
            case 6:
                return this.f683d.m1084b(menuItem);
            default:
                return false;
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.f683d.m1077a(z);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f683d.m1081b();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f683d.m1082b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f685f = false;
        if (this.f682c.hasMessages(2)) {
            this.f682c.removeMessages(2);
            m1063b();
        }
        this.f683d.m1092i();
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.f683d.m1083b(z);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f682c.removeMessages(2);
        m1063b();
        this.f683d.m1097n();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : m1062a(view, menu) | this.f683d.m1078a(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.f691l.m1668a(i3);
            this.f691l.m1674c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            C0212h a = this.f683d.m1069a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.m955a(i & 65535, strArr, iArr);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.f682c.sendEmptyMessage(2);
        this.f685f = true;
        this.f683d.m1097n();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f686g) {
            m1061a(true);
        }
        Object c = m1064c();
        C0234o d = this.f683d.m1087d();
        C0331l r = this.f683d.m1101r();
        if (d == null && r == null && c == null) {
            return null;
        }
        C0216b c0216b = new C0216b();
        c0216b.f679a = c;
        c0216b.f680b = d;
        c0216b.f681c = r;
        return c0216b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C0217i.m1056a(m1067f(), C0012b.CREATED);
        Parcelable c = this.f683d.m1085c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.f691l.m1670b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f690k);
            int[] iArr = new int[this.f691l.m1670b()];
            String[] strArr = new String[this.f691l.m1670b()];
            for (int i = 0; i < this.f691l.m1670b(); i++) {
                iArr[i] = this.f691l.m1676d(i);
                strArr[i] = (String) this.f691l.m1677e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f686g = false;
        this.f687h = false;
        this.f682c.removeMessages(1);
        if (!this.f684e) {
            this.f684e = true;
            this.f683d.m1089f();
        }
        this.f683d.m1081b();
        this.f683d.m1097n();
        this.f683d.m1098o();
        this.f683d.m1090g();
        this.f683d.m1100q();
    }

    public void onStateNotSaved() {
        this.f683d.m1081b();
    }

    protected void onStop() {
        super.onStop();
        this.f686g = true;
        C0217i.m1056a(m1067f(), C0012b.CREATED);
        this.f682c.sendEmptyMessage(1);
        this.f683d.m1093j();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.b || i == -1)) {
            C0202e.m900b(i);
        }
        super.startActivityForResult(intent, i);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
