package com.example.scaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.scaff.pantallas.Materiales_act;

public class Costo_con_envio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costo_con_envio);
    }
    public void irEnvioMat(View view) {
        Intent intent = new Intent(Costo_con_envio.this, Envio_act.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void volver(View view) {

        finish();
    }

}