package com.mrinalraj.instaprofilephoto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class search extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    EditText username_et;
    JSONObject reply;
    String link;
    String err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setElevation(0);
        username_et= (EditText) findViewById(R.id.editText2);
        Button srch= (Button) findViewById(R.id.button);
        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username_et.getText().toString().equals("")){
                    Toast.makeText(search.this, "username cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    new GetLink().execute(username_et.getText().toString().trim());
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
        //respond to menu item selection
        return false;

    }

    private class GetLink extends AsyncTask<String,String,JSONObject>{
        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(search.this);
            pd.setIndeterminate(true);
            pd.setTitle("Reaching out their profile.");
            pd.setMessage("Please wait...");
            pd.show();
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            JSONCustom result= new JSONCustom();
            try {
                reply=result.getJSONObjectFromURL("http://insta-profile.herokuapp.com/"+strings[0],"GET");
                if (reply!=null){
                    Log.d("server reply",reply.toString());
                    err=reply.optString("error");
                    Log.d("error status",err);
                    if (err.equals("0")){
                        link=reply.optString("profile_pic_url");
                    }
                    else {

                    }
                }
                else{
                    search.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(search.this, "server returned noting please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            pd.dismiss();
            Log.d("error status and link", err+"____"+link);
            if(link!=null) {
                String name = username_et.getText().toString();
                Intent intent = new Intent(search.this, result.class);
                intent.putExtra("username", name);
                intent.putExtra("link", link);
                link=null;
                startActivity(intent);
            }
            else {
                search.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(search.this, "Enter a valid Instagram username", Toast.LENGTH_LONG).show();
                    }
                });
            }
            super.onPostExecute(jsonObject);
        }
    }
}
