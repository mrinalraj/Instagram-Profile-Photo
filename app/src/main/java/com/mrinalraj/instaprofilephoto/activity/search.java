package com.mrinalraj.instaprofilephoto.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrinalraj.instaprofilephoto.adapter.HistoryAdapter;
import com.mrinalraj.instaprofilephoto.adapter.Username;
import com.mrinalraj.instaprofilephoto.database.DatabaseInteraction;
import com.mrinalraj.instaprofilephoto.listeners.RecyclerTouchListener;
import com.mrinalraj.instaprofilephoto.network.GetLink;
import com.mrinalraj.instaprofilephoto.network.JSONCustom;
import com.mrinalraj.instaprofilephoto.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    EditText username_et;
    JSONObject reply;
    String link,err,username;

    DatabaseInteraction db;
    TextView del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setElevation(0);
        username_et= (EditText) findViewById(R.id.editText2);
        Button srch= (Button) findViewById(R.id.button);

        //db=new DatabaseInteraction(this,null);

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
