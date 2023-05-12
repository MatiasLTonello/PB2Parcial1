package ar.edu.unlam.parcial;

public abstract class Evento {
	private int tiempoMinutos;
	private Jugador jugador;

	public Evento(int tiempoMinutos, Jugador jugador) {
		this.tiempoMinutos = tiempoMinutos;
		this.jugador = jugador;
	}

	public int getTiempoMinutos() {
		return tiempoMinutos;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public abstract void ejecutar();
}
