package ar.edu.unlam.parcial;

public class Gol extends Evento {

    public Gol(int tiempoMinutos, Jugador jugador) {
        super(tiempoMinutos, jugador);
        tipoDeEvento = "gol";
    }

    @Override
    public void ejecutar() {}
}
