package juegos;

import java.util.Random;

public class Espada {

    private String Nombre;
    private int danno;
    private int critico;

    public Espada(String Nombre, int danno, int critico) {
        this.Nombre = Nombre;
        this.danno = danno;
        this.critico = critico;
    }

    public int ataque() {
        
        Random random = new Random();
        int danno= this.danno;
        int prob = random.nextInt(100) + 1;
        if (prob <= this.critico) {
            danno = danno * 2;
            System.out.println("-Critico-");
        }
        danno= danno-(random.nextInt(danno/10)+1);
        return danno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    public int getCritico() {
        return critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }

}
