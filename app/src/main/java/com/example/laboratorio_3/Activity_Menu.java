// Clase MainActivity
package com.example.laboratorio_3;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_Menu extends AppCompatActivity {
    Button nuevo, info;
    TextView bienvenido;
    ArrayList<Alumno> registrados = new ArrayList<>();
    Alumno alumnoAguardar;
    Alumno alumnoEncontrado;

    public Alumno find_Alumno(String dni){
        for (int i = 0; i < registrados.size(); ++i){
            if (dni.equals( registrados.get(i).DNI) )
                return registrados.get(i);
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nuevo = (Button) findViewById(R.id.nuevobtn);
        info = (Button) findViewById(R.id.infobtn);
        bienvenido = (TextView) findViewById(R.id.welcometv);
        String bienvenidomsg = getIntent().getStringExtra("nicknametv");
        bienvenido.setText("Bienvenido "+bienvenidomsg);

        ActivityResultLauncher<Intent> registroResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                   Intent data = result.getData();
                   try{
                       alumnoAguardar = (Alumno) data.getSerializableExtra("objeto");
                       registrados.add(alumnoAguardar);
                       Log.d(TAG, "alumno registrado!: "+alumnoAguardar+"!");
                   }catch(Exception e){
                       Log.d(TAG, "no se guardo nada! ");
                   }
                });

        ActivityResultLauncher<Intent> infoResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();
                    try{
                        Log.d(TAG, "DNI recibido!: "+data.getStringExtra("dnialumno")+"!");
                        alumnoEncontrado = find_Alumno(data.getStringExtra("dnialumno"));
                        if (alumnoEncontrado!=null){
                            Intent i    = new Intent(Activity_Menu.this,Activity_PostulanteInfo.class);
                            i.putExtra("alumnoencontrado",alumnoEncontrado);
                            startActivity(i);
                        }
                    }catch(Exception e){
                        Log.d(TAG, "se regreso de forma inesperada! ");
                    }
                });
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i    = new Intent(Activity_Menu.this,Activity_PostulanteRegistro.class);
                registroResultLauncher.launch(i);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i    = new Intent(Activity_Menu.this,Activity_PostulanteInfo.class);
                infoResultLauncher.launch(i);
            }
        });
    }
}