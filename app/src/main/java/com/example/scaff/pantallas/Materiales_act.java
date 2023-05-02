package com.example.scaff.pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.scaff.Costo_con_envio;
import com.example.scaff.Costo_sin_envio;
import com.example.scaff.R;
import com.example.scaff.Registro_materiales;

public class Materiales_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiales);
    }
    public void irRegistroMat(View view) {
        Intent intent = new Intent(Materiales_act.this, Registro_materiales.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void irMaquinariaMat(View view) {
        Intent intent = new Intent(Materiales_act.this, Maquinaria_act.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void irCostoSinEnvio(View view){
        Intent intent = new Intent(Materiales_act.this, Costo_sin_envio.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void irCostoConEnvio(View view){
        Intent intent = new Intent(Materiales_act.this, Costo_con_envio.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}