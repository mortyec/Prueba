package com.example.app_002;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellido;
    private Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);

        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //asociar el menu contextual al control: editTextNombre
        registerForContextMenu(editTextNombre);
    }

    public void onClickAceptar(View view)
    {
       String nombre = editTextNombre.getText().toString();
       String apellido = editTextApellido.getText().toString();

       if(!nombre.matches("")&& !apellido.matches(""))
       {
           Intent intent = new Intent(this, SegundoActivity.class);

           intent.putExtra("key_nombre", nombre);
           intent.putExtra("key_apellido", apellido);

           startActivity(intent);
       }
       else
       {
           Toast.makeText(this,"Nombre y apellido son obligatorios", Toast.LENGTH_LONG).show();
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_archivo:
                Toast.makeText(this, "Presiono: Archivo",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, CuartoActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_acercade:
                Toast.makeText(this, "Presiono: Acerca de...",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_editar_copiar:
                Toast.makeText(this, "Presiono: copiar",
                        Toast.LENGTH_LONG).show();
                break;
        }
        //return super.onOptionsItemSelected(item);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual, menu);

    }

    //para al menu contextual
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_contextual_cortar:
                Toast.makeText(this, "Presiono: cortar del menu contextual",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_contextual_copiar:
                Toast.makeText(this, "Presiono: copiar del menu contextual",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_contextual_pegar:
                Toast.makeText(this, "Presiono: pegar del menu contextual",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}