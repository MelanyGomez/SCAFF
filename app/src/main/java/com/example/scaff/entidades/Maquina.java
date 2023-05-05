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
}



