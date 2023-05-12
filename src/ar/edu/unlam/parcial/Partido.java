package ar.edu.unlam.parcial;

import java.util.ArrayList;

public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Integer numeroDePartdo;
	private ArrayList<Evento> eventos;

	public Partido(Integer numeroDePartido, Equipo equipo1, Equipo equipo2) {
		this.equipoLocal = equipo1;
		this.equipoVisitante = equipo2;
		this.numeroDePartdo = numeroDePartido;
		eventos = new ArrayList<Evento>();
	}

	public void sancionarRoja(Equipo equipo, Jugador jugador, Integer minuto) {
		Evento roja = new Tarjeta(minuto, equipo.buscarJugador(jugador.getNumeroDorsal()), TipoTarjeta.Roja);
		this.eventos.add(roja);
	}

	public void sancionarAmarilla(Equipo equipo, Jugador jugador, Integer minuto) {
		Evento amarilla = new Tarjeta(minuto, equipo.buscarJugador(jugador.getNumeroDorsal()), TipoTarjeta.Amarilla);
		this.eventos.add(amarilla);
		if (equipo.buscarJugador(jugador.getNumeroDorsal()).getAmarillas() == 2) {
			sancionarRoja(equipo, jugador, minuto);
		}
	}

	public void gol(Equipo equipo, Jugador jugador, Integer minuto) {
		Evento gol = new Gol(minuto, equipo.buscarJugador(jugador.getNumeroDorsal()));
		this.eventos.add(gol);
	}
	
    public void listarEventos() {
        System.out.println("Lista de eventos del partido:");

        for (Evento evento : eventos) {
            int tiempoMinutos = evento.getTiempoMinutos();
            Jugador jugador = evento.getJugador();
            String nombreJugador = jugador.getNombre();
            String tipoDeEvento = evento.getTipoDeEvento();

            System.out.println("Minutos: " + tiempoMinutos + ", Jugador: " + nombreJugador + tipoDeEvento);
        }
    }
}
