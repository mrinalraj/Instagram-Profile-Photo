package com.mrinalraj.instaface.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.C0550b.C0547a;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.mrinalraj.instaface.C0992a;
import com.mrinalraj.instaface.R;
import com.mrinalraj.instaface.p034a.C0991a;
import com.mrinalraj.instaface.p037d.C1020a;
import com.mrinalraj.instaface.services.ClipBoardService;
import com.p026a.p027a.C0886m;
import com.p026a.p027a.p028a.C0866k;

public class Search extends C0991a {
    ClipboardManager f3295s;
    String[] f3296t;
    C0886m f3297u;

    class C10011 implements OnClickListener {
        final /* synthetic */ Search f3289a;

        C10011(Search search) {
            this.f3289a = search;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.about:
                    this.f3289a.startActivity(new Intent(this.f3289a, about.class));
                    return;
                case R.id.history:
                    this.f3289a.startActivity(new Intent(this.f3289a, History.class));
                    return;
                default:
                    return;
            }
        }
    }

    class C10022 implements OnClickListener {
        final /* synthetic */ Search f3290a;

        C10022(Search search) {
            this.f3290a = search;
        }

        public void onClick(View view) {
            Toast.makeText(this.f3290a, "Coming Soon !", 0).show();
        }
    }

    class C10033 implements DialogInterface.OnClickListener {
        final /* synthetic */ Search f3291a;

        C10033(Search search) {
            this.f3291a = search;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f3291a.f3295s.getPrimaryClip();
            this.f3291a.f3295s.setPrimaryClip(ClipData.newPlainText("text", ""));
            new C1020a(this.f3291a, this.f3291a.f3297u).m5295a(this.f3291a.f3296t[3].trim());
        }
    }

    class C10044 implements DialogInterface.OnClickListener {
        final /* synthetic */ Search f3292a;

        C10044(Search search) {
            this.f3292a = search;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    class C10055 implements DialogInterface.OnClickListener {
        final /* synthetic */ Search f3293a;

        C10055(Search search) {
            this.f3293a = search;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(this.f3293a, "Background service stopped", 0).show();
        }
    }

    class C10066 implements DialogInterface.OnClickListener {
        final /* synthetic */ Search f3294a;

        C10066(Search search) {
            this.f3294a = search;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f3294a.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + this.f3294a.getApplicationContext().getPackageName())), 1);
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean m5269a(Context context) {
        if (VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            return Settings.canDrawOverlays(context);
        } catch (NoSuchMethodError e) {
            return m5270b(context);
        }
    }

    public static boolean m5270b(Context context) {
        try {
            return ((Integer) AppOpsManager.class.getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName()})).intValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    private void m5271l() {
        this.o.setText("Invalid handle");
    }

    private void m5272m() {
        this.o.setText("");
        new C1020a(this, this.f3297u).m5295a(this.m.getText().toString().trim());
    }

    private boolean m5273n() {
        return this.m.getText().toString().equals("") || this.m.getText().toString().contains("instagram.com") || this.m.getText().toString().contains("@");
    }

    @SuppressLint({"InlinedApi"})
    public void m5274a(Activity activity, int i) {
        if (m5269a(this)) {
            startService(new Intent(this, ClipBoardService.class));
        } else {
            new C0547a(this).m2547a((CharSequence) "App Requires Permission").m2549b("This app requires permission \"Draw Over Apps\" to run a background service to assist you on Instagram App.\nPlease click allow to go to the settings page and allo the permission.").m2548a((CharSequence) "Allow", new C10066(this)).m2550b("Deny", new C10055(this)).m2552c();
        }
    }

    public void m5275k() {
        try {
            if (this.f3295s.hasPrimaryClip()) {
                String charSequence = this.f3295s.getPrimaryClip().getItemAt(0).getText().toString();
                String str = "www.instagram.com/p/";
                this.f3296t = charSequence.split("/");
                if (charSequence.contains("www.instagram.com/") && !this.f3296t[3].equals("p")) {
                    C0547a c0547a = new C0547a(this);
                    c0547a.m2547a((CharSequence) "Found instagram profile link.");
                    c0547a.m2549b(this.f3296t[3] + "\nhas been found on your clipboard do you want to view the profile photo of this user?");
                    c0547a.m2548a((CharSequence) "Yes", new C10033(this));
                    c0547a.m2550b("No Thanks", new C10044(this));
                    c0547a.m2552c();
                }
            }
        } catch (NullPointerException e) {
            Log.e("clipboard error", e.toString());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(this)) {
                new C0547a(this).m2547a((CharSequence) "Yay! Automatic detection Enabled").m2549b("You no more need to paste the Instagram handles here. Just go to the app, navigate to the user's profile and click \"Copy profile URL\" a bubble will appear on the right. Click the bubble to view the PRofile photo. : )").m2548a((CharSequence) "Ok", null).m2552c();
                startService(new Intent(this, ClipBoardService.class));
                return;
            }
            Toast.makeText(this, "Background service stopped", 0).show();
        }
    }

    public void onClick(View view) {
        super.onClick(view);
        if (m5273n()) {
            m5271l();
        } else {
            m5272m();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m5250a(getString(R.string.search_title), getString(R.string.search_description));
        this.f3295s = (ClipboardManager) getSystemService("clipboard");
        this.f3297u = C0866k.m4910a(this);
        C0992a c0992a = new C0992a(this);
        if (VERSION.SDK_INT >= 23) {
            m5274a(this, 1);
        } else {
            startService(new Intent(this, ClipBoardService.class));
        }
        this.r.setButtonsMenu(R.menu.menu_fab1);
        this.r.setOnClickListener(new C10011(this));
        ((ImageView) findViewById(R.id.hamburger)).setOnClickListener(new C10022(this));
        m5275k();
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 66) {
            if (m5273n()) {
                m5271l();
            } else {
                m5272m();
            }
        }
        return super.onKey(view, i, keyEvent);
    }

    protected void onResume() {
        String str = null;
        try {
            str = getIntent().getStringExtra("service");
            getIntent().removeExtra("service");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str != null) {
            new C1020a(this, this.f3297u).m5295a(str);
        } else {
            m5275k();
        }
        super.onResume();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (m5273n()) {
            m5271l();
        } else {
            this.o.setText("");
        }
        super.onTextChanged(charSequence, i, i2, i3);
    }
}
