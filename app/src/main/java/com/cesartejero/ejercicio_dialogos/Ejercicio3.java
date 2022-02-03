package com.cesartejero.ejercicio_dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio3 extends AppCompatActivity implements MiDialogoEjercicio3.MiDialogoListener {
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        label = findViewById(R.id.tvwEj3Fecha);

        MiDialogoEjercicio3 fechaDialog = new MiDialogoEjercicio3();
        Button btnFecha = findViewById(R.id.btnEj3Fecha);
        btnFecha.setOnClickListener(view -> fechaDialog.show(getSupportFragmentManager(), "Fecha"));

        Button btnVolver = findViewById(R.id.btnEj3Volver);
        btnVolver.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }

    @Override
    public void onDialogResult(Date fecha) {
        DateFormat soloFecha = SimpleDateFormat.getDateInstance();
        label.setText(soloFecha.format(fecha));
    }
}