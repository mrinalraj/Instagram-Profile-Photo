package com.mrinalraj.instaface.p037d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.mrinalraj.instaface.R;
import com.mrinalraj.instaface.activities.ImageResult;
import com.mrinalraj.instaface.p036c.C1017a;
import com.p026a.p027a.C0867s;
import com.p026a.p027a.C0886m;
import com.p026a.p027a.C0889n.C0887a;
import com.p026a.p027a.C0889n.C0888b;
import com.p026a.p027a.p028a.C0864h;
import com.p031c.p032a.C0965a;
import com.p031c.p032a.C0968b;
import org.json.JSONObject;

public class C1020a {
    Context f3324a;
    C0886m f3325b;
    String f3326c = "http://insta-profile.herokuapp.com/";

    class C10192 implements C0887a {
        final /* synthetic */ C1020a f3323a;

        C10192(C1020a c1020a) {
            this.f3323a = c1020a;
        }

        public void mo846a(C0867s c0867s) {
            Toast.makeText(this.f3323a.f3324a, "Invalid Handle", 0).show();
        }
    }

    public C1020a(Context context, C0886m c0886m) {
        this.f3324a = context;
        this.f3325b = c0886m;
    }

    public void m5295a(final String str) {
        String str2 = this.f3326c + str.trim();
        final C0965a a = C0968b.m5196a((Activity) this.f3324a).m5207a("Getting Profile").m5209b("Getting the user profile image").m5208a(true).m5206a((int) R.color.colorAccent).m5205a();
        this.f3325b.m4934a(new C0864h(0, str2, null, new C0888b<JSONObject>(this) {
            final /* synthetic */ C1020a f3322c;

            public void m5293a(JSONObject jSONObject) {
                a.m5194a();
                if (jSONObject == null) {
                    a.m5194a();
                    Toast.makeText(this.f3322c.f3324a, "", 0).show();
                } else if (jSONObject.optString("error").equals("0")) {
                    String optString = jSONObject.optString("profile_pic_url");
                    new C1017a(this.f3322c.f3324a, null).m5286a(str, optString);
                    Intent intent = new Intent(this.f3322c.f3324a, ImageResult.class);
                    intent.putExtra("handle", str);
                    intent.putExtra("link", optString);
                    this.f3322c.f3324a.startActivity(intent);
                } else {
                    a.m5194a();
                    Toast.makeText(this.f3322c.f3324a, "Some error occured!", 0).show();
                }
            }
        }, new C10192(this)));
    }
}
