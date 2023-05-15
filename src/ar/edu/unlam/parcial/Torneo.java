package ar.edu.unlam.parcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Torneo {
	private List<Equipo> equipos;
	private List<Partido> partidos;
	private List<Equipo> equiposFinal;

	public Torneo(List<Equipo> equiposInicial) {
		if (equiposInicial.size() <= 10) {
			this.equipos = equiposInicial;
		} else {
			this.equipos = new ArrayList<>();
		}
		this.partidos = new ArrayList<>();

		this.equiposFinal = new ArrayList<>(equipos);
	}

	public Torneo() {
		this.equipos = new ArrayList<>();
		this.partidos = new ArrayList<>();
		this.equiposFinal = new ArrayList<>(equipos);
	}

	public Boolean generarTorneo() {
		if (equipos.size() == 10) {
			for (int i = 0; i < equiposFinal.size() - 1; i++) {
				for (int j = i + 1; j < equiposFinal.size(); j++) {
					Partido partido = crearPartido(equiposFinal.get(i), equiposFinal.get(j));
					partidos.add(partido);
				}
			}
			return true;
		}
		return false;
	}

	public List<Jugador> obtenerJugadoresMasAmonestados() {
		Map<Jugador, Integer> amonestacionesPorJugador = new HashMap<>();

		for (Partido partido : partidos) {
			List<Jugador> amonestadosPartido = partido.buscarAmonestados();
			for (Jugador jugador : amonestadosPartido) {
				Integer amonestacionesActuales = amonestacionesPorJugador.getOrDefault(jugador, 0);
				amonestacionesPorJugador.put(jugador, amonestacionesActuales + 1);
			}
		}

		int maxAmonestaciones = 0;
		for (Integer amonestaciones : amonestacionesPorJugador.values()) {
			if (amonestaciones > maxAmonestaciones) {
				maxAmonestaciones = amonestaciones;
			}
		}

		List<Jugador> jugadoresMasAmonestados = new ArrayList<>();
		for (Map.Entry<Jugador, Integer> entry : amonestacionesPorJugador.entrySet()) {
			if (entry.getValue() == maxAmonestaciones) {
				jugadoresMasAmonestados.add(entry.getKey());
			}
		}

		return jugadoresMasAmonestados;
	}

	public Boolean agregarEquipo(Equipo equipo) {
		if (equipos.size() < 10 && !tieneEquipoMismoNombre(equipo)) {
			equipos.add(equipo);
			equiposFinal.add(equipo);
			return true;
		}
		return false;
	}

	private boolean tieneEquipoMismoNombre(Equipo equipo) {
		for (Equipo e : equipos) {
			if (e.getNombre().equalsIgnoreCase(equipo.getNombre())) {
				return true;
			}
		}
		return false;
	}


	public List<Equipo> getEquipos() {
		return equipos;
	}

	public Jugador obtenerGoleador() {
		HashMap<Jugador, Integer> golesPorJugador = new HashMap<>();

		for (Partido partido : partidos) {
			for (Evento evento : partido.getEventos()) {
				if (evento instanceof Gol) {
					Jugador jugadorQueAnoto = ((Gol) evento).getJugador();
					Integer golesActuales = golesPorJugador.getOrDefault(jugadorQueAnoto, 0);
					golesPorJugador.put(jugadorQueAnoto, golesActuales + 1);
				}
			}
		}

		Jugador goleador = null;
		int maxGoles = 0;
		for (Jugador jugador : golesPorJugador.keySet()) {
			int goles = golesPorJugador.get(jugador);
			if (goles > maxGoles) {
				goleador = jugador;
				maxGoles = goles;
			}
		}

		return goleador;
	}
	
	public List<Equipo> generarRanking() {
	    List<Equipo> ranking = new ArrayList<>(equipos);

	    Collections.sort(ranking, new Comparator<Equipo>() {
	        @Override
	        public int compare(Equipo equipo1, Equipo equipo2) {
	            int puntosEquipo1 = calcularPuntos(equipo1);
	            int puntosEquipo2 = calcularPuntos(equipo2);

	            if (puntosEquipo1 > puntosEquipo2) {
	                return -1;
	            } else if (puntosEquipo1 < puntosEquipo2) {
	                return 1;
	            } else {
	                return 0;
	            }
	        }
	    });

	    return ranking;
	}

	private int calcularPuntos(Equipo equipo) {
	    int puntos = 0;
	    puntos += equipo.getPartidosGanados() * 3;
	    puntos += equipo.getPartidosEmpatados();

	    return puntos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	private Partido crearPartido(Equipo equipo1, Equipo equipo2) {
		Partido partido = new Partido(partidos.size() + 1, equipo1, equipo2);
		return partido;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

}
