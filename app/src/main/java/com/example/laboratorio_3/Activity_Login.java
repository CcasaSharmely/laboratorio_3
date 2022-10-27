// Clase MainActivity
package com.example.laboratorio_3;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_Login extends AppCompatActivity {

    EditText  nick,contrasena;
    Button login;
    ArrayList<Operador> Operadores = new ArrayList<>();
    Operador auxOperador;

    private void initialize_Operadores(){
        Operadores.add(new Operador("admin","1234"));
        Operadores.add(new Operador("user","1234"));
    }
    private boolean find_Operador(Operador op){
        boolean exist=false;
        for (int i = 0; i < Operadores.size(); ++i){
            if (op.nick.equals( Operadores.get(i).nick) && op.password.equals( Operadores.get(i).password))
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize_Operadores();

        nick = (EditText) findViewById(R.id.nicknameedt);
        contrasena = (EditText) findViewById(R.id.contrasenaedt);
        login = (Button) findViewById(R.id.loginbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auxOperador= new Operador(nick.getText().toString(), contrasena.getText().toString());
                if (find_Operador(auxOperador)==true){
                    Log.d(TAG, "Login realizado con éxito "+auxOperador+"!");
                    Intent i    = new Intent(Activity_Login.this,Activity_Menu.class);
                    i.putExtra("nicknametv",auxOperador.nick);

                    startActivity(i);
                }
                else{
                    Log.d(TAG, "Usuario no existe o la contraseña es incorrecta !");
                    nick.setText("");
                    contrasena.setText("");
                }
            }

        });

    }
}