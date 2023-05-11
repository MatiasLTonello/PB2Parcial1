package ar.edu.unlam.parcial;

public class Roja extends Evento {
	
    public Roja(int tiempoMinutos, Jugador jugador) {
        super(tiempoMinutos, jugador);
    }

    @Override
    public void ejecutar() {
    	System.out.println(+ getJugador().getNombre() + " del equipo " + getJugador().getEquipo() + 
    			"Recibio una tarjeta Roja en el minuto " + getTiempoMinutos());
    }
}