package com.example.jzabar7531.lyricist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

/**
 * Created by jzabar7531 on 9/21/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("TaskDBAdapter", "Upgrading from version" + oldVersion + "to" + newVersion +
        ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" + "TEMPLATE");

        onCreate(db);
    }
}
