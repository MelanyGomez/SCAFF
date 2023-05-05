package com.example.scaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scaff.pantallas.Maquinaria_act;
import com.example.scaff.pantallas.Materiales_act;

public class Registro_maquinas extends AppCompatActivity {
    ConexionSQLiteHelper db;
    Button add_data;
    EditText add_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_maquinas);

        db = new ConexionSQLiteHelper(this, "db", null, 1);

        add_data = findViewById(R.id.bt_agregar);
        add_name = findViewById(R.id.ed_nom_maq);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String name = add_name.getText().toString();
                if(!name.equals("") && db.insertData(name)){
                    Toast.makeText(Registro_maquinas.this, "Maquina agregada", Toast.LENGTH_SHORT).show();
                    add_name.setText("");

                }
                else{
                    Toast.makeText(Registro_maquinas.this, "Maquina no agregada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void volver(View view) {

        finish();
    }

    public void irMaquinariaMat(View view) {
        Intent intent = new Intent(Registro_maquinas.this, Maquinaria_act.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
