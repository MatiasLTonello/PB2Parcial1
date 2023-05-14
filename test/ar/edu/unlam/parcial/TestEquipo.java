package ar.edu.unlam.parcial;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestEquipo {
	private Equipo bocaJuniors;
	private Jugador riquelme;
	private Jugador ortega;

	@Before
	public void setUp() {
		bocaJuniors = new Equipo("Boca Juniors", "Xeneizes", "Cochabamba");
		riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		ortega = new Jugador("Burrito", "Ortega", 8, 12312312, 30, "312013");

	}

	@Test
	public void queSePuedaCrearUnEquipoCorrectamente() {
		String NOMBRE_ESPERADO = "Boca Juniors";
		String APODO_ESPERADO = "Xeneizes";
		String DIRECCION_ESPERADA = "Cochabamba";

		assertEquals(bocaJuniors.getApodo(), APODO_ESPERADO);
		assertEquals(bocaJuniors.getNombre(), NOMBRE_ESPERADO);
		assertEquals(bocaJuniors.getDireccion(), DIRECCION_ESPERADA);
	}

	@Test
	public void queNoSePuedanAgregarMasDe6Jugadores() {
		Jugador palermo = new Jugador("Martin", "Palermo", 1, 12312312, 30, "312013");
		Jugador martinez = new Jugador("Emiiano", "Martinez", 2, 12312312, 30, "312013");
		Jugador benedetto = new Jugador("Dario", "Benedetto", 3, 12312312, 30, "312013");
		Jugador varela = new Jugador("Alan", "Varela", 4, 12312312, 30, "312013");
		Jugador juan = new Jugador("Juan", "Monteagudo", 5, 12312312, 30, "312013");

		bocaJuniors.agregarJugador(varela);
		bocaJuniors.agregarJugador(benedetto);
		bocaJuniors.agregarJugador(martinez);
		bocaJuniors.agregarJugador(palermo);
		bocaJuniors.agregarJugador(ortega);
		bocaJuniors.agregarJugador(riquelme);

		assertFalse(bocaJuniors.agregarJugador(juan));
	}

	@Test
	public void queNoSePuedanAgregarMasDe2CuerposTecnicos() {
		CuerpoTecnico gallardo = new CuerpoTecnico("Marcelo", "Gallardo", Rol.DT, 22, "30123123");
		CuerpoTecnico sampaoli = new CuerpoTecnico("pelado", "Sampaoli", Rol.ASISTENTE, 24, "30123123");
		CuerpoTecnico scaloni = new CuerpoTecnico("Marcelo", "Scaloneta", Rol.DT, 22, "30123123");

		bocaJuniors.agregarCuerpoTecnico(scaloni);
		bocaJuniors.agregarCuerpoTecnico(gallardo);

		assertFalse(bocaJuniors.agregarCuerpoTecnico(sampaoli));
	}

	@Test
	public void queSePuedaAgregarJugadoresAUnEquipoCorrectamente() {

		Integer JUGADORES_ESPERADOS = 2;
		Jugador riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		Jugador ortega = new Jugador("Burrito", "Ortega", 8, 12312312, 30, "312013");
		bocaJuniors.agregarJugador(riquelme);
		bocaJuniors.agregarJugador(ortega);

		assertTrue(bocaJuniors.agregarJugador(riquelme));
		assertEquals(bocaJuniors.getCantidadDeJugadores(), JUGADORES_ESPERADOS);
	}

	@Test
	public void queNoSePuedanAgregarDosJugadoresConElMismoDorsal() {
		Integer JUGADORES_ESPERADOS = 1;
		Jugador riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		Jugador ortega = new Jugador("Burrito", "Ortega", 10, 12312312, 30, "312013");
		bocaJuniors.agregarJugador(riquelme);
		bocaJuniors.agregarJugador(ortega);

		assertEquals(bocaJuniors.getCantidadDeJugadores(), JUGADORES_ESPERADOS);
	}

	@Test
	public void queSePuedaAgregarCuerpoTecnicoCorrectamente() {
		Integer CUERPO_TECNICO_ESPERADO = 1;

		CuerpoTecnico gallardo = new CuerpoTecnico("Marcelo", "Gallardo", Rol.DT, 22, "30123123");

		assertTrue(bocaJuniors.agregarCuerpoTecnico(gallardo));
		assertEquals(bocaJuniors.getCantidadDeCuerpoTecnico(), CUERPO_TECNICO_ESPERADO);
	}

	@Test
	public void queSePuedaBuscarUnJugadorPorDni() {
		String NOMBRE_DEL_JUGADOR_ESPERADO = "Roman";
		Jugador riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		bocaJuniors.agregarJugador(riquelme);

		assertEquals(bocaJuniors.buscarJugadorPorDni("40143300").getNombre(), NOMBRE_DEL_JUGADOR_ESPERADO);

	}

	@Test
	public void queSePuedaBuscarUnJugadorPorDorsal() {
		String NOMBRE_DEL_JUGADOR_ESPERADO = "Roman";
		Jugador riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		bocaJuniors.agregarJugador(riquelme);

		assertEquals(bocaJuniors.buscarJugadorPorNumero(10).getNombre(), NOMBRE_DEL_JUGADOR_ESPERADO);
	}

	@Test
	public void queSePuedaCalcularLaEdadPromedioDelEquipo() {
		Double EDAD_PROMEDIO_ESPERADA = 28.00;
		Jugador riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 26, "40143300");
		Jugador ortega = new Jugador("Burrito", "Ortega", 8, 12312312, 32, "312013");
		Jugador messi = new Jugador("Lionel", "Messi", 6, 12312312, 26, "312013");
		bocaJuniors.agregarJugador(ortega);
		bocaJuniors.agregarJugador(riquelme);
		bocaJuniors.agregarJugador(messi);

		assertEquals(EDAD_PROMEDIO_ESPERADA, bocaJuniors.calcularEdadPromedio(), 0.01);
	}

}
