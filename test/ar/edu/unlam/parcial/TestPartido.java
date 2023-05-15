package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestPartido {

	private Equipo bocaJuniors;
	private Equipo river;
	private Jugador riquelme;
	private Jugador ortega;

	@Before
	public void setUp() {
		bocaJuniors = new Equipo("Boca Juniors", "Xeneizes", "La Boca");
		river = new Equipo("River", "Gallinas", "Nuniez");
		riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		ortega = new Jugador("Burrito", "Ortega", 8, 12312312, 30, "312013");
		bocaJuniors.agregarJugador(riquelme);
		river.agregarJugador(ortega);

	}

	@Test
	public void queSePuedaGenerarElPartido() {

		Equipo equipoLocalEsperado = new Equipo();
		Equipo equipoVisitanteEsperado = new Equipo();
		final Integer NUMERO_DE_PARTIDO_ESPERADO = 1;

		Partido partidoEsperado = new Partido(NUMERO_DE_PARTIDO_ESPERADO, equipoLocalEsperado, equipoVisitanteEsperado);

		assertNotNull(partidoEsperado);

	}

	@Test
	public void poderObtenerLosDatosDelEquipoLocalCorrectamente() {
		String NOMBRE_ESPERADO = "Boca Juniors";
		Equipo bocaJuniors = new Equipo("Boca Juniors", "Xeneizes", "La Boca");
		Partido partidoEsperado = new Partido(1, bocaJuniors, river);
		System.out.println(partidoEsperado.getEquipoLocal());
		assertEquals(partidoEsperado.getEquipoLocal().getNombre(), NOMBRE_ESPERADO);
	}

	@Test
	public void poderObtenerLosDatosDelEquipoVisitanteCorrectamente() {
		String APODO_ESPERADO = "Gallinas";
		Equipo river = new Equipo("River", "Gallinas", "Nuniez");
		Partido partidoEsperado = new Partido(1, bocaJuniors, river);

		assertEquals(partidoEsperado.getEquipoVisitante().getApodo(), APODO_ESPERADO);
	}

	@Test
	public void poderAnotarUnGolCorrectamente() {

		bocaJuniors.agregarJugador(riquelme);

		Partido partidoEsperado = new Partido(1, bocaJuniors, river);
		int GOLES_ESPERADOS = 3;

		partidoEsperado.anotarUnGol(bocaJuniors, riquelme, 90);
		partidoEsperado.anotarUnGol(bocaJuniors, riquelme, 32);
		partidoEsperado.anotarUnGol(bocaJuniors, riquelme, 25);

		assertEquals(GOLES_ESPERADOS, partidoEsperado.buscarGoles().size());

	}

	@Test
	public void queSeSepaQuienEsElEquipoGanador() {

		bocaJuniors.agregarJugador(riquelme);
		river.agregarJugador(ortega);

		Partido partidoEsperado = new Partido(1, bocaJuniors, river);

		partidoEsperado.anotarUnGol(bocaJuniors, riquelme, 90);
		partidoEsperado.anotarUnGol(bocaJuniors, riquelme, 32);
		partidoEsperado.anotarUnGol(bocaJuniors, riquelme, 25);

		assertEquals(bocaJuniors, partidoEsperado.obtenerEquipoGanador());

	}
	
	@Test
	public void queSePuedaSaberSiHuboUnEmpate() {

		bocaJuniors.agregarJugador(riquelme);
		river.agregarJugador(ortega);

		Partido partidoEsperado = new Partido(1, bocaJuniors, river);

		partidoEsperado.anotarUnGol(bocaJuniors, riquelme, 90);
		partidoEsperado.anotarUnGol(river, ortega, 32);
	
		assertNull( partidoEsperado.obtenerEquipoGanador());

	}



	@Test
	public void queSePuedanBuscarAmonestados() {
		int TOTAL_DE_AMONESTADOS_ESPERADOS = 2;
		Partido partido = new Partido(1, bocaJuniors, river);
		partido.sancionarAmarilla(river, ortega, 20);

		partido.sancionarAmarilla(bocaJuniors, riquelme, 50);

		List<Jugador> amonestados = partido.buscarAmonestados();
		assertEquals(TOTAL_DE_AMONESTADOS_ESPERADOS, amonestados.size());
		assertTrue(amonestados.contains(riquelme));
		assertTrue(amonestados.contains(ortega));
	}

	@Test
	public void queSePuedaSancionarUnaTarjetaRoja() {

		int CANTIDAD_DE_EXPULSADOS_ESPERADOS = 2;
		Partido partido = new Partido(1, bocaJuniors, river);
		partido.sancionarRoja(partido.getEquipoLocal(), riquelme, 60);
		partido.sancionarRoja(partido.getEquipoVisitante(), ortega, 60);
		List<Evento> eventos = partido.getEventos();
		assertEquals(CANTIDAD_DE_EXPULSADOS_ESPERADOS, eventos.size());
		Evento evento = eventos.get(0);
		assertTrue(evento instanceof Tarjeta);
		Tarjeta tarjeta = (Tarjeta) evento;
		assertEquals(riquelme, tarjeta.getJugador());
		assertEquals(TipoTarjeta.Roja, tarjeta.getTipoTarjeta());
	}

	@Test
	public void queSiSeSacanDosAmarillasElJugadorEsteExpulsado() {
		bocaJuniors.agregarJugador(riquelme);

		Partido partido = new Partido(1, bocaJuniors, river);

		partido.sancionarAmarilla(partido.getEquipoLocal(), riquelme, 10);
		partido.sancionarAmarilla(partido.getEquipoLocal(), riquelme, 10);

		assertTrue(riquelme.estaExpulsado());

	}

	@Test
	public void queNoSePuedanSacarMasDeDosAmarillasAUnJugador() {
		Partido partido = new Partido(1, bocaJuniors, river);

		partido.sancionarAmarilla(partido.getEquipoLocal(), riquelme, 10);
		partido.sancionarAmarilla(partido.getEquipoLocal(), riquelme, 10);
		assertFalse(partido.sancionarAmarilla(partido.getEquipoLocal(), riquelme, 10));
	}

}
