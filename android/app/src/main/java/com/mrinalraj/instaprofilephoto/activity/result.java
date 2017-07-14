package com.mrinalraj.instaprofilephoto.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.mrinalraj.instaprofilephoto.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class result extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    Bitmap img;
    Bundle bundle;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setElevation(0);
        bundle=getIntent().getExtras();
        title=bundle.getString("username");
        if (title.equals("")){

        }
        else{
            setTitle(title);
        }
        new DownloadImage().execute(bundle.getString("link"));

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_result, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.save){

            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
            saveImage(img);
        }
        if (item.getItemId()==R.id.share){
            String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(), img,"title", null);
            Uri bitmapUri = Uri.parse(bitmapPath);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/png");
            intent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
            intent.putExtra(Intent.EXTRA_TEXT, "Sent using Instagram Profile Photo Viewer");
            startActivity(Intent.createChooser(intent , "Share"));
        }
        //respond to menu item selection
        return false;

    }

    @Override
    public void onBackPressed() {
        bundle.putString("link","");
        bundle.putString("username","");
        super.onBackPressed();
    }

    private void saveImage(Bitmap image){
        File imageFile=getOutputMediaFile();
        if (imageFile == null) {
            Log.d("error","Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            image.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.close();
            Toast.makeText(this, "file save to gallery", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("NOt found", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("io ex", "Error accessing file: " + e.getMessage());
        }
    }
    /** Create a File for saving an image or video */
    private  File getOutputMediaFile(){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()+"/InstaProfilePhotos");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
        File mediaFile;
        String mImageName=title+"_"+timeStamp +".jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }

    private class DownloadImage extends AsyncTask<String,Void,Bitmap>{
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(result.this);
            super.onPreExecute();
            pd.setTitle("Loading Image");
            pd.setMessage("please wait");
            pd.setIndeterminate(true);
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url=strings[0];
            img=null;
            try {
                InputStream in=new URL(url).openStream();
                img= BitmapFactory.decodeStream(in);

            }
            catch (Exception e){
                Log.d("error",e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            pd.dismiss();
            ImageView imgView= (ImageView) findViewById(R.id.imageView);
            imgView.setImageBitmap(img);
            super.onPostExecute(bitmap);
        }
    }
}
