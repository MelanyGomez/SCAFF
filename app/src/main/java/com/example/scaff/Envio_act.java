package com.example.scaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Envio_act extends AppCompatActivity {

    public EditText costo_km;
    public EditText distancia_km;
    public TextView costo_mat_cenv;
    public TextView costo_env_cenv;
    public TextView costo_total_cenv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);

        costo_km=(EditText)findViewById(R.id.ed_costo_km_cenv);
        distancia_km=(EditText)findViewById(R.id.ed_cant_km_cenv);
        costo_mat_cenv=(TextView)findViewById(R.id.tv_cost_mat_cenv);
        costo_env_cenv=(TextView)findViewById(R.id.tv_cost_env_cenv);
        costo_total_cenv=(TextView)findViewById(R.id.tv_total_cenv);

    }
    public void irClienteCenv(View view) {
        Intent intent = new Intent(Envio_act.this, Cliente_senv.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    public void volver(View view) {

        finish();
    }


    public void calcular_total_cenv(View view){
        String costo_senv_String = costo_km.getText().toString();
        String cant_senv_String = distancia_km.getText().toString();

        if(costo_senv_String.isEmpty() || cant_senv_String.isEmpty()){
            Toast.makeText(this, "Por favor ingrese los valores en todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }else{

            int costo_senv_int = Integer.parseInt(costo_senv_String);
            int cant_senv_int = Integer.parseInt(cant_senv_String);

            int cos_envio = costo_senv_int * cant_senv_int;

            costo_env_cenv.setText("El costo del envio es: " + cos_envio);

        }
    }

}