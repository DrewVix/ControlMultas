package ControladorMultas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class Agente {

    private StringBuilder nombre;
    private boolean borrado;

    public Agente(String nombre, boolean estado) {

        setNombre(nombre);
        this.borrado = estado;
    }

    @Override
    public String toString() {
        return "| INFORMACION AGENTE" + " ➞ NOMBRE: " + nombre + '|';
    }

    public String toStringParaBorrar() {
        return "| INFORMACION AGENTE: " + "➞ NOMBRE: " + nombre + "| ELIMINADO: " + borrado + " |";
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public StringBuilder getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = new StringBuilder(nombre);
        this.nombre.setLength(25);
    }

    public static int getSize() {
        return 51;
    }

}
