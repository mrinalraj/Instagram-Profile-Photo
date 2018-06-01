package com.p026a.p027a.p028a;

import com.p026a.p027a.C0880i;
import com.p026a.p027a.C0882k;
import com.p026a.p027a.C0889n;
import com.p026a.p027a.C0889n.C0887a;
import com.p026a.p027a.C0889n.C0888b;
import org.json.JSONObject;

public class C0864h extends C0863i<JSONObject> {
    public C0864h(int i, String str, JSONObject jSONObject, C0888b<JSONObject> c0888b, C0887a c0887a) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), c0888b, c0887a);
    }

    protected C0889n<JSONObject> mo799a(C0880i c0880i) {
        try {
            return C0889n.m4942a(new JSONObject(new String(c0880i.f2911b, C0859e.m4858a(c0880i.f2912c, "utf-8"))), C0859e.m4857a(c0880i));
        } catch (Throwable e) {
            return C0889n.m4941a(new C0882k(e));
        } catch (Throwable e2) {
            return C0889n.m4941a(new C0882k(e2));
        }
    }
}
