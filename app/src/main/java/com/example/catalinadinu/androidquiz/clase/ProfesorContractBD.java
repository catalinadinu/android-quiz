package com.example.catalinadinu.androidquiz.clase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.catalinadinu.androidquiz.InregistrareProfilProfesor;
import com.example.catalinadinu.androidquiz.InregistrareProfilStudent;


public class ProfesorContractBD extends SQLiteOpenHelper {

        // You create a subclass implementing onCreate(SQLiteDatabase), onUpgrade(SQLiteDatabase, int, int)
        // and optionally onOpen(SQLiteDatabase),
        // and this class takes care of opening the database if it exists, creating it if it does not, and upgrading it as necessary.
        // Transactions are used to make sure the database is always in a sensible state.

        // This class makes it easy for ContentProvider implementations to defer opening

        // sqlLiteOpenHelper is on top of the database --- it manages it

        // CTRL + I implement on upgrade + on create

        // first declare attributes
        // you will need these 2 for the constructor that is required because of the "extends SQLiteOpenHelper"
        public static final String DATABASE_NAME = "demoDatabase.sqLite.db"; // string for the name of the database
        private static final int DB_VERS = 1;

        // DB_VERS
        // int: number of the database (starting at 1);
        // if the database is older, onUpgrade(SQLiteDatabase, int, int) will be used to upgrade the database;
        // if the database is newer, onDowngrade(SQLiteDatabase, int, int) will be used to downgrade the database

        private static final String TAG = ProfesorContractBD.class.getSimpleName(); // TAG for the toast or the Logcat

        private Context lContext; // Context: to use for locating paths to the the database
        // you take the context of the class where you are located


        // Constructor with one attribute , only the context

    public ProfesorContractBD(Context context)// it gets this (the context) as a parameter
        {
            super(context, DATABASE_NAME, null, DB_VERS);
            this.lContext = context;
        }

        //onCreate and onUpgrade are methods that needs to be overrided because of the
        //extends SQLiteOpenHelper; abstract class with these 2 methods
        @Override
        public void onCreate (SQLiteDatabase db)
        {
            ProfesorBD.onCreate(db);
            // Called when the database is created for the first time.
        }

        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion)
        {
            ProfesorBD.onUpgrade(db, oldVersion, newVersion);

            // here you use that shit with the versions
            // it updates by version
            // Called when the database needs to be upgraded.
            // The implementation should use this method to drop tables, add tables,
            // or do anything else it needs to upgrade to the new schema version.
        }

        public void insertSample ()
        {
            SQLiteDatabase db = this.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

            for(UtilizatorProfesor profesor : InregistrareProfilProfesor.profesori){
                ContentValues cv = new ContentValues(); // Creates an empty set of values using the default initial size
                cv.put(ProfesorBD.COLUMN_LAST_NAME, profesor.getNume());
                cv.put(ProfesorBD.COLUMN_FIRST_NAME, profesor.getPrenume());
                cv.put(ProfesorBD.COLUMN_EMAIL, profesor.getEmail());
                cv.put(ProfesorBD.COLUMN_PASSWORD, profesor.getParola());
                long result = db.insert(ProfesorBD.TABLE_NAME, null, cv);

                Log.d("CACA", "Inserted value: " + result);
                Toast.makeText(lContext, "Inserted value:" + result, Toast.LENGTH_LONG).show();
            }



        }

        public Cursor getDataCursor () // pointer / sort of a query
        {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(ProfesorBD.TABLE_NAME, null, null, null, null, null, null);
            // Query the given table, returning a Cursor over the result set.
            return cursor; // you return your fucking result m8
        }

        public void deleteItembyId (Long id)
        // Delete stuff from the database based on the parameter
        //the parameter could have been also a string and so on
        {
            SQLiteDatabase db = this.getWritableDatabase();
            //Create and/or open a database that will be used for reading and writing.

            String[] args = new String[]{id.toString()};
            // string because you can delete more than 1 element from the db

            int result = db.delete(ProfesorBD.TABLE_NAME, "_id=? ", args);
            // Convenience method for deleting rows in the database.
            // Returns an int
            // Table String: the table to delete from (TABLE_NAME)
            // whereClause	String: the optional WHERE clause to apply when deleting. Passing null will delete all rows. ("_id=? ")
            // whereArgs	String[]: You may include ?s in the where clause, which will be replaced by the values from whereArgs.
            // The values will be bound as Strings.

            Log.d(TAG, "Item Deleted");
        }

}
