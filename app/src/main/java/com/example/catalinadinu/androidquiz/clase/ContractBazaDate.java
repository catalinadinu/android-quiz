package com.example.catalinadinu.androidquiz.clase;

import android.app.AlertDialog;
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
    public static final String DATABASE_NAME = "databaseAndroidQuiz.sqLite.db";
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

    //INSERT
    public void insertProf () {
        SQLiteDatabase db = this.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

        for(UtilizatorProfesor profesor : InregistrareProfilProfesor.profesori){
            ContentValues cv = new ContentValues(); // Creates an empty set of values using the default initial size
            cv.put(ProfesorBD.COLUMN_LAST_NAME, profesor.getNume());
            cv.put(ProfesorBD.COLUMN_FIRST_NAME, profesor.getPrenume());
            cv.put(ProfesorBD.COLUMN_EMAIL, profesor.getEmail());
            cv.put(ProfesorBD.COLUMN_PASSWORD, profesor.getParola());
            long result = db.insert(ProfesorBD.TABLE_NAME, null, cv);

            Toast.makeText(lContext, "Index valoare adaugata in tabela:" + result, Toast.LENGTH_LONG).show();
        }
    }

    public long insertStud () {
        SQLiteDatabase db = this.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.
        long result=0;
        for(UtilizatorStudent student : InregistrareProfilStudent.studenti){
            ContentValues cv = new ContentValues(); // Creates an empty set of values using the default initial size
            cv.put(StudentBD.COLUMN_LAST_NAME, student.getNume());
            cv.put(StudentBD.COLUMN_FIRST_NAME, student.getPrenume());
            cv.put(StudentBD.COLUMN_EMAIL, student.getEmail());
            cv.put(StudentBD.COLUMN_PASSWORD, student.getParola());
            result = db.insert(StudentBD.TABLE_NAME, null, cv);
            //Toast.makeText(lContext, "Index valoare adaugata in tabela:" + result, Toast.LENGTH_LONG).show();

        }
        return result;
    }

    public Cursor getProfDataCursor () // pointer / sort of a query
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ProfesorBD.TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }


    //SELECT
    public Cursor getInregistrareDataStudCursor (String email) // pointer / sort of a query
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] array=new String[]{email};
        Cursor cursor = db.rawQuery(" SELECT email, parola FROM studenti WHERE email=?",array);
        return cursor;
    }

    public Cursor getStudentBDDataCursor(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] array = new String[]{email};
        Cursor cursor = db.rawQuery(" SELECT nume, prenume, email FROM studenti WHERE email=?",array);
        return cursor;
    }



    //DELETE
    public void deleteProfItembyPK (String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] array = new String[]{email};
        int result = db.delete(ProfesorBD.TABLE_NAME, "email=? ", array);
        //Log.d(TAG, "Item Deleted");
    }

    public void deleteStudItembyPK (String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] array = new String[]{email};
        int result = db.delete(StudentBD.TABLE_NAME, "email=? ", array);
        //Log.d(TAG, "Item Deleted");
    }


    //UPDATE
    public void updateParolaStudent(String email,String parola)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] array = new String[]{email};
        ContentValues contentValues = new ContentValues();
        contentValues.put("parola",parola);
        int result = db.update(StudentBD.TABLE_NAME, contentValues,"email=?",array);
    }
}
