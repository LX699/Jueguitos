package juegos;

import java.util.Scanner;

public class Ahorcado {

    static Dibujo dibujo = new Dibujo();
    static Palabra palabra = new Palabra();
    static Validar validar = new Validar();

    public static void main(String[] args) {
        jugar();
    }

    public static void jugar() {
        Scanner intro = new Scanner(System.in);
        while (dibujo.quemado() == false && palabra.complete() == false) {
            dibujo.getDibujo();
            palabra.getPalabra();
            char letra = validar.ifchar();
            if (palabra.acierto(letra) == false) {
                dibujo.quemar();
            }

        }
        if (dibujo.quemado()) {
            System.out.println("\n-Perdiste-");
            System.out.println("La palabra era:");
            palabra.getIncognita();
        } else {
            palabra.getPalabra();
            System.out.println("\n-Ganaste-");
        }
    }
}
