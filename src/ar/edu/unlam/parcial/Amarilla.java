package ar.edu.unlam.parcial;

public class Amarilla extends Evento {

    public Amarilla(int tiempoMinutos, Jugador jugador) {
        super(tiempoMinutos, jugador);
    }

    @Override
    public void ejecutar() {
    	System.out.println(getJugador().getNombre() + " del equipo " + getJugador().getEquipo() + 
    			"Recibio una tarjeta Amarilla en el minuto " + getTiempoMinutos());
    }
}
