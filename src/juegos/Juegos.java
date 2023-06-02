package juegos;

import java.util.Scanner;

public class Juegos {

    Ahorcado ahorcado = new Ahorcado();
    Battleship battleship = new Battleship();
    Jumanji jumanji = new Jumanji();
    static Validar validar = new Validar();

    public static void main(String[] args) {
        validar.ifOpcion(5);
        System.out.println("termino");
    }

    public static void menu() {
        System.out.println("");
        System.out.println("    ---Menu---");
        System.out.println("1- Ahorcado");
        System.out.println("2- Battleship");
        System.out.println("3- Jumanji");
        System.out.println("4- Salir");
    }

    public static void ejecutar() {
        Scanner intro = new Scanner(System.in);
        int opcion = 0;
        do {
            menu();
            System.out.println(" ");
            try {
                opcion = intro.nextInt();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("\n--------------------------------------------");
                    System.out.println("---No se encuentra dentro de las opciones---");
                    System.out.println("--------------------------------------------");
                    ejecutar();

                }

            } catch (Exception e) {
                System.out.println("\n--------------------------------");
                System.out.println("---Ingrese Caracteres Validos---");
                System.out.println("--------------------------------");
                ejecutar();
            }
            switch (opcion) {
                case 1:
                    Ahorcado.jugar();
                    break;
                case 2:
                    Battleship.ejecutar();
                    break;
                case 3:
                    Jumanji.ejecutar();
                    break;
                case 4:
                    break;

            }
        } while (opcion != 4);
    }
}
