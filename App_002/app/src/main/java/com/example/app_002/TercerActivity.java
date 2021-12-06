package com.example.app_002;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TercerActivity extends AppCompatActivity {

    private ListView    listViewDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        listViewDatos = findViewById(R.id.listViewDatos);

        //cargar datos en el listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cargarDatosListView());

        //Asociar el adaptador con el control
        listViewDatos.setAdapter(adapter);

        //Crear el manejador para el evento de item
        listViewDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                //Obtener el item seleccionado
                String seleccionado = listViewDatos.getAdapter().getItem(i).toString();

                //Toast.makeText(getApplicationContext(), seleccionado, Toast.LENGTH_LONG).show();

                //regresar el item seleccionado
                Intent intent = new Intent();
                intent.setData(Uri.parse(seleccionado));

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }

    private List<String> cargarDatosListView()
    {
        List<String> lista = new ArrayList<String>();

        String cadena;
        for(int i=1; i<=18; i++)
        {
           cadena = "Numero: " + i;
           lista.add(cadena);
        }
        return lista;
    }
}