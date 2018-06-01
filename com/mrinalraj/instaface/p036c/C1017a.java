package com.mrinalraj.instaface.p036c;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class C1017a extends SQLiteOpenHelper {
    Context f3318a;
    CursorFactory f3319b;

    public C1017a(Context context, CursorFactory cursorFactory) {
        super(context, "Search_History", cursorFactory, 1);
        this.f3318a = context;
        this.f3319b = cursorFactory;
    }

    public void m5286a(String str, String str2) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (m5287a(str)) {
                Log.d("duplicate data", "username already present");
                return;
            }
            writableDatabase.execSQL("INSERT INTO history (name,link) VALUES('" + str + "','" + str2 + "');");
            Log.d("added", "added to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean m5287a(String str) {
        try {
            for (String equals : m5288a()) {
                if (equals.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String[] m5288a() {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM history", null);
        String[] strArr = new String[rawQuery.getCount()];
        Log.d("query", rawQuery.toString());
        if (rawQuery != null && rawQuery.moveToFirst()) {
            int i = 0;
            while (true) {
                strArr[i] = rawQuery.getString(0);
                if (rawQuery.isLast()) {
                    break;
                }
                rawQuery.moveToNext();
                i++;
            }
        }
        return strArr;
    }

    public void m5289b(String str) {
        getWritableDatabase().delete("history", "name=?", new String[]{str});
    }

    public String[] m5290b() {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM history", null);
        String[] strArr = new String[rawQuery.getCount()];
        Log.d("query", rawQuery.toString());
        if (rawQuery != null && rawQuery.moveToFirst()) {
            int i = 0;
            while (true) {
                strArr[i] = rawQuery.getString(1);
                if (rawQuery.isLast()) {
                    break;
                }
                rawQuery.moveToNext();
                i++;
            }
        }
        return strArr;
    }

    public void m5291c() {
        getWritableDatabase().execSQL("DELETE FROM history;");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS history(name VARCHAR NOT NULL PRIMARY KEY,link VARCHAR NOT NULL);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
