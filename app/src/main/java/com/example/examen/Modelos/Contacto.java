package com.example.examen.Modelos;

public class Contacto {
    private String Nombre;
    private Telefono Tel;

    public Contacto(String nombre, Telefono tel) {
        Nombre = nombre;
        Tel = tel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Telefono getTel() {
        return Tel;
    }

    public void setTel(Telefono tel) {
        Tel = tel;
    }
}
