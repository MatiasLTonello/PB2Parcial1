package ar.edu.unlam.parcial;

import java.util.HashSet;

public class Equipo {
    private String nombre;
    private String apodo;
    private String direccion;
    private HashSet<Jugador> jugadores;
    private HashSet<CuerpoTecnico> cuerpoTecnico;

    public Equipo(String nombre, String apodo, String direccion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.direccion = direccion;
        this.jugadores = new HashSet<>();
        this.cuerpoTecnico = new HashSet<>();
    }

    public Equipo() {
	}


	public String getNombre() {
        return nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public String getDireccion() {
        return direccion;
    }

    public HashSet<Jugador> getJugadores() {
        return jugadores;
    }
    
    public Jugador buscarJugadorPorNumero(Integer numero) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNumeroDorsal().equals(numero)) {
                return jugador;
            }
        }
        return null; 
    }
    
    public Jugador buscarJugadorPorDni(String dni) {
        for (Jugador jugador : jugadores) {
            if (jugador.getDni().equals(dni)) {
                return jugador;
            }
        }
        return null;
    }
    
    public Jugador buscarNombreDeEquipo(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null; 
    }


    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public Boolean agregarJugador(Jugador jugador) {
       if(this.jugadores.size() < 6 && jugador.getEdad() > 18) {
    	   this.jugadores.add(jugador);
    	   return true;
       }
       return false;
    }

    public Boolean agregarCuerpoTecnico(CuerpoTecnico cuerpoTecnico) {
       if(this.cuerpoTecnico.size() < 2) {
    	   this.cuerpoTecnico.add(cuerpoTecnico);
    	   return true;
       }
       return false;
    }

	public Integer getCantidadDeJugadores() {
		return this.jugadores.size();
	}

	public Integer getCantidadDeCuerpoTecnico() {
		return this.cuerpoTecnico.size();
	}

	public Double calcularEdadPromedio() {
	    Double edadPromedio = 0.0;
	    for (Jugador jugador : jugadores) {
	        edadPromedio += jugador.getEdad();
	    }
	    if (this.getCantidadDeJugadores() > 0) {
	        edadPromedio /= this.getCantidadDeJugadores();
	    }
	    return edadPromedio;
	}
}
