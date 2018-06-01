package android.support.v4.p009e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p009e.C0305a.C0307a;

public class C0313d implements Parcelable {
    public static final Creator<C0313d> CREATOR = new C03101();
    final boolean f906a = false;
    final Handler f907b = null;
    C0305a f908c;

    static class C03101 implements Creator<C0313d> {
        C03101() {
        }

        public C0313d m1524a(Parcel parcel) {
            return new C0313d(parcel);
        }

        public C0313d[] m1525a(int i) {
            return new C0313d[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1524a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1525a(i);
        }
    }

    class C0311a extends C0307a {
        final /* synthetic */ C0313d f902a;

        C0311a(C0313d c0313d) {
            this.f902a = c0313d;
        }

        public void mo212a(int i, Bundle bundle) {
            if (this.f902a.f907b != null) {
                this.f902a.f907b.post(new C0312b(this.f902a, i, bundle));
            } else {
                this.f902a.mo298a(i, bundle);
            }
        }
    }

    class C0312b implements Runnable {
        final int f903a;
        final Bundle f904b;
        final /* synthetic */ C0313d f905c;

        C0312b(C0313d c0313d, int i, Bundle bundle) {
            this.f905c = c0313d;
            this.f903a = i;
            this.f904b = bundle;
        }

        public void run() {
            this.f905c.mo298a(this.f903a, this.f904b);
        }
    }

    C0313d(Parcel parcel) {
        this.f908c = C0307a.m1522a(parcel.readStrongBinder());
    }

    protected void mo298a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f908c == null) {
                this.f908c = new C0311a(this);
            }
            parcel.writeStrongBinder(this.f908c.asBinder());
        }
    }
}
