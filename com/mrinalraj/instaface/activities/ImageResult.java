package com.mrinalraj.instaface.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.support.design.widget.Snackbar;
import android.support.v7.app.C0551c;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.joaquimley.faboptions.FabOptions;
import com.jsibbold.zoomage.ZoomageView;
import com.mrinalraj.instaface.R;
import com.p029b.p030a.C0919e;
import com.p029b.p030a.C0951t;
import com.p029b.p030a.C0951t.C0947d;
import com.p029b.p030a.ac;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageResult extends C0551c {
    String f3286m;
    String f3287n;
    ZoomageView f3288o;

    class C09961 implements C0919e {
        final /* synthetic */ ImageResult f3280a;

        C09961(ImageResult imageResult) {
            this.f3280a = imageResult;
        }

        public void mo829a() {
            this.f3280a.findViewById(R.id.progress).setVisibility(8);
        }

        public void mo830b() {
            Toast.makeText(this.f3280a, "Error Loading Image", 0).show();
            this.f3280a.finish();
        }
    }

    class C09972 implements OnClickListener {
        final /* synthetic */ ImageResult f3281a;

        C09972(ImageResult imageResult) {
            this.f3281a = imageResult;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.save:
                    this.f3281a.m5267k();
                    return;
                case R.id.share:
                    this.f3281a.m5268l();
                    return;
                default:
                    return;
            }
        }
    }

    class C09993 implements ac {
        final /* synthetic */ ImageResult f3284a;

        C09993(ImageResult imageResult) {
            this.f3284a = imageResult;
        }

        public void mo831a(final Bitmap bitmap, C0947d c0947d) {
            new Thread(new Runnable(this) {
                final /* synthetic */ C09993 f3283b;

                public void run() {
                    File a = this.f3283b.f3284a.m5266m();
                    if (a == null) {
                        Log.d("error", "Error creating media file, check storage permissions: ");
                        return;
                    }
                    try {
                        OutputStream fileOutputStream = new FileOutputStream(a);
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.close();
                        Snackbar.m604a(this.f3283b.f3284a.getWindow().getDecorView().getRootView(), "Saved to Gallery", -1).m595a();
                    } catch (FileNotFoundException e) {
                        Toast.makeText(this.f3283b.f3284a, e.toString(), 0).show();
                        Log.d("Not found", "File not found: " + e.getMessage());
                    } catch (IOException e2) {
                        Toast.makeText(this.f3283b.f3284a, e2.toString(), 0).show();
                        Log.d("io ex", "Error accessing file: " + e2.getMessage());
                    }
                }
            }).start();
        }

        public void mo832a(Drawable drawable) {
        }

        public void mo833b(Drawable drawable) {
        }
    }

    class C10004 implements ac {
        final /* synthetic */ ImageResult f3285a;

        C10004(ImageResult imageResult) {
            this.f3285a = imageResult;
        }

        public void mo831a(Bitmap bitmap, C0947d c0947d) {
            Parcelable parse = Uri.parse(Media.insertImage(this.f3285a.getContentResolver(), bitmap, this.f3285a.f3286m, null));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.STREAM", parse);
            intent.putExtra("android.intent.extra.TEXT", "Sent using Insta Face app on Google Play Store \nDownload now https://play.google.com/store/apps/details?id=com.mrinalraj.instaface");
            this.f3285a.startActivity(Intent.createChooser(intent, "Share"));
        }

        public void mo832a(Drawable drawable) {
        }

        public void mo833b(Drawable drawable) {
        }
    }

    private File m5266m() {
        File file = new File(Environment.getExternalStorageDirectory() + "/InstaProfilePhotos");
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return new File(file.getPath() + File.separator + (this.f3286m + "_" + new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date()) + ".jpg"));
    }

    public void m5267k() {
        C0951t.m5139a((Context) this).m5145a(this.f3287n).m5179a(new C09993(this));
    }

    public void m5268l() {
        C0951t.m5139a((Context) this).m5145a(this.f3287n).m5179a(new C10004(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_image_result);
        this.f3288o = (ZoomageView) findViewById(R.id.imageView);
        this.f3286m = getIntent().getExtras().getString("handle");
        this.f3287n = getIntent().getExtras().getString("link");
        ((TextView) findViewById(R.id.handle)).setText(this.f3286m.toUpperCase());
        C0951t.m5139a((Context) this).m5145a(this.f3287n).m5178a(this.f3288o, new C09961(this));
        ((FabOptions) findViewById(R.id.fab_options2)).setOnClickListener(new C09972(this));
    }
}
