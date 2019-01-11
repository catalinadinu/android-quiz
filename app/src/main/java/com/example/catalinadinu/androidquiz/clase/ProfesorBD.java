package com.example.catalinadinu.androidquiz.clase;

//baza de date

import android.database.sqlite.SQLiteDatabase;

public class ProfesorBD {
    public static final String TABLE_NAME = "profesori"; // table name
    public static final String COLUMN_ID = "_id"; // attribute --- also primary key
    public static final String COLUMN_LAST_NAME = "nume"; // attribute
    public static final String COLUMN_FIRST_NAME = "prenume"; // attribute
    public static final String COLUMN_EMAIL = "email"; // attribute
    public static final String COLUMN_PASSWORD = "parola"; // attribute

    private static final String TABLE_CREATE = "create table "
            // Here you create the string that you use in order to create that table that you are working with
            + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LAST_NAME + " text not null, "
            + COLUMN_FIRST_NAME + " text not null, "
            + COLUMN_EMAIL + " text not null, "
            + COLUMN_PASSWORD + " text not null);";



    public static void onCreate(SQLiteDatabase db)
    // in onCreate method you give a database object as parameter
    {
        db.execSQL(TABLE_CREATE); // you create the database object using the .execSQL command
        // and give the TABLE_CREATE String as parameter in order to create the table
    }

    public static void onUpgrade(SQLiteDatabase db,int oldVers,int newVers)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); // in the situation that the table exists
        // .execSQL can directly execute queries or execute strings
        // it deletes it

        // here you can have modifications of your local table
        onCreate(db);
        // and it re-writes it by calling onCreate(where you create the table)
    }
}
