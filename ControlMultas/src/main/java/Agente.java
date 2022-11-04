/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dev
 */
public class Agente {

    private int id;
    private StringBuilder nombre;

    public Agente(int id, String nombre) {
        this.id = id;
        setNombre(nombre);
    }

    @Override
    public String toString() {
        return "Agente{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringBuilder getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = new StringBuilder(nombre);
        this.nombre.setLength(25);
    }
    public static int getSize(){
        return 54;
    }

}
