package juegos;

public class Jugador {

    private String nombre;
    private int vida;

    public Jugador(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public void perdidaSalud(int danno) {
        vida -= danno;
    }

    public void incrementoSalud(int salud) {
        vida += salud;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
