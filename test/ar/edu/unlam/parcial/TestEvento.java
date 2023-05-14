package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEvento {

	 
	Jugador riquelme;
	 Gol nuevoGol;
	 Jugador tevez;
	 Tarjeta nuevaTarjeta,nuevaTarjeta2;
	
	@Before
    public void setUp() {
         riquelme = new Jugador("juan roman","riquelme",10,1565854255,28,"33.453.444");
         nuevoGol = new Gol(45,riquelme,"boca juniors");
         tevez = new Jugador("juan roman","riquelme",9,1565784255,25,"33.453.544");
         nuevaTarjeta = new Tarjeta(35,tevez, TipoTarjeta.Amarilla);
         nuevaTarjeta2 = new Tarjeta(80,tevez, TipoTarjeta.Amarilla);
	}
	
	@Test
	public void queSeCreeElEventoGol() {
		final Integer MINUTO = 45;
		final Jugador JUGADOR_ESPERADO = riquelme;
		final String EQUIPO_ESPERADO = "boca juniors";
		Gol golEsperado = new Gol(MINUTO, JUGADOR_ESPERADO, EQUIPO_ESPERADO);
		
		
		assertEquals(nuevoGol,golEsperado);

	
	}
	

	
	
	
	
	

}
