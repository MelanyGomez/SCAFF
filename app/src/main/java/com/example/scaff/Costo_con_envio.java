package com.example.scaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scaff.pantallas.Materiales_act;

public class Costo_con_envio extends AppCompatActivity {
    public EditText costo_cenv;
    public EditText cant_cenv;
    public TextView costo_mat_cenv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costo_con_envio);

        costo_cenv=(EditText)findViewById(R.id.ed_cos_mat_cenv);
        cant_cenv=(EditText)findViewById(R.id.ed_cant_mat_cenv);
        costo_mat_cenv=(TextView)findViewById(R.id.tv_total_mat_cenv);
    }
    public void calcular_mat_cenv(View view){
        String costo_senv_String = costo_cenv.getText().toString();
        String cant_senv_String = cant_cenv.getText().toString();

        if(costo_senv_String.isEmpty() || cant_senv_String.isEmpty()){
            Toast.makeText(this, "Por favor ingrese los valores en todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }else{

            int costo_senv_int = Integer.parseInt(costo_senv_String);
            int cant_senv_int = Integer.parseInt(cant_senv_String);

            int total = costo_senv_int * cant_senv_int;

            costo_mat_cenv.setText("El costo total es: " + total);
        }
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