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

}