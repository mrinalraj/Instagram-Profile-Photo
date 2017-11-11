package com.mrinalraj.instaprofilephoto.activity;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;

import com.mrinalraj.instaprofilephoto.R;
import com.mrinalraj.instaprofilephoto.database.DatabaseInteraction;
import com.mrinalraj.instaprofilephoto.network.GetLink;

public class search extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    EditText username_et;
    String username;
    ClipboardManager clipMan;
    String[] words;

    DatabaseInteraction db;
    TextView del;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setElevation(0);
        username_et= (EditText) findViewById(R.id.editText2);
        Button srch= (Button) findViewById(R.id.button);
        clipMan= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        clipboard();
        //db=new DatabaseInteraction(this,null);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }

        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username_et.getText().toString().equals("")){
                    Toast.makeText(search.this, "username cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    username=username_et.getText().toString().trim();
                    //db.add(username);
                    new GetLink(search.this).execute(username);
                }
            }
        });
    }

    @Override
    public void onResume(){
        clipboard();
        super.onResume();
    }

    public void clipboard(){
        ClipData clipData=clipMan.getPrimaryClip();
        ClipData.Item clipitem=clipData.getItemAt(0);

        String clipStringg = clipitem.getText().toString();
        String profileLink="www.instagram.com/";
        String postLink = "www.instagram.com/p/";
        words = clipStringg.split("/");
        if (clipStringg.contains(profileLink) && !words[3].equals("p")){
            AlertDialog.Builder dilog = new AlertDialog.Builder(this);
                    dilog.setTitle("Found instagram profile link.");
                    dilog.setMessage(words[3] + " has been found on your clipboard do you want to view the profile photo of this user?");
                    dilog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ClipData clipD = clipMan.getPrimaryClip();
                            clipD = ClipData.newPlainText("text", "");
                            clipMan.setPrimaryClip(clipD);
                            new GetLink(search.this).execute(words[3].trim());
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

//        try {
//            String clipString = clipitem.getText().toString();
//            String matchingLink="www.instagram.com/";
//            String matchingLink2="www.instagram.com/p/";
//            if (clipString.toLowerCase().contains(matchingLink)){
//                if(clipString.toLowerCase().contains(matchingLink2)){
//                    // for posts image loading.. will be released in next version
//                    Toast.makeText(this, "Clipboard contains some instagram post link. make sure it's a profile link copied.", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    words = clipString.split("/");
//                    AlertDialog.Builder dilog = new AlertDialog.Builder(this);
//                    dilog.setTitle("Found instagram profile link.");
//                    dilog.setMessage(words[3] + " has been found on your clipboard do you want to view the profile photo of this user?");
//                    dilog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            new GetLink(search.this).execute(words[3].trim());
//                            ClipData clipD = clipMan.getPrimaryClip();
//                            clipD = ClipData.newPlainText("text", "");
//                            clipMan.setPrimaryClip(clipD);
//                        }
//                    });
//                    dilog.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                    dilog.create().show();
//                }
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
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
        else if(item.getItemId()==R.id.history){
            startActivity(new Intent(search.this,history.class));
        }
        //respond to menu item selection
        return false;

    }


}
