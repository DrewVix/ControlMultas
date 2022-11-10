package GestionDepartamentosFT;


import java.io.File;
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
        File f = new File("departamentos.txt");
        int op;
        ControladorDepartamentos cd = new ControladorDepartamentos(f);

        do {
            op = menu(sc);
            switch (op) {
                case 1:
                    Departamento d;
                    System.out.println("INTRODUCE NOMBRE DEPARTAMENTO.");
                    String name = sc.nextLine();
                    System.out.println("INTRODUCE NOMBRE RESPONSABLE DEPARTAMENTO.");
                    String nameBoss = sc.nextLine();
                    System.out.println("INTRODUCE NUMERO DE EMPLEADOS.");
                    int numEm = Integer.parseInt(sc.nextLine());
                    System.out.println("INTRODUCE NUMERO DE PLANTA.");
                    int numPlanta = Integer.parseInt(sc.nextLine());
                    d = new Departamento(name, nameBoss, numEm,numPlanta);
                    cd.alta(d);
                    break;

                case 2:
                    Departamento d2;
                    System.out.println("INTRODUCE EL ID DEL DEPARTAMENTO QUE DESEAS ELIMINAR:");
                    int dep2= sc.nextInt();
                    cd.baja(dep2);
                    break;

                case 3:
                    System.out.println("INTRODUCE EL ID DEL DEPARTAMENTO:");
                    int dep3 = Integer.parseInt(sc.nextLine());
                    cd.consultaDepartamentoPorID(dep3);

                    Departamento d3;
                    System.out.println("INTRODUCE NOMBRE DEPARTAMENTO.");
                    String name3 = sc.nextLine();
                    System.out.println("INTRODUCE NOMBRE RESPONSABLE DEPARTAMENTO.");
                    String nameBoss3 = sc.nextLine();
                    System.out.println("INTRODUCE NUMERO DE EMPLEADOS.");
                    int numEm3 = Integer.parseInt(sc.nextLine());
                    System.out.println("INTRODUCE NUMERO DE PLANTA.");
                    int numPlanta3 = Integer.parseInt(sc.nextLine());
                    d3 = new Departamento(dep3, name3, nameBoss3, numEm3,numPlanta3);
                    cd.modificarDepartamento(d3);
                    break;

                case 4:
                    cd.consultaTodosDepartamentos();
                    break;

                case 5:
                    System.out.println("INTRODUCE EL ID DEL DEPARTAMENTO:");
                    int dep = Integer.parseInt(sc.nextLine());
                    cd.consultaDepartamentoPorID(dep);
                    break;

                default:
                    break;
            }

        } while (op != 6);

    }

    public static int menu(Scanner sc) {
        int menu;

        System.out.println("SELECCIONE LA OPCIÓN:");
        System.out.println("1.ALTA DEPARTAMENTO.");
        System.out.println("2.BAJA DEPARTAMENTO.");
        System.out.println("3.MODIFICACION DEPARTAMENTO.");
        System.out.println("4.LISTADO TOTAL DEPARTAMENTOS.");
        System.out.println("5.LISTADO POR IDENTIFICADOR.");
        System.out.println("6.SALIR");

        System.out.println("INTRODUZCA UNA OPCION:");
        menu = Integer.parseInt(sc.nextLine());

        return menu;
    }

}
