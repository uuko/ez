package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MySQLiteHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MySQLiteHelper(this, "BookStore.db", null, 3);
        Button create=(Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        Button add=(Button) findViewById(R.id.add);
        Button update=(Button) findViewById(R.id.up);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database=dbHelper.getWritableDatabase();
                 ContentValues values=new ContentValues();
                 values.put("price",11);
                 database.update(
                         "Book",values,"name=?",new String[]{
                                 "uuko"
                         });
            }
        });
        Button del =(Button)findViewById(R.id.del);
        Button query=(Button) findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database=dbHelper.getWritableDatabase();
                Cursor cursor=database.query("Book",
                        null,null,null,
                        null,null,null);
                if (cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        Log.d("MainActivity", "onClick: "+name);
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                database.delete("Book","pages>?",new String[] {"500"});
            }
        });
//
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","uuko");
                values.put("author","yy");
                values.put("pages",444);
                values.put("price",10.55);
                database.insert("Book",null,values);
                values.put("name","ttt");
                values.put("author","tt");
                values.put("pages",41);
                values.put("price",3.55);
                database.insert("Book",null,values);
            }
        });

    }
}
