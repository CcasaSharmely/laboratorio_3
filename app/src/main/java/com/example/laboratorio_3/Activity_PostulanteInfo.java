// Clase MainActivity
package com.example.laboratorio_3;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_PostulanteInfo extends AppCompatActivity {

    TextView  dni,nombres,apellidos,fechanac,colegio,carrera;
    EditText dnibuscar;
    Button buscar;
    Button regresar;
    Alumno AlumnoHallado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteinfo);
        dnibuscar = (EditText) findViewById(R.id.dnied);
        dni = (TextView) findViewById(R.id.dnitv);
        nombres = (TextView) findViewById(R.id.nombretv);
        apellidos = (TextView)  findViewById(R.id.apellidotv);
        fechanac = (TextView) findViewById(R.id.fechanactv);
        colegio = (TextView) findViewById(R.id.colegiotv);
        carrera = (TextView) findViewById(R.id.carreratv);

        buscar = (Button) findViewById(R.id.buscarbtn);
        regresar = (Button) findViewById(R.id.regresarbtn);

        try{
            AlumnoHallado = (Alumno) getIntent().getSerializableExtra("alumnoencontrado");
            if (AlumnoHallado!=null){
                Log.d(TAG, "alumno recibido! "+AlumnoHallado);
                dnibuscar.setEnabled(false);
                buscar.setEnabled(false);
                dni.setText(AlumnoHallado.DNI);
                nombres.setText(AlumnoHallado.nombres);
                apellidos.setText(AlumnoHallado.aPaterno+" "+AlumnoHallado.aMaterno);
                fechanac.setText(AlumnoHallado.fecNacimiento);
                colegio.setText(AlumnoHallado.colProcedencia);
                carrera.setText(AlumnoHallado.Postula);
            }

        }catch(Exception e){
            Log.d(TAG, "error en alumno! ");
        }

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("dnialumno", dnibuscar.getText().toString());
                setResult(3,intent);
                finish();

            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }
}