package ar.edu.unlam.parcial;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class EquipoTest {
    private Equipo bocaJuniors;
	
    @Before
    public void setUp() {
        bocaJuniors = new Equipo("Boca Juniors", "Xeneizes", "Cochabamba");
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
		
		assertEquals(bocaJuniors.buscarJugadorPorDni("40143300").getNombre(), NOMBRE_DEL_JUGADOR_ESPERADO );
		
	}
	
	@Test
	public void queSePuedaBuscarUnJugadorPorDorsal() {
		String NOMBRE_DEL_JUGADOR_ESPERADO = "Roman";
		Jugador riquelme = new Jugador("Roman", "Riquelme", 10, 1123214221, 24, "40143300");
		bocaJuniors.agregarJugador(riquelme);
		
		assertEquals(bocaJuniors.buscarJugadorPorNumero(10).getNombre(), NOMBRE_DEL_JUGADOR_ESPERADO );
	}

}
