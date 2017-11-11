package com.mrinalraj.instaprofilephoto.activity;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mrinalraj.instaprofilephoto.R;
import com.mrinalraj.instaprofilephoto.network.GetLink;
import com.mrinalraj.instaprofilephoto.services.ClipBoardService;

public class search extends AppCompatActivity {
    EditText username_et;
    String username;
    ClipboardManager clipMan;
    String[] words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setElevation(0);
        username_et= (EditText) findViewById(R.id.editText2);
        Button srch= (Button) findViewById(R.id.button);
        clipMan= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    0);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkDrawOverlayPermission();
        }
        else{
            startService(new Intent(this, ClipBoardService.class));
        }

        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username_et.getText().toString().equals("")){
                    Toast.makeText(search.this, "username cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    username=username_et.getText().toString().trim();
                    new GetLink(search.this).execute(username);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkDrawOverlayPermission() {

        if (!Settings.canDrawOverlays(this)) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                    .setTitle("App Requires Permission")
                    .setMessage("This app requires permission \"Draw Over Apps\" to run a background service to assist you on Instagram App.\nPlease click allow to go to the settings page and allo the permission.")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                    Uri.parse("package:" +getApplicationContext().getPackageName()));
                            startActivityForResult(intent, 1);
                        }
                    })
                    .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(search.this, "Background service stopped", Toast.LENGTH_SHORT).show();
                        }
                    });
            dialog.show();
        }else{
            startService(new Intent(this, ClipBoardService.class));
        }
    }
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        if (requestCode == 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                            .setTitle("Yay! Automatic detection Enabled")
                            .setMessage("You no more need to paste the Instagram handles here. Just go to the app, navigate to the user's profile and click \"Copy profile URL\" a bubble will appear on the right. Click the bubble to view the PRofile photo. : )")
                            .setPositiveButton("Ok",null);
                    dialog.show();

                    startService(new Intent(this, ClipBoardService.class));
                }
                else{
                    Toast.makeText(this, "Background service stopped", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @Override
    public void onResume(){
        String extra = null;
        try{
            extra = getIntent().getStringExtra("service");
            getIntent().removeExtra("service");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (extra != null){
            new GetLink(this).execute(extra,"true");
        }
        else{
            clipboard();
        }

        super.onResume();
    }

    public void clipboard(){
        ClipData clipData=clipMan.getPrimaryClip();
        if(clipData!=null && clipData.getItemAt(0)!=null) {
            ClipData.Item clipitem = clipData.getItemAt(0);
            String clipStringg = clipitem.getText().toString();
            String profileLink = "www.instagram.com/";
            String postLink = "www.instagram.com/p/";
            words = clipStringg.split("/");
            if (clipStringg.contains(profileLink) && !words[3].equals("p")) {
                AlertDialog.Builder dilog = new AlertDialog.Builder(this);
                dilog.setTitle("Found instagram profile link.");
                dilog.setMessage(words[3] + "\nhas been found on your clipboard do you want to view the profile photo of this user?");
                dilog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClipData clipD = clipMan.getPrimaryClip();
                        clipD = ClipData.newPlainText("text", "");
                        clipMan.setPrimaryClip(clipD);
                        new GetLink(search.this).execute(words[3].trim(),"false");
                    }
                });
                dilog.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dilog.show();
            }
        }

    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(search.this,about.class));
        }
        else if(item.getItemId()==R.id.history) {
            startActivity(new Intent(search.this, history.class));
        }
        return false;

    }


}
