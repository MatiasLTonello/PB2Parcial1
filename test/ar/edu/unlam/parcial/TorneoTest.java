package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TorneoTest {

	@Test
		public void verificarQueAlCrearUnTorneoHaya45PartidosParaQueJueguenTodosContraTodos() {
	      
	        Equipo equipo1 = new Equipo("Equipo1", "Apodo1", "Direccion1");
	        Equipo equipo2 = new Equipo("Equipo2", "Apodo2", "Direccion2");
	        Equipo equipo3 = new Equipo("Equipo3", "Apodo3", "Direccion3");
	        Equipo equipo4 = new Equipo("Equipo4", "Apodo4", "Direccion4");
	        Equipo equipo5 = new Equipo("Equipo5", "Apodo5", "Direccion5");
	        Equipo equipo6 = new Equipo("Equipo6", "Apodo6", "Direccion6");
	        Equipo equipo7 = new Equipo("Equipo7", "Apodo7", "Direccion7");
	        Equipo equipo8 = new Equipo("Equipo8", "Apodo8", "Direccion8");
	        Equipo equipo9 = new Equipo("Equipo9", "Apodo9", "Direccion9");
	        Equipo equipo10 = new Equipo("Equipo10", "Apodo10", "Direccion10");
	        List<Equipo> equipos = Arrays.asList(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8, equipo9, equipo10);
	        Torneo torneo = new Torneo(equipos);
	       
	        torneo.generarTorneo();
	
	        
	        assertEquals(45, torneo.getPartidos().size()); 
	    }
	
		@Test
		public void queNoSePuedaCrearUnTorneoSiNoHay10Equipos() {
			final int NUMEROS_DE_PARTIDOS_ESPERADOS = 0;
			Equipo equipo1 = new Equipo("Equipo1", "Apodo1", "Direccion1");
			Equipo equipo2 = new Equipo("Equipo2", "Apodo2", "Direccion2");
			Equipo equipo3 = new Equipo("Equipo3", "Apodo3", "Direccion3");
			Equipo equipo4 = new Equipo("Equipo4", "Apodo4", "Direccion4");
			Equipo equipo5 = new Equipo("Equipo5", "Apodo5", "Direccion5");
			Equipo equipo6 = new Equipo("Equipo6", "Apodo6", "Direccion6");
			Equipo equipo7 = new Equipo("Equipo7", "Apodo7", "Direccion7");

			List<Equipo> equipos = Arrays.asList(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7);
			Torneo torneo = new Torneo(equipos);

			torneo.generarTorneo();

			assertEquals(NUMEROS_DE_PARTIDOS_ESPERADOS, torneo.getPartidos().size());
		}
	
	@Test
	public void queSePuedaAgregarEquiposAlTorneoDeFormaIndividual() {
		Torneo torneo = new Torneo();
		final int CANTIDAD_DE_EQUIPOS_ESPERADOS = 2;
		Equipo equipo1 = new Equipo("Equipo1", "Apodo1", "Direccion1");
		Equipo equipo2 = new Equipo("Equipo2", "Apodo2", "Direccion2");
		torneo.agregarEquipo(equipo2);
		
		assertTrue(torneo.agregarEquipo(equipo1));
		assertEquals(CANTIDAD_DE_EQUIPOS_ESPERADOS, torneo.getEquipos().size());
	}
	
	@Test
	public void testObtenerGoleador() {
	
		Equipo equipo1 = new Equipo("Equipo1", "Apodo1", "Direccion1");
		Equipo equipo2 = new Equipo("Equipo2", "Apodo2", "Direccion2");
		Equipo equipo3 = new Equipo("Equipo3", "Apodo3", "Direccion3");
		Equipo equipo4 = new Equipo("Equipo4", "Apodo4", "Direccion4");
		Equipo equipo5 = new Equipo("Equipo5", "Apodo5", "Direccion5");
		Equipo equipo6 = new Equipo("Equipo6", "Apodo6", "Direccion6");
		Equipo equipo7 = new Equipo("Equipo7", "Apodo7", "Direccion7");
		Equipo equipo8 = new Equipo("Equipo8", "Apodo8", "Direccion8");
		Equipo equipo9 = new Equipo("Equipo9", "Apodo9", "Direccion9");
		Equipo equipo10 = new Equipo("Equipo10", "Apodo10", "Direccion10");
		List<Equipo> equipos = Arrays.asList(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8,
				equipo9, equipo10);
		Torneo torneo = new Torneo(equipos);

		torneo.generarTorneo();

	
		Jugador riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		Jugador ortega = new Jugador("Burrito", "Ortega", 8, 12312312, 30, "312013");
		equipo1.agregarJugador(riquelme);
		equipo2.agregarJugador(ortega);


	    Partido partido = torneo.getPartidos().get(0);

	   
	    partido.anotarUnGol(equipo1, riquelme, 30);
	    partido.anotarUnGol(equipo1, riquelme, 30);
	    partido.anotarUnGol(equipo1, riquelme, 30);
	    partido.anotarUnGol(equipo2, ortega, 30);


	    Jugador goleador = torneo.obtenerGoleador();
	    

	    assertEquals(riquelme, goleador);
	}


}
