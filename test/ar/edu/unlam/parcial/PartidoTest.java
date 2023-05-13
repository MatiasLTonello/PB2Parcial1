package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class PartidoTest {

	private Equipo bocaJuniors;
	private Equipo river;
	 @Before
	    public void setUp() {
	        bocaJuniors = new Equipo("Boca Juniors", "Xeneizes", "La Boca");
	        river = new Equipo("River", "Gallinas", "Nuniez");
	    }
	@Test
	public void queSePuedaGenerarElPartido() {
		
		 Equipo equipoLocalEsperado = new Equipo();
		 Equipo equipoVisitanteEsperado = new Equipo();
		 final Integer NUMERO_DE_PARTIDO_ESPERADO = 1;
	
		
		Partido partidoEsperado = new Partido (NUMERO_DE_PARTIDO_ESPERADO,equipoLocalEsperado,equipoVisitanteEsperado )	;	
		
		assertNotNull(partidoEsperado);
		
	}
	
	@Test
	public void poderObtenerLosDatosDelEquipoLocalCorrectamente() {
		String NOMBRE_ESPERADO = "Boca Juniors";
		Partido partidoEsperado = new Partido (1, bocaJuniors, river );		

		assertEquals(partidoEsperado.getEquipoLocal().getNombre(), NOMBRE_ESPERADO);
	}
	
	@Test
	public void poderObtenerLosDatosDelEquipoVisitanteCorrectamente() {
		String APODO_ESPERADO = "Gallinas";
		Partido partidoEsperado = new Partido (1, bocaJuniors, river );		

		assertEquals(partidoEsperado.getEquipoVisitante().getApodo(), APODO_ESPERADO);
	}
	
	
	
	
	
}

		