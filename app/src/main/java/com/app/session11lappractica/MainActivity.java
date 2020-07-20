package com.app.session11lappractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ir_a_listar(View v){
        Intent i =new Intent(this,ListarAluActivity.class);
        startActivity(i);
    }

    public void ir_a_Agregar(View v){
        Intent i =new Intent(this,AgregarAluActivity.class);
        startActivity(i);
    }

    public void ir_a_Editar(View v){
        Intent i =new Intent(this,EditAluActivity2.class);
        startActivity(i);
    }

    public void ir_a_eliminar(View v){
        Intent i =new Intent(this,ListarAluActivity.class);
        startActivity(i);
    }

}