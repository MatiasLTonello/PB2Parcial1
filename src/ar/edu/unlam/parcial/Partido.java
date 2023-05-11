package ar.edu.unlam.parcial;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Partido {
	
	private Set <Persona> equipoLocal;
	private Set <Persona> equipoVisitante;
	private Integer numeroDePartdo;
	private List<Evento> goles;
	private List<Evento> sanciones;
	
	
	public Partido(Integer numeroDePartido,HashSet <Persona> equipo1, HashSet <Persona> equipo2) {
		this.equipoLocal = equipo1;
		this.equipoVisitante = equipo2;
		this.numeroDePartdo = numeroDePartido;
		goles = new LinkedList <Evento>();
		
	}
	
	

}
