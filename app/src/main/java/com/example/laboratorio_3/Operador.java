package com.example.laboratorio_3;

public class Operador {
    String nick,password;
    public Operador(String nk, String pass){
        this.nick = nk;
        this.password = pass;
    }
    @Override
    public String toString(){
        return this.nick;
    }

}