package com.example.dell.testproject6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Dell on 2019/12/19.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_User = "create table User("
            +"id integer primary key autoincrement,"
            +"username text,"
            +"password text,"
            +"phone text)";
    private Context mcontext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_User);
//        Toast.makeText(mcontext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        onCreate(db);
    }
}
