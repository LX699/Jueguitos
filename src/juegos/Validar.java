package juegos;

import java.util.Scanner;

public class Validar {

    public Validar() {
    }

    public char ifchar() {
        Scanner intro = new Scanner(System.in);
        char[] caracteres;
        char caracter;
        System.out.println("-Ingrese una Letra-");
        caracteres = intro.next().toCharArray();

        if (caracteres.length > 1) {
            System.out.println("\n------------------------");
            System.out.println("-ingrese solo una letra-");
            System.out.println("------------------------\n");
            ifchar();
        }
        caracter = caracteres[0];
        return caracter;
    }

    public int ifOpcion(int rango) {
        Scanner intro = new Scanner(System.in);
        int opcion = 0;
        System.out.println("-Ingrese una Opcion-");
        try {
            opcion = intro.nextInt();
            if (opcion > rango || opcion < 1) {
                System.out.println("\n-----------------------");
                System.out.println("-opcion fuera de rango-");
                System.out.println("-----------------------\n");
                ifOpcion(rango);

            }
        } catch (Exception e) {
            System.out.println("\n------------------------------");
            System.out.println("-Ingrese caracteres numericos-");
            System.out.println("------------------------------\n");
            ifOpcion(rango);
        }
        return opcion;
    }
}
