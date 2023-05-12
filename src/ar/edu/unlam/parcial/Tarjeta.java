package ar.edu.unlam.parcial;

public class Tarjeta extends Evento {
	private TipoTarjeta tipotarjeta;

	public Tarjeta(int tiempoMinutos, Jugador jugador, TipoTarjeta tipotarjeta) {
		super(tiempoMinutos, jugador);
		this.tipotarjeta = tipotarjeta;
	}

	@Override
	public void ejecutar() {
		if (tipotarjeta == TipoTarjeta.Amarilla) {
			this.getJugador().setAmarillas(this.getJugador().getAmarillas() + 1);
			tipoDeEvento = "Amarilla";

		} else{
			tipoDeEvento = "Roja";
		}
	}
}
