// Clase MainActivity
package com.example.laboratorio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class Activity_PostulanteRegistro extends AppCompatActivity {

    EditText  aPaterno,aMaterno,nombres,fecNacimiento,colProcedencia,Postula,documento;
    Button registrar;
    Alumno auxAlum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteregistro);

        aPaterno = (EditText) findViewById(R.id.aPaterno);
        aMaterno = (EditText) findViewById(R.id.aMaterno);
        nombres = (EditText) findViewById(R.id.nombres);
        fecNacimiento = (EditText)  findViewById(R.id.fecha);
        colProcedencia = (EditText) findViewById(R.id.colegio);
        Postula = (EditText) findViewById(R.id.carrera);
        documento = (EditText) findViewById(R.id.DNI);

        registrar = (Button) findViewById(R.id.button1);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auxAlum = new Alumno(aPaterno.getText().toString(), aMaterno.getText().toString(),nombres.getText().toString()
                        ,fecNacimiento.getText().toString(),colProcedencia.getText().toString(),Postula.getText().toString(),documento.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("objeto", auxAlum);
                setResult(2,intent);
                aPaterno.setText("");
                aMaterno.setText("");
                nombres.setText("");
                fecNacimiento.setText("");
                colProcedencia.setText("");
                Postula.setText("");
                documento.setText("");
                finish();//finishing activity

            }
        });
    }
}