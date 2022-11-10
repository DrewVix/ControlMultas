package GestionDepartamentosRAF;


import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dev
 */
public class Departamento implements Serializable{
    
    private StringBuilder nombre;
    private StringBuilder responsable;
    private int empleados;
    private int nPlanta;
       private StringBuilder puerta;
    private boolean eliminado;

    public Departamento(String nombre, String responsable, int empleados, int nPlanta,String puerta) {
       
        setNombre (nombre);
        setResponsable(responsable);
        this.empleados = empleados;
        this.nPlanta = nPlanta;
        setPuerta(puerta);
        this.eliminado= false;
    }

    public Departamento(String nombre, String responsable, int empleados, int nPlanta,String puerta, boolean eliminado) {
        
        setNombre (nombre);
        setResponsable(responsable);
        this.empleados = empleados;
        this.nPlanta = nPlanta;
        setPuerta(puerta);
        this.eliminado = eliminado;
    }

    public StringBuilder getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = new StringBuilder (puerta);
        this.puerta.setLength(5);
    }
    

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado() {
        this.eliminado = true;
    }
    

    public StringBuilder getNombre() {
        this.nombre.setLength(50);
        return this.nombre;
    }

    public StringBuilder getResponsable() {
        this.responsable.setLength(30);
        return this.responsable;
    }

    public int getEmpleados() {
        return empleados;
    }

    public int getnPlanta() {
        return nPlanta;
    }


    public void setNombre(String nombre) {
        this.nombre = new StringBuilder (nombre);
        
    }

    public void setResponsable(String responsable) {
        this.responsable = new StringBuilder (responsable);
        
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    public void setnPlanta(int nPlanta) {
        this.nPlanta = nPlanta;
    }
    
    public static int getSize(){
        return 179;
    }

    @Override
    public String toString() {
        return "Departamento{" + "nombre=" + nombre + ", responsable=" + responsable + ", empleados=" + empleados + ", nPlanta=" + nPlanta + ", puerta=" + puerta + ", eliminado=" + eliminado + '}';
    }

    
    
}
