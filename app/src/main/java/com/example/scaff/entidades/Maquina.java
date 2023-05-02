package com.example.scaff.entidades;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.scaff.ConexionSQLiteHelper;

import java.util.UUID;

public class Maquina {
    private String id_maquina;
    private String nombre;
    private String descrip;
    private String cliente;
    private String meses;

    public Maquina(String id_maquina,
                   String nombre, String descrip,
                   String cliente, String meses) {
        this.id_maquina = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descrip = descrip;
        this.cliente = cliente;
        this.meses = meses;
    }

    @SuppressLint("Range")
    public Maquina(Cursor cursor) {
        id_maquina = cursor.getString(cursor.getColumnIndex(ConexionSQLiteHelper.MaquinaEntry.ID_MAQUINA));
        nombre = cursor.getString(cursor.getColumnIndex(ConexionSQLiteHelper.MaquinaEntry.NOMBRE));
        descrip = cursor.getString(cursor.getColumnIndex(ConexionSQLiteHelper.MaquinaEntry.DESCRIP));
        cliente = cursor.getString(cursor.getColumnIndex(ConexionSQLiteHelper.MaquinaEntry.CLIENTE));
        meses = cursor.getString(cursor.getColumnIndex(ConexionSQLiteHelper.MaquinaEntry.CLIENTE));

    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ConexionSQLiteHelper.MaquinaEntry.ID_MAQUINA, id_maquina);
        values.put(ConexionSQLiteHelper.MaquinaEntry.NOMBRE, nombre);
        values.put(ConexionSQLiteHelper.MaquinaEntry.DESCRIP, descrip);
        values.put(ConexionSQLiteHelper.MaquinaEntry.CLIENTE, cliente);
        values.put(ConexionSQLiteHelper.MaquinaEntry.MESES, meses);

        return values;
    }

    public String getId_maquina() {
        return id_maquina;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescrip() {
        return descrip;
    }
    public String getCliente() {
        return cliente;
    }
    public String getMeses() {
        return meses;
    }}

