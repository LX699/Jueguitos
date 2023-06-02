package juegos;

import java.util.Random;

public class Palabra {

    private char[] incognita = Palabras();
    private char[] palabra = guiones();

    public Palabra() {
    }

    private char[] Palabras() {
        Random random = new Random();
        String[] palabras = {"hola", "chao", "perro", "gato", "patiperro", "notas", "ingles", "rapido", "paralelepipedo"};
        int i = random.nextInt(palabras.length);
        char[] palabra = palabras[i].toCharArray();
        System.out.println(palabras[i]);
        return palabra;
    }

    private char[] guiones() {
        char guion = '_';
        int largo = incognita.length;
        char[] guiones = new char[largo];
        for (int i = 0; i < guiones.length; i++) {
            guiones[i] = guion;
        }
        return guiones;
    }

    public boolean acierto(char letra) {
        for (int i = 0; i < incognita.length; i++) {
            if (letra == incognita[i]) {
                palabra[i] = letra;
            }
        }
        for (int i = 0; i < incognita.length; i++) {
            if (letra == incognita[i]) {

                return true;
            }

        }
        return false;
    }

    public boolean complete() {
        int aciertos = 0;
        for (int i = 0; i < incognita.length; i++) {
            if (palabra[i] == incognita[i]) {
                aciertos++;
            }
        }
        if (aciertos == incognita.length) {
            return true;
        }
        return false;
    }

    public void getPalabra() {
        for (int i = 0; i < palabra.length; i++) {
            System.out.print(palabra[i] + " ");
        }
        System.out.println("\n\n");
    }

    public void getIncognita() {
        for (int i = 0; i < incognita.length; i++) {
            System.out.print(incognita[i] + " ");
        }
        System.out.println("\n\n");
    }

}
