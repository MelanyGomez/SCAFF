package com.example.scaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Costo_con_envio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costo_con_envio);
    }
    public void irClienteCenv(View view) {
        Intent intent = new Intent(Costo_con_envio.this, Cliente_senv.class);
        startActivity(intent);
    }
}