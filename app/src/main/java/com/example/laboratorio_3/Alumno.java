package com.example.laboratorio_3;

import java.io.Serializable;

public class Alumno implements Serializable {
    String aPaterno,aMaterno,nombres,fecNacimiento,colProcedencia,Postula,DNI;
    public Alumno(){}
    public Alumno(String ap, String am, String name, String fecNac, String colPro, String Postula, String dni){
        this.aPaterno = ap;
        this.aMaterno = am;
        this.nombres = name;
        this.fecNacimiento = fecNac;
        this.colProcedencia = colPro;
        this.Postula = Postula;
        this.DNI = dni;
    }
    @Override
    public String toString(){
        return this.aPaterno+", "+this.aMaterno+", "+this.nombres+", "+this.fecNacimiento+", "+this.colProcedencia+", "+this.Postula+", "+this.DNI;
    }

}