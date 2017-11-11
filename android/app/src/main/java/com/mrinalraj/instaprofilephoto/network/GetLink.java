package com.mrinalraj.instaprofilephoto.network;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mrinalraj.instaprofilephoto.activity.result;
import com.mrinalraj.instaprofilephoto.database.DatabaseInteraction;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Mystique on 17-06-2017.
 */
public class GetLink extends AsyncTask<String,Integer,JSONObject>{
    ProgressDialog pd;
    Context c;
    JSONObject reply;
    String link,err,username,finish;

    public GetLink(Context c){
        this.c=c;
    }
    @Override
    protected void onPreExecute() {
        pd=new ProgressDialog(c);
        pd.setIndeterminate(true);
        pd.setTitle("Reaching out their profile.");
        pd.setMessage("Please wait...");
        pd.show();
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        JSONCustom result= new JSONCustom();
        username=strings[0];
        finish = strings[1];
        try {
            reply=result.getJSONObjectFromURL("http://insta-profile.herokuapp.com/"+username,"GET");
            if (reply!=null){
                Log.d("server reply",reply.toString());
                err=reply.optString("error");
                Log.d("error status",err);
                if (err.equals("0")){
                    link=reply.optString("profile_pic_url");
                }
                else {
                    Toast.makeText(c, "Some error occured!", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                publishProgress(1);
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
            DatabaseInteraction db=new DatabaseInteraction(c,null);
            db.add(username);
            String name = username;
            Intent intent = new Intent(c, result.class);
            intent.putExtra("username", name);
            intent.putExtra("link", link);
            link=null;
            c.startActivity(intent);
            if (finish!= null && finish.equals("true")){
                ((Activity)c).finish();
            }
        }
        else {
            Toast.makeText(c, "Enter a valid Instagram username", Toast.LENGTH_LONG).show();
        }
        super.onPostExecute(jsonObject);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        if (values.equals(1)){
            Toast.makeText(c, "Server returned nothing!", Toast.LENGTH_SHORT).show();
        }
        super.onProgressUpdate(values);
    }
}