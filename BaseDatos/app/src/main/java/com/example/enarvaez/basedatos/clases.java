package com.example.enarvaez.basedatos;

public class Clases {
    private  String nombre;
    private  String correo;
    private  String barrio;
    private  String email;
    private  String departamento;
    private  String Municipio;
    private String Contrasena;
    private String rcontrasena;

    public Clases() {


    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public void setRcontrasena(String rcontrasena) {
        this.rcontrasena = rcontrasena;
    }







    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public String getRcontrasena() {
        return rcontrasena;
    }


}