package com.cesartejero.ejercicio_dialogos;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Ejercicio1 extends AppCompatActivity implements MiDialogoEjercicio1.MiDialogoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        DialogFragment cerrarDialog = new MiDialogoEjercicio1();
        Button btnCerrar = findViewById(R.id.btnEj1Salir);
        btnCerrar.setOnClickListener(view -> cerrarDialog.show(getSupportFragmentManager(), "Cerrar"));
    }

    void CerrarAplicacion() {
        finish();
    }

    @Override
    public void onDialogResult(boolean devuelto) {
        if(devuelto) CerrarAplicacion();
    }
}