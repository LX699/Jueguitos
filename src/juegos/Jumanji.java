package juegos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jumanji {

    static ArrayList<Integer> jugador1 = new ArrayList<>();
    static ArrayList<Integer> jugador2 = new ArrayList<>();
    static ArrayList<Integer> jugador3 = new ArrayList<>();

    static int dados;

    public static void main(String[] args) {
        ejecutar();

    }

    public static void ejecutar() {
        do {
            System.out.println("Turno Jugador 1:");
            turno(jugador1);
            System.out.println("Turno Jugador 2:");
            turno(jugador2);
            System.out.println("Turno Jugador 3:");
            turno(jugador3);
        } while ((jugador1.size() <= 28) || (jugador2.size() <= 28) || (jugador3.size() <= 28));

    }

    public static void dados() {
        Random Random = new Random();
        int Dado1 = Random.nextInt(6) + 1;
        int Dado2 = Random.nextInt(6) + 1;
        int resultado = Dado1 + Dado2;
        System.out.println("El dado numero uno dio: " + Dado1);
        System.out.println("El dado numero dos dio: " + Dado2);
        System.out.println("Total: " + resultado);
        dados = resultado;
    }

    public static void turno(ArrayList<Integer> jugador) {
        Scanner intro = new Scanner(System.in);
        System.out.println("Presione enter para lanzar los dados: ");
        String enter = intro.next();
        dados();
        agregar(jugador, dados);
        System.out.println(" ");
        filtro(jugador);
        System.out.println(" ");
    }

    public static void imprimir(ArrayList<Integer> jugador) {
        for (int i = 0; i < jugador.size(); i++) {
            System.out.print(jugador.get(i) + " ");
        }
    }

    public static void agregar(ArrayList<Integer> jugador, int valor) {
        for (int i = 1; i <= valor; i++) {
            jugador.add(jugador.size() + 1);
        }
        imprimir(jugador);
        if (jugador.size() >= 28) {
            System.out.println(" ");
            System.out.println("--Ganaste--");
            System.exit(0);
        }

    }

    public static void quitar(ArrayList<Integer> jugador, int valor) {
        for (int i = 1; i <= valor; i++) {
            jugador.remove((jugador.size() - 1));
        }
        imprimir(jugador);
    }

    public static void filtro(ArrayList<Integer> jugador) {

        int contador = 0;
        for (int I = 1; I <= jugador.size(); I++) {
            if ((jugador.size() % I) == 0) {
                contador++;
            }
        }

        if ((jugador.size() == 10) || (jugador.size() == 20)) {
            System.out.println("Multiplo de 10");
            agregar(jugador, 5);
        } else if (jugador.size() == 13) {
            System.out.println("Callo en el 13");
            jugador.clear();
        } else if (contador <= 2) {
            System.out.println("Es Primo");
            primos(jugador);
        } else if (jugador.size() % 2 == 0) {
            System.out.println("Es par");
            agregar(jugador, 2);
        } else {
            System.out.println("Es Impar");
            quitar(jugador, 1);
        }
        if (jugador.size() >= 28) {
            System.out.println(" ");
            System.out.println("--Ganaste-- ");
            System.exit(0);

        }
        System.out.println(" ");
    }

    public static void primos(ArrayList<Integer> jugador) {
        if (jugador.size() == 23) {
            quitar(jugador, 4);
        } else if (jugador.size() == 19) {
            quitar(jugador, 2);
        } else if (jugador.size() == 17) {
            quitar(jugador, 4);
        } else if (jugador.size() == 13) {
            quitar(jugador, 2);
        } else if (jugador.size() == 11) {
            quitar(jugador, 4);
        } else if (jugador.size() == 7) {
            quitar(jugador, 2);
        } else if (jugador.size() == 5) {
            quitar(jugador, 2);
        } else if (jugador.size() == 3) {
            quitar(jugador, 1);
        } else if (jugador.size() == 2) {
        }
    }
}
