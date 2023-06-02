package juegos;

import java.util.ArrayList;

public class Dibujo {

    private String[] dibujo = {" 0", "/", "|", "\\", " |", "/ ", "\\"};
    private int equivocaciones = 0;

    public void getDibujo() {
        for (int i = 0; i < this.dibujo.length - this.equivocaciones; i++) {
            System.out.print(dibujo[i]);
            if (i == 0 || i == 3 || i == 4) {
                System.out.print("\n");
            }

        }
        System.out.println("");
    }

    public void quemar() {
        this.equivocaciones++;
    }

    public boolean quemado() {
        return this.equivocaciones >= this.dibujo.length;

    }
}
