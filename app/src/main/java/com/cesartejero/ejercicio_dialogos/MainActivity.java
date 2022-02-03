package com.cesartejero.ejercicio_dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEj1 = findViewById(R.id.btnEj1);
        btnEj1.setOnClickListener(view -> AbrirActivity(Ejercicio1.class));

        Button btnEj2 = findViewById(R.id.btnEj2);
        btnEj2.setOnClickListener(view -> AbrirActivity(MainActivity.class));

        Button btnEj3 = findViewById(R.id.btnEj3);
        btnEj3.setOnClickListener(view -> AbrirActivity(MainActivity.class));
    }

    void AbrirActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}