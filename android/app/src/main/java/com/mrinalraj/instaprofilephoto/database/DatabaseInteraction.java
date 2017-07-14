package com.mrinalraj.instaprofilephoto.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Mystique on 17-06-2017.
 */

public class DatabaseInteraction extends SQLiteOpenHelper{
    Context context;
    SQLiteDatabase.CursorFactory mode;
    private static final String DATABASE_NAME= "Search_History";
    private static final String SELECT_SQL = "SELECT * FROM history";
    Cursor c;

    public DatabaseInteraction(Context context, SQLiteDatabase.CursorFactory mode){
        super(context,DATABASE_NAME,mode,1);
        this.context=context;
        this.mode=mode;
    }



    public void add(String username){
        SQLiteDatabase mydb=this.getWritableDatabase();
        if (!doesHave(username)) {
            String query = "INSERT INTO history (name) VALUES('" + username + "');";
            mydb.execSQL(query);
            Log.d("added", "added to database");
        }
        else {
            Log.d("duplicate data", "username already present");
        }
    }
    public boolean doesHave(String record){
        String[] all=readAll();
        for (int i=0; i<all.length;i++){
            if (all[i].equals(record)){
                return true;
            }
        }
        return false;
    }
    public String[] readAll(){
        SQLiteDatabase mydb=this.getReadableDatabase();
        Cursor cursor = mydb.rawQuery(SELECT_SQL, null);
        String[] users=new String[cursor.getCount()];
        Log.d("query",cursor.toString());
        if(cursor!=null && cursor.moveToFirst()) {
            for(int i=0;;){
                users[i] = cursor.getString(0);
                if(cursor.isLast()){
                    break;
                }
                cursor.moveToNext();
                i++;
            }
        }
        return users;
    }

    public void deleteAll(){
        SQLiteDatabase mydb=this.getWritableDatabase();
        mydb.execSQL("DELETE FROM history;");
    }

    public void delete(String username){
        SQLiteDatabase mydb=this.getWritableDatabase();
        mydb.delete("history", "name=?", new String[]{username});
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS history(name VARCHAR NOT NULL PRIMARY KEY);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
