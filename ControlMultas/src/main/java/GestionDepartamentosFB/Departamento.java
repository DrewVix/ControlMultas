package GestionDepartamentosFB;


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

    private int id;
    private String nombre;
    private String responsable;
    private int empleados;
    private int nPlanta;

    public Departamento(int id, String nombre, String responsable, int empleados,int nPlanta) {
        this.id = id;
        this.nombre = nombre;
        this.responsable = responsable;
        this.empleados = empleados;
        this.nPlanta= nPlanta;
    }
 public Departamento( String nombre, String responsable, int empleados, int nPlanta) {
        
        this.nombre = nombre;
        this.responsable = responsable;
        this.empleados = empleados;
        this.nPlanta= nPlanta;
    }
    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getnPlanta() {
        return nPlanta;
    }

    public void setnPlanta(int nPlanta) {
        this.nPlanta = nPlanta;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + ", empleados=" + empleados + ", nPlanta=" + nPlanta + '}';
    }
    
    
}