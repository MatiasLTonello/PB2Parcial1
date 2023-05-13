package ar.edu.unlam.parcial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Integer numeroDePartdo;
	private ArrayList<Evento> eventos;

	public Partido(Integer numeroDePartido, Equipo equipoLocal, Equipo equipoVisitante) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.numeroDePartdo = numeroDePartido;
		eventos = new ArrayList<Evento>();
	}

	public void sancionarRoja(Equipo equipo, Jugador jugador, Integer minuto) {
	    if (equipo == null || jugador == null) {
	        throw new IllegalArgumentException("Equipo y jugador no pueden ser nulos.");
	    }

	    if (!equipo.getJugadores().contains(jugador)) {
	        throw new IllegalArgumentException("El jugador no pertenece al equipo.");
	    }

	    Evento roja = new Tarjeta(minuto, equipo.buscarJugadorPorNumero(jugador.getNumeroDorsal()), TipoTarjeta.Roja);
	    this.eventos.add(roja);
	}

	public void sancionarAmarilla(Equipo equipo, Jugador jugador, Integer minuto) {
		Evento amarilla = new Tarjeta(minuto, equipo.buscarJugadorPorNumero(jugador.getNumeroDorsal()), TipoTarjeta.Amarilla);
		this.eventos.add(amarilla);
		if (equipo.buscarJugadorPorNumero(jugador.getNumeroDorsal()).getAmarillas() == 2) {
			sancionarRoja(equipo, jugador, minuto);
		}
	}

	public void anotarUnGol(Equipo equipo, Jugador jugador, Integer minuto) {
		Evento gol = new Gol(minuto, equipo.buscarJugadorPorNumero(jugador.getNumeroDorsal()));
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
	
	
}
