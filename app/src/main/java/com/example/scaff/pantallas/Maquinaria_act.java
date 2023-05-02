package com.example.scaff.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.scaff.R;
import com.example.scaff.Registro_materiales;

public class Maquinaria_act extends AppCompatActivity {
ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquinaria);
        lv1= (ListView) findViewById(R.id.lv1);

    }

    public void irMaterialMaq(View view) {
        Intent intent = new Intent(Maquinaria_act.this, Materiales_act.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void irRegistroMaq(View view) {
        Intent intent = new Intent(Maquinaria_act.this, Registro_materiales.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void volver(View view) {

        finish();
    }

}