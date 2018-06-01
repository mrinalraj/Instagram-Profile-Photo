package android.support.v4.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p018g.C0331l;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0218k {
    private final C0214l<?> f692a;

    private C0218k(C0214l<?> c0214l) {
        this.f692a = c0214l;
    }

    public static final C0218k m1068a(C0214l<?> c0214l) {
        return new C0218k(c0214l);
    }

    public C0212h m1069a(String str) {
        return this.f692a.f671d.m1186b(str);
    }

    public C0221m m1070a() {
        return this.f692a.m1041i();
    }

    public View m1071a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f692a.f671d.onCreateView(view, str, context, attributeSet);
    }

    public void m1072a(Configuration configuration) {
        this.f692a.f671d.m1166a(configuration);
    }

    public void m1073a(Parcelable parcelable, C0234o c0234o) {
        this.f692a.f671d.m1168a(parcelable, c0234o);
    }

    public void m1074a(C0212h c0212h) {
        this.f692a.f671d.m1176a(this.f692a, this.f692a, c0212h);
    }

    public void m1075a(C0331l<String, C0254u> c0331l) {
        this.f692a.m1026a((C0331l) c0331l);
    }

    public void m1076a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f692a.m1034b(str, fileDescriptor, printWriter, strArr);
    }

    public void m1077a(boolean z) {
        this.f692a.f671d.m1178a(z);
    }

    public boolean m1078a(Menu menu) {
        return this.f692a.f671d.m1181a(menu);
    }

    public boolean m1079a(Menu menu, MenuInflater menuInflater) {
        return this.f692a.f671d.m1182a(menu, menuInflater);
    }

    public boolean m1080a(MenuItem menuItem) {
        return this.f692a.f671d.m1183a(menuItem);
    }

    public void m1081b() {
        this.f692a.f671d.m1220k();
    }

    public void m1082b(Menu menu) {
        this.f692a.f671d.m1192b(menu);
    }

    public void m1083b(boolean z) {
        this.f692a.f671d.m1193b(z);
    }

    public boolean m1084b(MenuItem menuItem) {
        return this.f692a.f671d.m1194b(menuItem);
    }

    public Parcelable m1085c() {
        return this.f692a.f671d.m1218j();
    }

    public void m1086c(boolean z) {
        this.f692a.m1029a(z);
    }

    public C0234o m1087d() {
        return this.f692a.f671d.m1213h();
    }

    public void m1088e() {
        this.f692a.f671d.m1222l();
    }

    public void m1089f() {
        this.f692a.f671d.m1224m();
    }

    public void m1090g() {
        this.f692a.f671d.m1227n();
    }

    public void m1091h() {
        this.f692a.f671d.m1228o();
    }

    public void m1092i() {
        this.f692a.f671d.m1230p();
    }

    public void m1093j() {
        this.f692a.f671d.m1231q();
    }

    public void m1094k() {
        this.f692a.f671d.m1232r();
    }

    public void m1095l() {
        this.f692a.f671d.m1234t();
    }

    public void m1096m() {
        this.f692a.f671d.m1235u();
    }

    public boolean m1097n() {
        return this.f692a.f671d.m1206e();
    }

    public void m1098o() {
        this.f692a.m1043k();
    }

    public void m1099p() {
        this.f692a.m1044l();
    }

    public void m1100q() {
        this.f692a.m1045m();
    }

    public C0331l<String, C0254u> m1101r() {
        return this.f692a.m1046n();
    }
}
