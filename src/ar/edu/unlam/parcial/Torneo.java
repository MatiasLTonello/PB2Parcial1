package ar.edu.unlam.parcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Torneo {
	private List<Equipo> equiposInicial;
	private List<Partido> partidos;
	private List<Equipo> equiposFinal;

	public Torneo(List<Equipo> equiposInicial) {
		this.equiposInicial = equiposInicial;
		this.partidos = new ArrayList<Partido>();
		this.equiposFinal = new ArrayList<Equipo>(equiposFinal);
	}

	public void generarTorneo() {
		while (equiposFinal.size() >= 2) {
			List<Equipo> equiposAleatorios = seleccionarEquiposAleatorios();

			if (equiposAleatorios.size() == 2) {
				Partido partido = crearPartido(equiposAleatorios.get(0), equiposAleatorios.get(1));
				partidos.add(partido);

				moverEquipos(equiposAleatorios);
			}
		}
	}

	private List<Equipo> seleccionarEquiposAleatorios() {
		List<Equipo> equiposAleatorios = new ArrayList<Equipo>(equiposFinal);
		Collections.shuffle(equiposAleatorios);
		return equiposAleatorios.subList(0, Math.min(2, equiposAleatorios.size()));
	}

	private Partido crearPartido(Equipo equipo1, Equipo equipo2) {
		Partido partido = new Partido(partidos.size() + 1, equipo1, equipo2);
		return partido;
	}

	private void moverEquipos(List<Equipo> equipos) {
		equiposFinal.removeAll(equipos);
	}
}
