package com.tech.suraj.mysqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by suraj on 13-09-2017.
 */

public class MyDatabase extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME="shop.db";
    public static final String TABLE_NAME="shop_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="QUANTITY";
    public static final String COL_4="COST";

    public MyDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,QUANTITY INTEGER, COST INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String quantity,String cost)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV=new ContentValues();
        cV.put(COL_2,name);
        cV.put(COL_3,quantity);
        cV.put(COL_4,cost);

        long result = db.insert(TABLE_NAME,null,cV);
        if (result ==-1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return (res);
    }

    public boolean updateData(String name,String quantity,String cost)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,quantity);
        contentValues.put(COL_4,cost);
        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { name });
        return true;
    }

    public Integer deleteData (String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NAME = ?",new String[] {name});
    }
}
