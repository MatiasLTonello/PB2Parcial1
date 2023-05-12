package ar.edu.unlam.parcial;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Partido {
	
	private Set <Personal> equipoLocal;
	private Set <Personal> equipoVisitante;
	private Integer numeroDePartido;
	private List<Evento> goles;
	private List<Evento> sanciones;
	
	
	public Partido(Integer numeroDePartido,HashSet <Personal> equipo1, HashSet <Personal> equipo2) {
		this.setEquipoLocal(equipo1);
		this.setEquipoVisitante(equipo2);
		this.numeroDePartido = numeroDePartido;
		goles = new LinkedList <Evento>();
		sanciones = new LinkedList<Evento>();
		
	}
	
	public List<Evento> getGoles() {
		return goles;
	}


	public void setGoles(List<Evento> goles) {
		this.goles = goles;
	}

	public String obtenerEquipoGanador() {
		Integer golesEquipoLocal=0;
		Integer golesEquipoVisitante=0;
		String ganador="empate";
		for(Evento gol :this.goles) {
			String equipo =enQueEquipoEstaElJugador(gol.getJugador());
			if (equipo.equals("local"))
				golesEquipoLocal++;
			if (equipo.equals("visitante")) 
				golesEquipoVisitante++;
		}
		
			
		if (golesEquipoLocal>golesEquipoVisitante)
			ganador= "local";
		else {
			if (golesEquipoLocal<golesEquipoVisitante)
				ganador ="visitante";
		}
			
			;
		return ganador;		
		
	}
	
	private String enQueEquipoEstaElJugador(Jugador jugador) {
		
		String  equipo="";
		
		for( Personal goleador : this.equipoLocal)
			if (goleador.equals(jugador)) {
				equipo="local";
				break;
			}
		for( Personal goleador : this.equipoVisitante)
			if (goleador.equals(jugador)) {
				equipo="visitante";
				break;
			}
		
		
		return equipo;
	}

	
	public List<Evento> getSanciones() {
		return sanciones;
	}




	public void setSanciones(List<Evento> sanciones) {
		
		
		this.sanciones = sanciones;
	}




	public Set <Personal> getEquipoLocal() {
		return equipoLocal;
	}


	public void setEquipoLocal(Set <Personal> equipoLocal) {
		this.equipoLocal = equipoLocal;
	}


	public Set <Personal> getEquipoVisitante() {
		return equipoVisitante;
	}


	public void setEquipoVisitante(Set <Personal> equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	
	

}
