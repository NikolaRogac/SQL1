package com.example.logovanje;

import android.provider.BaseColumns;

public class DbContract
{
    public static final int DATEBASE_VERSION = 1;
    public static final String DATEBASE_NAME = "LOGOVANJE";

    private DbContract()
    {

    }

    public static abstract class TabelaKorisnik implements BaseColumns
    {
        public static final String TABLE_NAME = "Korisnik";
        public static final String COLUMN_NAME_IME = "Korisnicko_ime";
        public static final String COLUMN_NAME_LOZINKA = "Lozinka";

        public static final String SQL_CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_IME + " TEXT," +
                COLUMN_NAME_LOZINKA + " TEXT)";

        public static final String SQL_DELETE_ITEMS_TABLE = "DROP TABLE IF EXIST " + TABLE_NAME;

    }

}
