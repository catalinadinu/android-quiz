package com.example.catalinadinu.androidquiz.clase;

//baza de date

import android.database.sqlite.SQLiteDatabase;

public class ProfesorBD {
    public static final String TABLE_NAME = "profesori"; // table name
    //public static final String COLUMN_ID = "_id"; // attribute --- also primary key
    public static final String COLUMN_LAST_NAME = "nume"; // attribute
    public static final String COLUMN_FIRST_NAME = "prenume"; // attribute
    public static final String COLUMN_EMAIL = "email"; // attribute
    public static final String COLUMN_PASSWORD = "parola"; // attribute

    private static final String TABLE_CREATE = "create table "
            + TABLE_NAME
            + "("
            + COLUMN_LAST_NAME + " text not null, "
            + COLUMN_FIRST_NAME + " text not null, "
            + COLUMN_EMAIL + " text primary key not null, "
            + COLUMN_PASSWORD + " text not null);";



    public static void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase db,int oldVers,int newVers)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
