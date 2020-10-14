package com.example.groceriesmart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "MyProduct.db";
    public static final String table_name="products";
    public static final String image_name="image";
    public static final String product_name="name";
    public static final String counts="count";
    public static final String price="price";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table if not exists " +table_name+
                        "("+image_name+" text primary key,"+product_name+" text,"+price+" text,"+counts+" text);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }

    public boolean insertData(String imagename,String product,String  priceproduct,String  countproduct)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("image", imagename);
            contentValues.put("name",product);
            contentValues.put("price",priceproduct);
            contentValues.put("count",countproduct);
            db.insert(table_name, null, contentValues);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db,table_name);
        return numRows;
    }
    public void deleteItemsAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }
    public String[][] getDataProducts()
    {
        int num=numberOfRows();
        String[][] st=new String[num][4];

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+table_name, null );
        res.moveToFirst();

        int i=0;
            while(res.isAfterLast() == false)
            {

                st[i][0]=res.getString(res.getColumnIndex(image_name));
                st[i][1]=res.getString(res.getColumnIndex(product_name));
                st[i][2]=res.getString(res.getColumnIndex(price));
                st[i][3]=res.getString(res.getColumnIndex(counts));
                i++;
                res.moveToNext();
            }
        return st;
    }
    public boolean deletePerticularItem(String id)
    {
        try
        {
            SQLiteDatabase db = this.getReadableDatabase();
            return db.delete(table_name,image_name + "=" + id, null) > 0;
        }
        catch (Exception e)
        {
            System.out.println("---> Delete Error  "+id);
        }
        return false;
    }
}
