package ControladorMultas;


import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class ControladorMultas {

    private String fichero;
    private final String permisoRW = "rw";
    private final String permisoR = "r";

    public ControladorMultas(String fichero) {
        this.fichero = fichero;
    }

    public void alta(Multa m) {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {

            raf.seek(raf.length());
            registroMulta(raf, m);
            System.out.println(Multa.getSize());
        } catch (Exception e) {
            e.getMessage();
            System.out.println("FALLO EN ALTA DE MULTA.");
        }

    }

    public void baja(int i) {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {
            raf.seek(i * Agente.getSize());
            Multa aux = consultaMultaID(i);
            aux.setBorrado(true);
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
            raf.writeBoolean(m.isBorrado());

        } catch (Exception ex) {
            ex.getMessage();
            System.out.println("FALLO EN REGISTO MULTA.");

        }
    }

    public void modificacion(int i, Multa m) {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {
            raf.seek(i * Multa.getSize());
            registroMulta(raf, m);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN LA MODIFICACION DE LA MULTA.");
        }

    }

    public void pagarMulta(int i) {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {
            raf.seek(i * Agente.getSize());
            Multa aux = consultaMultaID(i);
            aux.setPagado(true);
            aux.setBorrado(true);
            raf.seek(i * Agente.getSize());
            registroMulta(raf, aux);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL PAGO DE LA MULTA.");
        }

    }

    public void consultaAll() {
        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoR);) {

            double total = raf.length() / Multa.getSize();
            System.out.println(total);

            for (int i = 0; i < total; i++) {
                Multa m = leerMultas(raf);
                if (!m.isBorrado() && !m.isPagado()) {
                    System.out.println(i + " " + m.toStringMultas());
                }
            }
        } catch (Exception e) {
            e.getMessage();

        }

    }

    public Multa consultaMultaID(int i) {

        try (RandomAccessFile raf = new RandomAccessFile(this.fichero, permisoRW);) {

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

            boolean borrado = raf.readBoolean();

            Multa aux = new Multa(numAgente, localidad, coste, pagado, borrado);
            return aux;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL LISTADO DE AGENTES.");
        }
        return null;
    }

    public void busquedaPorNombreAgente(String nombre) {
        try (RandomAccessFile raf1 = new RandomAccessFile(this.fichero, permisoR);
                RandomAccessFile raf2 = new RandomAccessFile(this.fichero, permisoR);) {

            int pointerAgente = leerAgentes(raf2, nombre);
            leerMultas10(raf1, pointerAgente);
        } catch (Exception e) {
            e.getMessage();

        }
    }

    public int leerAgentes(RandomAccessFile raf, String nombre) {
        int pointer = -1;
        byte[] nombreArrayOriginal = nombre.getBytes(StandardCharsets.UTF_8);
        String utf8Nombre = new String(nombreArrayOriginal, StandardCharsets.UTF_8);
        try {

            double total = raf.length() / Agente.getSize();
            for (int i = 0; i < total; i++) {
                byte[] nombreArray = new byte[50];
                raf.read(nombreArray);
                String nombreAgente = new String(transformaSoloImpares(nombreArray));
                byte[] nombreArrayAgente = nombreAgente.getBytes(StandardCharsets.UTF_8);
                String utf8NombreAgente = new String(nombreArrayAgente, StandardCharsets.UTF_8);
                boolean eliminado = raf.readBoolean();

                if (utf8Nombre.toString().trim().equalsIgnoreCase(utf8NombreAgente.toString().trim())) {
                    pointer = i;
                }

            }
            return pointer;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL LISTADO DE AGENTES.");

        }
        return -1;
    }

    public void leerMultas10(RandomAccessFile raf, int pointer) {
        System.out.println(pointer);
        try {
            double total = raf.length() / Multa.getSize();
            for (int i = 0; i < total; i++) {
                int numAgente = raf.readInt();

                byte[] localidadArray = new byte[100];
                raf.read(localidadArray);
                String localidad = new String(localidadArray);

                int coste = raf.readInt();

                boolean pagado = raf.readBoolean();

                boolean borrado = raf.readBoolean();

                Multa aux = new Multa(numAgente, localidad, coste, pagado, borrado);

                if (aux.getnAgente() == pointer) {
                    System.out.println(aux.toStringMultas());

                }

            }

        } catch (Exception e) {
            e.getMessage();
            System.out.println("ERROR EN EL LISTADO DE AGENTES.");
        }

    }

    public byte[] transformaSoloImpares(byte[] original) {
        byte[] resultado = new byte[original.length];
        int j = 0;
        for (int i = 0; i < original.length; i++) {
            if (i % 2 != 0) {
                resultado[j] = original[i];
                j++;
            }
        }
        return resultado;
    }

}
