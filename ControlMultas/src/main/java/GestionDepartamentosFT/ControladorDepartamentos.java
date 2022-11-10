package GestionDepartamentosFT;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class ControladorDepartamentos {

    File f;

    public ControladorDepartamentos(File f) {
        this.f = f;
    }

    public void alta(Departamento d) {
        int id = leerUltimoID();
        id++;
        try (FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(id + "," + d.getNombre() + "," + d.getResponsable() + "," + d.getEmpleados() + "," + d.getnPlanta()+ "\n");

        } catch (Exception ex) {

        }
    }
    public void baja(int id){
          File aux = new File("aux.txt");
        try (FileReader fr = new FileReader(f);
                FileWriter fw = new FileWriter(aux);
                BufferedWriter bw = new BufferedWriter(fw);
                BufferedReader br = new BufferedReader(fr);) {
            String linea;
            String auxBaja;
            while ((linea = br.readLine()) != null) {
                auxBaja=linea;
                String registro[] = linea.split(",");
                if (Integer.parseInt(registro[0]) == id) {   
                }else{
                    bw.write(auxBaja+"\n");
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR I/O");
        }
        aux.renameTo(f);
    }

    public int leerUltimoID() {
        int n;
        File f = new File("departamentos.txt");
        String temp = null;

        try (FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                temp = linea;
            }
            String[] registros= temp.split(",");
            temp= registros[0];
            return Integer.parseInt(temp);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public void modificarDepartamento(Departamento d) {
        File aux = new File("aux.txt");
        try (FileReader fr = new FileReader(f);
                FileWriter fw = new FileWriter(aux);
                BufferedWriter bw = new BufferedWriter(fw);
                BufferedReader br = new BufferedReader(fr);) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String registro[] = linea.split(",");
                if (Integer.parseInt(registro[0]) == d.getId()) {
                    bw.write(d.getId() + "," + d.getNombre() + "," + d.getResponsable() + "," + d.getEmpleados()+ "," +d.getnPlanta());
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR I/O");
        }
    }

    public void consultaTodosDepartamentos() {
        String linea;
        try (FileReader fr = new FileReader(this.f);
                BufferedReader br = new BufferedReader(fr);) {
            while ((linea = br.readLine()) != null) {
                String[] lineas = linea.split(",");
                System.out.println("ID: " + lineas[0] + " //NOMBRE: " + lineas[1] + " //RESPONSABLE: " + lineas[2] + " //EMPLEADOS: " + lineas[3]+ " //NUMERO PLANTA: " +lineas[4]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultaDepartamentoPorID(int id) {
        boolean existe = false;
        String linea;
        try (FileReader fr = new FileReader(this.f);
                BufferedReader br = new BufferedReader(fr);) {
            while ((linea = br.readLine()) != null) {
                String[] lineas = linea.split(",");
                if (Integer.parseInt(lineas[0]) == id) {
                System.out.println("ID: " + lineas[0] + " //NOMBRE: " + lineas[1] + " //RESPONSABLE: " + lineas[2] + " //EMPLEADOS: " + lineas[3]+ " //NUMERO PLANTA: " +lineas[4]);
                    existe = true;

                }

            }
            if (!existe) {
                System.out.println("No existe el departamento " + id + ".");
            }

        } catch (Exception e) {
        }
    }
}
