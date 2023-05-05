package com.example.scaff.pantallas;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.scaff.ConexionSQLiteHelper;
import com.example.scaff.R;
import com.example.scaff.Registro_materiales;

import java.util.ArrayList;

public class Maquinaria_act extends AppCompatActivity {
    ConexionSQLiteHelper db;

    Button add_data;
    EditText add_name;
    ListView userlist;
    ArrayList<String> listItem;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquinaria);

        db = new ConexionSQLiteHelper(this, "db", null, 1);

        listItem = new ArrayList<>();

        add_data = findViewById(R.id.agregar_maquina);
        add_name = findViewById(R.id.nombre_maquina);
        userlist = findViewById(R.id.lv1);

        viewData();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = userlist.getItemAtPosition(position).toString();
                Toast.makeText(Maquinaria_act.this,""+text, Toast.LENGTH_SHORT).show();

            }
        });

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_name.getText().toString();
                if(!name.equals("") && db.insertData(name)){
                    Toast.makeText(Maquinaria_act.this, "Maquina agregada", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    viewData();
                }
                else{
                    Toast.makeText(Maquinaria_act.this, "Maquina no agregada", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void irMaterialMaq(View view) {
        Intent intent = new Intent(Maquinaria_act.this, Materiales_act.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void irRegistroMaq(View view) {
        Intent intent = new Intent(Maquinaria_act.this, Registro_materiales.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);    }
    public void volver(View view) {

        finish();
    }

    private void viewData(){
        Cursor cursor = db.viewData();

        if(cursor.getCount()==0){
            Toast.makeText(this, "No hay datos que mostrar", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
    }

}