package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MySQLiteHelper extends SQLiteOpenHelper {

//    public static final String TABLE_COMMENTS = "comments";
//    public static final String COLUMN_ID = "_id";
//    public static final String COLUMN_COMMENT = "comment";
//
//    private static final String DATABASE_NAME = "commments.db";
//    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String CREATE_BOOK = "create table BOOK"
            + "("
            + " id integer primary key autoincrement, " + "author text,"
            +"price real,"
            +"pages integer,"
            +"name text);";
    private static final String CREATE_CATEGORY = "create table Category"
            + "("
            + " id integer primary key autoincrement, " + "category text,"
            +"category_code integer);";
    private Context mContext;
    public MySQLiteHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name,factory,version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_BOOK);
        database.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext,"sussed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS BOOK" );
        db.execSQL("DROP TABLE IF EXISTS Category" );
        onCreate(db);
    }

}