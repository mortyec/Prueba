package com.example.app_002;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    private TextView textViewTitulo;

    private int codigoRequerido = 1; //para pasar entre actividades

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        textViewTitulo = findViewById(R.id.textViewTitulo);

        //recibir los datos pasados en el intent (MainActivity)
        Bundle datosExtra =  getIntent().getExtras();

        String nombre = datosExtra.getString("key_nombre");
        String apellido = datosExtra.getString("key_apellido");

        textViewTitulo.setText("Bienvenido: "+ nombre + " " + apellido + " a Android");
    }

    public void onClicNavegadorWeb(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);

    }

    public void onClicLlamar(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+593999051864"));
        startActivity(intent);
    }

    public void onClicMostrar(View view)
    {
        Intent intent =  new Intent(this, TercerActivity.class);
        //startActivity(intent);

        //Para permitir regresar datos
        startActivityForResult(intent, codigoRequerido);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //obtener los datos regresados desde la ventana hija
        if((requestCode == codigoRequerido) && (resultCode == RESULT_OK))
        {
            textViewTitulo.setText("Valor seleccionado en la actividad hija: " + data.getDataString());
        }


    }
}