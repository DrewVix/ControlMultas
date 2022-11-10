package ControladorMultas;


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
        Scanner sc = new Scanner(System.in);
        String fileUsuario = System.getProperty("user.home");
        String f1 = fileUsuario + "/agentes.dat";
        String f2 = fileUsuario + "/multas.dat";
        
        try {

            int op;
            ControladorAgentes ca = new ControladorAgentes(f1);
            ControladorMultas cm = new ControladorMultas(f2);

            do {
                op = menu(sc);
                switch (op) {
                    case 1:
                        System.out.println("NUEVA MULTA: ");
                        System.out.println("-------------");
                        System.out.println("INTRODUZCA NUMERO DE AGENTE: ");
                        int nAgente = Integer.parseInt(sc.nextLine());
                        System.out.println("INTRODUZCA LA LOCALIDAD DESDE DONDE SE DETALLA LA MULTA: ");
                        String localidad = sc.nextLine();
                        System.out.println("INTRODUZCA EL COSTE EN EUROS DE LA MULTA: ");
                        int coste = Integer.parseInt(sc.nextLine());

                        cm.alta(new Multa(nAgente, localidad, coste, false, false));

                        break;

                    case 2:
                        System.out.println("ALTA DE AGENTE: ");
                        System.out.println("----------------");
                        System.out.println("INTRODUZCA NOMBRE DEL AGENTE: ");
                        String nombre = sc.nextLine();
                        ca.alta(new Agente(nombre, false));

                        break;

                    case 3:
                        System.out.println("ELIMINAR UNA MULTA: ");
                        System.out.println("--------------------");
                        cm.consultaAll();
                        System.out.println("INTRODUZCA EL NUMERO DE MULTA A ELIMINAR: ");
                        int id3 = Integer.parseInt(sc.nextLine());
                        cm.baja(id3);

                        break;

                    case 4:
                        System.out.println("ELIMINADO DE AGENTES: ");
                        System.out.println("----------------------");
                        ca.consultaAll();
                        System.out.println("INTRODUCE EL NUMERO DE AGENTE QUE DESEAS ELIMINAR.");
                        int id4 = Integer.parseInt(sc.nextLine());
                        ca.baja(id4);

                        break;

                    case 5:
                        System.out.println("MODIFICACION DE MULTA: ");
                        System.out.println("-----------------------");
                        cm.consultaAll();
                        System.out.println("INTRODUCE EL NUMERO DE MULTA QUE DESEA MODIFICAR: ");
                        int id5 = Integer.parseInt(sc.nextLine());
                        System.out.println("INTRODUCE EL NUMERO DEL AGENTE PARA SU MODIFICACION: ");
                        int numAgente6 = Integer.parseInt(sc.nextLine());
                        System.out.println("INTRODUZCA LOCALIDAD PARA SU MODIFICACION: ");
                        String localidad6 = sc.nextLine();
                        System.out.println("INTRODUZCA EL COSTE EN EUROS MODIFICADO: ");
                        int coste6 = Integer.parseInt(sc.nextLine());

                        cm.modificacion(id5, new Multa(numAgente6, localidad6, coste6, false, false));
                        break;

                    case 6:
                        System.out.println("MODIFICACION DE AGENTE: ");
                        System.out.println("------------------------");
                        System.out.println("INTRODUCE EL ID DEL AGENTE QUE DESEA MODIFICAR: ");
                        int id6 = Integer.parseInt(sc.nextLine());
                        System.out.println("INTRODUCE EL NOMBRE DEL AGENTE PARA SU MODIFICACION: ");
                        String nombre6 = sc.nextLine();

                        ca.modificacion(id6, new Agente(nombre6, false));
                        break;

                    case 7:
                        System.out.println("PAGAR UNA MULTA: ");
                        System.out.println("-----------------");
                        cm.consultaAll();
                        System.out.println("INTRODUZCA EL NUMERO DE MULTA A PAGAR: ");
                        int id7 = Integer.parseInt(sc.nextLine());
                        cm.pagarMulta(id7);

                        break;

                    case 8:
                        System.out.println("LISTADO DE MULTAS: ");
                        cm.consultaAll();
                        break;

                    case 9:
                        System.out.println("LISTADO DE AGENTES: ");
                        ca.consultaAll();
                        break;

                    case 10:
                        System.out.println("CONSULTAR MULTA POR NOMBRE DE AGENTE: ");
                        System.out.println("--------------------------------------");
                        System.out.println("INTRODUZCA EL NOMBRE DEL AGENTE QUE QUIERAS CONSULTAR: ");
                        ca.consultaAll();
                        String nombreAgente = sc.nextLine();
                        cm.busquedaPorNombreAgente(nombreAgente);
                        break;

                    case 11:
                        System.out.println("CONSULTAR MULTA POR ID: ");
                        System.out.println("------------------------");
                        System.out.println("INTRODUCE EL ID DE LA MULTA A CONSULTAR: ");
                        cm.consultaAll();
                        int id11 = Integer.parseInt(sc.nextLine());

                        System.out.println(cm.consultaMultaID(id11));
                        break;

                    default:
                        break;
                }

            } while (op != 12);

        } catch (Exception e) {
            e.getMessage();
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
