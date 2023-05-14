package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JugadorTest {
	Jugador riquelme;
	
	 @Before
	    public void setUp() {
	         riquelme = new Jugador("juan roman","riquelme",10,1565854255,28,"33.453.444");
	    }
	    

	@Test
	public void queSepuedaRegistrarElJugador() {
		final String NOMBRE_ESPERADO = "juan roman";
		final String APELLIDO_ESPERADO = "riquelme";
		final Integer NUMERO_DORSAL_ESPERADO = 10;
		final Integer TELEFONO_ESPERADO = 1565854255;
		final Integer EDAD_ESPERADO = 28;
		final String DNI_ESPERADO = "33.453.444";
		
		assertEquals(NOMBRE_ESPERADO,riquelme.getNombre());
		assertEquals(APELLIDO_ESPERADO,riquelme.getApellido());
		assertEquals(NUMERO_DORSAL_ESPERADO,riquelme.getNumeroDorsal());
		assertEquals(TELEFONO_ESPERADO,riquelme.getNumeroTelefono());
		assertEquals(EDAD_ESPERADO,riquelme.getEdad());
		assertEquals(DNI_ESPERADO,riquelme.getDni());
		
	}
	

	
	

}
