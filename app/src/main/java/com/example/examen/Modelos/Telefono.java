package com.example.examen.Modelos;

public class Telefono {
    private String Numero;
    private String Lada;

    public String getNumero() {
        return Numero;
    }
    public String getNumeroCompleto() {
        return Lada + Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getLada() {
        return Lada;
    }

    public void setLada(String lada) {
        Lada = lada;
    }

    public Telefono(String numero, String lada) {
        Numero = numero;
        Lada = lada;
    }
}
