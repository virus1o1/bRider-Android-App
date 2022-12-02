package com.simple.brider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SignUpHelper extends SQLiteOpenHelper {

    public SignUpHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(fname TEXT primary key,lname TEXT,email TEXT, pass TEXT, cpass TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");
    }
    public Boolean insertData(String fname,String lname, String email, String pass, String cpass) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fname", fname);
        contentValues.put("lname", lname);
        contentValues.put("email", email);
        contentValues.put("pass", pass);
        contentValues.put("cpass", cpass);

        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean updateuserdata(String fname,String lname,String email, String pass, String cpass)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("lname", lname);
        contentValues.put("fname", fname);
        contentValues.put("email", email);
        contentValues.put("pass", pass);
        contentValues.put("cpass", cpass);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where fname = ?", new String[]{fname});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "fname=?", new String[]{fname});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
}