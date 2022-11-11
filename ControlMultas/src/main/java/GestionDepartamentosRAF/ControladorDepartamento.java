package GestionDepartamentosRAF;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class ControladorDepartamento {

    private String fichero;

    public ControladorDepartamento(String fichero) {
        this.fichero = fichero;
    }

    public void alta(Departamento d) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile("departamentos.dat", "rw");
        raf.seek(raf.length());
        escribirDepartamento(raf, d);

    }

    public void baja(int i) {
        try {
            RandomAccessFile raf = new RandomAccessFile("departamentos.dat", "rw");
        raf.seek(i * Departamento.getSize());
        Departamento aux = consultaDepartamento(i);
        aux.setEliminado();
        raf.seek(i * Departamento.getSize());
        escribirDepartamento(raf, aux); 
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
       

    }

    public Departamento consultaDepartamento(int i) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile("departamentos.dat", "rw");
        try {

            raf.seek(i * Departamento.getSize());

            return leerDepartamento(raf);

        } catch (Exception e) {
            System.out.println("ERROR: NO EXISTE ESE DEPARTAMENTO.");
        }

        return null;

    }

    public void modificacion(int i, Departamento d) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile("departamentos.dat", "rw");
        raf.seek(i * Departamento.getSize());
        escribirDepartamento(raf, d);

    }

    public void consultaPorID(int i) throws FileNotFoundException, IOException {
        Departamento aux = consultaDepartamento(i);
        if (!aux.isEliminado()) {
            System.out.println(i+ "| NOMBRE: " + aux.getNombre() + " | RESPONSABLE: " + aux.getResponsable() + " | EMPLEADO: " + aux.getEmpleados() + " | PLANTA: " + aux.getnPlanta()+ " |PUERTA: "+ aux.getPuerta());

        }
    }

    public void consultaAll() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile("departamentos.dat", "r");

        double total = raf.length() / Departamento.getSize();
        System.out.println(total);

        for (int i = 0; i < total; i++) {
            Departamento d = leerDepartamento(raf);
            if (!d.isEliminado()) {
                System.out.println(i+" "+d.toString());
            }
        }

    }

    public void tamanoFichero() {
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("departamentos.dat", "r");
            System.out.println(raf.length());
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }

    public void escribirDepartamento(RandomAccessFile raf, Departamento d) {

        try {

            raf.writeChars(d.getNombre().toString());
            raf.writeChars(d.getResponsable().toString());
            raf.writeInt(d.getEmpleados());
            raf.writeInt(d.getnPlanta());
            raf.writeChars(d.getPuerta().toString());
            raf.writeBoolean(d.isEliminado());

        } catch (IOException ex) {

        }
    }

    public Departamento leerDepartamento(RandomAccessFile raf) throws IOException {

        byte[] nombreArray = new byte[100];
        raf.read(nombreArray);
        String nombre = new String(nombreArray);

        byte[] responsableArray = new byte[60];
        raf.read(responsableArray);
        String responsable = new String(responsableArray);

        int empleados = raf.readInt();
        int planta = raf.readInt();

        byte[] Npuerta = new byte[10];
        raf.read(Npuerta);
        String puerta = new String(Npuerta);

        boolean eliminado = raf.readBoolean();

        Departamento aux = new Departamento(nombre, responsable, empleados, planta, puerta,eliminado);
        return aux;

    }
}
