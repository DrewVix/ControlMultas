package GestionDepartamentosFB;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class ControladorDepartamento {

    File f;

    public ControladorDepartamento(File f) {
        this.f = f;
    }

    public void alta(Departamento d) {

        if (f.exists()) {
            d.setId(leerUltimoId() + 1);
            try (FileOutputStream fos = new FileOutputStream(f, true);
                    MiObjectOutputStream moos = new MiObjectOutputStream(fos);) {

                moos.writeObject(d);

            } catch (Exception e) {
            }

        } else {
            d.setId(leerUltimoId() + 1);
            try (FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);) {

                oos.writeObject(d);

            } catch (Exception e) {
            }
        }

    }

    public int leerUltimoId() {
        try (FileInputStream fos = new FileInputStream(f);
                ObjectInputStream oos = new ObjectInputStream(fos);) {
            Departamento aux;
            int id = 0;
            try {
                while (true) {
                    aux = (Departamento) oos.readObject();
                    id = aux.getId();
                }
            } catch (Exception e) {

            }
            return id;

        } catch (Exception e) {
        }
        return 0;
    }

    public void consultarDepartamentos() {
        try (FileInputStream fos = new FileInputStream(f);
                ObjectInputStream oos = new ObjectInputStream(fos);) {
            Departamento aux;

            while ((aux = (Departamento) oos.readObject()) != null) {
                System.out.println(aux.toString());
            }

        } catch (Exception e) {
        }
    }

}
