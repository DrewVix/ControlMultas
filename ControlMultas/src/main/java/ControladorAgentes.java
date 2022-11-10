
import java.io.RandomAccessFile;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class ControladorAgentes {

    private String fichero;
    private final String permisoRW = "rw";
    private final String permisoR = "r";

    public ControladorAgentes(String fichero) {
        this.fichero = fichero;
    }

    public void alta(Agente a) {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {

            raf.seek(raf.length());
            registroAgente(raf, a);
            System.out.println(Agente.getSize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("FALLO EN ALTA DE AGENTE.");
        }

    }

    public void baja(int i) {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {
            raf.seek(i * Agente.getSize());
            Agente aux = consultaAgenteID(i);
            aux.setBorrado(true);
            raf.seek(i * Agente.getSize());
            registroAgente(raf, aux);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL REGISTRO DEL AGENTE.");
        }

    }

    public void modificacion(int i, Agente a) {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {
            raf.seek(i * Agente.getSize());
            registroAgente(raf, a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR EN LA MODIFICACION DEL AGENTE.");
        }

    }

    public void registroAgente(RandomAccessFile raf, Agente a) {

        try {

            raf.writeChars(a.getNombre().toString());
            raf.writeBoolean(a.isBorrado());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("FALLO EN REGISTO AGENTE.");

        }
    }

    public void consultaAll() {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoR);) {

            double total = raf.length() / Agente.getSize();
            System.out.println(total);

            for (int i = 0; i < total; i++) {
                Agente a = leerAgentes(raf);
                if (!a.isBorrado()) {
                    System.out.println(i + " " + a.toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public Agente leerAgentes(RandomAccessFile raf) {
        try {
            byte[] nombreArray = new byte[50];
            raf.read(nombreArray);
            String nombre = new String(nombreArray);

            boolean eliminado = raf.readBoolean();

            Agente aux = new Agente(nombre, eliminado);
            return aux;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR EN EL LISTADO DE AGENTES.");
        }
        return null;
    }

    public Agente consultaAgenteID(int i) {

        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoR);) {

            raf.seek(i * Agente.getSize());

            return leerAgentes(raf);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR: NO EXISTE ESE AGENTE.");
        }

        return null;

    }

}
