package com.example.scaff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.example.scaff.entidades.Maquina;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "db";
    private static final String DB_TABLE = "maquinas_tabla";
    //columnas
    private static final String ID = "Id";
    private static final String NAME = "Nombre";

    private static final String CREATE_TABLE = "CREATE TABLE "+ DB_TABLE+ "("+
            ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME + "TEXT "+")";

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL("CREATE TABLE materiales(nombre_mat text, costo_mat real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);

        onCreate(db);
    }
    public boolean materialExiste(String nombre_mat) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = { "nombre_mat" };
        String selection = "nombre_mat = ?";
        String[] selectionArgs = { nombre_mat };
        Cursor cursor = db.query("materiales", projection, selection, selectionArgs, null, null, null);
        boolean existe = (cursor.getCount() > 0);
        cursor.close();
        return existe;
    }

    public boolean insertData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);

        long result = db.insert(DB_TABLE, null, contentValues);

        return result != -1;
    }

    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from "+DB_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }
}
