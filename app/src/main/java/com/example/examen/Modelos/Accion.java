package com.example.examen.Modelos;

public class Accion {
    private String accion;
    private String descripcion;
    private int id;
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accion(String accion, String descripcion, int id) {
        this.accion = accion;
        this.descripcion = descripcion;
        this.id = id;
    }
}
