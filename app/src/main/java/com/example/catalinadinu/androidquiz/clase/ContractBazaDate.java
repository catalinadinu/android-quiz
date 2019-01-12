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

public class ContractBazaDate extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "databaseQuiz.sqLite.db";
    private static final int DB_VERS = 1;

    private static final String TAG = ContractBazaDate.class.getSimpleName();
    private Context lContext;

    public ContractBazaDate(Context context){
        super(context, DATABASE_NAME, null, DB_VERS);
        this.lContext = context;
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        ProfesorBD.onCreate(db);
        StudentBD.onCreate(db);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion) {
        ProfesorBD.onUpgrade(db, oldVersion, newVersion);
        StudentBD.onUpgrade(db, oldVersion, newVersion);
    }

    public void insertProf () {
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

    public void insertStud () {
        SQLiteDatabase db = this.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

        for(UtilizatorStudent student : InregistrareProfilStudent.studenti){
            ContentValues cv = new ContentValues(); // Creates an empty set of values using the default initial size
            cv.put(StudentBD.COLUMN_LAST_NAME, student.getNume());
            cv.put(StudentBD.COLUMN_FIRST_NAME, student.getPrenume());
            cv.put(StudentBD.COLUMN_EMAIL, student.getEmail());
            cv.put(StudentBD.COLUMN_PASSWORD, student.getParola());
            long result = db.insert(StudentBD.TABLE_NAME, null, cv);

            //Log.d("CACA", "Inserted value: " + result);
            Toast.makeText(lContext, "Inserted value:" + result, Toast.LENGTH_LONG).show();
        }
    }

    public Cursor getProfDataCursor () // pointer / sort of a query
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ProfesorBD.TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }


    public Cursor getInregistrareDataProfCursor (String email) // pointer / sort of a query
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] array=new String[]{email};
        Cursor cursor = db.rawQuery("SELECT email, parola FROM profesori WHERE email=?",array);
        return cursor;
    }

    public Cursor getStudDataCursor ()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(StudentBD.TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }

    public void deleteProfItembyId (Long id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = new String[]{id.toString()};
        int result = db.delete(ProfesorBD.TABLE_NAME, "_id=? ", args);
        Log.d(TAG, "Item Deleted");
    }

    public void deleteStudItembyId (Long id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = new String[]{id.toString()};
        int result = db.delete(StudentBD.TABLE_NAME, "_id=? ", args);
        Log.d(TAG, "Item Deleted");
    }
}
