package com.cesartejero.ejercicio_dialogos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio2 extends AppCompatActivity implements MiDialogoEjercicio2.MiDialogoListener {
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        EditText editTextnombre = findViewById(R.id.editTextEj2Nombre);
        Button btnAceptar = findViewById(R.id.btnEj2Aceptar);
        Button btnVolver = findViewById(R.id.btnEj2Volver);
        label = findViewById(R.id.tvwEj2Asignatura);

        DialogFragment selectDialog = new MiDialogoEjercicio2();
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextnombre.getText().toString().equals("")) {
                    Toast.makeText(Ejercicio2.this, R.string.ToastEj2NoName, Toast.LENGTH_LONG).show();
                } else {
                    Bundle bundle=new Bundle();
                    bundle.putString("title", editTextnombre.getText().toString());
                    selectDialog.setArguments(bundle);
                    selectDialog.show(getSupportFragmentManager(), "Asignatura");
                }
            }
        });

        btnVolver.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }

    @Override
    public void onDialogResult(String opcion) {
        label.setText("Has escogido: " + opcion);
    }
}