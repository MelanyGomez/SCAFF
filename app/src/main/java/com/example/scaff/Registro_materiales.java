package com.example.scaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_materiales extends AppCompatActivity {
    public EditText et_nombre_mat, et_costo_mat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_materiales);

        et_nombre_mat = (EditText)findViewById(R.id.ed_nom_mat_reg);
        et_costo_mat = (EditText)findViewById(R.id.ed_cos_mat_reg);
    }

    public void Registrar_mat (View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this,"administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String nombre_mat = et_nombre_mat.getText().toString();
        String costo_mat = et_costo_mat.getText().toString();

        if(!nombre_mat.isEmpty() && !costo_mat.isEmpty()){
            if(admin.materialExiste(nombre_mat)){
                Toast.makeText(this, "El material con nombre "+nombre_mat+" ya existe", Toast.LENGTH_SHORT).show();
            }else{
                ContentValues registro_mat = new ContentValues();
                registro_mat.put("nombre_mat", nombre_mat);
                registro_mat.put("costo_mat", costo_mat);
                BaseDeDatos.insert("materiales",null,registro_mat);
                et_nombre_mat.setText("");
                et_costo_mat.setText("");
                BaseDeDatos.close();
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, nombre_mat+costo_mat,Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    public void consultar(View view) {
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String nom_mat = et_nombre_mat.getText().toString();
        if (!nom_mat.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery("SELECT costo_mat FROM materiales32222222222 WHERE nombre_mat='"+nom_mat+"'", null);
            if (fila.moveToFirst()) {
                et_costo_mat.setText(fila.getString(0));
            } else {
                Toast.makeText(getApplicationContext(), "No existe el material", Toast.LENGTH_SHORT).show();
            }
            fila.close();
        } else {
            Toast.makeText(getApplicationContext(), "Debes introducir el nombre del material", Toast.LENGTH_SHORT).show();
        }
        BaseDeDatos.close();
    }

    public void volver_mat(View view) {

        finish();
    }

}