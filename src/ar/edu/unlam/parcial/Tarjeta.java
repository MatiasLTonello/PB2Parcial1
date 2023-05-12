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
			System.out.println(
					getJugador().getNombre() + " Recibio una tarjeta Amarilla en el minuto " + getTiempoMinutos());
			this.getJugador().setAmarillas(this.getJugador().getAmarillas() + 1);

			if (this.getJugador().getAmarillas() == 2) {
			}
		} else {
			System.out
					.println(getJugador().getNombre() + " Recibio una tarjeta Roja en el minuto " + getTiempoMinutos());
		}
	}
}

//se podria hacer un enum tarjeta donde sea amarilla/roja y dependiendo ese enum hacer 2 metodos asi se puede lanzar la misma cosa
