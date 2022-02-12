package com.example.logovanje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper
{
    public DbHelper(@Nullable Context context)
    {
        super(context, DbContract.DATEBASE_NAME, null, DbContract.DATEBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DbContract.TabelaKorisnik.SQL_CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DbContract.TabelaKorisnik.SQL_DELETE_ITEMS_TABLE);
        onCreate(db);
    }

    public boolean unosPodataka(String korIme,String lozinka)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbContract.TabelaKorisnik.COLUMN_NAME_IME, korIme);
        values.put(DbContract.TabelaKorisnik.COLUMN_NAME_LOZINKA, lozinka);
        long newRowId = db.insert(DbContract.TabelaKorisnik.TABLE_NAME,null,values);
        if (newRowId == -1)
            return false;
        else
            return true;
    }

    public boolean proveraPodataka(String korisnickoIme,String lozinka)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Korisnik where Korisnicko_ime = ? and Lozinka = ?",new String[] {korisnickoIme,lozinka});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

















}
