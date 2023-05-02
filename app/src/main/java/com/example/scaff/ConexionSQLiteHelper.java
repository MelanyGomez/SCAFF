package com.example.scaff;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.example.scaff.entidades.Maquina;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + "maquinas" + " ("
                + MaquinaEntry.ID_MAQUINA + " integer primary key autoincrement,"
                + MaquinaEntry.NOMBRE + " text not null,"
                + MaquinaEntry.DESCRIP + " text not null,"
                + MaquinaEntry.CLIENTE + " text not null,"
                + MaquinaEntry.MESES + "text not null,"
                + "UNIQUE (" + MaquinaEntry.ID_MAQUINA + "))");

        mockData(db);

    }
    private void mockData(SQLiteDatabase db) {
    }
    public static abstract class MaquinaEntry implements BaseColumns {
        public static final String TABLE_NAME ="Maquina";

        public static final String ID_MAQUINA = "id_maquina";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIP = "descrip";
        public static final String CLIENTE = "cliente";
        public static final String MESES = "meses";

    }
    public long mockMaquina(SQLiteDatabase db, Maquina maquina) {
        return db.insert(
                MaquinaEntry.TABLE_NAME,
                null,
                maquina.toContentValues());
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long saveMaquina(Maquina maquina) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                MaquinaEntry.TABLE_NAME,
                null,
                maquina.toContentValues());

    }

    public Cursor getAllMaquinas() {
        return getReadableDatabase()
                .query(
                        MaquinaEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getMaquinaById(String maquinaId) {
        Cursor c = getReadableDatabase().query(
                MaquinaEntry.TABLE_NAME,
                null,
                MaquinaEntry.ID_MAQUINA + "",
                new String[]{maquinaId},
                null,
                null,
                null);
        return c;
    }

    public int deleteMaquina(String maquinaId) {
        return getWritableDatabase().delete(
                MaquinaEntry.TABLE_NAME,
                MaquinaEntry.ID_MAQUINA + "",
                new String[]{maquinaId});
    }

    public int updateMaquina(Maquina maquina, String maquinaId) {
        return getWritableDatabase().update(
                MaquinaEntry.TABLE_NAME,
                maquina.toContentValues(),
                MaquinaEntry.ID_MAQUINA + "",
                new String[]{maquinaId}
        );
    }
}
