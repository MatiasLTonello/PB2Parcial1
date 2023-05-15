package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestTorneo {

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
		List<Equipo> equipos = Arrays.asList(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8,
				equipo9, equipo10);
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
	public void queSePuedaObtenerAlGoleadorDelTorneo() {

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

	public void queNoSePuedaAgrega2EquiposConMismoNombreAUnTorneo() {

		Equipo equipo1 = new Equipo("boca", "Apodo1", "Direccion1");
		Equipo equipo2 = new Equipo("boca", "Apodo2", "Direccion2");
		Equipo equipo3 = new Equipo("Equipo3", "Apodo3", "Direccion3");
		Equipo equipo4 = new Equipo("Equipo4", "Apodo4", "Direccion4");
		Equipo equipo5 = new Equipo("Equipo5", "Apodo5", "Direccion5");
		Equipo equipo6 = new Equipo("Equipo6", "Apodo6", "Direccion6");
		Equipo equipo7 = new Equipo("Equipo7", "Apodo7", "Direccion7");
		Equipo equipo8 = new Equipo("Equipo8", "Apodo8", "Direccion8");
		Equipo equipo9 = new Equipo("Equipo9", "Apodo9", "Direccion9");
		Equipo equipo10 = new Equipo("Equipo10", "Apodo10", "Direccion10");

		Torneo torneo = new Torneo();

		torneo.agregarEquipo(equipo1);
		torneo.agregarEquipo(equipo3);
		torneo.agregarEquipo(equipo4);
		torneo.agregarEquipo(equipo5);
		torneo.agregarEquipo(equipo6);
		torneo.agregarEquipo(equipo7);
		torneo.agregarEquipo(equipo8);
		torneo.agregarEquipo(equipo9);
		torneo.agregarEquipo(equipo10);
		torneo.agregarEquipo(equipo2);

		assertNotEquals(10, torneo.getEquipos().size());
	}
	
	public void ObtenerJugadoresMasAmonestados() {

		Jugador jugador1 = new Jugador("Juan", "Perez", 10, 123456789, 25, "12345678");
		Jugador jugador2 = new Jugador("Pedro", "Gomez", 5, 987654321, 28, "87654321");
		Jugador jugador3 = new Jugador("Luis", "Lopez", 7, 555555555, 30, "76543210");

		Equipo equipo1 = new Equipo("boca", "Apodo1", "Direccion1");
		Equipo equipo2 = new Equipo("boca", "Apodo2", "Direccion2");
		Equipo equipo3 = new Equipo("Equipo3", "Apodo3", "Direccion3");
		Equipo equipo4 = new Equipo("Equipo4", "Apodo4", "Direccion4");
		Equipo equipo5 = new Equipo("Equipo5", "Apodo5", "Direccion5");
		Equipo equipo6 = new Equipo("Equipo6", "Apodo6", "Direccion6");
		Equipo equipo7 = new Equipo("Equipo7", "Apodo7", "Direccion7");
		Equipo equipo8 = new Equipo("Equipo8", "Apodo8", "Direccion8");
		Equipo equipo9 = new Equipo("Equipo9", "Apodo9", "Direccion9");
		Equipo equipo10 = new Equipo("Equipo10", "Apodo10", "Direccion10");

		equipo1.agregarJugador(jugador1);
		equipo1.agregarJugador(jugador2);
		equipo2.agregarJugador(jugador3);

		List<Equipo> equipos = Arrays.asList(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8,
				equipo9, equipo10);
		Torneo torneo = new Torneo(equipos);
		torneo.agregarEquipo(equipo1);
		torneo.agregarEquipo(equipo2);

		torneo.generarTorneo();

		// Agregar amonestaciones en los partidos
		torneo.getPartidos().get(0).sancionarAmarilla(equipo1, jugador1, 10); // Jugador1 - Amarilla
		torneo.getPartidos().get(0).sancionarAmarilla(equipo2, jugador3, 15); // Jugador3 - Amarilla
		torneo.getPartidos().get(1).sancionarAmarilla(equipo1, jugador1, 20); // Jugador1 - Amarilla
		torneo.getPartidos().get(1).sancionarAmarilla(equipo1, jugador2, 30); // Jugador2 - Amarilla
		torneo.getPartidos().get(1).sancionarRoja(equipo1, jugador2, 32); // Jugador2 - Roja
		torneo.getPartidos().get(2).sancionarAmarilla(equipo1, jugador1, 5); // Jugador1 - Amarilla

		// Obtener los jugadores más amonestados
		List<Jugador> jugadoresMasAmonestados = torneo.obtenerJugadoresMasAmonestados();

		// Verificar que el jugador más amonestado sea el correcto
		assertEquals(1, jugadoresMasAmonestados.size());
		assertEquals(jugador1, jugadoresMasAmonestados.get(0));
	}

}
