package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEvento {
	private Jugador riquelme;

	@Before
	public void setUp() {
		riquelme = new Jugador("juan roman", "riquelme", 10, 1565854255, 28, "33.453.444");

	}

	@Test
	public void queSeCreeElEventoGol() {

		final Integer MINUTO = 45;
		final Jugador JUGADOR_ESPERADO = riquelme;
		final String EQUIPO_ESPERADO = "boca juniors";
		Gol golEsperado = new Gol(MINUTO, JUGADOR_ESPERADO, EQUIPO_ESPERADO);

		assertNotNull(golEsperado);
	}
}
