package com.example.sqlite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR=0;
    public static final int BOOK_ITEM=1;
    public static final int CATEGORY_DIR=2;
    public static final int CATEGORY_ITEM=3;
    public static final  String AUTHORITY=
            "com.example.sqlite.provider";
    private static UriMatcher uriMatcher;
    private  MySQLiteHelper dbHelper;
    //用UriMatcher 匹配 addURI(authority,path,owndef)
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"category/#",CATEGORY_ITEM);
    }

    public DatabaseProvider() {
    }






    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        dbHelper=new MySQLiteHelper(getContext(),"Bookstore.db",null,3);
        return true;
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        Uri uriReturn=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookId=database.insert("Book",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/book/"+newBookId);
                break;
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
                long newCateGoryId=database.insert("Category",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/category/"+newCateGoryId);
                break;
            default:
                break;

            //throw new UnsupportedOperationException("Not yet implemented");
        } return uriReturn;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Cursor cursor=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                cursor=database.query("Book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                // uri權限之後用 / 分割 放到list 第0個是路徑 第一個是id
                cursor=database.query("Book",projection,"id=?",new String[]{bookId},null,null,sortOrder);
                break;
            case CATEGORY_DIR:
                cursor=database.query("Category",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case CATEGORY_ITEM:
                String categoryId=uri.getPathSegments().get(1);
                cursor=database.query("Category",projection,"id=?",new String[]{categoryId},null,null,sortOrder);
                break;
            default:
                break;

        }
        return cursor;
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        int updateRows =0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                updateRows=database.update("Book",values,selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                updateRows=database.update("Book",values,"id=?",new String[]{bookId});
                break;
            case CATEGORY_DIR:
                updateRows=database.update("Category",values,selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId=uri.getPathSegments().get(1);
                updateRows=database.update("Category",values,"id=?",new String[]{categoryId});
                break;
            default:
                break;
        }
        return updateRows;
//        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        int deletedRows=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deletedRows=database.delete("Book",selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                deletedRows=database.delete("Book","id=?",new String[]{bookId});
                break;
            case CATEGORY_DIR:
                deletedRows=database.delete("Category",selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId=uri.getPathSegments().get(1);
                deletedRows=database.delete("Category","id=?",new String[]{categoryId});
                break;

        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public  String getType(Uri uri){
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.sqlite.provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.sqlite.provider.book";
            case CATEGORY_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.sqlite.provider.category";
            case CATEGORY_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.sqlite.provider.category";
        }
        return null;
    }
}
