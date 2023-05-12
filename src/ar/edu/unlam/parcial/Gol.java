package ar.edu.unlam.parcial;

public class Gol extends Evento {

    public Gol(int tiempoMinutos, Jugador jugador) {
        super(tiempoMinutos, jugador);
    }

    @Override
    public void ejecutar() {
        System.out.println("¡Gol! " + getJugador().getNombre() + " anota en el minuto " + getTiempoMinutos());
    }
}
