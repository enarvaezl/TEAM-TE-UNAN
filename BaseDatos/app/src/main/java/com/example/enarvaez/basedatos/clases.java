package com.example.enarvaez.basedatos;

public class clases {

  public  String clasid;
   public  String Seccion;
    public String Area;
   public  String Tema;



    public clases(String Cid,String S,String A,String T) {
        this.clasid=Cid;
        this.Seccion=S;
        this.Area=A;
        this.Tema=T;

    }

    public String getClasid() {
        return clasid;
    }

    public String getSeccion() {
        return Seccion;
    }

    public String getArea() {
        return Area;
    }

    public String getTema() {
        return Tema;
    }

}