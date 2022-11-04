

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class Principal {

    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            String f1 = "agentes.dat";
            String f2 = "multas.dat";
            int op;
            ControladorAgentes ca = new ControladorAgentes(f1);
            //ControladorMultas cm = new ControladorMultas(f2);

            do {
                op = menu(sc);
                switch (op) {
                    case 1:

                        break;

                    case 2:
                        System.out.println("INTRODUZCA NOMBRE DEL AGENTE: ");
                        String nombre = sc.nextLine();
                        ca.alta(new Agente(nombre, false));

                        break;

                    case 3:

                        break;

                    case 4:
                        ca.consultaAll();
                        System.out.println("INTRODUCE EL NUMERO DE AGENTE QUE DESEAS ELIMINAR.");
                        int id = Integer.parseInt(sc.nextLine());
                        ca.baja(id);

                        break;

                    case 5:

                        break;
                    case 6:
                        System.out.println("INTRODUCE EL ID DEL AGENTE QUE DESEA MODIFICAR: ");
                        int id6 = Integer.parseInt(sc.nextLine());
                        System.out.println("INTRODUCE EL NOMBRE DEL AGENTE PARA SU MODIFICACION: ");
                        String nombre6 = sc.nextLine();

                        ca.modificacion(id6, new Agente(nombre6, false));
                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:
                        ca.consultaAll();

                        break;
                    case 10:

                        break;
                    case 11:

                        break;

                    default:
                        System.out.println("INTRODUCE UN VALOR VALIDO.");
                        break;
                }

            } while (op != 12);

        } catch (Exception e) {
        }

    }

    public static int menu(Scanner sc) {
        int menu;

        System.out.println("SELECCIONE LA OPCIÓN:");
        System.out.println("1.CREAR MULTA.");
        System.out.println("2.CREAR AGENTE.");
        System.out.println("3.ELIMINAR MULTA.");
        System.out.println("4.ELIMINAR AGENTE.");
        System.out.println("5.MODIFICAR MULTA.");
        System.out.println("6.MODIFICAR AGENTE.");
        System.out.println("7.PAGAR MULTA.");
        System.out.println("8.CONSULTAR MULTAS PENDIENTES DE PAGAR.");
        System.out.println("9.CONSULTAR TODOS LOS AGENTES.");
        System.out.println("10.CONSULTAR TODAS LAS MULTAS POR NOMBRE DE AGENTE.");
        System.out.println("11.CONSULTAR TODAS LAS MULTAS POR NUMERO DE MULTA.");
        System.out.println("12.SALIR");

        System.out.println("INTRODUZCA UNA OPCION:");
        menu = Integer.parseInt(sc.nextLine());

        return menu;
    }

}
