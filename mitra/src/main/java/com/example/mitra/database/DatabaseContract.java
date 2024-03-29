package com.example.mitra.database;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    public static final String TABLE_USER = "users";
    public static final String AUTHORITY = "com.dsc.lapak";
    public static final String SCHEME = "content";

    public static final Uri CONTENT_URI_USER = new Uri.Builder().scheme(SCHEME)
            .authority(AUTHORITY)
            .appendPath(TABLE_USER)
            .build();

    public static final class userColoumn implements BaseColumns {
        public static String ID = "id";
        public static String USER_NAME = "user_name";
        public static String USER_LEVEL = "user_level";
        public static String USER_WALLET = "user_wallet";
        public static String EMAIL = "email";
        public static String PASSWORD = "password";
    }

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

}

