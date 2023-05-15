package ar.edu.unlam.parcial;

import java.util.ArrayList;
import java.util.List;

public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Integer numeroDePartdo;
	private ArrayList<Evento> eventos;
	

	public Partido(Integer numeroDePartido, Equipo equipoLocal, Equipo equipoVisitante) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.setNumeroDePartdo(numeroDePartido);
		eventos = new ArrayList<Evento>();
	}

	public Boolean sancionarRoja(Equipo equipo, Jugador jugador, Integer minuto) {
		if (equipo == null || jugador == null) {
			return false;
		}

		if (!equipo.getJugadores().contains(jugador)) {
			return false;
		}

		Evento roja = new Tarjeta(minuto, equipo.buscarJugadorPorNumero(jugador.getNumeroDorsal()), TipoTarjeta.Roja);
		this.eventos.add(roja);
		return true;
	}

	public Boolean sancionarAmarilla(Equipo equipo, Jugador jugador, Integer minuto) {
		if (jugador.getAmarillas() < 2) {
			Evento amarilla = new Tarjeta(minuto, jugador, TipoTarjeta.Amarilla);
			this.eventos.add(amarilla);
			if (jugador.getAmarillas() == 2) {
				sancionarRoja(equipo, jugador, minuto);
				return true;
			}
		}
		return false;
	}
	
	public Equipo actualizarPartido() {
	    Equipo equipoGanador = obtenerEquipoGanador();
	    listarEventos();
	    return equipoGanador;
	}


	public void anotarUnGol(Equipo equipo, Jugador jugador, Integer minuto) {
		Evento gol = new Gol(minuto, equipo.buscarJugadorPorNumero(jugador.getNumeroDorsal()), equipo.getNombre());
		this.eventos.add(gol);
	}

	public List<Gol> buscarGoles() {
		List<Gol> goles = new ArrayList<Gol>();
		for (Evento evento : eventos) {
			if (evento instanceof Gol) {
				goles.add((Gol) evento);
			}
		}
		return goles;
	}

	public List<Jugador> buscarAmonestados() {
		List<Jugador> amonestados = new ArrayList<>();
		for (Evento evento : eventos) {
			if (evento instanceof Tarjeta) {
				Tarjeta tarjeta = (Tarjeta) evento;
				if (tarjeta.getTipoTarjeta() == TipoTarjeta.Amarilla) {
					Jugador jugador = tarjeta.getJugador();
					amonestados.add(jugador);
				}
			}
		}

		return amonestados;
	}

	public Equipo obtenerEquipoGanador() {
		int golesEquipoLocal = 0;
		int golesEquipoVisitante = 0;

		List<Gol> goles = buscarGoles();

		for (Gol gol : goles) {
			if (gol.getNombreDelEquipo().equals(equipoLocal.getNombre())) {
				golesEquipoLocal++;
			} else if (gol.getNombreDelEquipo().equals(equipoVisitante.getNombre())) {
				golesEquipoVisitante++;
			}
		}

	    if (golesEquipoLocal > golesEquipoVisitante) {
	        equipoLocal.sumarVictoria();
	        equipoVisitante.sumarDerrota();
	        return equipoLocal;
	    } else if (golesEquipoLocal < golesEquipoVisitante) {
	        equipoVisitante.sumarVictoria();
	        equipoLocal.sumarDerrota();
	        return equipoVisitante;
	    } else {
	        equipoLocal.sumarEmpate();
	        equipoVisitante.sumarEmpate();
	        return null;
	    }
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

	public Equipo getEquipoLocal() {
		return this.equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return this.equipoVisitante;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public Integer getNumeroDePartdo() {
		return numeroDePartdo;
	}

	public void setNumeroDePartdo(Integer numeroDePartdo) {
		this.numeroDePartdo = numeroDePartdo;
	}

}
