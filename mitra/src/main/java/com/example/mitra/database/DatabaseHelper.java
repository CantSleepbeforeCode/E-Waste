package com.example.mitra.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "LAPAK";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_TABLE_USERS = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_USER,
            DatabaseContract.userColoumn.ID,
            DatabaseContract.userColoumn.USER_NAME,
            DatabaseContract.userColoumn.USER_LEVEL,
            DatabaseContract.userColoumn.USER_WALLET,
            DatabaseContract.userColoumn.EMAIL,
            DatabaseContract.userColoumn.PASSWORD);

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_USER);
        onCreate(sqLiteDatabase);
    }
}

