package juegos;

import java.util.Random;
import java.util.Scanner;

public class Battleship {

    static int[][] pc = new int[5][5];
    static int[][] usuario = new int[5][5];
    static int BarcosDerribadosUsuario = 0;
    static int BarcosDerribadosPc = 0;

    public static void main(String[] args) {
        ejecutar();

    }

    public static void ejecutar() {
        llenarcon0();
        BarcosPc();
        Menu();
        do {
            System.out.println(" ");
            System.out.println("      ---Puntaje---");
            System.out.println("Pc: " + BarcosDerribadosPc + "  Usuario: " + BarcosDerribadosUsuario);
            Escribir(pc);
            TurnoUsuario();
            System.out.println(BarcosDerribadosUsuario);
            TurnoPc();

        } while ((BarcosDerribadosPc != 5) && (BarcosDerribadosUsuario != 5));
        if (BarcosDerribadosUsuario == 5) {
            System.out.println("Felicidades as ganado");
        } else if (BarcosDerribadosPc == 5) {
            System.out.println("La maquina a Ganado");

        }
    }

    public static void Menu() {
        Scanner intro = new Scanner(System.in);
        int opcion = 0;
        System.out.println("--------------------------------------");
        System.out.println("1- Colocar tu mismo los barcos");
        System.out.println("2- Colocar tus barcos aleatoriamente");
        System.out.println("Elija una opcion:");
        try {
            opcion = intro.nextInt();
            if ((opcion == 1) || (opcion == 2)) {
                switch (opcion) {
                    case 1:
                        BarcosUsuarioManual();
                        break;
                    case 2:
                        BarcosUsuarioAleatorio();
                        break;
                }
            } else {
                System.out.println("--Ingrese una de las opciones--");
                System.out.println("");
                Menu();
            }
        } catch (Exception e) {
            System.out.println("--Ingrese caracteres validos--");
            System.out.println("");
            Menu();
        }
        if ((opcion != 1) || (opcion != 2)) {

        }
        switch (opcion) {
            case 1:
                BarcosUsuarioManual();
            case 2:
                BarcosUsuarioAleatorio();
        }
    }

    public static void llenarcon0() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pc[i][j] = 0;
                usuario[i][j] = 0;
            }
        }
    }

    public static void BarcosPc() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int j = random.nextInt(4);
            int h = random.nextInt(4);
            if (pc[j][h] == 1) {
                i--;
            } else {
                pc[j][h] = 1;
            }
        }
    }

    public static void BarcosUsuarioAleatorio() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int j = random.nextInt(4);
            int h = random.nextInt(4);
            if (usuario[j][h] == 1) {
                i--;
            } else {
                usuario[j][h] = 1;
            }
        }
    }

    public static void BarcosUsuarioManual() {
        Scanner intro = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese cordenadas del barco N°: " + (i + 1));
            System.out.println("Las cordenadas deben ser del 1 al 5 :");
            System.out.print("Cordenada N° 1: ");
            int j = intro.nextInt() - 1;
            System.out.print("Cordenada N° 2: ");
            int h = intro.nextInt() - 1;
            if ((j > 5) || (h > 5)) {
                System.out.println("--Ingrese cordenadas Validas--");
                BarcosUsuarioManual();
            } else {
                if (usuario[j][h] == 1) {
                    System.out.println("--Esta coordenada ya tiene un barco--");
                    System.out.println("");
                    i--;
                } else {
                    usuario[j][h] = 1;
                    System.out.println("");
                }
            }
        }

    }

    public static void TurnoUsuario() {
        try {
            Scanner intro = new Scanner(System.in);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("   --Es tu turno--");
            System.out.println("Ingrese cordenadas:");
            System.out.println("Las cordenadas deben ser del 1 al 5 :");
            System.out.println(" ");
            System.out.print("Cordenada N° 1: ");
            int j = intro.nextInt() - 1;
            System.out.print("Cordenada N° 2: ");
            int h = intro.nextInt() - 1;
            if ((j > 4) || (h > 4)) {
                System.out.println("");
                System.out.println("--Ingrese cordenadas Validas--");
                TurnoUsuario();
            } else {
                if (pc[j][h] == 1) {
                    System.out.println("Justo en el blanco");
                    BarcosDerribadosUsuario++;
                    pc[j][h] = 0;
                } else {
                    System.out.println("Suerte para la proxima");
                }
            }
        } catch (Exception e) {
            System.out.println("--Ingrese caracteres validos--");
            System.out.println("");
            TurnoUsuario();
        }
    }

    public static void TurnoPc() {
        Random random = new Random();
        System.out.println("");
        System.out.println("  --Turno del Pc--");
        int j = random.nextInt(4);
        int h = random.nextInt(4);
        System.out.print("Cordenada N° 1: " + j);
        System.out.print("Cordenada N° 2: " + h);
        System.out.println(" ");

        if (usuario[j][h] == 1) {
            System.out.println("Justo en el blanco");
            BarcosDerribadosPc++;
            usuario[j][h] = 0;
        } else {
            System.out.println("Suerte para la proxima");
        }
    }

    public static void Escribir(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            System.out.println(" ");
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j]+" ");

            }

        }
    }
}
