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
    private boolean estado;

    public Agente(String nombre, boolean estado) {

        setNombre(nombre);
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Agente{" + "nombre=" + nombre + '}';
    }
    

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
