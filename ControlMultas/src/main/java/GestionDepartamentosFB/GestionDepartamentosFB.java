package GestionDepartamentosFB;



import java.io.File;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dev
 */
public class GestionDepartamentosFB {
    
    public static void main(String[] args) {
        File f = new File("departamentos.dat");
        Departamento d = new Departamento("it3","raul",10,1); 
        ControladorDepartamento cd= new ControladorDepartamento(f);
        
        //cd.alta(d);
        cd.consultarDepartamentos();
    }
    
}
