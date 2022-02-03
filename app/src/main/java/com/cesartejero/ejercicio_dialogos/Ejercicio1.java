package com.cesartejero.ejercicio_dialogos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity implements View.OnClickListener, MiDialogo.MiDialogoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);


        Button btnCerrar = findViewById(R.id.btnEj1Salir);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment cerrarDialog = new MiDialogo();
                cerrarDialog.show(getSupportFragmentManager(), "Cerrar");
            }
        });

        Button btnVolver = findViewById(R.id.btnEj1Volver);
        btnVolver.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }

    void CerrarAplicacion() {
        finish();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onDialogResult(boolean devuelto) {
        if(devuelto) CerrarAplicacion();
    }
}