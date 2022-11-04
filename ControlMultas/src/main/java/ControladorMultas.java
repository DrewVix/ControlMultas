
import java.io.RandomAccessFile;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class ControladorMultas {

    String fichero;

    public ControladorMultas(String fichero) {
        this.fichero = fichero;
    }

    public void alta(Multa m) {
        try {
            RandomAccessFile raf = new RandomAccessFile("multas.dat", "rw");

            raf.seek(raf.length());
            registroMulta(raf, m);
            System.out.println(Multa.getSize());
        } catch (Exception e) {
            e.getMessage();
            System.out.println("FALLO EN ALTA DE MULTA.");
        }

    }

    public void baja(int i) {
        try {
            RandomAccessFile raf = new RandomAccessFile("multas.dat", "rw");
            raf.seek(i * Agente.getSize());
            Multa aux = consultaMultaID(i);
            aux.setActivo(false);
            raf.seek(i * Multa.getSize());
            registroMulta(raf, aux);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL REGISTRO DE LA MULTA.");
        }

    }

    public void registroMulta(RandomAccessFile raf, Multa m) {

        try {

            raf.writeInt(m.getnAgente());
            raf.writeChars(m.getLocalidad().toString());
            raf.writeInt(m.getCoste());
            raf.writeBoolean(m.isPagado());
            raf.writeBoolean(m.isActivo());

        } catch (Exception ex) {
            ex.getMessage();
            System.out.println("FALLO EN REGISTO MULTA.");

        }
    }

    public void modificacion(int i, Multa m) {
        try {
            RandomAccessFile raf = new RandomAccessFile("multas.dat", "rw");
            raf.seek(i * Multa.getSize());
            registroMulta(raf, m);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN LA MODIFICACION DE LA MULTA.");
        }

    }

    public void pagarMulta(int i) {
        try {
            RandomAccessFile raf = new RandomAccessFile("multas.dat", "rw");
            raf.seek(i * Agente.getSize());
            Multa aux = consultaMultaID(i);
            aux.setPagado(true);
            raf.seek(i * Agente.getSize());
            registroMulta(raf, aux);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL PAGO DE LA MULTA.");
        }

    }

    public void consultaAll() {
        try {
            RandomAccessFile raf = new RandomAccessFile("multas.dat", "r");

            double total = raf.length() / Multa.getSize();
            System.out.println(total);

            for (int i = 0; i < total; i++) {
                Multa m = leerMultas(raf);
                if (!m.isPagado()) {
                    System.out.println(i + " " + m.toString());
                }
            }
        } catch (Exception e) {
            e.getMessage();

        }

    }

    public Multa consultaMultaID(int i) {

        try {
            RandomAccessFile raf = new RandomAccessFile("multas.dat", "rw");

            raf.seek(i * Multa.getSize());

            return leerMultas(raf);

        } catch (Exception e) {
            System.out.println("ERROR: NO EXISTE ESA MULTA.");
        }

        return null;

    }

    public Multa leerMultas(RandomAccessFile raf) {
        try {
            int numAgente = raf.readInt();

            byte[] localidadArray = new byte[100];
            raf.read(localidadArray);
            String localidad = new String(localidadArray);

            int coste = raf.readInt();

            boolean pagado = raf.readBoolean();

            boolean activo = raf.readBoolean();

            Multa aux = new Multa(numAgente, localidad, coste, pagado, activo);
            return aux;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL LISTADO DE AGENTES.");
        }
        return null;
    }

}
