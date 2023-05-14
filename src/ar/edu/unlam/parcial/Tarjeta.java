package ar.edu.unlam.parcial;

public class Tarjeta extends Evento {
	private TipoTarjeta tipotarjeta;

	public Tarjeta(int tiempoMinutos, Jugador jugador, TipoTarjeta tipotarjeta) {
		super(tiempoMinutos, jugador);
		this.tipotarjeta = tipotarjeta;
		this.ejecutar();
	}

	public TipoTarjeta getTipoTarjeta() {
		return tipotarjeta;
	}

	@Override
	public void ejecutar() {
		Jugador jugador = this.getJugador();
		if (this.tipotarjeta == TipoTarjeta.Amarilla) {
			jugador.setAmarillas(jugador.getAmarillas() + 1);
			tipoDeEvento = "Amarilla";
		} else if (this.tipotarjeta == TipoTarjeta.Roja) {
			jugador.setExpulsado(true);
			tipoDeEvento = "Roja";
		}
	}
}
